package model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class DataUser implements Parcelable {
    public static ArrayList<User> saveList = new ArrayList<>();

    protected DataUser(Parcel in) {
    }

    public static final Creator<DataUser> CREATOR = new Creator<DataUser>() {
        @Override
        public DataUser createFromParcel(Parcel in) {
            return new DataUser(in);
        }

        @Override
        public DataUser[] newArray(int size) {
            return new DataUser[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
