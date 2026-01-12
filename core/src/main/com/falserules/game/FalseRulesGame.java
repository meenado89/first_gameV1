package com.falserules.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.falserules.game.screens.*;

public class FalseRulesGame extends Game {
    public SpriteBatch batch;
    public ShapeRenderer shapeRenderer;
    public BitmapFont font;
    
    // Game state
    public int currentLevel = 1;
    public int totalDeaths = 0;
    public float totalPlayTime = 0;
    public int coinsCollectedThisLevel = 0;
    public int coinsRequiredThisLevel = 0;
    
    // Level completion tracking
    public boolean[] levelsCompleted = new boolean[10];
    
    @Override
    public void create() {
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        font = new BitmapFont();
        font.getData().setScale(2f);
        
        // Start with Level 1
        loadLevel(1);
    }
    
    public void loadLevel(int levelNum) {
        currentLevel = levelNum;
        coinsCollectedThisLevel = 0;
        
        // Dispose current screen if exists
        if (screen != null) {
            screen.dispose();
        }
        
        // Load appropriate level
        switch (levelNum) {
            case 1:
                setScreen(new Level01Screen(this));
                break;
            case 2:
                setScreen(new Level02Screen(this));
                break;
            case 3:
                setScreen(new Level03Screen(this));
                break;
            case 4:
                setScreen(new Level04Screen(this));
                break;
            case 5:
                setScreen(new Level05Screen(this));
                break;
            case 6:
                setScreen(new Level06Screen(this));
                break;
            case 7:
                setScreen(new Level07Screen(this));
                break;
            case 8:
                setScreen(new Level08Screen(this));
                break;
            case 9:
                setScreen(new Level09Screen(this));
                break;
            case 10:
                setScreen(new Level10Screen(this));
                break;
            default:
                showVictoryScreen();
                break;
        }
    }
    
    public void nextLevel() {
        levelsCompleted[currentLevel - 1] = true;
        currentLevel++;
        
        if (currentLevel <= 10) {
            loadLevel(currentLevel);
        } else {
            showVictoryScreen();
        }
    }
    
    public void restartLevel() {
        totalDeaths++;
        loadLevel(currentLevel);
    }
    
    private void showVictoryScreen() {
        setScreen(new VictoryScreen(this));
    }
    
    @Override
    public void render() {
        totalPlayTime += Gdx.graphics.getDeltaTime();
        super.render();
    }
    
    @Override
    public void dispose() {
        batch.dispose();
        shapeRenderer.dispose();
        font.dispose();
        if (screen != null) {
            screen.dispose();
        }
    }
}