public class Level06Screen {
    package com.falserules.game.screens;

import com.badlogic.gdx.graphics.Color;
import com.falserules.game.FalseRulesGame;
import com.falserules.game.entities.*;

public class Level06Screen extends BaseLevel {
    public Level06Screen(FalseRulesGame game) {
        super(game);
    }
    
    @Override
    protected void createLevel() {
        spawnX = 360f;
        spawnY = 300f;
        
        platforms.add(new Platform(300, 200, 150, 40, Color.GREEN, true));
        platforms.add(new Platform(150, 150, 100, 30, Color.GREEN, true));
        platforms.add(new Platform(50, 100, 80, 30, Color.GREEN, true));
        
        spikes.add(new Spike(450, 0, 270, 50, false));
        
        arrows.add(new Arrow(340, 280, false));
        
        coins.add(new Coin(190, 230));
        coins.add(new Coin(550, 120));
        coins.add(new Coin(650, 120));
        
        exitDoor = new ExitDoor(650, 50);
    }
}
}
