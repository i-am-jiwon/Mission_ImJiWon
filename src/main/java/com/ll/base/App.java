package com.ll.base;

import com.ll.domain.SentenceController;

import java.util.Scanner;

public class App {
    private Scanner sc = new Scanner(System.in);
    //crud서비스 컨트롤러
    SentenceController sentenceController = new SentenceController(sc);
    //명령 입력 구분기
    Command command = new Command();


    public void run() {
        System.out.println("=== 명언앱 ===");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            switch (command.cmd(cmd)){
                //종료
                case 1 :
                    sentenceController.toFile();
                    return;
                //등록
                case 2 :
                    sentenceController.register();
                    break;
                //목록
                case 3:
                    sentenceController.list();
                    break;
                // 삭제
                case 4 :
                    sentenceController.delete(command.getId());
                    break;
                // 수정
                case 5 :
                    sentenceController.modify(command.getId());
                    break;
                // 잘못된 명령시 오류 메시지 출력
                default:
                    System.out.println("*명령어 오류* 다시 입력해 주세요.");
            }
        }
    }


}
