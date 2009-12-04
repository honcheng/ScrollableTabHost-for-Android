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

public class ProjectList extends ListActivity {
	
	static List intentsArray;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        
        intentsArray = new ArrayList();
        
        // show scrollable tabhost demo
        IntentObject demoScrollabelTabHost = new IntentObject();
        demoScrollabelTabHost.title = "Scrollable TabHost";
        demoScrollabelTabHost.description = "com.mobyfactory.scrollabletabhost";
        demoScrollabelTabHost.intent = new Intent(this, Demo_ScrollableTabHost.class);
        intentsArray.add(demoScrollabelTabHost);
        
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