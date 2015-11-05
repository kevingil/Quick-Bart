/*
 *  Copyright (C) 2014  Kevin Gil
*/



package com.kevingil.bart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

//Serializable so it can be sent via broadcast messenger
public class etdResponse implements Serializable{
	
	public String tmpDestination;  //hacky - temp store destination for following estimates
	public String station;
	public Date date;
	public ArrayList etds;
	public String message;
	
	public String toString(){
		return station + "date: "+ date.toString() + " etds: " + etds;
	}
	
	public etdResponse(){
		this.etds = new ArrayList();
	}
	public void etdResponse(String station, Date date, ArrayList etds){
		this.station = station;
		this.date = date;
		this.etds = etds;
	}
	
	public etd addEtd(){
		etd newEtd = new etd();
		etds.add(newEtd);
		return newEtd;
	}
	public etd lastEtd(){
		return (etd) etds.get(etds.size()-1);
	}
	public String lastDestination(){
		return ((etd)etds.get(etds.size()-1)).destination;
	}

}
