import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import javax.swing.*;
public class Mine extends JFrame implements ActionListener{
	public static void main(String[] args ){
		JFrame f = new JFrame();
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent arg0){
				System.exit(1);
			}
		});
		f.setBounds(300, 500, 300, 500);
		Bomb b = new Bomb(1, 2, 12, 24, 20, 20);
		f.add(b);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
