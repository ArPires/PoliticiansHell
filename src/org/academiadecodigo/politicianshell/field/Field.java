package org.academiadecodigo.politicianshell.field;


import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.event.KeyListener;

public class Field {

    public static final int PADDING_BOTTOM = -50;
    private Picture grid;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 700;

    public Field(){
        //this.fieldType = fieldType;
        Canvas.getInstance().setWidth(WIDTH);
        Canvas.getInstance().setHeight(HEIGHT);

        //grid = new Picture(0, PADDING_BOTTOM, "resources/Hellbg1.png");
        //grid.setColor(Color.BLACK);
        //grid.draw();

    }

   /* public void menu(){
        menu = new Picture(0, PADDING_BOTTOM, "resources/Menu.png");
        menu.draw();

    }*/

    public void init(){
        //grid.fill();
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
