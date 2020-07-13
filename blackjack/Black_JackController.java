package com.mycompany.house.of.gold.blackjack;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import com.mycompany.house.of.gold.*;
import javafx.scene.Node;

/**
 * FXML Controller class
 *
 * @author senth
 */
public class Black_JackController implements Initializable {

    PassingClass pc;
    Spieler spieler;
    @FXML
    private Button exit_Blackjack;
    @FXML
    private ImageView handKarte1;
    @FXML
    private Button hitButton;
    @FXML
    private Button standButton;
    @FXML
    private TextField einsatz;
    @FXML
    private Button einsatzBestaetigenButton;
    @FXML
    private Label balance;
    @FXML
    private ImageView handKarte2;
    @FXML
    private ImageView handKarte3;
    @FXML
    private ImageView handKarte4;

    /**
     * Initializes the controller class.
     */
    //Deklartion -------------------------------------------------------------------------------------
    ArrayList<Image> cards = new ArrayList<>();

    Boolean restartPressed = false;
    Boolean oneTime = false;

    private Image twoC = new Image("/img/blackjack/2C.png");
    private Image twoD = new Image("/img/blackjack/2D.png");
    private Image twoH = new Image("/img/blackjack/2H.png");
    private Image twoS = new Image("/img/blackjack/2S.png");
    private Image threeC = new Image("/img/blackjack/3C.png");
    private Image threeD = new Image("/img/blackjack/3D.png");
    private Image threeH = new Image("/img/blackjack/3H.png");
    private Image threeS = new Image("/img/blackjack/3S.png");
    private Image fourC = new Image("/img/blackjack/4C.png");
    private Image fourD = new Image("/img/blackjack/4D.png");
    private Image fourH = new Image("/img/blackjack/4H.png");
    private Image fourS = new Image("/img/blackjack/4S.png");
    private Image fiveC = new Image("/img/blackjack/5C.png");
    private Image fiveD = new Image("/img/blackjack/5D.png");
    private Image fiveH = new Image("/img/blackjack/5H.png");
    private Image fiveS = new Image("/img/blackjack/5S.png");
    private Image sixC = new Image("/img/blackjack/6C.png");
    private Image sixD = new Image("/img/blackjack/6D.png");
    private Image sixH = new Image("/img/blackjack/6H.png");
    private Image sixS = new Image("/img/blackjack/6S.png");
    private Image sevenC = new Image("/img/blackjack/7C.png");
    private Image sevenD = new Image("/img/blackjack/7D.png");
    private Image sevenH = new Image("/img/blackjack/7H.png");
    private Image sevenS = new Image("/img/blackjack/7S.png");
    private Image eightC = new Image("/img/blackjack/8C.png");
    private Image eightD = new Image("/img/blackjack/8D.png");
    private Image eightH = new Image("/img/blackjack/8H.png");
    private Image eightS = new Image("/img/blackjack/8S.png");
    private Image nineC = new Image("/img/blackjack/9C.png");
    private Image nineD = new Image("/img/blackjack/9D.png");
    private Image nineH = new Image("/img/blackjack/9H.png");
    private Image nineS = new Image("/img/blackjack/9S.png");
    private Image tenC = new Image("/img/blackjack/10C.png");
    private Image tenD = new Image("/img/blackjack/10D.png");
    private Image tenH = new Image("/img/blackjack/10H.png");
    private Image tenS = new Image("/img/blackjack/10S.png");
    private Image jackC = new Image("/img/blackjack/JC.png");
    private Image jackD = new Image("/img/blackjack/JD.png");
    private Image jackH = new Image("/img/blackjack/JH.png");
    private Image jackS = new Image("/img/blackjack/JS.png");
    private Image kingC = new Image("/img/blackjack/KC.png");
    private Image kingD = new Image("/img/blackjack/KD.png");
    private Image kingH = new Image("/img/blackjack/KH.png");
    private Image kingS = new Image("/img/blackjack/KS.png");
    private Image queenC = new Image("/img/blackjack/QC.png");
    private Image queenD = new Image("/img/blackjack/QD.png");
    private Image queenH = new Image("/img/blackjack/QH.png");
    private Image queenS = new Image("/img/blackjack/QS.png");
    private Image aceC = new Image("/img/blackjack/AC.png");
    private Image aceD = new Image("/img/blackjack/AD.png");
    private Image aceH = new Image("/img/blackjack/AH.png");
    private Image aceS = new Image("/img/blackjack/AS.png");
    //private Image handKarte2Save;

    int kontostand;
    String kontoString;

    int einsatzInt; //In einsatzBestaetigen Methode

    int playerCardValue = 0;

    int croupierCardValue = 0;

    int insurance;

    //Deklaration ------------------------------------------------------------------------------------
    @FXML
    private ImageView karte1;
    @FXML
    private ImageView karte2;
    @FXML
    private ImageView karte3;
    @FXML
    private ImageView karte4;
    @FXML
    private Button insureButton;
    @FXML
    private ImageView karte5;
    @FXML
    private ImageView karte6;
    @FXML
    private Button doubleButton;
    @FXML
    private Button insuranceSubmit;
    @FXML
    private TextField insuranceInput;
    @FXML
    private Label einsatzAnzeige;
    @FXML
    private Label insuranceAnzeige;
    @FXML
    private ImageView handKarte5;
    @FXML
    private ImageView handKarte6;
    @FXML
    private ImageView handKarte7;
    @FXML
    private ImageView karte7;
    @FXML
    private Label croupierValue;
    @FXML
    private Label playerValue;
    @FXML
    private Button restartButton;
    @FXML
    private ImageView backgroundSpiel;
    @FXML
    private Label winOrLose;

    private void kartenHinzufuegen() {

        cards.add(twoC);
        cards.add(twoD);
        cards.add(twoH);
        cards.add(twoS);
        cards.add(threeC);
        cards.add(threeD);
        cards.add(threeH);
        cards.add(threeS);
        cards.add(fourC);
        cards.add(fourD);
        cards.add(fourH);
        cards.add(fourS);
        cards.add(fiveC);
        cards.add(fiveD);
        cards.add(fiveH);
        cards.add(fiveS);
        cards.add(sixC);
        cards.add(sixD);
        cards.add(sixH);
        cards.add(sixS);
        cards.add(sevenC);
        cards.add(sevenD);
        cards.add(sevenH);
        cards.add(sevenS);
        cards.add(eightC);
        cards.add(eightD);
        cards.add(eightH);
        cards.add(eightS);
        cards.add(nineC);
        cards.add(nineD);
        cards.add(nineH);
        cards.add(nineS);
        cards.add(tenC);
        cards.add(tenD);
        cards.add(tenH);
        cards.add(tenS);
        cards.add(jackC);
        cards.add(jackD);
        cards.add(jackS);
        cards.add(jackS);
        cards.add(kingC);
        cards.add(kingD);
        cards.add(kingH);
        cards.add(kingS);
        cards.add(queenC);
        cards.add(queenD);
        cards.add(queenH);
        cards.add(queenS);
        cards.add(aceC);
        cards.add(aceD);
        cards.add(aceH);
        cards.add(aceS);
    }
    Spiel spiel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        spiel = new Spiel("blackjack");
        pc = PassingClass.getInstance();
        spieler = pc.getSpieler();
        kontostand = spieler.getVermoegen();
        kontoString = Integer.toString(kontostand);
        balance.setText(kontoString);
        kartenHinzufuegen();
        kontostand = spieler.getVermoegen();

