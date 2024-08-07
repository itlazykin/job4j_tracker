package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator<Attachment> cmpSize =  new Comparator<>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return Integer.compare(o1.size(), o2.size());
            }
        };
        attachments.sort(cmpSize);
        System.out.println(attachments);
        System.out.println();
        ArrayList<Integer> list = new ArrayList<>() {
            @Override
            public boolean add(Integer o) {
                System.out.println("Add a new element to list: " + o);
                return super.add(o);
            }
        };
        list.add(100500);
        System.out.println();
        Comparator<Attachment> cmpName = new Comparator<>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return o1.name().compareTo(o2.name());
            }
        };
        attachments.sort(cmpName);
        System.out.println(attachments);
    }
}
