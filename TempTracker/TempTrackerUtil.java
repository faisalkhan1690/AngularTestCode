import java.io.*; 
import java.util.*; 

/*
 *TempTracker class is to achive the given functionality 
 *insert() - records a new temperature
 *get_max() - returns the highest temp we've seen so far 
 *get_min() - returns the lowest temp we've seen so far
 *get_mean() - returns the mean of all temps we've seen so far
 *get_mode() - returns a mode of all temps we've seen so far
 *
 *Favour speeding up the getter methods get_max(), get_min(), get_mean(), and get_mode() over speeding up the insert() method.
 *get_mean() should return a float, but the rest of the getter methods can return integers. Temperatures will all be inserted as integers and we can assume they will be in the range 0 ℃ to 150 ℃.
 *If there is more than one mode, return any of the modes.
 *
 *@author Faisal Khan
 */
class TempTracker { 
    
    private final int NO_DATA=-1;
    private List<Integer> mListTemperatures;
    
    TempTracker(){
        mListTemperatures=new ArrayList();
    }
    
  
    /*
     * To insert temperature
     * @temperature temperature to insert 
     * @return int -1 if fails lese 0
     */
    public int insert(int temperature) {
        
        if(temperature<0 || temperature>150){
            return -1;
        }
        mListTemperatures.add(new Integer(temperature));
        System.out.print("All Temperatures Are :- ");
        for(int i=0;i<mListTemperatures.size();i++){
        	System.out.print(" "+mListTemperatures.get(i));
        }
        System.out.println("");
        return 0;
       
    } 
    
    /*
     * To get max  temperature
     * @retunr max temperature in integer
     */
    public int get_max() {
        
        if(mListTemperatures.size()==0){
            return NO_DATA;
        }
        
        if(mListTemperatures.size()==1){
            return  mListTemperatures.get(0);
        }
        Collections.sort(mListTemperatures);
        return  mListTemperatures.get(mListTemperatures.size()-1);
       
    } 
    
    /*
     * To get min  temperature
     * @retunr min temperature in integer
     */
    public int get_min() {
        
        if(mListTemperatures.size()==0){
            return NO_DATA;
        }
        
        if(mListTemperatures.size()==1){
            return  mListTemperatures.get(0);
        }
        Collections.sort(mListTemperatures);
        return  mListTemperatures.get(0);
       
    } 
    
     /*
     * To get mean  temperature
     * @retunr mean temperature in float
     */
    public float get_mean() {
        
        if(mListTemperatures.size()==0){
            return NO_DATA;
        }
        
        if(mListTemperatures.size()==1){
            return  mListTemperatures.get(0);
        }
        
        float sumOftemperatures=0.0f;
        
        for(int i=0;i<mListTemperatures.size();i++){
            sumOftemperatures=sumOftemperatures+mListTemperatures.get(i);
        }
        
        return  sumOftemperatures/mListTemperatures.size();
       
    } 
    
     /*
     * To get temperature that is entered by user highest time
     * @return mode temperature in integer
     */
    public int get_mode() {
        
        int modeTemperature=0;
        int count=0;
        int modeTemp=0;
        int countTemp=0;
        
        if(mListTemperatures.size()==0){
            return NO_DATA;
        }
        
        if(mListTemperatures.size()==1){
            return  mListTemperatures.get(0);
        }
        Collections.sort(mListTemperatures);
        
        modeTemp=mListTemperatures.get(0);
        modeTemperature=modeTemp;
        count=1;
        countTemp=1;
        
        for(int i=1;i<mListTemperatures.size();i++){
            if(modeTemp==mListTemperatures.get(i)){
                countTemp++;
                if(mListTemperatures.size()-1==i){
                    count=countTemp;
                    modeTemperature=modeTemp;
                }
            }else if(countTemp>count){
                count=countTemp;
                modeTemperature=modeTemp;
            }else{
                modeTemp=mListTemperatures.get(i);
                countTemp=1;
            }
            
        }
        
        return modeTemperature;
       
    } 
    
    
    
}

/*
 * Main class to create and use of tracker class object
 *
 */
public class TempTrackerUtil{
    
    private static final int NO_DATA=-1;
    
    
    public static void main(String args[]){
        TempTracker object=new TempTracker();
        Scanner sc = new Scanner(System.in);
        
         while(true){
         
        	 System.out.println("");
        	 System.out.println("------------------------------------");
             System.out.println("Enter A to insert Temperature");
             System.out.println("Enter B to get Max Temperature");
             System.out.println("Enter C to get Min Temperature");
             System.out.println("Enter D to get Mean Temperature");
             System.out.println("Enter E to get Mode Temperature");
             System.out.println("Enter Q to Quit");
             
             String option=sc.nextLine();
             boolean isQuit=false;
             
             switch(option){
                case "A":
                case "a":
                    System.out.println("Enter Temperature"); 
                    String temp=sc.nextLine();
                    try{
                        int insertData=object.insert(Integer.parseInt(temp));
                        if(insertData==NO_DATA){
                            System.out.println("temperature should be between  0 ℃ to 150 ℃.");
                        } 
                    }catch(Exception e){
                        System.out.println("Please enter a valid number");
                    }
                   
                    break;
                    
                case "B":
                case "b":
                    //get max temperature
                    int maxTemp=object.get_max();
                    if(maxTemp==NO_DATA){
                        System.out.println("There is not temperature recored available"); 
                    }else{
                        System.out.println("Max temperature is = "+maxTemp);    
                    }
                    break;
                    
                case "C":
                case "c":
                     //get min temperature
                    int minTemp=object.get_min();
                    if(minTemp==NO_DATA){
                        System.out.println("There is not temperature recored available"); 
                    }else{
                        System.out.println("Min temperature is = "+minTemp);    
                    }
                    break;
                    
                case "D":
                case "d":
                      //get mean temperature
                    float meanTemp=object.get_mean();
                    if(meanTemp==NO_DATA){
                        System.out.println("There is not temperature recored available"); 
                    }else{
                        System.out.println("Mean temperature is = "+meanTemp);    
                    }
                    break;
                
                case "E":
                case "e":
                   //get mean temperature
                    int modeTemp=object.get_mode();
                    if(modeTemp==NO_DATA){
                        System.out.println("There is not temperature recored available"); 
                    }else{
                        System.out.println("Mode temperature is = "+modeTemp);    
                    }
                    break;
                    
                case "Q":
                case "q":
                    isQuit=true;
                    break;
                    
                default:
                    System.out.println("Enter wrong option Please try again"); 
                    
             }
             
             if(isQuit){
                 break;
             }
             
         }
        
        
    }
}