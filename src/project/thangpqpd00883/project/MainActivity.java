package project.thangpqpd00883.project;

import java.util.ArrayList;
import java.util.List;


import project.thangpqpd00883.obj.DrawerItem;



import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class MainActivity extends Activity {
	
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	CustomDrawerAdapter adapter;

	List<DrawerItem> dataList;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// Initializing
		dataList = new ArrayList<DrawerItem>();
		mTitle = mDrawerTitle = getTitle();
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		// Add Drawer Item to dataList
		dataList.add(new DrawerItem("Trang chủ", R.drawable.ic_home));
		dataList.add(new DrawerItem("Thời sự", R.drawable.ic_news));
		dataList.add(new DrawerItem("Đời sống", R.drawable.ic_life));
		dataList.add(new DrawerItem("Thế giới", R.drawable.ic_world));
		dataList.add(new DrawerItem("Kinh doanh", R.drawable.ic_business));
		dataList.add(new DrawerItem("Giải trí", R.drawable.ic_entertainment));
		dataList.add(new DrawerItem("Thể thao", R.drawable.ic_sport));
		dataList.add(new DrawerItem("Pháp luật", R.drawable.ic_laws));
		dataList.add(new DrawerItem("Du lịch", R.drawable.ic_travel));
		dataList.add(new DrawerItem("Khoa học",R.drawable.ic_scientific));
		dataList.add(new DrawerItem("Số hóa", R.drawable.ic_technology));
		dataList.add(new DrawerItem("Xe", R.drawable.ic_car));
		dataList.add(new DrawerItem("Cộng đồng", R.drawable.ic_comunity));
		dataList.add(new DrawerItem("Tâm sự", R.drawable.ic_messager));
		dataList.add(new DrawerItem("Cười", R.drawable.ic_smile));
		dataList.add(new DrawerItem("About", R.drawable.ic_about));

		adapter = new CustomDrawerAdapter(this, R.layout.custom_drawer_item,dataList);

		mDrawerList.setAdapter(adapter);

		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,R.string.drawer_close) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}
		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {
			SelectItem(0);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void SelectItem(int possition) {

		Fragment fragment = null;
		Bundle args = new Bundle();
		switch (possition) {
		case 0:
			fragment = new HomeFragment();
			break;
		case 1:
			fragment = new NewsFragment();
			break;
		case 2:
			fragment = new LifeFragment();
			break;
		case 3:
			fragment = new WorldFragment();
			break;
		case 4:
			fragment = new BussinesFragment();
			break;
		case 5:
			fragment = new EntertainmentFragment();
			break;
		case 6:
			fragment = new SportFragment();
			break;
		case 7:
			fragment = new LawsFragment();
			break;
		case 8:
			fragment = new TravelFragment();
			break;
		case 9:
			fragment = new ScientificFragment();
			break;
		case 10:
			fragment = new TechnologyFragment();
			break;
		case 11:
			fragment = new CarFragment();
			break;
		case 12:
			fragment = new ComunityFragment();
			break;
		case 13:
			fragment = new MessagerFragment();
			break;
		case 14:
			fragment = new SmileFragment();
			break;
		case 15:
			fragment = new AboutFragment();
			break;
		default:
			break;
		}

		fragment.setArguments(args);
		FragmentManager frgManager = getFragmentManager();
		frgManager.beginTransaction().replace(R.id.content_frame, fragment)
				.commit();

		mDrawerList.setItemChecked(possition, true);
		setTitle(dataList.get(possition).getItemName());
		mDrawerLayout.closeDrawer(mDrawerList);

	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggles
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// The action bar home/up action should open or close the drawer.
		// ActionBarDrawerToggle will take care of this.
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}

		return false;
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			SelectItem(position);

		}
	}
}

