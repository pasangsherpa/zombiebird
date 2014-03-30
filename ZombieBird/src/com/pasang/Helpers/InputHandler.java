package com.pasang.Helpers;

import com.badlogic.gdx.InputProcessor;
import com.pasang.GameObjects.Bird;
import com.pasang.GameWorld.GameWorld;

public class InputHandler implements InputProcessor {

	private GameWorld world;
	private Bird bird;
	
	public InputHandler(GameWorld world) {
		this.world = world;
		this.bird = world.getBird();
	}
	
	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if (world.isReady()) {
			world.start();
		}
		bird.onClick();
		
		if (world.isGameOver()) {
			world.restart();
		}
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
