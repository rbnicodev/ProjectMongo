package com.rbnico.views;

import com.rbnico.models.*;
import com.rbnico.repositories.Repository;
import com.rbnico.repositories.StudentRepository;
import com.rbnico.repositories.TeacherRepository;

import java.util.List;
import java.util.Scanner;

public class EntitiesView {
    Scanner scanner = new Scanner(System.in);
    Repository repository;
    int type;
    boolean exit = false;
    String sENTITIES = "";
    String sEntity = "";
    EntityModel entity;


    public EntitiesView() {}
    public EntitiesView(int type) {
        this.type = type;
        init();
        while(!exit) menu();
    }

    void init() {
        if (type == 1) {
            repository = new TeacherRepository();
            sENTITIES = "PROFESORES";
            sEntity = "profesor";
            entity = new TeacherModel();
        }
        else {
            repository = new StudentRepository();
            sENTITIES = "ALUMNOS";
            sEntity = "alumno";
            entity = new StudentModel();
        }
    }

    void menu() {
        System.out.println("\n\n" + sENTITIES + "\n\n");
        System.out.println("Indica qué quieres hacer");
        System.out.println("1.- Buscar un registro");
        System.out.println("2.- Modificar un registro");
        System.out.println("3.- Borrar un registro");
        System.out.println("4.- Mostrar todos los registros");
        System.out.println("5.- SALIR AL MENÚ PRINCIPAL");
        String option = scanner.nextLine();
        if("1".equals(option)) {
            find();
        } else if("2".equals(option)) {
            update();
        } else if("3".equals(option)) {
            delete();
        } else if("4".equals(option)) {
            findAll();
        } else if("5".equals(option)) {
            exit = true;
        } else {
            System.out.println("Ha habido algún error");
        }
    }

    void find() {
        System.out.println("Introduce el id del " + sEntity + " que quieres buscar");
        String sId = scanner.nextLine();
        boolean number = false;
        Long id = -1L;
        try { id = Long.parseLong(sId); number = true; } catch (NumberFormatException e) { System.out.println("EntitiesView.update(), "+e.getMessage());}

        if(type == 1) {
            TeacherModel teacher = (TeacherModel)repository.find(id);
            if (teacher != null) {
                System.out.println("Nombre: " + teacher.getName());
                System.out.println("Apellido: " + teacher.getLastName());
            }
        } else {
            StudentModel student = (StudentModel)repository.find(id);
            if(student != null) {
                System.out.println("Nombre: " + student.getName());
                System.out.println("Apellido: " + student.getLastName());
                System.out.println("Edad: " + student.getAge());
            }
        }
    }

    void update() {
        System.out.println("Introduce el ID del registro que quieres actualizar: ");
        String sId = scanner.nextLine();
        boolean number = false;
        Long id = -1L;
        try { id = Long.parseLong(sId); number = true; } catch (NumberFormatException e) { System.out.println("EntitiesView.update(), "+e.getMessage());}
        EntityModel oldEntity = (EntityModel) repository.find(id);
        if(number && oldEntity != null)
        {
//            System.out.println("Introduce el nuevo nombre: ");
//            String newName = scanner.nextLine();
//
//            System.out.println("Introduce el nuevo apellido: ");
//            String newLastName = scanner.nextLine();
//            int age;
//            if(type == 2) {
//                System.out.println("Introduce la edad del alumno:");
//                String iage = scanner.nextLine();
//                try {age = Integer.parseInt(iage);} catch (NumberFormatException e) { System.out.println(e.getMessage()); age = 0;}
//                repository.update(new StudentModel(newName, newLastName, age));
//            }
//            repository.update(new TeacherModel(newName, newLastName));
        } else { System.out.println("Ha habido algún error");

    }}

    void delete() {
        System.out.println("Introduce el nombre del registro que quieres actualizar: ");
        String name = scanner.nextLine();
        repository.delete(name);
    }

    void findAll() {
        List<EntityModel> entities = repository.findAll();
        if(type == 1) {
            for (EntityModel e : entities) {
                TeacherModel t = (TeacherModel)e;
                System.out.println("Nombre: \t" + t.getName());
                System.out.println("Apellido: \t" + t.getLastName());
            }
        } else if(type == 2) {
            for (EntityModel e : entities) {
                StudentModel t = (StudentModel)e;
                System.out.println("Nombre: \t" + t.getName());
                System.out.println("Apellido: \t" + t.getLastName());
                System.out.println("Edad: \t" + t.getAge());
            }
        }
    }


}
