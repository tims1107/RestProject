package Main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Calendar;

public class AppMain {

    public static void main(String[] args) {
        getAPI();
    }

    private void _buildJson(String json){
        GsonBuilder builder = new GsonBuilder();
        builder.setVersion(2.8);

        Gson gson = builder.create();
    }

    private static void getAPI() {
        URL url;

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(0);
        System.out.println(cal.getTime());
        StringBuffer sb = new StringBuffer();
        BufferedReader reader = null;

        try {

            url = new URL("https://npiregistry.cms.hhs.gov/api/?version=2.1&number=1932215357&pretty=true");

            reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            for (String line; (line = reader.readLine()) != null; ) {
                System.out.println(line);
                for(int i : line.getBytes()){
                    //System.out.println("byte: " + i + " " + (char)i);


                }


            }

            reader.close();

            reader = null;
            //System.out.println(sb.toString());

        } catch (Exception e) {

        } finally {
            if(reader != null) {
                try{reader.close();} catch (Exception e){}
            }
        }

    }

}
