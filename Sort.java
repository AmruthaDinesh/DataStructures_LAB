import java.io.*;
class Sort
{
private int max;
private int i;
public int[] P;
public Sort(int S)
{
max=S;
P=new int[max];
}

public  void BubbleSort()
{
int j,temp;
for(i=0;i<max-1;i++)
{
for(j=0;j<max-i-1;j++)
{
if(P[j]>P[j+1])
{
temp=P[j];
P[j]=P[j+1];
P[j+1]=temp;

}
}
}

}

public  void Display()
{
System.out.println("Displaying the array elements after sorting\n");
for(i=0;i<max;i++)
{
System.out.println( "The element at "+ i +" is : "+P[i]);
}
}



public static void main(String args[]) throws IOException
{
int n;
System.out.println("Enter the array size ");
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
n=Integer.parseInt(br.readLine());
Sort A= new Sort(n);


System.out.println("Enter the array elements : ");
int k;
for( k=0;k<n;k++)
{
System.out.println("Enter the array element at position  ");

A.P[k]=Integer.parseInt(br.readLine());

}

A.BubbleSort();
A.Display();

}
}
