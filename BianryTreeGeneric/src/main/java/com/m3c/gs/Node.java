package com.m3c.gs;

/**
 * Created by alumniHawking23 on 16/08/2017.
 */

public class Node <T extends Comparable<T>>{
    private Node left;
    private Node right;
    private T data;


    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setData(T data) {
        this.data = data;
    }





    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    //stores object like employees here
    public T getData() {
        return data;
    }



//    public void setNode (Node left, Node right, int data){
//        this.left = left;
//        this.right = right;
//        this.data = data;
//    }



}
