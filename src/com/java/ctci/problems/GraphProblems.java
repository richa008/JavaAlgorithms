package com.java.ctci.problems;

import com.model.main.Graph;
import com.model.main.GraphNode;
import com.model.main.NodeState;

import java.util.LinkedList;

/**
 * Created by richa on 1/7/17.
 *
 */
public class GraphProblems {

    /**
     *  Checks if there is a path between two nodes in a directed graph
     *
     * @param graph - Directed graph
     * @param start - start node
     * @param end - end node
     * @return - Returns true if there is a path between the 2 nodes
     */
    public boolean routeBetweenNodes(Graph graph, GraphNode start, GraphNode end){

        if(start == null || end == null || start == end){
            return false;
        }

        for(GraphNode node : graph.getAllNodes()){
            node.state = NodeState.Unvisited;
        }

        LinkedList<GraphNode> list = new LinkedList<GraphNode>();
        list.add(start);

        while (!list.isEmpty()) {
            GraphNode n = list.removeFirst();
            if (n != null) {
                for (GraphNode adjacentNode : n.getAdjacentNodes()) {
                    if (adjacentNode != null && adjacentNode.state == NodeState.Unvisited) {
                        if (adjacentNode == end) {
                            return true;
                        }
                        adjacentNode.state = NodeState.Visiting;
                        list.add(adjacentNode);
                    }
                }

                n.state = NodeState.Visited;
            }
        }

        return false;
    }
}
