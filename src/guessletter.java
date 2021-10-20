import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class guessletter {




    public static void main(String[] args) throws IOException {

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
            //System.out.print(resultcity);
            /**
             * string convert to string array string
             */

            String stringArray=resultcity;
            String[] newArray =stringArray.split("(?!^)");
            //System.out.println(Arrays.toString(newArray));

            //System.out.println(newArray[2]);//check 2nd letter of city
            int l=newArray.length;//city letter length
            //System.out.printf("newArray length: %d\n",l);
            //System.out.println("=============================================\n\n");
            int counttimes=0;
            int counttimes2=0;
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

                for (int j = 0; j <= l - 1; j++) {
                    //  String arrayString = Arrays.toString(newArray);
                    String abc = newArray[j];
                    if (abc.equalsIgnoreCase(strGuess)) {
                        newArray2[j] = newArray[j];
                        counttimes2 -= 1;



                    }
                    if (counttimes2<=-1) {
                        counttimes2 = -1;
                    }
                        else{counttimes2=0;}


                }





                counttimes=counttimes+counttimes2+1;
                if (counttimes<0) { counttimes=0;}
                else {counttimes=counttimes;}
                for (int k = 0; k <= l - 1; k++) {

                    System.out.print(newArray2[k]);
                }



                System.out.printf("\nYou have guessed(%d) wrong letters:\n", counttimes);

                if ((counttimes == 10) & !((rets.equals(rets2)))) {
                    System.out.println("You lost! You guessed (10) wrong letter:xxxxxxxxxx");
                    System.out.printf("The correct word was '%s'!", resultcity);


                    break;}





            }



        }
        catch (FileNotFoundException e)
        { System.out.println("File missing! Please check the file path.");}


    }


}
