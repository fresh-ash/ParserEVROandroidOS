package com.example.sergei.a02myjsonparser.services;

import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import interfaces.IURLConnection;

/**
 * Created by sergei on 20.01.2017.
 *
 * Класс исключительно для подключения к необходимому URL.
 */

public class AppURLConnection implements IURLConnection {

    private HttpURLConnection conn;
    private Integer status;

    // Уже в конструкторе передаем URL
    public AppURLConnection(String str) throws IOException {
        URL url = new URL(str);
        this.conn = (HttpURLConnection) url.openConnection();
        Log.i("CONN", "Open connection to URL " + str);
        this.status = this.conn.getResponseCode();
    }
    public HttpURLConnection getConn() {
        return this.conn;
    }

    // Для проверки ответа от сервера
    public Integer getStatus() {
        Log.i("STATUS_CONNECTION", String.valueOf(this.status));
        return this.status;
    }

}
