package com.m3c.gs;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alumniHawking23 on 16/08/2017.
 */
public class BinaryTreeEngine <T extends Comparable<T>> implements BinaryTreeInterface<T> {

    private static Logger Log = Logger.getLogger(BinaryTreeEngine.class.getName());
    //it will find the file
    private static final String LOG_PROPERTIES_FILE =  "C:\\Users\\alumniHawking23\\IdeaProjects\\BianryTreeGeneric\\resources\\log4j.properties";


    public static void intialiseLogging(){
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
        Log.info("Logging intialised");
    }


    private int NumOfNodes = 0;
    private Node node = new Node();

    public void settingNodes(T[] values) {
        intialiseLogging();
        //setting the root node
        node.setData(values[0]);
        //and all its children
        for (int i = 1; i < values.length; i++) {
            addNode(values[i]);
        }
    }

    public Node getRootNode() {
        return node;
    }


    public int getNumberOfNodes() {
        NumOfNodes = 0;
        RecursiveNodeSearch(node);
        return NumOfNodes;
    }




    private Node RecursiveNodeSearch(Node node) {

        if (node == null) {
            return null;
        }

        NumOfNodes++;

        Log.trace("Number of nodes - Using Trace " + NumOfNodes);

        //Log.debug("Number of nodes Using- Debug " + NumOfNodes);




        RecursiveNodeSearch(node.getLeft());
        RecursiveNodeSearch(node.getRight());


        return null;
    }


    public void addNode(T element) {
        Node newNode = new Node();
        newNode.setData(element);
        addRecursiveNode(node, newNode);

    }

    private void addRecursiveNode(Node node, Node newNode) {

        //check if left or right branch placement
        if (node.getData().compareTo(newNode.getData()) > 0) {
            //if null then add it as a node
            if (node.getLeft() == null) {
                node.setLeft(newNode);
                return;
            }
            addRecursiveNode(node.getLeft(), newNode);
        } else if (node.getData().compareTo(newNode.getData()) < 0){

            if (node.getRight() == null) {
                node.setRight(newNode);
                return;
            }
            addRecursiveNode(node.getRight(), newNode);

        }


    }


    private Node exitNode;

    public Node findNode(T value) {
        exitNode = null;
        findRecursiveNode(node, value);
        return exitNode;

    }


    private Node findRecursiveNode(Node node, T value) {

        //check if it matches the root node
        if (node.getData().compareTo(value) == 0 ) {
            exitNode = node;
            return null;
        }

        //checks left and right and if the node's data is equal  it returns the node
        if (node.getData().compareTo(value) > 0) {
            if (node.getLeft().getData().compareTo(value) == 0 ) {
                exitNode = node.getLeft();
                return null;
            }
            findRecursiveNode(node.getLeft(), value);
        } else{
            if (node.getRight().getData().compareTo(value) == 0 ) {
                exitNode = node.getRight();
                return null;
            }
            findRecursiveNode(node.getRight(), value);

        }
         return exitNode;
    }

    public List<Node> getSortedTreeAsc() {
        List<Node> list = new ArrayList<Node>();

        findInSequenceRecursiveNodeSmallToLarge(false, node, list);
        return list;
    }

    boolean flipper = true;

    private Node findInSequenceRecursiveNodeSmallToLarge(boolean reverse, Node node, List<Node> listNode) {

        //the reverse is if you want descending
        if (reverse) {
            //go all the way to the end of the very right end branch and add the node to the list
            if (node.getRight() != null) {
                //if yes then go deeper
                findInSequenceRecursiveNodeSmallToLarge(reverse, node.getRight(), listNode);
            }
            //if the next right is null then add to the list
            listNode.add(node);

            if (node.getLeft() != null) {
                //check for left children and recurse
                findInSequenceRecursiveNodeSmallToLarge(reverse, node.getLeft(), listNode);
            }

            return null;


        } else {
            //the opposite to the above
            if (node.getLeft() != null) {
                findInSequenceRecursiveNodeSmallToLarge(reverse, node.getLeft(), listNode);
            }

            listNode.add(node);

            if (node.getRight() != null) {
                findInSequenceRecursiveNodeSmallToLarge(reverse, node.getRight(), listNode);
            }

            return null;


        }

    }

    //uses the function above
    public List<Node> getSortedTreeDesc() {
        List<Node> list = new ArrayList<Node>();

        //reversing variable is the boolean
        findInSequenceRecursiveNodeSmallToLarge(true, node, list);
        return list;

    }


}
