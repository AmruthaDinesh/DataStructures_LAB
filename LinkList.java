import java.io.*;
class Link
{
public int data;
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

class LinkList
{
public Link first;
public LinkList()
{
first=null;
}

public boolean isEmpty()
{
return(first==null);
}

public void insertFirst(int d)
{
Link nw=new Link(d);
nw.next=first;

first=nw;
}

public void insert_after_Key(int k,int d)
{
Link cur=first;
Link prev=first;
Link nw=new Link(d);
while(cur.data!=k)
{
if(cur.next==null)
{
System.out.println("Key element not found");
return ;
}
else
{
prev=cur;
cur=cur.next;
}
}

nw.next=prev.next;
prev.next=nw;

}

public Link deleteFirst()
{
Link temp=first;
first=first.next;
return temp;
}



public void insertLast(int d)
{
Link nw=new Link(d);
Link cur=first;

while(cur.next!=null)
{

cur=cur.next;
}
if(cur==first)
{
nw.next=first;
first=nw;
}
else
{
cur.next=nw;
nw.next=null;
}
}

public Link deleteLast()
{
Link cur=first;
Link prev=first;
while(cur.next!=null)
{
prev=cur;
cur=cur.next;
}
if(cur==first)
{
first=first.next;
}
prev.next=null;
return cur;

}
public Link findLink(int key) //To find the particular link 
{
Link cur=first;
if(cur.data!=key)
{
if(cur.next==null)
return null;
else
cur=cur.next;
}
return cur;
}

public Link delete_at_Key(int k)
{
Link cur=first;
Link prev=first;
while(cur.data!=k)
{
if(cur.next==null)
{
System.out.println("Key element not found !");
return null;
}
else
{
prev=cur;
cur=cur.next;
}
}
if(cur==first)
{
first=first.next;
}
else
prev.next=cur.next;
return cur;
}


public void displayList()
{
Link cur=first;
while(cur!=null)
{
cur.displayLink();
cur=cur.next;
}
}


public static void main(String args[])throws IOException
{
int choice,d,k,ch;
LinkList L=new LinkList();
do
{
System.out.println("Enter your choice : \n1--Check if Linked list is empty?\n2--To insert first into the linked list\n3--To delete first from Linked list\n4--To display all data \n5--To insert after a given node \n6--To delete a particular node \n7--To insert to the last \n8--To delete the last node \nEnter your choice : ");
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
choice=Integer.parseInt(br.readLine());
switch(choice)
{
case 1:
if(L.isEmpty())
System.out.println("Linked list is empty\n");
else
System.out.println("Linked list is not empty\n");

break;

case 2:
System.out.println("Enter the data to be inserted : ");
d=Integer.parseInt(br.readLine());
L.insertFirst(d);
System.out.println("Data  "+d+" inserted");

break;

case 3:
if(L.isEmpty())
System.out.println("Linklist is empty - there is nothing left to delete");
else
{
L.deleteFirst();
System.out.println("First element deleted");
}
break;

case 4:
if(L.isEmpty())
System.out.println("Linked list is empty\n");
else
{
L.displayList();

}
break;

case 5:
if(L.isEmpty())
System.out.println("Linklist is empty - there is no key to search for");
else
{
System.out.println("Enter the data to be inserted : ");
d=Integer.parseInt(br.readLine());
System.out.println("Enter the key element  : ");
k=Integer.parseInt(br.readLine());
L.insert_after_Key(k,d);
System.out.println("Data  "+d+" inserted after"+k);
}
break;

case 6:
if(L.isEmpty())
System.out.println("Linklist is empty - there is nothing left to delete");
else
{
System.out.println("Enter the key element  : ");
k=Integer.parseInt(br.readLine());

if(L.delete_at_Key(k)!=null)
System.out.println("The element "+k+" deleted");
}
break;
case 7:
System.out.println("Enter the data to be inserted to the last");
d=Integer.parseInt(br.readLine());
L.insertLast(d);
System.out.println("Data inserted to the last");
break;

case 8:
if(L.isEmpty())
System.out.println("Linklist is empty - there is nothing left to delete");
else
{
System.out.println("Last element deleted ! ");
L.deleteLast();
}
break;
default:System.out.println("Invalid option selected");
}
System.out.println("PRESS 1 if you want to continue ");
ch=Integer.parseInt(br.readLine());
}while(ch==1);
}
}
