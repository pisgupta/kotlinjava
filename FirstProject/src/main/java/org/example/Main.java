package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    private int add(int i , int j){
        return i+j;
    }

    private int sub(int i , int j){
        return i-j;
    }

    private int mul(int i , int j){
        return i*j;
    }

    private int div(int i , int j){
        return i/j;
    }

    private int root(int i){
        return i*i;
    }


    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        Main m = new Main();
        System.out.println(m.add(10,23));
        System.out.println(m.sub(10,23));
        System.out.println(m.mul(10,23));
        System.out.println(m.div(10,10));
        System.out.println(m.root(55));
        System.out.println("Hi I'm doing good");

    }
}