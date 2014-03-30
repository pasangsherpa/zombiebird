package com.pasang;

import com.badlogic.gdx.Game;
import com.pasang.Helpers.AssetLoader;
import com.pasang.Screens.GameScreen;

public class ZBGame extends Game {

	@Override
	public void create() {
		AssetLoader.load();
		setScreen(new GameScreen());
	}
	
	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}
}
