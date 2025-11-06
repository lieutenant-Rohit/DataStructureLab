import java.util.Scanner;

class Stack{
   Scanner sc = new Scanner(System.in);
   int[] arr = new int[5];
   int top = -1;

   public void push()
   {
       if(top == arr.length-1)
       {
           System.out.println("Stack Is Full!......");
           return;
       }
       System.out.print("Enter Number to push:- ");
       int no = sc.nextInt();
       arr[++top] = no;
   }

   public  void pop()
   {
       if(top == -1)
       {
           System.out.println("Stack is Empty :(((");
           return;
       }
       System.out.println("Popping Element from top "+top);
       System.out.println("Element Popped:- "+ arr[top]);
       top--;
   }

   public void peek()
   {
       System.out.println("Element at Top:- "+ arr[top]);
   }
   public void display()
   {
       for (int j : arr) {
           System.out.print(j + " ");
       }
   }
}

public class StackDemo
{
    public static void main(String[] args) {
        Stack s1 = new Stack();
        boolean isTrue = true;
        while (isTrue) {
            Scanner sc = new Scanner(System.in);
            System.out.println("1---> Push");
            System.out.println("2---> Pop");
            System.out.println("3---> Peek");
            System.out.println("4---> Display");
            System.out.println("5---> EXIT");
            int ch = sc.nextInt();
            if (ch == 1) {
                s1.push();
            } else if (ch == 2) {
                s1.pop();
            } else if (ch == 3) {
                s1.peek();
            } else if (ch == 4) {
                s1.display();
            } else if (ch == 5) {
                isTrue = false;
            } else {
                System.out.println("Wrong Choice Input");
            }
        }
    }
}