import java.io.*; 
import java.util.*; 

/*
 *AnagramCheck class is to check that checks if two words are anagrams.
 *
 *@author Faisal Khan
 */
public class AnagramCheck { 
  
    static int NO_OF_CHARS = 256; 
  
    /*
     * is_anagram is to check that checks if two words are anagrams.
     * 
     * @return true if yes else false 
     */
    static boolean is_anagram(char str1[], char str2[]) { 
        
        //fill defauilt array with zeros
        int count1[] = new int[NO_OF_CHARS]; 
        Arrays.fill(count1, 0); 
        int count2[] = new int[NO_OF_CHARS]; 
        Arrays.fill(count2, 0); 

        // if length is not equal then return false
        if (str1.length != str2.length) 
            return false; 
        
        for (int i = 0; i < str1.length ;i++) { 
            count1[str1[i]]++; 
            count2[str2[i]]++; 
        } 
  
        // return false any character is not common 
        for (int i = 0; i < NO_OF_CHARS; i++){
            if (count1[i] != count2[i]) 
                return false; 
        }
            
  
        return true; 
    } 
  


	//program start from here 
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        
        while(true){
        
            System.out.println("Enter First String"); 
            String firstString = sc.nextLine();
            System.out.println("Enter Second String"); 
            String secondString = sc.nextLine();
      
            if (is_anagram(firstString.toCharArray(), secondString.toCharArray())) 
                System.out.println("Strings are anagrams"); 
            else
                System.out.println("Strings are not anagrams"); 
            
            System.out.println("Press 0 to try again or any key to Quit ");
            String continueCheck = sc.nextLine();
            if(!continueCheck.equalsIgnoreCase("0")){
                break;
            }
            
        }
       
    } 
}