package AISS.restClient.service;

import AISS.restClient.model.commits.Commit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommitServiceTest {
    @Autowired
    CommitService service;
    @Test
    @DisplayName("Get all commits without personal token authentication")
    void findAllCommitsWithoutAuth(){
        List<Commit> commits = service.findAllCommitsWithoutAuth("Mastercard","client-encryption-java");
        assertTrue(!commits.isEmpty());
        System.out.println(commits);
    }

    @Test
    @DisplayName("Get all commits with personal token authentication")

    void findAllCommits(){

        String token = "";
        Scanner scanner = new Scanner("token.txt");
        while (scanner.hasNextLine()) {
            token += scanner.nextLine();
        }
        scanner.close();
        List<Commit> commits = service.findAllCommits(token,"Mastercard","client-encryption-java");
        assertTrue(!commits.isEmpty());
        System.out.println(commits);

    }

}