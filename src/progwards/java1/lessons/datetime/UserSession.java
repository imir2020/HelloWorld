package ru.progwards.java1.lessons.datetime;

import java.time.LocalDateTime;
import java.util.Random;

public class UserSession {
    static private int handleNextNum = 0;
    private int sessionHanle;
    private String userName;
    private LocalDateTime lastAccess;
    private SessionManager sessionManager;

    public UserSession(String userName) {
        Random rnd = new Random();
        this.sessionHanle = handleNextNum++; // считаю так лучше для хэш таблицы + полная уникальность + легче
        this.userName = userName;
        refreshLastAccess();
    }
    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
    public void setSessionHandle(int sessionHandle) {
        sessionManager.reHash(this, this.sessionHanle, sessionHanle);
        this.sessionHanle = sessionHanle;
    }
    public int getSessionHandle() {
        return sessionHanle;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return userName;
    }
    public void refreshLastAccess() {
        this.lastAccess = LocalDateTime.now();
    }
    public void setLastAccess(LocalDateTime lastAccess) {
        this.lastAccess = lastAccess;
    }
    public LocalDateTime getLastAccess() {
        return lastAccess;
    }
    public boolean isValid(int sessionValid, LocalDateTime now) {// sessionValid-период валидности сессии в секундах
        return lastAccess.plusSeconds(sessionValid).isAfter(now);
    }
    @Override
    public String toString() {
        return "S{" + "h=" + sessionHanle + ",u='" + userName + '}';
    }
}
