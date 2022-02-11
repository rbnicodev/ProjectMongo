package com.rbnico.views;

import com.rbnico.controllers.Controller;
import com.rbnico.controllers.StudentController;
import com.rbnico.controllers.TeacherController;
import com.rbnico.models.*;
import com.rbnico.repositories.*;

import java.util.List;
import java.util.Scanner;

public class EntitiesView {
    Scanner scanner = new Scanner(System.in);
    Controller controller;
    EditEntities editor;
    int type;
    boolean exit = false;
    String sENTITIES = "";
    String sEntity = "";
    EntityModel entity;


    public EntitiesView() {
    }

    public EntitiesView(int type) {
        this.type = type;
        init();
        while (!exit) menu();
    }

    void init() {
        if (type == 1) {
            controller = new TeacherController();
            sENTITIES = "PROFESORES";
            sEntity = "profesor";
            entity = new Teacher();
            editor = new TeacherEdit();
        } else {
            controller = new StudentController();
            sENTITIES = "ALUMNOS";
            sEntity = "alumno";
            entity = new Student();
            editor = new StudentEdit();
        }
    }

    void menu() {
        System.out.println("\n\n" + sENTITIES + "\n\n");
        System.out.println("Indica qué quieres hacer");
        System.out.println("0.- Introducir un registro");
        System.out.println("1.- Visualizar un registro");
        System.out.println("2.- Modificar un registro");
        System.out.println("3.- Borrar un registro");
        System.out.println("4.- Mostrar todos los registros");
        System.out.println("5.- Mostrar con filtro");
        System.out.println("6.- SALIR AL MENÚ PRINCIPAL");
        String option = scanner.nextLine();
        if("0".equals(option)) {
            editor.create();
        }
        else if ("1".equals(option)) {
            System.out.println("Introduce el ID del registro que quieres visualizar");
            int id;
            String[] entity = null;
            try {
                id = Integer.parseInt(scanner.nextLine());
                entity = (String[])controller.find(id);
                for (int i = 0; i < entity.length; i++) {
                    System.out.println(entity[i]);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else if ("2".equals(option)) {
            editor.update();
        } else if ("3".equals(option)) {
            System.out.println("Introduce el ID del registro que quieres eliminar");
            try {
                int id = Integer.parseInt(scanner.nextLine());
                controller.delete(id);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Ha habido algún problema");
            }
        } else if ("4".equals(option)) {
            String[][] entities = (String[][]) controller.findAll();
            for (int i = 0; i < entities.length; i++) {
                System.out.println('\n');
                for (int j = 0; j < entities[i].length; j++) {
                    System.out.print(entities[i][j] + ", ");
                }
            }
        } else if ("5".equals(option)) {
            editor.findWithFilter();
        } else if ("6".equals(option)) {
            exit = true;
        } else {
            System.out.println("Ha habido algún error");
        }
    }
}