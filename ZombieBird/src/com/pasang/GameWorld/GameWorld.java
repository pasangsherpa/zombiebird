package com.pasang.GameWorld;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.pasang.GameObjects.Bird;
import com.pasang.GameObjects.ScrollHandler;
import com.pasang.Helpers.AssetLoader;

public class GameWorld {

	private Bird bird;
	private ScrollHandler scroller;
	private Rectangle ground;
	private int score = 0;
	private int midPointY;
	private GameState currentState;

	public enum GameState {
		READY, RUNNING, GAMEOVER
	}

	public GameWorld(int midPointY) {
		this.midPointY = midPointY;
		currentState = GameState.READY;
		bird = new Bird(33, midPointY - 5, 17, 12);
		scroller = new ScrollHandler(this, midPointY + 66);
		ground = new Rectangle(0, midPointY + 66, 136, 11);
	}

	public void start() {
		currentState = GameState.RUNNING;
	}

	public void update() {
		switch (currentState) {
		case READY:

			break;
		case RUNNING:

			break;
		default:
			break;
		}
	}

	public void updateReady(float delta) {

	}

	public void updateRunning(float delta) {

		delta = delta > 0.15f ? 0.15f : delta;

		bird.update(delta);
		scroller.update(delta);

		if (scroller.collides(bird) && bird.isAlive()) {
			scroller.stop();
			bird.die();
			AssetLoader.dead.play();
		}

		if (Intersector.overlaps(bird.getBoundingCircle(), ground)) {
			scroller.stop();
			bird.die();
			bird.decelerate();
			currentState = GameState.GAMEOVER;
		}
	}

	public void restart() {
		currentState = GameState.READY;
		score = 0;
		bird.onRestart(midPointY - 5);
		scroller.onRestart();
		currentState = GameState.READY;
	}

	public void addScore(int increment) {
		score += increment;
	}

	public Bird getBird() {
		return bird;
	}

	public ScrollHandler getScroller() {
		return scroller;
	}

	public int getScore() {
		return score;
	}

	public boolean isGameOver() {
		return currentState == GameState.GAMEOVER;
	}

	public boolean isReady() {
		return currentState == GameState.READY;
	}

}
