package ru.progwards.java1.lessons.datetime;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Profiler {
    enum TimeMeasureUnits {MILLISECONDS, NANOSECONDS}

    ;
    static TimeMeasureUnits timeMeasureUnits = TimeMeasureUnits.MILLISECONDS;
    static TreeMap<String, StatisticInfo> sections = new TreeMap();


    // войти в профилировочную секцию
    public static void enterSection(String name) {
        StatisticInfo section;
        if (sections.containsKey(name)) {
            section = sections.get(name);
        } else {
            section = new StatisticInfo(name, timeMeasureUnits);
            sections.put(name, section);
        }
        if (!section.isRun) {
            for (StatisticInfo i : sections.values()) i.addInsider(section);
        }
        section.enter();
    }

    // выйти из профилировочной секции
    public static void exitSection(String name) {
        StatisticInfo section = sections.get(name);
        section.exit();
        if (!section.isRun) {
            for (StatisticInfo i : sections.values()) i.removeInsider(section);
        }
    }

    // обнулить статистику
    public static void clear() {
        sections.clear();
    }

    // получить профилировочную статистику, отсортировать по наименованию секции
    public static List<StatisticInfo> getStatisticInfo() {
        return new ArrayList<StatisticInfo>(sections.values());
    }

    public static String getSectionsInfo() {
        return sections.values().toString();
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
        }
    }

    public static void main(String[] args) {
        enterSection("s1");
        sleep(100);
        enterSection("s2");
        sleep(200);
        exitSection("s2");
        enterSection("s2");
        sleep(200);
        exitSection("s2");
        enterSection("s2");
        sleep(200);
        exitSection("s2");
        sleep(100);
        exitSection("s1");
        System.out.println(getSectionsInfo());
    }
}
