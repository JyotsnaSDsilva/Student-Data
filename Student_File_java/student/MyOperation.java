package student;

import java.io.FileNotFoundException;
import java.io.IOException;


public interface MyOperation { // this is an interface class which includes all the abstract methods
 
    public abstract void enter() throws IOException; // Enters the content to the file
   
    public abstract void search() throws IOException, FileNotFoundException; // Searches the given content in the file
   
    public abstract void display() throws IOException; // displays the content of the file
  }