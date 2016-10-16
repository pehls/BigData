package com.bigdata.model;

public class Count {
	private static int count = 0;

	public Count() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	static  void sum () {
		
		count++;
	}
	
	public static int getCount() {
		return count;
	}

}
