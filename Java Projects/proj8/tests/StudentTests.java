package tests;

import org.junit.*;

import graph.Graph;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
/*
 * Name - Race Saunders
 * Directory ID - rssaunde
 * University ID - 114803078
 * Section - 0108
 * "I pledge on my honor that I have not given or received any unauthorized assistance on this assignment."
 *  The purpose of this class is to create tests for the Graph class 
 */
public class StudentTests {
	@Test
	public void testAddVertex() {
		Graph<Boolean> graph = new Graph<>(); // this will be a very small graph

		assertTrue(graph.addVertex(true));
		assertTrue(graph.isVertex(true));

		assertTrue(graph.isVertex(true));
		assertFalse(graph.isVertex(false));

		assertTrue(graph.addVertex(false));

		assertFalse(graph.addVertex(true));
	}

	
	@Test
	public void testIsVertex() {
		Graph<Integer> graph = TestData.exampleGraph1();

		assertEquals(10, graph.getVertices().size());
		assertTrue(TestData.checkCollection(graph.getVertices(),
				new Integer[] { 131, 132, 216, 250, 320, 330, 351, 411, 420, 430 }));

		graph.addVertex(132); 

		assertEquals(10, graph.getVertices().size()); 
		assertTrue(TestData.checkCollection(graph.getVertices(),
				new Integer[] { 131, 132, 216, 250, 320, 330, 351, 411, 420, 430 }));
	}

	
	@Test
	public void testGetVertices() {
		Graph<Integer> graph = TestData.exampleGraph3();

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

	
	@Test
	public void testRemoveVertex() {
		Graph<Character> graph = TestData.exampleGraph4();

		assertTrue(graph.changeEdgeCost('a', 'b', 100));
		assertTrue(graph.changeEdgeCost('f', 'i', 101));
		assertTrue(graph.changeEdgeCost('g', 'h', 102));

		assertEquals(100, graph.costOfEdge('a', 'b'));
		assertEquals(101, graph.costOfEdge('f', 'i'));
		assertEquals(102, graph.costOfEdge('g', 'h'));

	
		assertEquals(6, graph.costOfEdge('h', 'g'));
	}

	@Test
	public void testCreateEdge() {
		Graph<Character> graph = TestData.exampleGraph4();

		assertFalse(graph.changeEdgeCost('e', 'c', 100));
		assertEquals(4, graph.neighborsOfVertex('e').size());
	}


	@Test
	public void testCostOfEdge() {
		Graph<Character> graph = TestData.exampleGraph4();

		assertFalse(graph.changeEdgeCost('a', 'w', 100));
		assertFalse(graph.changeEdgeCost('x', 'b', 101));
		assertFalse(graph.changeEdgeCost('y', 'z', 102));

		assertEquals(-1, graph.costOfEdge('a', 'w'));
		assertEquals(-1, graph.costOfEdge('x', 'b'));
		assertEquals(-1, graph.costOfEdge('y', 'z'));
		assertTrue(TestData.checkCollection(graph.neighborsOfVertex('a'), new Character[] { 'b', 'c', 'g', 'i' }));
		assertTrue(TestData.checkCollection(graph.getVertices(),
				new Character[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k' }));
	}

	
	@Test
	public void testChangeEdgeCost() {
		Graph<Integer> graph = TestData.exampleGraph1();
		int[] vertices = { 131, 132, 216, 250, 320, 330, 351, 411, 420, 430 };
		int[] expectedResults = { 1, -1, 1, 1, -1, -1, 1, 1, -1 };
		int i;

		graph.removeEdge(132, 216);
		graph.removeEdge(320, 330);
		graph.removeEdge(330, 351);
		graph.removeEdge(420, 430);

		for (i = 0; i < vertices.length - 1; i++)
			assertEquals(expectedResults[i], graph.costOfEdge(vertices[i], vertices[i + 1]));
	}


	@Test
	public void testRemoveEdge() {
		Graph<String> graph = TestData.exampleGraph2();
		String[] verticesToCheck = { "giraffe", "hyena", "iguana", "jaguar" };

		for (String vertex : verticesToCheck)
			assertTrue(TestData.checkCollection(graph.neighborsOfVertex(vertex),
					new String[] { "koala", "lemur", "manatee", "numbat", "ocelot" }));
	}


	@Test
	public void testNeighborsOfVertex() {
		Graph<Integer> graph = TestData.exampleGraph3();

		assertEquals(0, graph.neighborsOfVertex(10).size());
	}


	@Test
	public void testReachable() {
		Graph<Integer> graph = TestData.exampleGraph3();

		assertEquals(0, graph.neighborsOfVertex(4).size());
	}


	@Test
	public void testDivideGraph() {
		Graph<Integer> graph = TestData.exampleGraph1();

		assertTrue(graph.createEdge(132, 411, 0));
		assertFalse(graph.createEdge(250, 330, -17));

		assertEquals(2, graph.neighborsOfVertex(132).size());
		assertEquals(1, graph.neighborsOfVertex(250).size());
		assertTrue(TestData.checkCollection(graph.neighborsOfVertex(132), new Integer[] { 216, 411 }));
		assertTrue(TestData.checkCollection(graph.neighborsOfVertex(250), new Integer[] { 320 }));
	}

	

}
