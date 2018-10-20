package org.academiadecodigo.politicianshell.enemies;

public enum EnemyPicture {
    SOCRATES ("resources/Socrates.png"),
    LULA ("resources/Lula.png"),
    BOLSONARO ("resources/Bolsonaro.png"),
    MADURO ("resources/Maduro.png"),
    PUTIN ("resources/Putin.png"),
    TRUMP ("resources/Trump.png");

    private String url;

    private EnemyPicture(String url){
        this.url = url;
    }

    public String getUrl(){
        return this.url;
    }

}

