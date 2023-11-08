package com.ll.simpleDb;

public class SimpleDb {

    public SimpleDb(String sql1, String sql2, String sql3 ,String sql4) {
    }

    public void run(String sql){

    }

    public void run(String sql, String title, String body, boolean isBlind){

    }

    public void setDevMode(boolean b){

    }

    public Sql genSql(){

        return new Sql();
    }
}

class Sql{
    public Sql append(String sql){
        return this;
    }
    public Sql append(String sql1, String sql2){
        return this;
    }
    public Sql append(String sql1, int i1, int i2, int i3, int i4){
        return this;
    }

    public long insert(){
        return 1L;
    }
}
