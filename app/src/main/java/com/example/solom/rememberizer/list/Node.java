package com.example.solom.rememberizer.list;

public abstract class Node {

    protected Node next;
    protected int info;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    protected Node(int info){
        this.info = info;
    }
}
