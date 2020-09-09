import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Form {
     Rectangle a,b,c,d;
     int form=1;
     String name;
     Color color;

    public Form(Rectangle a, Rectangle b, Rectangle c, Rectangle d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Form(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.name = name;


        switch (name) {
            case "j":
                color = Color.SLATEGRAY;
                break;
            case "l":
                color = Color.DARKGOLDENROD;
                break;
            case "o":
                color = Color.INDIANRED;
                break;
            case "s":
                color = Color.FORESTGREEN;
                break;
            case "t":
                color = Color.CADETBLUE;
                break;
            case "z":
                color = Color.HOTPINK;
                break;
            case "i":
                color = Color.SANDYBROWN;
                break;

        }

        a.setFill(color);
        b.setFill(color);
        c.setFill(color);
        d.setFill(color);
    }

    public String getName() {
        return name;
    }
    
    public void changeForm(){
        if (form != 4) {
            form++;
        }else {
            form=1;
        }
    }

}
