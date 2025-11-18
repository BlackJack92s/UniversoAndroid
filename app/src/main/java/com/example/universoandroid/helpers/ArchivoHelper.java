package com.example.universoandroid.helpers;
import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.*;

public class ArchivoHelper {

    final static String fileName = "data.txt";
    final static String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/instinctcoder/readwrite/";
    final static String TAG = ArchivoHelper.class.getName();

    // Leer información del archivo
    public static String ReadFile(Context context){
        String line = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(path + fileName));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append(System.getProperty("line.separator"));
            }
            bufferedReader.close();
            fileInputStream.close();
            return stringBuilder.toString();
        } catch (IOException ex) {
            Log.d(TAG, ex.getMessage());
            return null;
        }
    }

    // Guardar información en el archivo
    public static boolean saveToFile(String data){
        try {
            new File(path).mkdirs();
            File file = new File(path + fileName);
            if (!file.exists()) file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write((data + System.getProperty("line.separator")).getBytes());
            fileOutputStream.close();
            return true;
        } catch (IOException ex) {
            Log.d(TAG, ex.getMessage());
            return false;
        }
    }
}