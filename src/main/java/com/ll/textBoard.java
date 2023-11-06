package com.ll;

import java.util.Scanner;

public class textBoard {
    Scanner sc = new Scanner(System.in);
    storage stor = new storage();

    int id;

    public void run() {

        System.out.println("=== 명언앱 ===");

        while (true) {
            System.out.print("명령) ");

            switch (cmd()){
                //등록
                case 1 :
                    return;
                case 2 :
                    register();
                    break;
                case 3:
                    list();
                    break;
                case 4 :
                    delete();
                    break;
                case 5 :
                    modify();
                    break;
            }

        }
    }

    public int cmd(){
        String cmd = sc.nextLine();
        if (cmd.equals("종료")) return 1;
        else if (cmd.equals("등록")) return 2;
        else if (cmd.equals("목록")) return 3;
        else if (cmd.startsWith("삭제")){
            int index = cmd.indexOf("=");
            id = Integer.parseInt(cmd.substring(index+1));
            return 4;
        }
        else if (cmd.startsWith("수정")){
            int index = cmd.indexOf("=");
            id = Integer.parseInt(cmd.substring(index+1));
            return 5;
        }
        else return 0;
    }

    public void register(){
        System.out.print("명언 : ");
        String sentence = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        stor.save(author, sentence);
        System.out.printf("%d번 명언이 등록되었습니다.\n", stor.count);
    }

    public void list(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        stor.getList();
    }

    public void delete(){
        stor.delete(id);
    }

    public void modify(){
        stor.modify(id);
    }

}
