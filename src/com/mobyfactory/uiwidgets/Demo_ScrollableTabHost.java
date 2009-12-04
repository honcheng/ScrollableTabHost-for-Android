package com.mobyfactory.uiwidgets;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class Demo_ScrollableTabHost  extends ScrollableTabActivity{

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setDelegate(new SliderBarActivityDelegateImpl());
        
        for (int i=0; i<14; i++)
        {
        	Intent intent;
        	if (i%2==0) intent = new Intent(this, DemoActivity1.class);
        	else intent = new Intent(this, DemoActivity2.class);

            //this.addTab("title"+i, R.drawable.android_green, R.drawable.android_gray, intent);
        	//this.addTab("title"+i, R.drawable.star, intent);
        	//this.addTab("title"+i, R.drawable.icon, R.drawable.icon, intent);
        	this.addTab("title"+i, R.drawable.star, RadioStateDrawable.SHADE_GRAY, RadioStateDrawable.SHADE_YELLOW,intent);
        }
        commit();
    }
 
    private class SliderBarActivityDelegateImpl extends SliderBarActivityDelegate
    {
    	protected void onTabChanged(int tabIndex) 
    	{
    		Log.d("onTabChanged",""+tabIndex);
    	}
    }
}
