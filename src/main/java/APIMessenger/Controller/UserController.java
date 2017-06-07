package APIMessenger.Controller;
import APIMessenger.Model.User;
import APIMessenger.Response.UserWrapper;
import APIMessenger.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(
        value = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/users/{id}")
    public @ResponseBody ResponseEntity<UserWrapper> getById(@PathVariable("id") int id){
        User user = userService.getById(id);
        if(user != null){
            UserWrapper userWrapper = new UserWrapper(user.getName(), user.getSurname(), user.getAddress(), user.getTelephone(), user.getCity(), user.getProvince(), user.getCountry());
            return new ResponseEntity<UserWrapper>(userWrapper, HttpStatus.OK);
        }
        else
            return new ResponseEntity<UserWrapper>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping("/users/")
    public @ResponseBody ResponseEntity<List<UserWrapper>> getAll(){
        List<User> users = userService.getAll();
        if(users.size() > 0){
            return new ResponseEntity<List<UserWrapper>>(users, HttpStatus.OK);
        }
        else
            return new ResponseEntity<List<UserWrapper>>(HttpStatus.NOT_FOUND);
    }
}
