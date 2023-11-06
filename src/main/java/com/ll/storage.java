package com.ll;

import java.util.HashMap;
import java.util.Map;

public class storage {
    String author;
    String sentence;

    int count = 0;

    Map<Integer, saveForm> authorSentenceMap = new HashMap<Integer, saveForm>();

    public void save(String author, String sentence){
        count++;
        saveForm sa = new saveForm(author, sentence);
        authorSentenceMap.put(count, sa);
    }

    public void getList(){
        for(int i = authorSentenceMap.size(); i > 0; i--){
            System.out.println(i + " / " + authorSentenceMap.get(i).author + " / " + authorSentenceMap.get(i).sentence);
        }
    }
}
