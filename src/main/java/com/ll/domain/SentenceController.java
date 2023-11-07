package com.ll.domain;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SentenceController {

    private int listNum;
    private String author;
    private String sentence;
    private Scanner sc;
    Map<Integer, Sentence> authorSentenceMap;

    public SentenceController(Scanner sc) {
        this.sc = sc;
        listNum = 0;
        authorSentenceMap = new HashMap<Integer, Sentence>();
    }


    public void register() {
        //등록한 개수 == id이기 때문에 listNum이라는 내부 숫자로 증가시키기 >>> Map의 key로 활용
        //작가와 명언을 Sentence 클래스에 담기 >> Map의 value로 활용
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
        //비어있으면 리턴
        if (authorSentenceMap.isEmpty()) return;
        for (int i = listNum; i > 0; i--) {
            // Map에서 있는 것 역순으로 가져오기
            if (authorSentenceMap.containsKey(i)) {
                System.out.println(i + " / " + authorSentenceMap.get(i).getAuthor() + " / " + authorSentenceMap.get(i).getSentence());
            }
        }
    }

    public void delete(int id) {
        if (authorSentenceMap.containsKey(id)) {
            authorSentenceMap.remove(id);
            System.out.println(id + "번 명언이 삭제되었습니다.");
        } else System.out.println(id + "번 명언은 존재하지 않습니다.");
    }

    public void modify(int id) {
        if (authorSentenceMap.containsKey(id)) {
            Scanner sc = new Scanner(System.in);
            System.out.println("명언(기존) : " + authorSentenceMap.get(id).getSentence());
            System.out.print("명언 : ");
            String newSentence = sc.nextLine();
            System.out.println("작가(기존) : " + authorSentenceMap.get(id).getAuthor());
            System.out.print("작가 : ");
            String newAuthor = sc.nextLine();
            authorSentenceMap.get(id).setSentence(newSentence);
            authorSentenceMap.get(id).setAuthor(newAuthor);
        } else System.out.println(id + "번 명언은 존재하지 않습니다.");
    }

    public void toFile() {
        if (authorSentenceMap.isEmpty()) return;

        File file = new File("file.txt");
        FileWriter writer;
        String save = "";
        for (int i = listNum; i > 0; i--) {
            if (authorSentenceMap.containsKey(i)) {
                save += i + " / " +authorSentenceMap.get(i).getAuthor()+" / " + authorSentenceMap.get(i).getSentence() + "\n";
            }
        }
        try{
            writer = new FileWriter(file);
            writer.write(save);
            writer.flush();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
