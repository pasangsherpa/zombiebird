package com.pasang;

import com.badlogic.gdx.Game;
import com.pasang.Screens.GameScreen;

public class ZBGame extends Game {

	@Override
	public void create() {
		System.out.println("Game Created..");
		setScreen(new GameScreen());
	}
}
