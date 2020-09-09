import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Stack;


public class Controller {

    static int SIZE = Main.SIZE, XMAX = Main.XMAX, YMAX = Main.YMAX;
    static int[][] mesh = Main.mesh;
    static Pane pane = Main.pane;
    static int score=0, aliminateLineCount =0;



    public static void moveLeft(Form form) {
        if (form.a.getX() - 25 >= 0 && form.b.getX() - 25 >= 0 && form.c.getX() - 25 >= 0 && form.d.getX() - 25 >= 0) {

            form.a.setX(form.a.getX() - 25);
            form.b.setX(form.b.getX() - 25);
            form.c.setX(form.c.getX() - 25);
            form.d.setX(form.d.getX() - 25);


        }
    }

    public static void moveRight(Form form) {
        if (form.a.getX() + 25 < XMAX && form.b.getX() + 25 < XMAX && form.c.getX() + 25 < XMAX && form.d.getX() + 25 < XMAX) {

            form.a.setX(form.a.getX() + 25);
            form.b.setX(form.b.getX() + 25);
            form.c.setX(form.c.getX() + 25);
            form.d.setX(form.d.getX() + 25);


        }
    }


    public static Form makeForm() {
        String name;
        score=score+40;
        Main.score.setText(String.valueOf(score));
        Main.linecount.setText(String.valueOf(aliminateLineCount));
        Rectangle a = new Rectangle(SIZE - 1, SIZE - 1), b = new Rectangle(SIZE - 1, SIZE - 1), c = new Rectangle(SIZE - 1, SIZE - 1), d = new Rectangle(SIZE - 1, SIZE - 1);
        int randome = (int) (Math.random() * 100 + 1);
//        int randome = 720;
        if (randome < 15) {

            a.setX(XMAX / 2);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2);
            d.setX(XMAX / 2 - 25);
            b.setY(25);
            c.setY(25 * 2);
            d.setY(25 * 2);
            name = "j";
        } else if (randome < 30) {
            a.setX(XMAX / 2);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2);
            d.setX(XMAX / 2 + 25);
            b.setY(25);
            c.setY(25 * 2);
            d.setY(25 * 2);
            name = "l";
        } else if (randome < 45) {
            a.setX(XMAX / 2);
            b.setX(XMAX / 2 + 25);
            c.setX(XMAX / 2);
            c.setY(25);
            d.setX(XMAX / 2 + 25);
            d.setY(25);
            name = "o";
        } else if (randome < 60) {
            a.setX(XMAX / 2 + 25);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2);
            d.setX(XMAX / 2 - 25);
            c.setY(25);
            d.setY(25);
            name = "s";
        } else if (randome < 75) {
            a.setX(XMAX / 2 - 25);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2 + 25);
            d.setX(XMAX / 2);
            d.setY(25);
            name = "t";
        } else if (randome < 90) {
            a.setX(XMAX / 2 - 25);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2);
            d.setX(XMAX / 2 + 25);
            c.setY(25);
            d.setY(25);
            name = "z";
        } else {
            a.setX(XMAX / 2);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2);
            d.setX(XMAX / 2);
            b.setY(25);
            c.setY(25 * 2);
            d.setY(25 * 3);
            name = "i";
        }


        return new Form(a, b, c, d, name);

    }

    public static Boolean moveCheck(Rectangle rect) {
        return mesh[(int) (rect.getY() / 25) + 1][(int) (rect.getX() / 25)] == 1;
    }

    public static void moveDown(Form form) {
        Rectangle a = form.a, b = form.b, c = form.c, d = form.d;

        int moveA = mesh[(int) (a.getY() / SIZE) + 1][(int) (a.getX() / SIZE)];
        int moveB = mesh[(int) (b.getY() / SIZE) + 1][(int) (b.getX() / SIZE)];
        int moveC = mesh[(int) (c.getY() / SIZE) + 1][(int) (c.getX() / SIZE)];
        int moveD = mesh[(int) (d.getY() / SIZE) + 1][(int) (d.getX() / SIZE)];
        if (a.getY() + SIZE < YMAX && b.getY() + SIZE < YMAX && c.getY() + SIZE < YMAX && d.getY() + SIZE < YMAX) {

            if (moveA == 0 && moveB == moveA && moveC == moveA && moveD == moveA) {

                a.setY(a.getY() + 25);
                b.setY(b.getY() + 25);
                c.setY(c.getY() + 25);
                d.setY(d.getY() + 25);
            }
        }
//        System.out.println("a X : " + a.getX());
//        System.out.println("b X : " + b.getX());
//        System.out.println("c X : " + c.getX());
//        System.out.println("d X : " + d.getX());
//        System.out.println("==================================");
//        System.out.println("a Y : " + a.getY());
//        System.out.println("b Y : " + b.getY());
//        System.out.println("c Y : " + c.getY());
//        System.out.println("d Y : " + d.getY());
//        System.out.println("==================================");
//        System.out.println("moveA : " + moveA);
//        System.out.println("moveB : " + moveB);
//        System.out.println("moveC : " + moveC);
//        System.out.println("moveD : " + moveD);
//        System.out.println("==================================");

        if (a.getY() == YMAX - 25 || b.getY() == YMAX - 25 ||
                c.getY() == YMAX - 25 || d.getY() == YMAX - 25 ||
                moveCheck(a) || moveCheck(b) || moveCheck(c) || moveCheck(d)) {
            if(a.getY()/25==1||b.getY()/25==1||c.getY()/25==1||d.getY()/25==1){
                Main.gameOver.setVisible(true);
                Main.gameOver.toFront();
                Main.gameRunning =false;
            }
            moveA = mesh[(int) (a.getY() / SIZE)][(int) (a.getX() / SIZE)] = 1;
            moveB = mesh[(int) (b.getY() / SIZE)][(int) (b.getX() / SIZE)] = 1;
            moveC = mesh[(int) (c.getY() / SIZE)][(int) (c.getX() / SIZE)] = 1;
            moveD = mesh[(int) (d.getY() / SIZE)][(int) (d.getX() / SIZE)] = 1;

//            for (int[] ar :
//                    mesh) {
//                System.out.println(Arrays.toString(ar));
//            }
//
//            System.out.println("===================================================");

            remove();
            Form nextObject = makeForm();
            Main.setNextForm(nextObject);
            pane.getChildren().addAll(nextObject.a, nextObject.b, nextObject.c, nextObject.d);


        }


    }


    public static void remove() {
        int full = 0, count = 0;
        Stack line = new Stack<Integer>();
        ArrayList rectAbove = new ArrayList<Node>();
        ArrayList rowRect = new ArrayList<Node>();
        for (int i = 23; i >0; i--) {
            for (int j = 0; j < 12; j++) {
                if (mesh[i][j] == 1)
                    full++;
            }
            if (full == 12) {
                line.push(i);
            }
            full = 0;
        }

        while (line.size() > 0) {
            aliminateLineCount++;
            int scaleY= (int) line.pop();
            for (Node node :
                    pane.getChildren()) {
                //for  row deletion
                if(node instanceof Rectangle){
                    if(((Rectangle) node).getY()==scaleY*SIZE){
                        rowRect.add(node);
                    }
                    if(((Rectangle) node).getY()<scaleY*SIZE){
                        rectAbove.add(node);
                    }
                }

            }

            for(Object node2: rowRect){
                Rectangle rectangleDeletion = (Rectangle)node2;
                mesh[(int) (rectangleDeletion.getY() / SIZE)][(int) (rectangleDeletion.getX() / SIZE)] = 0;
                pane.getChildren().remove(rectangleDeletion);

            }
            //removing one for it current postion and inserting one
             for(Object node3: rectAbove){
                Rectangle rectangleabove = (Rectangle)node3;
                mesh[(int) (rectangleabove.getY() / SIZE)][(int) (rectangleabove.getX() / SIZE)] = 0;
               rectangleabove.setY(rectangleabove.getY()+25);
            }
             //inseting one for its new positon
            for(Node node4:pane.getChildren()){
                if(node4 instanceof Rectangle) {
                    Rectangle rectNew=(Rectangle)node4;
                    mesh[(int) (rectNew.getY() / SIZE)][(int) (rectNew.getX() / SIZE)] = 1;

                }


            }





            rectAbove.clear();
            rowRect.clear();
        }

//        System.out.println("remove===================================");
//        for (int[] a :
//                mesh) {
//            System.out.println(Arrays.toString(a));
//        }
    }


}
