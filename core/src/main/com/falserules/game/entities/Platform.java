public class Platform {
    package com.falserules.game.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Platform extends GameObject {
    private boolean isSafe;
    
    public Platform(float x, float y, float width, float height, Color color, boolean isSafe) {
        this.bounds = new Rectangle(x, y, width, height);
        this.color = color;
        this.isSafe = isSafe;
    }
    
    public boolean isSafe() { return isSafe; }
    public void setSafe(boolean safe) { this.isSafe = safe; }
    
    @Override
    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        shapeRenderer.rect(bounds.x, bounds.y, bounds.width, bounds.height);
        shapeRenderer.end();
    }
}

}
