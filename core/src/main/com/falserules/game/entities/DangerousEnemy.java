public class DangerousEnemy {
    package com.falserules.game.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class DangerousEnemy extends Enemy {
    public DangerousEnemy(float x, float y, float minX, float maxX) {
        super(x, y, minX, maxX, Color.GREEN, false);
    }
    
    @Override
    public void render(ShapeRenderer shapeRenderer) {
        if (isActive()) {
            super.render(shapeRenderer);
            
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            shapeRenderer.setColor(Color.BLACK);
            Rectangle b = getBounds();
            shapeRenderer.line(b.x, b.y, b.x + 10, b.y - 10);
            shapeRenderer.line(b.x + b.width, b.y, b.x + b.width - 10, b.y - 10);
            shapeRenderer.end();
        }
    }
}
}
