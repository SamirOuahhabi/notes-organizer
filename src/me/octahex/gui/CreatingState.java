package me.octahex.gui;

import java.awt.Color;

import javax.swing.ListSelectionModel;

public class CreatingState implements EditorState
{
	private Color _defaultForegroundColor;
	private Color _defaultBackgroundColor;

	public CreatingState()
	{
		_defaultForegroundColor = Color.BLACK;
		_defaultBackgroundColor = Color.WHITE;
	}
	
	@Override
	public void updateComponents(ComponentManager cm)
	{
		cm.get_lContent().setForeground(_defaultBackgroundColor);
		cm.get_lTitle().setForeground(_defaultBackgroundColor);
		cm.get_noteList().setEnabled(false);
		cm.get_taContent().setForeground(_defaultForegroundColor);
		cm.get_taContent().setBackground(_defaultBackgroundColor);
		cm.get_taContent().setText("");
		cm.get_taContent().setEditable(true);
		cm.get_tfTitle().setForeground(_defaultForegroundColor);
		cm.get_tfTitle().setBackground(_defaultBackgroundColor);
		cm.get_tfTitle().setText("");
		cm.get_tfTitle().setEditable(true);
	}
}
