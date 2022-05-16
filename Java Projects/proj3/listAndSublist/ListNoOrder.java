/*
 * Name - Race Saunders
 * Directory ID - rssaunde
 * University ID - 114803078
 * Section - 0108
 * "I pledge on my honor that I have not given or received any unauthorized assistance on this assignment."
 *  
 *  The purpose of this class is to create the ListNoOrder class, which uses nodes to create a linked list of generic.
 */
package listAndSublist;

import java.lang.IndexOutOfBoundsException;

public class ListNoOrder<T extends Comparable<T>> implements Comparable<ListNoOrder<T>> {
	protected Node head;
	protected Node tail;

	public ListNoOrder() {
		// throw new UnsupportedOperationException("You must write this
		// method.");
		head = null;

	}

	public void add(T newElt) {
		// throw new UnsupportedOperationException("You must write this
		// method.");
		if (newElt == null) {
			throw new IllegalArgumentException();
		}
		Node temp = head;
		if (head == null) {
			// base case for when head is null
			head = new Node(newElt);
			tail = head;

		} else if (head.next == null) {
			// base case for when head.next is null
			Node add = new Node(newElt);
			head.next = add;
			add.prev = head;
		} else {
			while (temp.next != null) {
				temp = temp.next;
			}
			Node add = new Node(newElt);
			temp.next = add;
			add.prev = temp;
			tail = add;
		}
	}

	public int length() {
		// throw new UnsupportedOperationException("You must write this
		// method.");
		// calculates the length based off of all nodes from the head.
		Node temp = head;
		int count = 0;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}

	public String toString() {
		// throw new UnsupportedOperationException("You must write this
		// method.");
		Node temp = head;
		String ret = "";
		while (temp != null) {
			// ternary to account for final case when there should be no comma
			String t = ((temp.next != null)) ? ", " : "";
			ret += temp.data.toString() + t;
			temp = temp.next;
		}
		return ret;
	}

	public void reset() {
		// throw new UnsupportedOperationException("You must write this
		// method.");
		head = null;

	}

	public int numOccurrencesOfElement(T element) {
		// throw new UnsupportedOperationException("You must write this
		// method.");

		if (element == null) {
			throw new IllegalArgumentException();
		}
		Node temp = head;
		int count = 0;
		while (temp != null) {
			if (temp.data.compareTo(element) == 0) {
				count++;
			}
			temp = temp.next;

		}
		return count;

	}

	public int positionOfElement(T element) {
		// throw new UnsupportedOperationException("You must write this
		// method.");
		if (element == null) {
			throw new IllegalArgumentException();
		}
		Node temp = head;
		int pos = 0;
		while ((temp != null) && (temp.data.compareTo(element) != 0)) {
			// searches while temp and temp.next are not null
			if (temp.next == null) {
				return -1;
			}
			temp = temp.next;
			pos++;
		}

		return pos;
	}

	public T elementAtPosition(int position) throws IndexOutOfBoundsException {
		if (position < 0 || position > length() - 1) {
			throw new IndexOutOfBoundsException();
		}

		Node temp = head;
		int count = 0;
		while (count < position) {
			temp = temp.next;
			count++;
		}
		return temp.data;
	}

	public ListNoOrder<T> elementsAfter(T element) {
		if (element == null) {
			throw new IllegalArgumentException();
		}
		ListNoOrder<T> r = new ListNoOrder<T>();
		// it is possible that the element wont exist. In this case -1 will be
		// returned, which causes an empty list to be returned.
		int pos = positionOfElement(element);
		if (pos == -1) {
			return r;
		}
		int count = 0;
		Node temp = head;
		while (count <= pos && pos != -1) {
			temp = temp.next;
			count++;
		}

		while (temp != null) {
			r.add(temp.data);
			temp = temp.next;

		}
		return r;
		// throw new UnsupportedOperationException("You must write this
		// method.");

	}

	public int distanceBetween(T element1, T element2) {
		// throw new UnsupportedOperationException("You must write this
		// method.");
		if (element1 == null || element2 == null) {
			throw new IllegalArgumentException();
		}
		int count = 0;
		// triggers are created to account for the timing of the first and
		// second elements
		int ftrigger = 0;
		int strigger = 0;
		Node temp = head;

		while ((!(ftrigger == 1 && strigger == 1)) && temp != null) {
			// first if statement placed at the top to avoid counting the
			// Occurrence of element1
			if (ftrigger == 1) {
				count++;
			}
			if (temp.data.compareTo(element1) == 0) {
				ftrigger = 1;
			}
			//ftrigger must already be accounted for in order to trigger the second one
			if (ftrigger == 1 && temp.data.compareTo(element2) == 0) {
				strigger = 1;
			}
			temp = temp.next;
		}
		if (ftrigger == 0 || strigger == 0) {
			return -1;
		}

		return count;
	}

	public void removeElementAtPosition(int position) throws IndexOutOfBoundsException {
		// throw new UnsupportedOperationException("You must write this
		// method.");
		if (position < 0 || position > length() - 1) {
			throw new IndexOutOfBoundsException();
		} else if (position == 0) {
			head = head.next;
		} else {
			int count = 0;
			Node temp = head;
			while (count < position) {
				temp = temp.next;
			}
			//just passes over the element at the position that we want to remove. 
			temp.next = temp.next.next;
		}
	}

	public int compareTo(ListNoOrder<T> otherList) {
		// throw new UnsupportedOperationException("You must write this
		// method.");
		Node temp1 = head;
		Node temp2 = otherList.head;

		while (temp1 != null || temp2 != null) {
			if (temp1.data.compareTo(temp2.data) != 0) {
				return temp1.data.compareTo(temp2.data);
			}
			temp1 = temp1.next;
			temp2 = temp2.next;

		}
		return 0;

	}

	protected class Node {
		T data;
		Node next, prev;

		public Node(T d) {
			data = d;

		}

	}

}
