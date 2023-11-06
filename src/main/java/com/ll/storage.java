package com.ll;

import java.util.HashMap;
import java.util.Map;

public class storage {
    String author;
    String sentence;

    int count = 0;

    Map<Integer, saveForm> authorSentenceMap = new HashMap<Integer, saveForm>();

    public void save(String author, String sentence) {
        count++;
        saveForm sa = new saveForm(author, sentence);
        authorSentenceMap.put(count, sa);
    }

    public void getList() {
        for (int i = count; i > 0; i--) {

            if (authorSentenceMap.isEmpty()) {
                // test
                System.out.println("목록 없다.");
            } else if (authorSentenceMap.containsKey(i)) {
                System.out.println(i + " / " + authorSentenceMap.get(i).author + " / " + authorSentenceMap.get(i).sentence);
            }
        }
    }

    public void delete(int id) {
        if (authorSentenceMap.containsKey(id)) {
            authorSentenceMap.remove(id);
        }
        else System.out.println("x");
    }
}
