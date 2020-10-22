package student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class StudentApplication implements MyOperation { // this is an implementation class  from myOperation
                                                         

   public void enter() {
      FileWriter out = null;

      try {
         out = new FileWriter("output.txt", true);
         Scanner inp = new Scanner(System.in);
         PrintWriter pw = new PrintWriter(out);

         File file = new File("output.txt");
         FileReader fr = new FileReader(file);
         BufferedReader br = new BufferedReader(fr);

         String[] wordsr = null;
         String stri;

         System.out.println("enter STUDENT ID : ");
         String reg = inp.nextLine();
         if (!reg.matches("[0-9]+")) {  //validation
            System.out.println("Invalid ID");
            return;
         }

         if (reg.matches("[0-9]+")) {
            while ((stri = br.readLine()) != null) // Reading Content from the file
            {
               wordsr = stri.split(" "); // Split the word using space
               for (String word : wordsr) {
                  if (word.equals(reg)) // Search for the given word
                  {
                     System.out.println("Invalid ID");
                     return;
                  }
               }
            }
         }
         System.out.println("Enter Student First Name : ");
         String name = inp.nextLine();
         if (!name.matches("[a-zA-Z_]+")) {//validation
            System.out.println("Invalid Name");
            return;
         }

         System.out.println("Enter Student Last Name : ");
         String lastname = inp.nextLine();
         if (!name.matches("[a-zA-Z_]+")) {//validation
            System.out.println("Invalid Name");
            return;
         }

         System.out.println("enter student COURSE : ");
         String sub = inp.nextLine();

         if (!sub.matches("[a-zA-Z_]+")) {//validation
            System.out.println("Invalid Input. ");
            return;
         }
         System.out.println("enter student SUBJECT PREFERENCE : ");
         String pre = inp.nextLine();

         if (!pre.matches("[a-zA-Z_ ]+")) {//validation
            System.out.println("Invalid Input.");
            return;
         }
         //enter the values to the file
         pw.println("Student ID                 : " + reg);
         pw.println("Student name               : " + name + " " + lastname);
         pw.println("Student course             : " + sub);
         pw.println("Student Subject Preference : " + pre);
         pw.println();
         System.out.println("\n Details added to the file : output.txt \n");
         System.out.println();

         pw.close();
         inp.close();
         br.close();

      } catch (IOException e) {
         System.out.println("file not found");
      }
   }

   public void search() throws IOException { // this method searches for the given id
      File file = new File("output.txt");
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      Scanner inp = new Scanner(System.in);

      try {

         String[] words = null;
         String str;
         int flag = 1;
         System.out.println("enter student ID : ");
         String id = inp.nextLine();

         if (!id.matches("[0-9]+")) {
            System.out.println("Invalid number");
            return;
         }

         while ((str = br.readLine()) != null) // Reading Content from the file
         {
            words = str.split(" "); // Split the word using space
            for (String word : words) {
               if (word.equals(id)) // Search for the given word
               {
                  System.out.println();
                  System.out.println("--------------------------------------------------------------");
                  System.out.println("Student Details");
                  System.out.println("--------------------------------------------------------------");
                  System.out.println("Student ID :" + word);
                  String next = br.readLine(); // reads the next available line in the file
                  System.out.println(next);
                  String nextline = br.readLine();
                  System.out.println(nextline);
                  String last = br.readLine();
                  System.out.println(last);
                  System.out.println("---------------------------------------------------------------");
                  System.out.println();
                  return;
               } else {
                  flag = 0;
               }
            }
         }
         if (flag == 0) {
            System.out.println();
            System.out.println("Student ID not found");
            System.out.println();
         }
      } catch (IOException e) { // handling of the exceptions takes place in this block
         System.out.println("Error Reading the file");
      } finally {

         if (fr != null) {
            fr.close();
         }
         if (br != null) {
            br.close();
         }
         inp.close();
      }
   }

   public void display() { // This method displays the content of the file 'output.txt'
      String line = null;
      try {
         File file = new File("output.txt");
         FileReader fr = new FileReader(file);
         BufferedReader br = new BufferedReader(fr);
         System.out.println();
         System.out.println("--------------------------------------------------------------");
         System.out.println("Student Details");
         System.out.println("--------------------------------------------------------------");
         while ((line = br.readLine()) != null) // Reading Content from the file line by line
         {
            System.out.println(line); // displays the file content line by line
         }
         System.out.println("---------------------------------------------------------------");
         br.close(); // closes the bufferReader
      } catch (IOException e) {
         System.out.println("Error reading the file");
      }
   }
}