
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package frc.robot.Framework.Logging;
/**
 *
 * @author vshah-21
 */
import java.io.FileWriter;
import java.util.Scanner;
import java.net.Socket;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CSVClient{
   
    Socket firstSocket;
    Scanner in;
    ArrayList<Report> report = new ArrayList();
    public CSVClient(String addr, int portNumber){
        try {
            firstSocket = new Socket(addr, portNumber);
            in = new Scanner(firstSocket.getInputStream());
            getServerInputAndDumpToCSV();
        } catch (IOException ex) {
            Logger.getLogger(CSVClient.class.getName()).log(Level.SEVERE, null, ex);//dont really need, i was just using this in netbeans
        }
       
    }
    /**
     * Gets the input from the surver and dumps it to an output 
     * In all honesty this is proably very poorly written and inefficient, and if that bothers you feel free to clean it up
     * I however am not such a mythical good programmer and am to lazy to fix it
     * What this does is it gets lines from server until it has none. For each line we deformat into an arraylist (CSV server does some
     *  formatting to keep data organized across the network so we must first undo it)
     * Then we take the arraylist and move it into an array(once again prbly pointless but i had already written the array impl
     * and didn't wanna re-write)
     * This array is then written to a csv through fun. explained below
     */
    public void getServerInputAndDumpToCSV(){ 
        
        String lineFromServer;
        do{
           lineFromServer = in.nextLine();
           ArrayList<String> strings = new ArrayList<String>();
           char[] cs = lineFromServer.toCharArray();
           int lastIndex = 0;
           int saveI =0;
        System.out.println(lineFromServer.length());
        boolean firstfound = false;
        for(int i =0; i < lineFromServer.length();i++){
            saveI = i;
            try{
                
                if(i>0&&lineFromServer.charAt(i)==','){
                    if(!firstfound){
                        strings.add(lineFromServer.substring(lastIndex,i));
                        firstfound = true;
                        lastIndex =i;
                    }else{
                    System.out.println("hit" + lineFromServer.substring(lastIndex+1,i));
                    strings.add(lineFromServer.substring(lastIndex+1,i));
                    lastIndex=i;
                    }
                }
                
            }catch(NullPointerException e){
              System.out.println("exception at line " + i);  
            }
        }
        System.out.println("String sie" + strings.size());
        String[] s = new String[strings.size()];
        for(int i =0; i < s.length;i++){
            s[i] = strings.get(i);
        }
        report.add(new Report(s));
        }while(in.hasNext());{
        
       
    }
         String name = "Lrvgwpf"+ System.currentTimeMillis();
        writeCsvFile(name+".csv");
    }
    String filename = "";
    /**
     * 
     * @return the name of the file that we created
     */
    public String fileName(){   
        return directoryName() + filename;
    }
    /**
     * 
     * @return the name of the directory(full path!) to place the files in + what you named the file, rn  its lrvgwpf(left and right
     *  velocity for path following)
     */
    public static String staticDirectoryName(){
        return "D:\\MyProfile\\Desktop\\2019 2020\\Robotics\\Graphs";
    }
    public String directoryName(){
        System.out.println("D:\\MyProfile\\Desktop\\2019 2020\\Robotics\\Graphs"+filename);
        return "D:\\MyProfile\\Desktop\\2019 2020\\Robotics\\Graphs";
    }
    /**
     * Writes across the network for whatever you wanna call it 
     * @param fileName the name we wanna call it
     */
    public void writeCsvFile(String fileName) {
       
        
        FileWriter fileWriter = null;
                 
        try {
            fileWriter = new FileWriter(directoryName()+fileName);
            filename = fileName;
            
            fileWriter.append("\n");// add a new line
             
            //Write ur report to csv=> this was intented to be further implemented but never got around to it, might remove it
            for (Report reportss : report) {
                reportss.returnCsvReport(fileWriter);
                fileWriter.append("\n");
            }
             
        } catch (Exception e) {
            e.printStackTrace();
        } finally {//being responsible and closing stuff down like good programmer
             
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
             
        }
    }
    public static void main(String[] args) throws IOException {
      new CSVClient("10.58.95.2",5800);//Robot ip, port 5800(MAKE SURE THIS ISN'T USED IN PORT FORWARDING!!!!!!)
    }
}















