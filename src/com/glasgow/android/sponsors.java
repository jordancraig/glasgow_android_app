package com.glasgow.android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.Preference.OnPreferenceClickListener;
import com.glasgow.android1.R;

public class sponsors extends PreferenceActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.sponsors);
        
        Preference fya = (Preference) findPreference("fya");
        fya.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
                String url = "http://www.freeyourandroid.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
				return true;				
			}     	
        });
        
        Preference lod = (Preference) findPreference("lod");
        lod.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
                String url = "http://www.landofdroid.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
				return true;				
			}     	
        });
        
        Preference htc = (Preference) findPreference("htc");
        htc.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
                String url = "http://www.htcdev.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
				return true;				
			}     	
        });
        
        Preference three = (Preference) findPreference("htc");
        three.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
                String url = "http://www.htcdev.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
				return true;				
			}     	
        });
        
        Preference clove = (Preference) findPreference("clove");
        clove.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
                String url = "http://www.clove.co.uk";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
				return true;				
			}     	
        });
    }
	
}
