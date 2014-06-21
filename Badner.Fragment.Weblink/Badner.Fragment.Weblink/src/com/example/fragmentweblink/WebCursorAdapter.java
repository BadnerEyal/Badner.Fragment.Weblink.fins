package com.example.fragmentweblink;



import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * A static import will inject the entire public\protect methods and parameters of the import subjuct
 */
import static com.example.fragmentweblink.WebDatabaseHelper.*;


public class WebCursorAdapter extends CursorAdapter
{
private LayoutInflater myInflator = null;
	

	public WebCursorAdapter(Context context, Cursor c) 
	{
		super(context, c,true);
		myInflator = LayoutInflater.from(context);
		
	}


	
	@Override
	public void bindView(View myView, Context context, Cursor cursor) 
	{
		ViewHolder holder = (ViewHolder)myView.getTag();
		
		int columnIndexId = cursor.getColumnIndex(COLUMN_ID);
		int columnIndexLink = cursor.getColumnIndex(COLUMN_LINK);
		
		long webId = cursor.getInt(columnIndexId);
		String link = cursor.getString(columnIndexLink);
		
		holder.setLinkId(webId);
		holder.setUrl(link);
		//holder.setMyTextViewLink(link);
		//String strurl=getMyTextViewLink(link);
		holder.getMyTextViewLink().setText(link);
		//holder.setMyTextViewLink(link);
		
	}

	



	@Override
	public View newView(Context arg0, Cursor arg1, ViewGroup arg2) 
	{
        View myView = myInflator.inflate(R.layout.my_list_item, null);
		
		ViewHolder holder = new ViewHolder();
		TextView myTextView = (TextView)myView.findViewById(R.id.myTextView);
		holder.setMyTextViewLink(myTextView);
		
		myView.setTag(holder);
		
		return myView;
	}


}
