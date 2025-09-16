public class Stack {

    private int top = -1;
    private int[] stack;

    public Stack(int length){
        stack = new int[length];
    }

    public void push(int num){
        top++;
        stack[top] = num;
    }

    public void pop(){
        top--;
    }

    public int peek(){
        return stack[top];
    }

    public void size(){
        System.out.println("Number of elements in stack: " + (top + 1));
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void printStack(){
        if (isEmpty()){
            System.out.println("Stack is empty");
        }
        else{
            System.out.println("Top of stack");
            for(int i = top; i >= 0; i--){
                System.out.println(stack[i]);
                System.out.println("--");
            }
            System.out.println("Bottom of stack");
        }
    }
}