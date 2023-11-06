package com.ll;

import java.util.Scanner;

public class textBoard {
    public void run(){


        System.out.println("=== 명언앱 ===");

        System.out.print("명령) ");

        Scanner sc = new Scanner(System.in);
        String cmd = sc.nextLine();

        System.out.print("명언 : ");
        String sentence = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        System.out.printf("%d번 명언이 등록되었습니다.\n",1);

        System.out.print("명령) ");
        String cmd2 = sc.nextLine();


    }
}
