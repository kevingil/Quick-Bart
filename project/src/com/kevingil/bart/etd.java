/*
 *  Copyright (C) 2014  Kevin Gil
*/


package com.kevingil.bart;

public class etd {
	
	public String destination;
	public int minutesToArrival;
	public int platform;
	public String direction;
	public boolean bikes;
	public String color;
	public boolean isExpanded = false; // Is corresponding view expanded?
	
	public String toString(){
		return destination + " in " + String.valueOf(minutesToArrival)+"m";
	}
	
	public etd(){
		this.minutesToArrival = 0;
	}
	
	public etd(String destination, int minutesToArrival, int platform, String direction, boolean bikes, String color){
		this.destination = destination;
		this.minutesToArrival = minutesToArrival;
		this.platform = platform;
		this.direction = direction;
		this.bikes = bikes;
		this.color = color;
	}

}
