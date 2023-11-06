package com.ll.base;

import lombok.Getter;

import java.util.Scanner;

public class Command {

    // 수정과 삭제에서 쓰이는 id
    @Getter
    private int id = 0;

    public int cmd(String cmd){
        if (cmd.equals("종료")) return 1;
        else if (cmd.equals("등록")) return 2;
        else if (cmd.equals("목록")) return 3;
        else if (cmd.startsWith("삭제")){
            int tempId = idSeparator(cmd);
            if (tempId == 0) return 0;
            id = tempId;
            return 4;
        }
        else if (cmd.startsWith("수정")){
            int tempId = idSeparator(cmd);
            if (tempId == 0) return 0;
            id = tempId;
            return 5;
        }
        else return 0;
    }

    private int idSeparator(String cmd){
        // '='기준 앞 단어 3개가 '?id'와 일치하는 지 알아보기
        // 일치하면 =뒤에는 숫자가 오는지 확인하고 숫자면 id에 값 저장하기
        String preWords;

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
                return id;
            }catch(NumberFormatException e){
                return 0;
            }
        }else return 0;
    }

}
