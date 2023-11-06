package com.ll.base;

import com.ll.domain.SentenceController;

import java.util.Scanner;

public class App {
    Scanner sc = new Scanner(System.in);
    SentenceController stor = new SentenceController(sc);

    int id;

    public void run() {
        System.out.println("=== 명언앱 ===");
        while (true) {
            System.out.print("명령) ");
            switch (cmd()){
                //종료
                case 1 :
                    return;
                //등록
                case 2 :
                    stor.register();
                    break;
                //목록
                case 3:
                    stor.list();
                    break;
                // 삭제
                case 4 :
                    stor.delete(id);
                    break;
                // 수정
                case 5 :
                    stor.modify(id);
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



}
