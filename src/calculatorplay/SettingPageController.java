/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorplay;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class SettingPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Slider volumeSlider;
    @FXML
    TextField volumeTextField;

    @FXML
    private void BackButton(ActionEvent event) throws IOException, URISyntaxException {
        String value = ((Button) event.getSource()).getText();
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        volumeSlider.setBlockIncrement(1);
        volumeSlider.setValue(CalculatorPlay.mp.getVolume() * 100);
        volumeSlider.valueProperty().addListener((Observable observable) -> {
            CalculatorPlay.mp.setVolume(volumeSlider.getValue() / 100);
        });
        volumeTextField.setText(Double.toString(volumeSlider.getValue()));
        volumeTextField.textProperty().bindBidirectional(volumeSlider.valueProperty(), NumberFormat.getInstance());
    }

}
