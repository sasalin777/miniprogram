import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class guessletter {




    public static <ArrayyList> void main(String[] args) throws IOException {

        try {
            final String file="src/cities.txt";



            //public static String getRandomLineFromTheFile(File file )  {
            /**
             * read txt and random pick up a city
             */

            final RandomAccessFile f = new RandomAccessFile(file, "r");
            final long randomLocation = (long) (Math.random() * f.length());
            f.seek(randomLocation);
            f.readLine();
            String resultcity=f.readLine();
            System.out.print(resultcity);
            System.out.print("\n");
            /**
             * string convert to string array string
             */
            ArrayList<String> disPlaywrongletter=new ArrayList();
            String stringArray=resultcity;
            String[] newArray =stringArray.split("(?!^)");
            //System.out.println(Arrays.toString(newArray));

            //System.out.println(newArray[2]);//check 2nd letter of city
            int l=newArray.length;//city letter length
            //System.out.printf("newArray length: %d\n",l);
            //System.out.println("=============================================\n\n");
            int counttimes=0;
            int counttimes2=0;
            int checkWrong=0;
            String[] newArray2=new String[newArray.length];


            System.out.println("Here is a question.");//Start guessing game
            for (int i = 0; i <= l - 1; i++) {

                String s = "_";

                newArray2[i]=s;
                System.out.print(newArray2[i]);

            }

            System.out.print("\n");
            Scanner scanner = new Scanner(System.in);
            //System.out.print("Guess a letter of City:");

            //  String strGuess = scanner.nextLine();//for using input

            while (counttimes<=10) {

                List<String> rets = Arrays.asList(newArray);//array convert to string
                List<String> rets2 = Arrays.asList(newArray2);//array convert to string
                if ((rets.equals(rets2)))  { //compare
                    System.out.println("You Win!");
                    System.out.printf("You have guessed '%s' correctly.",resultcity);
                    break;}

                System.out.print("\nGuess a letter of City:");
                String strGuess = scanner.nextLine();//for using input
                System.out.printf("You are guessing:%s\n", strGuess);
                counttimes2=0;
                checkWrong=0;

                for (int j = 0; j <= l - 1; j++) {

                    //  String arrayString = Arrays.toString(newArray);
                    String abc = newArray[j];
                    if (abc.equalsIgnoreCase(strGuess)) {
                        newArray2[j] = newArray[j];
                        counttimes2 -= 1;
                    } else {checkWrong+=1;}
                    if (counttimes2<=-1) {
                        counttimes2 = -1;
                    }
                        else{counttimes2=0;}

                    if (  checkWrong == l) { disPlaywrongletter.add(strGuess);}

                }






                counttimes=counttimes+counttimes2+1;
                if (counttimes<0) { counttimes=0;}
                else {counttimes=counttimes;}
                for (int k = 0; k <= l - 1; k++) {

                    System.out.print(newArray2[k]);
                }


                String SdisPlaywrongletter=String.join(",",disPlaywrongletter);
                System.out.printf("\nYou have guessed(%,d) wrong letters:%s\n", counttimes,SdisPlaywrongletter);

                if ((counttimes == 10) & !((rets.equals(rets2)))) {
                    System.out.printf("You lost! You guessed (10) wrong letter:%s",SdisPlaywrongletter);
                    System.out.printf("\nThe correct word was '%s'!", resultcity);


                    break;}





            }



        }
        catch (FileNotFoundException e)
        { System.out.println("File missing! Please check the file path.");}


    }


}
