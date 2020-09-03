/*
 * $Id$
 * 
 * This file is part of the Object Modeling System (OMS),
 * 2007-2011, Olaf David, Colorado State University
 *
 * OMS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * OMS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with OMS.  If not, see <http://www.gnu.org/licenses/>.
 */
package ex0;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import oms3.annotations.*;

/**
 * @author sidereus
 */
public class In3 extends InputProcessing {

    @InNode public Map<Integer, double[]> inval1;
    @InNode public Map<Integer, double[]> inval2;
    @InNode public Map<Integer, double[]> inval3;
    @Out public Map<Integer, double[]> outval = new HashMap<Integer, double[]>();

    @In public Integer to_key;

    @Execute
    public void run() {
        // add precondition to check for size inval1 inval2;
        Iterator<Map.Entry<Integer, double[]>> iter1 = inval1.entrySet().iterator();
        Iterator<Map.Entry<Integer, double[]>> iter2 = inval2.entrySet().iterator();
        Iterator<Map.Entry<Integer, double[]>> iter3 = inval3.entrySet().iterator();

        while(iter1.hasNext() || iter2.hasNext() || iter3.hasNext()) {

            Map.Entry<Integer, double[]> e1 = iter1.next();
            Integer key1 = e1.getKey();
            double[] val1 = e1.getValue();
            Map.Entry<Integer, double[]> e2 = iter2.next();
            Integer key2 = e2.getKey();
            double[] val2 = e2.getValue();
            Map.Entry<Integer, double[]> e3 = iter3.next();
            Integer key3 = e3.getKey();
            double[] val3 = e3.getValue();


            double sum = val1[0] + val2[0] + val3[0];

            getSingleTimeStepData(to_key, sum, outval);

            removeTimeStepFromBuffer(key1, val1, inval1);
            removeTimeStepFromBuffer(key2, val2, inval2);
            removeTimeStepFromBuffer(key3, val3, inval3);

        }

    }
 
}
