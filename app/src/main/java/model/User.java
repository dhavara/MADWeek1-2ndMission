package model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String nama, kota;
    private int umur;

    public User() {
        this.nama = "";
        this.umur = 0;
        this.kota = "";
    }

    public User(String nama, int umur, String kota) {
        this.nama = nama;
        this.umur = umur;
        this.kota = kota;
    }

    protected User(Parcel in) {
        nama = in.readString();
        umur = in.readInt();
        kota = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String judul) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeInt(umur);
        dest.writeString(kota);
    }
}
