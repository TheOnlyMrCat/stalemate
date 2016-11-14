package com.dockdev.farming.reference;

import com.dockdev.farming.reference.MiscFunctions;

public class Farmcost {
	
	private MiscFunctions funcs;
	public final int basecost = 100;
	
	public int getCost(int size){
		int multiplier = funcs.exponent(size, 10);
		return (basecost * multiplier);
	}
}
