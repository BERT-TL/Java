package com.bert.spring5;

public class Book {

//    无参构造
    private String bname;
    private String bauthour;


    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBauthour() {
        return bauthour;
    }

    public void setBauthour(String bauthour) {
        this.bauthour = bauthour;
    }

    public void testDemo() {
        System.out.println(bname+":"+bauthour);
    }

}
