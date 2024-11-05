public class Player extends GameObject{

	private boolean jumping = false;

	public Player() {
		super(50, Game.GROUND_HEIGHT);
		sprite = loadSprite("assets/dino.png");
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

	public void jumpAction() {
		if (!jumping) {
			jumping = true;
			dy = -8;
		}
	}
}
