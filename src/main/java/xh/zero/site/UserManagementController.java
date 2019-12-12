package xh.zero.site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Hashtable;
import java.util.Map;

@Controller
public class UserManagementController {

    private final Map<Long, User> userDatabase = new Hashtable<>();

//    {
//        long userId = getNextUserId();
//        userDatabase.put(userId, new User(userId, "John", 20));
//        userId = getNextUserId();
//        userDatabase.put(userId, new User(userId, "Alice", 18));
//    }

    private volatile long userIdSequence = 0;

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public String displayUsers(Map<String, Object> model) {
        model.put("users", userDatabase);
        return "user/list";
    }

    @RequestMapping(value = "user/add", method = RequestMethod.GET)
    public String addUser(Map<String, Object> model) {
        model.put("userForm", new UserForm());
        return "user/add";
    }

    @RequestMapping(value = "user/add", method = RequestMethod.POST)
    public View addUser(UserForm userForm) {
        User user = new User();
        user.setId(getNextUserId());
        user.setAge(userForm.getAge());
        user.setName(userForm.getUsername());
        userDatabase.put(user.getId(), user);
        return new RedirectView("/user/list", true, false);
    }

    @RequestMapping(value = "user/edit/{userId}", method = RequestMethod.GET)
    public String editUser(@PathVariable("userId") long userId, Map<String, Object> model) {
        User user = userDatabase.get(userId);
        UserForm userForm = new UserForm();
        userForm.setUsername(user.getName());
        userForm.setAge(user.getAge());
        model.put("userForm", userForm);
        return "user/edit";
    }

    @RequestMapping(value = "user/edit/{userId}", method = RequestMethod.POST)
    public View editUser(@PathVariable("userId") long userId, UserForm userForm) {
        User user = userDatabase.get(userId);
        user.setName(userForm.getUsername());
        user.setAge(userForm.getAge());
       return new RedirectView("/user/list", true, false);
    }

    private synchronized long getNextUserId() {
        return userIdSequence++;
    }

}
