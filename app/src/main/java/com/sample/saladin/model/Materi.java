package com.sample.saladin.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class Materi implements Parcelable {
    private String id;
    private String nama_admin;
    private String tema;
    private String video;
    private String tanggal;

    public Materi() {
    }

    protected Materi(Parcel in) {
        id = in.readString();
        nama_admin = in.readString();
        tema = in.readString();
        video = in.readString();
        tanggal = in.readString();
    }

    public static final Creator<Materi> CREATOR = new Creator<Materi>() {
        @Override
        public Materi createFromParcel(Parcel in) {
            return new Materi(in);
        }

        @Override
        public Materi[] newArray(int size) {
            return new Materi[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama_admin() {
        return nama_admin;
    }

    public void setNama_admin(String nama_admin) {
        this.nama_admin = nama_admin;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(nama_admin);
        dest.writeString(tema);
        dest.writeString(video);
        dest.writeString(tanggal);
    }

    public Materi(JSONObject object) {
        try {
            String id = object.getString("id");
            String nama_admin = object.getString("nama_admin");
            String tema = object.getString("tema");
            String video = object.getString("video");
            String tanggal = object.getString("tanggal");

            this.id = id;
            this.nama_admin = nama_admin;
            this.tema = tema;
            this.video = video;
            this.tanggal = tanggal;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
