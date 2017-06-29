package com.example.solom.rememberizer.list;

public abstract class List {

    protected Node head;

    protected List(){
        head = null;
    }

    protected List(Node head){
        this.head = head;
    }

    protected void addAfter(Node a, Node b){
        if (a != null && b != null){
            b.setNext(a.getNext());
            a.setNext(b.getNext());
        }
    }

    protected void addLast(Node node){
        if(head != null){
            Node i = head;
            while (i.getNext() != null){
                i = i.getNext();
            }
            if(node != null){
                node.setNext(null);
                i.setNext(node);
            }
        }
        else {
            head = node;
        }
    }
}
