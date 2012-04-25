package com.glasgow.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.glasgow.android1.R;

public class joinIn extends Activity {
    /** Called when the activity is first created. */
	Context mContext;
	EditText mEmail;
	EditText mName;
	EditText mTwitter;
	EditText mQuestion;
	String Twitter;
	String Name;
	String Email;
	String Question;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joinus);
        
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
    	btnSubmit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mEmail = (EditText) findViewById(R.id.editEmail);
				mName = (EditText) findViewById(R.id.editName);
				mTwitter = (EditText) findViewById(R.id.editTwitter);
				mQuestion = (EditText) findViewById(R.id.editQuestion);
				Twitter = mTwitter.getText().toString();
				Name = mName.getText().toString();
				Email = mEmail.getText().toString();
				Question = mQuestion.getText().toString();
				
				String mySubject = "Interest from: " + mEmail.getText().toString();
				String myBodyText = "E-mail: " +  Email + "\n" + "Name: " + Name + "\n" + "Twitter: " + Twitter + "\n" + "\n" + "Question/Additional Details: " + Question;
				
		        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		        emailIntent.setType("plain/text");
		        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"gary@glasgowandroid.com"});
		        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, mySubject);   
		        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, myBodyText);      
		        startActivity(Intent.createChooser(emailIntent, "Send via: "));
			}
    		
    	});
        
        
        

    }
    
}
