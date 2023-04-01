package AISS.restClient.service;

import AISS.restClient.model.commits.Commit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import utils.RestUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    public List<Commit[]> findAllCommits(String token, String owner, String repo){
        List<Commit[]> commitsPerPage = new ArrayList<>();
        String uri = gitUri + "/" + owner + "/" + repo + "/commits";
        HttpHeaders headers =  new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<Commit[]> request = new HttpEntity<>(null, headers);
        ResponseEntity<Commit[]> response =  restTemplate.exchange(uri, HttpMethod.GET, request, Commit[].class);

        //Adding first page of commits
        Commit[] commitPage = Arrays.stream(response.getBody()).toList().toArray(new Commit[0]);
        commitsPerPage.add(commitPage);

        //Adding the remaining pages
        while(RestUtils.getNextPageUrl(response.getHeaders()) != null){
            String url = RestUtils.getNextPageUrl(response.getHeaders());
            response =  restTemplate.exchange(url,HttpMethod.GET,request,Commit[].class);
            commitPage = Arrays.stream(response.getBody()).toList().toArray(new Commit[0]);
            commitsPerPage.add(commitPage);
        }

        Integer pages = commitsPerPage.size();
        System.out.println("Numer of pages :" + pages);
        return commitsPerPage;
    }

}
