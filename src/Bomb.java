import java.util.*;


public class Bomb{
	public int i;
	public int j;
	public int flag;
	public int count;
	public boolean inStack = false;
	public boolean onClick = false;
	public boolean bomb;
	public Bomb(int i,int j){
		this.i = i;
		this.j = j;
		//if(Math.random()>0.9 && i != 0 && j != 0 && i != 11 && j != 11)
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
