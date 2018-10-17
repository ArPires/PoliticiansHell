package org.academiadecodigo.politicianshell.field;


import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {

    public static final int WIDTH = 500;
    public static final int HEIGHT = 700;
    public static final int MARGIN_BOTTOM = 50;
    private Rectangle grid;


    public Field(){

        Canvas.getInstance().setWidth(WIDTH);
        Canvas.getInstance().setHeight(HEIGHT);

        grid = new Rectangle(0,0,WIDTH,(HEIGHT - MARGIN_BOTTOM));
        grid.setColor(Color.GRAY);
        grid.fill();

    }

    public void init(){
        grid.fill();
    }



}
