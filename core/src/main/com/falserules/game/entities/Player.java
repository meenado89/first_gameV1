public class Player {
    package com.falserules.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player implements GestureDetector.GestureListener {
    private Vector2 position;
    private Vector2 velocity;
    private Rectangle bounds;
    
    private static final float MOVE_SPEED = 400f;
    private static final float JUMP_FORCE = -600f;
    private static final float GRAVITY = 1800f;
    private static final float MAX_FALL_SPEED = 800f;
    private static final float FRICTION = 0.85f;
    
    private static final float WIDTH = 32f;
    private static final float HEIGHT = 32f;
    
    private boolean isOnGround = false;
    private boolean canJump = true;
    private boolean isDead = false;
    private boolean isCrouching = false;
    
    private Color color = Color.BLUE;
    
    public Player(float x, float y) {
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        bounds = new Rectangle(x, y, WIDTH, HEIGHT);
    }
    
    public void update(float delta) {
        if (isDead) return;
        
        if (!isOnGround) {
            velocity.y += GRAVITY * delta;
            if (velocity.y > MAX_FALL_SPEED) {
                velocity.y = MAX_FALL_SPEED;
            }
        } else {
            velocity.y = 0;
        }
        
        position.x += velocity.x * delta;
        position.y += velocity.y * delta;
        
        if (isOnGround) {
            velocity.x *= FRICTION;
        }
        
        float height = isCrouching ? HEIGHT / 2 : HEIGHT;
        bounds.set(position.x, position.y, WIDTH, height);
        
        if (position.x < 0) position.x = 0;
        if (position.x > 720 - WIDTH) position.x = 720 - WIDTH;
        
        isOnGround = false;
    }
    
    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        shapeRenderer.rect(bounds.x, bounds.y, bounds.width, bounds.height);
        shapeRenderer.end();
    }
    
    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        if (isDead) return false;
        
        float absX = Math.abs(velocityX);
        float absY = Math.abs(velocityY);
        
        if (absY > absX && absY > 500) {
            if (velocityY < 0) {
                jump();
            } else {
                crouch();
            }
        } else if (absX > 500) {
            if (velocityX > 0) {
                moveRight();
            } else {
                moveLeft();
            }
        }
        
        return true;
    }
    
    public void moveRight() {
        velocity.x = MOVE_SPEED;
    }
    
    public void moveLeft() {
        velocity.x = -MOVE_SPEED;
    }
    
    public void jump() {
        if (isOnGround && canJump && !isCrouching) {
            velocity.y = JUMP_FORCE;
            isOnGround = false;
        }
    }
    
    public void crouch() {
        isCrouching = true;
    }
    
    public void standUp() {
        isCrouching = false;
    }
    
    public void landOnPlatform(float platformTop) {
        if (velocity.y >= 0) {
            position.y = platformTop;
            velocity.y = 0;
            isOnGround = true;
            isCrouching = false;
        }
    }
    
    public void die() {
        isDead = true;
        color = Color.RED;
    }
    
    public void reset(float x, float y) {
        position.set(x, y);
        velocity.set(0, 0);
        isDead = false;
        isCrouching = false;
        isOnGround = false;
        color = Color.BLUE;
    }
    
    public Rectangle getBounds() { return bounds; }
    public boolean isDead() { return isDead; }
    public boolean isOnGround() { return isOnGround; }
    public void setOnGround(boolean onGround) { this.isOnGround = onGround; }
    public Vector2 getPosition() { return position; }
    public float getX() { return position.x; }
    public float getY() { return position.y; }
    public boolean isCrouching() { return isCrouching; }
    
    @Override public boolean touchDown(float x, float y, int pointer, int button) { return false; }
    @Override public boolean tap(float x, float y, int count, int button) { return false; }
    @Override public boolean longPress(float x, float y) { return false; }
    @Override public boolean pan(float x, float y, float deltaX, float deltaY) { return false; }
    @Override public boolean panStop(float x, float y, int pointer, int button) { return false; }
    @Override public boolean zoom(float initialDistance, float distance) { return false; }
    @Override public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) { return false; }
    @Override public void pinchStop() {}
}
}
