package ru.progwards.java1.lessons.datetime;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class StatisticInfo implements Comparable{
    public String sectionName;
    public int fullTime = 0;
    public int selfTime = 0;
    public int count = 0;
    boolean isRun; // выполняется ли секция
    private Profiler.TimeMeasureUnits timeMeasureUnits; // единицы измерения времени
    private long runStartTime; // время начала
    private List<Insider> runInside; // кто запущен внутри

    StatisticInfo(String sectionName, Profiler.TimeMeasureUnits timeMeasureUnits) {
        this.sectionName = sectionName;
        this.timeMeasureUnits = timeMeasureUnits;
        runInside = new ArrayList<Insider>();
    }

    // текущее время
    long getTimeNow() {
        switch (timeMeasureUnits) {
            case NANOSECONDS:
                return System.nanoTime();
            default:
                return System.currentTimeMillis();
        }
    }

    // вход в секцию
    void enter() {
        count++;
        if (!isRun) {
            isRun = true;
            runStartTime = getTimeNow();
        }
    }
    // выход из секции
    void exit() {
        if (!isRun) return;
        long timeNow = getTimeNow();
        int newFullTime = fullTime + (int) (timeNow - runStartTime);
        int newSelfTime = actualSelfTime(timeNow);
        runInside.clear();
        isRun = false;
        fullTime = newFullTime;
        selfTime = newSelfTime;
    }
    // собственное время, без подсекций
    int actualSelfTime(long timeNow) {
        if (!isRun) return selfTime;
        int result = selfTime + (int) (timeNow - runStartTime);
        for (Insider i : runInside) {
            result -= i.getInsideTime(timeNow);
        }
        return result;
    }
    // добавить внутреннюю секцию
    void addInsider(StatisticInfo info) {
        if (isRun) {
            runInside.add(new Insider(info, getTimeNow()));
        }
    }
    // удалить внутреннюю секцию
    void removeInsider(StatisticInfo info) {
        if (isRun) {
            long timeNow = getTimeNow();
            ListIterator i = runInside.listIterator();
            while (i.hasNext()) {
                Insider insider = (Insider) i.next();
                if (insider.info == info) {
                    selfTime -= insider.getInsideTime(timeNow);
                    i.remove();
                }
            }
        }
    }
    @Override
    public String toString() {
        return "\n" + sectionName + " total:" + fullTime + " self:" + selfTime + " count:" + count;
    }
    // для сортировки в TreeMap
    @Override
    public int compareTo(Object o) {
        return this.sectionName.compareTo(((StatisticInfo) o).sectionName);
    }


    public static void main(String[] args) {

    }
}
