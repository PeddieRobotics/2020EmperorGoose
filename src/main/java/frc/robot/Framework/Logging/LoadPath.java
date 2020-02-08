package frc.robot.Framework.Logging;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import edu.wpi.first.wpilibj.DriverStation;

/**
 *
 * @author vshah-21
 */
public class LoadPath {
    public ArrayList<String[]> loadCSV(String fileName){
        ArrayList<String[]> points = new ArrayList<String[]>();
        File test = new File(fileName);
        if(!test.exists()){
            DriverStation.reportError("exists",false);

        }
        String csvFile = fileName;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        int lines = 0;
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] dataFromCSV = null;
                // use comma as separator
                try{
                    dataFromCSV = line.split(cvsSplitBy);
                    Double.parseDouble(dataFromCSV[1]);
                    points.add(dataFromCSV);
                }catch(Exception e){
                    
                    
                    
                    }
                    
                }
            
            

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
   
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return points;
    }
    
}