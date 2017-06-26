package com.example.solom.rememberizer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ContentGenerator {

    private List<Integer> randomizedContent;

    ContentGenerator(int height, int width){
        randomizedContent = genRndContent(height, width);
    }

    private List<Integer> genRndContent(int height, int width){
        Integer[] integers = new Integer[height*width/2];
        Random rnd = new Random();
        List<Integer> result = new ArrayList<>();
        R.drawable drawable = new R.drawable();
        Field[] fields = R.drawable.class.getDeclaredFields();
        int j = 0;
        int flag = 0;
        while (flag == 0){
            try {
                flag = fields[j].getInt(drawable);
            }
            catch (Exception e){

            }
            j++;
        }

        for (int i = j; i < j+integers.length; i++) {
            try {
                integers[i-j] = fields[i].getInt(drawable);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        List<Integer> list = arrayToList(integers);

        for (int i = list.size(); i > 0; i--) {
            int r = rnd.nextInt(list.size());
            result.add(list.get(r));
            list.remove(r);
        }
        return result;
    }

    private List<Integer> arrayToList(Integer[] array){
        List<Integer> list = new ArrayList<>();
        for (Integer anArray : array) {
            if (anArray != null) {
                list.add(anArray);
                list.add(anArray);
            }
        }
        return list;
    }

    public int getRandomizedContent() {
        int res = randomizedContent.get(0);
        randomizedContent.remove(0);
        return res;
    }

}
