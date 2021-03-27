package fzu.zrf.mtsys.client.gui;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import fzu.zrf.mtsys.client.conf.Configuration;
import fzu.zrf.mtsys.client.conn.Connect2Server;
import fzu.zrf.mtsys.net.GetMemberCount;
import fzu.zrf.mtsys.net.Login.Result;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Chairman extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(Chairman.class, args);
    }

    private final Result result;

    public Chairman(Result result) {
        this.result = result;
    }

    @Override
    public void start(Stage stage) {

        BorderPane border = new BorderPane();

        HBox hbox = addHBox();
        border.setTop(hbox);
        border.setLeft(addVBox());

        addStackPane(hbox);

        Scene scene = new Scene(border);
        stage.setScene(scene);
        stage.setTitle(Configuration.BUNDLE.getString("Chairman.ChairmanClient.hint"));
        stage.show();
    }

    private HBox addHBox() {

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        Button buttonMessage = new Button(Configuration.BUNDLE.getString("Chairman.buttonMessage.hint"));
        buttonMessage.setPrefSize(170, 20);

        Button buttonAttendance = new Button(Configuration.BUNDLE.getString("Chairman.buttonAttendance.hint"));
        buttonAttendance.setPrefSize(120, 20);

        hbox.getChildren().addAll(buttonMessage, buttonAttendance);

        return hbox;
    }

    private VBox addVBox() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);

        Text title = new Text(Configuration.BUNDLE.getString("Chairman.buttonAttendance.hint"));
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        vbox.getChildren().add(title);

        TextField topic = new TextField();
        vbox.getChildren().add(new Label(Configuration.BUNDLE.getString("Chairman.topic.hint")));
        vbox.getChildren().add(topic);
        topic.setText("数字峰会");
        topic.setEditable(false);

        TextField chairman = new TextField();
        vbox.getChildren().add(new Label(Configuration.BUNDLE.getString("Chairman.chairman.hint")));
        vbox.getChildren().add(chairman);
        chairman.setText("小明");
        chairman.setEditable(false);

        TextField time = new TextField();
        vbox.getChildren().add(new Label(Configuration.BUNDLE.getString("Chairman.time.hint")));
        vbox.getChildren().add(time);
        time.setText("2021.3.27");
        time.setEditable(false);

        Text title1 = new Text(Configuration.BUNDLE.getString("Chairman.buttonAttendance.hint"));
        title1.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        vbox.getChildren().add(title1);

        TextField meeting = new TextField();
        vbox.getChildren().add(new Label(Configuration.BUNDLE.getString("Chairman.meeting.hint")));
        vbox.getChildren().add(meeting);
        meeting.setEditable(false);

        FutureTask<GetMemberCount.Result> task = new FutureTask<>(
                new Connect2Server<GetMemberCount, GetMemberCount.Result>() {

                    @Override
                    public GetMemberCount get() {
                        return new GetMemberCount();
                    }

                });
        task.run();

        try {
            meeting.setText(task.get().num + "");
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

//        TextField bbs = new TextField();
//        vbox.getChildren().add(new Label(Configuration.BUNDLE.getString("Chairman.bbs.hint")));
//        vbox.getChildren().add(bbs);
//        bbs.setEditable(false);

        return vbox;
    }

    private void addStackPane(HBox hb) {

        StackPane stack = new StackPane();
        Rectangle helpIcon = new Rectangle(30.0, 25.0);
        helpIcon.setFill(new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
                new Stop[] { new Stop(0, Color.web("#4977A3")), new Stop(0.5, Color.web("#B0C6DA")),
                        new Stop(1, Color.web("#9CB6CF")), }));
        helpIcon.setStroke(Color.web("#D0E6FA"));
        helpIcon.setArcHeight(3.5);
        helpIcon.setArcWidth(3.5);

        Text helpText = new Text("?");
        helpText.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        helpText.setFill(Color.WHITE);
        helpText.setStroke(Color.web("#7080A0"));

        stack.getChildren().addAll(helpIcon, helpText);
        stack.setAlignment(Pos.CENTER_RIGHT);

        StackPane.setMargin(helpText, new Insets(0, 10, 0, 0));

        hb.getChildren().add(stack);
        HBox.setHgrow(stack, Priority.ALWAYS);

    }

}
