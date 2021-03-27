package fzu.zrf.mtsys.client.gui;

import fzu.zrf.mtsys.client.conf.Configuration;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Secretary extends Application {
    private final TableView<Person> table = new TableView<>();

    // 数据源
    private final ObservableList<Person> data =
            FXCollections.observableArrayList(
                    new Person("Smith", "sub_meeting1"),
                    new Person("Johnson", "sub_meeting2")

            );


    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle(Configuration.BUNDLE.getString("scretary.hint"));
        stage.setWidth(600);
        stage.setHeight(600);

        final Label label = new Label(Configuration.BUNDLE.getString("participants.hint"));
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn idCol = new TableColumn(Configuration.BUNDLE.getString("message_id.hint"));
        idCol.setMinWidth(100);
        idCol.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        TableColumn meetingCol = new TableColumn(Configuration.BUNDLE.getString("sub_meeting.hint"));
        meetingCol.setMinWidth(200);
        meetingCol.setCellValueFactory(
                new PropertyValueFactory<>("sub_meeting"));

        // 设置数据源
        table.setItems(data);
        // 一次添加列进TableView
        table.getColumns().addAll(idCol, meetingCol);
        table.setPrefSize(300,500);
        Button btn = new Button();
        btn.setText(Configuration.BUNDLE.getString("sendMessage.hint"));
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SecretaryAddMessage open  = new SecretaryAddMessage();
                open.start(new Stage());
            }
        });
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table,btn);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    public static class Person {

        private final SimpleStringProperty id;
        private final SimpleStringProperty sub_meeting;

        private Person(String id,  String sub_meeting) {
            this.id = new SimpleStringProperty(id);
            this.sub_meeting = new SimpleStringProperty(sub_meeting);
        }

        public String getId() {
            return id.get();
        }

        public SimpleStringProperty idProperty() {
            return id;
        }

        public void setId(String id) {
            this.id.set(id);
        }

        public String getSub_meeting() {
            return sub_meeting.get();
        }

        public SimpleStringProperty sub_meetingProperty() {
            return sub_meeting;
        }

        public void setSub_meeting(String sub_meeting) {
            this.sub_meeting.set(sub_meeting);
        }
    }
}
