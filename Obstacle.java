import java.util.ArrayList;
import java.util.Random;

public class Obstacle extends GameObject{

	private ArrayList<String> spritePaths = new ArrayList<>();

	public Obstacle() {
		super(Game.GAME_WIDTH, Game.GROUND_HEIGHT);

		spritePaths.add("assets/cactus1.png");
		spritePaths.add("assets/cactus2.png");
		spritePaths.add("assets/cactus3.png");

		sprite = loadSprite(spritePaths.get(new Random().nextInt(spritePaths.size())));
	}
}
