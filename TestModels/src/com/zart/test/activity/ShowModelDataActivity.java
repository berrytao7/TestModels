package com.zart.test.activity;

import com.zart.test.model.AlbumModel;
import com.zart.test.model.ArtistModel;
import com.zart.test.model.TrackModel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowModelDataActivity extends Activity {

	public static final int TYPE_ARTIST_MODEL = 1;
	public static final int TYPE_TRACK_MODEL = 2;
	public static final int TYPE_ALBUM_MODEL = 3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView tv = new TextView(this);

		Intent intent = getIntent();
		int type = intent.getIntExtra("type", TYPE_ARTIST_MODEL);

		switch (type) {
		case TYPE_ARTIST_MODEL:
			ArtistModel artistModel = (ArtistModel) intent
					.getParcelableExtra("artistModel");
			tv.setText(artistModel.toString());
			break;
		case TYPE_TRACK_MODEL:
			TrackModel trackModel = intent.getParcelableExtra("trackModel");
			tv.setText(trackModel.toString());
			break;
		case TYPE_ALBUM_MODEL:
			AlbumModel albumModel = intent.getParcelableExtra("albumModel");
			tv.setText(albumModel.toString());
			break;
		default:
			break;
		}
		setContentView(tv);
	}

}
