import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {

    static int SIZE=25,XMAX=12*SIZE, YMAX=24*SIZE;
    static int[][] mesh=new int[YMAX/25][XMAX/25];
    static Form nextForm;
    static boolean gameRunning =true;
    static Pane pane;
    static Label score,linecount,gameOver;


    @Override
    public void start(Stage primaryStage) throws Exception {
        pane = new Pane();
        Stage parent = new Stage();
        parent.setTitle("Tetries");
        int size = 25;
        XMAX = 12 * size;
        YMAX = 24 * size;

        Line line =new Line(XMAX,0, XMAX, YMAX);

        Label scorelable=new Label("Score :");

        scorelable.setLayoutY(50);
        scorelable.setLayoutX(XMAX+25);
        scorelable.setId("score");

        ///score count
        score=new Label("1225442");
        score.setLayoutY(100);
        score.setLayoutX(XMAX+25);
        score.setId("count");

        //line lable
        Label linecountLable=new Label("Line :");
        linecountLable.setLayoutY(150);
        linecountLable.setLayoutX(XMAX+25);
        linecountLable.setId("line");

        //line count
        linecount=new Label("Line");
        linecount.setLayoutY(200);
        linecount.setLayoutX(XMAX+25);
        linecount.setId("count");

        //Gameover
            gameOver=new Label("G A M E \n O V E R");
            gameOver.setId("gameover");
            gameOver.setLayoutY(YMAX/2);
            gameOver.setLayoutX(XMAX/4);
            gameOver.setVisible(false);


        Scene scene = new Scene(pane, XMAX + 150, YMAX);
        scene.getStylesheets().add("stylesheet.css");


        nextForm=Controller.makeForm();


        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if(gameRunning) {

                    if (event.getCode() == KeyCode.LEFT) {
                        Controller.moveLeft(nextForm);
                    }
                    if (event.getCode() == KeyCode.RIGHT) {
                        Controller.moveRight(nextForm);
                    }
                    if (event.getCode() == KeyCode.UP) {
                        transform(nextForm);
                    }
                    if (event.getCode() == KeyCode.DOWN) {
                        Controller.moveDown(nextForm);
                    }
                }

            }
        });




        pane.getChildren().addAll(line,nextForm.a,nextForm.b,nextForm.c,nextForm.d,scorelable,linecountLable,score,linecount,gameOver);

        parent.setScene(scene);

        parent.show();

        Timer timer = new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if(gameRunning)
                        Controller.moveDown(nextForm);

                    }
                });
            }
        };

        timer.schedule(timerTask,0 , 300);
    }

    public void moveRectRight(Rectangle rect){
            rect.setX(rect.getX()+25);

    }

    public void moveRectLeft(Rectangle rect){
            rect.setX(rect.getX()-25);

    }

    public void moveRectDown(Rectangle rect){
            rect.setY(rect.getY()+25);

    }

    public void moveRectUp(Rectangle rect){
            rect.setY(rect.getY()-25);

    }

    public void transform(Form form){
        Rectangle a=form.a,b=form.b,c=form.c,d=form.d;
        if(a.getX()+25<XMAX&&b.getX()+25<XMAX&&c.getX()+25<XMAX&&d.getX()+25<XMAX&&
                a.getX()-25>-25&&b.getX()-25>-25&&c.getX()-25>-25&&d.getX()-25>-25&&
                a.getY()+25<YMAX&&b.getY()+25<YMAX&&c.getY()+25<YMAX&&d.getY()+25<YMAX&&
                a.getY()-25>-25&&b.getY()-25>-25&&c.getY()-25>-25&&d.getY()-25>-25){

            switch (form.getName()){
                case "j":
                    switch (form.form) {
                        case 1 -> {
                            moveRectRight(a);
                            moveRectDown(a);
                            moveRectLeft(c);
                            moveRectUp(c);
                            moveRectUp(d);
                            moveRectUp(d);
                            form.form = 2;
                        }
                        case 2 -> {
                            moveRectLeft(a);
                            moveRectDown(a);
                            moveRectRight(c);
                            moveRectUp(c);
                            moveRectRight(d);
                            moveRectRight(d);
                            form.form = 3;
                        }
                        case 3 -> {
                            moveRectLeft(a);
                            moveRectUp(a);
                            moveRectRight(c);
                            moveRectDown(c);
                            moveRectDown(d);
                            moveRectDown(d);
                            form.form = 4;
                        }
                        case 4 -> {
                            moveRectRight(a);
                            moveRectUp(a);
                            moveRectLeft(c);
                            moveRectDown(c);
                            moveRectLeft(d);
                            moveRectLeft(d);
                            form.form = 1;
                        }
                    }
                    break;
                case "l":
                    switch (form.form) {
                        case 1 -> {
                            moveRectRight(a);
                            moveRectDown(a);
                            moveRectLeft(c);
                            moveRectUp(c);
                            moveRectLeft(d);
                            moveRectLeft(d);
                            form.form = 2;
                        }
                        case 2 -> {
                            moveRectLeft(a);
                            moveRectDown(a);
                            moveRectRight(c);
                            moveRectUp(c);
                            moveRectUp(d);
                            moveRectUp(d);
                            form.form = 3;
                        }
                        case 3 -> {
                            moveRectLeft(a);
                            moveRectUp(a);
                            moveRectRight(c);
                            moveRectDown(c);
                            moveRectRight(d);
                            moveRectRight(d);
                            form.form = 4;
                        }
                        case 4 -> {
                            moveRectRight(a);
                            moveRectUp(a);
                            moveRectLeft(c);
                            moveRectDown(c);
                            moveRectDown(d);
                            moveRectDown(d);
                            form.form = 1;
                        }
                    }
                    break;
                case "s":
                    switch (form.form) {
                        case 1 -> {
                            moveRectLeft(a);
                            moveRectDown(a);
                            moveRectDown(a);
                            moveRectLeft(b);
                            form.form = 2;
                        }
                        case 2 -> {
                            moveRectUp(a);
                            moveRectUp(a);
                            moveRectRight(a);
                            moveRectRight(b);
                            form.form = 1;
                        }
                    }
                    break;
                case "t":
                    switch (form.form) {
                        case 1 -> {
                            moveRectRight(a);
                            moveRectUp(a);
                            moveRectLeft(c);
                            moveRectDown(c);
                            moveRectUp(d);
                            moveRectLeft(d);
                            form.form = 2;
                        }
                        case 2 -> {
                            moveRectDown(a);
                            moveRectRight(a);
                            moveRectUp(c);
                            moveRectLeft(c);
                            moveRectRight(d);
                            moveRectUp(d);
                            form.form = 3;
                        }
                        case 3 -> {
                            moveRectDown(a);
                            moveRectLeft(a);
                            moveRectUp(c);
                            moveRectRight(c);
                            moveRectRight(d);
                            moveRectDown(d);
                            form.form = 4;
                        }
                        case 4 -> {
                            moveRectLeft(a);
                            moveRectRight(c);
                            moveRectUp(a);
                            moveRectDown(c);
                            moveRectDown(d);
                            moveRectLeft(d);
                            form.form = 1;
                        }
                    }
                    break;
                case "z":
                    switch (form.form) {
                        case 1 -> {
                            moveRectRight(a);
                            moveRectUp(a);
                            moveRectLeft(c);
                            moveRectUp(c);
                            moveRectLeft(d);
                            moveRectLeft(d);
                            form.form = 2;
                        }
                        case 2 -> {
                            moveRectLeft(a);
                            moveRectDown(a);
                            moveRectRight(c);
                            moveRectDown(c);
                            moveRectRight(d);
                            moveRectRight(d);
                            form.form = 1;
                        }
                    }
                    break;
                case "i":
                    switch (form.form) {
                        case 1 -> {
                            moveRectLeft(a);
                            moveRectDown(a);
                            moveRectUp(c);
                            moveRectRight(c);
                            moveRectUp(d);
                            moveRectUp(d);
                            moveRectRight(d);
                            moveRectRight(d);
                            form.form = 2;
                        }
                        case 2 -> {
                            moveRectRight(a);
                            moveRectUp(a);
                            moveRectDown(c);
                            moveRectLeft(c);
                            moveRectDown(d);
                            moveRectDown(d);
                            moveRectLeft(d);
                            moveRectLeft(d);
                            form.form = 1;
                        }
                    }

            }
        }
    }

    public static void setNextForm(Form nextForm) {
        Main.nextForm = nextForm;
    }

    public static void main(String[] args) {

        for (int[] a :
                mesh) {
            Arrays.fill(a, 0);
//            System.out.println(Arrays.toString(a));
        }

        launch(args);


    }
}
