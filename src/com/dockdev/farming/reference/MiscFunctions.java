package com.dockdev.farming.reference;

public class MiscFunctions {
	
	public int exponent(int base, int power){
		int retnum = base;
		
		for (int i = 0; i < power; i++){
			retnum*= base;
		}
		return retnum;
		
	}
}
