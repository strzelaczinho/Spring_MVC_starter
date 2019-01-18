package adam.projekty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    // http://localhost:8080/Spring-01-todo-list/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    // http://localhost:8080/Spring-01-todo-list/welcome
    @GetMapping("welcome")//tutaj zwraca nazwe mapowania prefix+name+suffix z pliku web-inf .../welcome.jsp
    public String welcome()
    {
        return "welcome"; //welcome zwraca jsp plik
    }
}