public class Level10Screen {
    package com.falserules.game.screens;

import com.badlogic.gdx.graphics.Color;
import com.falserules.game.FalseRulesGame;
import com.falserules.game.entities.*;

public class Level10Screen extends BaseLevel {
    public Level10Screen(FalseRulesGame game) {
        super(game);
    }
    
    @Override
    protected void createLevel() {
        spawnX = 100f;
        spawnY = 200f;
        
        spikes.add(new Spike(0, 0, WORLD_WIDTH, 50, false));
        platforms.add(new Platform(300, 200, 200, 40, Color.GREEN, false));
        
        coins.add(new DeadlyCoin(200, 150));
        coins.add(new GlowingCoin(360, 120));
        coins.add(new DeadlyCoin(520, 150));
        
        exitDoor = new ExitDoor(600, 50);
    }
    
    @Override
    protected void checkCollisions() {
        super.checkCollisions();
        
        if (exitDoor != null && !exitDoor.isLocked()) {
            if (player.getBounds().overlaps(exitDoor.getBounds())) {
                if (player.isCrouching()) {
                    game.nextLevel();
                }
            }
        }
    }
    
    @Override
    protected void renderUI() {
        super.renderUI();
        
        if (exitDoor != null && !exitDoor.isLocked()) {
            float distToExit = Math.abs(player.getX() - exitDoor.getBounds().x);
            if (distToExit < 150) {
                game.batch.begin();
                game.font.setColor(Color.YELLOW);
                game.font.draw(game.batch, "Swipe down to enter", 
                              WORLD_WIDTH / 2 - 100, 400);
                game.batch.end();
            }
        }
    }
}
}
