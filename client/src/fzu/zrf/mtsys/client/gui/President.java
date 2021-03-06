package fzu.zrf.mtsys.client.gui;

import fzu.zrf.mtsys.client.conf.Configuration;
import fzu.zrf.mtsys.net.Login.Result;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
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

public class President extends Application {

	public static void main(String[] args) {
		launch(President.class, args);
	}

	private final Result result;
	public President(Result result) {
	    this.result = result;
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle(Configuration.BUNDLE.getString("Welcome.hint"));

		BorderPane border = new BorderPane();
		HBox hbox = addHBox();
		border.setTop(hbox);
		border.setLeft(addVBox());
		addStackPane(hbox); // 添加一个堆栈面板到上方区域的HBox中

		border.setCenter(addGridPane());
		border.setRight(addFlowPane());
		Scene scene = new Scene(border, 1200, 800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public HBox addHBox() {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12)); // 节点到边缘的距离
		hbox.setSpacing(10); // 节点之间的间距
		hbox.setStyle("-fx-background-color: #336699;"); // 背景色

		Button buttonCurrent = new Button(Configuration.BUNDLE.getString("DetailMeeting.hint"));
		buttonCurrent.setPrefSize(100, 20);

		Button buttonProjected = new Button(Configuration.BUNDLE.getString("MeetingNumber.hint"));
		buttonProjected.setPrefSize(100, 20);

		Button put = new Button(Configuration.BUNDLE.getString("PutMessage.hint"));
		buttonProjected.setPrefSize(100, 20);

		Button reflash = new Button(Configuration.BUNDLE.getString("refresh.hint"));
		buttonProjected.setPrefSize(100, 20);
		hbox.getChildren().addAll(buttonCurrent, buttonProjected, put, reflash);

		return hbox;
	}

	public VBox addVBox() {
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(10)); // 内边距
		vbox.setSpacing(8); // 节点间距

		Text title = new Text("Data");
		title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		vbox.getChildren().add(title);

		/*
		 * Hyperlink options[] = new Hyperlink[] { new
		 * Hyperlink("register.subforum.hint"), new Hyperlink("登出"), new
		 * Hyperlink("刷新"), new Hyperlink("相关")};
		 * 
		 * for (int i=0; i<4; i++){ VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
		 * //为每个节点设置外边距 vbox.getChildren().add(options[i]); }
		 */

		return vbox;
	}

	public void addStackPane(HBox hb) {
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
		stack.setAlignment(Pos.CENTER_RIGHT); // 右对齐节点

		StackPane.setMargin(helpText, new Insets(0, 10, 0, 0)); // 设置问号居中显示
		hb.getChildren().add(stack); // 将StackPane添加到HBox中
		HBox.setHgrow(stack, Priority.ALWAYS); // 将HBox水平多余的所有空间都给StackPane，这样前面设置的右对齐就能保证问号按钮在最右边
	}

	public GridPane addGridPane() {
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(0, 10, 0, 10));

		for (int t = 0; t < 60; t += 9) {
			Text category = new Text("会议标题：改革开放");
			category.setFont(Font.font("Arial", FontWeight.BOLD, 20));
			grid.add(category, 1, 0 + t);
			// 将category节点放在第1行,第2列
			// 将chartTitle节点放在第1行,第3列
			Text chartTitle = new Text("主席：邓小平...");
			chartTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
			grid.add(chartTitle, 2, 0 + t);

			// 将chartSubtitle节点放在第2行,占第2和第3列
			Text chartSubtitle = new Text("会议时间：1978.11.3");
			grid.add(chartSubtitle, 1, 1 + t, 2, 1);

			// 将House图标放在第1列，占第1和第2行
			/*
			 * ImageView imageHouse = new ImageView( new
			 * Image(LayoutSample.class.getResourceAsStream("graphics/house.png")));
			 * grid.add(imageHouse, 0, 0, 1, 2);
			 */

			// 将左边的标签goodsPercent放在第3行，第1列，靠下对齐
			Text goodsPercent = new Text("会议主要内容::改革开放");
			GridPane.setValignment(goodsPercent, VPos.BOTTOM);
			grid.add(goodsPercent, 0, 2 + t);

			// 将饼图放在第3行，占第2和第3列
			/*
			 * ImageView imageChart = new ImageView( new
			 * Image(LayoutSample.class.getResourceAsStream("graphics/piechart.png")));
			 * grid.add(imageChart, 1, 2, 2, 1);
			 */

			// 将右边的标签servicesPercent放在第3行，第4列，靠上对齐
			Text servicesPercent = new Text("参与人数：99");
			GridPane.setValignment(servicesPercent, VPos.TOP);
			grid.add(servicesPercent, 3, 2 + t);

			/*
			 * Text div = new
			 * Text("---------------------------------------------------------------------")
			 * ; GridPane.setValignment(div, VPos.TOP); grid.add(div, 3, 2+t);
			 */
		}

		return grid;
	}

	public FlowPane addFlowPane() {
		FlowPane flow = new FlowPane();
		flow.setPadding(new Insets(5, 0, 5, 0));
		flow.setVgap(4);
		flow.setHgap(4);
		flow.setPrefWrapLength(170); // 预设FlowPane的宽度，使其能够显示两列
		flow.setStyle("-fx-background-color: DAE6F3;");

		ImageView pages[] = new ImageView[8];

		return flow;
	}
}
