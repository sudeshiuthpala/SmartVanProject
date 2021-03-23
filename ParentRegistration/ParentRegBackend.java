package com.example.smartvanproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class ParentRegBackend extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    ParentRegBackend(Context ctx){
        context= ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String type=params[0];

        String reg_url="http://192.168.1.102/smartvan/parentRegistration.php";
        if (type.equals("reg")){
            try {
                String NIC=params[1];
                String FName=params[2];
                String MName=params[3];
                String LName=params[4];
                String Email=params[5];
                String contactNumber=params[6];
                String Address=params[7];
                String Area=params[8];
                String Password=params[9];
                URL url= new URL(reg_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
                String post_data= URLEncoder.encode("NIC","UTF-8")+"="+URLEncoder.encode(NIC,"UTF-8")+"&"+
                        URLEncoder.encode("FName","UTF-8")+"="+URLEncoder.encode(FName,"UTF-8")+"&"+
                        URLEncoder.encode("MName","UTF-8")+"="+URLEncoder.encode(MName,"UTF-8")+"&"+
                        URLEncoder.encode("LName","UTF-8")+"="+URLEncoder.encode(LName,"UTF-8")+"&"+
                        URLEncoder.encode("Email","UTF-8")+"="+URLEncoder.encode(Email,"UTF-8")+"&"+
                        URLEncoder.encode("contactNumber","UTF-8")+"="+URLEncoder.encode(contactNumber,"UTF-8")+"&"+
                        URLEncoder.encode("Address","UTF-8")+"="+URLEncoder.encode(Address,"UTF-8")+"&"+
                        URLEncoder.encode("Location","UTF-8")+"="+URLEncoder.encode(Area,"UTF-8")+"&"+
                        URLEncoder.encode("Password","UTF-8")+"="+URLEncoder.encode(Password,"UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1));
                StringBuilder result= new StringBuilder();
                String line;
                while ((line=bufferedReader.readLine())!=null){
                    result.append(line);
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog=new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Owner Registration Status");
    }

    @Override
    protected void onPostExecute(String result) {
        if (result!=null && result.equals("successful")){
            Intent i= new Intent(context,LogIn.class);
            context.startActivity(i);
//
        }
        else{
            alertDialog.setMessage(result);
            alertDialog.show();
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}