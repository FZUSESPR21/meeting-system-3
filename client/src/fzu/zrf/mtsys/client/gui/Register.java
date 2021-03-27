package fzu.zrf.mtsys.client.gui;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.FutureTask;

import fzu.zrf.mtsys.client.conf.Configuration;
import fzu.zrf.mtsys.client.conn.Connect2Server;
import fzu.zrf.mtsys.net.FormsInfo;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Register extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(Configuration.BUNDLE.getString("register.title"));

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid);
        stage.setResizable(false);
        stage.setScene(scene);

        grid.add(new Label(Configuration.BUNDLE.getString("register.account.hint")), 0, 0);

        TextField account = new TextField();
        grid.add(account, 1, 0);

        grid.add(new Label(Configuration.BUNDLE.getString("register.nickname.hint")), 0, 2);

        TextField nickname = new TextField();
        grid.add(nickname, 1, 2);

        grid.add(new Label(Configuration.BUNDLE.getString("register.password.hint")), 0, 4);

        PasswordField password = new PasswordField();
        grid.add(password, 1, 4);

        grid.add(new Label(Configuration.BUNDLE.getString("register.password.confirm.hint")), 0, 6);

        PasswordField confirm = new PasswordField();
        grid.add(confirm, 1, 6);

        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(5, 0, 5, 0));
        flow.setVgap(4);
        flow.setHgap(4);

        grid.add(flow, 0, 8, 2, 1);

        FutureTask<FormsInfo.Result> task = new FutureTask<>(new Connect2Server<FormsInfo, FormsInfo.Result>() {

            @Override
            public FormsInfo get() {
                return new FormsInfo();
            }

        });
        task.run();

        HashMap<Integer, CheckBox> cbs = new HashMap<>();

        try {
            FormsInfo.Result r = task.get();
            for (Entry<Integer, String> e : r.forms.entrySet()) {
                cbs.put(e.getKey(), new CheckBox(e.getValue()));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        flow.getChildren().addAll(cbs.values());

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        grid.add(buttonBox, 1, 10);

        Button register = new Button(Configuration.BUNDLE.getString("register.register.hint"));
        register.setOnAction(a -> {
            if (!account.getText().trim().equals(confirm.getText().trim())) {
                Alert err = new Alert(AlertType.ERROR, Configuration.BUNDLE.getString("register.psw.err.hint"),
                        ButtonType.OK);
                err.showAndWait();
                return;
            }
            System.out.println(new fzu.zrf.mtsys.net.Register(account.getText().trim(), nickname.getText().trim(),
                    password.getText().trim(), null, false));
        });
        buttonBox.getChildren().add(register);

        stage.show();
    }

}
