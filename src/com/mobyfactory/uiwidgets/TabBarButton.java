/**
 * Copyright (c) 2009 Muh Hon Cheng
 * 
 * Permission is hereby granted, free of charge, to any person obtaining 
 * a copy of this software and associated documentation files (the 
 * "Software"), to deal in the Software without restriction, including 
 * without limitation the rights to use, copy, modify, merge, publish, 
 * distribute, sublicense, and/or sell copies of the Software, and to 
 * permit persons to whom the Software is furnished to do so, subject 
 * to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be 
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT 
 * WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF 
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR 
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT 
 * SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE 
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, 
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR 
 * IN CONNECTION WITH THE SOFTWARE OR 
 * THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 * @author 		Muh Hon Cheng <honcheng@gmail.com>
 * @copyright	2009	Muh Hon Cheng
 * @version
 * 
 */


package com.mobyfactory.uiwidgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.RadioButton;

public class TabBarButton extends RadioButton{
	
	Context context;
	public TabBarButton(Context context) {
		super(context);
		this.context = context;
	}
	
	public TabBarButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
	}
	
	public void setState(String label, int imageId)
	{
		RadioStateDrawable offDrawable = new RadioStateDrawable(context, imageId, label, false, RadioStateDrawable.SHADE_GRAY);
		RadioStateDrawable onDrawable = new RadioStateDrawable(context, imageId, label, true, RadioStateDrawable.SHADE_YELLOW);
		setStateImageDrawables(onDrawable,offDrawable);
	}
	
	public void setState(String label, int imageId, int offState, int onState)
	{
		RadioStateDrawable offDrawable = new RadioStateDrawable(context, imageId, label, false, offState);
		RadioStateDrawable onDrawable = new RadioStateDrawable(context, imageId, label, true, onState);
		setStateImageDrawables(onDrawable,offDrawable);
	}

	public void setState(String label, int onId, int offId)
	{
		Resources resource = this.getResources();
		Drawable offDrawable = resource.getDrawable(offId);
		Drawable onDrawable = resource.getDrawable(onId);
		setStateImageDrawables(onDrawable,offDrawable);
	}
	
	private void setStateImageDrawables(Drawable onDrawable, Drawable offDrawable)
	{
		StateListDrawable drawables = new StateListDrawable();
		
		int stateChecked = android.R.attr.state_checked;
		int stateFocused = android.R.attr.state_focused;
		int statePressed = android.R.attr.state_pressed;
		int stateWindowFocused = android.R.attr.state_window_focused;
		
		Resources resource = this.getResources();
		Drawable xDrawable = resource.getDrawable(R.drawable.bottom_bar_highlight);
		
		drawables.addState(new int[]{ stateChecked, -stateWindowFocused}, offDrawable);
		drawables.addState(new int[]{-stateChecked, -stateWindowFocused}, offDrawable);
		drawables.addState(new int[]{ stateChecked,  statePressed      }, onDrawable);
		drawables.addState(new int[]{-stateChecked,  statePressed      }, onDrawable);
		drawables.addState(new int[]{ stateChecked,  stateFocused      }, onDrawable);
		drawables.addState(new int[]{-stateChecked,  stateFocused      }, offDrawable);
		drawables.addState(new int[]{ stateChecked                     }, onDrawable);
		drawables.addState(new int[]{-stateChecked                     }, offDrawable);
		drawables.addState(new int[]{                  				   }, xDrawable);
		this.setButtonDrawable(drawables);
	}
}
