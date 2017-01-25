package com.example.sergei.a02myjsonparser.view;

import com.example.sergei.a02myjsonparser.data.EntityEVRO2016;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergei on 23.01.2017.
 *
 * Вспомагательный класс. Для структурирования результатов. Слишком толстые сущности данных получились.
 *
 */

public class EntityView {
    private List<EntityEVRO2016> resultList;
    private String[] matchdays = {"Group stage1", "Group state2", "Group stage3", "1/8", "1/4", "1/2", "Final"};

    public EntityView(List<EntityEVRO2016> result){
        this.resultList = result;
    }

    // Искать в массиве сущностей данных нужную инфу по дням
    // Из-за этого лучше разбить сущности на более мелкие
    public  List<String> getTeamsGame(int mathday){
        List<String> str = new ArrayList<>();
        String matches = "";
        String result = "";
        for (EntityEVRO2016 entityEVRO2016 : resultList) {
                if (entityEVRO2016.getMatchDay() == mathday) {
                    matches += entityEVRO2016.getHomeTeamName() + " : " + entityEVRO2016.getAwayTeamName() + "\n";
                    result += entityEVRO2016.getGoalsHomeTeam() + " - " + entityEVRO2016.getGoalsAwayTeam() + "\n";
                }
        }
        str.add(matches);
        str.add(result);
        str.add(matchdays[mathday -1]);
        return str;
    }

}
