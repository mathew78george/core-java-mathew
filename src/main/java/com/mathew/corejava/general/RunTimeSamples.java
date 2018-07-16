package com.mathew.corejava.general;

import java.io.IOException;

public class RunTimeSamples {

  public static void main(String[] args) {
    Runtime runTime = Runtime.getRuntime();
    String[] commnds = new String[] { "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe",
        "http://javaconceptoftheday.com/" };
    try {
      Process process = runTime.exec(commnds);
      Thread.sleep(10000);
      process.destroy();
      System.out.println("Done");
      Process process1 = runTime.exec("notepad.exe");
      process1.getOutputStream().write("Test".getBytes());
    } catch(IOException ioe) {
      ioe.printStackTrace();
    } catch(InterruptedException ie) {
      ie.printStackTrace();
    }
  }

}
