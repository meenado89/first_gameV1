public class Level04Screen {
    package com.falserules.game.screens;

import com.badlogic.gdx.graphics.Color;
import com.falserules.game.FalseRulesGame;
import com.falserules.game.entities.*;

public class Level04Screen extends BaseLevel {
    public Level04Screen(FalseRulesGame game) {
        super(game);
    }
    
    @Override
    protected void createLevel() {
        spawnX = 100f;
        spawnY = 200f;
        
        platforms.add(new Platform(0, 50, WORLD_WIDTH, 50, Color.GREEN, true));
        spikes.add(new Spike(300, 0, 120, 50, true));
        
        coins.add(new Coin(200, 150));
        coins.add(new DeadlyCoin(360, 150));
        coins.add(new Coin(520, 150));
        
        exitDoor = new ExitDoor(640, 100);
    }
}
}
