import java.io.*;
class Stack
{
private int max;
private int[] Ar;
private int top;

public Stack(int S)

{
max=S;
Ar=new int[max];
top=-1;

}

public void Push(int j)
{
Ar[++top]=j;
}


public int pop()
{
return Ar[top--];
}

public int peek()
{
return Ar[top];
}

public boolean isFull()
{
return top==max-1;
}

public boolean isEmpty()
{
return top==-1;
}

public void  Display()
{
int i;
System.out.println("Displaying elements  of stack : \n ");
for(i=0;i<=top;i++)
{
System.out.println(Ar[i]+"  ");
}

}
}



class Main
{
public static void main(String args[])throws IOException
{
int n,ch,c,k;
System.out.println("Enter the limit of stack ");
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
n=Integer.parseInt(br.readLine());
Stack Stk=new Stack(n);
do
{
System.out.println("--------Enter Your choice------\n\n1----push to stack\n\n2-----pop from stack\n\n3-----Peek into stack\n\n4----Display");
c=Integer.parseInt(br.readLine());
switch (c)
{
case 1:
 if(Stk.isFull())
 {
 System.out.println("Stack Overflow");
 }
 else
 {
 System.out.println("Enter the element to be pushed to stack ");
 k=Integer.parseInt(br.readLine());
 Stk.Push(k);
 }
break;


case 2:
if(Stk.isEmpty())
 {
 System.out.println("Stack Underflow");
 }
 else
 {
  k=Stk.pop();
  System.out.println( k+"Popped");
  
  }
  break;
  
case 3:
if(Stk.isEmpty())
{
System.out.println("Stack is Empty");
}
else
{
  k=Stk.peek();
  System.out.println(k +"is the last element");
 }
 break;
 
 case 4:
 if(Stk.isEmpty())
{
System.out.println("Stack is Empty");
}
else
{
Stk.Display();
}
break;
 
default: System.out.println("Invalid choice"); 
}  
System.out.println("Do You want to continue ? Press 0--No\n Press 1--Yes");
ch=Integer.parseInt(br.readLine());
}while(ch==1);





}
}
