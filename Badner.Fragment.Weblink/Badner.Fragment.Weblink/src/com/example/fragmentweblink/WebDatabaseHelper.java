package com.example.fragmentweblink;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

//בסיס הנתונים
public class WebDatabaseHelper extends SQLiteOpenHelper {

	 //שם בסיס הנתונים
	  private static final String DATABASE_NAME = "webs.db";
	  //שם הטבלה
	public static final String TABLE_WEB = "webs";
	
	//העמודות
	  public static final String COLUMN_ID = "_id";
	  public static final String COLUMN_TITLE = "title";
	  public static final String COLUMN_DESCRIPTION = "description";
	  public static final String COLUMN_LINK = "link";
	  public static final String COLUMN_CATEGORY = "category";
	  public static final String COLUMN_ORIGIN = "origin";
	 
	  private static final int DATABASE_VERSION = 1;

	  // Create SQL query that create the studnets table
	  private static final String DATABASE_CREATE = "create table "
	      + TABLE_WEB + "(" + COLUMN_ID + " integer primary key autoincrement,"
		  +" " + COLUMN_TITLE+ " text not null,"
		  +" " + COLUMN_DESCRIPTION+ " text not null,"
		  +" " + COLUMN_LINK+ " text not null,"
		  +" " + COLUMN_CATEGORY+ " text not null,"
		  +" " + COLUMN_ORIGIN+ " text not null);";
	
	
	  public WebDatabaseHelper(Context context) 
		{
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

	@Override
	public void onCreate(SQLiteDatabase database) {
		/**
		  * Here we generate the students table
		  */
	    database.execSQL(DATABASE_CREATE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

	
}
