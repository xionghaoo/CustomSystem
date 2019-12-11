package xh.zero.site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

@Controller
public class LoginController {

    @Inject
    private User user;

    @ResponseBody
    @RequestMapping({"/", "/home", "/dashboard"})
    public String home() {
        return "Home";
    }

    @ResponseBody
    @RequestMapping(value = "/", params = "name")
    public String greeting(@RequestParam("name") String name) {
        user.setName(name);
        return "hello, " + user.getName();
    }

}
