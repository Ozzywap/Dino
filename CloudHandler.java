import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Random;

public class CloudHandler {

	private ArrayList<Cloud> clouds = new ArrayList<>();

	private float dx = -3;
	private float ddx = -0.001f;

	private long lastObst;
	private Random random = new Random();

	public void tick() {
		double rand = random.nextDouble();

		if (rand < 0.01 && System.currentTimeMillis() - lastObst > 600) {
			clouds.add(new Cloud());
			lastObst = System.currentTimeMillis();
		}

		for (Cloud cloud : clouds) {
			cloud.dx = dx;
			cloud.tick();

			if (cloud.x < -100) {
				clouds.remove(cloud);
				break;
			}
		}
		dx += ddx;
	}

	public void render(Graphics g, ImageObserver observer) {
		for (Cloud cloud : clouds) {
			cloud.render(g, observer);
		}
	}

	public ArrayList<Cloud> getClouds() {
		return new ArrayList<>(clouds);
	}

}
