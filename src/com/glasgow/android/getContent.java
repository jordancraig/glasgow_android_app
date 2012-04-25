package com.glasgow.android;


import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.Preference.OnPreferenceClickListener;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.glasgow.android1.R;

public class getContent extends PreferenceActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.menu);
        haveNetworkConnection();
        showBlog();
    }
    
    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
      	
        }
        if (haveConnectedWifi == false && haveConnectedMobile == false) {
        	Log.d("Network State", "false");
    	    AlertDialog.Builder alert = new AlertDialog.Builder(getContent.this);                 
    	    alert.setTitle("No Data Connection!");  
    	    alert.setMessage("You have no data connection, click ok to turn on WiFi in order to load content.");   
    	        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int whichButton) {
						// TODO Auto-generated method stub
                        final Intent intent = new Intent(Intent.ACTION_MAIN, null);
                        intent.addCategory(Intent.CATEGORY_LAUNCHER);
                        final ComponentName cn = new ComponentName("com.android.settings", "com.android.settings.wifi.WifiSettings");
                        intent.setComponent(cn);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity( intent);
					}
    	        	
    	        });
    	        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

    	            public void onClick(DialogInterface dialog, int which) {
    	                // TODO Auto-generated method stub
    	            	finish();
    	                return;   
    	            }
    	        });
    	        alert.show();
        	
        }else{
        	
        }
        return haveConnectedWifi || haveConnectedMobile;
    }
    
    public void showBlog() {
    	//beginning of about listener
        Preference about = (Preference) findPreference("about_pref");
        about.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
		    	 Intent intent = new Intent();
				 intent.setClass(getApplicationContext(), showAbout.class);
				 startActivity(intent);
				return false;				
			}     	
        });
        //end of about listener
        
        //beginning of blog listener
        Preference blog = (Preference) findPreference("blog_pref");
        blog.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
		    	 Intent intent = new Intent();
				 intent.setClass(getApplicationContext(), showRecentBlog.class);
				 startActivity(intent);
				return false;				
			}     	
        });
        //end of blog listener
        
        //beginning of join listener
        Preference join = (Preference) findPreference("joinus_pref");
        join.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
		    	 Intent intent = new Intent();
				 intent.setClass(getApplicationContext(), joinIn.class);
				 startActivity(intent);
				return false;				
			}     	
        });
        //end of join listener
        
        //beginning of sponsors listener
        Preference sponsors = (Preference) findPreference("sponsors_pref");
        sponsors.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
		    	 Intent intent = new Intent();
				 intent.setClass(getApplicationContext(), sponsors.class);
				 startActivity(intent);
				 return false;				
			}     	
        });
        //end of sponsors listener
        
        //beginning of follow listener
        Preference follow = (Preference) findPreference("social_pref");
        follow.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
		    	 Intent intent = new Intent();
				 intent.setClass(getApplicationContext(), socialNetwork.class);
				 startActivity(intent);
				 return false;						
			}     	
        });
        //end of follow listener
        
        
        //beginning of follow listener
        Preference maps = (Preference) findPreference("maps_pref");
        maps.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
		    	 Intent intent = new Intent();
				 intent.setClass(getApplicationContext(), showOnMap.class);
				 startActivity(intent);
				 return false;						
			}     	
        });
        //end of follow listener
    }
}