package AISS.restClient.service;

import AISS.restClient.model.commits.Commit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommitServiceTest {
    @Autowired
    CommitService service;
    @Test
    @DisplayName("Get all commits")
    void findAllCommits(){
        List<Commit> commits = service.findAllCommits("Mastercard","client-encryption-java");
        assertTrue(!commits.isEmpty());
        System.out.println(commits);
    }


}