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
        } else {
            controller = new StudentController();
            sENTITIES = "ALUMNOS";
            sEntity = "alumno";
            entity = new Student();
        }
    }

    void menu() {
        System.out.println("\n\n" + sENTITIES + "\n\n");
        System.out.println("Indica qué quieres hacer");
        System.out.println("0.- Introducir un registro");
        System.out.println("1.- Buscar un registro");
        System.out.println("2.- Modificar un registro");
        System.out.println("3.- Borrar un registro");
        System.out.println("4.- Mostrar todos los registros");
        System.out.println("5.- Mostrar con filtros");
        System.out.println("6.- SALIR AL MENÚ PRINCIPAL");
        String option = scanner.nextLine();
        if("0".equals(option)) {
            controller.create();
        }
        else if ("1".equals(option)) {
            controller.find();
        } else if ("2".equals(option)) {
            controller.update();
        } else if ("3".equals(option)) {
            controller.delete();
        } else if ("4".equals(option)) {
            controller.findAll();
        } else if ("5".equals(option)) {
            controller.findBy();
        } else if ("6".equals(option)) {
            exit = true;
        } else {
            System.out.println("Ha habido algún error");
        }
    }
}