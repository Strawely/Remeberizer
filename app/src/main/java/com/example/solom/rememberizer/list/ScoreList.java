package com.example.solom.rememberizer.list;

public class ScoreList extends List {

    public void addHighScore(int score){
        if(head != null){
            ScoreNode i = (ScoreNode)head;
            if(score > i.info){
                ScoreNode newScore = new ScoreNode(score);
                newScore.next = head;
                head = newScore;
            }
            else{
                while(i.next != null && score <= i.next.info){
                    i = (ScoreNode)i.next;
                }
                ScoreNode newScore = new ScoreNode(score);
                newScore.next = i.next;
                i.next = newScore;
            }
        }
        else {
            head = new ScoreNode(score);
            head.next = null;
        }
    }

    public ScoreList(){
        super();
    }

    public ScoreList(Node head){
        super(head);
    }
}
