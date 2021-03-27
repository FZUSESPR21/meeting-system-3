package fzu.zrf.mtsys.client.gui;

import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
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
    
    @Override
    public void start(Stage stage) {
 
 
        BorderPane border = new BorderPane();
        
        HBox hbox = addHBox();
        border.setTop(hbox);
        border.setLeft(addVBox());

        addStackPane(hbox);  
        
    
        //border.setRight(addFlowPane());
     
       // border.setCenter(addAnchorPane(addGridPane()));
 
        Scene scene = new Scene(border);
        stage.setScene(scene);
        stage.setTitle("ChairmanClient");
        stage.show();
    }
 

    private HBox addHBox() {
 
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);   
        hbox.setStyle("-fx-background-color: #336699;");
 
        Button buttonMessage = new Button("会议议程&分论坛信息");
        buttonMessage.setPrefSize(170, 20);
 
        Button buttonAttendance = new Button("实时参会人数");
        buttonAttendance.setPrefSize(120, 20);
        
        hbox.getChildren().addAll(buttonMessage, buttonAttendance);
        
        return hbox;
    }
    

    private VBox addVBox() {
        
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10)); 
        vbox.setSpacing(8);            
 
        Text title = new Text("会议议程&分论坛信息");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        vbox.getChildren().add(title);
        
        
        
        TextField topic = new TextField();
        vbox.getChildren().add(new Label("分论坛议题: "));
        vbox.getChildren().add(topic);
        topic.setText("2021第99届数字峰会");
        topic.setEditable(false);
        
        TextField chairman = new TextField();
        vbox.getChildren().add(new Label("主席: "));
        vbox.getChildren().add(chairman);
        chairman.setText("小明");
        chairman.setEditable(false);
        
        TextField time = new TextField();
        vbox.getChildren().add(new Label("召开时间: "));
        vbox.getChildren().add(time);
        time.setText("2021.3.27");
        time.setEditable(false);
        
		
		Text title1 = new Text("实时参会人数"); title1.setFont(Font.font("Arial",
		FontWeight.BOLD, 24)); vbox.getChildren().add(title1);
		  
		
        
        TextField meeting = new TextField();
        vbox.getChildren().add(new Label("会议参会人数: "));
        vbox.getChildren().add(meeting);
        meeting.setEditable(false);
        
        TextField bbs = new TextField();
        vbox.getChildren().add(new Label("分论坛参会人数: "));
        vbox.getChildren().add(bbs);
        bbs.setEditable(false);
        
        return vbox;
    }
    
	/*
	 * private GridPane addGridPane() {
	 * 
	 * TextField notification = new TextField (); notification.setText("Label");
	 * 
	 * notification.clear();
	 * 
	 * GridPane grid = new GridPane(); grid.setVgap(4); grid.setHgap(10);
	 * grid.setPadding(new Insets(5, 5, 5, 5)); grid.add(new Label("To: "), 0, 0);
	 * grid.add(notification, 1, 0);
	 * 
	 * Group root = (Group) scene.getRoot(); root.getChildren().add(grid); return
	 * grid; }
	 */
   

    private void addStackPane(HBox hb) {
 
        StackPane stack = new StackPane();
        Rectangle helpIcon = new Rectangle(30.0, 25.0);
        helpIcon.setFill(new LinearGradient(0,0,0,1, true, CycleMethod.NO_CYCLE,
            new Stop[]{
            new Stop(0,Color.web("#4977A3")),
            new Stop(0.5, Color.web("#B0C6DA")),
            new Stop(1,Color.web("#9CB6CF")),}));
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
 

 

    

 

    private AnchorPane addAnchorPane(GridPane grid) {
 
        AnchorPane anchorpane = new AnchorPane();
        
        Button buttonSave = new Button("Save");
        Button buttonCancel = new Button("Cancel");
 
        HBox hb = new HBox();
        hb.setPadding(new Insets(0, 10, 10, 10));
        hb.setSpacing(10);
        hb.getChildren().addAll(buttonSave, buttonCancel);
 
        anchorpane.getChildren().addAll(grid,hb);
        // Anchor buttons to bottom right, anchor grid to top
        AnchorPane.setBottomAnchor(hb, 8.0);
        AnchorPane.setRightAnchor(hb, 5.0);
        AnchorPane.setTopAnchor(grid, 10.0);
 
        return anchorpane;
    }
}
