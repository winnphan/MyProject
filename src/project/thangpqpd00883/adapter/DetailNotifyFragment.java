package project.thangpqpd00883.adapter;

import java.util.ArrayList;
import java.util.List;

import project.thangpqpd00883.parser.Entry;
import project.thangpqpd00883.parser.ListEntry;
import project.thangpqpd00883.project.R;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass. Activities that contain this fragment
 * must implement the {@link DetailNotifyFragment.OnFragmentInteractionListener}
 * interface to handle interaction events. Use the
 * {@link DetailNotifyFragment#newInstance} factory method to create an instance
 * of this fragment.
 * 
 */
@SuppressLint("NewApi") public class DetailNotifyFragment extends Fragment {
	List<Entry> arraylist = new ArrayList<Entry>();
	ListEntry listRss;
	
	// TODO: Rename parameter arguments, choose names that match
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
	public static final String ARG_WEB = "WEB_KEY";
	public static final String ARG_URL = "WEB_URL";

	// TODO: Rename and change types of parameters
	private String mWeb;
	private int mID;
	private String url;

	private OnFragmentInteractionListener mListener;

	/**
	 * Use this factory method to create a new instance of this fragment using
	 * the provided parameters.
	 * 
	 * @param webkey
	 *            Parameter 1.
	 * @param webid
	 *            Parameter 2.
	 * @return A new instance of fragment DetailNotifyFragment.
	 */
	// TODO: Rename and change types and number of parameters
	public static DetailNotifyFragment newInstance(String webkey, String webid) {
		DetailNotifyFragment fragment = new DetailNotifyFragment();
		Bundle args = new Bundle();
		args.putString(ARG_WEB, webkey);
		args.putString(ARG_URL, webid);
		fragment.setArguments(args);
		return fragment;
	}

	public DetailNotifyFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			mWeb = getArguments().getString(ARG_WEB);
			mID = getArguments().getInt(ARG_URL);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_detail_notify, container,false);
		WebView wv = (WebView) view.findViewById(R.id.wvWordItem);
		url = getArguments().getString(ARG_URL);
		wv.loadUrl(url);
		return view;
	}
	

	


	/**
	 * This interface must be implemented by activities that contain this
	 * fragment to allow an interaction in this fragment to be communicated to
	 * the activity and potentially other fragments contained in that activity.
	 * <p>
	 * See the Android Training lesson <a href=
	 * "http://developer.android.com/training/basics/fragments/communicating.html"
	 * >Communicating with Other Fragments</a> for more information.
	 */
	public interface OnFragmentInteractionListener {
		// TODO: Update argument type and name
		public void onFragmentInteraction(Uri uri);
	}

}
