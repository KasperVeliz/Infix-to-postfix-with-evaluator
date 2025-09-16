public class StackChar {
    private int top = -1;
    private char[] stack;

    public StackChar(int length){
        stack = new char[length];
    }

    public void push(char ch){
        top++;
        stack[top] = ch;
    }

    public void pop(){
        top--;
    }

    public char peek(){
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
