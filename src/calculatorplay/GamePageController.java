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
    @FXML
    Button ClearButton;
    @FXML
    Button PLUSButton;
    static int Level = 1;
    static int Goal = 2;
    static int init_Move = 1;
    static int now_Move = 1;
    static int init_State = 1;
    static int now_State = 1;
    IntegerProperty intProperty = new SimpleIntegerProperty(1024);

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

    private void Clear() throws IOException, URISyntaxException {
        now_Move = init_Move;
        now_State = init_State;
        state.setText("" + now_State);
        move.setText("" + now_Move);
    }

    private void Add(int x) throws IOException, URISyntaxException {
        now_Move -= 1;
        now_State += x;
        state.setText("" + now_State);
        move.setText("" + now_Move);
        if (now_State == Goal) {
            Complete();
        }
    }
    private void MUL(int x) throws IOException, URISyntaxException {
        now_Move -= 1;
        now_State *= x;
        state.setText("" + now_State);
        move.setText("" + now_Move);
        if (now_State == Goal) {
            Complete();
        }
    }

    @FXML
    private void ClearButton(ActionEvent event) throws IOException, URISyntaxException {
        Clear();
    }

    @FXML
    private void ADDButton(ActionEvent event) throws IOException, URISyntaxException {
        if (now_Move == 0) {
            Clear();
            return;
        }
        Node node = (Node) event.getSource();
        String data = (String) node.getUserData();
        Add(Integer.parseInt(data));
    }

    @FXML
    private void MULButton(ActionEvent event) throws IOException, URISyntaxException {
        if (now_Move == 0) {
            Clear();
            return;
        }
        Node node = (Node) event.getSource();
        String data = (String) node.getUserData();
        MUL(Integer.parseInt(data));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        level.setText("" + Level);
        goal.setText("" + Goal);
        state.setText("" + now_State);
        move.setText("" + now_Move);
    }

}
