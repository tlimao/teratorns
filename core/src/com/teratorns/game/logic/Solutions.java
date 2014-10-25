package com.teratorns.game.logic;

import java.util.ArrayList;

public class Solutions {
	ArrayList<GaussianKernel> gaussianKernels;
	ArrayList<Double> weights;
	
	Solutions(int dimensions, int cardinality){
		calculateWeights(cardinality);
		for(int i = 0; i < dimensions; i++){
			GaussianKernel gk = new GaussianKernel(cardinality, weights);
			gaussianKernels.add(gk);
		}
	}
	
	void calculateWeights(int cardinality){
		for(int l = 0; l < cardinality; l++){
			double num,den,exp,factor;
			factor = ColonyVariables.instance.robustness*cardinality;
			num = (l-1)*(l-1);
			den = 2*factor*factor;
			exp = Math.exp(-num/den);
			den = factor*Math.sqrt(2*Math.PI);
			weights.add(exp/den);
		}
	}
}
