package android.zjf.com.test;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by 破音D弦 on 2017/9/13.
 */

public class FileOutPut extends BaseActivity{
   public void save(String inputText){
       BufferedWriter writer = null;
       FileOutputStream out =null;
       try {
           out = openFileOutput("data", MODE_PRIVATE);
           writer = new BufferedWriter(new OutputStreamWriter(out));
           writer.write(inputText);
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           try {
               if (writer!=null){
                   writer.close();
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
       }

   }

   public String load() {
       BufferedReader reader =null;
       StringBuilder content = new StringBuilder();
       try {
           FileInputStream in = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
           String line ="";
           while((line = reader.readLine()) != null){
               content.append(line);
           }
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           if (reader!=null){
               try {
                   reader.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }
       return content.toString() ;
   }
}
