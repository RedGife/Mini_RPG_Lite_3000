package com.isep.jfx;

import com.isep.rpg.Game;
import com.isep.rpg.enemy.Enemy;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class GameController implements Initializable
{
    @FXML
    Label battleLogLabel;
    @FXML
    Label currentHeroLabel, currentHeroHPLabel, currentHeroResourcesLabel;
    @FXML
    ImageView hero1ImageView, hero2ImageView,hero3ImageView,hero4ImageView;
    @FXML
    ImageView bossImageView, basic1ImageView, basic2ImageView, basic3ImageView;

    @FXML
    ListView<String> enemyList;

    Game game = SelectionController.game;

    int currentHeroInList = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Init game");

        setImages();
        setCurrentHeroInfo(0);

        game.generateEnemies();
        setEnemyList();
    }

    public void setEnemyList()
    {
        String[] toEnemyList = new String[game.enemyList.size()];
        for (int e = 0; e < game.enemyList.size(); e++) { toEnemyList[e] = game.enemyList.get(e).getType(); }
        enemyList.getItems().clear();
        enemyList.getItems().addAll(toEnemyList);
        enemyList.getSelectionModel().select(0);
    }

    public void setImages()
    {
        // Met en place les images des héros
        if(game.party.size() >= 1) { hero1ImageView.setImage( new Image(getClass().getResourceAsStream("img/" + game.party.get(0).getType() + ".png")) ); }
        if(game.party.size() >= 2) { hero2ImageView.setImage( new Image(getClass().getResourceAsStream("img/" + game.party.get(1).getType() + ".png")) ); }
        if(game.party.size() >= 3) { hero3ImageView.setImage( new Image(getClass().getResourceAsStream("img/" + game.party.get(2).getType() + ".png")) ); }
        if(game.party.size() == 4) { hero4ImageView.setImage( new Image(getClass().getResourceAsStream("img/" + game.party.get(3).getType() + ".png")) ); }

        // Met en place les images des ennemis
        bossImageView.setImage( new Image(getClass().getResourceAsStream("img/Boss.png")) ); // Gilgamesh !
        Image basicImage = new Image(getClass().getResourceAsStream("img/Basic_Enemy.png"));
        if(game.party.size() >= 2) { basic1ImageView.setImage( basicImage ); }
        if(game.party.size() >= 3) { basic2ImageView.setImage( basicImage ); }
        if(game.party.size() >= 4) { basic3ImageView.setImage( basicImage ); }
    }

    public void setCurrentHeroInfo (int currentHeroInList)
    {
        String heroClass = game.party.get(currentHeroInList).getType();
        currentHeroLabel.setText(heroClass);
        currentHeroHPLabel.setText("Pts de Vie: " + game.party.get(currentHeroInList).getHp());

        switch(heroClass){
            case ("Warrior"):
                currentHeroResourcesLabel.setText("");
                break;
            case ("Hunter"):
                currentHeroResourcesLabel.setText("Flèche : " + game.party.get(currentHeroInList).getFleches());
                break;
            case ("Mage"):
            case ("Healer"):
                currentHeroResourcesLabel.setText("Points de Mana : " + game.party.get(currentHeroInList).getManaPoints() );
                break;
        }
    }



    public void onButtonClick() throws InterruptedException
    {
        this.currentHeroInList = (this.currentHeroInList + 1) % 4;
        setCurrentHeroInfo(currentHeroInList);

        // Tours ennemis
        // Si le dernier héro a fait une action
        if (currentHeroInList == 0) {
            for (Enemy e : game.enemyList)
            {
                if(game.party.size() <= 0)
                {
                    alertPopup("Game Over", "T'es nul frérot! =(.");
                }
                else
                {
                    Random random = new Random();
                    int selection = random.nextInt(game.party.size());
                    e.attack(game.party.get(selection));
                    battleLogLabel.setText(e.getType() + " à infligé " + e.getDegatsGlobaux() + " à " + game.party.get(selection).getType());

                    if (!game.party.get(selection).isAlive()) {
                        game.party.remove(selection);
                    }
                }
            }
        }



    }

    @FXML
    public void onAttackButtonClick() throws InterruptedException {
        int selection = enemyList.getSelectionModel().getSelectedIndex();
        game.party.get(currentHeroInList).attack(game.enemyList.get(selection));

        String battleLog = currentHeroLabel.getText() + " a infligé " + game.party.get(currentHeroInList).getDegatsGlobaux() + " pts de dégats !";
        if(!game.enemyList.get(selection).isAlive())
        {
            battleLog = battleLog + " Vous avez vaincu un ennemie.";
            game.enemyList.remove(selection);
            setEnemyList();
        }
        battleLogLabel.setText(battleLog);

        if(game.enemyList.size() <= 0)
        {
            alertPopup("Victoire !", "T'es pas mauvais...");
        }

        onButtonClick();
    }

    public void onDefendButtonClick() throws InterruptedException {
        game.party.get(currentHeroInList).defend();
        battleLogLabel.setText(currentHeroLabel + ("se défend"));

        onButtonClick();
    }

    public void onConsumablesButtonClick() throws InterruptedException {
        battleLogLabel.setText("Rien ne se passe...");

        onButtonClick();
    }

    private static void alertPopup(String title, String message)
    {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Ok");
        closeButton.setOnAction(e -> {
            window.close();
            MainApplication.window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

}
