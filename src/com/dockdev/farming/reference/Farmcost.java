package com.dockdev.farming.reference;

public class Farmcost {
	
	public final int basecost = 100;
	
	public double getCost(int size){
		double multiplier = Math.pow(size, 10);
		return (basecost * multiplier);
	}
}
