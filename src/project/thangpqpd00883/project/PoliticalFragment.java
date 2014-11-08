package project.thangpqpd00883.project;

import java.util.ArrayList;
import java.util.List;

import project.thangpqpd00883.adapter.CustomListView;
import project.thangpqpd00883.parser.Entry;
import project.thangpqpd00883.parser.ListEntry;
import project.thangpqpd00883.parser.ParserXML;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * A simple {@link Fragment} subclass.
 * 
 */
public class PoliticalFragment extends Fragment {

	public PoliticalFragment() {
		// Required empty public constructor
	}
	
	private String url = "http://vietnamnet.vn/rss/chinh-tri.rss";
	List<Entry> arraylist = new ArrayList<Entry>();
	ListEntry listRss;
	CustomListView adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_political, container, false);
		ListView listview =(ListView)view.findViewById(R.id.lvPolitical);
		
		ParserXML parse = new ParserXML(url);
		listRss = parse.parseXMNCC();
		
		arraylist = listRss.getListEntry();
		for (int i = 0; i <arraylist.size(); i++) {
			Entry entry = arraylist.get(i);
			}
		
			//EDITED Code 
        adapter = new CustomListView(getActivity(),arraylist);
        listview.setAdapter(adapter);  
        listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				
				Fragment fragment = new WebviewFragment();
				FragmentManager frgManager = getFragmentManager();

				frgManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
			}
		});
		return view;
	}

}