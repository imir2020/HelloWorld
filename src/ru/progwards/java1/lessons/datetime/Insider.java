package ru.progwards.java1.lessons.datetime;

public class Insider {
    public int selfTime; // чистое время связянной секции на момент создания связи
    StatisticInfo info; // секция, с которой связь

    Insider(StatisticInfo info, long timeNow) {
        this.info = info;
        selfTime = info.actualSelfTime(timeNow);
    }

    int getInsideTime(long timeNow) {
        return info.actualSelfTime(timeNow) - selfTime;
    }
}
