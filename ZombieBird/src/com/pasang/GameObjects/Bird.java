package com.pasang.GameObjects;

import com.badlogic.gdx.math.Vector2;

public class Bird {

	private Vector2 position;
	private Vector2 velocity;
	private Vector2 acceleration;

	private float rotation; // bird rotation
	private int height;
	private int width;

	public Bird(float x, float y, int width, int height) {
		
		this.width = width;
		this.height = height;
		
		position = new Vector2(x, y);
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, 460);
	}

	public void update(float delta) {
		velocity.add(acceleration.cpy().scl(delta));
		velocity.y = velocity.y > 200 ? 200 : velocity.y;
		position.add(velocity.cpy().scl(delta));
	}

	public void onClick() {
		velocity.y = -140;
	}

	public float getRotation() {
		return rotation;
	}

	public float getY() {
		return position.y;
	}

	public float getX() {
		return position.x;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

}
