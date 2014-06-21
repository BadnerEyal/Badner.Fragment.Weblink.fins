package com.example.fragmentweblink;



import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.fragmentweblink.MyListFragment.ListFragmentListener;

public class MainActivity extends FragmentActivity implements ListFragmentListener
	{
	FragmentManager fm;
	
	
	protected static final String HTTP = "http://";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//setHasOptionsMenu(true);
		
		fm = getSupportFragmentManager();
		// if im phone
		if (findViewById(R.id.phoneLayout) != null) {
			MyListFragment list = new MyListFragment();
			fm.beginTransaction().add(R.id.phoneLayout, list, "list").commit();
		} else {
			MyListFragment list = new MyListFragment();
			BrowserFragment browser = new BrowserFragment();
			fm.beginTransaction().add(R.id.listFrame, list, "list")
					.add(R.id.browserFrame, browser, "browser").commit();
		}
	}

	@Override
	  public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.activity_main, menu);
	    return true;
	  } 
	@SuppressLint("NewApi")
	@Override
	  public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    // action with ID action_refresh was selected
	    case R.id.action_add:
	    	
	    	//new MyDialogFragment().show(getFragmentManager(), "MyDialog");
	    	
	    	MyDialogabot iMyDialogabot = new MyDialogabot(MainActivity.this);
  			//לאנמציה דיאלוג שימוש גם בסטיל
  				iMyDialogabot.getWindow().getAttributes().windowAnimations = R.style.Animations_SmileWindow;
  				
  				iMyDialogabot.show();
	      Toast.makeText(this, "add selected", Toast.LENGTH_SHORT)
	          .show();
	      break;
         case R.id.action_delete:
	    	
	    	//new MyDialogFragment().show(getFragmentManager(), "MyDialog");
	    	
	      Toast.makeText(this, "delete selected", Toast.LENGTH_SHORT)
	          .show();
	      break;
	    
	    default:
	      break;
	    }

	    return true;
	  } 

	@Override
	public void setBrowserText(String url) {
		if (findViewById(R.id.phoneLayout) != null) {
			BrowserFragment browser = new BrowserFragment();
			fm.beginTransaction().replace(R.id.phoneLayout, browser, "browser").addToBackStack(null).commit();
			//מוודא שהשיכבה עם הדפדפן נמצאת לפני שמכניסים לתוכה URL חדש
			fm.executePendingTransactions();
			browser.changlink(url);
		}
		else{
			//BrowserFragment fragmentB = (BrowserFragment)getSupportFragmentManager().findFragmentById(R.id.);
			//fragmentB.changeText(value);
			//browser.changlink(url);
			//_webView.loadUrl(url);
			
			WebView _webView = (WebView) findViewById(R.id.wv);
			EditText addressEditText = (EditText)findViewById(R.id.web_address_edit_text);
			addressEditText.setText(url);
			
			if (addressEditText.getText().toString().startsWith(HTTP))
			{
				_webView.loadUrl(addressEditText.getText().toString());
			} else
			{
				_webView.loadUrl(HTTP
						+ addressEditText.getText().toString());
			}
		}
		
		
		
	}
	/**קלאס הוספה */
	private class MyDialogabot extends Dialog{
	
	public MyDialogabot(Context context) {
			super(context);
			setContentView(R.layout.dialogadd);
			setTitle("About apps");
			ImageView ok=(ImageView)findViewById(R.id.imageViewok);
			ok.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					dismiss();
				}
			});
			
        	}	
		}	
	
	 

	

}
