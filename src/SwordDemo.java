import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SwordDemo extends JPanel implements ActionListener, KeyListener{
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	
	JFrame window;
	Timer timer;
	

	Player player = new Player(100, 100, 100, 100);
	Sword sword = new Sword(100, 100, 25, 25, player);
	
	SwordDemo(){
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		window = new JFrame();
		window.add(this);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.addKeyListener(this);
		timer = new Timer(1000 / 60, this);
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(new Color(200, 200, 200));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		player.draw(g);
		sword.draw(g);
	}
	
	public static void main(String[] args) {
		new SwordDemo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
		sword.update();
		repaint();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {
			player.up = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			player.down = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			player.left = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			player.right = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			sword.targetY = player.y + player.h / 2;
			sword.targetX = player.x + player.w / 2 + 300;
			sword.currentState = sword.moveState;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {
			player.up = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			player.down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			player.left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			player.right = false;
		}
		
	}
}
