package me.octahex.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import me.octahex.core.Config;
import net.miginfocom.swing.MigLayout;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame extends JFrame
{
	private static final long serialVersionUID = -6415026719192740389L;
	private JPanel _contentPane;
	private MigLayout _layout;
	private EditorState _currentState;
	private ComponentManager _componentManager;
	private JMenuBar _menuBar;
	

	/**
	 * Create the frame.
	 */
	public MainFrame()
	{
		initFrame();
		setLookAndFeel();
		initContentPane();
		initLayout();
		_currentState = new ReadingState();
		_componentManager = new ComponentManager(_contentPane);
		initMenuBar();
		_currentState.updateComponents(_componentManager);
	}

	private void initMenuBar()
	{
		_menuBar = new JMenuBar();
		setJMenuBar(_menuBar);
		JMenu mnFile = new JMenu("File");
		_menuBar.add(mnFile);

		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		mntmNew.setActionCommand("new");
		mntmNew.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				_currentState = new CreatingState();
				_currentState.updateComponents(_componentManager);
			}
		});
	}

	private void initLayout()
	{
		_layout = new MigLayout("", // layout constraints
				"[]20[][grow]", // Column constraints
				"[][grow]"); // Row constraints
		_contentPane.setLayout(_layout);
	}

	private void initFrame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1920 + 100, 100, 750, 520);
		setTitle(Config.progName + " v." + Config.progVersion);
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

	private void initContentPane()
	{
		_contentPane = new JPanel();
		_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(_contentPane);
		_contentPane.setBackground(Color.BLACK);
	}

}
