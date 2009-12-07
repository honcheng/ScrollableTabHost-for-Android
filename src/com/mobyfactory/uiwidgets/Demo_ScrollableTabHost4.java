package com.mobyfactory.uiwidgets;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/*
 * This activity demonstrates the use of ScrollableTabActivity by extending the class
 * 
 * Required files:
 * ScrollableTabActivity.java
 * RadioStateDrawable.java
 * TabBarButton.java
 * res/drawable/bottom_bar_highlight.9.png
 * res/drawable/bottom_bar.9.png
 * res/drawable/scrollbar_horizontal_thumb.xml
 * res/drawable/scrollbar_horizontal_track.xml
 * res/layout/customslidingtabhost.xml
 * res/layout/scrollgroupradiobuttonview.xml
 */
public class Demo_ScrollableTabHost4  extends ScrollableTabActivity{

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        /*
         * set this activity as the tab bar delegate
         * so that onTabChanged is called when users tap on the bar
         */
        setDelegate(new SliderBarActivityDelegateImpl());
        
        for (int i=0; i<3; i++)
        {
        	Intent intent;
        	if (i%2==0) intent = new Intent(this, DemoActivity1.class);
        	else intent = new Intent(this, DemoActivity2.class);
        	
        	/*
        	 * This adds a title and an image to the tab bar button
        	 * Image should be a PNG file with transparent background.
        	 * Shades are opaque areas in on and off state are specific as parameters
        	 */
        	this.addTab("title"+i, R.drawable.star, RadioStateDrawable.SHADE_GRAY, RadioStateDrawable.SHADE_GREEN,intent);
        }
        
        /*
         * commit is required to redraw the bar after add tabs are added
         * if you know of a better way, drop me your suggestion please.
         */
        commit();
    }
 
    private class SliderBarActivityDelegateImpl extends SliderBarActivityDelegate
    {
    	/*
    	 * Optional callback method
    	 * called when users tap on the tab bar button
    	 */
    	protected void onTabChanged(int tabIndex) 
    	{
    		Log.d("onTabChanged",""+tabIndex);
    	}
    }
}

