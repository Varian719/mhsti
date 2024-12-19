package com.example.mhsti.Model;

import com.google.gson.annotations.SerializedName;

public class OEMDt95HH8834CFYpR9{

	@SerializedName("data")
	private Data data;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"OEMDt95HH8834CFYpR9{" + 
			"data = '" + data + '\'' + 
			"}";
		}
}