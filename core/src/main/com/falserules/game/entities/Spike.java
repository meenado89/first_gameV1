public class Spike {
    package com.falserules.game.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Spike extends GameObject {
    private boolean isDeadly;
    
    public Spike(float x, float y, float width, float height, boolean isDeadly) {
        this.bounds = new Rectangle(x, y, width, height);
        this.color = Color.RED;
        this.isDeadly = isDeadly;
    }
    
    public boolean isDeadly() { return isDeadly; }
    public void setDeadly(boolean deadly) { this.isDeadly = deadly; }
    
    @Override
    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        
        float spikeWidth = 20f;
        int numSpikes = (int)(bounds.width / spikeWidth);
        
        for (int i = 0; i < numSpikes; i++) {
            float x1 = bounds.x + i * spikeWidth;
            float x2 = x1 + spikeWidth / 2;
            float x3 = x1 + spikeWidth;
            float y1 = bounds.y;
            float y2 = bounds.y + bounds.height;
            
            shapeRenderer.triangle(x1, y1, x2, y2, x3, y1);
        }
        
        shapeRenderer.end();
    }
}

}
