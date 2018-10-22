package org.academiadecodigo.politicianshell;

public class Main {

    public static void main(String[] args){

        Game g = new Game();

        try {

            g.preGame();
            g.init();
            g.start();

        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

    }

}
