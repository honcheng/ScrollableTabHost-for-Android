package com.mobyfactory.uiwidgets;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DemoActivity2 extends Activity{
	
	Context context;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_activity2);
        context = this;
        
        Button button = (Button)findViewById(R.id.Button01);
        button.setOnClickListener(
            	new OnClickListener()
            	{
    				public void onClick(View v) {
    					Intent intent = new Intent(context, DemoActivity1.class);
    			        context.startActivity(intent);
    				}	
            	}
         );
        
        Button button2 = (Button)findViewById(R.id.Button02);
        button2.setOnClickListener(
            	new OnClickListener()
            	{
    				public void onClick(View v) {
    					Intent intent = new Intent(ScrollableTabActivity.ACTION_CHANGE_TAB);
    					intent.putExtra(ScrollableTabActivity.CURRENT_TAB_INDEX, 0);
    					sendBroadcast(intent);
    				}	
            	}
         );
    }
}

