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
        
        File wordList = new File("./enable1.txt");
        BufferedReader br = new BufferedReader(new FileReader(wordList));
       
        bonus2(br);
        keyb.close();
    }
    
    //Find the only word that has 15 dashes in a row
    private static void bonus2(BufferedReader br) throws Exception{

        String regex = ".*-{15}.*";
        String line;
        while( (line = br.readLine()) != null  ){
            String pattern = encode(line);
            if(pattern.matches(regex)){
                System.out.println("Only Word with 15 dashes in a row: " + line);
                System.out.println();
            }
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
