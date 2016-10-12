import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.util.Random;

import javax.swing.JFrame;

public class MyMouseAdapter extends MouseAdapter {
//	private Random generator = new Random();
	public void mousePressed(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame) c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			myPanel.mouseDownGridX = myPanel.getGridX(x, y);
			myPanel.mouseDownGridY = myPanel.getGridY(x, y);
			myPanel.repaint();
			break;
		case 3:		//Right mouse button
			c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			myFrame = (JFrame) c;
			myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
			myInsets = myFrame.getInsets();
			x1 = myInsets.left;
			y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			x = e.getX();
			y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			myPanel.mouseDownGridX = myPanel.getGridX(x, y);
			myPanel.mouseDownGridY = myPanel.getGridY(x, y);
			myPanel.repaint();
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
	public void mouseReleased(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame)c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			int gridX = myPanel.getGridX(x, y);
			int gridY = myPanel.getGridY(x, y);
			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
				//Had pressed outside
				//Do nothing
			} else {
				if ((gridX == -1) || (gridY == -1)) {
					//Is releasing outside
					//Do nothing
				} else {
					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
						//Released the mouse button on a different cell where it was pressed
						//Do nothing
					}
					else {
						//On the grid
						if(myPanel.isBomb(gridX, gridY) && !myPanel.colorArray[gridX][gridY].equals(Color.RED)) {
							//If square is a bomb and hasn't been flagged, reveal the rest
							for(int i = 0; i < myPanel.getColumns(); i++) {
								for(int j = 0; j < myPanel.getRows(); j++) {
									if(myPanel.isBomb(i,j)) {
										myPanel.colorArray[i][j] = Color.BLACK;
									} 
								}
							}
						} 
						 //reguero
						else if(!myPanel.colorArray[gridX][gridY].equals(Color.RED) && !myPanel.colorArray[gridX][gridY].equals(Color.BLACK)) {
							//Paint the panel if it hasn't been flagged or revealed to be a bomb
							
						} else if(!myPanel.colorArray[gridX][gridY].equals(Color.RED) && !myPanel.colorArray[gridX][gridY].equals(Color.BLACK)) {
							//Paint the panel if it hasn't been flagged or revealed to be a bomb
							myPanel.colorArray[gridX][gridY] = Color.GRAY;
							myPanel.chain(gridX, gridY);
							
						  for(int i=-1; i<2; i++){ //continue chain
								for (int j=-1; j<2; j++){
									myPanel.chain(gridX, gridY);
									myPanel.chain(gridX+i, gridY+j);
									myPanel.chain(gridX-i, gridY-j);
								}
<<<<<<< HEAD
=======
							}
						} 
						 //reguero
						else if(!myPanel.colorArray[gridX][gridY].equals(Color.RED) && !myPanel.colorArray[gridX][gridY].equals(Color.BLACK)) {
							//Paint the panel if it hasn't been flagged or revealed to be a bomb
							
						} else if(!myPanel.colorArray[gridX][gridY].equals(Color.RED) && !myPanel.colorArray[gridX][gridY].equals(Color.BLACK)) {
							//Paint the panel if it hasn't been flagged or revealed to be a bomb
							myPanel.colorArray[gridX][gridY] = Color.GRAY;
							myPanel.chain(gridX, gridY);
							
						  for(int i=-1; i<2; i++){ //continue chain
								for (int j=-1; j<2; j++){
									myPanel.chain(gridX, gridY);
									myPanel.chain(gridX+i, gridY+j);
									myPanel.chain(gridX-i, gridY-j);
								}
>>>>>>> refs/remotes/origin/master
							}
						}
						myPanel.repaint();
					}
				}
			}
			myPanel.repaint();
		case 3:		//Right mouse button
			c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			myFrame = (JFrame)c;
			myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			myInsets = myFrame.getInsets();
			x1 = myInsets.left;
			y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			x = e.getX();
			y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			gridX = myPanel.getGridX(x, y);
			gridY = myPanel.getGridY(x, y);
			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
				//Had pressed outside
				//Do nothing
			} else {
				if ((gridX == -1) || (gridY == -1)) {
					//Is releasing outside
					//Do nothing
				} else {
					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
						//Released the mouse button on a different cell where it was pressed
						//Do nothing
					} else {
						//On the grid
						if(!myPanel.colorArray[gridX][gridY].equals(Color.GRAY) && !myPanel.colorArray[gridX][gridY].equals(Color.BLACK)){
							//Paint the tile red as long as it hasn't been uncovered or shown to be a bomb
							myPanel.colorArray[gridX][gridY] = Color.RED;	
						} else if(myPanel.colorArray[gridX][gridY].equals(Color.RED)) {
							//If tile is red, then paint white
							myPanel.colorArray[gridX][gridY] = Color.WHITE;
						}
					}
				}
			}
			myPanel.repaint();
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
}