package com.rbnico.views;

import java.util.Scanner;

public class MainView {
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;
    public MainView(){
        while(!exit){ menu();}
    }


    void menu() {
        System.out.println("Indica con qué registros quieres trabajar:");
        System.out.println("1.- Profesores");
        System.out.println("2.- Alumnos");
        System.out.println("3.- SALIR DEL PROGRAMA");
        String option = scanner.nextLine();
        if("1".equals(option)) {
            EntitiesView entitiesView = new EntitiesView(1);
        } else if("2".equals(option)) {
            EntitiesView entitiesView = new EntitiesView(2);
        } else if("3".equals(option)) {
            exit = true;
        } else {
            System.out.println("\n\nHa habido un error\n\n");
        }
    }
}