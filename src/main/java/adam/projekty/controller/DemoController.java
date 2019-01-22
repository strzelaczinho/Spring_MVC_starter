package adam.projekty.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
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
    public String welcome(Model model)
    {
        model.addAttribute("user","Tim");//dodaje atrybut do modelu o nazwie user i wartosci Tim
        log.info("model = {}",model);
        return "welcome"; //welcome zwraca jsp plik
    }
    @ModelAttribute("welcomeMessage")   // to dziala tak samo jak model.addAtribute. Domyslnie mapowanie bedzie na stronie
    public String welcomeMessage()
    {
        log.info("welcomeMessage() zawolanie");
        return "To jest widok modelu z @ModelAttribute";
    }

    @GetMapping("test") // tutaj model tez zadziala bo jest mapowanie strony. Oraz ModelAttribute welcomeMessage jest zarejestronway jako bean bodaje
    public String test()
    {// wykona sie log.info w consoli jesli w test.jsp bede chcial zobaczyc zawartosc modelu ${welcomeMessage}
        return "test";
    }
}