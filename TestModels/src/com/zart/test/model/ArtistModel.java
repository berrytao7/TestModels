package com.zart.test.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 歌手信息
 * @author zart
 * 
 */
public class ArtistModel implements Parcelable{

	private static final long serialVersionUID = 1L;
	public static final int SEX_MALE = 0;
	public static final int SEX_FEMALE = 1;

	private String artistName;
	private String country;
	private int sex;
	private int age;
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(artistName);
		dest.writeString(country);
		dest.writeInt(sex);
		dest.writeInt(age);
	}
	
	public static final Parcelable.Creator<ArtistModel> CREATOR = new Parcelable.Creator<ArtistModel>() {

		@Override
		public ArtistModel createFromParcel(Parcel source) {

			ArtistModel model = new ArtistModel();
			model.artistName=source.readString();
			model.country=source.readString();
			model.sex=source.readInt();
			model.age=source.readInt();
			return model;
		}

		@Override
		public ArtistModel[] newArray(int size) {
			return new ArtistModel[size];
		}
	};

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("ArtistModel:[ artistName=").append(getArtistName());
		sb.append(" country=").append(getCountry());
		String str = "";
		if (sex == SEX_MALE) {
			str = "男";
		} else {
			str = "女";
		}
		sb.append(" sex=").append(str);
		sb.append(" age=").append(getAge());
		sb.append("]");

		return sb.toString();
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
