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
import java.util.Map;
import oms3.annotations.*;
import java.util.Iterator;

/**
 * @author sidereus
 */
public class Out2 extends OutProcessing {

    @OutNode public Map<Integer, double[]> outval1 = new HashMap<Integer, double[]>();
    @OutNode public Map<Integer, double[]> outval2 = new HashMap<Integer, double[]>();
    @In public Map<Integer, double[]> inval1;
    @In public Map<Integer, double[]> inval2;

    @Execute
    public void run() {
    
    // add precondition to check for size inval1 inval2;
        Iterator<Map.Entry<Integer, double[]>> iter1 = inval1.entrySet().iterator();
        Iterator<Map.Entry<Integer, double[]>> iter2 = inval2.entrySet().iterator();
        
        int size1=inval1.size();
        int size2=inval2.size();
        
        System.out.println("size1:"+size1+"size2:"+size2);
        
        
        while(iter1.hasNext() || iter2.hasNext()) {

            Map.Entry<Integer, double[]> e1 = iter1.next();
            Integer key1 = e1.getKey();
            double[] val1 = e1.getValue();
            
            
            Map.Entry<Integer, double[]> e2 = iter2.next();
            Integer key2 = e2.getKey();
            double[] val2 = e2.getValue();


            addTimeStepValue(key1, val1[0], outval1);
            addTimeStepValue(key2, val2[0], outval2);
        }
    }
 
}
