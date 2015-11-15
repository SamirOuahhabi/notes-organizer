package me.octahex.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import me.octahex.core.Config;
import me.octahex.core.DBManager;
import me.octahex.core.Note;
import me.octahex.core.NoteManager;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JList;
import javax.swing.JTable;

public class MainFrame extends JFrame
{
	private static final long serialVersionUID = -6415026719192740389L;
	private JPanel _contentPane;
	private JMenuBar _menuBar;
	private JList<Note> _noteList;

	/**
	 * Create the frame.
	 */
	public MainFrame()
	{
		initFrame();
		setLookAndFeel();
		initContentPane();
		initMenu();
		initNoteList();
	}

	private void initFrame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 520);
		setTitle(Config.progName+" v."+Config.progVersion);
	}

	private void setLookAndFeel()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e)
		{
			e.printStackTrace();
		}
	}

	private void initNoteList()
	{
		Note[] notes = DBManager.getInstance().fetchAllNotes();
		_noteList = new JList<>(notes);
		_contentPane.add(_noteList, BorderLayout.WEST);
	}

	private void initContentPane()
	{
		_contentPane = new JPanel();
		_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		_contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(_contentPane);
	}

	private void initMenu()
	{
		_menuBar = new JMenuBar();
		setJMenuBar(_menuBar);

		JMenu mnFile = new JMenu("File");
		_menuBar.add(mnFile);

		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
	}
}
