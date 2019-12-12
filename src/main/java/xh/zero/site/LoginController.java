package xh.zero.site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.inject.Inject;
import java.util.Map;

@Controller
public class LoginController {

    @ResponseBody
    @RequestMapping({"/", "/home", "/dashboard"})
    public String home() {
        return "Home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin(Map<String, Object> model) {
        model.put("title", "abc");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public View login(LoginForm form) {
        System.out.println("username: " + form.getUsername());
        System.out.println("password: " + form.getPassword());
        return new RedirectView("/home", true);
    }

//    @RequestMapping(value = "/home", method = RequestMethod.GET)
//    @ModelAttribute("user")
//    public User userHome() {
//        user.setName("Haha");
//        System.out.println("loginX: " + user.getName());
//        return user;
//    }

    // 响应内容协商
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public User user(@PathVariable("userId") String userId) {
        User user = new User();
        user.setId(Long.parseLong(userId));
        user.setName("user1");
        user.setAge(20);
        return user;
    }

}
