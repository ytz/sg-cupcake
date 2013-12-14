package com.ytz.sgcupcake;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;

public class MainAdapter extends ParseQueryAdapter<ParseObject> {

	private Context mContext;

	public MainAdapter(Context context, String className) {
		super(context, className);
		mContext = context;
	}

	private static class ViewHolder {
		TextView tv_PostTitle;
		TextView tv_PostSource;
		TextView tv_PostTime;
		// ImageView iv_PostImage;
		ViewPager viewPager;
	}

	@Override
	public View getItemView(ParseObject object, View v, ViewGroup parent) {
		super.getItemView(object, v, parent);
		ViewHolder holder = null;
		if (v == null) {
			v = View.inflate(mContext, R.layout.list_main, null);
			holder = new ViewHolder();
			holder.tv_PostTitle = (TextView) v
					.findViewById(R.id.list_main_tv_title);
			holder.tv_PostSource = (TextView) v
					.findViewById(R.id.list_main_tv_source);
			holder.tv_PostTime = (TextView) v
					.findViewById(R.id.list_main_tv_time);
			// holder.iv_PostImage = (ImageView) v
			// .findViewById(R.id.list_main_iv_post);
			holder.viewPager = (ViewPager) v.findViewById(R.id.view_pager);
			
			v.setTag(holder);
		} else
			holder = (ViewHolder) v.getTag();

		holder.tv_PostTitle.setText(object.getString("postTitle"));
		holder.tv_PostSource.setText(object.getString("postSource"));
		// holder.tv_PostTime
		// UrlImageViewHelper.setUrlDrawable(holder.iv_PostImage, (String)
		// object
		// .getList("postImages").get(0));
		ImageAdapter adapter = new ImageAdapter(mContext, object.getList("postImages"));
		holder.viewPager.setAdapter(adapter);
		return v;
	}
}
