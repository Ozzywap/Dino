import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.Random;

public class Cloud extends GameObject{

	public Cloud() {
		super(Game.GAME_WIDTH,
			Game.GAME_HEIGHT / 4 - (new Random().nextInt(50)));
		sprite = loadSprite("assets/cloud.png");
	}

	@Override
	public void render(Graphics g, ImageObserver observer) {

		g.drawImage(sprite, (int) x, (int) y - sprite.getHeight(),
			observer);
	}
}
