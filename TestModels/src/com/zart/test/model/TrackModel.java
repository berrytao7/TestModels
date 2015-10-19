package com.zart.test.model;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * ∏Ë«˙–≈œ¢
 * @author zart
 * 
 */
public class TrackModel implements Parcelable {

	private String trackName;
	private ArrayList<ArtistModel> artistList;
	private String releaseTime;

	@Override
	public void writeToParcel(Parcel dest, int flag) {
		dest.writeString(trackName);
		dest.writeList(artistList);
		dest.writeString(releaseTime);

	}

	public static final Parcelable.Creator<TrackModel> CREATOR = new Parcelable.Creator<TrackModel>() {

		@Override
		public TrackModel createFromParcel(Parcel source) {
			TrackModel model = new TrackModel();
			model.trackName = source.readString();
			
			model.artistList = new ArrayList<ArtistModel>();
			source.readList(model.artistList, ArtistModel.class.getClassLoader());
			model.releaseTime = source.readString();

			return model;
		}

		@Override
		public TrackModel[] newArray(int size) {
			return new TrackModel[size];
		}
	};

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("TrackModel:[ trackName=").append(getTrackName());
		sb.append(" artistList=");
		for(ArtistModel model:artistList){
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

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public ArrayList<ArtistModel> getArtistList() {
		return artistList;
	}

	public void setArtistList(ArrayList<ArtistModel> artistList) {
		this.artistList = artistList;
	}

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

}
