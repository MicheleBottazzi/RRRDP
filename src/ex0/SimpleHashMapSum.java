/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex0;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import oms3.annotations.*;

/**
 *
 * @author sidereus
 */
public class SimpleHashMapSum {

    @In public Map<Integer, double[]> inFromAboveVert;
    @In public Map<Integer, double[]> inComputation;
    @Out public HashMap<Integer, double[]> outSum;

    @Execute
    public void exec() {

        outSum = new HashMap<Integer, double[]>();

        Iterator<Entry<Integer, double[]>> iter1 = inFromAboveVert.entrySet().iterator();
        Iterator<Entry<Integer, double[]>> iter2 = inComputation.entrySet().iterator();

        while(iter1.hasNext() || iter2.hasNext()) {

            Entry<Integer, double[]> e1 = iter1.next();
            Integer key1 = e1.getKey();
            double[] val1 = e1.getValue();

            Entry<Integer, double[]> e2 = iter2.next();
            Integer key2 = e2.getKey();
            double[] val2 = e2.getValue();

            // add check on equals key: MUST BE EQUAL
            double[] outval = new double[]{val1[0] + val2[0]};

            outSum.put(key2, outval);

        }

    }

}
