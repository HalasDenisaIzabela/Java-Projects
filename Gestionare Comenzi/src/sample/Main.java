package sample;

import bll.BonFiscal;
import conexiune.ConexiuneMYSQL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Organizare depozit");
        primaryStage.setScene(new Scene(root, 833, 519));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        Connection conexiuneMYSQL = ConexiuneMYSQL.getConnection();

    }
}
