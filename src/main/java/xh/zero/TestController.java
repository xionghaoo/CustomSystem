package xh.zero;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @ResponseBody
    @RequestMapping("/")
    public String home() {
        return "Hello, home";
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello, Test";
    }
}
