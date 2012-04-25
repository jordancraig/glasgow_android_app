package com.glasgow.android;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import com.glasgow.android1.R;

public class showAbout extends Activity {
	
	TextView contentTitle;
	TextView contentBody;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        new getContent().execute();
    }
    
    public class Show {
    	public String mTitle;
    	public String mBody;
    	public Bitmap mX;
    	
    	public Show (String title, String body, Bitmap x) {
			mTitle = title;
			mBody = body;
			mX = x;
    	}
    }
    
    public class getContent extends AsyncTask<String, Integer, Show> {

		@Override
		protected Show doInBackground(String... params) {
			Document doc;
			try {
				doc = Jsoup.connect("http://www.glasgowandroid.com/category/about/").timeout(15000).get();
				String title = doc.title();
				Element elC = doc.select("div.entry").first();
				String body = elC.text();
			    Element img = elC.select("img").first();
			    String url = img.absUrl("src");
			    if (url == null) {
			    	Log.d("Image", "URL is null");
			    }
			    
			    Bitmap x;

			    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			    connection.connect();
			    InputStream input = connection.getInputStream();

			    x = BitmapFactory.decodeStream(input);


				return new Show(title, body, x);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String title = "Couldn't return title";
			String body = "Couldn't return body";
			Bitmap x = null;
			return new Show(title, body, x);			
			}
		
		@Override
	    public void onPostExecute(final Show result) {
			if (result.mTitle == "") {
				Log.d("Title", "null");
				finish();
			}
			Log.d("PostExecute", "Been called");
			TextView contentTitle = (TextView) findViewById(R.id.webtext);
			TextView contentBody = (TextView) findViewById(R.id.content);
	    	contentTitle.setText(result.mTitle);
	    	contentBody.setMovementMethod(new ScrollingMovementMethod());
	    	contentBody.setText(result.mBody);
		    ImageView logo = (ImageView) findViewById(R.id.aboutImg);
		    logo.setImageBitmap(result.mX);
	    }
    	
    }
  
}
