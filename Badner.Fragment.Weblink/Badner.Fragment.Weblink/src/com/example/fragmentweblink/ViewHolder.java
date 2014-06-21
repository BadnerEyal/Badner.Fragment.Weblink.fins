package com.example.fragmentweblink;

import android.widget.TextView;

public class ViewHolder 
{
	private long LinkId;
	private TextView myTextViewLink;
	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getLinkId() {
		return LinkId;
	}

	public void setLinkId(long linkId) {
		LinkId = linkId;
	}

	

	public TextView getMyTextViewLink() {
		return myTextViewLink;
	}

	public void setMyTextViewLink(TextView myTextViewLink) {
		this.myTextViewLink = myTextViewLink;
	}

	
	
	
	

	
	
	
}
