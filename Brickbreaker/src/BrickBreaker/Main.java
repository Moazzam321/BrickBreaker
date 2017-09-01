package BrickBreaker;
import javax.swing.JFrame;


public class Main {

	public static void main(String[] args) {
		JFrame obj=new JFrame();
		obj.setBounds(10,10,700,600);
		Gameplay gamePlay=new Gameplay();
		
		obj.setVisible(true);
		obj.setResizable(false);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.setTitle("BrickBreaker");
		obj.add(gamePlay);
		gamePlay.requestFocus();
		
	}

}
