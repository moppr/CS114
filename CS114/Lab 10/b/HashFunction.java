package b;

import java.io.*;
import java.math.*;

public class HashFunction
{

int sfold(String s, int M) {

  int intLength = s.length() / 4;
  int sum = 0;
  for (int j = 0; j < intLength; j++) {
   char c[] = s.substring(j*4,(j*4)+4).toCharArray();
    int mult = 1;
    for (int k = 0; k < c.length; k++) {
      sum += c[k] * mult;
      mult *= 256;
    }
  }

  char c[] = s.substring(intLength * 4).toCharArray();
  int mult = 1;
  for (int k = 0; k < c.length; k++) {
    sum += c[k] * mult;
    mult *= 256;
  }

  return(Math.abs(sum) % M);
}
int h(String x, int M) {
  char ch[];
  ch = x.toCharArray();
  int xlength = x.length();

  int i, sum;
  for (sum=0, i=0; i<x.length(); i++)
    sum += ch[i];
  return sum % M;
}
int h(int x) {
  return(x % 16);
}
 
}

