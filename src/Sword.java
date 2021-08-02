import java.awt.Color;
import java.awt.Graphics;

public class Sword extends GameObject{
	int targetX;
	int targetY;
	int speed = 10;
	Player player;
	
	int followState = 0;
	int moveState = 1;
	int pauseState = 2;
	int currentState = followState;
	boolean returningToPlayer = false;
	
	long pauseStartTime;
	
	Sword(int x, int y, int w, int h, Player player) {
		super(x, y, w, h);
		this.player = player;
	}
	
	public void update() {
		if(currentState == followState) {
			x = player.x + player.w / 2;
			y = player.y + player.h / 2;
		}else if(currentState == moveState) {
			if(returningToPlayer) {
				targetX = player.x + player.w / 2;
				targetY = player.y + player.h / 2;
				if(x < targetX) {
					x += speed;
				}else if(x > targetX){
					x -= speed;
				}
				if(y < targetY) {
					y += speed;
				}else if(y > targetY){
					y -= speed;
				}
				
				if(targetX == x && targetY == y) {
					currentState = followState;
					returningToPlayer = false;
				}
				
			}else {
				if(x < targetX) {
					x += speed;
				}else if(x > targetX){
					x -= speed;
				}else {
					returningToPlayer = true;
					pauseStartTime = System.currentTimeMillis();
					currentState = pauseState;
				}
				
			}
				
				
		}else if(currentState == pauseState) {
			if(System.currentTimeMillis() - pauseStartTime > 1000) {
				System.out.println("pauseState time expired");
				currentState = moveState;
				targetX = player.x + player.w / 2;
				targetY = player.y + player.h / 2;
			}
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, w, h);
		
	}

}
