package com.example.sergei.a02myjsonparser.logic;

import android.util.JsonReader;
import android.util.Log;

import com.example.sergei.a02myjsonparser.data.EntityEVRO2016;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import interfaces.IParserJSON;

/**
 * Created by sergei on 23.01.2017.
 *
 * Парсер указанного в ТЗ ресурса.
 */

public class ParserEvro2016 implements IParserJSON {



    /*
     * Метод для всего документа. Ненужные для ТЗ сущности просто игнорируются, но
     * без труда могут быть распарсены.
     */

    @Override
    public List<EntityEVRO2016> parseEntitys(JsonReader jr) throws IOException {
        List<EntityEVRO2016> entitys = new ArrayList<>();
        jr.beginObject();
        while (jr.hasNext()){
            String name = jr.nextName();
            if (name.equals("_links")){
                jr.skipValue();
            }
            else if (name.equals("count")){
                jr.nextInt();
            }
            else if (name.equals("fixtures")){
                jr.beginArray();
                while (jr.hasNext()){
                    entitys.add(parseEntity(jr));
                    Log.i("Info", "addEntity");
                }
                jr.endArray();
            }
            else {
                jr.skipValue();
            }
        }
        jr.endObject();
        jr.close();
        return entitys;
    }

    /*
    * Метод для массива, описанного в JSON документе.
    * */

    @Override
    public EntityEVRO2016 parseEntity(JsonReader jr) throws IOException {
        EntityEVRO2016 ent = new EntityEVRO2016();
        jr.beginObject();
        while(jr.hasNext()){
            String name = jr.nextName();
            if (name.equals("_links")){
                jr.skipValue();
            }
            else if (name.equals("date")){
                jr.skipValue();
            }
            else if (name.equals("status")){
                jr.skipValue();
            }
            else if (name.equals("matchday")){
                ent.setMatchDay(jr.nextInt());
            }
            else if (name.equals("homeTeamName")){
                ent.setHomeTeamName(jr.nextString());
            }
            else if (name.equals("awayTeamName")){
                ent.setAwayTeamName(jr.nextString());
            }
            else if (name.equals("result")){
                List<Integer> mass = getResult(jr);
                ent.setGoalsHomeTeam(mass.get(0));
                ent.setGoalsAwayTeam(mass.get(1));
            }
            else{
                jr.skipValue();
            }

        }
        jr.endObject();

        return ent;
    }


    /*
    * Парсер счета основного времени.
    * Не парсит extraTime и счет пенальти соответственно.
    * */
    public List<Integer> getResult(JsonReader jr) throws IOException {
        List<Integer> result = new ArrayList<>();

        jr.beginObject();
        while(jr.hasNext()){
            String name = jr.nextName();
            if (name.equals("goalsHomeTeam")){
                result.add(jr.nextInt());
            }
            else if (name.equals("goalsAwayTeam")){
                result.add(jr.nextInt());
            }
            else {
                jr.skipValue();
            }
        }
        jr.endObject();



        return result;
    }
}
