/*
 * Name - Race Saunders
 * Directory ID - rssaunde
 * University ID - 114803078
 * Section - 0108
 * "I pledge on my honor that I have not given or received any unauthorized assistance on this assignment."
 *  
 *  The purpose of this class is to create the ListInOrder class, which extends the ListNoOrder class with 
 *  complete functionality, only adding that the list is ordered
 */
package listAndSublist;

public class ListInOrder<T extends Comparable<T>> extends ListNoOrder<T> {

	/*
	 * Implement (i.e., override) whatever methods from the superclass that you
	 * find are necessary to have this list be sorted, *as well as* any methods
	 * that would be more efficient if overridden in this subclass.
	 */

	// This is the overridden add method for ListInOrder. It maintains the order
	// of the list as items are added, so that they do not have to be organized
	// later.
	@Override
	public void add(T newElt) {
		if (newElt == null) {
			throw new IllegalArgumentException();
		}
		// base case for empty object
		Node temp = head;
		if (head == null) {
			head = new Node(newElt);
			tail = head;
		} else if (head.next == null) {
			// tricky situation for when there are only two objects. One may
			// have to replace the head, which causes a mess with the head and
			// tail declarations
			if (temp.data.compareTo(newElt) > 0) {
				Node add = new Node(temp.data);
				head = new Node(newElt);
				head.next = add;
				add.prev = head;
				tail = add;
			} else {
				Node add = new Node(newElt);
				temp.next = add;
				add.prev = temp;
				tail = add;
			}

		} else {
			// once moving past all of the base cases, we only need search
			// through until we are at the node whose value is <= ours, and one
			// behind the first node whose value is greater
			Node prev = head;
			Node next = head.next;
			Node toAdd = new Node(newElt);
			boolean isNotAdded = true;

			while (isNotAdded) {

				if (toAdd.data.compareTo(head.data) < 0) {
					Node moved = head;
					head = toAdd;
					head.next = moved;
					moved.prev = head;
					isNotAdded = false;
				} else if (toAdd.data.compareTo(next.data) < 0 && toAdd.data.compareTo(prev.data) >= 0) {
					prev.next = toAdd;
					toAdd.prev = prev;
					toAdd.next = next;
					next.prev = toAdd;

					isNotAdded = false;
				} else if (next.next == null) {
					// if we make it to the last node, we must reset the tail
					next.next = toAdd;
					tail = toAdd;
					toAdd.prev = next;
					isNotAdded = false;

				}

				next = next.next;
				prev = prev.next;

			}
		}
	}

	// This method is overridden because it does not need to continue search for
	// the number of occurrences of elements when searching through a sorted list.
	// If it has passed the desired objects then the while loop can end. 
	@Override
	public int numOccurrencesOfElement(T element) {
		if (element == null) {
			throw new IllegalArgumentException();
		}
		Node temp = head;
		int count = 0;
		while (temp != null && !(temp.data.compareTo(element) > 0)) {
			// If it has passed the desired objects then the while loop can end. 
			if (temp.data.compareTo(element) == 0) {
				count++;
			}
			temp = temp.next;

		}
		return count;

	}

}
