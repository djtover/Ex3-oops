package GUI;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.awt.Desktop;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileSystemView;

import FileFormat.FromCsv;
import FileFormat.ToCsv;
import FileFormat.ToKml;
import GIS.Fruit;
import GIS.Game;
import GIS.Map;
import GIS.Packman;
import GIS.ShortestPathAlgo;
import GIS.Solution;
import Geom.Point3D;

/**
 * This class represents the GUI of the Packman game
 * @author David Tover
 *
 */
public class MainWindow extends JFrame implements MouseListener, ComponentListener
{
	private BufferedImage myImage;
	private boolean isPack;
	private boolean isFruit;
	private boolean isRun;
	private int x = -1;
	private int y = -1;
	private ArrayList<Packman> pointsPack = new ArrayList<Packman>();
	private ArrayList<Fruit> pointsFruit = new ArrayList<Fruit>();
	private static int c = 1;
	

	/**
	 * This is the constructor for the class
	 * @param imageName input the path of the image that you would like to put in the GUI
	 */
	public MainWindow(String imageName) 
	{
		this.addComponentListener(this);
		isPack = false;
		isFruit = false;
		isRun = false;
		initGUI(imageName);		
		this.addMouseListener(this);

	}

	public BufferedImage getMyImage() {
		return myImage;
	}
	/**
	 * This is a class that initiates the GUI
	 * @param imageName input the path of the image that you would like to put in the GUI
	 */
	private void initGUI(String imageName) 
	{
		MenuBar menuBar = new MenuBar();
		Menu menu1 = new Menu("Menu"); 
		MenuItem PackMenu = new MenuItem("Packman");
		MenuItem FruitMenu = new MenuItem("Fruit");
		MenuItem RunMenu = new MenuItem("Run");
		MenuItem ClearMenu = new MenuItem("Clear");
		Menu menu2 = new Menu("File");
		MenuItem toCsv = new MenuItem ("Save to CSV");
		MenuItem fromCsv = new MenuItem ("Import CSV File");
		MenuItem toKml = new MenuItem ("Save to KML");

		toCsv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				isPack = false;
				isRun = false;
				isFruit = false;
				
				JFileChooser jfc = new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				jfc.setAcceptAllFileFilterUsed(false);
				int rVal = jfc.showOpenDialog(getParent());
				if(rVal == JFileChooser.APPROVE_OPTION) {
					System.out.println("You chose this folder: " + jfc.getSelectedFile().getName());
					String path = jfc.getSelectedFile().getPath() +"\\game"+ c + ".csv";
					c++;
					System.out.println(path);
					ToCsv tc = new ToCsv(path, pointsPack , pointsFruit);
				}
				
			}
			
		});
		
		
		toKml.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				isPack = false;
				isRun = false;
				isFruit = false;
				
				JFileChooser jfc = new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				jfc.setAcceptAllFileFilterUsed(false);
				int rVal = jfc.showOpenDialog(getParent());
				if(rVal == JFileChooser.APPROVE_OPTION) {
					System.out.println("You chose this folder: " + jfc.getSelectedFile().getName());
					String path = jfc.getSelectedFile().getPath() +"\\game"+ ".kml";
					c++;
					System.out.println(path);
					ToKml tk = new ToKml(path , pointsPack, pointsFruit);
				}
				
			}
		});
		
		
		PackMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				isPack = true;
				isFruit = false;
				isRun=false;

			}
		});

		FruitMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				isFruit = true;
				isPack = false;
				isRun = false;
			}
		});

		RunMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//				run();
				isPack=false;
				isFruit = false;
				isRun =true;
				repaint();
			}
		});

		ClearMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//				run();
				isPack=false;
				isFruit = false;
				isRun =false;
				pointsPack.clear();
				pointsFruit.clear();
				repaint();
			}
		});

		fromCsv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				isPack=false;
				isFruit = false;
				isRun =false;
				pointsPack.clear();
				pointsFruit.clear();
				repaint();
				
				
				
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

				int returnValue = jfc.showOpenDialog(null);
				// int returnValue = jfc.showSaveDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = jfc.getSelectedFile();
					if (selectedFile.getAbsoluteFile().toString().endsWith(".csv")) {
						FromCsv csvFile = new FromCsv(selectedFile.getAbsoluteFile().toString());


						for(int i=0;i<csvFile.getALP().size();i++) {
							pointsPack.add(csvFile.getALP().get(i));
						}
						for(int i=0;i<csvFile.getALF().size();i++) {
							pointsFruit.add(csvFile.getALF().get(i));
						}
						isPack= false;
						isFruit = false;
						isRun = false;
						for(int i=0;i<csvFile.getALP().size();i++) {
							System.out.println(pointsPack.get(i));
						}
						
						repaint();
					}	
					else {
						System.out.println("This is not a csv file");
					}

				}
			}
		});




		menuBar.add(menu1);
		menuBar.add(menu2);
		menu2.add(fromCsv);
		menu2.add(toCsv);
		menu2.add(toKml);
		menu1.add(PackMenu);
		menu1.add(FruitMenu);
		menu1.add(RunMenu);
		menu1.add(ClearMenu);
		this.setResizable(true);
		this.setMenuBar(menuBar);

		try {
			myImage = ImageIO.read(new File(imageName));

		} catch (IOException e) {
			e.printStackTrace();
		}		

	}
	/**
	 * This is a method thats paints on the image that will put Packmans and Fruits on the image
	 */
	public void paint(Graphics g)
	{
		Map m = new Map(getWidth(),getHeight(),"Ariel1.png");

		g.drawImage(myImage, 0, 0, getWidth()-8,getHeight()-8, this);

		if(x!=-1 && y!=-1 )
		{
			
			Point3D point = new Point3D(x,y);
			Point3D newPoint=new Point3D (m.Pixels2Coords(point, getWidth(), getHeight()));
			if(isPack) {
				Packman p1 = new Packman(newPoint.x(),newPoint.y(),0,1,1);
				pointsPack.add(p1);
				System.out.println(p1);
			}
			if(isFruit) {
				Fruit f1 = new Fruit(newPoint.x(),newPoint.y(),0,1);
				pointsFruit.add(f1);
				System.out.println(f1);
			}
		}
		if(isRun) {
			Game game = new Game(pointsPack,pointsFruit);
           

			ShortestPathAlgo spa = new ShortestPathAlgo(game);
			Solution s = new Solution(spa.getSolution());
//			System.out.println(s.getGame());
			for(int i=0; i<s.getGame().getALP().size();i++) {
				if(s.getGame().getALP().get(i).getPath().size()>0) {
					g.setColor(Color.CYAN);
					Point3D a = m.Coords2Pixels(s.getGame().getALP().get(i).getStartingPoint());
					Point3D b = m.Coords2Pixels(s.getGame().getALP().get(i).getPath().getAL().get(0).getP());
					g.drawLine(a.ix(), a.iy(), b.ix(), b.iy());
				}
				for(int j=1;j<s.getGame().getALP().get(i).getPath().size();j++) {					
					Point3D a = m.Coords2Pixels(s.getGame().getALP().get(i).getPath().getAL().get(j-1).getP());
					Point3D b = m.Coords2Pixels(s.getGame().getALP().get(i).getPath().getAL().get(j).getP());
					g.setColor(Color.CYAN);
					g.drawLine(a.ix(),a.iy(),b.ix(),b.iy());
				}
			}	
		}
		
		for(int i = 0 ; i<pointsPack.size();i++) {
			int r = 30;
			Point3D pointDraw =  m.Coords2Pixels(pointsPack.get(i).getP());
			x = pointDraw.ix() - (r/2);
			y = pointDraw.iy() - (r/2);
			g.setColor(Color.YELLOW);
			g.fillOval(x, y, r, r);
		}
		for(int i = 0 ; i<pointsFruit.size();i++) {
			int r = 10;
			Point3D pointDraw =  m.Coords2Pixels(pointsFruit.get(i).getP());
			x = pointDraw.ix() - (r/2);
			y = pointDraw.iy() - (r/2);
			g.setColor(Color.MAGENTA);
			g.fillOval(x, y, r, r);

		}
	}


	@Override
	public void mouseClicked(MouseEvent arg) {
//				System.out.println("mouse Clicked");
		x = arg.getX();
		y = arg.getY();
		repaint();

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		//		System.out.println("mouse entered");

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		//		System.out.println("resized " + getWidth()+" "+ getHeight());
		isPack = false;
		isFruit = false;
		isRun = false;
//		repaint();
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

}
