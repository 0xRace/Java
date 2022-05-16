//********************************************************************
//  Commission.java  
//
//  Represents an hourly employee who also gets commission
//********************************************************************
public class Commission extends Hourly
{
    private double sales, crate;
   
   
   //-----------------------------------------------------------------
   // Constructor
   // Need commission rate as well as other hourly employee info
   //-----------------------------------------------------------------
    public Commission(String eName, String eAddress, String ePhone, String socSecNumber, double rate,double c)
    {
     super (eName, eAddress, ePhone, socSecNumber, rate);
     crate=c;
     sales=0.0;
    } 

   //-----------------------------------------------------------------
   // addSales method
   // Add to amount of sales for this employee
   //-----------------------------------------------------------------
   public void addSales (double totalSales)
   {
       sales=sales+totalSales;
   }
   

   //-----------------------------------------------------------------
   // pay method
   // Include commission in pay
   //-----------------------------------------------------------------
   public double pay()
   {
      double payment = super.pay() + crate*sales;
      sales=0.0;
      return payment;
   }
   
   //-----------------------------------------------------------------
   // toString method
   // Return total sales as part of string representation
   //-----------------------------------------------------------------
   public String toString()
   {
       return super.toString() + "\nTotal Sales: "+ sales; 
   }
   
   
   
}
