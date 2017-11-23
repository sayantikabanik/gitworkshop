import java.io.*;
import java.util.*;
import java.net.*;

class clientsocket{
    public static void main(String [] args)throws Exception{
        Socket sock =new Socket("127.0.0.1",4000);
        System.out.println("connection estabilised");
        System.out.println("enter the file name");
        BufferedReader buff =new BufferedReader(new InputStreamReader(System.in));
        String fname=buff.readLine();
        
        //ostream on server
        OutputStream ostream=sock.getOutputStream();
        PrintWriter pwrite=new PrintWriter(ostream,true);
        pwrite.println(fname);
        //waiting for server response
        InputStream instream=sock.getInputStream();
          BufferedReader buff2 =new BufferedReader(new InputStreamReader(System.in));
          String str=buff2.readLine();
          while(str!=null)
          {
              System.out.print(str);
            }
            buff.close();buff2.close();pwrite.close();sock.close();
        }
    }
    class serversocket{
         public static void main(String [] args)throws Exception{
             ServerSocket sersock=new ServerSocket(4000);
             Socket sock=new Socket();
             sock=sersock.accept();
              InputStream instream=sock.getInputStream();
          BufferedReader buff3 =new BufferedReader(new InputStreamReader(System.in));
          String str=buff3.readLine();
          
             BufferedReader buff4 =new BufferedReader(new InputStreamReader(System.in));
           
             
             OutputStream ostream=sock.getOutputStream();
        PrintWriter pwrite=new PrintWriter(ostream,true);
                String str2=buff4.readLine();
         while(str2!=null)
          {
              System.out.print(str);
            }
        sock.close();sersock.close();pwrite.close();buff3.close();buff4.close();
    }
}
