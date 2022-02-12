
package gradle_Mortage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class App {
  public static void main(String[] args) throws FileNotFoundException, IOException {
    //temp var
    String a = "";
    ArrayList < String > fileLines = new ArrayList < > ();
    //regex
    String otherThanQuote = " [^\"] ";
    String quotedString = String.format(" \" %s* \" ", otherThanQuote);
    String regex = String.format("(?x) " + // enable comments, ignore white spaces
      ",                         " + // match a comma
      "(?=                       " + // start positive look ahead
      "  (?:                     " + //   start non-capturing group 1
      "    %s*                   " + //     match 'otherThanQuote' zero or more times
      "    %s                    " + //     match 'quotedString'
      "  )*                      " + //   end group 1 and repeat it zero or more times
      "  %s*                     " + //   match 'otherThanQuote'
      "  $                       " + // match the end of the string
      ")                         ", // stop positive look ahead
      otherThanQuote, quotedString, otherThanQuote);
    //regex end
    //read file path here ->
    File resourceFile = new File("../prospects.txt");
    BufferedReader reader = new BufferedReader(new FileReader(resourceFile));
    reader.readLine(); // this will read the first line eg skip the ""headers""
    String line1 = null;
    while ((line1 = reader.readLine()) != null) { //loop will run from 2nd line
      //create new person instance
      Person p = new Person(a, 1, 2, 3);
      String[] tokens = line1.split(regex, -1);
      fileLines.add(line1);
      //set values to class->
      p.set_Namess(tokens[0]);
      p.set_Total_Loan(tokens[1]);
      p.set_Interest(tokens[2]);
      p.set_Year(tokens[3]);
      //print results
      System.out.println(p.getNames()+" "+p.getTotal_Loan()+" Euros Loan ");
      System.out.println(p.math()+" Euro per month");
    }
  }
}
