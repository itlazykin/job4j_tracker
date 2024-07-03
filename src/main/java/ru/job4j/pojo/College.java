package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.getName());
        System.out.println(student.getGroup());
        System.out.println(student.getData());
        student.setName("Denis Lazykin");
        student.setData(2011);
        student.setGroup("AAA-54");
        System.out.println(student.getName()
                + " from group "
                + student.getGroup()
                + " entered "
                + student.getData());
    }
}
