import java.io.*;
class StrnG
{

private int max;
private char[] Ar;
private int top;

public StrnG(int L)
{
max=L;
Ar=new char[max];
top=-1;

}

public void Push(char j)
{
Ar[++top]=j;
}


public int pop()
{
return Ar[top--];
}

public char peek()
{
return Ar[top];
}
}
class Mainstring
{
public static void main(String args[])throws IOException
{
int i,l;
System.out.println("Enter the string");
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
String str=br.readLine();
l=str.length();
StrnG S= new StrnG(l);
for(i=0;i<l;i++)
{
S.Push(str.charAt(i));
}

for(i=0;i<l;i++)
{

System.out.println(S.peek());
S.pop();
}
}
}


