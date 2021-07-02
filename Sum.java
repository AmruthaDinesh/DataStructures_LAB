import java.io.*;
class Sum
{
public static void main(String args[]) throws IOException
{
int a,b,s;
System.out.println("Enter the values of a and b ");
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
a=Integer.parseInt(br.readLine());
b=Integer.parseInt(br.readLine());
s=a+b;
System.out.println("Sum is " +s);
}
};
