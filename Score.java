import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Score{

	private int score;
	private int highScore;
	private Font font;
	private long lastUpdate;

	public Score() {
		font = loadFont("assets/font.ttf", 12);
		score = 0;
		highScore = 0;
	}

	public void tick(){
		if (System.currentTimeMillis() - lastUpdate > 100){
			lastUpdate = System.currentTimeMillis();
			score++;
		}
	}

	public void render(Graphics g, ImageObserver observer){
		g.setFont(font);
		g.setColor(Color.gray);
		g.drawString("HI " + pad(highScore), 590, 50);
		g.setColor(Color.black);
		g.drawString(pad(score), 705, 50);
	}

	public Font loadFont(String fontPath, float fontSize) {
		try {
			return Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(fontSize);
		} catch (IOException | FontFormatException e) {
			System.out.println("Font failed to load.");
		}
		return null;
	}

	public void clear(){
		if (score > highScore){
			highScore = score;
		}
		score = 0;
	}

	public String pad(int score){
		StringBuilder string = new StringBuilder(String.valueOf(score));
		while (string.length() < 5){
			string.insert(0, "0");
		}
		return string.toString();
	}
}
