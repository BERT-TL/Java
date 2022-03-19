package com.bert.spring5.collectionType;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Stu {
    //1. 数组类型属性
    private String[] courses;

    //2. list类型属性
    private List<String> list;

    //3. Map类型属性
    private Map<String,String> maps;

    //4. Set类型属性
    private Set<String> set;

    private List<Course> courseList;//Course类型



    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }
    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void test() {
        System.out.println(Arrays.toString(courses));
        System.out.println(list);
        System.out.println(maps);
        System.out.println(set);
        System.out.println(courseList);
    }



}
