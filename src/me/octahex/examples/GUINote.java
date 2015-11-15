package me.octahex.examples;

import java.util.Date;

import me.octahex.core.Note;
import me.octahex.core.NoteManager;
import me.octahex.gui.MainFrame;

public class GUINote
{
	public static void main(String[] args)
	{
		Note n = new Note("new title", "better content", new Date());
		NoteManager.updateNote(n, 1);
		MainFrame mf = new MainFrame();
		mf.setVisible(true);
	}
}
