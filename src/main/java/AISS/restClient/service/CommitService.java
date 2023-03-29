package AISS.restClient.service;

import AISS.restClient.model.commits.Commit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CommitService {
    @Autowired
    RestTemplate restTemplate;
    final String gitUri = "https://api.github.com/repos";

    public List<Commit> findAllCommitsWithoutAuth(String owner, String repo){
        Commit[] commits = restTemplate.getForObject(gitUri + "/" + owner + "/" + repo + "/commits",Commit[].class);
        return Arrays.stream(commits).toList();
    }

    public List<Commit> findAllCommits(String token, String owner, String repo){
        String uri = gitUri + "/" + owner + "/" + repo + "/commits";
        HttpHeaders headers =  new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<Commit[]> request = new HttpEntity<>(null, headers);
        ResponseEntity<Commit[]> response =  restTemplate.exchange(uri, HttpMethod.GET, request, Commit[].class);
        return Arrays.stream(response.getBody()).toList();
    }

}
