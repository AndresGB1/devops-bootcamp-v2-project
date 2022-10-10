package view;

import java.util.Scanner;

public class View {
    private Scanner sc;

    public View() {
        this.sc = new Scanner(System.in);
    }

    public void showMenu(String schoolName) {
        System.out.println("=============================");
        System.out.println("Welcome to " + schoolName);
        System.out.println("=============================");

        System.out.println("Select your role please: ");
        System.out.println("1. Teacher");
        System.out.println("2. Student");
    }
    public String getString(){
        return sc.nextLine();
    }
    public void showMessage(String message){
        System.out.println(message);
    }
}
