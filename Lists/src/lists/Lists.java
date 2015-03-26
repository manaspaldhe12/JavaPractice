package lists;
import java.util.Hashtable;
/**
 *
 * @author mpaldhe
 */
class Node {
    int data;
    Node next;         
    
    Node (int element){
        data=element;        
    }
    
    void addtoHead (int element){
        Node copy = new Node(data);
        copy.next=next;
        
        data=element;
        next=copy;
    }
    
    void addtoTail (int element){
        Node temp=next;
        if (temp==null){
            next=new Node (element);
        }
        else{
            while(temp.next !=  null){
                temp=temp.next;
            }
            temp.next=new Node (element);
        }
    }
    
    void print (Node list){
        Node temp=list;
        if (list==null){
        }
        else{
            while(temp.next !=  null){
                System.out.print(temp.data+"->");
                temp=temp.next;
            }
            System.out.println(temp.data);
            
        }
    }
    
    Node reverse (Node list){
        Node temp=list;
        if (list == null){
            return null;
        }
        else{
            Node reversed = new Node (list.data);
            temp=temp.next;
            while(temp != null){
                reversed.addtoHead(temp.data);
                temp=temp.next;
            }
            return reversed;
        }
    }
    
    Node mergeRecursive (Node a, Node b){
        if (a == null){
            return b;
        }
        if (b==null){
            return a;
        }
        else{            
            if (a.data<b.data){
               Node merged= new Node (a.data);
               merged.next=mergeRecursive(a.next, b);
               return merged;
            }
            else{
               Node merged= new Node (b.data);
               merged.next=mergeRecursive(a, b.next);                
               return merged;
            }
        }
        
    }
    
    Node mergeSorted (Node a, Node b){
        Node sorted1= a;
        Node sorted2= b;
        Node merged=new Node(0);
        Node merged_copy=merged;
        
        while((sorted1 != null)&&(sorted2 != null)){
            if (sorted1.data<sorted2.data){
                merged_copy.next=new Node (sorted1.data);                
                sorted1=sorted1.next;   
            }
            else{
                merged_copy.next=new Node (sorted2.data);                                
                sorted2=sorted2.next;                
            }
            merged_copy=merged_copy.next;
        }
        if (sorted1 == null){
            merged_copy.next=sorted2;
        }
        else{
            merged_copy.next=sorted1;
        }
        return merged.next;
    }
    
    void removeDuplicates (){
        Node copy = new Node(data);
        copy.next=next;
        
        Hashtable table = new Hashtable();
        table.put(copy.data, copy.data);
        if (copy.next==null){
            return;
        }
        else{
            while (copy.next != null){
                if (table.containsKey(copy.next.data)==true){
                    copy.next=copy.next.next;
                    if (copy.next==null){
                        break;
                    }
                }
                else{
                    table.put(copy.next.data, copy.next.data);
                }
                copy=copy.next;                
            }
        }
    }
    
    void removeDuplicatesNoSpace (){
        Node copy = new Node (data);
        copy.next=next;

        if (copy.next==null){
            return;
        }
        else{
            boolean last_repeated=false;
            while (copy != null){
                Node iterator=copy;
                while(iterator.next != null){
                    if (iterator.next.data==copy.data){
                        if (iterator.next.next==null){
                            iterator.next=null;
                            break;
                        }
                        else{
                            last_repeated=false;
                            iterator.next.data=iterator.next.next.data;
                            iterator.next.next=iterator.next.next.next;
                        }
                    }
                    iterator=iterator.next;
                }
                copy=copy.next;
            }
        }
    }
    
    Node nthFromLast(int n){
        Node copy=new Node (data);
        copy.next=next;
        
        Node forward_copy = copy;
        for (int i=0; i<n; i++){
            if (forward_copy==null){
                return copy;
            }
            forward_copy=forward_copy.next;
        }
        
        while(forward_copy != null){
            forward_copy= forward_copy.next;
            copy=copy.next; 
        }
        return copy;
    }
    
    void deleteNode (){

      this.data=this.next.data;
      this.next=this.next.next;
    }
    
    Node addNumbers (Node a, Node b){
        int carry =0;
        
        Node num1=a;
        Node num2=b;
        Node result= new Node(0);
        Node result_copy= result;
        
        while ((num1 !=  null) && (num2 != null)){
            if (num1.data+num2.data+carry>9){
                result.next=new Node (num1.data+num2.data+carry-10);
                carry=1;
            }
            else{
                result.next=new Node (num1.data+num2.data+carry);
                carry=0;
            }
            num1=num1.next;
            num2=num2.next;
            result=result.next;
        }
        if (num1==null){
            while (num2 != null){
                if (carry==0){
                    result.next=new Node (num2.data);
                    result.next.next=num2.next;
                }
                else{
                    if (num2.data==9){
                        carry=1;
                        result.next=new Node (0);
                    }                    
                    else{
                        result.next=new Node (num2.data+1);
                        carry=0;
                    }                    
                }
                num2=num2.next;
                result=result.next;
            }
        }
        else if (num2==null){
            while (num1 != null){
                if (carry==0){
                    result.next=new Node (num1.data);
                    result.next.next=num1.next;
                }
                else{
                    if (num1.data==9){
                        carry=1;
                        result.next=new Node (0);
                    }                    
                    else{
                        result.next=new Node (num1.data+1);
                        carry=0;
                    }
                }
                num1=num1.next;
                result=result.next;
            }
        }
        return result_copy.next;
    }
}

public class Lists {
   
    public static void main(String[] args) {
        
        Node a=new Node(3);
        a.addtoTail(1);
        a.addtoTail(5);
        a.print(a);

        Node b=new Node(5);
        b.addtoTail(9);
        b.addtoTail(2);
        b.print(b);
        
        Node sum= a.addNumbers(b,a);
        sum.print(sum);
    }
}
