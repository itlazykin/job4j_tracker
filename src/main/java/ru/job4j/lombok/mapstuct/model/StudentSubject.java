package ru.job4j.lombok.mapstuct.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentSubject {
    private int id;
    private String name;
    private String classVal;
    private SubjectEntity subject;
}
