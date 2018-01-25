package com.codecool;
import java.io.*;

public class Logger {
    Horse[] horses;

    public Logger(Horse[] horses) {
        this.horses = horses;
    }

    public Logger() {}

    
    public String printTime(double horseLaptTime)  {
        String startTime = "00:00:00";
        double seconds = horseLaptTime*1000;
        int m = (int)Math.round(seconds / 60000 + Integer.parseInt(startTime.substring(0,1)));
        int s = (int)Math.round((seconds % 60000)/1000 + Integer.parseInt(startTime.substring(3,4)));
        int ms = (int)Math.round((seconds % 1000) + Integer.parseInt(startTime.substring(6,7)));
        String newtime = m+":"+s+":"+ms;
        return newtime;
    }
}