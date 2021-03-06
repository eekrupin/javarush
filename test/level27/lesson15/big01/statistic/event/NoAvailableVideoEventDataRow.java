package com.javarush.test.level27.lesson15.big01.statistic.event;

import java.util.Date;

public class NoAvailableVideoEventDataRow implements EventDataRow{
    private int totalDuration;
    private Date currentDate;

    public NoAvailableVideoEventDataRow(int totalDuration) {
        this.totalDuration = totalDuration;
        currentDate = new Date();
    }
    public EventType getType() {
        return EventType.NO_AVAILABLE_VIDEO;
    }

    public Date getDate() {
        return currentDate;
    }

    public int getTime() {
        return totalDuration;
    }

}
