public class Cloud extends GameObject{

	public Cloud() {
		super(Game.GAME_WIDTH, Game.GAME_HEIGHT / 4);

		sprite = loadSprite("assets/cloud.png");
	}
}
