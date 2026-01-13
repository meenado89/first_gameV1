public class Level09Screen {
    package com.falserules.game.screens;

import com.badlogic.gdx.graphics.Color;
import com.falserules.game.FalseRulesGame;
import com.falserules.game.entities.*;

public class Level09Screen extends BaseLevel {
    public Level09Screen(FalseRulesGame game) {
        super(game);
    }
    
    @Override
    protected void createLevel() {
        spawnX = 100f;
        spawnY = 400f;
        
        spikes.add(new Spike(0, 0, 200, 50, false));
        spikes.add(new Spike(250, 100, 150, 40, false));
        
        platforms.add(new Platform(200, 200, 100, 30, Color.GREEN, false));
        platforms.add(new Platform(400, 300, 100, 30, Color.GREEN, false));
        
        platforms.add(new Platform(0, 300, 80, 30, Color.GREEN, true));
        platforms.add(new Platform(550, 150, 100, 30, Color.GREEN, true));
        
        enemies.add(new Enemy(250, 50, 200, 350, Color.RED, true));
        enemies.add(new DangerousEnemy(450, 330, 400, 550));
        
        coins.add(new Coin(50, 380));
        coins.add(new DeadlyCoin(240, 280));
        coins.add(new Coin(450, 380));
        coins.add(new GlowingCoin(600, 230));
        coins.add(new Coin(150, 120));
        coins.add(new DeadlyCoin(350, 180));
        coins.add(new Coin(590, 380));
        
        arrows.add(new Arrow(50, 250, false));
        
        spikes.add(new Spike(650, 0, 70, 200, false));
        exitDoor = new ExitDoor(655, 50);
    }
}
}
