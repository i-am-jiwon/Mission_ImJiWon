package com.ll.base;

import java.util.Scanner;

public class Command {

    int id = 0;


    public int cmd(String cmd){
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
            return 5;
        }
        else return 0;
    }

}
