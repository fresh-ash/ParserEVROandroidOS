package com.example.sergei.a02myjsonparser.data;

import interfaces.IEntityEVRO2016;



/**
 * Created by sergei on 19.01.2017.
 * Класс, который описывает сущность необходимых для ТЗ данных.
 * Методы все элементарные - устанавливают и получают поля.
 * Переопределен метод toString().
 */

public class EntityEVRO2016 implements IEntityEVRO2016 {
    private String homeTeamName, awayTeamName, result;
    private int matchDay, goalsHomeTeam, goalsAwayTeam;

    public int getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public void setGoalsHomeTeam(int goalsHomeTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
    }

    public int getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    public void setGoalsAwayTeam(int goalsAwayTeam) {
        this.goalsAwayTeam = goalsAwayTeam;
    }

    public int getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(int matchDay) {
        this.matchDay = matchDay;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


    @Override
    public String toString() {
        String result = "My entity: homeTeamName:" + getHomeTeamName() + "awayTeamName:" + getAwayTeamName() ;

        return result;
    }
}
