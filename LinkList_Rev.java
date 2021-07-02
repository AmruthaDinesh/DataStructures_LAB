import java.io.*;

class Link
{
public int data;
public Link next;
public Link prev;

public Link(int d)
{
    data=d; 
  
}
public void displayLink()
{
    System.out.println(data);
}
}
class LinkList_Rev
{
public Link first;

public LinkList_Rev()
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
    nw.prev=null;
    first=nw;
    first.prev=nw;
}

public Link deleteFirst()
{
Link temp=first;
first=first.next;
first.prev=null;
return temp;
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
public  void  reverse()
   {
   
    Link cur=first;
    
    Link temp2=first;//is the second temp to swap next and prev

    
System.out.println("Inside rev");
    while(cur.next!=null)
    {
      temp2=cur;
      temp2.next=cur.prev;
      temp2.prev=cur.next;
     System.out.println("Inside while");
      cur=cur.next;

    }
    cur.prev=cur.next;
    cur.next=temp2;
 
    System.out.println("Inside last rev");
    return;
    

}
public static void main(String[] args) throws IOException
{
       int choice,ch,d;
       LinkList_Rev L=new LinkList_Rev();
      do {
           System.out.println("Enter your choice : \n1--Insert to first\n2--Delete from first\n3--Reverse Link\n4--Display link\nEnter your choice : ");
           BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
           choice=Integer.parseInt(br.readLine());
           switch(choice)
           {
              case 1:
              System.out.println("Enter the element to be inserted : ");
              d=Integer.parseInt(br.readLine());
              L.insertFirst(d);
              break;

              case 2:
              if(L.isEmpty())
              {
                  System.out.println("Link list is already Empty, nothing's left to delete");
              }
              else 
              {
                 Link D=L.deleteFirst();
                  System.out.println("Data "+D.data+ " is deleted");

              }
              break;

              case 3:
              if(L.isEmpty())
              {
                  System.out.println("Link list is already Empty, nothing's left to delete");
              }
              else
              {
              L.reverse();
              System.out.println("Link reversed");
              }
              break;
              case 4:
              if(L.isEmpty())
              {
                  System.out.println("Link list is Empty");
              }
              else
              {
                  L.displayList();
              }
              break;
            

              default:
              System.out.println("Invalid Choice !");
           }
           System.out.println("\nPress 1 if you want to continue : ");
           ch=Integer.parseInt(br.readLine());
       }while(ch==1);
}

}
