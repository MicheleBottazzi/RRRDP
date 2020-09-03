/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex0;

import java.util.Map;

/**
 *
 * @author sidereus
 */
public abstract class OutProcessing {

    protected void addTimeStepValue(Integer key, double val, Map<Integer, double[]> outval) {
        if (outval.containsKey(key)) add(key, val, outval);
        else outval.put(key, new double[]{val});
    }

	private void add(final Integer key, final double val, final Map<Integer, double[]> outval) {
        double[] valFromOut = outval.get(key);
        double[] tmpval = new double[valFromOut.length+1];
        System.arraycopy(valFromOut, 0, tmpval, 0, valFromOut.length);
        tmpval[tmpval.length - 1] = val;
		outval.replace(key, tmpval);
	}

}
