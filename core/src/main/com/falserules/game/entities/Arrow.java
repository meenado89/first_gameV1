public class Arrow {
    package com.falserules.game.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Arrow extends GameObject {
    private boolean pointsRight;
    
    public Arrow(float x, float y, boolean pointsRight) {
        this.bounds = new Rectangle(x, y, 40, 30);
        this.color = Color.YELLOW;
        this.pointsRight = pointsRight;
    }
    
    @Override
    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        
        float x = bounds.x;
        float y = bounds.y;
        
        if (pointsRight) {
            shapeRenderer.triangle(x, y, x, y + 30, x + 40, y + 15);
        } else {
            shapeRenderer.triangle(x + 40, y, x + 40, y + 30, x, y + 15);
        }
        
        shapeRenderer.end();
    }
}
}
