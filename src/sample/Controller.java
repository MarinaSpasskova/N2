package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;

public class Controller implements Initializable {

    @FXML
    private Button ram;
    @FXML
    private Button bull;
    @FXML
    private Button twins;
    @FXML
    private Button crab;
    @FXML
    private Button lion;
    @FXML
    private Button maiden;
    @FXML
    private Label display;
    @FXML
    private Button scales;
    @FXML
    private Button scorpion;
    @FXML
    private Button archer;
    @FXML
    private Button goatHorned;
    @FXML
    private Button water;
    @FXML
    private Button fishes;
    private String zodiacSing;
    private ArrayList<String> allZodiacSings = new ArrayList<>();
    Client client  = new Client();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Controllers is initialiaezed!");
        display.setWrapText(true);
    }

    /*public void clickButton (MouseEvent mouseEvent) throws IOException {
            if(mouseEvent.getSource() == ram) {
                zodiacSing = ram.getText();
            }
            if (mouseEvent.getSource() == bull) {
                zodiacSing = bull.getText();
            }
            if (mouseEvent.getSource() == twins) {
                zodiacSing = twins.getText();
            }
            if (mouseEvent.getSource() == crab) {
                zodiacSing = crab.getText();
            }
            if (mouseEvent.getSource() == lion) {
                zodiacSing = lion.getText();
            }
            if (mouseEvent.getSource() == maiden) {
                zodiacSing = maiden.getText();
            }
            if (mouseEvent.getSource() == scales) {
                zodiacSing = scales.getText();
            }
            if (mouseEvent.getSource() == scorpion) {
                zodiacSing = scorpion.getText();
            }
            if (mouseEvent.getSource() == archer) {
                zodiacSing = archer.getText();
            }
            if (mouseEvent.getSource() == goatHorned) {
                zodiacSing = goatHorned.getText();
            }
            if (mouseEvent.getSource() == water) {
                zodiacSing = water.getText();
            }
            if (mouseEvent.getSource() == fishes) {
                zodiacSing = fishes.getText();
            }
            client.contactToServer(zodiacSing);
            String toSet = client.getDayHoroscope();
            display.setText(toSet);
        }*/

    public void clickButton(ActionEvent event) throws IOException {
        if(event.getSource() == ram) {
            zodiacSing = ram.getText();
        }
        if (event.getSource() == bull) {
            zodiacSing = bull.getText();
        }
        if (event.getSource() == twins) {
            zodiacSing = twins.getText();
        }
        if (event.getSource() == crab) {
            zodiacSing = crab.getText();
        }
        if (event.getSource() == lion) {
            zodiacSing = lion.getText();
        }
        if (event.getSource() == maiden) {
            zodiacSing = maiden.getText();
        }
        if (event.getSource() == scales) {
            zodiacSing = scales.getText();
        }
        if (event.getSource() == scorpion) {
            zodiacSing = scorpion.getText();
        }
        if (event.getSource() == archer) {
            zodiacSing = archer.getText();
        }
        if (event.getSource() == goatHorned) {
            zodiacSing = goatHorned.getText();
        }
        if (event.getSource() == water) {
            zodiacSing = water.getText();
        }
        if (event.getSource() == fishes) {
            zodiacSing = fishes.getText();
        }
        client.contactToServer(zodiacSing);
        String toSet = client.getDayHoroscope();
        display.setText(toSet);
    }
}