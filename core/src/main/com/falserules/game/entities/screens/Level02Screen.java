public class Level02Screen {
    package com.falserules.game.screens;

import com.badlogic.gdx.graphics.Color;
import com.falserules.game.FalseRulesGame;
import com.falserules.game.entities.*;

public class Level02Screen extends BaseLevel {
    public Level02Screen(FalseRulesGame game) {
        super(game);
    }
    
    @Override
    protected void createLevel() {
        spawnX = 50f;
        spawnY = 200f;
        
        platforms.add(new Platform(0, 50, 300, 50, Color.GREEN, true));
        platforms.add(new Platform(400, 50, 320, 50, Color.GREEN, true));
        
        platforms.add(new Platform(150, 200, 80, 30, Color.GREEN, true));
        platforms.add(new Platform(300, 250, 80, 30, Color.GREEN, true));
        platforms.add(new Platform(450, 200, 80, 30, Color.GREEN, true));
        
        spikes.add(new Spike(300, 0, 100, 50, true));
        
        coins.add(new Coin(100, 150));
        coins.add(new Coin(190, 280));
        coins.add(new Coin(340, 330));
        coins.add(new Coin(490, 280));
        coins.add(new Coin(620, 150));
        
        enemies.add(new Enemy(200, 100, 150, 350, Color.RED, true));
        
        exitDoor = new ExitDoor(640, 100);
    }
}
}
