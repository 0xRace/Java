package tests;

// (c) Larry Herman, 2017.  You are allowed to use this code yourself, but
// not to provide it to anyone else.

import graph.Graph;
import java.util.Set;
import java.util.HashSet;
import org.junit.*;
import static org.junit.Assert.*;

public class PublicTests {

  // Tests the return value of addVertex(), both for adding new vertices and
  // for trying to add already-existing vertices, that isVertex() returns
  // true for vertices that do exist, and false for vertices that don't
  // exist.
  @Test public void testPublic1() {
    Graph<Boolean> graph= new Graph<>();  // this will be a very small graph

    assertTrue(graph.addVertex(true));
    assertTrue(graph.isVertex(true));

    assertTrue(graph.isVertex(true));
    assertFalse(graph.isVertex(false));

    assertTrue(graph.addVertex(false));

    assertFalse(graph.addVertex(true));  // already-existing vertex
  }

  // Tests the basic operation of getVertices(), and that addVertex()
  // doesn't change anything if called to attempt to add an already-existing
  // vertex.
  @Test public void testPublic2() {
    Graph<Integer> graph= TestData.exampleGraph1();

    assertEquals(10, graph.getVertices().size());
    assertTrue(TestData.checkCollection(graph.getVertices(),
                                        new Integer[]{131, 132, 216, 250,
                                                      320, 330, 351, 411,
                                                      420, 430}));

    graph.addVertex(132);  // we love 132 so much we are trying to add it again

    assertEquals(10, graph.getVertices().size());  // but nothing changed
    assertTrue(TestData.checkCollection(graph.getVertices(),
                                        new Integer[]{131, 132, 216, 250,
                                                      320, 330, 351, 411,
                                                      420, 430}));
  }

  // Tests calling costOfEdge() on some edges in a graph (of course this
  // also tests createEdge()), and that createEdge() only adds the edge in
  // the direction that it should be added.
  @Test public void testPublic3() {
    Graph<Integer> graph= TestData.exampleGraph3();

    assertEquals(14, graph.costOfEdge(1, 2));
    assertEquals(13, graph.costOfEdge(1, 3));
    assertEquals(7, graph.costOfEdge(6, 4));
    assertEquals(2, graph.costOfEdge(8, 6));
    assertEquals(1, graph.costOfEdge(8, 7));

    assertEquals(-1, graph.costOfEdge(1, 6));
    assertEquals(-1, graph.costOfEdge(8, 1));
    assertEquals(-1, graph.costOfEdge(2, 6));
    assertEquals(-1, graph.costOfEdge(5, 1));
  }

  // Tests calling changeEdgeCost() in the typical case.
  @Test public void testPublic4() {
    Graph<Character> graph= TestData.exampleGraph4();

    assertTrue(graph.changeEdgeCost('a', 'b', 100));
    assertTrue(graph.changeEdgeCost('f', 'i', 101));
    assertTrue(graph.changeEdgeCost('g', 'h', 102));

    assertEquals(100, graph.costOfEdge('a', 'b'));
    assertEquals(101, graph.costOfEdge('f', 'i'));
    assertEquals(102, graph.costOfEdge('g', 'h'));

    // ensure the opposite-direction edge from h to g wasn't changed
    assertEquals(6, graph.costOfEdge('h', 'g'));
  }

  // Tests calling changeEdgeCost() with a nonexistent edge.
  @Test public void testPublic5() {
    Graph<Character> graph= TestData.exampleGraph4();

    assertFalse(graph.changeEdgeCost('e', 'c', 100));
    assertEquals(4, graph.neighborsOfVertex('e').size());
  }

  // Tests calling changeEdgeCost() with nonexistent vertices.
  @Test public void testPublic6() {
    Graph<Character> graph= TestData.exampleGraph4();

    assertFalse(graph.changeEdgeCost('a', 'w', 100));
    assertFalse(graph.changeEdgeCost('x', 'b', 101));
    assertFalse(graph.changeEdgeCost('y', 'z', 102));

    assertEquals(-1, graph.costOfEdge('a', 'w'));
    assertEquals(-1, graph.costOfEdge('x', 'b'));
    assertEquals(-1, graph.costOfEdge('y', 'z'));
    assertTrue(TestData.checkCollection(graph.neighborsOfVertex('a'),
                                        new Character[]{'b', 'c', 'g', 'i'}));
    assertTrue(TestData.checkCollection(graph.getVertices(),
                                        new Character[]{'a', 'b', 'c', 'd',
                                                        'e', 'f', 'g', 'h',
                                                        'i', 'j', 'k'}));
  }

  // Tests calling removeEdge() to remove some edges from a graph.
  @Test public void testPublic7() {
    Graph<Integer> graph= TestData.exampleGraph1();
    int[] vertices= {131, 132, 216, 250, 320, 330, 351, 411, 420, 430};
    int[] expectedResults= {1, -1, 1, 1, -1, -1, 1, 1, -1};
    int i;

    graph.removeEdge(132, 216);
    graph.removeEdge(320, 330);
    graph.removeEdge(330, 351);
    graph.removeEdge(420, 430);

    for (i= 0; i < vertices.length - 1; i++)
      assertEquals(expectedResults[i],
                   graph.costOfEdge(vertices[i], vertices[i + 1]));
  }

