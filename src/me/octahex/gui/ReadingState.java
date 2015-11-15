package me.octahex.gui;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.ListSelectionModel;

public class ReadingState implements EditorState
{
	private Color _defaultForegroundColor;
	private Color _defaultBackgroundColor;
	
	public ReadingState()
	{
		_defaultForegroundColor = Color.WHITE;
		_defaultBackgroundColor = Color.GRAY;
	}
	
	@Override
	public void updateComponents(ComponentManager cm)
	{
		cm.get_lContent().setForeground(_defaultForegroundColor);
		cm.get_lTitle().setForeground(_defaultForegroundColor);
		cm.get_noteList().setEnabled(true);
		cm.get_noteList().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cm.get_noteList().setForeground(_defaultForegroundColor);
		cm.get_noteList().setBackground(_defaultBackgroundColor);
		cm.get_taContent().setForeground(_defaultForegroundColor);
		cm.get_taContent().setBackground(_defaultBackgroundColor);
		cm.get_taContent().setEditable(false);
		cm.get_tfTitle().setForeground(_defaultForegroundColor);
		cm.get_tfTitle().setBackground(_defaultBackgroundColor);
		cm.get_tfTitle().setEditable(false);
	}

}
