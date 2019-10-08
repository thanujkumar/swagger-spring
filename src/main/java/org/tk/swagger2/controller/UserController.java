package org.tk.swagger2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tk.swagger2.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Api(value = "UserController", description = "Swagger2 REST API for user")
@RestController
public class UserController {
    private List<User> userList = new ArrayList<>();

    {
        userList.add(new User("Test1", 10, "India"));
        userList.add(new User("Test2", 20, "Sweden"));
        userList.add(new User("Test2", 30, "Norway"));
    }

    @ApiOperation(value = "Get list of users", response = Iterable.class, tags = "users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|Ok"),
            @ApiResponse(code = 401, message = "Not Authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @RequestMapping(value = "/users")
    public List<User> getUsers() {
        return userList;
    }


    @ApiOperation(value = "Get specific user by name", response = User.class, tags = "user")
    @RequestMapping(value = "/users/{name}", method = RequestMethod.GET)
    public User getUser(@PathVariable(value = "name") String name) {
        return userList.stream().filter(x -> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
    }

    @ApiOperation(value = "Get specific user by country ", response = User.class, tags = "users/country")
    @RequestMapping(value = "/users/country/{country}")
    public List<User> getUserByCountry(@PathVariable(value = "country") String country) {
        List<User> userByCountry = userList.stream().filter(x -> x.getCountry().equalsIgnoreCase(country))
                .collect(Collectors.toList());
        return userByCountry;
    }
}
