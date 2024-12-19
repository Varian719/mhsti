package com.example.mhsti.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class DataItem implements Parcelable {
	protected DataItem(Parcel in) {
		// Ambil data dari Parcel
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// Tulis data ke Parcel
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<DataItem> CREATOR = new Creator<DataItem>() {
		@Override
		public DataItem createFromParcel(Parcel in) {
			return new DataItem(in);
		}

		@Override
		public DataItem[] newArray(int size) {
			return new DataItem[size];
		}
	};
	@SerializedName("nim")
	private String nim;

	@SerializedName("nama")
	private String nama;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("kelas")
	private String kelas;

	@SerializedName("fotomhs")
	private String fotomhs;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("prodi")
	private String prodi;

	public void setNim(String nim){
		this.nim = nim;
	}

	public String getNim(){
		return nim;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setKelas(String kelas){
		this.kelas = kelas;
	}

	public String getKelas(){
		return kelas;
	}

	public void setFotomhs(String fotomhs){
		this.fotomhs = fotomhs;
	}

	public String getFotomhs(){
		return fotomhs;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setProdi(String prodi){
		this.prodi = prodi;
	}

	public String getProdi(){
		return prodi;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"nim = '" + nim + '\'' + 
			",nama = '" + nama + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",kelas = '" + kelas + '\'' + 
			",fotomhs = '" + fotomhs + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",prodi = '" + prodi + '\'' + 
			"}";
		}
}