public class App {
    public static void main(String[] args) throws Exception {
//         test();
//         zad2();
//         zad3();
//         zad4();
//        zamiana();
    }

    public static void zad2() {
        Stos<Character> stos = new Stos<Character>();
        String correct = "( ( ) (( )) )";
        String inCorrect = ")())))";
        String inCorrect2 = "(()";

        checkCorrectBracket(correct, stos);
        checkCorrectBracket(inCorrect, stos);
        checkCorrectBracket(inCorrect2, stos);

    }

    public static void checkCorrectBracket(String correct, Stos<Character> stos) {

        boolean allString = true;

        for (int i = 0; i < correct.length(); i++) {
            if (correct.charAt(i) == '(')
                stos.push(correct.charAt(i));
            else if (correct.charAt(i) == ')')
            {
                if(stos.pop() == null)
                {
                    allString = false;
                    break;
                }

            }

        }
        System.out.println("Ciąg: " + correct + (stos.isEmpty() && allString? " jest " : " nie jest ") + "poprawny");
        stos.clear();
    }

    public static void zad3() {
        Stos<Character> stos = new Stos<Character>();
        String palindrome = "sedes";
        String notPalindrome = "jakieśsłowo";

        CheckPalindrome(palindrome, stos);
        CheckPalindrome(notPalindrome, stos);
    }

    public static void CheckPalindrome(String palindrome, Stos<Character> stos) {
        for (int i = 0; i < palindrome.length(); i++) {
            stos.push(palindrome.charAt(i));
        }

        int i = 0;
        boolean isPalindrome = true;
        Character element = 'a';
        while (element != null) {
            element = stos.pop();
            if (element != null) {
                if (element != palindrome.charAt(i)) {
                    isPalindrome = false;
                    break;
                }
                i++;
            }
        }

        System.out.println(palindrome + (isPalindrome ? " jest " : " nie jest ") + "palindromem");
        stos.clear();
    }

    public static void zad4() {
        Stos<Integer> stos = new Stos<Integer>();
        String wyrazenie = "52+7*";
        for (int i = 0; i < wyrazenie.length(); i++) {
            int element = Character.getNumericValue(wyrazenie.charAt(i));
            if (element != -1)
                stos.push(element);
            else {
                int second = stos.pop();
                int first = stos.pop();
                int result = 0;
                switch (wyrazenie.charAt(i)) {
                    case '+':
                        result = first + second;
                        break;
                    case '-':
                        result = first - second;
                        break;
                    case '*':
                        result = first * second;
                        break;
                    case '/':
                        result = first / second;
                        break;
                }
                stos.push(result);
            }
        }
        System.out.println("Wynikiem działania: " + wyrazenie + " jest: " + stos.pop());
    }

    public static int priorityOfCharacter(char element) {
        if (element == '*' || element == '/')
            return 2;
        return 1;
    }

    public static void zamiana() {
        String wyrazenie = "(5+2)*7";
        Stos<Operator> operatorStack = new Stos<Operator>();
        Stos<Operator> postfixStack = new Stos<Operator>();
        for (int i = 0; i < wyrazenie.length(); i++) {
            int element = Character.getNumericValue(wyrazenie.charAt(i));
            if (element != -1)
                postfixStack.push(new Operator(-1, wyrazenie.charAt(i)));
            else {
                if (wyrazenie.charAt(i) == '(')
                    operatorStack.push(new Operator(0, wyrazenie.charAt(i)));
                else if (wyrazenie.charAt(i) == ')') {
                    Operator temp = operatorStack.peek();
                    while (temp.element != '(') {
                        temp = operatorStack.pop();
                        if (temp.element != '(')
                            postfixStack.push(temp);
                    }
                    operatorStack.pop();
                } else {
                    Operator temp = operatorStack.peek();
                    int priority = priorityOfCharacter(wyrazenie.charAt(i));
                    if (temp == null || priority > temp.priority) {
                        operatorStack.push(new Operator(priority, wyrazenie.charAt(i)));
                    } else {
                        postfixStack.push(operatorStack.pop());
                        do {

                            temp = operatorStack.pop();
                            if (temp == null)
                                break;
                            if (priority > temp.priority) {
                                break;
                            } else {
                                postfixStack.push(temp);
                            }
                        } while (temp != null);
                        operatorStack.push(new Operator(priority, wyrazenie.charAt(i)));
                    }
                }
            }
        }

        Operator change = operatorStack.peek();
        while (change != null) {
            change = operatorStack.pop();
            if (change != null)
                postfixStack.push(change);
        }
        postfixStack.print(false);
    }

    public static void test() {
        Stos<Integer> stos = new Stos<Integer>();
        stos.push(10);
        stos.push(11);
        stos.push(12);
        stos.push(13);
        stos.push(14);
        stos.push(15);
        stos.print(true);
        System.out.println();
        System.out.println("Peek: " + stos.peek());
        System.out.println("Pop: " + stos.pop());
        System.out.println("Pop: " + stos.pop());
        System.out.println("Pop: " + stos.pop());
        System.out.println("Pop: " + stos.pop());
        System.out.println("Pop: " + stos.pop());
        System.out.println("Pop: " + stos.pop());

        System.out.println("Pop: " + stos.pop());
        System.out.println("Peek: " + stos.peek());

        stos.push(10);
        stos.push(11);
        stos.push(12);
        stos.push(13);
        stos.push(14);
        stos.push(15);
        stos.print(true);
        stos.clear();
    }
}
