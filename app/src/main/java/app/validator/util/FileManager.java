package app.validator.util;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author Rakesh.Jha
 * Date - 07/10/2013
 * Definition - Logger file use to keep Log info to external SD with the simple method
 */

public class FileManager {

//    private static String filename = "ProjectName_Log";
    private static final String folderName = "/Files/";

    static boolean isExternalStorageAvailable = false;
    static boolean isExternalStorageWriteable = false;
    static String state = Environment.getExternalStorageState();

    public static void init() {
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            // We can read and write the media
            isExternalStorageAvailable = isExternalStorageWriteable = true;
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            // We can only read the media
            isExternalStorageAvailable = true;
            isExternalStorageWriteable = false;
        } else {
            // Something else is wrong. It may be one of many other states, but all we need
            //  to know is we can neither read nor write
            isExternalStorageAvailable = isExternalStorageWriteable = false;
        }

        String path = Environment.getExternalStorageDirectory().getPath();
        File dir = new File(path + "/Files/ITS_A90/logs");
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            if (!dir.exists()) {
                Log.d("Dir created ", "Dir created ");
                dir.mkdirs();
            }
        }
    }

    public static void saveVideo(Context context, Uri uri){
        try {

            File newfile;

            AssetFileDescriptor videoAsset = context.getContentResolver().openAssetFileDescriptor(uri, "r");
            FileInputStream in = videoAsset.createInputStream();

//            File filepath = Environment.getExternalStorageDirectory();
            String path = Environment.getExternalStorageDirectory().getPath();
            File dir = new File(path + "/" +"videos" + "/");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            newfile = new File(dir, "save_"+System.currentTimeMillis()+".mp4");

            if (newfile.exists()) newfile.delete();



            OutputStream out = Files.newOutputStream(newfile.toPath());

            // Copy the bits from instream to outstream
            byte[] buf = new byte[1024];
            int len;

            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }

            in.close();
            out.close();

            Log.v("", "Copy file successful.");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void logError(String origin,String message) {
            try {
        String path = Environment.getExternalStorageDirectory().getPath();
        File logFile = new File(path+folderName + getDate() + ".txt");

            if (!logFile.exists()) {
                try {
                    Log.d("File created ", "File created ");
                    logFile.createNewFile();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
                //BufferedWriter for performance, true to set append to file flag
                BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true));
                String msg = getDateTIme() + "   " + origin + "   " + message;
                buf.write(msg + "\r\n");
                //buf.append(message);
                buf.newLine();
                buf.flush();
                buf.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                Log.d("DEBUG_APP_E",e.getLocalizedMessage());
            }
        }
        public StringBuilder getLogs(String name){
            StringBuilder text = new StringBuilder();
            try {
                File sdcard = Environment.getExternalStorageDirectory();
                File file = new File(sdcard +folderName + name);

                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    text.append(line);
                    Log.i("Test", "text : "+text+" : end");
                    text.append('\n');
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();

            }
            return text;
        }

     public List<File> getFiles(){
         ArrayList<File> list = new ArrayList<>();
        try {

         String path = Environment.getExternalStorageDirectory().toString()+folderName;
         Log.d("Files", "Path: " + path);
         File directory = new File(path);
         File[] files = directory.listFiles();
         Log.d("Files", "Size: "+ files.length);
         for (File file : files) {
             Log.d("Files", "FileName:" + file.getName());
             list.add(file);
         }
         return list;
        }catch(Exception e){
            return list;
        }
     }

    private static String getDateTIme() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd  hh-mm-ss"); //EEEE, dd-MMM-yyyy hh-mm-ss a
        Calendar calendar = Calendar.getInstance();

        return simpleDateFormat.format(calendar.getTime());
    }

    private static String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); //EEEE, dd-MMM-yyyy hh-mm-ss a
        Calendar calendar = Calendar.getInstance();

        return simpleDateFormat.format(calendar.getTime());
    }
}