package com.techgene;

public class Engine {
	String company;


	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}



	@Override
	public String toString(){
		return "This is Engine object from:"+company;
	}
}
