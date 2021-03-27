package fzu.zrf.mtsys.client.gui;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
/**
 * @ClassName SecretaryAddMessage
 * @Description TODO
 * @Author Charley Chen
 * @DATE 2021/3/27 16:11
 * @Version 1.0
 **/
public class SecretaryAddMessage extends Application {
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());

        Label label0 = new Label("分论坛");
        String[] greetings = new String[] { "A", "B", "C", "D", "E" };
        ChoiceBox<String> cb = new ChoiceBox<String>(
                FXCollections.observableArrayList("a", "b", "c", "d", "e"));
        HBox hb0 = new HBox();
        hb0.getChildren().addAll(label0, cb);
        hb0.setSpacing(5);

        stage.setTitle("秘书，添加消息");
        stage.setWidth(450);
        stage.setHeight(500);
        Label label1 = new Label("消息标题");
        TextField textField = new TextField ();
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField);
        hb.setSpacing(5);

        Label label2 = new Label("消息正文");
        TextArea textArea = new TextArea ();
        textArea.setPrefSize(300,200);
        textArea.setWrapText(true);

        HBox hb2 = new HBox();
        hb2.getChildren().addAll(label2, textArea);
        hb2.setSpacing(5);


        Button btn = new Button();
        btn.setText("提交消息");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");  // wait to be overrided 点一下会提交
            }
        });

        HBox hb3 = new HBox();
        hb3.getChildren().addAll(btn);
        hb3.setSpacing(5);
        final VBox vbox = new VBox();
        vbox.setSpacing(50);
        vbox.setPadding(new Insets(5, 0, 0, 5));
        vbox.getChildren().addAll(hb0,hb,hb2,hb3);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        stage.show();
    }
}
