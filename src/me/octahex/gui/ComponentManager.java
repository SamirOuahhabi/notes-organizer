package me.octahex.gui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import me.octahex.core.DBManager;
import me.octahex.core.Note;

public class ComponentManager
{
	private JList<Note> _noteList;
	private JTextField _tfTitle;
	private JTextArea _taContent;
	private JLabel _lTitle;
	private JLabel _lContent;
	
	public ComponentManager(JPanel pane)
	{
		initFields(pane);
		initEventListeners();
	}
	
	private void initFields(JPanel pane)
	{
		initNoteList();
		pane.add(_noteList, "dock west");
		
		_lTitle = new JLabel("Title :");
		pane.add(_lTitle, "cell 1 0");
		
		_tfTitle = new JTextField(100);
		pane.add(_tfTitle, "cell 2 0");
		
		_lContent = new JLabel("Content :");
		pane.add(_lContent, "cell 1 1");
		
		_taContent = new JTextArea(25, 100);
		pane.add(_taContent, "cell 2 1");
	}

	private void initNoteList()
	{
		Note[] notes = DBManager.getInstance().fetchAllNotes();
		_noteList = new JList<>(notes);
	}
	
	private void initEventListeners()
	{
		_noteList.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e)
			{
				displayNote(_noteList.getSelectedValue());
			}
		});
	}
	
	private void displayNote(Note n)
	{
		_tfTitle.setText(n.get_title());
		_taContent.setText(n.get_content());
	}

	public JList<Note> get_noteList()
	{
		return _noteList;
	}

	public JTextField get_tfTitle()
	{
		return _tfTitle;
	}

	public JTextArea get_taContent()
	{
		return _taContent;
	}

	public JLabel get_lTitle()
	{
		return _lTitle;
	}

	public JLabel get_lContent()
	{
		return _lContent;
	}
}
