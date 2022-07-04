package com.fullarray.dijkstra_algorithm;

public class Dijkstra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vertex vertexA = new Vertex("A");
		Vertex vertexB = new Vertex("B");
		Vertex vertexC = new Vertex("C");
		Vertex vertexD = new Vertex("D");
		Vertex vertexE = new Vertex("E");
		
		vertexA.addNeighbour(new Edge(5,vertexA,vertexC));
		vertexA.addNeighbour(new Edge(10,vertexA,vertexB));
		vertexC.addNeighbour(new Edge(3,vertexC,vertexB));
		vertexC.addNeighbour(new Edge(7,vertexC,vertexD));
		vertexC.addNeighbour(new Edge(8,vertexC,vertexE));
		vertexB.addNeighbour(new Edge(6,vertexB,vertexD));
		vertexD.addNeighbour(new Edge(1,vertexD,vertexE));
		
		DijkstraShortestPath shortestPath = new DijkstraShortestPath();
		shortestPath.computeShortestPaths(vertexA);
		
		System.out.println("======================================");
		System.out.println("Min distance");
		System.out.println("======================================");
		
		System.out.println("Best distance from A to B: "+vertexB.getDistance());
		System.out.println("Best distance from A to C: "+vertexC.getDistance());
		System.out.println("Best distance from A to D: "+vertexD.getDistance());
		System.out.println("Best distance from A to E: "+vertexE.getDistance());
		
		System.out.println("=====================	=================");
		System.out.println("Paths");
		System.out.println("======================================");
		
		System.out.println("Best Path from A to B: "+shortestPath.getShortestPathTo(vertexB));
		System.out.println("Best Path from A to C: "+shortestPath.getShortestPathTo(vertexC));
		System.out.println("Best Path from A to D: "+shortestPath.getShortestPathTo(vertexD));
		System.out.println("Best Path from A to E: "+shortestPath.getShortestPathTo(vertexE));
		
	}

}
