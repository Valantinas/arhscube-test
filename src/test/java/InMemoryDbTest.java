import com.arhscube.test.ServiceApplication;
import com.arhscube.test.dao.model.User;
import com.arhscube.test.dao.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ServiceApplication.class)
public class InMemoryDbTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void givenUser_whenSave_thenGetOk() {
        List<User> all = userRepository.findAll();
        assertEquals("giuseppe", all.get(0).getFirstName());
    }
}