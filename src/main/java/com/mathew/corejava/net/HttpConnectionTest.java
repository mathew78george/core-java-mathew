package com.mathew.corejava.net;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpConnectionTest {
  public static void main(String[] args) {

    try {
      URL targetURL = new URL("http://localhost:8080/angularwebproject/MyTestServlet");
      HttpURLConnection conn = (HttpURLConnection) targetURL.openConnection();
//      conn.setAllowUserInteraction(true);
//      conn.setConnectTimeout(15000); // 15 sec. connection timeout
      conn.setDoInput(true);
//      conn.setDoOutput(true);
//      conn.setUseCaches(false);
      conn.setRequestMethod("POST");
      System.out.println(conn.getExpiration());
//      conn.setRequestProperty("Content-type", "text/html; charset=" + "UTF-8");
//      conn.getI
//      conn.connect(); // just sending the request.
      System.out.println("done");
//      conn.getInputStream();
      conn.disconnect(); // we don't like to wait for response.
    } catch(MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch(ProtocolException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch(IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }catch(Exception e){
      e.printStackTrace();
    }

  }

}
