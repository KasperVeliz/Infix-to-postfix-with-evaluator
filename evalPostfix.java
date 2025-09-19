public class evalPostfix {

    public static void main(String[] args){
        String infix = "2*(2*(1+1))";
        String postfix = infix2postfix(infix);
        int ans = evalPostfixFunc(postfix);
        System.out.println(infix + " -> " + postfix);
        System.out.println("postfix = " + ans);
    }

    public static boolean isOporator(char op){

        return ((op == '^')||(op == '*')||(op == '/')||(op == '+')||(op == '-'));
    }

    public static int precedence(char op){
        switch (op) {
            case '^':
                return 3;
            case '*':
                return 2;
            case '/':
                return 2;
            case '+':
                return 1;
            case '-':
                return 1;
            default:
                return 0;
        }
    }

    public static String infix2postfix(String infix){

        StackChar stack = new StackChar(infix.length());
        infix = '('+infix+')';
        String postfix = "";

        for (int i = 0; i < infix.length(); i++){
            char op = infix.charAt(i);

            if (isOporator(op)) {
                while((!stack.isEmpty())&&(precedence(stack.peek()) >= precedence(op))){

                    postfix += stack.peek();
                    stack.pop();

                }
                stack.push(op);
                }
            else if (op == '('){
                stack.push(op);
            }
            else if (op == ')'){
                while (stack.peek() != '(') {
                    postfix += stack.peek();
                    stack.pop();
                }
                stack.pop();
            }
            else{
                //Add op to postfix string
                postfix += op;
            }
        }
        return postfix;
    }

    public static int evalPostfixFunc(String postfix){
        
        Stack stack = new Stack(postfix.length());

        for(int i = 0; i < postfix.length(); i++){
            char op = postfix.charAt(i);
            if(isOporator(op)){
                int num2 = stack.peek();
                stack.pop();

                int num1 = stack.peek();
                stack.pop();

                switch (op){
                    case '+':
                        stack.push(num1 + num2);
                        break;
                    case '-':
                        stack.push(num1 - num2);
                        break;
                    case '*':
                        stack.push(num1 * num2);
                        break;
                    case '/':
                        stack.push(num1 / num2);
                        break;
                    default:
                        int ans = 1;
                        for(int j = 0; j < num2; j++){
                            ans *= num1;
                        }
                        stack.push(ans);
                        break;
                }
            }
            else{
                 //ASCII conversion char -> int
                stack.push(op - 48);
            }
        }
        return stack.peek();
    }
}
