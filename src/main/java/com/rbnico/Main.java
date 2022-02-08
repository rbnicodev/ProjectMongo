package com.rbnico;

import com.rbnico.models.TeacherModel;
import com.rbnico.repositories.TeacherRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el nombre del primer profesor a registrar");
        TeacherModel teacher = new TeacherModel();
        teacher.setName(scanner.nextLine());
        System.out.println("Introduce el apellido del profesor");
        teacher.setLastName(scanner.nextLine());
        TeacherRepository repository = new TeacherRepository();

        repository.insertOne(teacher);

        System.out.println("Introduce el nombre del segundo profesor a registrar");
        TeacherModel teacher2 = new TeacherModel();
        teacher2.setName(scanner.nextLine());
        System.out.println("Introduce el apellido del profesor");
        teacher2.setLastName(scanner.nextLine());

        repository.insertOne(teacher2);

        System.out.println("Ahora intenta borrar uno de esos dos introduciendo su nombre");

        repository.delete(scanner.nextLine());
    }
}
