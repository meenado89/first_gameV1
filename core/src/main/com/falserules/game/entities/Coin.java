public package com.falserules.game.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Coin extends GameObject {
    private boolean collected = false;
    
    public Coin(float x, float y, Color color) {
        this.bounds = new Rectangle(x, y, 20, 20);
        this.color = color;
    }
    
    public Coin(float x, float y) {
        this(x, y, Color.YELLOW);
    }
    
    public void collect() {
        collected = true;
        active = false;
    }
    
    public boolean isCollected() {
        return collected;
    }
    
    @Override
    public void render(ShapeRenderer shapeRenderer) {
        if (!collected) {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(color);
            shapeRenderer.circle(bounds.x + bounds.width/2, bounds.y + bounds.height/2, bounds.width/2);
            shapeRenderer.end();
        }
    }
} {
    
}
