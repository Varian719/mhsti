package com.example.mhsti.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("current_page")
	private int currentPage;

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	public void setCurrentPage(int currentPage){
		this.currentPage = currentPage;
	}

	public int getCurrentPage(){
		return currentPage;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"data = '" + data + '\'' + 
			",current_page = '" + currentPage + '\'' + 
			"}";
		}
}