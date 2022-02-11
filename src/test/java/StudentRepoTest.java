import com.rbnico.models.Student;
import com.rbnico.repositories.Repository;
import com.rbnico.repositories.StudentsRepository;
import com.rbnico.repositories.StudentsRepositoryODB;
import org.junit.jupiter.api.Test;

public class StudentRepoTest {
    Repository repository = new StudentsRepository();

    @Test
    public void testCreate() {

        Student student = new Student();
        student.setId(3);
        student.setName("Laureal");
        student.setAge(14);
        student.setLastname("Rodríguez");
        repository.create(student);

        testList();
    }

    @Test
    public void testFind() {
        System.out.println(repository.find(1));
    }

    @Test
    public void testList() {
        repository.findAll().forEach(System.out::println);
    }

    @Test
    public void testUpdate() {
        Student student = (Student)repository.find(2);
        student.setAge(9);
        repository.update(student);
        testList();
    }

    @Test
    public void testDelete() {
        repository.delete(1);
    }

    @Test
    public void testFindBy() {
        repository.findBy(12,16).forEach(System.out::println);
    }
}
