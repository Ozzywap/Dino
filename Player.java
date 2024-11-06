import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Player extends GameObject{

	private boolean jumping = false;
	private BufferedImage deadDinoSprite;
	private boolean alive = true;

	public Player() {
		super(50, Game.GROUND_HEIGHT);
		sprite = loadSprite("assets/dino.png");
		deadDinoSprite = loadSprite("assets/dead.png");
	}

	@Override
	public void tick() {
		if (jumping && y + dy > Game.GROUND_HEIGHT) {
			// stop falling when the dinosaur touches the ground
			y = Game.GROUND_HEIGHT;
			dy = 0;
			jumping = false;
		} else if (jumping) {
			// this imitates gravity
			dy += 0.3f;
		}
		y += dy;
		x += dx;
	}

	@Override
	public void render(Graphics g, ImageObserver observer){
		if(alive){
			g.drawImage(sprite, (int) x, (int) y - sprite.getHeight(), observer);
		} else{
			g.drawImage(deadDinoSprite, (int) x, (int) y - deadDinoSprite.getHeight(),
				observer);
		}
	}

	public void jumpAction() {
		if (!jumping) {
			jumping = true;
			dy = -8;
		}
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}
