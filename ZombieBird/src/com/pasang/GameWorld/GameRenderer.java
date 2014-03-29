package com.pasang.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameRenderer {

	private GameWorld world;
	private OrthographicCamera camera;
	private ShapeRenderer shapeRenderer;

	public GameRenderer(GameWorld world) {
		
		this.world = world;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 136, 204);
		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(camera.combined);
	}

	public void render() {
		System.out.println("GameRenderer - render");

		// Draw black background to prevent flickering.
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);



	}

}
