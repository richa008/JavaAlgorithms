package com.model.main;

import java.util.ArrayList;

/**
 * Created by richa on 1/7/17.
 *
 */

public class GraphNode {

    int data;

    public NodeState state;

    private ArrayList<GraphNode> adjacentNodes;

    public ArrayList<GraphNode> getAdjacentNodes(){
        return adjacentNodes;
    }
}
