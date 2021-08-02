import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject{

	boolean up, down, left, right;
	int speed = 5;
	
	Player(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	public void update() {
		if(up) {
			y -= speed;
		}
		if(down) {
			y += speed;
		}
		if(left) {
			x -= speed;
		}
		if(right) {
			x += speed;
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, w, h);
	}

}
