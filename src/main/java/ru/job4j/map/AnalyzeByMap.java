package ru.job4j.map;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Collections.sort;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sumScore = 0;
        byte sumOfSubjects = 0;
        for (Pupil pupil : pupils) {
            for (Subject score : pupil.getSubjects()) {
                sumScore += score.getScore();
                sumOfSubjects += 1;
            }
        }
        return sumScore / sumOfSubjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> label = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double pupilScore = 0;
            int pupilSubjectCount = 0;
            List<Subject> subj = pupil.getSubjects();
            for (Subject score : subj) {
                pupilScore += score.getScore();
                pupilSubjectCount += 1;
            }
            label.add(new Label(pupil.getName(), pupilScore / pupilSubjectCount));
        }
        return label;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        List<Label> label = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.getSubjects()) {
                map.putIfAbsent(subject.getName(), 0);
                map.computeIfPresent(subject.getName(),(t,u)-> u+ subject.getScore());
                /*for (Map.Entry<String, Integer> x : map.entrySet()) {
                    if (subject.getName().equals(x.getKey())) {
                        map.put(x.getKey(), map.get(x.getKey()) + subject.getScore());
                    }
                }*/
            }
        }
        for (Map.Entry<String, Integer> x : map.entrySet()) {
            label.add(new Label(x.getKey(), x.getValue() / pupils.size()));
        }
        return label;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> label = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double pupilScore = 0;
            List<Subject> subj = pupil.getSubjects();
            for (Subject score : subj) {
                pupilScore += score.getScore();
            }
            label.add(new Label(pupil.getName(), pupilScore));
        }
        sort(label);
        return label.get(label.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        List<Label> label = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.getSubjects()) {
                map.putIfAbsent(subject.getName(), 0);
                for (Map.Entry<String, Integer> x : map.entrySet()) {
                    if (subject.getName().equals(x.getKey())) {
                        map.put(x.getKey(), map.get(x.getKey()) + subject.getScore());
                    }
                }
            }
        }
        for (Map.Entry<String, Integer> x : map.entrySet()) {
            label.add(new Label(x.getKey(), x.getValue()));
        }
        sort(label);
        return label.get(label.size() - 1);
    }
}
