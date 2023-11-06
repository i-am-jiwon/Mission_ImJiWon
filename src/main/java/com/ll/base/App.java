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
                default:
                    System.out.println("*명령어 오류* 다시 입력해 주세요.");
            }
        }
    }

    public int cmd(){
        String cmd = sc.nextLine();
        String preWords;
        if (cmd.equals("종료")) return 1;
        else if (cmd.equals("등록")) return 2;
        else if (cmd.equals("목록")) return 3;
        else if (cmd.startsWith("삭제")){
            int index = cmd.indexOf("=");
            if(index == -1){
                return 0;
            }
            try{
                preWords = cmd.substring(index-3,index);
            }catch (StringIndexOutOfBoundsException e){
                return 0;
            }
            if(preWords.equals("?id")){
                try{
                    id = Integer.parseInt(cmd.substring(index+1));
                }catch(NumberFormatException e){
                    return 0;
                }
            }else return 0;
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
