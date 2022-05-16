/*
 * Name - Race Saunders
 * Directory ID - rssaunde
 * University ID - 114803078
 * Section - 0108
 * "I pledge on my honor that I have not given or received any unauthorized assistance on this assignment."
 *  
 *  The purpose of this class is to create the RecursiveMethodsList class, which uses generic Arraylists.
 */
package recursiveList;

import java.util.ArrayList;

public class RecursiveMethodsList<T extends Comparable<T>> {

	private ArrayList<T> elements = new ArrayList<>();

	// do NOT change this method
	public void add(T newElement) {
		if (newElement == null)
			throw new IllegalArgumentException("No way will I add null to the " + "elements field- not a chance!!!");
		else
			elements.add(newElement);
	}

	public boolean isNonDecreasing() {
		// throw new UnsupportedOperationException("You must write this
		// method.");
		if (elements.size() == 0) {
			return true;
		}
		return nonDecRec(0);
	}

	private boolean nonDecRec(int pos) {
		// throw new UnsupportedOperationException("You must write this
		// method.");
		if (pos == elements.size() - 1) {
			return true;
		} else if (elements.get(pos).compareTo(elements.get(pos + 1)) > 0) {
			return false;
		} else {
			return nonDecRec(pos + 1);
		}
	}

	public T elementAfter(T element) {
		if (element == null)
			throw new IllegalArgumentException("No way will I add null to the " + "elements field- not a chance!!!");
		return afterRec(element, 0);

	}

	private T afterRec(T element, int pos) {
		if (pos == elements.size() - 1) {
			return null;
		} else if (elements.get(pos).compareTo(element) == 0) {
			return elements.get(pos + 1);
		} else {
			return afterRec(element, pos + 1);
		}

	}

	public RecursiveMethodsList<T> elementsBetweenValues(T lowerValue, T upperValue) {
		if (upperValue == null || lowerValue == null)
			throw new IllegalArgumentException("No way will I add null to the " + "elements field- not a chance!!!");
		RecursiveMethodsList<T> ret = new RecursiveMethodsList<T>();
		if (lowerValue.compareTo(upperValue) > 0) {
			return ret;
		}
		return betweenRec(lowerValue, upperValue, ret, 0);

	}

	private RecursiveMethodsList<T> betweenRec(T lowerValue, T upperValue, RecursiveMethodsList<T> r, int pos) {
		if (elements.get(pos).compareTo(lowerValue) >= 0 && elements.get(pos).compareTo(upperValue) <= 0) {
			r.add(elements.get(pos));
		}
		if (pos < elements.size() - 1) {
			betweenRec(lowerValue, upperValue, r, pos + 1);
		}

		return r;
	}

	public void replaceWithOtherList(RecursiveMethodsList<T> otherList, int startingPos) {
		if (otherList == null) {
			throw new IllegalArgumentException();

		}
		if (startingPos >= 0 && startingPos < elements.size()
				&& otherList.elements.size() + startingPos <= elements.size()) {
			replaceRec(otherList, startingPos, 0);
		}
		// throw new UnsupportedOperationException("You must write this
		// method.");

	}

	private void replaceRec(RecursiveMethodsList<T> otherList, int startingPos, int count) {
		if (startingPos < elements.size() && count < otherList.elements.size()) {
			elements.set(startingPos, otherList.elements.get(count));
			replaceRec(otherList, startingPos + 1, count + 1);
		}

	}

	public String toString() {
		if (elements == null || elements.size() == 0) {
			return "";
		} else {
			return stringRec(0);
		}

	}

	private String stringRec(int pos) {
		if (pos == elements.size() - 1) {
			return elements.get(pos).toString();
		} else {
			return elements.get(pos).toString() + ", " + stringRec(pos + 1);
		}

	}

}
