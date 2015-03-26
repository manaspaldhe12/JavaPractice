package stacks;

class Stack{    
    int max_size=1000;
    int[] data = new int[max_size];
    int size=0;
    Stack(){
        size=0;
    }
    
    void push (int next){
        data[size]=next;
        size++;
    }

    boolean isEmpty(){
        if (size==0){
            return true;
        }
        else{
            return false;
        }
    }
    
    int top (){
        return data[size-1];
    }
    
    int pop(){
        size--;
        return data[size];
    }
    
    void print(){
        for (int i=size-1; i>=0; i--){
            System.out.print(data[i]+",  ");
        }
        System.out.println();
    }
    
    void sortStack(){
        Stack sorted = new Stack();
        
        while (!this.isEmpty()){
            int current=this.pop();
            int number_pushed=0;
            while((!sorted.isEmpty())&&(current < sorted.top())){
                this.push(sorted.pop());
                number_pushed++;
            }
            sorted.push(current);
            while(number_pushed>0){
                sorted.push(this.pop());
                number_pushed--;
            }
        }
        while (!sorted.isEmpty()){
            this.push(sorted.pop());
        }
    }
}

class StackMin {
    int[] data = new int[1000];
    int size=0;
    int[] min = new int[1000];
    int min_size=0;

    StackMin(){
        size=0;
        min_size=0;
    }
    
    void push (int next){
        data[size]=next;
        size++;
        if (min_size==0){
            min[min_size]=next;   
            min_size++;
        }    
        else{
            if (min[min_size-1]<next);
            else{
                min[min_size]=next;
                min_size++;
            }
        }
    }
    
    
    int top (){
        return data[size-1];
    }
    
    int pop(){
        size--;
        if (data[size]==min[min_size-1]){
            min_size--;
        }
        return data[size];
    }
    
    void print(){
        System.out.println("stack is");
        for (int i=size-1; i>=0; i--){
            System.out.print(data[i]+",  ");
        }
        System.out.println("minstack is");
        for (int i=min_size-1; i>=0; i--){
            System.out.print(min[i]+",  ");
        }
        System.out.println();
    }
}

class SetofStack{
    Stack [] setofStacks = new Stack[1000];
    int number_of_stacks=1;
    
    SetofStack(){
        number_of_stacks=1;
        setofStacks[0]=new Stack();
    }
    
    void push (int next){
        if (setofStacks[number_of_stacks-1].size==setofStacks[number_of_stacks-1].max_size){
            setofStacks[number_of_stacks]= new Stack();
            number_of_stacks++;
        }
        setofStacks[number_of_stacks-1].push(next);
    }
    
    int top (){
        return setofStacks[number_of_stacks-1].top();
    }
    
    int pop(){
        if (setofStacks[number_of_stacks-1].size==1){
            number_of_stacks--;
            return setofStacks[number_of_stacks].pop();
        }
        else{
            return setofStacks[number_of_stacks-1].pop();            
        }
    }
    
    void print (){
        for (int i=number_of_stacks-1; i>=0; i--){
            setofStacks[i].print();
        }
    }
}

class QueueUsingStack{
    Stack insert_stack = new Stack();
    Stack dequeue_stack = new Stack();
    
    QueueUsingStack(){
    }
    
    void insert (int next){
        insert_stack.push(next);
    }
    
    int front (){
        if (dequeue_stack.isEmpty()){
            while (!insert_stack.isEmpty()){
                dequeue_stack.push(insert_stack.pop());
            }
        }
        return dequeue_stack.top();
    }
    
    int dequeue(){
        if (dequeue_stack.isEmpty()){
            while (!insert_stack.isEmpty()){
                dequeue_stack.push(insert_stack.pop());
            }
        }
        return dequeue_stack.pop();        
    }
    
    boolean isEmpty (){
        if (dequeue_stack.isEmpty() && insert_stack.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
    
    void print (){
        System.out.println("dequeue stack");
        dequeue_stack.print();
        System.out.println("insert stack");
        insert_stack.print();
    }
}


public class Stacks {

    public static void main(String[] args) {
        
        Stack test= new Stack();
        test.push(1);
        test.push(122);
        test.push(43);
        test.push(34);
        test.push(215);
        test.push(-215);
        test.push(415);
        System.out.println("printing");
        test.print();
        test.sortStack();
        System.out.println("sorted");
        test.print();

    }
}
