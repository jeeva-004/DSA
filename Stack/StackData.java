package Stack;
class Stack {
    int[] stack = new int[5];
    int tos;
    Stack(){
        tos = -1;
    }

    void push(int value){
        if(tos==stack.length-1)
            System.out.println("stack is full");
        else
            stack[++tos] = value;
    }

    void display(){
        for(int num: stack){
            System.out.println(num);
        }
    }

    int pop(){
        if(tos<=0)
            System.out.println("stack is empty!");
        else
            return stack[tos--];
        return -1;
    }
}

public class StackData {
    public static void main(String[] args) {
        Stack data = new Stack();
        data.push(3);
        data.push(4);
        data.push(2);
        data.push(3);
        data.push(3);
        // data.pop();
        data.pop();
        data.pop();
        data.pop();
        data.pop();
        data.pop();
    }
}