/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vshah-21
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frc.robot.Framework.Logging;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.event.HyperlinkEvent;

/**
 *
 * @author vshah-21
 */
//to-do: fix horrible naming convention 
public class GraphsForCSV extends Application {
    ArrayList<String[]> points = new ArrayList<String[]>();//our point arraylist, to be generated by csv

    ArrayList<CheckBox> boxes;//our checkbox array, one for each header, let us graph things we choose
    String[] headings;//poorly named header
    double[] scaleFactor;//important array, what we will scale each column by
    double[][] pointArrays;//our arrayList of points
    int WIDTH = 1500; //mod as u want
    int HEIGHT = 700;
    int currentColumn = 2;

    // ArrayList<Boolean> graphBooleans = new ArrayList<Boolean>();
    boolean wasRan = false;
    double setpoint = 0;
    double timeSetpoint=1;
    /**
     * Our startup screen
     */
    @Override
    public void start(Stage primaryStage) {

        Group root = new Group();
        Canvas background = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(background);//add canvas first so doesn't overwirte the buttons + stuff
        Button runGraphServer = new Button("graphScene");
        Button runGraphDefault = new Button("default Graph");
        Button startVideoPlayer = new Button("Video Player");
        final FileChooser fileChooser = new FileChooser();

        final Button openButton = new Button("Open a file");
        final Button openMultipleButton = new Button("Open files");

        openButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
                fileChooser.setInitialDirectory(new File("D:\\MyProfile\\Documents\\NetBeansProjects\\GraphsForCSV\\"));//CHANGE TO WHEREVER UR FILE IS 
                
                File file = fileChooser.showOpenDialog(primaryStage);

                if (file != null) {

                    graphCSVScene(primaryStage, file.getAbsolutePath());//if it exists then we graph la csv

                }
            }
        });
        EventHandler<ActionEvent> drawFromServer = (ActionEvent e) -> {
            CSVClient csvCreator = new CSVClient("10.58.95.2", 5800);/// thread will run until connection made(be wary!)
            graphCSVScene(primaryStage, csvCreator.fileName());//once connectoin made run csvScene

        };
        EventHandler<ActionEvent> graphLatest = (ActionEvent e) -> {
            graphCSVScene(primaryStage, "D:\\MyProfile\\Documents\\NetBeansProjects\\GraphsForCSV\\DefaultGraph.csv");// default
                                                                                                                      // graph
                                                                                                                      // loc
        };
        System.out.println("client graphessssssr");
        EventHandler<ActionEvent> videoButtonPressed = (ActionEvent es) -> {
            System.out.println("ran");
            videoScene(primaryStage);
        };

        startVideoPlayer.addEventHandler(ActionEvent.ACTION, videoButtonPressed);//add our event handlers
        runGraphServer.addEventHandler(ActionEvent.ACTION, drawFromServer);
        runGraphDefault.addEventHandler(ActionEvent.ACTION, graphLatest);
        root.getChildren().add(openButton);
        openButton.relocate(200, 600);//move stuff to desired loc. after added to our group
        root.getChildren().add(startVideoPlayer);//to-do add gst bindings 
        root.getChildren().add(runGraphDefault);
        startVideoPlayer.relocate(200, 300);
        root.getChildren().add(runGraphServer);
        runGraphServer.relocate(200, 200);
        runGraphDefault.relocate(200, 400);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        System.out.println("running and not breaking?");//change print statements if u want, prbly should, i was frustrated @ the time
    }

    public void videoScene(Stage primaryStage) {
        Group root = new Group();
        
        Canvas mainCanvas = new Canvas(WIDTH, HEIGHT);//canvas is thing u can draw on
        root.getChildren().add(mainCanvas);

        primaryStage.setScene(new Scene(root));
        
        addBackButton(primaryStage, root);
        primaryStage.show();
    }

    public void graphCSVScene(Stage primaryStage, String filename) {
        System.out.println("filename " + filename);
        LoadCSV load = new LoadCSV();//try to load the csv

        System.out.println("file name");//another debug print, lets us know file has been loaded
        pointArrays = load.loadCSV(filename);
        headings = load.getHeading();
        String[] variables;
        variables = load.getVariables();
        primaryStage.setTitle("CSV Graphyer");
        Group root = new Group();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        primaryStage.setTitle("This is really running");//i was dealing w/ bugs okay
        boxes = new ArrayList<CheckBox>();

        EventHandler<ActionEvent> eventHandlerTextFields = (ActionEvent e) -> {
            System.out.println("happening");//dummy field, to be added to in new implementation
        };

        EventHandler<ActionEvent> eventHandlerTextField;
        eventHandlerTextField = (ActionEvent event) -> {
            // Playing the animation
            try {
                System.out.println("running this");
                gc.clearRect(0, 0, WIDTH, HEIGHT);
                printVars(gc, variables);
                gc.setFill(Color.BLACK);
                gc.setStroke(Color.BLUE);

                calcAndDrawAxes(pointArrays, HEIGHT, HEIGHT/2, gc);
                drawGraph(gc, pointArrays);

            } catch (Exception e) {

            }

        };
        EventHandler<MouseEvent> drawLineAndPoints = (MouseEvent dragged) -> {
            if(dragged.getSceneX()%2==0){
            gc.clearRect(0, 0, WIDTH, HEIGHT);
            calcIntersections(gc,pointArrays,dragged.getSceneX());
            calcAndDrawAxes(pointArrays,HEIGHT,HEIGHT/2,gc);
            drawGraph(gc,pointArrays);
            printVars(gc, variables);
            }
        };
       
        Button but = new Button("Testing?");
        but.relocate(200, 200);
       
        but.addEventHandler(ActionEvent.ACTION, eventHandlerTextField);
       // System.out.println("here?");
        //canvas.addEventHandler(KeyEvent.KEY_PRESSED, eventHandlerTextField);
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, drawLineAndPoints);
    
       
        
        VBox layout= new VBox(5);
        System.out.println("can print from here? ");
        for(int i =0; i < pointArrays[0].length;i++){
                try{
                CheckBox checky = new CheckBox(headings[i]);
                
                boxes.add(checky);
                boxes.get(i).relocate(20,50+ (HEIGHT/2)*((double)i/pointArrays[0].length));
                //boxes.get(i).addEventHandler(ActionEvent.ACTION, eventHandlerTextFields);
                layout.getChildren().add(boxes.get(i));
                }catch(Exception e){
                    
                }
        }
        
        layout.getChildren().add(but);
        root.getChildren().add(canvas);
        
        root.getChildren().add(layout);
        
        addBackButton(primaryStage, root);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        
        System.out.println("running and not breaking?");
    
    }
    /**
     * 
     * @param gc The graphic context of the canvas that we are currently in 
     * @param s Variable values to be printed out
     */
    public void printVars(GraphicsContext gc, String[] s){
        double totalLength = 0;
        for(int i =0; i < s.length;i++){

            totalLength += s[i].length();
          
            
        }
        for(int i =0; i < s.length;i++){
            
            gc.setFont(new Font((int)((double)1800/(30+totalLength))));//add 30 to normalize font size 
            double fontSize = (int)((double)1800/(30+totalLength));
            gc.fillText(" " + s[i], 200+i*(s.length+4)*(fontSize-10), 200);
        }
    }
    /**
     * Main function for calculating scale factors. Calculate the dist between min + max, divide by 1/2 width(or arbitrayr bouds)
     * and then 
     * @param pointArray points generated from csv
     * @param maxLen high bound of one axis(think of like how x has pos and neg, one axis would be positive side
     * so like how high the positive side goes)
     * @param minLen low bound of one axis
     * @param gc The current graphics context
     */
    public void calcAndDrawAxes(double[][] pointArray, int maxLen, int minLen,GraphicsContext gc){
        
        double[] max = new double[pointArray[2].length];
        double[] min = new double[pointArray[2].length];
        scaleFactor = new double[pointArray[2].length];
        for(int i =0; i < max.length;i++){
            max[i] = Double.MIN_VALUE;
            min[i] = Double.MAX_VALUE;
        }
        for(int i =0; i < pointArray[0].length;i++){
            for(int j = 0; j < pointArray.length;j++){
                if(pointArray[j][i]>max[i]){
                    max[i]=pointArray[j][i];
                    }
                if(pointArray[j][i]<min[i]){
                    min[i]=pointArray[j][i];
                    
                }
            }
        }
        gc.setStroke(Color.GREEN);
        gc.strokeLine(5,0,5,WIDTH);
        gc.strokeLine(0,HEIGHT/2,WIDTH,HEIGHT/2);
        Line lines;
        
        for(int i =0; i < min.length;i++){
            scaleFactor[i] = (maxLen-minLen)/(max[i]-min[i]);   
        }
        
        
    }
    /**
     * Draws axis for given scale factor
     * @param gc the current graphics context
     * @param factor the scale factor to be used for axis drawing
     */
    public void drawAxes(GraphicsContext gc,double factor){
        for(int i =0; i < 20; i++){
            gc.setFont(new Font(10));
           String formated = String.format("%.2f",(((double)1/factor)*(-HEIGHT/2+HEIGHT*((double)i/20))));//formats axis into smaller string to prevent annoying long string covering graphs
            gc.strokeText(""+ formated,20,HEIGHT-(HEIGHT*((double)i/20)));
            
             //System.out.println("Scale factor" + scaleFactor[5]);
        }
    
    }
    /**
     * Creates the pointArray from an array list of strings
     * @param points translates our ArrayList from csv into double array for easier use
     */
    public void createPoints(ArrayList<String[]> points){
        pointArrays = new double[points.size()][points.get(0).length];
        for(int i =0; i <points.size();i++){
            for(int j =0; j < points.get(i).length;j++){
                
                pointArrays[i][j] = Double.parseDouble(points.get(i)[j]);
            }
           
        }
    }
    //really poorly placed boolean , basically used to print out scale factors to console
    boolean hasPrintedScaleFactors = false;
    /**
     * Draws a line where the mouse is and gives the x and y values of any points that it intersects with, this way we can 
     * see how far appart two values really are/ what the value is at a given time
     * @param gc The graphics context 
     * @param pointList our pointlist from csv
     * @param mouseX the current mouseLocation
     */
    public void calcIntersections(GraphicsContext gc, double pointList[][], double mouseX){
        double currentScale = Integer.MAX_VALUE;
        for(int j =0; j < pointList[0].length;j++){
            if(!hasPrintedScaleFactors){
                System.out.println("scale factor " +  j + " is " + scaleFactor[j]);
                hasPrintedScaleFactors = true;
            }
            if(boxes.get(j).isSelected()){
                if(currentScale>scaleFactor[j]){
                    currentScale=scaleFactor[j];
                }
            }
        }
        drawAxes(gc,currentScale);
        int offset = 0;
        for(int i =0; i < pointList.length; i++){
            for(int j = 0; j < pointList[i].length;j++){
                if(boxes.get(j).isSelected()){
                    if(mouseX==i*timeSetpoint){
                        double pY = HEIGHT/2+(pointList[i-1][j]*currentScale);
                        
                        gc.setStroke(Color.BLUE);
                        gc.strokeLine(mouseX, 0,mouseX, WIDTH);
                        gc.setFont(new Font(20));
                        String formattedPList = String.format("%.2f",pointList[i][j]);
                         gc.strokeText(headings[j]+ " Intersect At", mouseX, HEIGHT/2+offset);
                         gc.strokeText( "MOUSE X: " + mouseX + " Y LOC: " + formattedPList,mouseX, HEIGHT/2+40+offset);
                         offset+=80;
                    }
                }
            }
        }
    }
    /**
     * Draws the graph of each element for which their checkbox is selected from a point list 
     * @param gc The current Graphics context
     * @param pointList list of points
     */
    private void drawGraph(GraphicsContext gc, double pointList[][]) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(2);
        double currentScale = Integer.MAX_VALUE;
        for(int j =0; j < pointList[0].length;j++){
            if(boxes.get(j).isSelected()){
                if(currentScale>scaleFactor[j]){
                    currentScale=scaleFactor[j];
                    
                }
            }
        }
        for(int i =1; i <pointList.length;i++){
            // System.out.println("point output " +(900-(pointList[i-1][1]*scaleFactor[1])));
            for(int j =0; j < pointList[i].length;j++){
                if(boxes.get(j).isSelected()){
                    gc.strokeLine(timeSetpoint*i - 1,HEIGHT/2+(pointList[i-1][j]*currentScale),i*timeSetpoint,HEIGHT/2+(pointList[i][j]*currentScale));                          
                }
            }
        }
    }
    public void addBackButton(Stage primaryStage, Group currentGroup){
        Button toHome = new Button("Home");
        currentGroup.getChildren().add(toHome);
        toHome.relocate(WIDTH-100, HEIGHT-100);
        EventHandler<ActionEvent> homeButtonPressed = (ActionEvent homeButtonEvent)->{
            start(primaryStage);
        };
        toHome.addEventHandler(ActionEvent.ANY,homeButtonPressed);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String... args) {
        launch(args);
    }
    
}

