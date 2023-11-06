package com.ll.base;

import com.ll.domain.SentenceController;

import java.util.Scanner;

public class App {
    Scanner sc = new Scanner(System.in);
    SentenceController stor = new SentenceController(sc);
    Command command = new Command();

    int id;

    public void run() {
        System.out.println("=== 명언앱 ===");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            switch (command.cmd(cmd)){
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
                    stor.delete(command.id);
                    break;
                // 수정
                case 5 :
                    stor.modify(command.id);
                    break;
                // 잘못된 명령시 오류 메시지 출력
                default:
                    System.out.println("*명령어 오류* 다시 입력해 주세요.");
            }
        }
    }


}
