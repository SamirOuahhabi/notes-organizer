package me.octahex.core;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.TableModel;

public class DBManager
{
	private static DBManager _instance = null;
	private Connection _connection;

	protected DBManager()
	{
		initDB();
		checkTables();
	}

	private void initDB()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			_connection = DriverManager.getConnection("jdbc:sqlite:" + Config.dbName);
			System.out.println("Connected!");
		} catch (Exception e)
		{
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	private void checkTables()
	{
		if (tableExists(Config.notesTableName))
		{
			System.out.println("Table exists!");
		} else
		{
			System.out.println("Table does not exists!");
			createTable(Config.notesTableSQL);
		}
	}

	private boolean tableExists(String tableName)
	{
		try
		{
			DatabaseMetaData meta = _connection.getMetaData();
			ResultSet tables = meta.getTables(null, null, tableName, null);
			if (tables.next())
				return true;
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	private void createTable(String sql)
	{
		Statement statement;
		try
		{
			statement = _connection.createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static DBManager getInstance()
	{
		if (_instance == null)
		{
			_instance = new DBManager();
		}

		return _instance;
	}

	public void close()
	{
		try
		{
			_connection.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void insertData(String sql)
	{
		try
		{
			_connection.setAutoCommit(false);
			Statement statement = _connection.createStatement();
			statement.executeUpdate(sql);
			_connection.commit();
			statement.close();
			_connection.setAutoCommit(true);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public Note[] fetchAllNotes()
	{
		String sql = "SELECT * FROM `"+Config.notesTableName+"`;";
		ArrayList<Note> notes = new ArrayList<>();
		try
		{
			_connection.setAutoCommit(false);
			Statement statement = _connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				notes.add(new Note(rs.getString("TITLE"),
						rs.getString("CONTENT"), 
						new Date(rs.getLong("CREATED_AT"))));
			}
			rs.close();
			statement.close();
			_connection.setAutoCommit(true);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		Note[] notesArray = new Note[notes.size()];
		int i = 0;
		for(Note n : notes)
		{
			notesArray[i] = n;
			i++;
		}
		
		return notesArray;
	}
}
