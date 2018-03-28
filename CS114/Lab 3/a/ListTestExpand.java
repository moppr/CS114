package a;

/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/

/** A JUnit test class for lists. */

import java.io.*;
import java.util.*;

public class ListTestExpand
{

    public static void main(String args[]) {
    AListGrow arr = new AListGrow(10);
    Random gen = new Random();
    for (int i= 0; i<10; i++)
     arr.insert(gen.nextInt(100));
    

    System.out.println("\nBefore initial size is exceeded: "+arr.length());
    System.out.println(arr.toString());
    
    for (int i= 0; i<10; i++)
     arr.append(gen.nextInt(100));

    System.out.println("\nAfter expanding of array and before set: "+arr.length());
    System.out.println(arr.toString());
    
    for (int i= 0; i<40; i++)
     arr.append(gen.nextInt(100));

    System.out.println("\nAfter expanding of array and before set: "+arr.length());
    System.out.println(arr.toString());
    

    arr.next();
    arr.insert(12345);

    System.out.println("\nAfter set: ");
    System.out.println(arr.toString());
  }

}
