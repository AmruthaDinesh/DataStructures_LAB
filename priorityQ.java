import java.io.*;
import java.util.*;

//Link
class Link {
    
    public int data;
    public int priority;
    public Link next;
    public Link (int d,int p){
        data=d;   
        priority=p;
}

public void displayLink() {
    System.out.println(data);
}
}

class LinkList
{
    private Link first;
    public LinkList()
    {
        first=null;
    }

    public boolean isEmpty()
    {
        return(first==null);
    }

 //insert at last

public void insertLast(int d,int p)
{
    Link cur=first;
    Link nl =new Link(d,p);

    if(isEmpty()){
        first=nl;
    }else{
        
    
        while(cur.next!=null)
        {
            cur=cur.next;
        }
        cur.next=nl;
        nl.next=null;
    }

}

// delete the first element

public int deleteFirst()
{
    //if list is Empty

        sort();
        int temp = first.data;
        first = first.next;
        return temp;
    
}



 // SWAP
 public void swap(int pos) {
    Link cur = first;
    Link prev = first;

    int i = 0;
    while (pos != i) {
        prev = cur;
        cur = cur.next;
        i++;
    }
    if(cur.priority>prev.priority)
    {
    int temp = cur.data;
    int tp=cur.priority;
    
    cur.data = prev.data;
    cur.priority=prev.priority;
    prev.data = temp;
    prev.priority=tp;
    }
}

// Sort-Bubble
public void sort() {
    int p, n = 1;
    Link cur = first;
    while (cur.next != null) {
        cur = cur.next;
        n++;
    }
    for (int i = 0; i < n - 1; i++) {
        for (int j = 1; j <= n - i - 1; j++) {
            p = j;
            swap(p);
        }

    }
  
}



}

public class priorityQ {
    public static void main(String args[])throws IOException
    {
        LinkList obj;
        obj = new LinkList();
        int choice,value,value1,p;

        Scanner sc = new Scanner(System.in);

    
 
    System.out.println("**** DESCENDING PRIORITY QUEUE ****");
    do {
        System.out.println("1.INSERT TO QUEUE");
        System.out.println("2.DELETE FROM QUEUE");

        choice =sc.nextInt();

        switch (choice) {
        case 1: {
            System.out.println("Enter the data");
            value = sc.nextInt();
            System.out.println("Enter the priority");
            p = sc.nextInt();
            obj.insertLast(value,p);
            break;
        }
        case 2: {

            if(obj.isEmpty())
            {
                System.out.println("List is Empty");
            }else{
            int d = obj.deleteFirst();
            System.out.println(d + " is Deleted");
            }
            break;
        }
        
        default:
            System.out.println("Invalid input");

        }

    } while (choice == 1 || choice == 2);

}
}
