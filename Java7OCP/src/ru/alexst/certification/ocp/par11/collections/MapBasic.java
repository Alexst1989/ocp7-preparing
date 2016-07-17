/**
 * 
 */
package ru.alexst.certification.ocp.par11.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.lang.System.out;

/*
public interface Map<K,V> {
 1	 int size();
 2   boolean containsKey(Object key);
 3   boolean containsValue(Object value);
 4   V get(Object key);
 5   V put(K key, V value);
 6   V remove(Object key);
 7   void putAll(Map<? extends K, ? extends V> m);
 8   void clear();
 9   Set<K> keySet();
 10  Collection<V> values();
 11  Set<Map.Entry<K, V>> entrySet();
    
}   

 */
public class MapBasic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<>();
		m.put("stringKey", 5);
		m.put("2", 2);
		
		out.println(m.get("2"));
		out.println(m.containsKey("3"));
		
	}

}
