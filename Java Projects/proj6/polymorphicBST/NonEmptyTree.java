package polymorphicBST;

@SuppressWarnings("unchecked")
public class NonEmptyTree<K extends Comparable<K>, V> extends Tree<K, V> {
	private K key;
	private V value;
	private Tree<K, V> left, right;


	public NonEmptyTree<K, V> insertKeyValuePair(K keyIn, V valueIn) {
	
		if (keyIn == null || valueIn == null) {
			throw new IllegalArgumentException();
		}

		else if (key == null && value == null) {
			key = keyIn;
			value = valueIn;
			left = EmptyTree.getInstance();
			right = EmptyTree.getInstance();
			return this;
		}
	
		else if (key.compareTo(keyIn) == 0) {
			value = valueIn;
			return this;
		}
	
		else if (keyIn.compareTo(key) < 0) {
			left = left.insertKeyValuePair(keyIn, valueIn);
		}
	
		else if (keyIn.compareTo(key) > 0) {
			right = right.insertKeyValuePair(keyIn, valueIn);
		}

		return this;
	}

	public int size() {
		// throw new UnsupportedOperationException("You must write this
		// method.");
		return 1 + left.size() + right.size();
	}

	public V getValueForKey(K keyIn) {
		// throw new UnsupportedOperationException("You must write this
		// method.");
		if (keyIn == null) {
			throw new IllegalArgumentException();
		}

		if (keyIn.compareTo(key) == 0) {
			return value;
		} else if (keyIn.compareTo(key) > 0){
				return right.getValueForKey(keyIn);

		}
		else{
		return left.getValueForKey(keyIn);
		}

	}

	public int depthOfKey(K keyIn) {
		// throw new UnsupportedOperationException("You must write this
		// method.")
		if (keyIn == null) {
			throw new IllegalArgumentException();
		}
		else
		{
			
				return helper(keyIn,0);
			
		}

		
	}
	
	public int helper(K keyIn,int counter)
	{
		if (keyIn.compareTo(key) == 0) {
			return counter;
		} else if (keyIn.compareTo(key) > 0){
				
					return right.helper(keyIn,counter+1);
		}
		else{
			
				return right.helper(keyIn,counter+1);
			
		}
   }		
	

	public Tree<K, V> copyOfTree() {
		NonEmptyTree copy = new NonEmptyTree();
		copy.value=value;
		copy.key=key;
		copy.left=left.copyOfTree();
		copy.right=right.copyOfTree();
		return this;

	}

	public K max() throws EmptyTreeException {
		try {
			return right.max();
		} catch (EmptyTreeException ex) {
			return key;
		}

	}

	public K min() throws EmptyTreeException {
		try {
			return left.min();
		} catch (EmptyTreeException ex) {
			return key;
		}

	}

	public Tree<K, V> deleteKeyValuePair(K keyIn) {
		if (keyIn == null) {
			throw new IllegalArgumentException();
		}
	
		else if (keyIn.compareTo(key) > 0) {
			right = right.deleteKeyValuePair(keyIn);
		}

		else if (keyIn.compareTo(key) < 0) {
			left = left.deleteKeyValuePair(keyIn);
		} 
	
		else {
			try {
			
				key = left.max();
				value = left.getValueForKey(key);
				left = left.deleteKeyValuePair(key);
			} 
			catch (EmptyTreeException e) {
				try {
				
					key = right.min();
					value = right.getValueForKey(key);
					right = right.deleteKeyValuePair(key);
					return this;
				} 
			
				catch (EmptyTreeException ex) {
					return EmptyTree.getInstance();
				}
			}
			
		}
	return this;
	}

	public String toString() {
		
		return left.toString() + key + "->" + value + " " + right.toString();
	}

}
