package polymorphicBST;

@SuppressWarnings({"unchecked", "rawtypes"})
public class EmptyTree<K extends Comparable<K>, V> extends Tree<K, V> {

	private static EmptyTree single= new EmptyTree();
	private EmptyTree()
	{
		
	}
	

  public static EmptyTree getInstance() {
   // throw new UnsupportedOperationException("You must write this method.");
	  return single;
  }

  public NonEmptyTree<K, V> insertKeyValuePair(K keyIn, V valueIn) {
    //throw new UnsupportedOperationException("You must write this method.");
	// Create new NonEmptyTree.
			NonEmptyTree<K, V> insThis = new NonEmptyTree();
			// Call insertKeyValuePair on newly created NonEmptyTree. There will be
			// a base case there to create this object in
			// further detail (with value, key, left, and right assigned).
			return insThis.insertKeyValuePair(keyIn, valueIn);
  }

  public int size() {
    //throw new UnsupportedOperationException("You must write this method.");
	  return 0;
  }

  public V getValueForKey(K keyIn) {
    //throw new UnsupportedOperationException("You must write this method.");
	  return null;
  }
  

  public int depthOfKey(K keyIn) {
    //throw new UnsupportedOperationException("You must write this method.");
	  return -1;
  }
  public int helper(K keyIn, int counter)
  {
	 return -1;
  }

  public Tree<K, V> copyOfTree() {
    //throw new UnsupportedOperationException("You must write this method.");
    return this;
  }

  public K max() throws EmptyTreeException {
    throw new EmptyTreeException();
  }

  public K min() throws EmptyTreeException {
   throw new EmptyTreeException();
  }

  public Tree<K, V> deleteKeyValuePair(K keyIn) {
    //throw new UnsupportedOperationException("You must write this method.");
	  return single;
  }

  public String toString() {
    //throw new UnsupportedOperationException("You must write this method.");
	  return "";
  }

}
