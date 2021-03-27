package fzu.zrf.mtsys.client.gui;

import fzu.zrf.mtsys.client.conf.Configuration;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Login extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle(Configuration.BUNDLE.getString("login.title"));

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid);
        stage.setResizable(false);
        stage.setScene(scene);

        grid.add(new Label(Configuration.BUNDLE.getString("login.account.hint")), 0, 0);

        TextField account = new TextField();
        grid.add(account, 1, 0);

        grid.add(new Label(Configuration.BUNDLE.getString("login.password.hint")), 0, 2);

        PasswordField password = new PasswordField();
        grid.add(password, 1, 2);

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        grid.add(buttonBox, 1, 4);

        Button register = new Button(Configuration.BUNDLE.getString("login.register.hint"));
        register.setOnAction(a -> {
            try {
                Register r = new Register();
                r.start(new Stage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        buttonBox.getChildren().add(register);

        Button login = new Button(Configuration.BUNDLE.getString("login.login.hint"));
        login.setOnAction(e -> {
        });
        buttonBox.getChildren().add(login);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);// args is unavailable
    }
}