public class ExitDoor {
    package com.falserules.game.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class ExitDoor extends GameObject {
    private boolean locked = true;
    
    public ExitDoor(float x, float y) {
        this.bounds = new Rectangle(x, y, 50, 80);
        this.color = Color.GREEN;
    }
    
    public boolean isLocked() { return locked; }
    public void unlock() { 
        locked = false;
        color = Color.CYAN;
    }
    
    @Override
    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(locked ? Color.DARK_GRAY : color);
        shapeRenderer.rect(bounds.x, bounds.y, bounds.width, bounds.height);
        
        if (locked) {
            shapeRenderer.setColor(Color.RED);
            shapeRenderer.circle(bounds.x + bounds.width/2, bounds.y + bounds.height/2, 10);
        }
        
        shapeRenderer.end();
    }
}
}
