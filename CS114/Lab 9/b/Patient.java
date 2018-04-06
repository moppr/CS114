package b;

//*******************************************************************
//  Patient.java        
//*******************************************************************

public class Patient implements Comparable<Patient>
{
   private int id;
   private String name;
   private String emergencyCase;

   //----------------------------------------------------------------
   //  Creates a customer with the specified id number.
   //----------------------------------------------------------------
   public Patient (int number, String custName,String er )
   {
      id = number;
      name = custName;
      emergencyCase = er;
   }

   //----------------------------------------------------------------
   //  Returns a string description of this customer.
   //----------------------------------------------------------------
   public String toString()
   {
      return "Patient priority id:  " + id+" \tPatient name: "+name+" \tSymptom: "+emergencyCase; //wow almost like adding tabs made this readable
   }
   
   public String getName()
   {
    return name;
   }
   
   public int getId()
   {
     return id;
   }
   
   public String getCase()
   {
    return emergencyCase;
   }

@Override
public int compareTo(Patient o){
	// TODO Auto-generated method stub
	return this.id - o.id;
}

}
