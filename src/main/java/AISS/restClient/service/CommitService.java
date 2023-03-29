package AISS.restClient.service;

import AISS.restClient.model.commits.Commit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CommitService {
    @Autowired
    RestTemplate restTemplate;
    final String gitUri = "https://api.github.com/repos";

    public List<Commit> findAllCommits(String owner, String repo){
        Commit[] commits = restTemplate.getForObject(gitUri + "/" + owner + "/" + repo + "/commits",Commit[].class);
        return Arrays.stream(commits).toList();
    }

}
