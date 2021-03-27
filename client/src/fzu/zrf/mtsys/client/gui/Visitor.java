package fzu.zrf.mtsys.client.gui;

import fzu.zrf.mtsys.client.conf.Configuration;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
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


public class Visitor extends Application {	
	@Override
	public void start(Stage stage) {
		BorderPane border = new BorderPane();
	    
	    HBox hbox = addHBox();
	    border.setTop(hbox);
	    border.setLeft(addLeftVBox());
	    addStackPane(hbox); 
	    
	    border.setRight(addFlowPane());
	    border.setCenter(addCenterVBox());

	    Scene scene = new Scene(border);
	    stage.setScene(scene);
	    stage.setTitle(Configuration.BUNDLE.getString("register.visitor.hint"));
	    stage.show();
	}	

    private HBox addHBox() { 
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 15, 15, 15));
        hbox.setSpacing(10);
        
        Text text = new Text(Configuration.BUNDLE.getString("register.visitor.hint"));
        hbox.getChildren().add(text);
        return hbox;
    }
    
/*
 * Creates a VBox with a list of links for the left region
 */
    private VBox addLeftVBox() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10)); // Set all sides to 10
        vbox.setSpacing(8);              // Gap between nodes
 
        Text title = new Text(Configuration.BUNDLE.getString("register.subforum.hint"));
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        vbox.getChildren().add(title);
        
        //此处为具体参加的分论坛名称
        Hyperlink options[] = new Hyperlink[] {
            new Hyperlink("分论坛1 "),
            new Hyperlink("分论坛2 "),
            new Hyperlink("分论坛3 "),
            new Hyperlink("分论坛4 "),};
        
         
        for (int i=0; i<options.length; i++) {
            // Add offset to left side to indent from title
            VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
            vbox.getChildren().add(options[i]);
        }
        
        return vbox;
    }
    
    private VBox addCenterVBox() {
    	VBox vbox = new VBox();
        vbox.setPadding(new Insets(10)); // Set all sides to 10
        vbox.setSpacing(8);              // Gap between nodes
 
        Text title = new Text(Configuration.BUNDLE.getString("register.message.hint"));
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        vbox.getChildren().add(title);
        
        //此处为推送的消息
        Hyperlink options[] = new Hyperlink[] {
            new Hyperlink("消息1 "),
            new Hyperlink("消息2 "),
            new Hyperlink("消息3 "),
            new Hyperlink("消息4 "),};
         
        for (int i=0; i<options.length; i++) {
            // Add offset to left side to indent from title
            VBox.setMargin(options[i], new Insets(0, 0, 0, 18));
            vbox.getChildren().add(options[i]);
        }
        
        return vbox;     	
    }
 
/*
 * Uses a stack pane to create a help icon and adds it to the right side of an HBox
 * 
 * @param hb HBox to add the stack to
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
        // Add offset to right for question mark to compensate for RIGHT 
        // alignment of all nodes
        StackPane.setMargin(helpText, new Insets(0, 10, 0, 0));
        
        hb.getChildren().add(stack);
        HBox.setHgrow(stack, Priority.ALWAYS);
    
    }
/*
 * Creates a horizontal flow pane with eight icons in four rows
 */
    private FlowPane addFlowPane() {
 
        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(8, 0, 8, 0));
        flow.setVgap(4);
        flow.setHgap(4);
        flow.setPrefWrapLength(170); // preferred width allows for two columns
        flow.setStyle("-fx-background-color: DAE6F3;");
        Text nickname = new Text(Configuration.BUNDLE.getString("register.nickname.hint"));
        flow.getChildren().add(nickname);
        
        return flow;
    }
}