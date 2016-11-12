package com.dockdev.farming.reference;

public class Farmcost {
	
	public final int basecost = 100;
	
	public int getCost(int size){
		int multiplier = (size^10);
		return (basecost * multiplier);
	}
}
