public class Level08Screen {
    package com.falserules.game.screens;

import com.badlogic.gdx.graphics.Color;
import com.falserules.game.FalseRulesGame;
import com.falserules.game.entities.*;

public class Level08Screen extends BaseLevel {
    public Level08Screen(FalseRulesGame game) {
        super(game);
    }
    
    @Override
    protected void createLevel() {
        spawnX = 360f;
        spawnY = 300f;
        
        platforms.add(new Platform(300, 200, 150, 40, Color.GREEN, true));
        
        spikes.add(new Spike(50, 0, 200, 50, false));
        
        platforms.add(new Platform(500, 200, 80, 30, Color.GREEN, false));
        platforms.add(new CrackedPlatform(600, 150, 80, 30, false));
        platforms.add(new Platform(650, 100, 70, 30, Color.GREEN, false));
        
        coins.add(new Coin(540, 280));
        coins.add(new Coin(150, 120));
        coins.add(new Coin(680, 180));
        
        exitDoor = new ExitDoor(640, 50);
    }
}
}
