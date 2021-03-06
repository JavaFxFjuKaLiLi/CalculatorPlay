/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorplay;

import java.io.IOException;
import static java.lang.String.format;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author user
 */
public class GamePageController implements Initializable {

    @FXML
    Label level;
    @FXML
    Label goal;
    @FXML
    Label move;
    @FXML
    Label state;
    static int Goal = 0;
    static int init_Move = 0;
    static int now_Move = 0;
    static int init_State = 0;
    static int now_State = 0;

    @FXML
    private void BackButton(ActionEvent event) throws IOException, URISyntaxException {
        String value = ((Button) event.getSource()).getText();
        Parent root = FXMLLoader.load(getClass().getResource("SelectPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void Complete() {
        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1));
        pauseTransition.setOnFinished(e -> state.setText("WIN"));
        pauseTransition.play();
    }

    private void Update() {
        now_Move -= 1;
        state.setText("" + now_State);
        move.setText("" + now_Move);
        if (now_State == Goal) {
            Complete();
        } else if (now_Move == 0) {
            PauseTransition pauseTransition = new PauseTransition(Duration.seconds(2));
            pauseTransition.setOnFinished(e -> {
                try {
                    this.Clear();
                } catch (IOException | URISyntaxException ex) {
                    Logger.getLogger(GamePageController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            });
            pauseTransition.play();
        }
    }

    private void Clear() throws IOException, URISyntaxException {
        now_Move = init_Move;
        now_State = init_State;
        state.setText("" + now_State);
        move.setText("" + now_Move);
    }

    @FXML
    private void ClearButton(ActionEvent event) throws IOException, URISyntaxException {
        Clear();
    }

    @FXML
    private void ADDButton(ActionEvent event) throws IOException, URISyntaxException {
        Node node = (Node) event.getSource();
        String data = (String) node.getUserData();
        now_State += Integer.parseInt(data);
        Update();
    }

    @FXML
    private void SUBButton(ActionEvent event) throws IOException, URISyntaxException {
        Node node = (Node) event.getSource();
        String data = (String) node.getUserData();
        now_State -= Integer.parseInt(data);
        Update();
    }

    @FXML
    private void MULButton(ActionEvent event) throws IOException, URISyntaxException {
        Node node = (Node) event.getSource();
        String data = (String) node.getUserData();
        now_State *= Integer.parseInt(data);
        Update();
    }

    @FXML
    private void RightShiftButton(ActionEvent event) throws IOException, URISyntaxException {
        int n = now_State;
        int mul = now_State % 10;
        while (n >= 10) {
            mul *= 10;
            n /= 10;
        }
        now_State = (now_State / 10 + mul);
        Update();
    }

    @FXML
    private void LeftShiftButton(ActionEvent event) throws IOException, URISyntaxException {
        int mul = 1;
        while (mul * 10 < now_State) {
            mul *= 10;
        }
        now_State = (now_State / mul + now_State % mul * 10);
        Update();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Goal = Integer.parseInt(goal.getText());
        now_State = init_State = Integer.parseInt(state.getText());
        now_Move = init_Move = Integer.parseInt(move.getText());
    }
}
