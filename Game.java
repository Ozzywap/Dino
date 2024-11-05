import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements KeyListener {
	// constants
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 400;
	public static final int GROUND_HEIGHT = 250;

	private boolean running = false;
	private Player player;
	private ObstacleHandler obstacleHandler;

	public Game() {
		// empty constructor for now, we'll use it later
		player = new Player();
		obstacleHandler = new ObstacleHandler();

		addKeyListener(this);
	}

	public static void main(String[] args) {
		// main method
		new GameWindow(GAME_WIDTH, GAME_HEIGHT, "Dino Game",
			new Game());
	}

	public synchronized void start() {
		// where we'll put the game loop
		long lastTime = System.nanoTime();
		double amountOfTicks = 100.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;

		running = true;

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			while (delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;

			// this prints the tick and frame rate to the console
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("fps: " + frames + " ticks: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		// draw things here
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		g.setColor(Color.BLACK);
		g.drawLine(0, GROUND_HEIGHT, GAME_WIDTH, GROUND_HEIGHT);
		g.drawOval(GAME_WIDTH/2, GAME_HEIGHT/2, 10, 10);
		player.render(g, this);
		obstacleHandler.render(g, this);
		g.dispose();
		bs.show();
	}

	private void tick(){
		player.tick();
		obstacleHandler.tick();
		detectCollisions();
	}

	private void detectCollisions() {
		for (Obstacle obstacle : obstacleHandler.getObstacles()) {
			if (player.getHitBox().intersects(obstacle.getHitBox())) {
				running = false;
				return;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_SPACE) {
			player.jumpAction();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
