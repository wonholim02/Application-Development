import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;

public class BankAccount extends Application {
    /**
     * This method opens new window and displays bank related things.
     * @param stg stage that will be used.
     */
    public void start(Stage stg) throws Exception {
        Pane pane1 = new Pane();
        stg.setTitle("Bank Account");
        Image seoul = new Image("seoul.jpg", 1332.0, 850.0, true, true);
        BackgroundSize bgs = new BackgroundSize(100.0, 100.0, true, true, true, false);
        BackgroundImage bgi = new BackgroundImage(seoul, BackgroundRepeat.REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bgs);
        Background bg = new Background(bgi);
        pane1.setBackground(bg);
        Circle cl = new Circle(75);
        cl.setFill(Color.BLACK);
        cl.setStrokeWidth(10);
        cl.setStroke(Color.WHITE);
        Text t1 = new Text("2000");
        t1.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        t1.setFill(Color.WHITE);
        StackPane stack = new StackPane();
        stack.getChildren().addAll(cl, t1);
        stack.setLayoutX(1100);
        stack.setLayoutY(50);
        pane1.getChildren().add(stack);
        Rectangle rect = new Rectangle(496, 315, 320, 200);
        rect.setFill(Color.WHITE);
        pane1.getChildren().add(rect);
        rect.setStrokeWidth(10);
        rect.setStroke(Color.BLACK);
        Scene window = new Scene(pane1, 1332, 850);
        stg.setScene(window);
        stg.show();
    }
    /**
     * This is main method for launching.
     * @param args list of arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }
}