package com.glasgow.android;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import com.glasgow.android1.R;

public class showRecentBlog extends Activity {
	TextView contentTitle;
	TextView contentBody;
	MenuItem refresh;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blog);  
        new getContent().execute();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar_menu, menu);  
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh:
	    			TextView contentTitle = (TextView) findViewById(R.id.title);
	    			TextView contentBody = (TextView) findViewById(R.id.blogContent);
	    	    	contentTitle.setText("Loading... Please wait.");
	    	    	contentBody.setText("");
	    	    	TextView postedAt = (TextView) findViewById(R.id.tvTime);
	    	    	postedAt.setText("");
            		new getContent().execute();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    
    public class Show {
    	public String mTitle;
    	public String mBody;
    	public String mTime;
    	
    	public Show (String title, String body, String time) {
			mTitle = title;
			mBody = body;
			mTime = time;
    	}
    }
    
    public class getContent extends AsyncTask<String, Integer, Show> {

		@Override
		protected Show doInBackground(String... params) {
			Document doc;
			try {
				doc = Jsoup.connect("http://www.glasgowandroid.com/category/blog/").timeout(15000).get();
				Element titleEl = doc.select("h2.title").first();
				String title= titleEl.text();
				Element elC = doc.select("div.entry").first();
				Element meta_time = doc.select("span.meta_date").first();
				String time = meta_time.text();
				String body = elC.text();
				return new Show(title, body, time);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String title = "Couldn't return title";
			String body = "Couldn't return body";
			String time = "";
			return new Show(title, body, time);			
			}
		
		@Override
	    public void onPostExecute(final Show result) {
			if (result.mTitle == "") {
				Log.d("Title", "null");
				finish();
			}
			Log.d("PostExecute", "Been called"); 
			TextView contentTitle = (TextView) findViewById(R.id.title);
			TextView contentBody = (TextView) findViewById(R.id.blogContent);
	    	contentTitle.setText(result.mTitle);
	    	contentBody.setMovementMethod(new ScrollingMovementMethod());
	    	contentBody.setText(result.mBody);
	    	TextView postedAt = (TextView) findViewById(R.id.tvTime);
	    	postedAt.setText("\n" + "Posted: " + result.mTime);
	    }
    	
    }
}
