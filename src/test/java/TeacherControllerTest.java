import com.rbnico.controllers.Controller;
import com.rbnico.controllers.TeacherController;
import org.junit.jupiter.api.Test;

public class TeacherControllerTest {
    Controller controller = new TeacherController();
    @Test
    public void createTest(){
        String[] teacher = new String[4];
        teacher[0] = "1";
        teacher[1] = "Jacinta";
        teacher[2] = "97655";
        teacher[3] = "965";

        controller.create(teacher);
    }

    @Test
    public void deleteTest(){
        controller.delete(1);
    }

    @Test
    public void updateTest(){
        String[] teacher = (String[])controller.find(1);
        teacher[1] = "Laura";

        controller.update(teacher);

    }

    @Test
    public void findByTest(){
        String[] minMax = new String[2];
        minMax[0] = "2000"; minMax[1] = "4000";
        String[][] entities = (String[][]) controller.findBy(minMax);
        for (int i = 0; i < entities.length; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(entities[i][j]);
            }
        }

    }

    @Test void findTest(){
        String[] entity = (String[]) controller.find(1);
        for (int i = 0; i < entity.length; i++) {
            System.out.println(entity[i]);
        }
    }

    @Test void findAll(){
        String[][] entities = (String[][]) controller.findAll();
        for (int i = 0; i < entities.length; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(entities[i][j]);
            }
        }
    }
}
