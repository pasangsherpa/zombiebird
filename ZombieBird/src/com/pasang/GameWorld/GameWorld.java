package com.pasang.GameWorld;

import com.pasang.GameObjects.Bird;
import com.pasang.GameObjects.ScrollHandler;

public class GameWorld {

	private Bird bird;
	private ScrollHandler scoller;

	public GameWorld(int midPointY) {
		bird = new Bird(33, midPointY - 5, 17, 12);
		scoller = new ScrollHandler(midPointY + 66);
	}

	public void update(float delta) {
		bird.update(delta);
		scoller.update(delta);
	}

	public Bird getBird() {
		return bird;
	}

	public ScrollHandler getScroller() {
		return scoller;
	}

}
