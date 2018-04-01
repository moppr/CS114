package c;

//********************************************************************
//  Inventory.java       
//
//********************************************************************

public class Inventory
{
   protected String PartNo;
   protected String Model;
   protected String Description;
   protected Double ListPrice;

   //-----------------------------------------------------------------
   //  Constructor: Sets up this inventory using the specified
   //  information.
   //-----------------------------------------------------------------
   public Inventory() {
   
   }
   
    public String GetPartNo()
    {
      return PartNo;
    
    }  
    public void SetInventory (String ePartNo, String eModel, String eDescription, Double eListPrice)
   {
      PartNo = ePartNo;
      Model = eModel;
      Description = eDescription;
      ListPrice = eListPrice;
   }


   //-----------------------------------------------------------------
   //  Returns a string including the basic inventory information.
   //-----------------------------------------------------------------
   public String toString()
   {
     String result = null;
    if (PartNo != null)
    {
      result = "Part Number: " + PartNo + " ";
      result += "Model: " + Model + " ";
      result += "List Price: "+ Double.toString(ListPrice) + "\n";
      result += "Description: " + Description + "\n";
    }
      return result;
   }

   //-----------------------------------------------------------------
   // 
   //-----------------------------------------------------------------
   
   public String getPartNo()
   {
         return PartNo;
         
   }
   
   public String getModel()
   {
         return Model;
   }
   
   public String getDesc()
   {
        return Description;
        
   }
   
   public double getListPrice()
   {
        return ListPrice;
   }
   

}
