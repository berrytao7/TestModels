package com.zart.test.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.zart.test.R;
import com.zart.test.model.AlbumModel;
import com.zart.test.model.ArtistModel;
import com.zart.test.model.TrackModel;

public class TestModelsActivity extends Activity implements OnClickListener {

	private Button btnArtist;
	private Button btnTrack;
	private Button btnAlbum;

	// data
	private ArtistModel artistModel;
	private TrackModel trackModel;
	private AlbumModel albumModel;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btnArtist = (Button) findViewById(R.id.tranArtist);
		btnTrack = (Button) findViewById(R.id.tranTrack);
		btnAlbum = (Button) findViewById(R.id.tranAlbum);

		btnArtist.setOnClickListener(this);
		btnTrack.setOnClickListener(this);
		btnAlbum.setOnClickListener(this);
		initData();
	}
	
	private void initData() {
		artistModel = new ArtistModel();
		artistModel.setArtistName("李宇春");
		artistModel.setCountry("北京");
		artistModel.setAge(33);
		artistModel.setSex(ArtistModel.SEX_FEMALE);

		trackModel = new TrackModel();
		trackModel.setTrackName("我们都一样");
		ArrayList<ArtistModel> artistList = new ArrayList<ArtistModel>();
		artistList.add(artistModel);
		trackModel.setArtistList(artistList);
		trackModel.setReleaseTime("20110308");

		albumModel = new AlbumModel();
		albumModel.setAlbumName("8080");
		albumModel.setArtistModel(artistModel);
		albumModel.setReleaseTime("20110308");
		ArrayList<TrackModel> trackList = new ArrayList<TrackModel>();
		trackList.add(trackModel);
		albumModel.setTrackList(trackList);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		intent.setClass(TestModelsActivity.this, ShowModelDataActivity.class);

		switch (v.getId()) {
		case R.id.tranArtist:
			intent.putExtra("type", ShowModelDataActivity.TYPE_ARTIST_MODEL);
			intent.putExtra("artistModel", artistModel);
			break;
		case R.id.tranTrack:
			intent.putExtra("type", ShowModelDataActivity.TYPE_TRACK_MODEL);
			intent.putExtra("trackModel", trackModel);
			break;
		case R.id.tranAlbum:
			intent.putExtra("type", ShowModelDataActivity.TYPE_ALBUM_MODEL);
			intent.putExtra("albumModel", albumModel);
			break;
		default:
			break;
		}

		startActivity(intent);
	}

}