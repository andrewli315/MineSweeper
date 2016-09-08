import java.util.*;


public class Bomb{
	public int i;
	public int j;
	public int flag;
	public int count;
	public boolean onClick = false;
	public boolean bomb;
	public Bomb(int i,int j){
		this.i = i;
		this.j = j;
		if(Math.random()>0.8 && i != 0 && j != 0 && i != 6 && j != 6)
			this.bomb = true;
		else
			this.bomb = false;
	}
	
	public void Onclick_event(){
		this.onClick = true;
	}
	public void changeFlag(int num){
		this.flag = num;
	}
	public boolean isOnclick(){
		return onClick;	
	}
	public void change_appearance() {
	}
	
}
