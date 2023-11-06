package com.ll.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SentenceController {

    private int listNum;
    private String author;
    private String sentence;
    private Scanner sc;
    Map<Integer, Sentence> authorSentenceMap;

    public SentenceController(Scanner sc){
        this.sc = sc;
        listNum = 0;
        authorSentenceMap = new HashMap<Integer, Sentence>();
    }


    public void register() {
        System.out.print("명언 : ");
        String sentence = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        listNum++;
        Sentence sa = new Sentence(author, sentence);
        authorSentenceMap.put(listNum, sa);

        System.out.printf("%d번 명언이 등록되었습니다.\n", listNum);
    }

    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for (int i = listNum; i > 0; i--) {

            if (authorSentenceMap.isEmpty()) {
                // test
                System.out.println("목록 없다.");
                return;
            } else if (authorSentenceMap.containsKey(i)) {
                System.out.println(i + " / " + authorSentenceMap.get(i).author + " / " + authorSentenceMap.get(i).sentence);
            }
        }
    }

    public void delete(int id) {
        if (authorSentenceMap.containsKey(id)) {
            authorSentenceMap.remove(id);
            System.out.println(id+"번 명언이 삭제되었습니다.");
        }
        else System.out.println(id +"번 명언은 존재하지 않습니다.");
    }

    public void modify(int id) {
        if (authorSentenceMap.containsKey(id)) {
            Scanner sc = new Scanner(System.in);
            System.out.println("명언(기존) : "+ authorSentenceMap.get(id).sentence);
            System.out.print("명언 : ");
            String newSentence = sc.nextLine();
            System.out.println("작가(기존) : "+ authorSentenceMap.get(id).author);
            System.out.print("작가 : ");
            String newAuthor = sc.nextLine();

            authorSentenceMap.get(id).sentence = newSentence;
            authorSentenceMap.get(id).author = newAuthor;
        }
        else System.out.println(id +"번 명언은 존재하지 않습니다.");
    }
}
