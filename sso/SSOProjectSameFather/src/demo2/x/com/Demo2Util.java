package demo2.x.com;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Demo2Util {
    public static String doGet(String url, String cookieName, String cookieValue){
        StringBuffer sb = new StringBuffer();
        HttpURLConnection httpURLConnection = null;
        try {
            URL urls = new URL(url + "?cookieName="+cookieName+"&cookieValue="+cookieValue);
            httpURLConnection = (HttpURLConnection) urls.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            InputStream iStream = httpURLConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(iStream);
            BufferedReader br = new BufferedReader(isr);
            String temp;
            while((temp=br.readLine())!=null){
                sb.append(temp);
            }
            br.close();
            isr.close();
            iStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (httpURLConnection!=null) {
                httpURLConnection.disconnect();
            }
        }
        return sb.toString();
    }
}
