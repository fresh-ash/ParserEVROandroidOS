package com.example.sergei.a02myjsonparser;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.JsonReader;
import android.widget.TextView;

import com.example.sergei.a02myjsonparser.data.EntityEVRO2016;
import com.example.sergei.a02myjsonparser.logic.ParserEvro2016;
import com.example.sergei.a02myjsonparser.services.AppURLConnection;
import com.example.sergei.a02myjsonparser.services.ServiceEVRO2016;
import com.example.sergei.a02myjsonparser.view.FragmentView;
import com.example.sergei.a02myjsonparser.view.EntityView;
import com.example.sergei.a02myjsonparser.view.ViewPagerEVRO2016;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Controller controller;
    private ViewPager vp;
    ViewPagerEVRO2016 adapter;
    TextView txt;
    //ccccc
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // В main только стартуем асинхронный поток и наш сервис уведомлений.

        controller = new Controller();
        controller.execute();

        startService(new Intent(this, ServiceEVRO2016.class));
        startService(new Intent(this, ServiceEVRO2016.class));
    }

    // В контроллере, в асинхронном потоке делаем запрос к серверу, получаем данные
    // и передаем их в пост обработку. Там отрисовка картинок и кнопочек
    class Controller extends AsyncTask<Void, Void, List<EntityEVRO2016>> {


        @Override
        protected List<EntityEVRO2016> doInBackground(Void... params) {
            List<EntityEVRO2016> listEntitys = null;
            try {
                // Коннектимся
                AppURLConnection connection = new AppURLConnection("http://api.football-data.org/v1/soccerseasons/424/fixtures");
                if (connection.getStatus() < 400){
                    InputStream instream = new BufferedInputStream(connection.getConn().getInputStream());
                    JsonReader jsonRead = new JsonReader(new InputStreamReader(instream, "UTF-8"));
                    ParserEvro2016 parser = new ParserEvro2016();
                    // Парсим
                    listEntitys = parser.parseEntitys(jsonRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return listEntitys;
        }

        @Override
        protected void onPostExecute(List<EntityEVRO2016> entityEVRO2016s) {
            super.onPostExecute(entityEVRO2016s);

            ViewPager vp = (ViewPager) findViewById(R.id.vpPager);
            adapter = new ViewPagerEVRO2016(getSupportFragmentManager());

            // Добавляем фракментов
            EntityView resView = new EntityView(entityEVRO2016s);
            List<String> strings;
            for (int i = 0; i < 7; i++){
                strings = resView.getTeamsGame(i+1);
                adapter.addFragment(i, FragmentView.newInstance(i,strings.get(2),strings.get(0),strings.get(1)));
            }

            // Рисуем
            vp.setAdapter(adapter);

        }
    }


}