import java.io.*;
import java.util.*;

public class Main {
      public static void main(String[] args) throws Exception {
          SortedSet<Long> cashData = new TreeSet<Long>();
          long sum;
        try {
            FileReader fin = new FileReader( "D:\\учеба\\third year\\JavaTech\\src\\input.txt");
            Scanner scan = new Scanner(fin);
          
            String newElem = scan.nextLine();


            if(newElem.matches("\\d+")){
               sum=Long.parseLong(newElem);
               System.out.println("Sum = "+sum);
               while (scan.hasNextLine()){
                    newElem = scan.nextLine();
                    if(newElem.matches("\\d+")){
                        long cashValue = Long.parseLong(newElem);
                        if(cashValue<=sum) cashData.add(cashValue);
                    }else {
                        System.out.println("Wrong input string "+newElem);
                    }

                }
            }else {
                System.out.println("Wrong input format for the Sum");
            }


            fin.close();
           /* if(cashData.isEmpty()){
                System.out.println("All data in the file is wrong");
            }else{
                System.out.println("Cash Set = "+cashData);
            }*/
         } catch (IOException e) {
            e.printStackTrace();
        }
         if(cashData.isEmpty())
             System.out.println("There are 0 ways to change a given sum");
         else{
             
         }
    }
}
