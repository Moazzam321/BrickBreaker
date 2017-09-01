package BrickBreaker;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;




import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener,ActionListener {

	
	private Timer time;
	private boolean play=false;
	private int delay=15;
	private int score=0;
	private int bricks=21;
	
	
	
	
	private int playerX=310;
	private int ballPosX=280;
	private int ballPosY=350;
	private int ballDirX=-3;
	private int ballDirY=-3;
	private map map;
	
	
	public Gameplay(){
		
		System.out.println("SADf23");
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		time=new Timer(delay,this);
		map=new map(3,7);
		time.start();
		
		
	}
	
	
	public void paint(Graphics g){
		g.setColor(Color.black);
		g.fillRect(1,1, 692, 592);
		System.out.println("SADf");
		
		g.setColor(Color.yellow);
		g.fillRect(0,0, 3, 592);
		g.fillRect(0,0, 692, 3);
		g.fillRect(691,0, 3, 592);
		map.draw((Graphics2D)g);
		g.setColor(Color.green);
		g.fillRect(playerX,550, 100,8);
		
		g.setColor(Color.yellow);
		g.fillOval(ballPosX,ballPosY,20,20);
		g.dispose();
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		time.start();
		if(play==true){
			if(new Rectangle(ballPosX,ballPosY,20,20).intersects(new Rectangle(playerX,550,100,8))){
				ballDirY= -ballDirY;
				
			}
			A:for(int x=0;x<map.map.length;x++){
				for(int j=0;j<map.map[0].length;j++){
					if(map.map[x][j]>0){
						int brickx=j*map.width+80;
						int bricky=x*map.Height+50;
						int width=map.width;
						int height=map.Height;
						Rectangle rect=new Rectangle(brickx,bricky,width,height);
						Rectangle ballrect=new Rectangle(ballPosX,ballPosY,20,20);
						Rectangle brickrect=rect;
						if(ballrect.intersects(brickrect)){
							map.setbrickvalue(0, x,j);
							bricks--;
							score+=5;
							if(ballPosX+19<=brickrect.x ||ballPosX+1<=brickrect.x+brickrect.width){
								ballDirX=-ballDirX;
								
							}
							else{
								ballDirY=-ballDirY;
								
							}
								break A;
								
						}
						
					}
				}
			}
			ballPosX+= ballDirX;
			ballPosY-= ballDirY;
			if(ballPosX<0){
				ballDirX= -ballDirX;
				
			}
			if(ballPosY<0){
				ballDirY= -ballDirY;
				
			}
			if(ballPosX>670){
				ballDirX= -ballDirX;
				
			}
		}
		repaint();
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("afas");
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			if(playerX>=600){
				playerX=600;
				
			}
			else{
				moveRight();
				System.out.println("wassip");
				
			}
		}
			if(e.getKeyCode()==KeyEvent.VK_LEFT){
			if(playerX<10){
				playerX=10;
				
			}
			else{
				moveLeft();
				
			}
			
			
	}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
		 System.out.println(e.toString());
		
	}
	public void moveRight(){
		play=true;
		playerX+=20;
		
	}
	public void moveLeft(){
		play=true;
		playerX-=20;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		 System.out.println(e.toString());
	}
}
	
