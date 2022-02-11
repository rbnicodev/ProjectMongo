import com.rbnico.models.Teacher;
import com.rbnico.repositories.Repository;
import com.rbnico.repositories.TeachersRepository;
import com.rbnico.repositories.TeachersRepositoryODB;
import org.junit.jupiter.api.Test;

public class TeacherRepoTest {
    Repository repository = new TeachersRepositoryODB();
    @Test
    public void testFindAll(){
        repository.findAll().forEach(System.out::println);
    }
    @Test
    public void testCreate(){
        Teacher teacher = new Teacher();
        teacher.setId(4);
        teacher.setName("Rigodolfo");
        teacher.setLastname("Alonso");
        teacher.setSegSocial(23423);
        teacher.setSalary(3543);

        repository.create(teacher);
    }
    @Test
    public void testFind(){
        System.out.println(repository.find(1));
    }
    @Test
    public void testDelete(){
        repository.delete(10);
    }
    @Test
    public void testUpdate(){
        Teacher teacher = (Teacher)repository.find(1);
        teacher.setSalary(12);
        repository.update(teacher);
    }
    @Test
    public void testFindBy(){
        repository.findBy(1600, 1700).forEach(System.out::println);
    }


}
