import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Slider;

public class LimWonhoExam5 extends Application {
    public void start(Stage stg) throws Exception {
        stg.setTitle("Sample JavaFX Activity");
        
        Text title = new Text("This is my code");
        title.setFont(Font.font("Georgia", FontWeight.BOLD, 12));
        
        Circle c1 = new Circle(75);
        c1.setFill(Color.BLACK);
        c1.setStrokeWidth(10);
        c1.setStroke(Color.BLUE);
        
        StackPane stack = new StackPane();
        stack.getChildren().addAll(c1);
        
        Button btn = new Button("Change Color");
        btn.setOnAction((ActionEvent e) -> {
                if (c1.getFill() == Color.BLUE) {
                    c1.setFill(Color.BLACK);
                }
                else {
                    c1.setFill(Color.BLUE);
                }
        }); 
        
        MenuButton button1 = new MenuButton("Change Alignment");
        MenuItem m1 = new MenuItem("Left");
        MenuItem m2 = new MenuItem("Center");
        MenuItem m3 = new MenuItem("Right");
        button1.getItems().addAll(m1, m2, m3);
        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent evt1) {
                stack.setAlignment(Pos.CENTER_LEFT);
            }
        };
        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent evt2) {
                stack.setAlignment(Pos.CENTER);
            }
        };
        EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent evt3) {
                stack.setAlignment(Pos.CENTER_RIGHT);
            }
        };
        m1.setOnAction(event1);
        m2.setOnAction(event2);
        m3.setOnAction(event3);

        
        Slider slider = new Slider(0.0, 1.0, 1.0);
        
        slider.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent evt4) {
                c1.setOpacity(slider.getValue());
            }
        });
        
        VBox total = new VBox();
        total.getChildren().addAll(title, btn, stack, button1, slider);
        total.setPadding(new Insets(50, 50, 50, 50));
        total.setSpacing(100);
        total.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(total, 500, 1000);
        stg.setScene(scene);
        stg.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}