package me.octahex.examples;

import java.util.Scanner;

import me.octahex.core.DBManager;
import me.octahex.core.Note;
import me.octahex.core.NoteManager;

public class CLINote
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		Note note = new Note();
		String title, content;
		System.out.println("Enter a title : ");
		title = kb.nextLine();
		System.out.println("Enter a content : ");
		content = kb.nextLine();
		kb.close();
		note.set_title(title);
		note.set_content(content);
		DBManager db = DBManager.getInstance();
//		db.createNote(note);
		db.close();
		System.out.println("Note created!");
	}
}
