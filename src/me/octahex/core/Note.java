package me.octahex.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Note
{
	private String _title;
	private String _content;
	private Date _date;
	
	public Note()
	{
		_title = "New note title";
		_content = "...";
		_date = null;
	}
	
	public Note(String title, String content, Date date)
	{
		_title = title;
		_content = content;
		_date = date;
	}
	
	public Note(File file)
	{
		Scanner fromFile;
		try
		{
			fromFile = new Scanner(file);
			parseFile(fromFile);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}		
	}
	
	private void parseFile(Scanner file)
	{
		String temp;
		while(file.hasNextLine())
		{
			temp = file.nextLine();
			switch (temp)
			{
			case "title" :
				if(file.hasNextLine())
					_title = file.nextLine();
				else
					_title = "No title";
				break;
			case "content" :
				_content = "";
				while(file.hasNextLine())
				{
					_content = file.nextLine();
				}
				break;
			case "date" :
				if(file.hasNextLine())
					_date = new Date(Long.parseLong(file.nextLine()));
				else
					_date = new Date(0);
				break;
			}
		}
	}

	public String get_title()
	{
		return _title;
	}

	public void set_title(String _title)
	{
		this._title = _title;
	}

	public String get_content()
	{
		return _content;
	}

	public void set_content(String _content)
	{
		this._content = _content;
	}

	public Date get_date()
	{
		return _date;
	}
	
	public String toString()
	{
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(_date);
		String dateStr = cal.get(Calendar.MONTH)+"/";
		dateStr += cal.get(Calendar.DAY_OF_WEEK)+"/";
		dateStr += cal.get(Calendar.YEAR);
		
		return _title + " - " + dateStr;
	}
}
