package me.octahex.core;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;

public class NoteManager
{
	public static DefaultListModel<Note> getSavedNotes()
	{
//		File folder = new File(Config.savePath);
//		File[] noteFiles = folder.listFiles();
//		DefaultListModel<Note> listModel = new DefaultListModel<>();
//		for(int i = 0; i < noteFiles.length; i++)
//		{
//			listModel.addElement(new Note(noteFiles[i]));
//		}
//		return listModel;
		return null;
	}
	
	public static void createNote(Note n)
	{
		long now = new Date().getTime();
		String sql = "INSERT INTO "+Config.notesTableName+" (TITLE, CREATED_AT, MODIFIED_AT, CONTENT) " +
                "VALUES ('"+n.get_title()+"', '"+now+"', '"+now+"', '"+n.get_content()+"');";
		DBManager.getInstance().insertData(sql);
	}
	
	public static void updateNote(Note n, int id)
	{
		long now = new Date().getTime();
		String sql = "UPDATE "+Config.notesTableName+" set TITLE = '"
					+n.get_title()+"', CONTENT = '"+n.get_content()
					+"', MODIFIED_AT = '"+now+"' where ID="+id;
		DBManager.getInstance().insertData(sql);
	}
}
