package com.tgy.kafka.springbootkafkaproducer.resource;

import com.tgy.kafka.springbootkafkaproducer.model.Logs;
import org.apache.log4j.Logger;

import java.io.*;

public class MyFileReader {
    private BufferedReader  stream;
    private static final Logger LOG = Logger.getLogger(MyFileReader.class);

    public BufferedReader  getFile() {
        return stream;
    }

    public void setFile(BufferedReader  stream) {
        this.stream = stream;
    }

    public MyFileReader(String filename) throws IOException {
        this.stream = new BufferedReader(new FileReader(filename));
    }

    public MyFileReader() {
    }

    public boolean closeReader(){
        try {
            stream.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public Logs readLine() throws IOException {
        String logLine = stream.readLine();
        if(logLine == null)
            return null;
        String[] logs = logLine.split(" - ");
        String[] logArray = logs[0].split(" ");
        String date = logArray[0] + " " + logArray[1];
        String type = logArray[2];
        String[] info = logs[1].trim().split(" ");
        String city = info[0];
        String message = info[1];
        return new Logs(date,type,city,message);
    }
}
