package com.example.sonu.mbltrust;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class dataFetching extends AsyncTask  <String, Void, String> {
    private Context context;
    TextView  textView ;
    public dataFetching(Context context  , TextView textView) {
        this.context = context;
        this.textView = textView;

    }



    protected void onPreExecute() {
    }

    @Override
    protected String doInBackground(String... arg0) {
        String link;
        String data;
        String id = "1";
       BufferedReader bufferedReader;
        String result;
        try {
            data = "?id=" + URLEncoder.encode(id, "UTF-8");
           link = "http://mblvtrust.in/showApp.php" + data;
           URL url = new URL(link);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
           bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            result = bufferedReader.readLine();
           return result;
           } catch (Exception e) {
           return new String("Exception: " + e.getMessage());
            }
        }
  @Override
    protected void onPostExecute(String result) {
       String jsonStr = result;
      if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                String query_result = jsonObj.getString("query_result");
                this.textView.setText(query_result);

               } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(context, "Check Your Internet Connection .", Toast.LENGTH_SHORT).show();
               }
           } else {
            Toast.makeText(context, "Check Your Internet Connection .", Toast.LENGTH_SHORT).show();
           }
        }
}