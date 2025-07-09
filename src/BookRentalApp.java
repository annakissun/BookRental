import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class BookRentalApp {
    
    public static void main (String args [] ) {

        try {

            BufferedReader in = new BufferedReader(new FileReader("book.txt"));
            PrintWriter outBookFiction = new PrintWriter(new BufferedWriter(new FileWriter("bookDetails.txt")));
            
            outBookFiction.println("======================================================================================================================================");
            outBookFiction.println(String.format("%-45s %-25s %-45s %-25s","FULL TITLE","ISBN","AUTHOR","PRICE PER DAY"));
            outBookFiction.println("======================================================================================================================================");

            String inData;
            while ((inData = in.readLine()) != null) {
                String[] data = inData.split(";");

                String fullTitle = data[0];
                String fullISBN = data[1];
                String fullAuthor = data[2];
                Double pricePerDay = Double.parseDouble(data[3]);

                outBookFiction.println(String.format("%-45s %-25s %-45s RM%-25s", fullTitle, fullISBN, fullAuthor, pricePerDay));
            }
            
            in.close();
            outBookFiction.close();

            BufferedReader showOutput = new BufferedReader(new FileReader("bookDetails.txt")); 
            String line;
            System.out.println("======================================================================================================================================");
            System.out.println(String.format("%75s","=== BOOK DETAILS ==="));
            while ((line = showOutput.readLine()) != null) {
                System.out.println(line);
            }
            showOutput.close();
            
        }
        catch(FileNotFoundException fe) {
            System.out.println(fe.getMessage());
        }

        catch(IOException iox) {
            System.out.println(iox.getMessage());
        }

        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        Scanner input = new Scanner (System.in);
        Scanner input2 = new Scanner (System.in);
        
        Book [] bk = new Book[2];

        for (int i = 0 ; i < 2 ; i++) {

            String fictionNfiction = "";
            String genreId = "";
            String subject = "";
            
            //Student discount for non fiction
            String studentDiscount = ""; 

            System.out.print ("\n");
            
            while (!fictionNfiction.equals("0") && !fictionNfiction.equals("1")) {

                System.out.print ("Enter fiction or non fiction [0/1] : ");
                fictionNfiction = input2.nextLine();

                if (!fictionNfiction.equals("0") && !fictionNfiction.equals("1")) {
                    System.out.println("Please enter only 0 or 1");
                }
            }
           
            System.out.print ("\n");
            System.out.print ("Enter book title id : ");
            String title = input2.nextLine();
            System.out.print ("\n");

            System.out.print ("Enter name of customer : ");
            String name = input2.nextLine();
            System.out.print ("\n");

            System.out.print ("Enter customer contact number : ");
            String contactNo = input2.nextLine();
            System.out.print ("\n");

            System.out.print ("Enter customer id : ");
            String identification = input2.nextLine();
            System.out.print ("\n");

            System.out.print ("Enter day of renting : ");
            int dayOfRenting = input.nextInt();
            System.out.print ("\n");

            if (fictionNfiction.equalsIgnoreCase("0")) {
                System.out.print ("Enter book genre id [H/F/R]: ");
                    genreId = input2.nextLine();
 
            }
            else if (fictionNfiction.equalsIgnoreCase("1")) {
                System.out.print ("Enter book subject id [PHY/BM]: ");
                    subject = input2.nextLine();
                    
                while (!studentDiscount.equalsIgnoreCase("Y") && !studentDiscount.equalsIgnoreCase("N")) {
                    System.out.print("Are you a student? [Y/N]: ");
                    studentDiscount = input2.nextLine().trim();

                    if (!studentDiscount.equalsIgnoreCase("Y") && !studentDiscount.equalsIgnoreCase("N")) {
                        System.out.println("Please enter Y or N only.");
                    }   
                }               

            }
            
            if (fictionNfiction.equalsIgnoreCase("0")) {
                bk[i] = new Fiction (title, genreId, new Customer(name, contactNo, identification, dayOfRenting));
            }
            else if (fictionNfiction.equalsIgnoreCase("1")) {
                bk[i] = new NonFiction (title, studentDiscount, subject, new Customer(name, contactNo, identification, dayOfRenting));
            }

            System.out.println("===========================================================================================================================================");
            System.out.println(String.format("%75s","=== CUSTOMER INFO ==="));
            System.out.println("===========================================================================================================================================");

            System.out.println(bk[i]. getCustomer());
            System.out.println("===========================================================================================================================================");
            System.out.println(String.format("%65s","=== RECEIPT ==="));
            System.out.println("===========================================================================================================================================");

            System.out.println(bk[i]);
            System.out.println("Final Total: RM" + bk[i].calcFinalTotal());
            
        }
    }
}
