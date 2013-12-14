package com.ytz.sgcupcake;

import java.util.List;

import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageAdapter extends PagerAdapter {
	Context mContext;
	List<Object> imageUrl;

	ImageAdapter(Context context, List<Object> list) {
		mContext = context;
		this.imageUrl = list;
	}

	@Override
	public int getCount() {
		return imageUrl.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == ((ImageView) object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		ImageView imageView = new ImageView(mContext);
		//int padding = context.getResources().getDimensionPixelSize(
				//R.dimen.padding_medium);
		//imageView.setPadding(padding, padding, padding, padding);
		//imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		//imageView.setImageResource(GalImages[position]);
		UrlImageViewHelper.setUrlDrawable(imageView, (String) imageUrl.get(position));
		((ViewPager) container).addView(imageView, 0);
		return imageView;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager) container).removeView((ImageView) object);
	}
}