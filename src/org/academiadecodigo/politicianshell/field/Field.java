package org.academiadecodigo.politicianshell.field;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {

    public static final int HEIGHT = 700;
    public static final int PADDING_BOTTOM = -50;
    public static final int WIDTH = 500;

    private Picture grid;

    public Field(){
        grid = new Picture(0, PADDING_BOTTOM, "resources/HellBg1.png");

    }

    public void init(){

        grid.draw();

    }

}
