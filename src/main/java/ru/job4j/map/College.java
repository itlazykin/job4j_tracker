package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Student findByAccountNoStream(String account) {
        for (Student student : students.keySet()) {
            if (student.account().equals(account)) {
                return student;
            }
        }
        return null;
    }

    public Optional<Student> findByAccount(String account) {
        return Optional.of(students.keySet()
                .stream()
                .filter(s -> s.account().equals(account))
                .findFirst())
                .get();

    }

    public Subject findBySubjectNameNoStream(String account, String name) {
        Optional<Student> student = findByAccount(account);
        if (student.isPresent()) {
            Set<Subject> subjects = students.get(student);
            for (Subject subject : subjects) {
                if (subject.name().equals(name)) {
                    return subject;
                }
            }
        }
        return null;
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        return findByAccount(account).flatMap(v -> Optional.of(students.get(v)
                .stream()
                .filter(subject -> subject.name().equals(name))
                .findFirst())
                .get());
    }
}
