package net.dinastiafoca.game;

import net.dinastiafoca.window.Window;

public class Game implements BaseGame {

    @Override
    public void onCreate() {
        new Window.WindowBuilder()
                .setTitle("--")
                .setWidth(800)
                .setHeight(600)
                .build();
    }// Oque a gente faz da vida? ;-;
    // Bom um commitzim pra registrar
    // Que nome eu coloco no commit? '-'
    // Como não tenho criatividade, colocaria: "Create Window and Window.WindowBuilder"

    @Override
    public void doTick() {

    }

    @Override
    public void doRender() {

    }

    @Override
    public void onDestroy() {

    }
}
