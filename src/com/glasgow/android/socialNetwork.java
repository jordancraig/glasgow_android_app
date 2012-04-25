package com.glasgow.android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.Preference.OnPreferenceClickListener;
import com.glasgow.android1.R;

public class socialNetwork extends PreferenceActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.socialnetwork);
        
        Preference twitter = (Preference) findPreference("twitter_pref");
        twitter.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
                String url = "https://www.twitter.com/#!/GlasgowAndroid";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
				return true;				
			}     	
        });
        
        
        Preference plus = (Preference) findPreference("google_pref");
        plus.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
                String url = "https://plus.google.com/117302776812400153217";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
				return true;				
			}     	
        });
    }

}
