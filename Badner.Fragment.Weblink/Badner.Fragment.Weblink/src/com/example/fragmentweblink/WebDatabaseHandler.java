package com.example.fragmentweblink;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;

/**
 * A static import will inject the entire public\protect methods and parameters of the import subjuct
 */
import static com.example.fragmentweblink.WebDatabaseHelper.*;

public class WebDatabaseHandler {

private Context c;
	
	private WebDatabaseHelper helper = null;
	
	public WebDatabaseHandler(Context context)
	{
		helper = new WebDatabaseHelper(context);
		c=context;
	}
	
	
	


	public Cursor getAllLink()
	{
		SQLiteDatabase db = helper.getReadableDatabase();
		boolean sort = PreferenceManager.getDefaultSharedPreferences(c).getBoolean("sort", true);
		  
		Cursor c =  db.query(TABLE_WEB, new String[]{
			COLUMN_ID, COLUMN_TITLE,COLUMN_DESCRIPTION,COLUMN_LINK,
			COLUMN_CATEGORY,COLUMN_ORIGIN}, 
			null, null, null, null, null);
		
		return c;
		  
	}
	
	public Web addLink(String title,String description,String link
			                 ,String category,String origin)
	{
		
		SQLiteDatabase db = helper.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(COLUMN_TITLE, title);
		values.put(COLUMN_DESCRIPTION, description);
		values.put(COLUMN_LINK, link);
		values.put(COLUMN_CATEGORY, category);
		values.put(COLUMN_ORIGIN, origin);
		 
		
		
		long id = db.insert(TABLE_WEB, null, values);
		
		if(id == -1)
		{
			return null;
		}
		
		Web web = new Web(id, title, description, link, category, origin);
		
		return web;
	}
	
	public void RemoveLink(long id)
	{
		
		SQLiteDatabase db = helper.getWritableDatabase();
		
		
		db.delete(TABLE_WEB, "_id=?",new String[] { String.valueOf(id)});

		
		
	
	}
	
}
