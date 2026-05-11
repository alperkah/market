package com.hmyo.market.ui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

public class AnaPencereGui extends JFrame{
	
	public AnaPencereGui(int yetki) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				initPencere();
				
			}
		});
	}
	private void initPencere() {
		setTitle("Market Otomasyonu");
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	private JPanel initPanel() {
		JPanel anaPanel = new JPanel();
		
		
		
		return anaPanel;

	}
	private JMenuBar initMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		return menuBar;
	}
	private JToolBar initToolBar() {
		JToolBar toolBar = new JToolBar();
		
		
		return toolBar;
	}

}
