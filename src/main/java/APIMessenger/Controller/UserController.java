package APIMessenger.Controller;
import APIMessenger.Converter.ConverterInterface;
import APIMessenger.Model.User;
import APIMessenger.Request.UserRequest;
import APIMessenger.Response.UserWrapper;
import APIMessenger.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE
)

public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    //@Qualifier("UserConverter")
    ConverterInterface userConverter;

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

    @RequestMapping(value = "/users/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<UserWrapper>> getByName(@RequestParam("name") String name){
        List<User> users = userService.getByName(name);
        if(users != null)
            return new ResponseEntity<List<UserWrapper>>(userConverter.listConverter(users), HttpStatus.OK);
        else
            return new ResponseEntity<List<UserWrapper>>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping("/users/")
    public @ResponseBody ResponseEntity<List<UserWrapper>> getAll(){
        List<User> users = userService.getAll();
        if(users != null)
            return new ResponseEntity<List<UserWrapper>>(userConverter.listConverter(users), HttpStatus.OK);
        else
            return new ResponseEntity<List<UserWrapper>>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/users/", method = RequestMethod.POST ,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addUser (@RequestBody UserRequest u){
        try{
            if(u.getPassword().equals(u.getPassword_confirm())) {
                userService.newUser(u.getName(), u.getSurname(), u.getAddress(), u.getTelephone(), u.getCity(), u.getProvince(), u.getCountry(), u.getPassword());
                return new ResponseEntity(HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
            }
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable("id") int id){
        try{
            userService.deleteUser(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
