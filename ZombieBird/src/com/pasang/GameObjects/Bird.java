package com.pasang.GameObjects;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.pasang.Helpers.AssetLoader;

public class Bird {

	private Vector2 position;
	private Vector2 velocity;
	private Vector2 acceleration;

	private float rotation; // bird rotation
	private int height;
	private int width;

	private Circle boundingCircle;

	private boolean isAlive;

	public Bird(float x, float y, int width, int height) {

		this.width = width;
		this.height = height;

		position = new Vector2(x, y);
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, 460);

		boundingCircle = new Circle();

		isAlive = true;
	}

	public void update(float delta) {
		velocity.add(acceleration.cpy().scl(delta));
		velocity.y = velocity.y > 200 ? 200 : velocity.y;
		position.add(velocity.cpy().scl(delta));

		boundingCircle.set(position.x + 9, position.y + 6, 6.5f);

		// Rotate counterclockwise
		if (velocity.y < 0) {
			rotation -= 600 * delta;
			if (rotation < -20) {
				rotation = -20;
			}
		}

		// Rotate counterclockwise
		if (isFalling() || !isAlive) {
			rotation += 480 * delta;
			if (rotation > 90) {
				rotation = 90;
			}
		}
	}

	public void onClick() {
		if (isAlive) {
			AssetLoader.flap.play();
			velocity.y = -140;
		}
	}

	public void die() {
		isAlive = false;
		velocity.y = 0;
	}

	public void decelerate() {
		acceleration.y = 0;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public boolean isFalling() {
		return velocity.y > 110;
	}

	public boolean shouldntFlap() {
		return velocity.y > 70 || !isAlive;
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

	public Circle getBoundingCircle() {
		return boundingCircle;
	}

}
