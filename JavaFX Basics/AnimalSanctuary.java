import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
/**
 * @author Wonho Lim
 * @version 11.0.12
 * Description:This class displays animal application.
 */
public class AnimalSanctuary extends Application {
    /**
     * This method opens new window and displays animal related things.
     * @param stg stage that will be used.
     */
    public void start(Stage stg) throws Exception {
        stg.setTitle("My Animal Sanctuary");
        Background bg = new Background(setBack());
        Alert a = new Alert(AlertType.NONE);
        Rectangle rect1 = makeRectangle();
        Label t1 = makeLabel();
        StackPane stack1 = stacker(rect1, t1);
        Rectangle rect2 = makeRectangle();
        Label t2 = makeLabel();
        StackPane stack2 = stacker(rect2, t2);
        Rectangle rect3 = makeRectangle();
        Label t3 = makeLabel();
        StackPane stack3 = stacker(rect3, t3);
        Rectangle rect4 = makeRectangle();
        Label t4 = makeLabel();
        StackPane stack4 = stacker(rect4, t4);
        Rectangle rect5 = makeRectangle();
        Label t5 = makeLabel();
        StackPane stack5 = stacker(rect5, t5);
        Rectangle rect6 = makeRectangle();
        Label t6 = makeLabel();
        StackPane stack6 = stacker(rect6, t6);
        Text txt1 = new Text("Type name here:");
        final TextField name = new TextField();
        name.setPromptText("Type name here");
        Text txt2 = new Text("Type health here:");
        final TextField health = new TextField();
        health.setPromptText("Type health here");
        Text txt3 = new Text("Pick animal type:");
        VBox vBox1 = new VBox();
        vBox1.getChildren().addAll(txt1, name);
        VBox vBox2 = new VBox();
        vBox2.getChildren().addAll(txt2, health);
        MenuButton button1 = new MenuButton("Select animal type");
        Button button2 = new Button("Add animal");
        button2.setPrefSize(200, 75);
        MenuItem m1 = new MenuItem(Animal.valueOf(Animal.DOG.name()).toString());
        MenuItem m2 = new MenuItem(Animal.valueOf(Animal.CAT.name()).toString());
        MenuItem m3 = new MenuItem(Animal.valueOf(Animal.SQUIRREL.name()).toString());
        MenuItem m4 = new MenuItem(Animal.valueOf(Animal.BIRD.name()).toString());
        button1.getItems().addAll(m1, m2, m3, m4);
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent evt2) {
                button1.setText(((MenuItem) evt2.getSource()).getText());
            }
        };
        m1.setOnAction(event);
        m2.setOnAction(event);
        m3.setOnAction(event);
        m4.setOnAction(event);
        EventHandler<MouseEvent> click1 = new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) {
                t1.setText("Empty");
                t1.setStyle("-fx-text-fill: black;");
            }
        };
        stack1.setOnMouseClicked(click1);
        EventHandler<MouseEvent> click2 = new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) {
                t2.setText("Empty");
                t2.setStyle("-fx-text-fill: black;");
            }
        };
        stack2.setOnMouseClicked(click2);
        EventHandler<MouseEvent> click3 = new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) {
                t3.setText("Empty");
                t3.setStyle("-fx-text-fill: black;");
            }
        };
        stack3.setOnMouseClicked(click3);
        EventHandler<MouseEvent> click4 = new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) {
                t4.setText("Empty");
                t4.setStyle("-fx-text-fill: black;");
            }
        };
        stack4.setOnMouseClicked(click4);
        EventHandler<MouseEvent> click5 = new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) {
                t5.setText("Empty");
                t5.setStyle("-fx-text-fill: black;");
            }
        };
        stack5.setOnMouseClicked(click5);
        EventHandler<MouseEvent> click6 = new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) {
                t6.setText("Empty");
                t6.setStyle("-fx-text-fill: black;");
            }
        };
        stack6.setOnMouseClicked(click6);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent evt) {
                String na = "No Name Yet";
                String type = button1.getText();
                int heal = 5;
                if (!name.getText().equals("")) {
                    na = name.getText();
                }
                if (!health.getText().equals("")) {
                    if (Integer.parseInt(health.getText()) >= 1 && Integer.parseInt(health.getText()) <= 10) {
                        heal = Integer.parseInt(health.getText());
                    }
                }
                if (t1.getText().equals("Empty")) {
                    t1.setText(na + "\n" + type + "\n" + heal);
                    t1.setStyle("-fx-text-fill: blue;");
                } else if (t3.getText().equals("Empty")) {
                    t3.setText(na + "\n" + type + "\n" + heal);
                    t3.setStyle("-fx-text-fill: blue;");
                } else if (t5.getText().equals("Empty")) {
                    t5.setText(na + "\n" + type + "\n" + heal);
                    t5.setStyle("-fx-text-fill: blue;");
                } else if (t2.getText().equals("Empty")) {
                    t2.setText(na + "\n" + type + "\n" + heal);
                    t2.setStyle("-fx-text-fill: blue;");
                } else if (t4.getText().equals("Empty")) {
                    t4.setText(na + "\n" + type + "\n" + heal);
                    t4.setStyle("-fx-text-fill: blue;");
                } else if (t6.getText().equals("Empty")) {
                    t6.setText(na + "\n" + type + "\n" + heal);
                    t6.setStyle("-fx-text-fill: blue;");
                } else {
                    a.setAlertType(AlertType.ERROR);
                    a.setContentText("There is no more room!");
                    a.show();
                }
                name.setText("");
                health.setText("");
                button1.setText("Select animal type");
            }
        });
        VBox vBox3 = new VBox();
        vBox3.getChildren().addAll(txt3, button1);
        VBox vBox4 = makeBox2();
        vBox4.getChildren().addAll(stack1, stack2);
        VBox vBox5 = makeBox2();
        vBox5.getChildren().addAll(stack3, stack4);
        VBox vBox6 = makeBox2();
        vBox6.getChildren().addAll(stack5, stack6);
        BorderPane border = new BorderPane();
        HBox hb = makeBottom(vBox1, vBox2, vBox3, button2);
        HBox hbCen = makeCenter(vBox4, vBox5, vBox6);
        border = makeFinal(hb, makeTitle(), hbCen, bg);
        Scene scene = new Scene(border, 1152, 864);
        stg.setScene(scene);
        stg.show();
    }
    /**
     * This sets border pane.
     * @param hb1 hBox 1 bottom
     * @param hb2 hBox 2 top
     * @param hb3 hBox 3 center
     * @param bg background
     * @return final border pane
     */
    public BorderPane makeFinal(HBox hb1, HBox hb2, HBox hb3, Background bg) {
        BorderPane border = new BorderPane();
        border.setBottom(hb1);
        border.setTop(hb2);
        border.setCenter(hb3);
        border.setBackground(bg);
        return border;
    }
    /**
     * This sets center box.
     * @param vb1 VBox 1
     * @param vb2 VBox 2
     * @param vb3 VBox 3
     * @param b1 the button
     * @return bottom box
     */
    public HBox makeBottom(VBox vb1, VBox vb2, VBox vb3, Button b1) {
        HBox hb = makeBox();
        hb.setSpacing(10);
        hb.getChildren().addAll(vb1, vb2, vb3, b1);
        hb.setStyle("-fx-background-color: yellow;");
        return hb;
    }
    /**
     * This sets center box.
     * @param vb1 VBox 1
     * @param vb2 VBox 2
     * @param vb3 VBox 3
     * @return center box
     */
    public HBox makeCenter(VBox vb1, VBox vb2, VBox vb3) {
        HBox hbCen = makeBox();
        hbCen.setSpacing(100);
        hbCen.getChildren().addAll(vb1, vb2, vb3);
        return hbCen;
    }
    /**
     * This sets title pane.
     * @return title pane.
     */
    public HBox makeTitle() {
        HBox hbTop = makeBox();
        Text title = new Text("The Animal Sanctuary");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        hbTop.getChildren().add(title);
        return hbTop;
    }
    /**
     * This sets rectangle.
     * @return the rectangle
     */
    public Rectangle makeRectangle() {
        Rectangle rect = new Rectangle(150, 150);
        rect.setFill(Color.WHITE);
        rect.setStrokeWidth(1);
        rect.setStroke(Color.BLACK);
        return rect;
    }
    /**
     * This sets stack.
     * @param rect the rectangle
     * @param lab the label
     * @return the stack
     */
    public StackPane stacker(Rectangle rect, Label lab) {
        StackPane stack = new StackPane();
        stack.getChildren().addAll(rect, lab);
        return stack;
    }
    /**
     * This sets label.
     * @return the label
     */
    public Label makeLabel() {
        Label t = new Label("Empty");
        t.setFont(Font.font("Arial", 15));
        return t;
    }
    /**
     * This sets HBox.
     * @return the HBox
     */
    public HBox makeBox() {
        HBox box = new HBox();
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(50, 50, 50, 50));
        return box;
    }
    /**
     * This sets Vbox.
     * @return the VBox
     */
    public VBox makeBox2() {
        VBox box = new VBox();
        box.setSpacing(100);
        return box;
    }
    /**
     * This sets background.
     * @return background image.
     */
    public BackgroundImage setBack() {
        Image pic = new Image("./animalImage.jpg", 1152.0, 864.0, true, true);
        BackgroundSize bgs = new BackgroundSize(1152.0, 864.0, true, true, true, false);
        BackgroundImage bgi = new BackgroundImage(pic, BackgroundRepeat.REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bgs);
        return bgi;
    }
    /**
     * This is main method for launching.
     * @param args list of arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }
}