package com.rbnico.views;

import com.rbnico.controllers.Controller;
import com.rbnico.controllers.TeacherController;

import java.util.Scanner;

public class TeacherEdit implements EditEntities{
    Scanner scanner = new Scanner(System.in);
    Controller controller = new TeacherController();
    @Override
    public void create() {
        String[] entity = new String[4];
        System.out.println("Introduce el ID del profesor que quieres añadir");
        entity[0] = scanner.nextLine();
        System.out.println("Ahora introduce el nombre");
        entity[1] = scanner.nextLine();
        System.out.println("Introduce el nº de Seg Social del profesor");
        entity[2] = scanner.nextLine();
        System.out.println("Introduce el salario del profesor (utiliza punto para los decimales)");
        entity[3] = scanner.nextLine();

        controller.create(entity);
    }

    @Override
    public void find() {
    }

    @Override
    public void update() {
        String[] entity = new String[4];
        System.out.println("Introduce el ID del profesor que quieres editar");
        entity[0] = scanner.nextLine();
        System.out.println("Introduce el nuevo nombre");
        entity[1] = scanner.nextLine();
        System.out.println("Introduce el nuevo nº de Seg Social del profesor");
        entity[2] = scanner.nextLine();
        System.out.println("Introduce el nuevo salario del profesor (utiliza punto para los decimales)");
        entity[3] = scanner.nextLine();

        controller.update(entity);
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
        System.out.println("Introduce a partir de qué salario (sin decimales) quieres mostrar los registros");
        maxMin[0] = scanner.nextLine();
        System.out.println("Introduce el valor máximo de salario de los registros a mostrar ");
        maxMin[1] = scanner.nextLine();
        String[][] entities = (String[][]) controller.findBy(maxMin);
        for (int i = 0; i < entities.length; i++) {
            for (int j = 0; j < entities[i].length; j++) {
                System.out.println(entities[i][j]);
            }
        }
    }
}
