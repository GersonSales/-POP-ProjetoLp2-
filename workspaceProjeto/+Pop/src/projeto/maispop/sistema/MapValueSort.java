package projeto.maispop.sistema;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapValueSort {
	
	/** inner class to do soring of the map **/
	private static class ValueComparer implements Comparator {
		private Map  _data = null;
		public ValueComparer (Map data){
			super();
			_data = data;
		}
		
         public int compare(Object o1, Object o2) {
        	 String e1 = (String) _data.get(o1);
             String e2 = (String) _data.get(o2);
             return e1.compareTo(e2);
         }
	}

	public static void main(String[] args){
		
		Map unsortedData = new HashMap();
		unsortedData.put("2", "DEF");
		unsortedData.put("1", "ABC");
		unsortedData.put("4", "ZXY");
		unsortedData.put("3", "BCD");
		unsortedData.put("9", "WWW");

		
		
		SortedMap sortedData = new TreeMap(new MapValueSort.ValueComparer(unsortedData));
		
		printMap(unsortedData);
		
		sortedData.putAll(unsortedData);
		System.out.println();
		printMap(sortedData);
	}

	private static void printMap(Map data) {
		for (Iterator iter = data.keySet().iterator(); iter.hasNext();) {
			String key = (String) iter.next();
			System.out.println("Value/key:"+data.get(key)+"/"+key);
		}
	}
	
}