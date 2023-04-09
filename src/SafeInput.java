/**
 *
 * @author willn
 */
import java.util.Scanner;
public class SafeInput {

    /**
     * @param pipe a Scanner opened to read from System.i
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString (Scanner pipe, String Prompt){
        String retString = "";
        do {
            System.out.print("\n" +Prompt+ ":");
            retString = pipe.nextLine();

        }
        while (retString.length()==0);
        return retString;
    }
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String result = "";
        boolean done = false;
        do
        {
            System.out.print(prompt + ": ");
            result = pipe.nextLine();
            if(result.matches(regEx))
                done = true;
            else
                System.out.println("\nMust match the pattern"+ result);


        }
        while(!done);
        return result;
    }
    public static int getRangedInt(Scanner pipe, String Prompt, int low, int high) {
        int retInt = 0;
        do {
            System.out.print("\n" +Prompt+ ":");
            retInt =pipe.nextInt();
        }
        while (retInt <=low -1 || retInt>= high +1);
        return retInt;
    }

    public static double getRangedDouble(Scanner pipe, String Prompt, double low, double high){
        double retDouble = 0;
        do{
            System.out.print("\n" +Prompt+ ":");
            retDouble = pipe.nextDouble();
        }
        while(retDouble <=low || retDouble >=high);
        return retDouble;
    }

    public static boolean getYNConfirm(Scanner pipe, String Prompt){
        String retBoolean = "";
        do{
            System.out.print("\n" +Prompt+ ":");
            retBoolean = pipe.next();
        }
        while(retBoolean.length()==0);
        if (retBoolean.equalsIgnoreCase("y"))
            return true;
        else if (retBoolean.equalsIgnoreCase("n"))
            return false;
        return false;
    }

    public static void prettyHeader(String msg){
        int limit = 60;
        int msgLen = msg.length();
        int diff = 60 - msgLen;
        int mid = diff / 2;
        char[]msgArr = msg.toCharArray();
        while (limit>0){
            for(int i = 0; i<mid;i++)
                System.out.print("*");
            limit --;
            for (char c:msgArr){
                System.out.print(c);
                limit--;
                while (limit>0){
                    System.out.print("*");
                    limit --;
                }
            }
        }
    }
}