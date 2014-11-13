package project.thangpqpd00883.adapter;

import java.util.List;

import project.thangpqpd00883.image.ImageLoader;
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
	
	public Activity context;
	List<Entry> listEntry;
	public LayoutInflater inflater;
	
	// Khai báo load hình ảnh
	public ImageLoader imageLoader;
	
	
	
	
	public CustomListView(Activity context,List<Entry> listEntry){
		super();
		this.listEntry = listEntry;
		this.context = context;
		inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		imageLoader = new ImageLoader(context.getApplicationContext());
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
			ImageView image = holder.image;
			
			
		}
		Entry a = (Entry) listEntry.get(position);
		holder.image.setImageResource(R.drawable.ic_image);
		imageLoader.DisplayImage(a.getImage(), holder.image);
		holder.titile.setText(a.getTitle());
		holder.pubdate.setText(a.getPubDate());
		
		return view;
	}
	
	public static class viewHolder{
		ImageView image;
		TextView titile,pubdate;
	}
}
