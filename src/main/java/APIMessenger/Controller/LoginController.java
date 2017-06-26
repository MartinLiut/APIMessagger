package APIMessenger.Controller;
import APIMessenger.Model.User;
import APIMessenger.Response.LoginResponse;
import APIMessenger.Response.UserWrapper;
import APIMessenger.Services.UserService;
import APIMessenger.util.AuthenticationData;
import APIMessenger.util.SessionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        value = "/",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class LoginController {

    @Autowired
    SessionData sessionData;

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationData aData;

    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<LoginResponse> login(@RequestParam("name") String name, @RequestParam("password") String password){
        User user = userService.login(name, password);
        if(user != null){
            String sessionId = sessionData.addSession(user);
            UserWrapper userWrapper = new UserWrapper(user.getName(), user.getSurname(), user.getAddress(), user.getTelephone(), user.getCity(), user.getProvince(), user.getCountry());
            return new ResponseEntity<LoginResponse>(new LoginResponse(sessionId), HttpStatus.OK);
        }
        else
            return new ResponseEntity<LoginResponse>(HttpStatus.FORBIDDEN);
    }

    @RequestMapping("/logout/")
    public @ResponseBody ResponseEntity getById(@RequestHeader("sessionid") String sessionId) {
        sessionData.removeSession(sessionId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
