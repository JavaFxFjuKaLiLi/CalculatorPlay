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
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author user
 */
public class GamePageController implements Initializable {
    @FXML Label level;
    @FXML Label goal;
    @FXML Label move;
    @FXML Label state;
    @FXML Button ClearButton;
    @FXML Button PLUSButton;
    static int Level=1;
    static int Goal=-5;
    static int init_Move=1;
    static int now_Move=1;
    static int init_State=1;
    static int now_State=1;
    @FXML
    private void BackButton(ActionEvent event) throws IOException, URISyntaxException {
            String value = ((Button)event.getSource()).getText();
            Parent root = FXMLLoader.load(getClass().getResource("SelectPage.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }   
    @FXML
    private void ClearButton(ActionEvent event) throws IOException, URISyntaxException {
            now_Move=init_Move;
            now_State=init_State;
    }     
    @FXML
    private void ADDButton(ActionEvent event) throws IOException, URISyntaxException {
            now_Move-=1;
            now_State+=1;
    }   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        level.textProperty().bindBidirectional(new SimpleIntegerProperty(Level), new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                return object.toString();
            }

            @Override
            public Number fromString(String string) {
                return Integer.parseInt(string);
            }
        } );
        goal.textProperty().bindBidirectional(new SimpleIntegerProperty(Goal), new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                return object.toString();
            }

            @Override
            public Number fromString(String string) {
                return Integer.parseInt(string);
            }
        } );
        move.textProperty().bindBidirectional(new SimpleIntegerProperty(now_Move), new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                return object.toString();
            }

            @Override
            public Number fromString(String string) {
                return Integer.parseInt(string);
            }
        } );
        state.textProperty().bindBidirectional(new SimpleIntegerProperty(now_State), new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                return object.toString();
            }

            @Override
            public Number fromString(String string) {
                return Integer.parseInt(string);
            }
        } );
    }    
    
}
