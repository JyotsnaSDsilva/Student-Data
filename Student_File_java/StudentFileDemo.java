
import java.io.*;
import java.util.Scanner;
import java.lang.String;
import java.io.IOException;
import student.*;

public class StudentFileDemo { // main class

   public static void main(String args[]) throws IOException {
      FileWriter out = null;
      Scanner sc = new Scanner(System.in);
      try {

         StudentObjects ob = new StudentObjects();
         do {

            System.out.println();
            System.out.println("  1) Enter Student Details.");
            System.out.println("  2) Search for Student.");
            System.out.println("  3) Display file content.");
            System.out.println("  4) Quit. \n\n Enter your choice : ");
            System.out.println();
            
            int ch = sc.nextInt();
            sc.nextLine();
               // int ch = sc.nextInt();

               switch (ch) {
                  case 1:
                     ob.mo.enter(); // Enters the content to the file
                     break;

                  case 2:
                     ob.mo.search(); // Searches the given content in the file
                     break;

                  case 3:
                     ob.mo.display(); // displays the content of the file
                     break;

                  default:
                     return;
               }
         } while (true);
      } finally {

         if (out != null) {
            out.close();
         }
         sc.close();
      }
   }
}

class StudentObjects { // this class is for all the object creation of implementation classes
   MyOperation mo = new StudentApplication();
}
