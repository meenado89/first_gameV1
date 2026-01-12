public package com.falserules.game.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

abstract class GameObject {
    protected Rectangle bounds;
    protected Color color;
    protected boolean active = true;
    
    public Rectangle getBounds() { return bounds; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    
    public abstract void render(ShapeRenderer shapeRenderer); {
    
}
