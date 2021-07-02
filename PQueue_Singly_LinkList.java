import java.io.*;
import java.io.*;
class Link
{
public int data;
public int priority;
public Link next;

public Link (int d)
{
data=d;
}
public void displayLink()
{
System.out.println(data);
}
}

class PQueue_Singly_LinkList  //descending priority queue using singly linked list
{
public static Link first;
public PQueue_Singly_LinkList ()
{
first=null;
}

public static boolean isEmpty()
{
return(first==null);
}
public PQueue_Singly_LinkList(int d,int p)
{
Link first=new Link(d);
first.priority=p;
first.next=null;
//return first;
}


public static int peek(Link L)
{
return(L.data);
}

public static Link pop()
{
Link tmp=first;
first=first.next;
return tmp;
}

public static Link push(int d, int p)
{
Link start=first;
Link tmp=new Link(d);
tmp.priority=p;

if((first.priority)>p)
{
tmp.next=first;
first=tmp;
}

else
{
while(start.next!=null &&start.next.priority<p)
{
start=start.next;
}
tmp.next=start.next;
start.next=tmp;

}
return tmp;

}


public void display()
{

Link cur=first;
while(cur!=null)
{

System.out.println(peek(cur));
cur=cur.next;
}
}
public static void main(String args[])throws IOException
{
int choice,ch,fd,fp,d,p;
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter the first data ");
fd=Integer.parseInt(br.readLine());
System.out.println("Enter the data priority ");
fp=Integer.parseInt(br.readLine());

PQueue_Singly_LinkList PQ= new PQueue_Singly_LinkList(fd,fp);  //object of class prioriyQ

//Link LK=newLink(fd,fp);
do
{
System.out.println("Enter your choice : \n1--To insert into priority queue \n2--To delete from priority queue\n3--To display the queue \nEnter your choice : ");

choice=Integer.parseInt(br.readLine());
switch(choice)
{
case 1:
System.out.println("Enter the data to be inserted : ");
d=Integer.parseInt(br.readLine());
System.out.println("Enter the priority of data : ");
p=Integer.parseInt(br.readLine());
PQ.push(d,p);

break;

case 2:
if(PQ.isEmpty())
System.out.println("Linklist is empty - there is nothing left to delete");
else
{
d=(PQ.pop()).data;
System.out.println("element "+d +" deleted");
}
break;

case 3:
if(PQ.isEmpty())
System.out.println("Linked list is empty\n");
else
{
PQ.display();



}
break;

default:System.out.println("Invalid option selected");
}
System.out.println("PRESS 1 if you want to continue ");
ch=Integer.parseInt(br.readLine());
}while(ch==1);
}
}
