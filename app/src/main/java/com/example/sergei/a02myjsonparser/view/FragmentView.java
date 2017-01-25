package com.example.sergei.a02myjsonparser.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sergei.a02myjsonparser.R;

/**
 * Created by sergei on 23.01.2017.
 *
 * Класс для элементов ViewPager.
 */

public class FragmentView extends Fragment {
    public String getTitle() {
        return title;
    }

    private String title;
    private int index;
    private String message;
    private String result;


    // Вместо этой кучи параметров лучше реализовать отдельный тип данных, но сразу не разобрался,
    //как его в Bundle запихнуть
    public static FragmentView newInstance(int index, String title, String message, String result) {
        FragmentView fragment = new FragmentView();
        Bundle args = new Bundle();
        args.putInt("index", index);
        args.putString("someTitle", title);
        args.putString("mess", message);
        args.putString("res", result);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle saveInstance) {
        super.onCreate(saveInstance);
        index = getArguments().getInt("index", 0);
        title = getArguments().getString("someTitle");
        message = getArguments().getString("mess");
        result = getArguments().getString("res");
    }

    // Заполняем наши фрагменты результатами
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstance) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        TextView teams = (TextView) view.findViewById(R.id.teams);
        TextView res = (TextView) view.findViewById(R.id.result);
        teams.setText(message);
        res.setText(result);
        return view;
    }


}
