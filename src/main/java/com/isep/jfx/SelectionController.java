package com.isep.jfx;


import com.isep.rpg.Game;
import com.isep.rpg.hero.*;
import com.isep.rpg.hero.item.Weapon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SelectionController implements Initializable
{
    @FXML
    Label hero1Label,hero2Label,hero3Label,hero4Label;
    @FXML
    ImageView hero1ImageView, hero2ImageView,hero3ImageView,hero4ImageView;
    @FXML
    Button addWarriorButton, addHunterButton, addMageButton, addHealerButton;
    @FXML
    Button startFightButton;

    static Game game = new Game();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        hero1Label.setText("");
        hero2Label.setText("");
        hero3Label.setText("");
        hero4Label.setText("");
    }


    // Ajoute un héro dans l'équipe
    public void addHero(ActionEvent event)
    {
        if (game.party.size() < 4)
        {
            Button button = (Button) event.getSource();
            String chosenClass = button.getText();
            switch (chosenClass) {
                case "Hunter":
                    Hunter hunter = new Hunter();
                    game.party.add(hunter);
                    updatePartyView(chosenClass);
                    Weapon h  = new Weapon("Arc", 1500);
                    hunter.add(h);
                    break;
                case "Warrior":
                    Warrior warrior=new Warrior();
                    game.party.add(warrior);
                    updatePartyView(chosenClass);
                    Weapon w = new Weapon("Excaliburne", 2000);
                    warrior.add(w);
                    break;
                case "Mage":
                    MagePotter mage=new MagePotter();
                    game.party.add(mage);
                    updatePartyView(chosenClass);
                    Weapon m = new Weapon("Bout2bois", 3000);
                    mage.add(m);
                    break;
                case "Healer":
                    Healheure healer= new Healheure();
                    game.party.add(healer);
                    updatePartyView(chosenClass);
                    Weapon he  = new Weapon("Trousse2Secours", 3500);
                    healer.add(he);
                    break;
            }
        }
        else
        {
            errorPopup("Ton équipe est pleine!");
        }
    }

    // Commence le combat avec l'équipe sélectionnée

    @FXML
    public void onFightButtonClick() throws IOException {
        if(game.party.size() > 0)
        {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("game-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
            MainApplication.window.setScene(scene);
            MainApplication.window.show();
        }
        else
        {
            errorPopup("Pas sûr que partir en mission sans perso soit la meilleure idée que tu ai eu...");
        }
    }


    // Autres

    // Ajoute les images des héros sélectionnés sur la scene
    private void updatePartyView(String choosenClass)
    {
        Image image = new Image(getClass().getResourceAsStream("img/" + choosenClass + ".png"));
        switch(game.party.size())
        {
            case 1:
                hero1Label.setText(choosenClass);
                hero1ImageView.setImage(image);
                break;
            case 2:
                hero2Label.setText(choosenClass);
                hero2ImageView.setImage(image);
                break;
            case 3:
                hero3Label.setText(choosenClass);
                hero3ImageView.setImage(image);
                break;
            case 4:
                hero4Label.setText(choosenClass);
                hero4ImageView.setImage(image);
                break;
            default:
                break;
        }
    }

    // Affiche un message d'erreur
    private static void errorPopup(String message)
    {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Error");
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Ok");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }


}
