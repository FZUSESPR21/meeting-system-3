package fzu.zrf.mtsys.client.gui;

import java.util.concurrent.FutureTask;

import fzu.zrf.mtsys.client.conf.Configuration;
import fzu.zrf.mtsys.client.conn.Connect2Server;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SecretaryAddMessage extends Application {
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());

        Label label0 = new Label(Configuration.BUNDLE.getString("sub_meeting.hint"));
        String[] greetings = new String[] { "A", "B", "C", "D", "E" };
        ChoiceBox<String> cb = new ChoiceBox<String>(FXCollections.observableArrayList("a", "b", "c", "d", "e"));
        HBox hb0 = new HBox();
        hb0.getChildren().addAll(label0, cb);
        hb0.setSpacing(5);

        stage.setTitle(Configuration.BUNDLE.getString("scretary.hint"));
        stage.setWidth(450);
        stage.setHeight(500);
        Label label1 = new Label(Configuration.BUNDLE.getString("message_title.hint"));
        TextField textField = new TextField();
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField);
        hb.setSpacing(5);

        Label label2 = new Label(Configuration.BUNDLE.getString("message_content.hint"));
        TextArea textArea = new TextArea();
        textArea.setPrefSize(300, 200);
        textArea.setWrapText(true);

        HBox hb2 = new HBox();
        hb2.getChildren().addAll(label2, textArea);
        hb2.setSpacing(5);
        Button btn = new Button();
        btn.setText(Configuration.BUNDLE.getString("sendMessage.hint"));
        btn.setOnAction(e -> {
            
        });
        HBox hb3 = new HBox();
        hb3.getChildren().addAll(btn);
        hb3.setSpacing(5);
        final VBox vbox = new VBox();
        vbox.setSpacing(50);
        vbox.setPadding(new Insets(5, 0, 0, 5));
        vbox.getChildren().addAll(hb0, hb, hb2, hb3);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        stage.show();

    }
}
