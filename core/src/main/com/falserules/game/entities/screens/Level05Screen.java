public class Level05Screen {
    package com.falserules.game.screens;

import com.badlogic.gdx.graphics.Color;
import com.falserules.game.FalseRulesGame;
import com.falserules.game.entities.*;

public class Level05Screen extends BaseLevel {
    public Level05Screen(FalseRulesGame game) {
        super(game);
    }
    
    @Override
    protected void createLevel() {
        spawnX = 100f;
        spawnY = 200f;
        
        spikes.add(new Spike(0, 0, WORLD_WIDTH, 50, false));
        platforms.add(new Platform(300, 200, 150, 40, Color.GREEN, false));
        
        coins.add(new Coin(150, 120));
        coins.add(new Coin(360, 280));
        coins.add(new Coin(550, 120));
        
        exitDoor = new ExitDoor(640, 50);
    }
}
}
