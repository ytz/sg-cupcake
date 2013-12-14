package com.ytz.sgcupcake;

import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class MainActivity extends Activity {

	private ListView mListView;
	private Activity mActivity = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Connect to Parse
		Parse.initialize(this, "Xr0ebqrP7HqOmK3jCH180GLONjLYajZor9F78rH5",
				"EaclW887OtjZCb5oItflXCV5PJo3Zkiof9TgbyS9");

		setContentView(R.layout.activity_main);
		mListView = (ListView) findViewById(R.id.list);
		buildList();
	}

	/**
	 * Build Article/Post ListView
	 */
	private void buildList() {
		// P1
		buildImage();

		MainAdapter adapter = new MainAdapter(this, "MainPost");
		mListView.setAdapter(adapter);
	}

	private void buildImage() {
		ParseQuery<ParseObject> query = ParseQuery.getQuery("MainPost");
		// Lola's Cafe @ Kovan
		ParseObject kovan;
		try {
			kovan = query.get("NVChoNpqZe");
			if (kovan.get("postImages") == null) {
				kovan.addAllUnique(
						"postImages",
						Arrays.asList(
								"http://4.bp.blogspot.com/-mUjtxJKLxJw/UpB4NUH_JgI/AAAAAAAAB1Q/QKShFKH_OvI/s1000/64+lolas+cafe+preview.jpg",
								"http://i988.photobucket.com/albums/af3/jovenaloon2/cafe%20hopping/64lolascafe/P1180820.jpg"));
				kovan.saveInBackground();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Chinatown
		ParseObject chinatown;
		try {
			chinatown = query.get("YHoMvgGKlC");
			if (chinatown.get("postImages") == null) {
				chinatown
						.addAllUnique(
								"postImages",
								Arrays.asList(
										"http://3.bp.blogspot.com/-MN0a_ZXFSVA/Ul6MjYzgkoI/AAAAAAAABpA/-CnVtB91Qts/s800/63+the+loft+cafe+preview.jpg",
										"http://i988.photobucket.com/albums/af3/jovenaloon2/cafe%20hopping/63theloft/P1180275.jpg"));
				chinatown.saveInBackground();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
