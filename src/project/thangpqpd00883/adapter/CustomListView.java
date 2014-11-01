package project.thangpqpd00883.adapter;

import java.util.List;

import project.thangpqpd00883.parser.Entry;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CustomListView extends BaseAdapter {
	
	List<Entry> listEntry;
	public Activity context;
	public LayoutInflater inflater;
	
	
	public CustomListView(Activity context,List<Entry> listEntry){
		super();
		this.listEntry = listEntry;
		this.context = context;
		inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listEntry.size();
	}


	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return listEntry.get(position);
	}


	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}
}
