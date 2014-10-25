package com.teratorns.game.logic;

import java.util.ArrayList;

public class GaussianKernel {
	
	ArrayList<Double> weights, mi, sigma;
	
	public GaussianKernel(int cardinality, ArrayList<Double> weights) {
		this.weights = weights;
	}
}
