package com.example.fragmentweblink;

import java.util.ArrayList;
import java.util.List;




import android.R.string;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MyListFragment extends ListFragment  {
	
	public static final String INDICATOR_NAME = "hgf";

	private WebDatabaseHandler handler = null;
	
//	public AreaCursorAdapter mAdapter;
	
	private WebCursorAdapter myAdapter = null;
	
	private Cursor cursor;
	// private AreaCursorAdapter mAdapter;
	
	private ListFragmentListener lfl;
	//ArrayList<String> arr;
	public interface ListFragmentListener{
		void setBrowserText(String text);
	}
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try{
		lfl = (ListFragmentListener)activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(
					"you must implement ListFragmentListener in your Activity");
		}
	}
	@Override
public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	//arr = new ArrayList<String>();
	//arr.add("aaa");
	//arr.add("bbb");
	//arr.add("ccc");
	//AreaCursorAdapter adapter = new AreaCursorAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arr);
	//AreaCursorAdapter adapter= new AreaCursorAdapter(getActivity(), null);
	//setListAdapter(adapter);
	
	
	//myListView = (ListView)findViewById(R.id.myListView);
	
	handler = new WebDatabaseHandler(getActivity());
	
	//handler.addLink("title", "description", "www.cnn.com", "category", "origin");
	
  //  handler.addLink("title"," description","http://www.mysamplecode.com/2012/08/android-fragment-example.html", "category", "origin");
	
	
	cursor =  handler.getAllLink();
	myAdapter = new WebCursorAdapter(getActivity(), cursor);
	
	setListAdapter(myAdapter);
	
	
	
	
	
}
	@Override
	public void onListItemClick(ListView list, View view, int position, long id) {
		super.onListItemClick(list, view, position, id);
		
	//	Web web = list.getTag(position);
		ViewHolder holder = (ViewHolder)view.getTag();
		
		long getLinkId = holder.getLinkId();
		
	    String strurl=holder.getUrl();
		lfl.setBrowserText(strurl);
		//LinkData data = ( (LinkAdapter) la ).getItem(position);
		//( (ChangeLinkListener)  getActivity()).onLinkChange(data.getLink());
		//בזמן לחיצה על שורה נעביר לפי המיקום את הערך לפרגמנט השני להצגה
    	//((SwitchFragmentsListener)getActivity()).switchAB("http://www.facebook.com");
	}


	}
	