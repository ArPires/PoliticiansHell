package org.academiadecodigo.politicianshell.field;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {

    public static final int HEIGHT = 700;
    public static final int PADDING_BOTTOM = -50;
    public static final int WIDTH = 500;

    private Picture grid;

    public Field(){

// RETIFICAR A NECESSIDADE DE COLOCAR ESTE COISO

        Canvas.getInstance().setWidth(WIDTH);
        Canvas.getInstance().setHeight(HEIGHT);

    }

    public void init(){

        grid = new Picture(0, PADDING_BOTTOM, "resources/Hellbg1.png");
        grid.draw();

    }

    public int getWidth(){
        return grid.getWidth();
    }

    public int getHeight(){
        return grid.getHeight();
    }


}
