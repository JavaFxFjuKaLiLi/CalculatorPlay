package calculatorplay;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SelectPageController implements Initializable {

    @FXML Button level;
    public static int Level = 1;

    @FXML
    private void SelectPage(ActionEvent event) throws IOException{
        String value = ((Button)event.getSource()).getText();
        if("+".equals(value)&&Level<15)
            Level++;
        if("-".equals(value)&&Level>1)
            Level--;
        
        level.setText(""+Level);
    }
    
    @FXML
    private void BackButton(ActionEvent event) throws IOException, URISyntaxException {
            String value = ((Button)event.getSource()).getText();
            Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show(); 
    }
    
    @FXML
     private void StartQuestion(ActionEvent event) throws IOException{
         Parent root = FXMLLoader.load(getClass().getResource("Game"+Level+".fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
     }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        level.setText(""+Level);
    }    
    
}
