package com.pasang.GameWorld;

import com.pasang.GameObjects.Bird;
import com.pasang.GameObjects.ScrollHandler;
import com.pasang.Helpers.AssetLoader;

public class GameWorld {

	private Bird bird;
	private ScrollHandler scroller;
	private boolean isAlive;

	public GameWorld(int midPointY) {
		bird = new Bird(33, midPointY - 5, 17, 12);
		scroller = new ScrollHandler(midPointY + 66);
	}

	public void update(float delta) {
		bird.update(delta);
		scroller.update(delta);

		if (scroller.collides(bird)) {
			scroller.stop();
			AssetLoader.dead.play();
			isAlive = false;
		}
	}

	public Bird getBird() {
		return bird;
	}

	public ScrollHandler getScroller() {
		return scroller;
	}

	public boolean isAlive() {
		return isAlive;
	}

}
