import java.io.*;
class Que_Array
{
private int max;
private int[] Ar;
private int rear;
private int front;

public Que_Array(int size)
{
max=size;
Ar=new int[max];
rear=-1;
front=-1;
}

public void Enqueue(int item)
{
if((rear+1)%max==front)
System.out.println("Overflow--Queue is already full");
else 
{
if((front==-1)&&(rear==-1))
{
front++;
rear++;
}
else if((rear==max-1)&&(front!=0))
{
rear=0;
}
else
rear=(rear+1)%max;

Ar[rear]=item;
System.out.println("Element inserted at "+rear);
}
}

public void Dequeue()
{ 
int value;
if(front==-1)
{
System.out.println("Underflow--Queue is already empty");
return ;
}
value=Ar[front];
if(front==rear)
{
front=-1;
rear=-1;
}
else if(front==max-1)
front=0;
else
front=front+1;
System.out.println(value + " deleted! ");
}

public void displayQue()
{
int i=front;
int j;
if(front==-1 && rear==-1)
{
System.out.println("Queue is empty");
}
else if(rear>=front)
{
while(i<=rear)
{
System.out.println(Ar[i]);
i++;
}
}
else
{
 for(i = front; i < max; i++)
        {
            System.out.println(Ar[i]);
            
        }
 for(j=0;j<=rear;j++)
 System.out.println(Ar[j]);       
}


}
public void isEmpty()
{
if(front==-1)
System.out.println("Queue is Empty");
else
System.out.println("Queue is not Empty");
}

public void isFull()
{
if((rear+1)%max==front)
System.out.println("Queue is Full");
else
System.out.println("Queue is not Full");
}

public static void main(String args[])throws IOException
{
int s,c,e,choice,d;
System.out.println("Enter the array size : ");
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
s=Integer.parseInt(br.readLine());
Que_Array Que=new Que_Array(s);
do
{
System.out.println("--------Enter Your choice------\n\n1----Enqueue-To insert to queue\n\n2-----Dequeue-To delete from queue\n\n3-----Display-To display all elements of queue\n\n4----To check if full\n\n5----To check if Empty   ");
c=Integer.parseInt(br.readLine());
switch (c)
{
case 1:
System.out.println("Enter the element to be inserted ");
e=Integer.parseInt(br.readLine());
Que.Enqueue(e);
break;

case 2:
Que.Dequeue();
break;

case 3:
Que.displayQue();
break;

case 4:
Que.isFull();
break;

case 5:
Que.isEmpty();
break;

default:
System.out.println("Invalid Choice !");
}
System.out.println("\nPress 1 if you want to continue");
choice=Integer.parseInt(br.readLine());
}while(choice==1);

}

}
