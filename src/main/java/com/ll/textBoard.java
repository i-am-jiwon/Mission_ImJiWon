package com.ll;

import java.util.Scanner;

public class textBoard {
    Scanner sc = new Scanner(System.in);
    int regCount = 0;
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
            }

        }
    }

    public int cmd(){
        String cmd = sc.nextLine();
        if (cmd.equals("종료")) return 1;
        if (cmd.equals("등록")) return 2;
        else return 0;
    }

    public void register(){
        System.out.print("명언 : ");
        String sentence = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();
        regCount++;
        System.out.printf("%d번 명언이 등록되었습니다.\n", regCount);
    }

}
