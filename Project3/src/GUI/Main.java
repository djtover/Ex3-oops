package GUI;

import javax.swing.JFrame;


public class Main 
{
	public static void main(String[] args)
	{
//		MainWindow window = new MainWindow("C:\\Users\\djtov\\Downloads\\Ex3 (2)\\Ex3\\Ariel1.png");
		MainWindow window = new MainWindow("Ariel1.png");
		window.setVisible(true);
		window.setSize(window.getMyImage().getWidth(),window.getMyImage().getHeight());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}

