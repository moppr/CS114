package a;

public class StaffMember
{
   protected String name;
   protected String address;
   protected String phone;
   protected String ssn;
   protected Double Rate;

   //-----------------------------------------------------------------
   //  Constructor: Sets up this staff member using the specified
   //  information.
   //-----------------------------------------------------------------
   public StaffMember() {
   
   }
   
      //why in the world was this not already a constructor
    public /*void Set*/StaffMember (String eName, String eAddress, String ePhone, String eSocialSec, Double eRate)
   {
      name = eName;
      address = eAddress;
      phone = ePhone;
      ssn = eSocialSec;
      Rate = eRate;
   }


   //-----------------------------------------------------------------
   //  Returns a string including the basic employee information.
   //-----------------------------------------------------------------
   public String toString()
   {
      String result = "Name: " + name + "\n";

      result += "Address: " + address + "\n";
      result += "Phone: " + phone + "\n";
      result += "Social Security # "+ssn;

      return result;
   }

   //-----------------------------------------------------------------
   //  Derived classes must define the pay method for each type of
   //  employee.
   //-----------------------------------------------------------------

}
