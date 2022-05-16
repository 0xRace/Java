package tests;

// (c) Larry Herman, 2017.  You are allowed to use this code yourself, but
// not to provide it to anyone else.

// This class contains a helper method used in the public tests, and example
// graphs that the tests call methods on.

import graph.Graph;
import java.util.ArrayList;
import java.util.Collection;

public class TestData {

  // utility method /////////////////////////////////////////////////////

  // In various tests we have to check the contents of a Collection returned
  // by a method, but we can't create a Collection that has the expected
  // values and use the equals() method to compare against the Collection,
  // because we don't even know what kind of Collection the methods will
  // return.  This method takes a Collection to check, and an array with the
  // expected values.  It constructs an ArrayList with the array's values
  // (the expected correct values)- of course an ArrayList is one type of
  // Collection.  Then it uses the Collection containsAll() method to
  // compare the parameter Collection against the ArrayList.  If we have two
  // collections A and B, and A contains all of the elements of B, and B
  // contains all of the elements of A, then it must be the case that they
  // must have all the same elements, and only the same elements.  Of course
  // this is not particularly efficient, but our goal is just to make it
  // easy to check the results of tests.
  public static <T> boolean checkCollection(Collection<T> collection,
                                            T[] array) {
    ArrayList<T> expectedResults= new ArrayList<T>();

    for (T elt : array)
      expectedResults.add(elt);

    return collection.containsAll(expectedResults) &&
           expectedResults.containsAll(collection);
  }

  // example graphs /////////////////////////////////////////////////////

  // Returns a simple graph instantiated with Integers.
  public static Graph<Integer> exampleGraph1() {
    Graph<Integer> graph= new Graph<>();
    int[] vertices= {131, 132, 216, 250, 320, 330, 351, 411, 420, 430};
    int i;

    // add vertices to the graph
    for (int vertex : vertices)
      graph.addVertex(vertex);

    // add some edges to the graph; the vertex corresponding to every
    // element in the array vertices has an edge to the next one, except for
    // the last one
    for (i= 0; i < vertices.length - 1; i++)
      graph.createEdge(vertices[i], vertices[i + 1], 1);

    return graph;
  }

  // Returns a more complex graph instantiated with Strings.
  public static Graph<String> exampleGraph2() {
    Graph<String> graph= new Graph<>();
    String[][] vertices= {{"aardvark"},
                          {"beagle", "cat"},
                          {"donkey", "elephant", "flamingo"},
                          {"giraffe", "hyena", "iguana", "jaguar"},
                          {"koala", "lemur", "manatee", "numbat", "ocelot"}};
    int i, j, k;

    // add vertices to the graph
    for (i= 0; i < vertices.length; i++)
      for (j= 0; j < vertices[i].length; j++)
        graph.addVertex(vertices[i][j]);

    // add some edges to the graph
    for (i= 0; i < vertices.length - 1; i++)
      for (j= 0; j < vertices[i].length; j++)
        for (k= 0; k < vertices[i + 1].length; k++)
          graph.createEdge(vertices[i][j], vertices[i + 1][k], 1);

    return graph;
  }

  // Returns another more complex graph instantiated with Integers.
  public static Graph<Integer> exampleGraph3() {
    Graph<Integer> graph= new Graph<>();
    int[] from= {1, 1, 1, 2, 3, 5, 6, 6, 6, 7, 7, 8, 8, 8};
    int[] to=   {2, 3, 5, 4, 4, 4, 3, 4, 5, 3, 6, 4, 6, 7};
    int i;

    for (i= 1; i <= 8; i++)
      graph.addVertex(i);

    for (i= 0; i < from.length; i++)
      graph.createEdge(from[i], to[i], from.length - i);

    return graph;
  }

  // This method creates an even more complex graph, instantiated with
  // Characters.
  public static Graph<Character> exampleGraph4() {
    Graph<Character> graph= new Graph<>();
    char[] edgeSource= {'a', 'a', 'a', 'a', 'b', 'c', 'c', 'd', 'e', 'e', 'e',
                        'e', 'f', 'f', 'g', 'g', 'h', 'i', 'i', 'i', 'k'};
    char[] edgeGoesTo= {'b', 'c', 'g', 'i', 'a', 'b', 'g', 'c', 'a', 'd', 'f',
                        'h', 'h', 'i', 'd', 'h', 'g', 'd', 'e', 'j', 'j'};
    int[] edgeWeights= { 2,   8,  14,  17,   5,   4,  21,  10,   7,  20,  12,
                        11,   3,  12,  16,   1,   6,  13,  15,   9,  18};
    char ch;
    int i;

    // add vertices to the graph
    for (ch= 'a'; ch <= 'k'; ch++)
      graph.addVertex(ch);

    // add some edges to the graph
    for (i= 0; i < edgeSource.length; i++)
      graph.createEdge(edgeSource[i], edgeGoesTo[i], edgeWeights[i]);

    return graph;
  }

}
