package com.example.android.newsfeed.utils;

import android.os.AsyncTask;
import android.util.Log;

import com.bumptech.glide.load.HttpException;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class LongOperation extends AsyncTask<Void, Void, String> {
    String code;
    String email;

    public LongOperation(String code, String email) {
        this.code = code;
        this.email = email;
    }

    @Override
    protected String doInBackground(Void... params) {
        HashMap<String, String> postDataParams = new HashMap<String, String>();
        postDataParams.put("email", email);
        postDataParams.put("code", code);

        URL url;
        String response = "";
        try {
            url = new URL("http://10.0.2.2:8080/api/sendMail");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setDoOutput(true);


            OutputStream os = conn.getOutputStream();

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(getPostDataString(postDataParams));

            writer.flush();
            writer.close();
            os.close();
            int responseCode = conn.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                Log.i("", "success");
            } else {
                response = "";

                throw new HttpException(responseCode + "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Executed";
    }

    private String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException, UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        return result.toString();
    }


    @Override
    protected void onPostExecute(String result) {
        Log.i("","Test");
    }
}
