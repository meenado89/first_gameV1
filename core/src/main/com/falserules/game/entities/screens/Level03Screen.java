public class Level03Screen {
    package com.falserules.game.screens;

import com.badlogic.gdx.graphics.Color;
import com.falserules.game.FalseRulesGame;
import com.falserules.game.entities.*;

public class Level03Screen extends BaseLevel {
    public Level03Screen(FalseRulesGame game) {
        super(game);
    }
    
    @Override
    protected void createLevel() {
        spawnX = 50f;
        spawnY = 300f;
        
        platforms.add(new Platform(0, 50, WORLD_WIDTH, 50, Color.GREEN, true));
        platforms.add(new Platform(100, 200, 100, 30, Color.GREEN, true));
        platforms.add(new Platform(250, 300, 100, 30, Color.GREEN, true));
        platforms.add(new Platform(400, 400, 100, 30, Color.GREEN, true));
        platforms.add(new Platform(550, 300, 100, 30, Color.GREEN, true));
        
        spikes.add(new Spike(200, 0, 150, 50, true));
        spikes.add(new Spike(450, 0, 150, 50, true));
        
        coins.add(new Coin(50, 150));
        coins.add(new Coin(150, 280));
        coins.add(new Coin(300, 380));
        coins.add(new Coin(450, 480));
        coins.add(new Coin(600, 380));
        coins.add(new Coin(650, 150));
        coins.add(new Coin(360, 150));
        
        enemies.add(new Enemy(100, 100, 50, 200, Color.RED, true));
        enemies.add(new Enemy(500, 100, 450, 650, Color.RED, true));
        
        exitDoor = new ExitDoor(640, 100);
    }
}
}
