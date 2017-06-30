package com.example.util;

import android.content.Context;
import android.widget.ImageView;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.nostra13.universalimageloader.utils.StorageUtils;

/**
	* Created by Administrator on 2016/5/22.
	*/
public class MainListImageLoader {

				ImageView imageView;
				Context mcontext;

				public MainListImageLoader(Context context) {
								mcontext = context;
								ImageLoaderConfiguration config = new ImageLoaderConfiguration
																.Builder(mcontext)
																.threadPriority(Thread.NORM_PRIORITY - 2)
																.denyCacheImageMultipleSizesInMemory()
																.diskCacheFileNameGenerator(new Md5FileNameGenerator())
																.diskCache(new UnlimitedDiskCache(StorageUtils.getCacheDirectory(mcontext)))
																.memoryCacheSizePercentage(13)
																.tasksProcessingOrder(QueueProcessingType.LIFO).build();
								ImageLoader.getInstance().init(config);
				}

				public void displayImage(String path, ImageView imageView, int defaultDrawable) {
								DisplayImageOptions options = new DisplayImageOptions.Builder()
																.cacheOnDisk(true)
																.cacheInMemory(true)
																.showImageOnLoading(defaultDrawable)
																.build();
								ImageLoader.getInstance().
																displayImage(path, new ImageViewAware(imageView), options, null, null, null);
				}
}
