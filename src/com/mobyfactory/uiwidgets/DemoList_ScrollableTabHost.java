package com.mobyfactory.uiwidgets;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
	
public class DemoList_ScrollableTabHost extends ListActivity{
	
	static List intentsArray;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        
        intentsArray = new ArrayList();
        
        // Set default on/off colour shades
        IntentObject demoScrollabelTabHost2 = new IntentObject();
        demoScrollabelTabHost2.title = "Set default on/off colour shades";
        demoScrollabelTabHost2.description = "File: Demo_ScrollableTabHost2";
        demoScrollabelTabHost2.intent = new Intent(this, Demo_ScrollableTabHost2.class);
        intentsArray.add(demoScrollabelTabHost2);
        
        // Set on/off colour shades individually
        IntentObject demoScrollabelTabHost = new IntentObject();
        demoScrollabelTabHost.title = "Set on/off colour shades individually";
        demoScrollabelTabHost.description = "File: Demo_ScrollableTabHost";
        demoScrollabelTabHost.intent = new Intent(this, Demo_ScrollableTabHost.class);
        intentsArray.add(demoScrollabelTabHost);
        
        // Set on/off images
        IntentObject demoScrollabelTabHost3 = new IntentObject();
        demoScrollabelTabHost3.title = "Set different on/off images";
        demoScrollabelTabHost3.description = "File: Demo_ScrollableTabHost3";
        demoScrollabelTabHost3.intent = new Intent(this, Demo_ScrollableTabHost3.class);
        intentsArray.add(demoScrollabelTabHost3);
        
        // Shows that scroll view is hidden and tabs are spaced out with less items
        IntentObject demoScrollabelTabHost4 = new IntentObject();
        demoScrollabelTabHost4.title = "ScrollView hidden with less items";
        demoScrollabelTabHost4.description = "File: Demo_ScrollableTabHost4";
        demoScrollabelTabHost4.intent = new Intent(this, Demo_ScrollableTabHost4.class);
        intentsArray.add(demoScrollabelTabHost4);
        
        setListAdapter(new EfficientAdapter(this));
    }
    
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
    	Intent intent = ((IntentObject)intentsArray.get(position)).intent;
		startActivity(intent);
    }
    
    private static class EfficientAdapter extends BaseAdapter {
		
        private LayoutInflater mInflater;
        
        public EfficientAdapter(Context context) {
            mInflater = LayoutInflater.from(context);
        }

        public int getCount() {
            return intentsArray.size();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
        
            ViewHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.title_and_description_cell, null);
                holder = new ViewHolder();
                holder.text = (TextView) convertView.findViewById(R.id.title);
                holder.description = (TextView) convertView.findViewById(R.id.description);
                convertView.setTag(holder);
            } else {

                holder = (ViewHolder) convertView.getTag();
            }   
            holder.text.setText(((IntentObject)intentsArray.get(position)).title);
            holder.description.setText(((IntentObject)intentsArray.get(position)).description);
            return convertView;
        }

        static class ViewHolder {
            TextView text;
            TextView description;
        }
    }
}
