package project.thangpqpd00883.main;

import java.util.ArrayList;
import java.util.List;

import project.thangpqpd00883.adapter.CustomDrawerAdapter;
import project.thangpqpd00883.obj.DrawerItem;
import project.thangpqpd00883.project.AboutFragment;
import project.thangpqpd00883.project.CultureFragment;
import project.thangpqpd00883.project.EconomicFragment;
import project.thangpqpd00883.project.EducationFragment;
import project.thangpqpd00883.project.HomeFragment;
import project.thangpqpd00883.project.InternationalFragment;
import project.thangpqpd00883.project.LifeFragment;
import project.thangpqpd00883.project.NewHighLightFragment;
import project.thangpqpd00883.project.NewsFragment;
import project.thangpqpd00883.project.PictureFragment;
import project.thangpqpd00883.project.PoliticalFragment;
import project.thangpqpd00883.project.R;
import project.thangpqpd00883.project.ReaderFragment;
import project.thangpqpd00883.project.ScienceFragment;
import project.thangpqpd00883.project.SocialFragment;
import project.thangpqpd00883.project.TechnologyFragment;
import project.thangpqpd00883.project.VietnamweekFragment;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

@SuppressLint("NewApi")
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
		dataList.add(new DrawerItem("Tin Mới Nóng", R.drawable.ic_hotnews));
		dataList.add(new DrawerItem("Tin Nổi Bật", R.drawable.ic_newhighlight));
		dataList.add(new DrawerItem("Xã Hội", R.drawable.ic_social));
		dataList.add(new DrawerItem("Giáo dục", R.drawable.ic_education));
		dataList.add(new DrawerItem("Chính trị", R.drawable.ic_politics));
		dataList.add(new DrawerItem("Tuần Việt Nam", R.drawable.ic_celendar));
		dataList.add(new DrawerItem("Đời sống", R.drawable.ic_life));
		dataList.add(new DrawerItem("Kinh tế", R.drawable.ic_economic));
		dataList.add(new DrawerItem("Quốc tế", R.drawable.ic_international));
		dataList.add(new DrawerItem("Văn hóa", R.drawable.ic_culture));
		dataList.add(new DrawerItem("Khoa học", R.drawable.ic_science));
		dataList.add(new DrawerItem("Công nghệ", R.drawable.ic_technology));
		dataList.add(new DrawerItem("Bạn đọc", R.drawable.ic_readers));
		dataList.add(new DrawerItem("Thế giới ảnh", R.drawable.ic_camera));
		dataList.add(new DrawerItem("Cài đặt", R.drawable.ic_settings));
		dataList.add(new DrawerItem("About", R.drawable.ic_about));

		adapter = new CustomDrawerAdapter(this, R.layout.custom_drawer_item,
				dataList);

		mDrawerList.setAdapter(adapter);

		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		getActionBar().setDisplayHomeAsUpEnabled(true);

		getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {
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

		
		// ================================= Connection ===============================================
		if (!isOnline()) {
			showNoConnectionDialog(this);
		} else {
			Toast.makeText(getApplicationContext(), "Internet Conected",Toast.LENGTH_SHORT).show();
			if (savedInstanceState == null) {
				SelectItem(0);
			}
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
			fragment = new NewHighLightFragment();
			break;
		case 3:
			fragment = new SocialFragment();
			break;
		case 4:
			fragment = new EducationFragment();
			break;
		case 5:
			fragment = new PoliticalFragment();
			break;
		case 6:
			fragment = new VietnamweekFragment();
			break;
		case 7:
			fragment = new LifeFragment();
			break;
		case 8:
			fragment = new EconomicFragment();
			break;
		case 9:
			fragment = new InternationalFragment();
			break;
		case 10:
			fragment = new CultureFragment();
			break;
		case 11:
			fragment = new ScienceFragment();
			break;
		case 12:
			fragment = new TechnologyFragment();
			break;
		case 13:
			fragment = new ReaderFragment();
			break;
		case 14:
			fragment = new PictureFragment();
			break;
		case 15:
			Intent intent = new Intent();
			startActivity(intent);
			break;
		case 16:
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
		public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
			SelectItem(position);

		}
	}

	@Override
	public void onBackPressed() {
		final FragmentManager fm = getFragmentManager();
		if (fm.getBackStackEntryCount() == 0) {
			// TODO Auto-generated method stub
			AlertDialog alertbox = new AlertDialog.Builder(this)
					.setMessage("Do you want to exit application?")
					.setPositiveButton("Yes",
							new DialogInterface.OnClickListener() {
								// do something when the button is clicked
								public void onClick(DialogInterface arg0,
										int arg1) {
									finish();
								}
							})
					.setNegativeButton("No",
							new DialogInterface.OnClickListener() {
								// do something when the button is clicked
								public void onClick(DialogInterface arg0,
										int arg1) {
								}
							}).show();
		} else {
			super.onBackPressed();
		}
	}

	
	// =========================== Connection ==========================================
	public static void showNoConnectionDialog(Context ctx1) {
		final Context ctx = ctx1;
		AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
		builder.setCancelable(true);
		builder.setMessage("Không có kết nối internet bạn vui lòng kết lại với internet và vào lại ứng dụng");
		builder.setTitle("No network conection");
		builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				ctx.startActivity(new Intent(Settings.ACTION_SETTINGS));
			}
		});
		builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				 
			}
		});
		builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
			public void onCancel(DialogInterface dialog) {
				return;
			}
		});
		builder.show();
	}

	public boolean isOnline() {
		boolean kq = false;
		try {
			ConnectivityManager connect = (ConnectivityManager) this
					.getSystemService(this.CONNECTIVITY_SERVICE);
			if (connect != null) {
				NetworkInfo[] info = connect.getAllNetworkInfo();
				if (info != null)
					for (int i = 0; i < info.length; i++)
						if (info[i].getState() == NetworkInfo.State.CONNECTED) {
							kq = true;
						} else {
							kq = false;
						}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return kq;

	}

}
