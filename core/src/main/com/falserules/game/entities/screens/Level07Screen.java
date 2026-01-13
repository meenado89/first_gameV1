public class Level07Screen {
    package com.falserules.game.screens;

import com.badlogic.gdx.graphics.Color;
import com.falserules.game.FalseRulesGame;
import com.falserules.game.entities.*;

public class Level07Screen extends BaseLevel {
    public Level07Screen(FalseRulesGame game) {
        super(game);
    }
    
    @Override
    protected void createLevel() {
        spawnX = 100f;
        spawnY = 200f;
        
        platforms.add(new Platform(0, 50, WORLD_WIDTH, 50, Color.GREEN, true));
        
        enemies.add(new Enemy(200, 100, 150, 300, Color.RED, true));
        enemies.add(new DangerousEnemy(450, 100, 400, 600));
        
        coins.add(new Coin(320, 200));
        coins.add(new Coin(280, 160));
        coins.add(new Coin(360, 160));
        coins.add(new Coin(320, 140));
        coins.add(new Coin(300, 120));
        coins.add(new Coin(340, 120));
        
        exitDoor = new ExitDoor(640, 100);
    }
}
}
