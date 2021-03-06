import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import javax.swing.*;
public class Mine extends JFrame implements ActionListener{
	JFrame f;
	JButton[] bomb_arr = new JButton[144];
	Bomb[] bomb_map = new Bomb[144];
	int[] stack = new int[200];
	int size_x;
	int size_y;
	static int stack_index = 0;
	public Mine(int x , int y){
		this.size_x = x;
		this.size_y = y;
		f = new JFrame();
		for(int i=0;i<(x+2);i++){
			for(int j=0;j<(y+2);j++){
				bomb_arr[i*12+j] = new JButton();
				bomb_arr[i*12+j].setIcon(new ImageIcon("btnNor.bmp"));
				bomb_map[i*12+j] = new Bomb(i,j);
				bomb_map[i*12+j].flag = 0;
				if(bomb_map[i*12+j].bomb == true)
					bomb_map[i*12+j].count = -2;
				if(i==0){
					bomb_map[i*12+j].flag = -1;
					bomb_map[i*12+j].count = -1;
				}
				if(j==0){
					bomb_map[i*12+j].flag = -1;
					bomb_map[i*12+j].count = -1;
				}
				if(i==x+1){
					bomb_map[i*12+j].flag = -1;
					bomb_map[i*12+j].count = -1;
				}
				if(j==y+1){
					bomb_map[i*12+j].flag = -1;
					bomb_map[i*12+j].count = -1;
				}
			}
		}
	
		
		//display();
		generate_bomb(15);
		Statistics();
		display(size_x,size_y);
		Search(8,9);
		display(size_x,size_y);
	
		
		
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent arg0){
				System.exit(1);
			}
		});
		
	}
	private void Statistics(){
		int count=0;
		for(int i=1;i<11;i++){
			for(int j=1;j<11;j++){
				int ii = i-1;
				int jj = j-1;
				if(bomb_map[ii*12+jj].bomb == true)
					count++;
				if(bomb_map[(ii+1)*12+jj].bomb == true)
					count++;
				if(bomb_map[(ii+2)*12+jj].bomb == true)
					count++;

				if(bomb_map[(ii+2)*12+jj+1].bomb == true)
					count++;

				if(bomb_map[(ii+2)*12+jj+2].bomb == true)
					count++;
				if(bomb_map[(ii+1)*12+jj+2].bomb == true)
					count++;
				if(bomb_map[ii*12+jj+2].bomb == true)
					count++;
				if(bomb_map[ii*12+jj+1].bomb == true)
					count++;			
				System.out.printf("%d ",count);
				bomb_map[i*12+j].count = count;
				count = 0;
			}
			count = 0;
			System.out.println("");
		}
	}
	private void Search(int i,int j){
		int index;
		int x,y;
		for(int ii=-1;ii<=1;ii++){
			for(int jj = -1;jj<=1;jj++){
				x = i +ii;
				y = j + jj;
				index = x + y*12;
				if(ii == -1 || ii == 1 )
					if(jj == 0){
						if(index>=1){
							if(!bomb_map[index].onClick){
								if(bomb_map[index].count == 0 && bomb_map[index].inStack != true 
										&& bomb_map[index].bomb != true){
									System.out.println(index);
									stack[++stack_index] = index;
									bomb_map[index].inStack = true;
									System.out.println("stack_index  "+stack_index);
									System.out.printf("%d %d\n",i,j);
									Search(x,y);
								}
					
							}
							else if(bomb_map[index].onClick){
								return;
							}
						}
					}
					else 
						continue;
				if(ii == 0){
					if(index>=1){
						if(!bomb_map[index].onClick){
							if(bomb_map[index].count == 0 && bomb_map[index].inStack != true 
									&& bomb_map[index].bomb != true){
								System.out.println(index);
								stack[++stack_index] = index;
								bomb_map[index].inStack = true;
								System.out.println("stack_index  "+stack_index);
								System.out.printf("%d %d\n",i,j);
								Search(x,y);
							}
				
						}
						else if(bomb_map[index].onClick){
							return;
						}
					}
				}
			}
		}
	}
	
	private void display(int x ,int y){
		int sum = (x+2)*(y+2);
		for(int i=0;i<sum;i++){
			if(bomb_map[i].bomb == true)
				System.out.printf("* ");
			else if(bomb_map[i].flag != -1)
				System.out.printf("0 ");
			else
				System.out.printf("- ");
			if(i%(x+2) == x+1 && i != 0)
				System.out.println("");
		}
		for(int i=0;i<sum;i++){
			if(bomb_map[i].bomb == true)
				System.out.printf("* ");
			else if(bomb_map[i].flag != -1 && bomb_map[i].inStack != true)
				System.out.printf("%d ",bomb_map[i].count);
			else if(bomb_map[i].inStack == true)
				System.out.printf("x ");
			else
				System.out.printf("- ");
			if(i%(x+2) == x+1 && i != 0)
				System.out.println("");
		}
					
	}
	private void generate_bomb(int n){
		Random ran = new Random();
		int rand_index;
		int range = (size_x+2)*(size_y+2);
		int count =0;
		do{
			rand_index = ran.nextInt(range);
			if(rand_index/(size_x+2) != 0 && rand_index/(size_x+2) != size_x+1 && 
					rand_index%(size_y+2) != 0 && rand_index%(size_y+2) != size_y+1 && bomb_map[rand_index].bomb == false){
				bomb_map[rand_index].bomb = true;
				count++;
			}
			else if(bomb_map[rand_index].bomb == true)
				continue;
			else
				continue;
			
		}while(count != n);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args){
		Mine test = new Mine(10,10);
		return;
	}
}