  // Tests the basic operation of neighborsOfVertex().
  @Test public void testPublic8() {
    Graph<String> graph= TestData.exampleGraph2();
    String[] verticesToCheck= {"giraffe", "hyena", "iguana", "jaguar"};

    for (String vertex : verticesToCheck)
      assertTrue(TestData.checkCollection(graph.neighborsOfVertex(vertex),
                                          new String[]{"koala", "lemur",
                                                       "manatee", "numbat",
                                                       "ocelot"}));
  }

  // Tests calling neighborsOfVertex() on a nonexistent vertex, which should
  // return an empty collection.
  @Test public void testPublic9() {
    Graph<Integer> graph= TestData.exampleGraph3();

    assertEquals(0, graph.neighborsOfVertex(10).size());
  }

  // Tests calling neighborsOfVertex() on an existing vertex with no
  // neighbors, which should return an empty collection.
  @Test public void testPublic10() {
    Graph<Integer> graph= TestData.exampleGraph3();

    assertEquals(0, graph.neighborsOfVertex(4).size());
  }

  // Tests that createEdge() will add zero-cost edges, but returns false
  // without changing anything when trying to add a negative-cost edge.
  @Test public void testPublic11() {
    Graph<Integer> graph= TestData.exampleGraph1();

    assertTrue(graph.createEdge(132, 411, 0));
    assertFalse(graph.createEdge(250, 330, -17));

    assertEquals(2, graph.neighborsOfVertex(132).size());
    assertEquals(1, graph.neighborsOfVertex(250).size());
    assertTrue(TestData.checkCollection(graph.neighborsOfVertex(132),
                                        new Integer[]{216, 411}));
    assertTrue(TestData.checkCollection(graph.neighborsOfVertex(250),
                                        new Integer[]{320}));
  }

  // Tests calling removeVertices() to remove some vertices from a graph.
  @Test public void testPublic12() {
    Graph<String> graph= TestData.exampleGraph2();

    graph.removeVertex("aardvark");  // no incoming edges
    graph.removeVertex("numbat");    // no outgoing edges
    graph.removeVertex("giraffe");   // both outgoing and incoming edges

    assertFalse(graph.isVertex("aaradvark"));
    assertFalse(graph.isVertex("numbat"));
    assertFalse(graph.isVertex("giraffe"));

    assertEquals(12, graph.getVertices().size());
    assertTrue(TestData.checkCollection(graph.getVertices(),
                                        new String[]{"beagle", "cat", "donkey",
                                                     "elephant", "flamingo",
                                                     "hyena", "iguana",
                                                     "jaguar", "koala",
                                                     "lemur", "manatee",
                                                     "ocelot"}));
  }

  // Tests calling neighborsOfVertex() on a vertex with an edge to itself,
  // so it is one of its own neighbors.
  @Test public void testPublic13() {
    Graph<Integer> graph= TestData.exampleGraph3();

    // add a few edges
    graph.createEdge(4, 8, 1);
    graph.createEdge(3, 8, 1);
    graph.createEdge(8, 8, 1);
    graph.createEdge(8, 2, 1);

    assertTrue(TestData.checkCollection(graph.neighborsOfVertex(8),
                                        new Integer[]{2, 4, 6, 7, 8}));
  }

  // Tests the basic operation of reachable().
  @Test public void testPublic14() {
    Graph<Integer> graph= TestData.exampleGraph3();

    assertTrue(TestData.checkCollection(graph.reachable(1),
                                        new Integer[]{1, 2, 3, 4, 5}));
    assertTrue(TestData.checkCollection(graph.reachable(8),
                                        new Integer[]{3, 4, 5, 6, 7, 8}));
  }

  // Tests the basic operation of divideGraph().
  @Test public void testPublic15() {
    Graph<Integer> graph= TestData.exampleGraph3();
    Graph<Integer> graph2;
    Set<Integer> vertices= new HashSet<Integer>();
    Integer[][] newNeighbors= {{}, {5}, {6}, {6, 7}};
    Integer[][] graph2NewNeighbors= {{2, 3}, {4}, {4}, {}};
    int i;

    for (i= 1; i <= 4; i++)
      vertices.add(i);

    graph2= graph.divideGraph(vertices);

    assertEquals(4, graph.getVertices().size());
    assertTrue(TestData.checkCollection(graph.getVertices(),
                                        new Integer[]{5, 6, 7, 8}));

    assertEquals(4, graph2.getVertices().size());
    assertTrue(TestData.checkCollection(graph2.getVertices(),
                                        new Integer[]{1, 2, 3, 4}));

    // check the remaining neighbors of the vertices in the original graph
    for (i= 0; i < newNeighbors.length; i++)
      assertTrue(TestData.checkCollection(graph.neighborsOfVertex(i + 5),
                                          newNeighbors[i]));

    // check the neighbors of the vertices in the new graph
    for (i= 0; i < graph2NewNeighbors.length; i++)
      assertTrue(TestData.checkCollection(graph2.neighborsOfVertex(i + 1),
                                          graph2NewNeighbors[i]));
  }

}
