package AISS.restClient.service;

import AISS.restClient.model.User;
import AISS.restClient.model.UserSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {
    @Autowired
    RestTemplate restTemplate;
    final String usersUri = "https://reqres.in/api/users";

    public List<User> findAllUsers(){
        List<User> users = null;
        UserSearch userSearch = restTemplate.getForObject(usersUri,UserSearch.class);
        users = userSearch.getData();
        return users;
    }

    public User findUser(Integer id){
        List<User> users = null;
        UserSearch userSearch = restTemplate.getForObject(usersUri, UserSearch.class);
        users  = userSearch.getData();
        User user =  users.stream().filter(x -> x.getId() == id).toList().get(0);
        return user;
    }


}
