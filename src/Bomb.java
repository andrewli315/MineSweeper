import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Bomb extends JButton{
	public JButton btn;
	public int i;
	public int j;
	public int flag;
	public boolean onClick = false;
	public Bomb(int i,int j,int x,int y,int width,int height){
		btn = new JButton(new ImageIcon("normal.png"));
		btn.setBounds(x, y, width, height);
		btn.setVisible(true);
		
	}
	

	public void changeFlag(int num){
		flag = num;
	}
	public boolean isOnclick(){
		return onClick;	
	}
	public void change_appearance() {
	}
	
}
