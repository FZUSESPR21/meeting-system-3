package fzu.zrf.mtsys.client.gui;

public class SecretaryAddMessage extends Application {
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());

        Label label0 = new Label(Configuration.BUNDLE.getString("sub_meeting.hint"));
        String[] greetings = new String[] { "A", "B", "C", "D", "E" };
        ChoiceBox<String> cb = new ChoiceBox<String>(
                FXCollections.observableArrayList("a", "b", "c", "d", "e"));
        HBox hb0 = new HBox();
        hb0.getChildren().addAll(label0, cb);
        hb0.setSpacing(5);

        stage.setTitle(Configuration.BUNDLE.getString("scretary.hint"));
        stage.setWidth(450);
        stage.setHeight(500);
        Label label1 = new Label(Configuration.BUNDLE.getString("message_title.hint"));
        TextField textField = new TextField ();
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField);
        hb.setSpacing(5);

        Label label2 = new Label(Configuration.BUNDLE.getString("message_content.hint"));
        TextArea textArea = new TextArea ();
        textArea.setPrefSize(300,200);
        textArea.setWrapText(true);

        HBox hb2 = new HBox();
        hb2.getChildren().addAll(label2, textArea);
        hb2.setSpacing(5);
        Button btn = new Button();
        btn.setText(Configuration.BUNDLE.getString("sendMessage.hint"));
                btn.setOnAction(e -> {
            FutureTask<fzu.zrf.mtsys.net.SecretaryAddMessage.Result> task = new FutureTask<>(
                    new Connect2Server<fzu.zrf.mtsys.net.post, fzu.zrf.mtsys.net.post.Result>() {

                        @Override
                        public fzu.zrf.mtsys.net.post get() {
                            return new fzu.zrf.mtsys.net.Login(cb.getValue().trim(), textField.getText().trim(), textArea.getText().trim());
                        }

                    });
        task.run();
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
