package setsAndMaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Bag {
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	public void add(int elt) {
		// throw new UnsupportedOperationException("Write me first!");
		if (map.containsKey(elt)) {
			map.replace(elt, map.get(elt) + 1);
		} else {
			map.put(elt, 0);
		}
	}

	public boolean contains(int elt) {
		// throw new UnsupportedOperationException("Please write me!");
			return map.containsKey(elt);
	}

	public int getCount(int elt) {
		// throw new UnsupportedOperationException("Write me please!");
		return (map.containsKey(elt)) ? map.get(elt) + 1 : 0;
	}

	public int size() {
		// throw new UnsupportedOperationException("Don't write that one, write
		// me!");
		int size = 0;
		Set<Integer> e = map.keySet();
		for (Integer i : e) {
			size += map.get(i) + 1;
		}

		return size;
	}

	public Set<Integer> uniqueElements() {
		// throw new UnsupportedOperationException("Don't forget about writing
		// me!");
		HashSet <Integer> unique = new HashSet<Integer>();
		for(Integer i: map.keySet()){
			unique.add(i.intValue());
		}
		return unique;
	}

	public void remove(int elt) {
		// throw new UnsupportedOperationException("I am the best method to
		// write!");
		if (map.containsKey(elt)) {
			if (map.get(elt).equals(0)) {
				map.remove(elt);
			} else {
				map.replace(elt, map.get(elt) - 1);
			}
		}
	}

}
