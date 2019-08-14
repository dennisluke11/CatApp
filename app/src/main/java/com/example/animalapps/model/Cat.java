package com.example.animalapps.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "Cat")
public class Cat implements Parcelable {


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "catId")
    int catId;

    @SerializedName("id")
    @ColumnInfo(name = "id")
    @Expose
    String id;

    public String getSourceurl() {
        return sourceurl;
    }

    public void setSourceurl(String sourceurl) {
        this.sourceurl = sourceurl;
    }

    @ColumnInfo(name = "sourceurl")
    @SerializedName("source_url")
    @Expose
    String sourceurl;

    @ColumnInfo(name = "url")
    @SerializedName("url")
    @Expose
    String url;


    protected Cat(Parcel in) {
        id = in.readString();
        url = in.readString();
        sourceurl = in.readString();
    }

    public static final Creator<Cat> CREATOR = new Creator<Cat>() {
        @Override
        public Cat createFromParcel(Parcel in) {
            return new Cat(in);
        }

        @Override
        public Cat[] newArray(int size) {
            return new Cat[size];
        }
    };


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;

    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        //notifyPropertyChanged(BR.url);
    }

    public String getSource_url() {
        return sourceurl;
    }

    public void setSource_url(String source_url) {
        this.sourceurl = source_url;
       // notifyPropertyChanged(BR.sourceurl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeValue(id);
        dest.writeValue(url);
        dest.writeValue(sourceurl);

    }

    public Cat() {
    }
    @Ignore
    public Cat(int catId, String id, String sourceurl, String url) {
        this.catId = catId;
        this.id = id;
        this.sourceurl = sourceurl;
        this.url = url;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }
}
