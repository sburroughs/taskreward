import com.dsburroughs.rewardbot.App;
import com.dsburroughs.rewardbot.model.Task;
import com.dsburroughs.rewardbot.model.TaskStatus;
import com.dsburroughs.rewardbot.repository.TaskRepository;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes={App.class})
public class Test {

    @Autowired
    private TaskRepository repository;

    @org.junit.Test
    public void test() {

        Task task = new Task(0, "yeah", 20, TaskStatus.CREATED);
        repository.save(task);

        List<Task> tasks = repository.findByStatusIn(Arrays.asList(TaskStatus.CREATED, TaskStatus.IN_PROGRESS));
        Assert.assertThat(tasks.size(), Matchers.is(1));

    }

}
