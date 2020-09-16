import java.io.*;
import java.util.*;

public class Main {
    long amOfCombinations;
    long sum;
    Long[] cashData;

    public void exchangeWays(long sum, Long[] currentCombination, int recLevel) {
        if (recLevel == 0) {
            if (sum % this.cashData[0] == 0) {
                this.amOfCombinations++;
                currentCombination[0] = sum / this.cashData[0];
                for (int i = 0; i < cashData.length; i++) {
                    System.out.print(currentCombination[i] + " of " + this.cashData[i] + " bills; ");
                }
                System.out.println('\n');
            }
        } else {
            long diffCoeff = sum / this.cashData[recLevel];
            currentCombination[recLevel] = diffCoeff;
            for (long i = currentCombination[recLevel]; i >= 0; i--) {
                //  System.out.println("Sum = "+sum);
                currentCombination[recLevel] = i;
                this.exchangeWays((sum - i * this.cashData[recLevel]), currentCombination, recLevel - 1);

            }
        }
    }

    public static void main(String[] args) {
        SortedSet<Long> cashData = new TreeSet<>();
        long sum;
        Main mainFunc = new Main();
        try {
            FileReader fin = new FileReader("D:\\учеба\\third year\\JavaTech\\src\\input.txt");
            Scanner scan = new Scanner(fin);

            String newElem = scan.nextLine();


            if (newElem.matches("\\d")) {
                mainFunc.sum = Long.parseLong(newElem);
                sum = mainFunc.sum;
                //   System.out.println("Sum = "+mainFunc.sum);

                while (scan.hasNextLine()) {
                    newElem = scan.nextLine();
                    if (newElem.matches("\\d+")) {
                        long cashValue = Long.parseLong(newElem);
                        if (cashValue <= sum && cashValue > 0) cashData.add(cashValue);
                    } else {
                        System.out.println("Wrong input string " + newElem);
                    }

                }
            } else {
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
        if (cashData.isEmpty())
            System.out.println("There are 0 ways to exchange a given sum");
        else {

            mainFunc.cashData = cashData.toArray(new Long[0]);
            mainFunc.amOfCombinations = 0;
            Long[] currentCombination = new Long[cashData.size()];
            for (int i = 0; i < cashData.size(); i++) {
                currentCombination[i] = (long) 0;
            }
            //mainFunc.sum = Long.MAX_VALUE;
            mainFunc.exchangeWays(mainFunc.sum, currentCombination, cashData.size() - 1);
            System.out.println("Finally, there are  " + mainFunc.amOfCombinations + " ways to exchange a given sum");
        }
    }
}
