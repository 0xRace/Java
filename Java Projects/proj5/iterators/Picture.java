package iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Picture implements Iterable<Shape> {

	private Shape[] shapes;
	private int numShapes;

	public Picture(int capacity) {
		shapes = new Shape[capacity];
		numShapes = 0;
	}

	// just do nothing if the picture is full (number of shapes == capacity)
	public void addShape(Shape newShape) {
		if (numShapes < shapes.length)
			shapes[numShapes++] = newShape;
	}

	public Iterator<Shape> iterator() {
		return new MyIter();

	}

	public class MyIter implements Iterator<Shape> {
		private Shape[] c = new Shape[numShapes];
		private int pos = 0;
		Shape next;

		public boolean hasNext() {
			return (pos < numShapes);
		}

		public Shape next() throws NoSuchElementException {
			if (pos >= numShapes) {
				throw new NoSuchElementException();
			} else {
				c[pos] = shapes[pos];
				next = shapes[pos];
				return shapes[pos++];
			}

		}

		public void remove() throws IllegalStateException {
			if (pos > 0 && next.equals(shapes[pos - 1])) {
				Shape[] shapeTemp = new Shape[shapes.length - 1];
				int x = 0;

				for (int i = 0; i < shapeTemp.length; i++) {
					if (i != pos-1) {
						shapeTemp[i] = shapes[i+x];
					}else
					{
						shapeTemp[i]=shapes[i+1];
						x++;
					}
				}
				shapes = shapeTemp;
				pos--;
				numShapes--;

			} else if (pos == 0 || next != shapes[pos - 1]) {
				throw new IllegalStateException();
			}

		}
	}

}
