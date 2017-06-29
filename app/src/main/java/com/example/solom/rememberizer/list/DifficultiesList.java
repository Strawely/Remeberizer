package com.example.solom.rememberizer.list;

public class DifficultiesList extends List {

    public ScoreList getScoreList(int fieldSize){
        if(head.info == fieldSize){
            return ((DifficultyNode)head).getRecords();
        }
        if (head != null){
            DifficultyNode i = (DifficultyNode)head;
            while (i.next != null && i.info != fieldSize){
                i = (DifficultyNode) i.next;
            }
            return i.getRecords();
        }
        else {
            return null;
        }
    }
}
