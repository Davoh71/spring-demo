package am.itspace.springdemo.controller;

import am.itspace.springdemo.model.User;
import am.itspace.springdemo.repository.UserReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserReposiroty userReposiroty;

    @GetMapping("/")
    public String homePage(ModelMap moduleMap) {
        List<User> all = userReposiroty.findAll();
        moduleMap.addAttribute("user",all);
        moduleMap.addAttribute("msg","Welcome");
        return "home";
    }

    @PostMapping("/addUser")
    public  String addUser(@ModelAttribute User user){
        userReposiroty.save(user);
        return "redirect:/";
    }
    @GetMapping("/about")
    public String aboutUsPage(){
        return "about";
    }

    @GetMapping("/deleteUse")
    public String deleteUser(@RequestParam("id") int id){
        userReposiroty.deleteById(id);
        return "redirect:/";
    }


}
