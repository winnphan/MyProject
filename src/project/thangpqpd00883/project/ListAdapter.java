//package project.thangpqpd00883.project;
//
//import java.util.List;
//
//import project.thangpqpd00883.obj.Item;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.TextView;
//
//public class ListAdapter extends ArrayAdapter<Item>{
//	public ListAdapter(Context context, int textViewResourceId) {
//	    super(context, textViewResourceId);
//	    // TODO Auto-generated constructor stub
//	}
//
//	private List<Item> items;
//
//	public ListAdapter(Context context, int resource, List<Item> items) {
//
//	    super(context, resource, items);
//
//	    this.items = items;
//	}
//	@Override
//	public View getView(int position, View convertView, ViewGroup parent) {
//
//	    View v = convertView;
//
//	    if (v == null) {
//
//	        LayoutInflater vi;
//	        vi = LayoutInflater.from(getContext());
//	        v = vi.inflate(R.layout.list_layout, null);
//
//	    }
//
//	    Item p = items.get(position);
//
//	    if (p != null) {
//
//	        TextView tt = (TextView) v.findViewById(R.id.game_txtTitle);
//	        TextView tt1 = (TextView) v.findViewById(R.id.game_txtRelease);
//	        TextView tt3 = (TextView) v.findViewById(R.id.game_txtPlatform);
//
//	        if (tt != null) {
//	            tt.setText(p.getId());
//	        }
//	        if (tt1 != null) {
//
//	            tt1.setText(p.getCategory().getId());
//	        }
//	        if (tt3 != null) {
//
//	            tt3.setText(p.getDescription());
//	        }
//	    }
//	}
//	}
