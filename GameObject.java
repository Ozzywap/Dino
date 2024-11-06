import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class GameObject {

	protected float x, y;
	protected float dx, dy;
	protected BufferedImage sprite;

	public GameObject(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public void tick() {
		x += dx;
		y += dy;
	};

	public void render(Graphics g, ImageObserver observer) {
		// we subtract the sprite height because the coordinate system starts at the top-left
		// mapping out hit box
//		g.setColor(Color.blue);
//		g.drawRect((int) x, (int) y - sprite.getHeight(), sprite.getWidth(),
//			sprite.getHeight());
		g.drawImage(sprite, (int) x, (int) y - sprite.getHeight(), observer);
	}

	public static BufferedImage loadSprite(String imgPath) {
		try {
			return ImageIO.read(new File(imgPath));
		} catch (IOException exc) {
			System.out.println("Error opening image file: " + exc.getMessage());
		}
		return null;
	}

	public Rectangle getHitBox() {
		Rectangle hitBox = new Rectangle(sprite.getWidth(), sprite.getHeight());
		hitBox.setLocation((int) x, (int) y - sprite.getHeight());
		return hitBox;
	}

	public void setX(float x) {
		this.x = x;
	}
}
