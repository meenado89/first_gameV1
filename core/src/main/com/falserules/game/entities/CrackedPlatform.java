public class CrackedPlatform {
    package com.falserules.game.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class CrackedPlatform extends Platform {
    public CrackedPlatform(float x, float y, float width, float height, boolean isSafe) {
        super(x, y, width, height, Color.GREEN, isSafe);
    }
    
    @Override
    public void render(ShapeRenderer shapeRenderer) {
        super.render(shapeRenderer);
        
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.BLACK);
        float midX = getBounds().x + getBounds().width / 2;
        shapeRenderer.line(midX, getBounds().y, midX - 10, getBounds().y + getBounds().height);
        shapeRenderer.line(midX, getBounds().y, midX + 10, getBounds().y + getBounds().height);
        shapeRenderer.end();
    }
}

}
