package com.isep.jfx;

import com.isep.rpg.Game;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable
{
    private String githubLink = "https://github.com/RedGife/.......";

    @FXML
    Label githubLinkLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        githubLinkLabel.setText(githubLink);
    }

    @FXML
    protected void onPlayButtonClick() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("hero-selection-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        MainApplication.window.setScene(scene);
        MainApplication.window.show();
    }


}
