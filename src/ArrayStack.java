public class ArrayStack<T> {
    private final T [] arr;
    private int top;

    public ArrayStack(int capacity) {
        arr = (T[]) new Object[capacity];
        top = -1;
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public boolean isFull() {
        if(top == arr.length - 1) return true;
        return false;
    }
    public void push(T value){
        if (isFull()){
            throw new StackException("Stack is full");
        }
        arr[++top] = value;
    }
    public void pop(){
        if(isEmpty()){
            throw new StackException("Stack is empty");
        }
        top--;
    }
    public T top(){
        if(isEmpty()){
            throw new StackException("Stack is empty");
        }
        return arr[top];
    }
    public T topAndPop(){
        if (isEmpty()){
            throw new StackException("Stack is empty");
        }
        return arr[top--];
    }
}
class StackException extends RuntimeException {
    public StackException(String message) {
        super(message);
    }
}
class InfixToPostfix {
    public static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }
    public static String infixToPostfix(String expr) {
        ArrayStack<Character> stack = new ArrayStack<>(expr.length());
        StringBuilder output = new StringBuilder();

        for(int i = 0; i<expr.length();i++){
            char c = expr.charAt(i);

            if(Character.isLetterOrDigit(c)){
                output.append(c);
            } else if (c == '('){
                stack.push(c);
            } else if (c == ')'){
                while(!stack.isEmpty() && stack.top() != '('){
                    output.append(stack.topAndPop());
                }
                if(!stack.isEmpty() && stack.top() != '('){
                    return "Invalid Expression";
                } else {
                    stack.pop();
                }
            } else if (isOperator(c)){
                while(!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.top())){
                    output.append(stack.topAndPop());
                }
                stack.push(c);

            }
        }
        while (!stack.isEmpty()){
            output.append(stack.topAndPop());
        }
        return output.toString();

    }
    //public static void main(String[] args) {
    //String infixExpr = "a+b*(c^d-e)^(f+g*h)-i";
    //String postfixExpr = infixToPostfix(infixExpr);
    // System.out.println("Infix Expression: " + infixExpr);
    //   System.out.println("Postfix Expression: " + postfixExpr);
    //}
}
class Postfix{
    public static int evaluatePostfix(String expr) {
        ArrayStack<Integer> stack = new ArrayStack<>(expr.length());

        for(char c: expr.toCharArray()){
            if(Character.isDigit(c)){
                stack.push(c - '0');
            } else if (InfixToPostfix.isOperator(c)) {
                int b = stack.topAndPop();
                int a = stack.topAndPop();

                switch (c) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                    case '^':
                        stack.push((int) Math.pow(a, b));
                        break;
                    default:
                        throw new StackException("Invalid operator: " + c);
                }

            }
        }
        return stack.topAndPop();
    }
    public static void main(String[] args) {
        String infixExpr = "3+5*2*(6+3)-9";
        String postfixExpr = InfixToPostfix.infixToPostfix(infixExpr);
        System.out.println(infixExpr);
        int result = evaluatePostfix(postfixExpr);
        System.out.println("Postfix Expression: " + postfixExpr);
        System.out.println("Evaluated Result: " + result);
    }
}
//TODO: postfix to infix
