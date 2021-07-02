import java.io.*;
class infix_to_post
{
private int max;
public char[] Ar;
private int top;

public infix_to_post(int S)
{
max=S;
Ar=new char[max];
top=-1;
}

public void push(char c)
{
Ar[++top]=c;
}

public char pop()
{
char qw=Ar[top];
top--;
return qw;

}

public char peek()
{
return Ar[top];
}

public boolean isFull()
{
return (top==max-1);
}

public boolean isEmpty()
{
return (top==-1);
}



static int Prec(char ch) //function to check for precedence
{ 
 switch (ch) 
 { 
        case '+': 
        case '-': 
            return 1; 
       
        case '*': 
        case '/': 
            return 2; 
       
        case '^': 
            return 3; 
        case '$':
            return 4;
 } 
        return -1; 
 } 
     						


public String Conversion(String expr)
{
     int l;
     char item,x;
String result=new String("");
l=expr.length();

for(int i=0;i<l;i++)
{
     //operator checking condition
   x=expr.charAt(i);
   
     if (x=='+'||x=='-'||x=='*'||x=='/'||x=='$')
     {
         if(isEmpty())
             push(x);
         else
         {
             while(!isEmpty())
             {
                 item = pop();
                 if(item=='(')
                    push(item);
                    
                 else
                 {
                   
                     if(Prec(item)<Prec(x)) 
                           push(item);
                  
                     if(Prec(item)>=Prec(x))
                         result+=item;
                 }

                 if(Prec(item)<Prec(x) || item == '(')
                    break;
             }
            push(x); 
         }
         
     }
     // '(' checking condition
     else if(x=='(')
     {push(x);
}
    // ')' checking condition
     else if(x==')')
     {
         while(!isEmpty())
         {
             item =pop();
             if(item == '(')
             break;
             else
             result+=item;
         }
     }

     else 
     // condition for operand
     result=result+x;
}

while(!isEmpty())
{
item=pop();
result+=item;
}
return result; 

}

public static String Rev(String str)
{



 byte[] strAsByteArray = str.getBytes();
 
        byte[] result = new byte[strAsByteArray.length];
 
        // Store result in reverse order into the
        // result byte[]
        for (int i = 0; i < strAsByteArray.length; i++)
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];
 
      String Rstr= new String(result);

return Rstr;
}


public static void main(String args[])throws IOException
{

int i,CH,ca,l;

System.out.println("Enter the infix expression");
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
String str=br.readLine();
l=str.length();

infix_to_post Stk=new infix_to_post(l);
do
{
System.out.println("--------Enter Your choice------\n\n1----Infix to postfix\n\n2-----Infix to prefix");
ca=Integer.parseInt(br.readLine());
switch (ca)
{
case 1:
System.out.println(Stk.Conversion(str)+" is the required postfix expression of "+ str);
break;
 
case 2:
String Rstr=Rev(str);
String R=new String("");

char[] Cha=new char[Rstr.length()];
 
 //step2. Make Every '(' as ')' and every ')' as '('.
 
for(i=0;i<Rstr.length();i++)
{
Cha[i]=Rstr.charAt(i);

 if(Cha[i]==')')
                  {
                      Cha[i]='(';
                      continue;
                  }
                  if(Cha[i]=='(')
                  {
                      Cha[i]=')';
                  }
}
for(i=0;i<Rstr.length();i++)
{
 R+=Cha[i];
 
}
         
 //step2. Make Every '(' as ')' and every ')' as '('.
           

System.out.println(Rev(Stk.Conversion(R))+" is the required prefix expression of "+ str);
break;

default:
{
System.out.println("Invalid choice");
}

}
System.out.println("Do you want to continue?(1==yes/2==no)");

CH=Integer.parseInt(br.readLine());


}while(CH==1);
}



}

