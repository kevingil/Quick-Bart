/*
 *  Copyright (C) 2014  Kevin Gil
*/


package com.kevingil.bart;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;

public class MapActivity extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_right);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		WebView webview = new WebView(this);
		webview.getSettings().setBuiltInZoomControls(true);
		webview.loadUrl("file:///android_asset/index.html");
		setContentView(webview);
		
	}
	
	@Override
	public void finish(){
		super.finish();
		overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
	}
} 
