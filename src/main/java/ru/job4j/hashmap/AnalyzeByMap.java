package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        double sum = 0;
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                sum += s.score();
                count++;
            }
        }
        return sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil p : pupils) {
            double sum = 0;
            for (Subject s : p.subjects()) {
                sum += s.score();
            }
            result.add(new Label(p.name(), sum / p.subjects().size()));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> tmp = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                tmp.put(subject.name(), tmp.getOrDefault(pupil.name(), 0) + subject.score());
            }
        }
        List<Label> labels = new ArrayList<>();
        int pupilsSize = pupils.size();
        for (Map.Entry<String, Integer> entry : tmp.entrySet()) {
            labels.add(new Label(entry.getKey(), ((double) entry.getValue()) / pupilsSize));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        return null;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        return null;
    }
}
