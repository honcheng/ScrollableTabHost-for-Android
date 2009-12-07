package com.mobyfactory.uiwidgets;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/*
 * This activity demonstrates the use of ScrollableTabActivity
 * and setting default on/off colour shades
 * 
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
public class Demo_ScrollableTabHost2 extends ScrollableTabActivity{
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        /*
         * set this activity as the tab bar delegate
         * so that onTabChanged is called when users tap on the bar
         */
        setDelegate(new SliderBarActivityDelegateImpl());
        
        /*
         * optional
         * set default off and on color shades of tab bar button
         * if not specified, opaque areas are shaded gray in off state, and yellow in on state 
         */
        setDefaultShade(RadioStateDrawable.SHADE_GRAY, RadioStateDrawable.SHADE_GREEN);
        
        for (int i=0; i<14; i++)
        {
        	Intent intent;
        	if (i%2==0) intent = new Intent(this, DemoActivity1.class);
        	else intent = new Intent(this, DemoActivity2.class);
        	
        	/*
        	 * This adds a title, and an image to the tab bar button
        	 * Image should be a PNG file with transparent background.
        	 * By default, opaque areas are shaded gray in off state, and yellow in on state 
        	 */
        	this.addTab("title"+i, R.drawable.star, intent);
        	
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
