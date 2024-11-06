import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class GameOver {

	private Font font;
	private BufferedImage sprite;

	public GameOver(){
		sprite = GameObject.loadSprite("assets/resetbutton.png");
		font = loadFont("assets/font.ttf", 12);
	}

	public void render(Graphics g, ImageObserver observer){
		String msg = "GAME OVER";
		g.setFont(font);
		g.setColor(Color.black);
		g.drawString(msg, (int) Game.GAME_WIDTH / 2 - 40,
			Game.GAME_HEIGHT / 2 - 30);
		g.drawImage(sprite, Game.GAME_WIDTH / 2,
			Game.GAME_HEIGHT / 2 - sprite.getHeight(),
			observer);
	}

	public Font loadFont(String fontPath, float fontSize) {
		try {
			return Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(fontSize);
		} catch (IOException | FontFormatException e) {
			System.out.println("Font failed to load.");
		}
		return null;
	}
}
