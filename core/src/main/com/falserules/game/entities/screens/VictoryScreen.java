public class VictoryScreen {
    package com.falserules.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.falserules.game.FalseRulesGame;

public class VictoryScreen implements Screen {
    private FalseRulesGame game;
    private OrthographicCamera camera;
    
    public VictoryScreen(FalseRulesGame game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 720, 1280);
    }
    
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        
        game.batch.begin();
        
        game.font.setColor(Color.WHITE);
        game.font.getData().setScale(3f);
        
        String title = "You've learned the only rule";
        game.font.draw(game.batch, title, 80, 1000);
        
        String subtitle = "that matters:";
        game.font.draw(game.batch, subtitle, 200, 920);
        
        game.font.setColor(Color.YELLOW);
        game.font.getData().setScale(4f);
        String mainMessage = "QUESTION EVERYTHING.";
        game.font.draw(game.batch, mainMessage, 60, 800);
        
        game.font.setColor(Color.WHITE);
        game.font.getData().setScale(2.5f);
        
        game.font.draw(game.batch, "Thanks for playing FALSE RULES", 80, 650);
        
        game.font.getData().setScale(2f);
        game.font.draw(game.batch, "Your Stats:", 280, 500);
        
        int minutes = (int)(game.totalPlayTime / 60);
        int seconds = (int)(game.totalPlayTime % 60);
        
        game.font.draw(game.batch, "Total Deaths: " + game.totalDeaths, 220, 420);
        game.font.draw(game.batch, "Time: " + minutes + "m " + seconds + "s", 220, 360);
        game.font.draw(game.batch, "Levels Completed: 10/10", 180, 300);
        
        game.font.setColor(Color.GRAY);
        game.font.getData().setScale(1.5f);
        game.font.draw(game.batch, "Tap anywhere to play again", 200, 150);
        
        game.batch.end();
        
        if (Gdx.input.justTouched()) {
            game.totalDeaths = 0;
            game.totalPlayTime = 0;
            game.currentLevel = 1;
            game.loadLevel(1);
        }
    }
    
    @Override public void show() {}
    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() {}
}
}
