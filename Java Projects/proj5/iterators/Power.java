package iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

import iterators.Picture.MyIter;

public class Power implements Iterable<Integer> {
	public int b = 0, mExp = 0;

	public Power(int base, int maxExponent) {
		// throw new UnsupportedOperationException("You must write this
		// method.");
		b = base;
		mExp = maxExponent;

	}

	public String toString() {
		// throw new UnsupportedOperationException("You must write this
		// method.");
		String s = "";
		MyIter it = new MyIter();
		for (int i = 0; i < mExp; i++) {
			s += it.next();
			if (i != mExp - 1) {
				s += " ";
			}
		}
		return s;
	}

	public static void main(String args[]) {
		Power f = new Power(10, 3);
		Power g = new Power(2, 5);
		Power h = new Power(3, 4);
		Iterator<Integer> iter = f.iterator();

		System.out.println(iter.next()); // should print 10^1
		System.out.println(iter.next()); // should print 10^2
		System.out.println(iter.next()); // should print 10^3

		System.out.println("\n" + g); // calls toString() on g
		System.out.println("\n" + h); // calls toString() on h
	}

	public Iterator<Integer> iterator() {

		return new MyIter();
	}

	public class MyIter implements Iterator<Integer> {
		private int pos = 0;

		public boolean hasNext() {
			return pos < mExp;
		}

		public Integer next() throws NoSuchElementException {
			if (pos >= mExp) {
				throw new NoSuchElementException();
			}
			int val = 1;
			for (int i = 0; i < pos + 1; i++) {
				val *= b;
			}
			pos++;
			// System.out.println(is);
			return val;

		}

	}
}
