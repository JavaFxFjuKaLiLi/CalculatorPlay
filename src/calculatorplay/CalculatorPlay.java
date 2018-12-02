/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorplay;

import java.io.IOException;
import java.net.URISyntaxException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class CalculatorPlay extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    static MediaPlayer mp;

    @Override
    public void start(Stage stage) throws Exception, IOException, URISyntaxException {
        stage.setTitle("Calculator Game");
        stage.setWidth(342);
        stage.setHeight(600);
        stage.setResizable(false);

        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        mp = new MediaPlayer(new Media(getClass().getResource("/music/222.mp3").toURI().toString()));
        mp.setAutoPlay(true);
        mp.setOnEndOfMedia(() -> {
            mp.seek(javafx.util.Duration.ZERO);
        });
        mp.setVolume(0.5);
    }
}
