package BrickBreaker;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class map {
public int map[][];
public int Height;
public int width;
public map(int row,int col){
	map=new int[row][col];
	for(int x=0;x<map.length;x++){
		for(int j=0;j<map[0].length;j++){
			map[x][j]=1;
			
		}
	}
	width=540/col;
	Height=150/row;
	
}
public void draw(Graphics2D g){
	for(int x=0;x<map.length;x++){
		for(int j=0;j<map[0].length;j++){
			if(map[x][j]>0){
				g.setColor(Color.WHITE);
				g.fillRect(j*width+80, x*Height+50,width,Height);
				g.setStroke(new BasicStroke(3));
				g.setColor(Color.black);
				g.drawRect(j*width+80, x*Height+50,width,Height);
			}
			
		}
}
}
	public void setbrickvalue(int value,int row,int col){
		map[row][col]=value;
		
		
	
}
}
