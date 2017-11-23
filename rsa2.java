
import java.io.*;
import java.util.*;
class rsa2
{
 public static void main(String args[])
 {
  Scanner ip=new Scanner(System.in);
  int p,q,n,e=1,j;
  int d=1,i1;
  int t1,t2;
  int pt[]= new int[10];
  int ct[]= new int[10];
  int rt[]= new int[10];
  String i=new String();
  System.out.println("Enter the two prime numbers:");
  p=ip.nextInt();
  q=ip.nextInt();
  System.out.println("Enter the message to be sent");
  i=ip.next();
  i1=i.length();
  for(j=0;j<i1;j++)
  {
   pt[j]=(i.charAt(j))-96;
  }
  n=p*q;
  t1=p-1;
  t2=q-1;
  while((t1*t2)%e==0)
  {
   e++;
  }
  for(j=0;j<i1;j++)
  {
   ct[j]=((int)Math.pow(pt[j],e))%n;
  }
  System.out.println("Sender Side:");
  System.out.println("----------------------");
  System.out.println("Public Key(e)= "+e);
  for(j=0;j<i1;j++)
  {
   System.out.println("Cipher Text= "+ct[j]);
  }
  System.out.println("Receiver Side:");
  System.out.println("----------------------");
  while((d*e)%(t1*t2)!=1)
  {
   d++;
  }
  System.out.println("Private Key(d)= "+d);
  for(j=0;j<i1;j++)
  {
   rt[j]=((int)Math.pow(ct[j],d))%n;
   System.out.println("Plain Text= "+rt[j]);
  }
  System.out.print("Decrypted Message:");
  for(j=0;j<i1;j++)
  {
   rt[j]=rt[j]+96;
   System.out.print((char)rt[j]);
  }
 }
}
