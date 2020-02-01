/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package halloffame;
package frc.robot;
/**
 *
 * @author vshah-21
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
/*
A classs that is designed to take an array last and send it across 
the network to be interpreted as a csv
*/
public class CSVServer {
     /*
     @param s This is the array of strings which will be transformed into a single string with commas seperating elements so it can 
     be converted to a string
     */
    public static String addComas(String[] s){
        String news = "";
        for(int i =0; i < s.length;i++){
            news+=s[i];
            if(i<s.length-1){
                news+=",";
            }
        }
        news +=",";
        return news;
    }
    /**
     * 
     * @param ones An arraylist of data to be sent accross the network, will be reformated with addComas
     * @throws IOException makes sure our socket 
     * doesnt create any errors
     */
    public void testings(ArrayList<String[]> ones)  throws IOException {
         
        try (ServerSocket listener = new ServerSocket(5800)) {
            
                try (Socket realServer = listener.accept()) {
                    PrintWriter o = new PrintWriter(realServer.getOutputStream(), true);
                    for(int i =0; i < ones.size();i++){
                        o.println(addComas(ones.get(i)));
                    }
                    realServer.close();
                    
                }
            
        }
    }

}