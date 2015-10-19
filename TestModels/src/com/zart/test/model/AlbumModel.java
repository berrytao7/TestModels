package com.zart.test.model;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * ×¨¼­ÐÅÏ¢
 * @author zart
 * 
 */
public class AlbumModel implements Parcelable {

	private String albumName;
	private ArtistModel artistModel;
	private ArrayList<TrackModel> trackList;
	private String releaseTime;

	@Override
	public void writeToParcel(Parcel dest, int flag) {
		dest.writeString(albumName);
		dest.writeValue(artistModel);
		dest.writeList(trackList);
		dest.writeString(releaseTime);
	}

	public static final Parcelable.Creator<AlbumModel> CREATOR = new Parcelable.Creator<AlbumModel>() {

		@Override
		public AlbumModel createFromParcel(Parcel source) {

			AlbumModel model = new AlbumModel();
			model.albumName = source.readString();
			model.artistModel = (ArtistModel) source.readValue(ArtistModel.class.getClassLoader());
			model.trackList = new ArrayList<TrackModel>();
			source.readList(model.trackList,TrackModel.class.getClassLoader());

			model.releaseTime = source.readString();
			return model;
		}

		@Override
		public AlbumModel[] newArray(int size) {
			return new AlbumModel[size];
		}
	};

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("AlbumModel:[ albumName=").append(getAlbumName());
		sb.append(" artist=").append(getArtistModel().toString());
		sb.append(" trackList=");
		for (TrackModel model : trackList) {
			sb.append(model.toString());
		}
		sb.append(" releaseTime=").append(getReleaseTime());
		sb.append("]");

		return sb.toString();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public ArtistModel getArtistModel() {
		return artistModel;
	}

	public void setArtistModel(ArtistModel artistModel) {
		this.artistModel = artistModel;
	}

	public ArrayList<TrackModel> getTrackList() {
		return trackList;
	}

	public void setTrackList(ArrayList<TrackModel> trackList) {
		this.trackList = trackList;
	}

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

}
