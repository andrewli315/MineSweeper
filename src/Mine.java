import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import javax.swing.*;
public class Mine extends JFrame implements ActionListener{
	JFrame f;
	JButton[] bomb_arr = new JButton[49];
	Bomb[] bomb_map = new Bomb[49]; 
	public Mine(){
		
		f = new JFrame();
		for(int i=0;i<7;i++){
			for(int j=0;j<7;j++){
				bomb_arr[i*7+j] = new JButton();
				bomb_arr[i*7+j].setIcon(new ImageIcon("btnNor.bmp"));
				bomb_map[i*7+j] = new Bomb(i,j);
				bomb_map[i*7+j].flag = 0;
				if(i==0)
					bomb_map[i*7+j].flag = -1;
				if(j==0)
					bomb_map[i*7+j].flag = -1;
				if(i==6)
					bomb_map[i*7+j].flag = -1;
				if(j==6)
					bomb_map[i*7+j].flag = -1;
			}
		}
	
		
		//display();
		Statics();
		display();
		
		
		
		
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent arg0){
				System.exit(1);
			}
		});
		
	}
	private void Statics(){
		int count=0;
		for(int i=1;i<6;i++){
			for(int j=1;j<6;j++){
				int ii = i-1;
				int jj = j-1;
				if(bomb_map[ii*7+jj].bomb == true)
					count++;
				if(bomb_map[(ii+1)*7+jj].bomb == true)
					count++;
				if(bomb_map[(ii+2)*7+jj].bomb == true)
					count++;

				if(bomb_map[(ii+2)*7+jj+1].bomb == true)
					count++;

				if(bomb_map[(ii+2)*7+jj+2].bomb == true)
					count++;
				if(bomb_map[(ii+1)*7+jj+2].bomb == true)
					count++;
				if(bomb_map[ii*7+jj+2].bomb == true)
					count++;
				if(bomb_map[ii*7+jj+1].bomb == true)
					count++;			
				System.out.printf("%d ",count);
				bomb_map[i*7+j].count = count;
				count = 0;
			}
			count = 0;
			System.out.println("");
		}
	}
	private void Search(int i,int j){
		
	}
	private void display(){
		
		for(int i=0;i<49;i++){
			if(bomb_map[i].bomb == true)
				System.out.printf("* ");
			else if(bomb_map[i].flag != -1)
				System.out.printf("0 ");
			else
				System.out.printf("- ");
			if(i%7 == 6 && i != 0)
				System.out.println("");
		}
		for(int i=0;i<49;i++){
			if(bomb_map[i].bomb == true)
				System.out.printf("* ");
			else if(bomb_map[i].flag != -1)
				System.out.printf("%d ",bomb_map[i].count);
			else
				System.out.printf("- ");
			if(i%7 == 6 && i != 0)
				System.out.println("");
		}
					
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args){
		Mine test = new Mine();
		return;
	}
}
