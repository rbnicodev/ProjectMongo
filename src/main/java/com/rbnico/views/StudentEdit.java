package com.rbnico.views;

import com.rbnico.controllers.Controller;
import com.rbnico.controllers.StudentController;

import java.util.Scanner;

public class StudentEdit implements EditEntities{
    Scanner scanner = new Scanner(System.in);
    Controller controller = new StudentController();
    @Override
    public void create() {
        String[] entity = new String[4];
        System.out.println("Introduce el ID del alumno que quieres añadir");
        entity[0] = scanner.nextLine();
        System.out.println("Ahora introduce el nombre");
        entity[1] = scanner.nextLine();
        System.out.println("Introduce el apellido");
        entity[2] = scanner.nextLine();
        System.out.println("Introduce la edad del alumno");
        entity[3] = scanner.nextLine();

        controller.create(entity);
    }

    @Override
    public void find() {

    }

    @Override
    public void update() {
        String[] entity = new String[4];
        System.out.println("Introduce el ID del alumno que quieres editar");
        entity[0] = scanner.nextLine();
        System.out.println("Ahora introduce el nuevo nombre");
        entity[1] = scanner.nextLine();
        System.out.println("Introduce el nuevo apellido");
        entity[2] = scanner.nextLine();
        System.out.println("Introduce la nueva edad del alumno");
        entity[3] = scanner.nextLine();

        controller.create(entity);
    }

    @Override
    public void delete() {

    }

    @Override
    public void findAll() {

    }

    @Override
    public void findWithFilter() {
        String[] maxMin = new String[2];
        System.out.println("Introduce a partir de qué edad quieres mostrar los registros");
        maxMin[0] = scanner.nextLine();
        System.out.println("Introduce la edad máxima de los registros a mostrar ");
        maxMin[1] = scanner.nextLine();
        String[][] entities = (String[][]) controller.findBy(maxMin);
        for (int i = 0; i < entities.length; i++) {
            for (int j = 0; j < entities[i].length; j++) {
                System.out.println(entities[i][j]);
            }
        }
    }
}
