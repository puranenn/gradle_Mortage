package gradle_Mortage;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author nikol
 */
public class Person {
  DecimalFormat dfZero = new DecimalFormat("0.00");
  String name;
  double Total_Loan;
  double Interest;
  int Year;
  ArrayList < String > names = new ArrayList < > ();

  public Person(String name, double Total_Loan, double Interest, int Year) {
    this.name = name.replace("\"", "");
    this.Total_Loan = Total_Loan;
    this.Interest = Interest;
    this.Year = Year;
  }
  //setters
  void set_Namess(String namee) {
    this.name = namee.replace("\"", "");
  }
  void set_Total_Loan(String namee) {
    this.Total_Loan = Double.parseDouble(namee);
  }
  void set_Interest(String namee) {
    this.Interest = Double.parseDouble(namee);
  }
  void set_Year(String namee) {
    this.Year = Integer.parseInt(namee);
  }
  //getters
  public String getNames() {
    return name;
  }
  public double getTotal_Loan() {
    return Total_Loan;
  }
  public double getInterest() {
    return Interest / 100;
  }
  public double getYear() {
    return Year * 12;
  }
//calculate monthly cost
  public String math() {
    double a = (Interest / 100) / 12;
    double b = Year * 12;
    double test = Total_Loan * (a * power(1 + a, b)) / (power(1 + a, b) - 1);
    return dfZero.format(test);
  };
//power function
  public double power(double a, double b) {
    double result = 1;
    for (b = b; b != 0; b--) {
      result = result * a;
    }
    return result;
  }
}