        balance.setText(kontoString);
        insuranceInput.setDisable(true);
        insuranceSubmit.setDisable(true);
        backgroundSpiel.setImage(new Image("/img/blackjack/BlackJack_Game_background.jpg"));
    }

    @FXML
    private void exit_Game(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/blackjack/BlackJackView.fxml"));
        Stage s = new Stage();
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void hit(ActionEvent event) throws InterruptedException {
        if (playerCardValue < 21 && croupierCardValue < 21) {
            Random randomHitKarte3 = new Random();
            int rHitKarte3 = randomHitKarte3.nextInt(cards.size() + 1);

            if (karte2.getImage() != null && karte3.getImage() == null) {
                karte3.setImage(cards.get(rHitKarte3));
                cards.remove(rHitKarte3);
                if (karte3.getImage() == twoC || karte3.getImage() == twoD || karte3.getImage() == twoH || karte3.getImage() == twoS) {
                    playerCardValue = playerCardValue + 2;
                } else if (karte3.getImage() == threeC || karte3.getImage() == threeD || karte3.getImage() == threeH || karte3.getImage() == threeS) {
                    playerCardValue = playerCardValue + 3;
                } else if (karte3.getImage() == fourC || karte3.getImage() == fourD || karte3.getImage() == fourH || karte3.getImage() == fourS) {
                    playerCardValue = playerCardValue + 4;
                } else if (karte3.getImage() == fiveC || karte3.getImage() == fiveD || karte3.getImage() == fiveH || karte3.getImage() == fiveS) {
                    playerCardValue = playerCardValue + 5;
                } else if (karte3.getImage() == sixC || karte3.getImage() == sixD || karte3.getImage() == sixH || karte3.getImage() == sixS) {
                    playerCardValue = playerCardValue + 6;
                } else if (karte3.getImage() == sevenC || karte3.getImage() == sevenD || karte3.getImage() == sevenH || karte3.getImage() == sevenS) {
                    playerCardValue = playerCardValue + 7;
                } else if (karte3.getImage() == eightC || karte3.getImage() == eightD || karte3.getImage() == eightH || karte3.getImage() == eightS) {
                    playerCardValue = playerCardValue + 8;
                } else if (karte3.getImage() == nineC || karte3.getImage() == nineD || karte3.getImage() == nineH || karte3.getImage() == nineS) {
                    playerCardValue = playerCardValue + 9;
                } else if (karte3.getImage() == jackC || karte3.getImage() == jackD || karte3.getImage() == jackH || karte3.getImage() == jackS) {
                    playerCardValue = playerCardValue + 10;
                } else if (karte3.getImage() == kingC || karte3.getImage() == kingD || karte3.getImage() == kingH || karte3.getImage() == kingS) {
                    playerCardValue = playerCardValue + 10;
                } else if (karte3.getImage() == tenC || karte3.getImage() == tenD || karte3.getImage() == tenH || karte3.getImage() == tenS) {
                    playerCardValue = playerCardValue + 10;
                } else if (karte3.getImage() == queenC || karte3.getImage() == queenD || karte3.getImage() == queenH || karte3.getImage() == queenS) {
                    playerCardValue = playerCardValue + 10;
                } else if (karte3.getImage() == aceC && playerCardValue > 10 || karte3.getImage() == aceD && playerCardValue > 10 || karte3.getImage() == aceH && playerCardValue > 10 || karte2.getImage() == aceS && playerCardValue > 10) {
                    playerCardValue = playerCardValue + 1;
                } else if (karte3.getImage() == aceC && playerCardValue <= 10 || karte3.getImage() == aceD && playerCardValue <= 10 || karte3.getImage() == aceH && playerCardValue <= 10 || karte3.getImage() == aceS && playerCardValue <= 10) {
                    playerCardValue = playerCardValue + 11;
                }

            } else if (karte3.getImage() != null && karte4.getImage() == null) {
                Random randomHitKarte4 = new Random();
                int rHitKarte4 = randomHitKarte4.nextInt(cards.size());
                karte4.setImage(cards.get(rHitKarte4));
                cards.remove(rHitKarte4);
                if (karte4.getImage() == twoC || karte2.getImage() == twoD || karte4.getImage() == twoH || karte4.getImage() == twoS) {
                    playerCardValue = playerCardValue + 2;
                } else if (karte4.getImage() == threeC || karte4.getImage() == threeD || karte4.getImage() == threeH || karte4.getImage() == threeS) {
                    playerCardValue = playerCardValue + 3;
                } else if (karte4.getImage() == fourC || karte4.getImage() == fourD || karte4.getImage() == fourH || karte4.getImage() == fourS) {
                    playerCardValue = playerCardValue + 4;
                } else if (karte4.getImage() == fiveC || karte4.getImage() == fiveD || karte4.getImage() == fiveH || karte2.getImage() == fiveS) {
                    playerCardValue = playerCardValue + 5;
                } else if (karte4.getImage() == sixC || karte4.getImage() == sixD || karte4.getImage() == sixH || karte4.getImage() == sixS) {
                    playerCardValue = playerCardValue + 6;
                } else if (karte4.getImage() == sevenC || karte4.getImage() == sevenD || karte4.getImage() == sevenH || karte4.getImage() == sevenS) {
                    playerCardValue = playerCardValue + 7;
                } else if (karte4.getImage() == eightC || karte4.getImage() == eightD || karte4.getImage() == eightH || karte4.getImage() == eightS) {
                    playerCardValue = playerCardValue + 8;
                } else if (karte4.getImage() == nineC || karte4.getImage() == nineD || karte4.getImage() == nineH || karte4.getImage() == nineS) {
                    playerCardValue = playerCardValue + 9;
                } else if (karte4.getImage() == jackC || karte4.getImage() == jackD || karte4.getImage() == jackH || karte4.getImage() == jackS) {
                    playerCardValue = playerCardValue + 10;
                } else if (karte4.getImage() == kingC || karte4.getImage() == kingD || karte4.getImage() == kingH || karte4.getImage() == kingS) {
                    playerCardValue = playerCardValue + 10;
                } else if (karte4.getImage() == tenC || karte4.getImage() == tenD || karte4.getImage() == tenH || karte4.getImage() == tenS) {
                    playerCardValue = playerCardValue + 10;
                } else if (karte4.getImage() == queenC || karte4.getImage() == queenD || karte4.getImage() == queenH || karte4.getImage() == queenS) {
                    playerCardValue = playerCardValue + 10;
                } else if (karte4.getImage() == aceC && playerCardValue > 10 || karte4.getImage() == aceD && playerCardValue > 10 || karte4.getImage() == aceH && playerCardValue > 10 || karte4.getImage() == aceS && playerCardValue > 10) {
                    playerCardValue = playerCardValue + 1;
                } else if (karte4.getImage() == aceC && playerCardValue <= 10 || karte4.getImage() == aceD && playerCardValue <= 10 || karte4.getImage() == aceH && playerCardValue <= 10 || karte4.getImage() == aceS && playerCardValue <= 10) {
                    playerCardValue = playerCardValue + 11;
                }
                playerValue.setText(Integer.toString(playerCardValue));

            } else if (karte4.getImage() != null && karte5.getImage() == null) {
                Random randomHitKarte5 = new Random();
                int rHitKarte5 = randomHitKarte5.nextInt(cards.size() + 1);
                karte5.setImage(cards.get(rHitKarte5));
                cards.remove(rHitKarte5);
                if (karte5.getImage() == twoC || karte5.getImage() == twoD || karte5.getImage() == twoH || karte5.getImage() == twoS) {
                    playerCardValue = playerCardValue + 2;
                } else if (karte5.getImage() == threeC || karte5.getImage() == threeD || karte5.getImage() == threeH || karte5.getImage() == threeS) {
                    playerCardValue = playerCardValue + 3;
                } else if (karte5.getImage() == fourC || karte5.getImage() == fourD || karte5.getImage() == fourH || karte5.getImage() == fourS) {
                    playerCardValue = playerCardValue + 4;
                } else if (karte5.getImage() == fiveC || karte5.getImage() == fiveD || karte5.getImage() == fiveH || karte5.getImage() == fiveS) {
                    playerCardValue = playerCardValue + 5;
                } else if (karte5.getImage() == sixC || karte5.getImage() == sixD || karte5.getImage() == sixH || karte5.getImage() == sixS) {
                    playerCardValue = playerCardValue + 6;
                } else if (karte5.getImage() == sevenC || karte5.getImage() == sevenD || karte5.getImage() == sevenH || karte5.getImage() == sevenS) {
                    playerCardValue = playerCardValue + 7;
                } else if (karte5.getImage() == eightC || karte5.getImage() == eightD || karte5.getImage() == eightH || karte5.getImage() == eightS) {
                    playerCardValue = playerCardValue + 8;
                } else if (karte5.getImage() == nineC || karte5.getImage() == nineD || karte5.getImage() == nineH || karte5.getImage() == nineS) {
                    playerCardValue = playerCardValue + 9;
                } else if (karte5.getImage() == jackC || karte5.getImage() == jackD || karte5.getImage() == jackH || karte5.getImage() == jackS) {
                    playerCardValue = playerCardValue + 10;
                } else if (karte5.getImage() == kingC || karte5.getImage() == kingD || karte5.getImage() == kingH || karte5.getImage() == kingS) {
                    playerCardValue = playerCardValue + 10;
                } else if (karte5.getImage() == tenC || karte5.getImage() == tenD || karte5.getImage() == tenH || karte5.getImage() == tenS) {
                    playerCardValue = playerCardValue + 10;
                } else if (karte5.getImage() == queenC || karte5.getImage() == queenD || karte5.getImage() == queenH || karte5.getImage() == queenS) {
                    playerCardValue = playerCardValue + 10;
                } else if (karte5.getImage() == aceC && playerCardValue > 10 || karte5.getImage() == aceD && playerCardValue > 10 || karte5.getImage() == aceH && playerCardValue > 10 || karte5.getImage() == aceS && playerCardValue > 10) {
                    playerCardValue = playerCardValue + 1;
                } else if (karte5.getImage() == aceC && playerCardValue <= 10 || karte5.getImage() == aceD && playerCardValue <= 10 || karte5.getImage() == aceH && playerCardValue <= 10 || karte5.getImage() == aceS && playerCardValue <= 10) {
                    playerCardValue = playerCardValue + 11;
                }
                playerValue.setText(Integer.toString(playerCardValue));
            } else if (karte5.getImage() != null && karte6.getImage() == null) {
                Random randomHitKarte6 = new Random();
                int rHitKarte6 = randomHitKarte6.nextInt(cards.size() + 1);
                karte6.setImage(cards.get(rHitKarte6));
                cards.remove(rHitKarte6);
                if (karte6.getImage() == twoC || karte6.getImage() == twoD || karte6.getImage() == twoH || karte6.getImage() == twoS) {
                    playerCardValue = playerCardValue + 2;
                } else if (karte6.getImage() == threeC || karte6.getImage() == threeD || karte6.getImage() == threeH || karte6.getImage() == threeS) {
                    playerCardValue = playerCardValue + 3;
                } else if (karte6.getImage() == fourC || karte6.getImage() == fourD || karte6.getImage() == fourH || karte6.getImage() == fourS) {
                    playerCardValue = playerCardValue + 4;
                } else if (karte6.getImage() == fiveC || karte6.getImage() == fiveD || karte6.getImage() == fiveH || karte6.getImage() == fiveS) {
                    playerCardValue = playerCardValue + 5;
                } else if (karte6.getImage() == sixC || karte6.getImage() == sixD || karte6.getImage() == sixH || karte6.getImage() == sixS) {
                    playerCardValue = playerCardValue + 6;
                } else if (karte6.getImage() == sevenC || karte6.getImage() == sevenD || karte6.getImage() == sevenH || karte6.getImage() == sevenS) {
                    playerCardValue = playerCardValue + 7;
                } else if (karte6.getImage() == eightC || karte6.getImage() == eightD || karte6.getImage() == eightH || karte6.getImage() == eightS) {
                    playerCardValue = playerCardValue + 8;
                } else if (karte6.getImage() == nineC || karte6.getImage() == nineD || karte6.getImage() == nineH || karte6.getImage() == nineS) {
                    playerCardValue = playerCardValue + 9;
                } else if (karte6.getImage() == jackC || karte6.getImage() == jackD || karte6.getImage() == jackH || karte6.getImage() == jackS) {
                    playerCardValue = playerCardValue + 10;
                } else if (karte6.getImage() == kingC || karte6.getImage() == kingD || karte6.getImage() == kingH || karte6.getImage() == kingS) {
                    playerCardValue = playerCardValue + 10;
                } else if (karte6.getImage() == tenC || karte6.getImage() == tenD || karte6.getImage() == tenH || karte6.getImage() == tenS) {
                    playerCardValue = playerCardValue + 10;
                } else if (karte6.getImage() == queenC || karte6.getImage() == queenD || karte6.getImage() == queenH || karte6.getImage() == queenS) {
                    playerCardValue = playerCardValue + 10;
                } else if (karte6.getImage() == aceC && playerCardValue > 10 || karte6.getImage() == aceD && playerCardValue > 10 || karte6.getImage() == aceH && playerCardValue > 10 || karte6.getImage() == aceS && playerCardValue > 10) {
                    playerCardValue = playerCardValue + 1;
                } else if (karte6.getImage() == aceC && playerCardValue <= 10 || karte6.getImage() == aceD && playerCardValue <= 10 || karte6.getImage() == aceH && playerCardValue <= 10 || karte6.getImage() == aceS && playerCardValue <= 10) {
                    playerCardValue = playerCardValue + 11;
                }
                playerValue.setText(Integer.toString(playerCardValue));

            } else if (karte6.getImage() != null && karte7.getImage() == null) {
                Random randomHitKarte7 = new Random();
                int rHitKarte7 = randomHitKarte7.nextInt(cards.size() + 1);
                karte7.setImage(cards.get(rHitKarte7));
                cards.remove(rHitKarte7);
                if (karte7.getImage() == twoC || karte7.getImage() == twoD || karte7.getImage() == twoH || karte7.getImage() == twoS) {
                    playerCardValue = playerCardValue + 2;
                } else if (karte7.getImage() == threeC || karte7.getImage() == threeD || karte7.getImage() == threeH || karte7.getImage() == threeS) {
                    playerCardValue = playerCardValue + 3;
                } else if (karte7.getImage() == fourC || karte7.getImage() == fourD || karte7.getImage() == fourH || karte7.getImage() == fourS) {
                    playerCardValue = playerCardValue + 4;
                } else if (karte7.getImage() == fiveC || karte7.getImage() == fiveD || karte7.getImage() == fiveH || karte7.getImage() == fiveS) {
                    playerCardValue = playerCardValue + 5;
                } else if (karte7.getImage() == sixC || karte7.getImage() == sixD || karte7.getImage() == sixH || karte7.getImage() == sixS) {
                    playerCardValue = playerCardValue + 6;
                } else if (karte7.getImage() == sevenC || karte7.getImage() == sevenD || karte7.getImage() == sevenH || karte7.getImage() == sevenS) {
                    playerCardValue = playerCardValue + 7;
                } else if (karte7.getImage() == eightC || karte7.getImage() == eightD || karte7.getImage() == eightH || karte7.getImage() == eightS) {
                    playerCardValue = playerCardValue + 8;
                } else if (karte7.getImage() == nineC || karte7.getImage() == nineD || karte7.getImage() == nineH || karte7.getImage() == nineS) {
                    playerCardValue = playerCardValue + 9;
                } else if (karte7.getImage() == jackC || karte7.getImage() == jackD || karte7.getImage() == jackH || karte7.getImage() == jackS) {
                    playerCardValue = playerCardValue + 10;
                } else if (karte7.getImage() == kingC || karte7.getImage() == kingD || karte7.getImage() == kingH || karte7.getImage() == kingS) {
                    playerCardValue = playerCardValue + 10;
                } else if (karte7.getImage() == tenC || karte7.getImage() == tenD || karte7.getImage() == tenH || karte7.getImage() == tenS) {
                    playerCardValue = playerCardValue + 10;
                } else if (karte7.getImage() == queenC || karte7.getImage() == queenD || karte7.getImage() == queenH || karte7.getImage() == queenS) {
                    playerCardValue = playerCardValue + 10;
                } else if (karte7.getImage() == aceC && playerCardValue > 10 || karte7.getImage() == aceD && playerCardValue > 10 || karte7.getImage() == aceH && playerCardValue > 10 || karte7.getImage() == aceS && playerCardValue > 10) {
                    playerCardValue = playerCardValue + 1;
                } else if (karte7.getImage() == aceC && playerCardValue <= 10 || karte7.getImage() == aceD && playerCardValue <= 10 || karte7.getImage() == aceH && playerCardValue <= 10 || karte7.getImage() == aceS && playerCardValue <= 10) {
                    playerCardValue = playerCardValue + 11;
                }
                playerValue.setText(Integer.toString(playerCardValue));
            }
            //Ace 1 or 11 ------------------
            if (playerCardValue > 21 && playerCardValue <= 31 && oneTime == false) {
                if (karte1.getImage() == aceC || karte1.getImage() == aceD || karte1.getImage() == aceH || karte1.getImage() == aceS || karte2.getImage() == aceC || karte2.getImage() == aceD || karte2.getImage() == aceH || karte2.getImage() == aceS || karte3.getImage() == aceC || karte3.getImage() == aceD || karte3.getImage() == aceH || karte3.getImage() == aceS || karte4.getImage() == aceC || karte4.getImage() == aceD || karte4.getImage() == aceH || karte4.getImage() == aceS || karte5.getImage() == aceC || karte5.getImage() == aceD || karte5.getImage() == aceH || karte5.getImage() == aceS || karte6.getImage() == aceC || karte6.getImage() == aceD || karte6.getImage() == aceH || karte6.getImage() == aceS || karte7.getImage() == aceC || karte7.getImage() == aceD || karte7.getImage() == aceH || karte7.getImage() == aceS) {
                    playerCardValue = playerCardValue - 10;
                    playerValue.setText(Integer.toString(playerCardValue));
                    oneTime = true;
                }
            }
            //Ace 1 or 11 ------------------

            if (playerCardValue > 21) {
                hitButton.setDisable(true);
                winOrLose.setText("You Lose");
            } else if (playerCardValue == 21 && croupierCardValue != 21) {
                winOrLose.setText("You win");
                double einsatzDoubleBlackjack = einsatzInt * 2.5;
                int einsatzIntBlackjack = (int) einsatzDoubleBlackjack;
                kontostand = kontostand + einsatzIntBlackjack;
                spiel.setEinsatz("blackjack", 0, einsatzIntBlackjack);
                balance.setText(Integer.toString(kontostand));
                hitButton.setDisable(true);
            }
        }
        playerValue.setText(Integer.toString(playerCardValue));
    }

    

    @FXML
    private void stand(ActionEvent event) {
        standFunction();
    }

    private void standFunction() {
        if (croupierCardValue <= 21) {
            secondCard();
            if (handKarte2.getImage() == twoC || handKarte2.getImage() == twoD || handKarte2.getImage() == twoH || handKarte2.getImage() == twoS) {
                croupierCardValue = croupierCardValue + 2;
            } else if (handKarte2.getImage() == threeC || handKarte2.getImage() == threeD || handKarte2.getImage() == threeH || handKarte2.getImage() == threeS) {
                croupierCardValue = croupierCardValue + 3;
            } else if (handKarte2.getImage() == fourC || handKarte2.getImage() == fourD || handKarte2.getImage() == fourH || handKarte2.getImage() == fourS) {
                croupierCardValue = croupierCardValue + 4;
            } else if (handKarte2.getImage() == fiveC || handKarte2.getImage() == fiveD || handKarte2.getImage() == fiveH || handKarte2.getImage() == fiveS) {
                croupierCardValue = croupierCardValue + 5;
            } else if (handKarte2.getImage() == sixS || handKarte2.getImage() == sixD || handKarte2.getImage() == sixH || handKarte2.getImage() == sixS) {
                croupierCardValue = croupierCardValue + 6;
            } else if (handKarte2.getImage() == sevenC || handKarte2.getImage() == sevenD || handKarte2.getImage() == sevenH || handKarte2.getImage() == sevenS) {
                croupierCardValue = croupierCardValue + 7;
            } else if (handKarte2.getImage() == eightC || handKarte2.getImage() == eightD || handKarte2.getImage() == eightH || handKarte2.getImage() == eightS) {
                croupierCardValue = croupierCardValue + 8;
            } else if (handKarte2.getImage() == nineC || handKarte2.getImage() == nineD || handKarte2.getImage() == nineH || handKarte2.getImage() == nineS) {
                croupierCardValue = croupierCardValue + 9;
            } else if (handKarte2.getImage() == jackC || handKarte2.getImage() == jackD || handKarte2.getImage() == jackH || handKarte2.getImage() == jackS) {
                croupierCardValue = croupierCardValue + 10;
            } else if (handKarte2.getImage() == kingC || handKarte2.getImage() == kingD || handKarte2.getImage() == kingH || handKarte2.getImage() == kingS) {
                croupierCardValue = croupierCardValue + 10;
            } else if (handKarte2.getImage() == tenC || handKarte2.getImage() == tenD || handKarte2.getImage() == tenH || handKarte2.getImage() == tenS) {
                croupierCardValue = croupierCardValue + 10;
            } else if (handKarte2.getImage() == aceC && croupierCardValue <= 10 || handKarte2.getImage() == aceD && croupierCardValue <= 10 || handKarte2.getImage() == aceH && croupierCardValue <= 10 || handKarte2.getImage() == aceS && croupierCardValue <= 10) {
                croupierCardValue = croupierCardValue + 11;
            } else if (handKarte2.getImage() == aceC && croupierCardValue > 10 || handKarte2.getImage() == aceD && croupierCardValue > 10 || handKarte2.getImage() == aceH && croupierCardValue > 10 || handKarte2.getImage() == aceS && croupierCardValue > 10) {
                croupierCardValue = croupierCardValue + 1;
            }
            croupierValue.setText(Integer.toString(croupierCardValue));

            while (croupierCardValue < 17 && croupierCardValue < 21) {
                if (handKarte2.getImage() != null && handKarte3.getImage() == null) {
                    Random randomStand3 = new Random();
                    int rStandHandKarte3 = randomStand3.nextInt(cards.size() + 1);

                    handKarte3.setImage(cards.get(rStandHandKarte3));
                    cards.remove(rStandHandKarte3);
                    if (handKarte3.getImage() == twoC || handKarte3.getImage() == twoD || handKarte3.getImage() == twoH || handKarte3.getImage() == twoS) {
                        croupierCardValue = croupierCardValue + 2;
                    } else if (handKarte3.getImage() == threeC || handKarte3.getImage() == threeD || handKarte3.getImage() == threeH || handKarte3.getImage() == threeS) {
                        croupierCardValue = croupierCardValue + 3;
                    } else if (handKarte3.getImage() == fourC || handKarte3.getImage() == fourD || handKarte3.getImage() == fourH || handKarte3.getImage() == fourS) {
                        croupierCardValue = croupierCardValue + 4;
                    } else if (handKarte3.getImage() == fiveC || handKarte3.getImage() == fiveD || handKarte3.getImage() == fiveH || handKarte3.getImage() == fiveS) {
                        croupierCardValue = croupierCardValue + 5;
                    } else if (handKarte3.getImage() == sixS || handKarte3.getImage() == sixD || handKarte3.getImage() == sixH || handKarte3.getImage() == sixS) {
                        croupierCardValue = croupierCardValue + 6;
                    } else if (handKarte3.getImage() == sevenC || handKarte3.getImage() == sevenD || handKarte3.getImage() == sevenH || handKarte3.getImage() == sevenS) {
                        croupierCardValue = croupierCardValue + 7;
                    } else if (handKarte3.getImage() == eightC || handKarte3.getImage() == eightD || handKarte3.getImage() == eightH || handKarte3.getImage() == eightS) {
                        croupierCardValue = croupierCardValue + 8;
                    } else if (handKarte3.getImage() == nineC || handKarte3.getImage() == nineD || handKarte3.getImage() == nineH || handKarte3.getImage() == nineS) {
                        croupierCardValue = croupierCardValue + 9;
                    } else if (handKarte3.getImage() == jackC || handKarte3.getImage() == jackD || handKarte3.getImage() == jackH || handKarte3.getImage() == jackS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte3.getImage() == kingC || handKarte3.getImage() == kingD || handKarte3.getImage() == kingH || handKarte3.getImage() == kingS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte3.getImage() == tenC || handKarte3.getImage() == tenD || handKarte3.getImage() == tenH || handKarte3.getImage() == tenS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte3.getImage() == aceC && croupierCardValue <= 10 || handKarte3.getImage() == aceD && croupierCardValue <= 10 || handKarte3.getImage() == aceH && croupierCardValue <= 10 || handKarte3.getImage() == aceS && croupierCardValue <= 10) {
                        croupierCardValue = croupierCardValue + 11;
                    } else if (handKarte3.getImage() == aceC && croupierCardValue > 10 || handKarte3.getImage() == aceD && croupierCardValue > 10 || handKarte3.getImage() == aceH && croupierCardValue > 10 || handKarte3.getImage() == aceS && croupierCardValue > 10) {
                        croupierCardValue = croupierCardValue + 1;
                    }
                    croupierValue.setText(Integer.toString(croupierCardValue));

                } else if (handKarte3.getImage() != null && handKarte4.getImage() == null) {
                    Random randomStand4 = new Random();
                    int rStandHandKarte4 = randomStand4.nextInt(cards.size() + 1);

                    handKarte4.setImage(cards.get(rStandHandKarte4));
                    cards.remove(rStandHandKarte4);
                    if (handKarte4.getImage() == twoC || handKarte4.getImage() == twoD || handKarte4.getImage() == twoH || handKarte4.getImage() == twoS) {
                        croupierCardValue = croupierCardValue + 2;
                    } else if (handKarte4.getImage() == threeC || handKarte4.getImage() == threeD || handKarte4.getImage() == threeH || handKarte4.getImage() == threeS) {
                        croupierCardValue = croupierCardValue + 3;
                    } else if (handKarte4.getImage() == fourC || handKarte4.getImage() == fourD || handKarte4.getImage() == fourH || handKarte4.getImage() == fourS) {
                        croupierCardValue = croupierCardValue + 4;
                    } else if (handKarte4.getImage() == fiveC || handKarte4.getImage() == fiveD || handKarte4.getImage() == fiveH || handKarte4.getImage() == fiveS) {
                        croupierCardValue = croupierCardValue + 5;
                    } else if (handKarte4.getImage() == sixS || handKarte4.getImage() == sixD || handKarte4.getImage() == sixH || handKarte4.getImage() == sixS) {
                        croupierCardValue = croupierCardValue + 6;
                    } else if (handKarte4.getImage() == sevenC || handKarte4.getImage() == sevenD || handKarte4.getImage() == sevenH || handKarte4.getImage() == sevenS) {
                        croupierCardValue = croupierCardValue + 7;
                    } else if (handKarte4.getImage() == eightC || handKarte4.getImage() == eightD || handKarte4.getImage() == eightH || handKarte4.getImage() == eightS) {
                        croupierCardValue = croupierCardValue + 8;
                    } else if (handKarte4.getImage() == nineC || handKarte4.getImage() == nineD || handKarte4.getImage() == nineH || handKarte4.getImage() == nineS) {
                        croupierCardValue = croupierCardValue + 9;
                    } else if (handKarte4.getImage() == jackC || handKarte4.getImage() == jackD || handKarte4.getImage() == jackH || handKarte4.getImage() == jackS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte4.getImage() == kingC || handKarte4.getImage() == kingD || handKarte4.getImage() == kingH || handKarte4.getImage() == kingS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte4.getImage() == tenC || handKarte4.getImage() == tenD || handKarte4.getImage() == tenH || handKarte4.getImage() == tenS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte4.getImage() == aceC && croupierCardValue <= 10 || handKarte4.getImage() == aceD && croupierCardValue <= 10 || handKarte4.getImage() == aceH && croupierCardValue <= 10 || handKarte4.getImage() == aceS && croupierCardValue <= 10) {
                        croupierCardValue = croupierCardValue + 11;
                    } else if (handKarte4.getImage() == aceC && croupierCardValue > 10 || handKarte4.getImage() == aceD && croupierCardValue > 10 || handKarte4.getImage() == aceH && croupierCardValue > 10 || handKarte4.getImage() == aceS && croupierCardValue > 10) {
                        croupierCardValue = croupierCardValue + 1;
                    }
                    croupierValue.setText(Integer.toString(croupierCardValue));
                } else if (handKarte4.getImage() != null && handKarte5.getImage() == null) {
                    Random randomStand5 = new Random();
                    int rStandHandKarte5 = randomStand5.nextInt(cards.size() + 1);

                    handKarte5.setImage(cards.get(rStandHandKarte5));
                    cards.remove(rStandHandKarte5);
                    if (handKarte5.getImage() == twoC || handKarte5.getImage() == twoD || handKarte5.getImage() == twoH || handKarte5.getImage() == twoS) {
                        croupierCardValue = croupierCardValue + 2;
                    } else if (handKarte5.getImage() == threeC || handKarte5.getImage() == threeD || handKarte5.getImage() == threeH || handKarte5.getImage() == threeS) {
                        croupierCardValue = croupierCardValue + 3;
                    } else if (handKarte5.getImage() == fourC || handKarte5.getImage() == fourD || handKarte5.getImage() == fourH || handKarte5.getImage() == fourS) {
                        croupierCardValue = croupierCardValue + 4;
                    } else if (handKarte5.getImage() == fiveC || handKarte5.getImage() == fiveD || handKarte5.getImage() == fiveH || handKarte5.getImage() == fiveS) {
                        croupierCardValue = croupierCardValue + 5;
                    } else if (handKarte5.getImage() == sixS || handKarte5.getImage() == sixD || handKarte5.getImage() == sixH || handKarte5.getImage() == sixS) {
                        croupierCardValue = croupierCardValue + 6;
                    } else if (handKarte5.getImage() == sevenC || handKarte5.getImage() == sevenD || handKarte5.getImage() == sevenH || handKarte5.getImage() == sevenS) {
                        croupierCardValue = croupierCardValue + 7;
                    } else if (handKarte5.getImage() == eightC || handKarte5.getImage() == eightD || handKarte5.getImage() == eightH || handKarte5.getImage() == eightS) {
                        croupierCardValue = croupierCardValue + 8;
                    } else if (handKarte5.getImage() == nineC || handKarte5.getImage() == nineD || handKarte5.getImage() == nineH || handKarte5.getImage() == nineS) {
                        croupierCardValue = croupierCardValue + 9;
                    } else if (handKarte5.getImage() == jackC || handKarte5.getImage() == jackD || handKarte5.getImage() == jackH || handKarte5.getImage() == jackS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte5.getImage() == kingC || handKarte5.getImage() == kingD || handKarte5.getImage() == kingH || handKarte5.getImage() == kingS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte5.getImage() == tenC || handKarte5.getImage() == tenD || handKarte5.getImage() == tenH || handKarte5.getImage() == tenS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte5.getImage() == aceC && croupierCardValue <= 10 || handKarte5.getImage() == aceD && croupierCardValue <= 10 || handKarte5.getImage() == aceH && croupierCardValue <= 10 || handKarte5.getImage() == aceS && croupierCardValue <= 10) {
                        croupierCardValue = croupierCardValue + 11;
                    } else if (handKarte5.getImage() == aceC && croupierCardValue > 10 || handKarte5.getImage() == aceD && croupierCardValue > 10 || handKarte5.getImage() == aceH && croupierCardValue > 10 || handKarte5.getImage() == aceS && croupierCardValue > 10) {
                        croupierCardValue = croupierCardValue + 1;
                    }
                    croupierValue.setText(Integer.toString(croupierCardValue));

                } else if (handKarte5.getImage() != null && handKarte6.getImage() == null) {
                    Random randomStand6 = new Random();
                    int rStandHandKarte6 = randomStand6.nextInt(cards.size() + 1);

                    handKarte6.setImage(cards.get(rStandHandKarte6));
                    cards.remove(rStandHandKarte6);

                    if (handKarte6.getImage() == twoC || handKarte6.getImage() == twoD || handKarte6.getImage() == twoH || handKarte6.getImage() == twoS) {
                        croupierCardValue = croupierCardValue + 2;
                    } else if (handKarte6.getImage() == threeC || handKarte6.getImage() == threeD || handKarte6.getImage() == threeH || handKarte6.getImage() == threeS) {
                        croupierCardValue = croupierCardValue + 3;
                    } else if (handKarte6.getImage() == fourC || handKarte6.getImage() == fourD || handKarte6.getImage() == fourH || handKarte6.getImage() == fourS) {
                        croupierCardValue = croupierCardValue + 4;
                    } else if (handKarte6.getImage() == fiveC || handKarte6.getImage() == fiveD || handKarte6.getImage() == fiveH || handKarte6.getImage() == fiveS) {
                        croupierCardValue = croupierCardValue + 5;
                    } else if (handKarte6.getImage() == sixS || handKarte6.getImage() == sixD || handKarte6.getImage() == sixH || handKarte6.getImage() == sixS) {
                        croupierCardValue = croupierCardValue + 6;
                    } else if (handKarte6.getImage() == sevenC || handKarte6.getImage() == sevenD || handKarte6.getImage() == sevenH || handKarte6.getImage() == sevenS) {
                        croupierCardValue = croupierCardValue + 7;
                    } else if (handKarte6.getImage() == eightC || handKarte6.getImage() == eightD || handKarte6.getImage() == eightH || handKarte6.getImage() == eightS) {
                        croupierCardValue = croupierCardValue + 8;
                    } else if (handKarte6.getImage() == nineC || handKarte6.getImage() == nineD || handKarte6.getImage() == nineH || handKarte6.getImage() == nineS) {
                        croupierCardValue = croupierCardValue + 9;
                    } else if (handKarte6.getImage() == jackC || handKarte6.getImage() == jackD || handKarte6.getImage() == jackH || handKarte6.getImage() == jackS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte6.getImage() == kingC || handKarte6.getImage() == kingD || handKarte6.getImage() == kingH || handKarte6.getImage() == kingS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte6.getImage() == tenC || handKarte6.getImage() == tenD || handKarte6.getImage() == tenH || handKarte6.getImage() == tenS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte6.getImage() == aceC && croupierCardValue <= 10 || handKarte6.getImage() == aceD && croupierCardValue <= 10 || handKarte6.getImage() == aceH && croupierCardValue <= 10 || handKarte6.getImage() == aceS && croupierCardValue <= 10) {
                        croupierCardValue = croupierCardValue + 11;
                    } else if (handKarte6.getImage() == aceC && croupierCardValue > 10 || handKarte6.getImage() == aceD && croupierCardValue > 10 || handKarte6.getImage() == aceH && croupierCardValue > 10 || handKarte6.getImage() == aceS && croupierCardValue > 10) {
                        croupierCardValue = croupierCardValue + 1;
                    }
                    croupierValue.setText(Integer.toString(croupierCardValue));

                } else if (handKarte6.getImage() != null && handKarte7.getImage() == null) {
                    Random randomStand7 = new Random();
                    int rStandHandKarte7 = randomStand7.nextInt(cards.size() + 1);

                    handKarte7.setImage(cards.get(rStandHandKarte7));
                    cards.remove(rStandHandKarte7);

                    if (handKarte7.getImage() == twoC || handKarte7.getImage() == twoD || handKarte7.getImage() == twoH || handKarte7.getImage() == twoS) {
                        croupierCardValue = croupierCardValue + 2;
                    } else if (handKarte7.getImage() == threeC || handKarte7.getImage() == threeD || handKarte7.getImage() == threeH || handKarte7.getImage() == threeS) {
                        croupierCardValue = croupierCardValue + 3;
                    } else if (handKarte7.getImage() == fourC || handKarte7.getImage() == fourD || handKarte7.getImage() == fourH || handKarte7.getImage() == fourS) {
                        croupierCardValue = croupierCardValue + 4;
                    } else if (handKarte7.getImage() == fiveC || handKarte7.getImage() == fiveD || handKarte7.getImage() == fiveH || handKarte7.getImage() == fiveS) {
                        croupierCardValue = croupierCardValue + 5;
                    } else if (handKarte7.getImage() == sixS || handKarte7.getImage() == sixD || handKarte7.getImage() == sixH || handKarte7.getImage() == sixS) {
                        croupierCardValue = croupierCardValue + 6;
                    } else if (handKarte7.getImage() == sevenC || handKarte7.getImage() == sevenD || handKarte7.getImage() == sevenH || handKarte7.getImage() == sevenS) {
                        croupierCardValue = croupierCardValue + 7;
                    } else if (handKarte7.getImage() == eightC || handKarte7.getImage() == eightD || handKarte7.getImage() == eightH || handKarte7.getImage() == eightS) {
                        croupierCardValue = croupierCardValue + 8;
                    } else if (handKarte7.getImage() == nineC || handKarte7.getImage() == nineD || handKarte7.getImage() == nineH || handKarte7.getImage() == nineS) {
                        croupierCardValue = croupierCardValue + 9;
                    } else if (handKarte7.getImage() == jackC || handKarte7.getImage() == jackD || handKarte7.getImage() == jackH || handKarte7.getImage() == jackS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte7.getImage() == kingC || handKarte7.getImage() == kingD || handKarte7.getImage() == kingH || handKarte7.getImage() == kingS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte7.getImage() == tenC || handKarte7.getImage() == tenD || handKarte7.getImage() == tenH || handKarte7.getImage() == tenS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte7.getImage() == aceC && croupierCardValue <= 10 || handKarte7.getImage() == aceD && croupierCardValue <= 10 || handKarte7.getImage() == aceH && croupierCardValue <= 10 || handKarte7.getImage() == aceS && croupierCardValue <= 10) {
                        croupierCardValue = croupierCardValue + 11;
                    } else if (handKarte7.getImage() == aceC && croupierCardValue > 10 || handKarte7.getImage() == aceD && croupierCardValue > 10 || handKarte7.getImage() == aceH && croupierCardValue > 10 || handKarte7.getImage() == aceS && croupierCardValue > 10) {
                        croupierCardValue = croupierCardValue + 1;
                    }
                    croupierValue.setText(Integer.toString(croupierCardValue));
                }
            }
            if (croupierCardValue > 21 && croupierCardValue <= 31) {
                if (handKarte1.getImage() == aceC || handKarte1.getImage() == aceD || handKarte1.getImage() == aceH || handKarte1.getImage() == aceS || handKarte2.getImage() == aceC || handKarte2.getImage() == aceD || handKarte2.getImage() == aceH || handKarte2.getImage() == aceS || handKarte3.getImage() == aceC || handKarte3.getImage() == aceD || handKarte3.getImage() == aceH || handKarte3.getImage() == aceS || handKarte4.getImage() == aceC || handKarte4.getImage() == aceD || karte4.getImage() == aceH || handKarte4.getImage() == aceS || handKarte5.getImage() == aceC || handKarte5.getImage() == aceD || handKarte5.getImage() == aceH || handKarte5.getImage() == aceS || handKarte6.getImage() == aceC || handKarte6.getImage() == aceD || handKarte6.getImage() == aceH || handKarte6.getImage() == aceS || handKarte7.getImage() == aceC || handKarte7.getImage() == aceD || handKarte7.getImage() == aceH || handKarte7.getImage() == aceS) {
                    croupierCardValue = croupierCardValue - 10;
                    croupierValue.setText(Integer.toString(croupierCardValue));
                }
            }
            standButton.setDisable(true);

            profitCheck();
        }

    }

    @FXML
    private void einsatzBestaetigen(ActionEvent event) throws InterruptedException {
        //Einsatz überprüfen

        try {
            einsatzInt = Integer.parseInt(einsatz.getText());
            if (einsatzInt == 0) {
                JOptionPane.showMessageDialog(null, "Die Zahl darf nicht 0 sein!", "Warnung!", JOptionPane.WARNING_MESSAGE);
            } else if (einsatzInt > kontostand) {
                JOptionPane.showMessageDialog(null, "Die Zahl darf nicht Ihren Kontostand übersteigen!", "Warnung!", JOptionPane.WARNING_MESSAGE);
            } else if (einsatzInt < 0) {
                JOptionPane.showMessageDialog(null, "Die Zahl darf nicht negativ sein!", "Warnung!", JOptionPane.WARNING_MESSAGE);
            } else {
                spiel.setEinsatz("blackjack", einsatzInt, 0);
                spieler.setVermoegen(spieler.getVermoegen() - einsatzInt);
                kontostand = spieler.getVermoegen();
                balance.setText(Integer.toString(kontostand));
                hitButton.setDisable(false);
                startKarten();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Ganzzahl eingeben", "Warnung!", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void startKarten() {
        spieler.setVermoegen(spieler.getVermoegen());
        balance.setText(Integer.toString(kontostand));
        einsatzAnzeige.setText(Integer.toString(einsatzInt));
        einsatzBestaetigenButton.setDisable(true);

        Random randomStartenKarte1 = new Random();
        int rStartKarte1 = randomStartenKarte1.nextInt(cards.size());

        karte1.setImage(cards.get(rStartKarte1));
        cards.remove(rStartKarte1);
        if (karte1.getImage() == twoC || karte1.getImage() == twoD || karte1.getImage() == twoH || karte1.getImage() == twoS) {
            playerCardValue = playerCardValue + 2;
        } else if (karte1.getImage() == threeC || karte1.getImage() == threeD || karte1.getImage() == threeH || karte1.getImage() == threeS) {
            playerCardValue = playerCardValue + 3;
        } else if (karte1.getImage() == fourC || karte1.getImage() == fourD || karte1.getImage() == fourH || karte1.getImage() == fourS) {
            playerCardValue = playerCardValue + 4;
        } else if (karte1.getImage() == fiveC || karte1.getImage() == fiveD || karte1.getImage() == fiveH || karte1.getImage() == fiveS) {
            playerCardValue = playerCardValue + 5;
        } else if (karte1.getImage() == sixC || karte1.getImage() == sixD || karte1.getImage() == sixH || karte1.getImage() == sixS) {
            playerCardValue = playerCardValue + 6;
        } else if (karte1.getImage() == sevenC || karte1.getImage() == sevenD || karte1.getImage() == sevenH || karte1.getImage() == sevenS) {
            playerCardValue = playerCardValue + 7;
        } else if (karte1.getImage() == eightC || karte1.getImage() == eightD || karte1.getImage() == eightH || karte1.getImage() == eightS) {
            playerCardValue = playerCardValue + 8;
        } else if (karte1.getImage() == nineC || karte1.getImage() == nineD || karte1.getImage() == nineH || karte1.getImage() == nineS) {
            playerCardValue = playerCardValue + 9;
        } else if (karte1.getImage() == jackC || karte1.getImage() == jackD || karte1.getImage() == jackH || karte1.getImage() == jackS) {
            playerCardValue = playerCardValue + 10;
        } else if (karte1.getImage() == kingC || karte1.getImage() == kingD || karte1.getImage() == kingH || karte1.getImage() == kingS) {
            playerCardValue = playerCardValue + 10;
        } else if (karte1.getImage() == tenC || karte1.getImage() == tenD || karte1.getImage() == tenH || karte1.getImage() == tenS) {
            playerCardValue = playerCardValue + 10;
        } else if (karte1.getImage() == queenC || karte1.getImage() == queenD || karte1.getImage() == queenH || karte1.getImage() == queenS) {
            playerCardValue = playerCardValue + 10;
        } else if (karte1.getImage() == aceC && playerCardValue > 10 || karte1.getImage() == aceD && playerCardValue > 10 || karte1.getImage() == aceH && playerCardValue > 10 || karte1.getImage() == aceS && playerCardValue > 10) {
            playerCardValue = playerCardValue + 1;
        } else if (karte1.getImage() == aceC && playerCardValue <= 10 || karte1.getImage() == aceD && playerCardValue <= 10 || karte1.getImage() == aceH && playerCardValue <= 10 || karte1.getImage() == aceS && playerCardValue <= 10) {
            playerCardValue = playerCardValue + 11;
        }

        playerValue.setText(Integer.toString(playerCardValue));

        Random randomStartKarte2 = new Random();
        int rStartKarte2 = randomStartKarte2.nextInt(cards.size() + 1);

        karte2.setImage(cards.get(rStartKarte2));
        cards.remove(rStartKarte2);
        if (karte2.getImage() == twoC || karte2.getImage() == twoD || karte2.getImage() == twoH || karte2.getImage() == twoS) {
            playerCardValue = playerCardValue + 2;
        } else if (karte2.getImage() == threeC || karte2.getImage() == threeD || karte2.getImage() == threeH || karte2.getImage() == threeS) {
            playerCardValue = playerCardValue + 3;
        } else if (karte2.getImage() == fourC || karte2.getImage() == fourD || karte2.getImage() == fourH || karte2.getImage() == fourS) {
            playerCardValue = playerCardValue + 4;
        } else if (karte2.getImage() == fiveC || karte2.getImage() == fiveD || karte2.getImage() == fiveH || karte2.getImage() == fiveS) {
            playerCardValue = playerCardValue + 5;
        } else if (karte2.getImage() == sixC || karte2.getImage() == sixD || karte2.getImage() == sixH || karte2.getImage() == sixS) {
            playerCardValue = playerCardValue + 6;
        } else if (karte2.getImage() == sevenC || karte2.getImage() == sevenD || karte2.getImage() == sevenH || karte2.getImage() == sevenS) {
            playerCardValue = playerCardValue + 7;
        } else if (karte2.getImage() == eightC || karte2.getImage() == eightD || karte2.getImage() == eightH || karte2.getImage() == eightS) {
            playerCardValue = playerCardValue + 8;
        } else if (karte2.getImage() == nineC || karte2.getImage() == nineD || karte2.getImage() == nineH || karte2.getImage() == nineS) {
            playerCardValue = playerCardValue + 9;
        } else if (karte2.getImage() == jackC || karte2.getImage() == jackD || karte2.getImage() == jackH || karte2.getImage() == jackS) {
            playerCardValue = playerCardValue + 10;
        } else if (karte2.getImage() == kingC || karte2.getImage() == kingD || karte2.getImage() == kingH || karte2.getImage() == kingS) {
            playerCardValue = playerCardValue + 10;
        } else if (karte2.getImage() == tenC || karte2.getImage() == tenD || karte2.getImage() == tenH || karte2.getImage() == tenS) {
            playerCardValue = playerCardValue + 10;
        } else if (karte2.getImage() == queenC || karte2.getImage() == queenD || karte2.getImage() == queenH || karte2.getImage() == queenS) {
            playerCardValue = playerCardValue + 10;
        } else if (karte2.getImage() == aceC && playerCardValue > 10 || karte2.getImage() == aceD && playerCardValue > 10 || karte2.getImage() == aceH && playerCardValue > 10 || karte2.getImage() == aceS && playerCardValue > 10) {
            playerCardValue = playerCardValue + 1;
        } else if (karte2.getImage() == aceC && playerCardValue <= 10 || karte2.getImage() == aceD && playerCardValue <= 10 || karte2.getImage() == aceH && playerCardValue <= 10 || karte2.getImage() == aceS && playerCardValue <= 10) {
            playerCardValue = playerCardValue + 11;
        } else if (karte2.getImage() == aceC && playerCardValue == 10 || karte2.getImage() == aceD && playerCardValue == 10 || karte2.getImage() == aceH && playerCardValue == 10 || karte2.getImage() == aceS && playerCardValue == 10) {
            playerCardValue = playerCardValue + 11;
        }
        playerValue.setText(Integer.toString(playerCardValue));

        Random randomStartHandKarte1 = new Random();
        int rStartHandKarte1 = randomStartHandKarte1.nextInt(cards.size() + 1);

        handKarte1.setImage(cards.get(rStartHandKarte1));
        cards.remove(rStartHandKarte1);
        if (handKarte1.getImage() == twoC || handKarte1.getImage() == twoD || handKarte1.getImage() == twoH || handKarte1.getImage() == twoS) {
            croupierCardValue = croupierCardValue + 2;
        } else if (handKarte1.getImage() == threeC || handKarte1.getImage() == threeD || handKarte1.getImage() == threeH || handKarte1.getImage() == threeS) {
            croupierCardValue = croupierCardValue + 3;
        } else if (handKarte1.getImage() == fourC || handKarte1.getImage() == fourD || handKarte1.getImage() == fourH || handKarte1.getImage() == fourS) {
            croupierCardValue = croupierCardValue + 4;
        } else if (handKarte1.getImage() == fiveC || handKarte1.getImage() == fiveD || handKarte1.getImage() == fiveH || handKarte1.getImage() == fiveS) {
            croupierCardValue = croupierCardValue + 5;
        } else if (handKarte1.getImage() == sixC || handKarte1.getImage() == sixD || handKarte1.getImage() == sixH || handKarte1.getImage() == sixS) {
            croupierCardValue = croupierCardValue + 6;
        } else if (handKarte1.getImage() == sevenC || handKarte1.getImage() == sevenD || handKarte1.getImage() == sevenH || handKarte1.getImage() == sevenS) {
            croupierCardValue = croupierCardValue + 7;
        } else if (handKarte1.getImage() == eightC || handKarte1.getImage() == eightD || handKarte1.getImage() == eightH || handKarte1.getImage() == eightS) {
            croupierCardValue = croupierCardValue + 8;
        } else if (handKarte1.getImage() == nineC || handKarte1.getImage() == nineD || handKarte1.getImage() == nineH || handKarte1.getImage() == nineS) {
            croupierCardValue = croupierCardValue + 9;
        } else if (handKarte1.getImage() == jackC || handKarte1.getImage() == jackD || handKarte1.getImage() == jackH || handKarte1.getImage() == jackS) {
            croupierCardValue = croupierCardValue + 10;
        } else if (handKarte1.getImage() == kingC || handKarte1.getImage() == kingD || handKarte1.getImage() == kingH || handKarte1.getImage() == kingS) {
            croupierCardValue = croupierCardValue + 10;
        } else if (handKarte1.getImage() == tenC || handKarte1.getImage() == tenD || handKarte1.getImage() == tenH || handKarte1.getImage() == tenS) {
            croupierCardValue = croupierCardValue + 10;
        } else if (handKarte1.getImage() == queenC || handKarte1.getImage() == queenD || handKarte1.getImage() == queenH || handKarte1.getImage() == queenS) {
            croupierCardValue = croupierCardValue + 10;
        } else if (handKarte1.getImage() == aceC && croupierCardValue <= 10 || handKarte1.getImage() == aceD && croupierCardValue <= 10 || handKarte1.getImage() == aceH && croupierCardValue <= 10 || handKarte1.getImage() == aceS && croupierCardValue <= 10) {
            croupierCardValue = croupierCardValue + 11;
        } else if (handKarte1.getImage() == aceC && croupierCardValue > 10 || handKarte1.getImage() == aceD && croupierCardValue > 10 || handKarte1.getImage() == aceH && croupierCardValue > 10 || handKarte1.getImage() == aceS && croupierCardValue > 10) {
            croupierCardValue = croupierCardValue + 1;
        }
        croupierValue.setText(Integer.toString(croupierCardValue));

        handKarte2.setImage(new Image("/img/blackjack/red_back.png"));
        einsatz.setDisable(true);
    }

    @FXML
    private void insure(ActionEvent event) {
        if (handKarte1.getImage() == aceC || handKarte1.getImage() == aceD || handKarte1.getImage() == aceH || handKarte1.getImage() == aceS) {
            insuranceSubmit.setDisable(false);
            insuranceInput.setDisable(false);
        }
    }

    private void secondCard() {
        Random randomStand = new Random();
        int rStandHandKarte2 = randomStand.nextInt(cards.size() + 1);

        handKarte2.setImage(cards.get(rStandHandKarte2));
        cards.remove(rStandHandKarte2);
    }

    @FXML
    private void insuranceSubmitAction(ActionEvent event) {
        if (Integer.parseInt(insuranceInput.getText()) < kontostand) {
            insurance = Integer.parseInt(insuranceInput.getText());
            int insuranceAndBet = einsatzInt + insurance;
            kontostand = kontostand - insurance;
            spiel.setEinsatz("blackjack", insurance, 0);

            insuranceAnzeige.setText(Integer.toString(insurance));
            spieler.setVermoegen(kontostand);
            balance.setText(Integer.toString(kontostand));

            secondCard();
            ArrayList<Image> valueTenCards = new ArrayList();
            valueTenCards.add(jackC);
            valueTenCards.add(jackD);
            valueTenCards.add(jackH);
            valueTenCards.add(jackS);
            valueTenCards.add(queenC);
            valueTenCards.add(queenD);
            valueTenCards.add(queenH);
            valueTenCards.add(queenS);
            valueTenCards.add(kingC);
            valueTenCards.add(kingD);
            valueTenCards.add(kingH);
            valueTenCards.add(kingS);
            valueTenCards.add(tenC);
            valueTenCards.add(tenD);
            valueTenCards.add(tenH);
            valueTenCards.add(tenS);

            if (valueTenCards.contains(handKarte2)) {
                //return 2 times insurance
                int insuranceBack = insurance * 2;
                kontostand = kontostand + insuranceBack;
                spieler.setVermoegen(kontostand);
                balance.setText(Integer.toString(kontostand));
                hitButton.setDisable(true);
            } else {
            }
        }
    }

    //nochmals machen
    @FXML
    private void doublen(ActionEvent event) {
        if (playerCardValue == 9 || playerCardValue == 10 || playerCardValue == 11) {
            Random randomDoublenKarte3 = new Random();
            int rDoublenKarte3 = randomDoublenKarte3.nextInt(cards.size() + 1);
            spiel.setEinsatz("blackjack", einsatzInt, 0);

            kontostand = spieler.getVermoegen();
            einsatzInt = einsatzInt + einsatzInt;
            einsatzAnzeige.setText(Integer.toString(einsatzInt));
            spieler.setVermoegen(kontostand);
            balance.setText(Integer.toString(kontostand));

            karte3.setImage(cards.get(rDoublenKarte3));
            cards.remove(rDoublenKarte3);
            if (karte3.getImage() == twoC || karte3.getImage() == twoD || karte3.getImage() == twoH || karte3.getImage() == twoS) {
                playerCardValue = playerCardValue + 2;
            } else if (karte3.getImage() == threeC || karte3.getImage() == threeD || karte3.getImage() == threeH || karte3.getImage() == threeS) {
                playerCardValue = playerCardValue + 3;
            } else if (karte3.getImage() == fourC || karte3.getImage() == fourD || karte3.getImage() == fourH || karte3.getImage() == fourS) {
                playerCardValue = playerCardValue + 4;
            } else if (karte3.getImage() == fiveC || karte3.getImage() == fiveD || karte3.getImage() == fiveH || karte3.getImage() == fiveS) {
                playerCardValue = playerCardValue + 5;
            } else if (karte3.getImage() == sixC || karte3.getImage() == sixD || karte3.getImage() == sixH || karte3.getImage() == sixS) {
                playerCardValue = playerCardValue + 6;
            } else if (karte3.getImage() == sevenC || karte3.getImage() == sevenD || karte3.getImage() == sevenH || karte3.getImage() == sevenS) {
                playerCardValue = playerCardValue + 7;
            } else if (karte3.getImage() == eightC || karte3.getImage() == eightD || karte3.getImage() == eightH || karte3.getImage() == eightS) {
                playerCardValue = playerCardValue + 8;
            } else if (karte3.getImage() == nineC || karte3.getImage() == nineD || karte3.getImage() == nineH || karte3.getImage() == nineS) {
                playerCardValue = playerCardValue + 9;
            } else if (karte3.getImage() == jackC || karte3.getImage() == jackD || karte3.getImage() == jackH || karte3.getImage() == jackS) {
                playerCardValue = playerCardValue + 10;
            } else if (karte3.getImage() == kingC || karte3.getImage() == kingD || karte3.getImage() == kingH || karte3.getImage() == kingS) {
                playerCardValue = playerCardValue + 10;
            } else if (karte3.getImage() == tenC || karte3.getImage() == tenD || karte3.getImage() == tenH || karte3.getImage() == tenS) {
                playerCardValue = playerCardValue + 10;
            } else if (karte3.getImage() == queenC || karte3.getImage() == queenD || karte3.getImage() == queenH || karte3.getImage() == queenS) {
                playerCardValue = playerCardValue + 10;
            } else if (karte3.getImage() == aceC && playerCardValue > 10 || karte3.getImage() == aceD && playerCardValue > 10 || karte3.getImage() == aceH && playerCardValue > 10 || karte3.getImage() == aceS && playerCardValue > 10) {
                playerCardValue = playerCardValue + 1;
            } else if (karte3.getImage() == aceC && playerCardValue <= 10 || karte3.getImage() == aceD && playerCardValue <= 10 || karte3.getImage() == aceH && playerCardValue <= 10 || karte3.getImage() == aceS && playerCardValue <= 10) {
                playerCardValue = playerCardValue + 11;
            }
            playerValue.setText(Integer.toString(playerCardValue));

            profitCheck();

            standButton.setDisable(true);
            hitButton.setDisable(true);
            doubleButton.setDisable(true);

            
            while (croupierCardValue < 17) {
                if (handKarte2.getImage() != null && handKarte3.getImage() == null) {
                    Random randomDoublen3 = new Random();
                    int rDoublenHandKarte3 = randomDoublen3.nextInt(cards.size() + 1);

                    handKarte3.setImage(cards.get(rDoublenHandKarte3));
                    cards.remove(rDoublenHandKarte3);
                    if (handKarte3.getImage() == twoC || handKarte3.getImage() == twoD || handKarte3.getImage() == twoH || handKarte3.getImage() == twoS) {
                        croupierCardValue = croupierCardValue + 2;
                    } else if (handKarte3.getImage() == threeC || handKarte3.getImage() == threeD || handKarte3.getImage() == threeH || handKarte3.getImage() == threeS) {
                        croupierCardValue = croupierCardValue + 3;
                    } else if (handKarte3.getImage() == fourC || handKarte3.getImage() == fourD || handKarte3.getImage() == fourH || handKarte3.getImage() == fourS) {
                        croupierCardValue = croupierCardValue + 4;
                    } else if (handKarte3.getImage() == fiveC || handKarte3.getImage() == fiveD || handKarte3.getImage() == fiveH || handKarte3.getImage() == fiveS) {
                        croupierCardValue = croupierCardValue + 5;
                    } else if (handKarte3.getImage() == sixS || handKarte3.getImage() == sixD || handKarte3.getImage() == sixH || handKarte3.getImage() == sixS) {
                        croupierCardValue = croupierCardValue + 6;
                    } else if (handKarte3.getImage() == sevenC || handKarte3.getImage() == sevenD || handKarte3.getImage() == sevenH || handKarte3.getImage() == sevenS) {
                        croupierCardValue = croupierCardValue + 7;
                    } else if (handKarte3.getImage() == eightC || handKarte3.getImage() == eightD || handKarte3.getImage() == eightH || handKarte3.getImage() == eightS) {
                        croupierCardValue = croupierCardValue + 8;
                    } else if (handKarte3.getImage() == nineC || handKarte3.getImage() == nineD || handKarte3.getImage() == nineH || handKarte3.getImage() == nineS) {
                        croupierCardValue = croupierCardValue + 9;
                    } else if (handKarte3.getImage() == jackC || handKarte3.getImage() == jackD || handKarte3.getImage() == jackH || handKarte3.getImage() == jackS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte3.getImage() == kingC || handKarte3.getImage() == kingD || handKarte3.getImage() == kingH || handKarte3.getImage() == kingS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte3.getImage() == tenC || handKarte3.getImage() == tenD || handKarte3.getImage() == tenH || handKarte3.getImage() == tenS) {
                        croupierCardValue = croupierCardValue + 10;

                    } else if (handKarte3.getImage() == aceC && croupierCardValue <= 10 || handKarte3.getImage() == aceD && croupierCardValue <= 10 || handKarte3.getImage() == aceH && croupierCardValue <= 10 || handKarte3.getImage() == aceS && croupierCardValue <= 10) {
                        croupierCardValue = croupierCardValue + 11;
                    } else if (handKarte3.getImage() == aceC && croupierCardValue > 10 || handKarte3.getImage() == aceD && croupierCardValue > 10 || handKarte3.getImage() == aceH && croupierCardValue > 10 || handKarte3.getImage() == aceS && croupierCardValue > 10) {
                        croupierCardValue = croupierCardValue + 1;
                    }
                    croupierValue.setText(Integer.toString(croupierCardValue));

                } else if (handKarte3.getImage() != null && handKarte4.getImage() == null) {
                    Random randomDoublen4 = new Random();
                    int rDoublenHandKarte4 = randomDoublen4.nextInt(cards.size() + 1);

                    handKarte4.setImage(cards.get(rDoublenHandKarte4));
                    cards.remove(rDoublenHandKarte4);
                    if (handKarte4.getImage() == twoC || handKarte4.getImage() == twoD || handKarte4.getImage() == twoH || handKarte4.getImage() == twoS) {
                        croupierCardValue = croupierCardValue + 2;
                    } else if (handKarte4.getImage() == threeC || handKarte4.getImage() == threeD || handKarte4.getImage() == threeH || handKarte4.getImage() == threeS) {
                        croupierCardValue = croupierCardValue + 3;
                    } else if (handKarte4.getImage() == fourC || handKarte4.getImage() == fourD || handKarte4.getImage() == fourH || handKarte4.getImage() == fourS) {
                        croupierCardValue = croupierCardValue + 4;
                    } else if (handKarte4.getImage() == fiveC || handKarte4.getImage() == fiveD || handKarte4.getImage() == fiveH || handKarte4.getImage() == fiveS) {
                        croupierCardValue = croupierCardValue + 5;
                    } else if (handKarte4.getImage() == sixS || handKarte4.getImage() == sixD || handKarte4.getImage() == sixH || handKarte4.getImage() == sixS) {
                        croupierCardValue = croupierCardValue + 6;
                    } else if (handKarte4.getImage() == sevenC || handKarte4.getImage() == sevenD || handKarte4.getImage() == sevenH || handKarte4.getImage() == sevenS) {
                        croupierCardValue = croupierCardValue + 7;
                    } else if (handKarte4.getImage() == eightC || handKarte4.getImage() == eightD || handKarte4.getImage() == eightH || handKarte4.getImage() == eightS) {
                        croupierCardValue = croupierCardValue + 8;
                    } else if (handKarte4.getImage() == nineC || handKarte4.getImage() == nineD || handKarte4.getImage() == nineH || handKarte4.getImage() == nineS) {
                        croupierCardValue = croupierCardValue + 9;
                    } else if (handKarte4.getImage() == jackC || handKarte4.getImage() == jackD || handKarte4.getImage() == jackH || handKarte4.getImage() == jackS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte4.getImage() == kingC || handKarte4.getImage() == kingD || handKarte4.getImage() == kingH || handKarte4.getImage() == kingS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte4.getImage() == tenC || handKarte4.getImage() == tenD || handKarte4.getImage() == tenH || handKarte4.getImage() == tenS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte4.getImage() == aceC && croupierCardValue <= 10 || handKarte4.getImage() == aceD && croupierCardValue <= 10 || handKarte4.getImage() == aceH && croupierCardValue <= 10 || handKarte4.getImage() == aceS && croupierCardValue <= 10) {
                        croupierCardValue = croupierCardValue + 11;
                    } else if (handKarte4.getImage() == aceC && croupierCardValue > 10 || handKarte4.getImage() == aceD && croupierCardValue > 10 || handKarte4.getImage() == aceH && croupierCardValue > 10 || handKarte4.getImage() == aceS && croupierCardValue > 10) {
                        croupierCardValue = croupierCardValue + 1;
                    }
                    croupierValue.setText(Integer.toString(croupierCardValue));
                } else if (handKarte4.getImage() != null && handKarte5.getImage() == null) {
                    Random randomDoublen5 = new Random();
                    int rDoublenHandKarte5 = randomDoublen5.nextInt(cards.size() + 1);

                    handKarte5.setImage(cards.get(rDoublenHandKarte5));
                    cards.remove(rDoublenHandKarte5);
                    if (handKarte5.getImage() == twoC || handKarte5.getImage() == twoD || handKarte5.getImage() == twoH || handKarte5.getImage() == twoS) {
                        croupierCardValue = croupierCardValue + 2;
                    } else if (handKarte5.getImage() == threeC || handKarte5.getImage() == threeD || handKarte5.getImage() == threeH || handKarte5.getImage() == threeS) {
                        croupierCardValue = croupierCardValue + 3;
                    } else if (handKarte5.getImage() == fourC || handKarte5.getImage() == fourD || handKarte5.getImage() == fourH || handKarte5.getImage() == fourS) {
                        croupierCardValue = croupierCardValue + 4;
                    } else if (handKarte5.getImage() == fiveC || handKarte5.getImage() == fiveD || handKarte5.getImage() == fiveH || handKarte5.getImage() == fiveS) {
                        croupierCardValue = croupierCardValue + 5;
                    } else if (handKarte5.getImage() == sixS || handKarte5.getImage() == sixD || handKarte5.getImage() == sixH || handKarte5.getImage() == sixS) {
                        croupierCardValue = croupierCardValue + 6;
                    } else if (handKarte5.getImage() == sevenC || handKarte5.getImage() == sevenD || handKarte5.getImage() == sevenH || handKarte5.getImage() == sevenS) {
                        croupierCardValue = croupierCardValue + 7;
                    } else if (handKarte5.getImage() == eightC || handKarte5.getImage() == eightD || handKarte5.getImage() == eightH || handKarte5.getImage() == eightS) {
                        croupierCardValue = croupierCardValue + 8;
                    } else if (handKarte5.getImage() == nineC || handKarte5.getImage() == nineD || handKarte5.getImage() == nineH || handKarte5.getImage() == nineS) {
                        croupierCardValue = croupierCardValue + 9;
                    } else if (handKarte5.getImage() == jackC || handKarte5.getImage() == jackD || handKarte5.getImage() == jackH || handKarte5.getImage() == jackS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte5.getImage() == kingC || handKarte5.getImage() == kingD || handKarte5.getImage() == kingH || handKarte5.getImage() == kingS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte5.getImage() == tenC || handKarte5.getImage() == tenD || handKarte5.getImage() == tenH || handKarte5.getImage() == tenS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte5.getImage() == aceC && croupierCardValue <= 10 || handKarte5.getImage() == aceD && croupierCardValue <= 10 || handKarte5.getImage() == aceH && croupierCardValue <= 10 || handKarte5.getImage() == aceS && croupierCardValue <= 10) {
                        croupierCardValue = croupierCardValue + 11;
                    } else if (handKarte5.getImage() == aceC && croupierCardValue > 10 || handKarte5.getImage() == aceD && croupierCardValue > 10 || handKarte5.getImage() == aceH && croupierCardValue > 10 || handKarte5.getImage() == aceS && croupierCardValue > 10) {
                        croupierCardValue = croupierCardValue + 1;
                    }
                    croupierValue.setText(Integer.toString(croupierCardValue));

                } else if (handKarte5.getImage() != null && handKarte6.getImage() == null) {
                    Random randomDoublen6 = new Random();
                    int rDoublenHandKarte6 = randomDoublen6.nextInt(cards.size() + 1);

                    handKarte6.setImage(cards.get(rDoublenHandKarte6));
                    cards.remove(rDoublenHandKarte6);

                    if (handKarte6.getImage() == twoC || handKarte6.getImage() == twoD || handKarte6.getImage() == twoH || handKarte6.getImage() == twoS) {
                        croupierCardValue = croupierCardValue + 2;
                    } else if (handKarte6.getImage() == threeC || handKarte6.getImage() == threeD || handKarte6.getImage() == threeH || handKarte6.getImage() == threeS) {
                        croupierCardValue = croupierCardValue + 3;
                    } else if (handKarte6.getImage() == fourC || handKarte6.getImage() == fourD || handKarte6.getImage() == fourH || handKarte6.getImage() == fourS) {
                        croupierCardValue = croupierCardValue + 4;
                    } else if (handKarte6.getImage() == fiveC || handKarte6.getImage() == fiveD || handKarte6.getImage() == fiveH || handKarte6.getImage() == fiveS) {
                        croupierCardValue = croupierCardValue + 5;
                    } else if (handKarte6.getImage() == sixS || handKarte6.getImage() == sixD || handKarte6.getImage() == sixH || handKarte6.getImage() == sixS) {
                        croupierCardValue = croupierCardValue + 6;
                    } else if (handKarte6.getImage() == sevenC || handKarte6.getImage() == sevenD || handKarte6.getImage() == sevenH || handKarte6.getImage() == sevenS) {
                        croupierCardValue = croupierCardValue + 7;
                    } else if (handKarte6.getImage() == eightC || handKarte6.getImage() == eightD || handKarte6.getImage() == eightH || handKarte6.getImage() == eightS) {
                        croupierCardValue = croupierCardValue + 8;
                    } else if (handKarte6.getImage() == nineC || handKarte6.getImage() == nineD || handKarte6.getImage() == nineH || handKarte6.getImage() == nineS) {
                        croupierCardValue = croupierCardValue + 9;
                    } else if (handKarte6.getImage() == jackC || handKarte6.getImage() == jackD || handKarte6.getImage() == jackH || handKarte6.getImage() == jackS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte6.getImage() == kingC || handKarte6.getImage() == kingD || handKarte6.getImage() == kingH || handKarte6.getImage() == kingS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte6.getImage() == tenC || handKarte6.getImage() == tenD || handKarte6.getImage() == tenH || handKarte6.getImage() == tenS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte6.getImage() == aceC && croupierCardValue <= 10 || handKarte6.getImage() == aceD && croupierCardValue <= 10 || handKarte6.getImage() == aceH && croupierCardValue <= 10 || handKarte6.getImage() == aceS && croupierCardValue <= 10) {
                        croupierCardValue = croupierCardValue + 11;
                    } else if (handKarte6.getImage() == aceC && croupierCardValue > 10 || handKarte6.getImage() == aceD && croupierCardValue > 10 || handKarte6.getImage() == aceH && croupierCardValue > 10 || handKarte6.getImage() == aceS && croupierCardValue > 10) {
                        croupierCardValue = croupierCardValue + 1;
                    }
                    croupierValue.setText(Integer.toString(croupierCardValue));
                } else if (handKarte6.getImage() != null && handKarte7.getImage() == null) {
                    Random randomDoublen7 = new Random();
                    int rDoublenHandKarte7 = randomDoublen7.nextInt(cards.size() + 1);

                    handKarte7.setImage(cards.get(rDoublenHandKarte7));
                    cards.remove(rDoublenHandKarte7);

                    if (handKarte7.getImage() == twoC || handKarte7.getImage() == twoD || handKarte7.getImage() == twoH || handKarte7.getImage() == twoS) {
                        croupierCardValue = croupierCardValue + 2;
                    } else if (handKarte7.getImage() == threeC || handKarte7.getImage() == threeD || handKarte7.getImage() == threeH || handKarte7.getImage() == threeS) {
                        croupierCardValue = croupierCardValue + 3;
                    } else if (handKarte7.getImage() == fourC || handKarte7.getImage() == fourD || handKarte7.getImage() == fourH || handKarte7.getImage() == fourS) {
                        croupierCardValue = croupierCardValue + 4;
                    } else if (handKarte7.getImage() == fiveC || handKarte7.getImage() == fiveD || handKarte7.getImage() == fiveH || handKarte7.getImage() == fiveS) {
                        croupierCardValue = croupierCardValue + 5;
                    } else if (handKarte7.getImage() == sixS || handKarte7.getImage() == sixD || handKarte7.getImage() == sixH || handKarte7.getImage() == sixS) {
                        croupierCardValue = croupierCardValue + 6;
                    } else if (handKarte7.getImage() == sevenC || handKarte7.getImage() == sevenD || handKarte7.getImage() == sevenH || handKarte7.getImage() == sevenS) {
                        croupierCardValue = croupierCardValue + 7;
                    } else if (handKarte7.getImage() == eightC || handKarte7.getImage() == eightD || handKarte7.getImage() == eightH || handKarte7.getImage() == eightS) {
                        croupierCardValue = croupierCardValue + 8;
                    } else if (handKarte7.getImage() == nineC || handKarte7.getImage() == nineD || handKarte7.getImage() == nineH || handKarte7.getImage() == nineS) {
                        croupierCardValue = croupierCardValue + 9;
                    } else if (handKarte7.getImage() == jackC || handKarte7.getImage() == jackD || handKarte7.getImage() == jackH || handKarte7.getImage() == jackS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte7.getImage() == kingC || handKarte7.getImage() == kingD || handKarte7.getImage() == kingH || handKarte7.getImage() == kingS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte7.getImage() == tenC || handKarte7.getImage() == tenD || handKarte7.getImage() == tenH || handKarte7.getImage() == tenS) {
                        croupierCardValue = croupierCardValue + 10;
                    } else if (handKarte7.getImage() == aceC && croupierCardValue <= 10 || handKarte7.getImage() == aceD && croupierCardValue <= 10 || handKarte7.getImage() == aceH && croupierCardValue <= 10 || handKarte7.getImage() == aceS && croupierCardValue <= 10) {
                        croupierCardValue = croupierCardValue + 11;
                    } else if (handKarte7.getImage() == aceC && croupierCardValue > 10 || handKarte7.getImage() == aceD && croupierCardValue > 10 || handKarte7.getImage() == aceH && croupierCardValue > 10 || handKarte7.getImage() == aceS && croupierCardValue > 10) {
                        croupierCardValue = croupierCardValue + 1;
                    }
                    croupierValue.setText(Integer.toString(croupierCardValue));
                }

                profitCheck();

            }
        }else{
            JOptionPane.showMessageDialog(null, "Diese Funktion ist nur verfügbar wenn Sie den Kartenwert 9, 10 oder 11 erreichen!", "Warnung!", JOptionPane.WARNING_MESSAGE);
        }
        
    }

    public void profitCheck() {
        croupierValue.setText(Integer.toString(croupierCardValue));
        playerValue.setText(Integer.toString(playerCardValue));
        if ((playerCardValue == croupierCardValue) && (croupierCardValue < 21 && playerCardValue < 21)) {
            winOrLose.setText("Draw");
            kontostand = spieler.getVermoegen();
            spiel.setEinsatz("blackjack", 0, einsatzInt);
            spieler.setVermoegen(kontostand);
            balance.setText(Integer.toString(kontostand));

        } else if ((playerCardValue > croupierCardValue && playerCardValue < 21) || (croupierCardValue > 21 && playerCardValue < 21)) {
            winOrLose.setText("You win!");
            einsatzInt = einsatzInt * 2;
            spiel.setEinsatz("blackjack", 0, einsatzInt);
            kontostand = kontostand + einsatzInt;
            balance.setText(Integer.toString(kontostand));
            spieler.setVermoegen(kontostand);

        } else if ((playerCardValue < croupierCardValue && playerCardValue < 21) || (playerCardValue > 21 && croupierCardValue < 21)) {
            balance.setText(Integer.toString(kontostand));

            spieler.setVermoegen(kontostand);
            winOrLose.setText("You Lose!");

        } else if (playerCardValue == 21 && croupierCardValue != 21) {
            winOrLose.setText("You win!");
            double einsatzIntHit = (einsatzInt);
            einsatzIntHit = einsatzInt * 2.5;
            spiel.setEinsatz("blackjack", 0, einsatzInt);
            kontostand = kontostand + (int) einsatzIntHit;
            spieler.setVermoegen(kontostand);
            balance.setText(Integer.toString(kontostand));

        } else if (croupierCardValue == 21 && playerCardValue != 21) {
            balance.setText(Integer.toString(kontostand));
            spieler.setVermoegen(kontostand);
            winOrLose.setText("You Lose!");
        } else if (croupierCardValue == 21 && playerCardValue == 21) {
            winOrLose.setText("Draw");
            kontostand = spieler.getVermoegen();
            spiel.setEinsatz("blackjack", 0, einsatzInt);
            spieler.setVermoegen(kontostand);
            balance.setText(Integer.toString(kontostand));
        }
    }

    @FXML
    private void restartGame(ActionEvent event) {
        restart();
    }

    public void restart() {
        kartenHinzufuegen();
        playerCardValue = 0;
        oneTime = false;
        croupierCardValue = 0;

        karte1.setImage(null);
        karte2.setImage(null);
        karte3.setImage(null);
        karte4.setImage(null);
        karte5.setImage(null);
        karte6.setImage(null);
        karte7.setImage(null);

        handKarte1.setImage(null);
        handKarte2.setImage(null);
        handKarte3.setImage(null);
        handKarte4.setImage(null);
        handKarte5.setImage(null);
        handKarte6.setImage(null);
        handKarte7.setImage(null);

        doubleButton.setDisable(false);
        hitButton.setDisable(false);
        standButton.setDisable(false);
        insureButton.setDisable(false);

        exit_Blackjack.setDisable(false);
        insuranceSubmit.setDisable(true);
        einsatzBestaetigenButton.setDisable(false);
        playerValue.setText("");
        croupierValue.setText("");
        einsatzAnzeige.setText("");
        insuranceAnzeige.setText("");
        einsatz.setDisable(false);
        insuranceInput.setDisable(true);
        winOrLose.setText("");
    }

}
