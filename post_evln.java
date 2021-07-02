import java.io.*;
 public class postfix_evaluation
{
private int max;
public int[] Ar;
private int top;

public postfix_evaluation(int S)
{
max=S;
Arr=new int[max];
top=-1;
}

public void push(int c)
{

Arr[++top]=c;
}

public int pop()
{
int qw=Arr[top];
top--;
return qw;

}

public int peek()
{
return Arr[top];
}

public boolean isFull()
{
return (top==max-1);
}

public boolean isEmpty()
{
return (top==-1);
}


public static boolean isOperator(char c)
{
return((!Character.isDigit(c))&&(!Character.isAlphabetic(c)));
}

public static boolean isOperand(char c)
{

return(Character.isDigit(c));

}



public static void main(String args[])throws IOException
{

int i,a,b,l;
int count=0;
System.out.println("Enter the postfix expression");
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
String str=br.readLine();
l=str.length();
for(i=0;i<l;i++)
{
if(isOperand(str.charAt(i)))
count++;
}

postfix_evaluation OPerand= new postfix_evaluation(count);
for(i=0;i<l;i++)
{
if(isOperand(str.charAt(i)))// if operand create stack to store operands
{
OPerand.push(Integer.parseInt(String.valueOf(str.charAt(i))));

}
else if(isOperator(str.charAt(i)))
{
switch(str.charAt(i))
{
case '+':
a= OPerand.pop();
b=OPerand.pop();
OPerand.push(a+b);

break;

case '*':
a=OPerand.pop();
b=OPerand.pop();
OPerand.push(a*b);

break;

case '-':
a=OPerand.pop();
b=OPerand.pop();
OPerand.push(a-b);

break;

case '/':
a=OPerand.pop();
b=OPerand.pop();
OPerand.push(a/b);


break;

/*case '^':
a=OPerand.pop();
b=OPerand.pop();
OPerand.push(Math.pow(a,b));
System.out.println(OPerand.peek()+"");
break;*/

default:
System.out.println("Invalid expression");

}

}
}
System.out.println("Expression evaluates to "+ OPerand.peek());

}
}
