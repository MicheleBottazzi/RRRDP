/*
 * This file is part of JGrasstools (http://www.jgrasstools.org)
 * (RO) HydroloGIS - www.hydrologis.com 
 * 
 * JGrasstools is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERROHANTABILITY or FITNESS FOR A PARTIROULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ex0;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import oms3.annotations.*;





@Description("")
@Author(name = "Marialaura Bancheri")


public class DataMergeStorageRO extends OutProcessing {


	@Description("")
	@In
	@Out
	public  HashMap<Integer, double[]> inHMStorageRO;	
	
	@Description("")
	@In
	public Map<Integer, double[]> inHMStorageROFromAboveVert1;
	
	@Description("")
	@In
	public Map<Integer, double[]> inHMStorageROFromAboveVert2;


	




	@Execute
	public void process() throws Exception {



		// reading the ID of all the stations 
		Set<Entry<Integer, double[]>> entrySet1 = inHMStorageROFromAboveVert1.entrySet();

		// iterate over the station
		for( Entry<Integer, double[]> entry : entrySet1 ) {
			Integer ID = entry.getKey();

			/**Input data reading*/
			double storageRO1 = inHMStorageROFromAboveVert1.get(ID)[0];
			inHMStorageRO.put(ID, new double[]{storageRO1});			
		}
		
		if( inHMStorageROFromAboveVert2!=null){
		Set<Entry<Integer, double[]>> entrySet2 = inHMStorageROFromAboveVert2.entrySet();
			
		for( Entry<Integer, double[]> entry2 : entrySet2 ) {
			Integer ID = entry2.getKey();	
			/**Input data reading*/
			
			double storageRO2 = inHMStorageROFromAboveVert2.get(ID)[0];
			inHMStorageRO.put(ID, new double[]{storageRO2});
			}

			
		}

			
			
			


		}



	}
