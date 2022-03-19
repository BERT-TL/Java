package com.bert.spring5.collectionType;

public class Course {
    private String cname;

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "course{" +
                "cname='" + cname + '\'' +
                '}';
    }
}
