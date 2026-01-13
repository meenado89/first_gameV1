public class Enemy {
    package com.falserules.game.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Enemy extends GameObject {
    private float speed = 100f;
    private float minX, maxX;
    private boolean movingRight = true;
    private boolean canBeStopped = true;
    
    public Enemy(float x, float y, float minX, float maxX, Color shellColor, boolean canBeStopped) {
        this.bounds = new Rectangle(x, y, 30, 30);
        this.color = shellColor;
        this.minX = minX;
        this.maxX = maxX;
        this.canBeStopped = canBeStopped;
    }
    
    public void update(float delta) {
        if (!active) return;
        
        if (movingRight) {
            bounds.x += speed * delta;
            if (bounds.x > maxX) {
                bounds.x = maxX;
                movingRight = false;
            }
        } else {
            bounds.x -= speed * delta;
            if (bounds.x < minX) {
                bounds.x = minX;
                movingRight = true;
            }
        }
    }
    
    public boolean canBeStopped() { return canBeStopped; }
    public void stomp() { if (canBeStopped) active = false; }
    
    @Override
    public void render(ShapeRenderer shapeRenderer) {
        if (active) {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(color);
            shapeRenderer.rect(bounds.x, bounds.y, bounds.width, bounds.height);
            
            shapeRenderer.setColor(Color.BLACK);
            shapeRenderer.circle(bounds.x + 8, bounds.y + 20, 3);
            shapeRenderer.circle(bounds.x + 22, bounds.y + 20, 3);
            shapeRenderer.end();
        }
    }
}
}
