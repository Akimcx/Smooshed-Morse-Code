import java.util.Scanner;
import java.io.*;

class SmooshedMorseCode1{

    static Scanner keyb = new Scanner(System.in);
    static String [] alphabetInMorse = { ".-", "-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
};        
    static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String args[]) throws Exception{

        System.out.print("Message to be encoded: "); 
        String plainTextMessage = keyb.nextLine().trim(); 
        
       
        System.out.println("Encryption process...");
        String encodedMessage = encode(plainTextMessage);

        System.out.println("Encryption done, here's the result: " + encodedMessage);
        
       
        optionalBonusChallenges();
        keyb.close();
    }

    private static void optionalBonusChallenges() throws Exception{
        
        File wordList = new File("./enable1.txt");
        BufferedReader br = new BufferedReader(new FileReader(wordList));
        
        String line;
        while( (line = br.readLine()) != null  ){
            String pattern = encode(line);
            bonus2(pattern, line);
            if(line.length() == 21){
                bonus3(pattern, line);
            }
        }
    }
    
    //Find the only word that has 15 dashes in a row
    private static void bonus2(String pattern, String line) {

        String regex = ".*-{15}.*";
        if(pattern.matches(regex)){
            System.out.println("Only Word with 15 dashes in a row: " + line);
        }
    }

    //Find the other 21-letter word that's perfectly balanced
    private static void bonus3(String pattern, String line){
        
        if(isPerfectlyBalanced(pattern)){
            System.out.println(line + " is a 21-letter word that's perfectly balanced");
        }
    }

    private static String encode(String plainTextMessage){

        String encodedMessage = "";
        for(int i = 0; i < plainTextMessage.length(); i++){
            int pos = alphabet.indexOf(plainTextMessage.charAt(i));
            encodedMessage += alphabetInMorse[pos];
        }
        return encodedMessage;
    }

    private static boolean isPerfectlyBalanced(String pattern){
       int dotCount = 0, dashCount = 0;

       for(int i = 0; i < pattern.length(); i++){
           if(pattern.charAt(i) == '.'){
               dotCount++;
           }else{
               dashCount++;
           }
       } 
       return dashCount == dotCount;
    }
}
