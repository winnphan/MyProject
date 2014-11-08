package project.thangpqpd00883.adapter;

import java.util.List;

import project.thangpqpd00883.parser.Entry;
import project.thangpqpd00883.project.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		viewHolder holder;
		if(view==null){
			holder = new viewHolder();
			view = inflater.inflate(R.layout.custom_listview, null);
			holder.image=(ImageView)view.findViewById(R.id.image);
			holder.titile=(TextView)view.findViewById(R.id.title);
			holder.pubdate=(TextView)view.findViewById(R.id.pubdate);			
			view.setTag(holder);
		}else{
			holder = (viewHolder) view.getTag();
		}
		Entry a = (Entry) listEntry.get(position);
		holder.image.setImageResource(R.drawable.ic_image);
		holder.titile.setText(a.getTitle());
		holder.pubdate.setText(a.getPubDate());
		
		return view;
	}
	
	public static class viewHolder{
		ImageView image;
		TextView titile,pubdate;
	}
}
