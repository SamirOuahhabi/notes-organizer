package me.octahex.core;

public final class Config
{
	public static final String progName = "Notes Organizer";
	
	public static final String progVersion = "0.1";
	
	public static final String dbName = "dabatase.sql";
	
	public static final String notesTableName = "notes";
	
	public static final String notesTableSQL = "CREATE TABLE " + notesTableName +
            "(ID INTEGER PRIMARY KEY," +
            " TITLE TEXT NOT NULL, " + 
            " CREATED_AT INTEGER NOT NULL, " + 
            " MODIFIED_AT INTEGER NOT NULL, " + 
            " CONTENT TEXT NOT NULL);";
}
