package me.octahex.examples;

import java.util.Arrays;

import me.octahex.core.DBManager;

public class DBTest
{
	public static void main(String[] args)
	{
		DBManager db = DBManager.getInstance();
		
		System.out.println(Arrays.toString(db.fetchAllNotes()));
		
		db.close();
	}
}
