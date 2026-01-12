public class GlowingCoin {
    package com.falserules.game.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GlowingCoin extends Coin {
    private float glowTimer = 0;
    
    public GlowingCoin(float x, float y) {
        super(x, y, Color.WHITE);
    }
    
    @Override
    public void render(ShapeRenderer shapeRenderer) {
        if (!isCollected()) {
            glowTimer += 0.05f;
            float alpha = (float) (Math.sin(glowTimer) * 0.3f + 0.7f);
            
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            Color glowColor = new Color(1, 1, 1, alpha);
            shapeRenderer.setColor(glowColor);
            shapeRenderer.circle(getBounds().x + getBounds().width/2, getBounds().y + getBounds().height/2, getBounds().width/2 + 3);
            shapeRenderer.setColor(Color.WHITE);
            shapeRenderer.circle(getBounds().x + getBounds().width/2, getBounds().y + getBounds().height/2, getBounds().width/2);
            shapeRenderer.end();
        }
    }
}
}
