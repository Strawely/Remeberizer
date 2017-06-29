package com.example.solom.rememberizer;

import android.content.Context;

import com.example.solom.rememberizer.list.DifficultiesList;
import com.example.solom.rememberizer.list.ScoreList;
import com.example.solom.rememberizer.list.ScoreNode;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Statistics implements Serializable {

    private DifficultiesList difficultiesList;
    private Context context;
    private Statistics dsStatistics;  //Statistics object from deserialization

    public Statistics(int time, int fieldSize, Context context){
        this.context = context;
        dsStatistics = deserialization();
        if(dsStatistics != null){
            difficultiesList = dsStatistics.getDifficultiesList();
        }
        else {
            difficultiesList = new DifficultiesList();
        }
        ScoreList scoreList = difficultiesList.getScoreList(fieldSize);
        scoreList.addHighScore(scoreFromTime(time));
    }

    private Statistics deserialization(){
        try {
            FileInputStream fileInputStream = context.openFileInput("stat.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Statistics) objectInputStream.readObject();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            return null;
        }
    }

    private int scoreFromTime(int time){
        return time;
    }

    public DifficultiesList getDifficultiesList() {
        return difficultiesList;
    }

    public void setDifficultiesList(DifficultiesList difficultiesList) {
        this.difficultiesList = difficultiesList;
    }
}
