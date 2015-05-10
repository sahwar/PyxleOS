package com.dakkra.pyxleos.specialcomponents;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;

import com.dakkra.pyxleos.model.MainModel;

public class ToolbarColorBox extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3468468953407277875L;
	Color color;
	public MainModel m;

	public ToolbarColorBox(Color color, MainModel m) {
		this.m = m;
		this.color = color;
		this.setText("       ");
		this.addActionListener(new ClickListener());
	}
	
	public void updateColor(){
		color = m.fgColor;
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(color);
		g.fillRect(0, 0, getSize().width, getSize().height);
	}

	private class ClickListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Color newColor = JColorChooser.showDialog(null, "Paint Color",
					m.fgColor);

			if (!(newColor == null)) {
				m.fgColor = newColor;
				updateColor();
			} else {
				return;
			}

		}

	}
}
