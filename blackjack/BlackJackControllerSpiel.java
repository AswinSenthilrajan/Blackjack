/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.house.of.gold.blackjack;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import com.mycompany.house.of.gold.*;
import javafx.scene.Node;

/**
 *
 * @author senth
 */
public class BlackJackControllerSpiel implements Initializable {

    private Label label;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button startButton;
    @FXML
    private Button exitButton_Start;
    @FXML
    private ImageView background_Start;
    @FXML
    private Rectangle rectangle;
    @FXML
    private Label balance1;
    @FXML
    private Label nameBenutzer;
    PassingClass pc;
    Spieler spieler;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        pc = PassingClass.getInstance();
        spieler = pc.getSpieler();
        nameBenutzer.setText(spieler.getName());
        String vermoegenSpieler2 = Integer.toString(spieler.getVermoegen());
        balance1.setText(vermoegenSpieler2);

        background_Start.setImage(new Image("/img/blackjack/Casino_BlackJack_Starbild.jpg"));
    }

    @FXML
    private void startGame(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/blackjack/Black_Jack.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Black Jack");
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    private void exitStart(ActionEvent event) throws IOException {

        Stage stage = new Stage();

        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/casino/MainPageView.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

}
