public class BaseLevel {
    package com.falserules.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.utils.Array;
import com.falserules.game.FalseRulesGame;
import com.falserules.game.entities.*;

public abstract class BaseLevel implements Screen {
    protected FalseRulesGame game;
    protected OrthographicCamera camera;
    protected Player player;
    
    protected Array<Platform> platforms;
    protected Array<Spike> spikes;
    protected Array<Coin> coins;
    protected Array<Enemy> enemies;
    protected Array<Arrow> arrows;
    protected ExitDoor exitDoor;
    
    protected float spawnX = 100f;
    protected float spawnY = 200f;
    protected int requiredCoins = 0;
    
    private float deathTimer = 0;
    private static final float DEATH_DELAY = 1.0f;
    
    protected static final float WORLD_WIDTH = 720f;
    protected static final float WORLD_HEIGHT = 1280f;
    
    public BaseLevel(FalseRulesGame game) {
        this.game = game;
        
        camera = new OrthographicCamera();
        camera.setToOrtho(false, WORLD_WIDTH, WORLD_HEIGHT);
        
        platforms = new Array<>();
        spikes = new Array<>();
        coins = new Array<>();
        enemies = new Array<>();
        arrows = new Array<>();
        
        player = new Player(spawnX, spawnY);
        
        GestureDetector gestureDetector = new GestureDetector(player);
        Gdx.input.setInputProcessor(gestureDetector);
        
        createLevel();
        
        for (Coin coin : coins) {
            if (!(coin instanceof DeadlyCoin)) {
                requiredCoins++;
            }
        }
        game.coinsRequiredThisLevel = requiredCoins;
    }
    
    protected abstract void createLevel();
    
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        if (player.isDead()) {
            deathTimer += delta;
            if (deathTimer >= DEATH_DELAY) {
                game.restartLevel();
                return;
            }
        } else {
            update(delta);
        }
        
        camera.update();
        game.shapeRenderer.setProjectionMatrix(camera.combined);
        game.batch.setProjectionMatrix(camera.combined);
        
        renderLevel();
        renderUI();
    }
    
    protected void update(float delta) {
        player.update(delta);
        
        for (Enemy enemy : enemies) {
            enemy.update(delta);
        }
        
        checkCollisions();
        
        if (game.coinsCollectedThisLevel >= requiredCoins && exitDoor != null) {
            exitDoor.unlock();
        }
    }
    
    protected void checkCollisions() {
        for (Platform platform : platforms) {
            if (player.getBounds().overlaps(platform.getBounds())) {
                if (platform.isSafe()) {
                    if (player.getY() >= platform.getBounds().y + platform.getBounds().height - 10) {
                        player.landOnPlatform(platform.getBounds().y + platform.getBounds().height);
                    }
                } else {
                    player.die();
                }
            }
        }
        
        for (Spike spike : spikes) {
            if (player.getBounds().overlaps(spike.getBounds())) {
                if (spike.isDeadly()) {
                    player.die();
                } else {
                    if (player.getY() >= spike.getBounds().y + spike.getBounds().height - 10) {
                        player.landOnPlatform(spike.getBounds().y + spike.getBounds().height);
                    }
                }
            }
        }
        
        for (Coin coin : coins) {
            if (!coin.isCollected() && player.getBounds().overlaps(coin.getBounds())) {
                if (coin instanceof DeadlyCoin) {
                    player.die();
                } else {
                    coin.collect();
                    game.coinsCollectedThisLevel++;
                }
            }
        }
        
        for (Enemy enemy : enemies) {
            if (enemy.isActive() && player.getBounds().overlaps(enemy.getBounds())) {
                if (player.getY() > enemy.getBounds().y + enemy.getBounds().height - 10 && 
                    player.getPosition().y > enemy.getBounds().y) {
                    if (enemy.canBeStopped()) {
                        enemy.stomp();
                    } else {
                        player.die();
                    }
                } else {
                    player.die();
                }
            }
        }
        
        if (exitDoor != null && !exitDoor.isLocked()) {
            if (player.getBounds().overlaps(exitDoor.getBounds())) {
                game.nextLevel();
            }
        }
        
        if (player.getY() < -100) {
            player.die();
        }
    }
    
    protected void renderLevel() {
        for (Platform platform : platforms) {
            platform.render(game.shapeRenderer);
        }
        
        for (Spike spike : spikes) {
            spike.render(game.shapeRenderer);
        }
        
        for (Arrow arrow : arrows) {
            arrow.render(game.shapeRenderer);
        }
        
        for (Coin coin : coins) {
            coin.render(game.shapeRenderer);
        }
        
        for (Enemy enemy : enemies) {
            enemy.render(game.shapeRenderer);
        }
        
        if (exitDoor != null) {
            exitDoor.render(game.shapeRenderer);
        }
        
        player.render(game.shapeRenderer);
    }
    
    protected void renderUI() {
        game.batch.begin();
        
        game.font.setColor(Color.WHITE);
        game.font.draw(game.batch, "Level " + game.currentLevel, 20, WORLD_HEIGHT - 20);
        
        game.font.draw(game.batch, "Coins: " + game.coinsCollectedThisLevel + "/" + requiredCoins, 
                      20, WORLD_HEIGHT - 60);
        
        game.font.draw(game.batch, "Deaths: " + game.totalDeaths, 20, WORLD_HEIGHT - 100);
        
        game.batch.end();
    }
    
    @Override public void show() {}
    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() {}
}
}
