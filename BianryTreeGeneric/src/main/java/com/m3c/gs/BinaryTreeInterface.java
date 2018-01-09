package com.m3c.gs;

import java.util.List;

/**
 * Created by alumniHawking23 on 16/08/2017.
 */
public interface BinaryTreeInterface <T extends Comparable<T>> {


    Node getRootNode();
    int getNumberOfNodes();
    void addNode(T element);
    Node findNode(T value);
    List<Node> getSortedTreeAsc();
    List<Node> getSortedTreeDesc();

}
