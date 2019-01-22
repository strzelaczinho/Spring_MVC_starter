package adam.projekty.controller;

import adam.projekty.Service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class ChallengeController {


    private final DemoService demoService;

    @Autowired
    public ChallengeController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("challenge")//tutaj zwraca nazwe mapowania
    public String challenge(Model model)
    {
        model.addAttribute("NazwaAtrybutu",demoService.getHelloMessage("Wiadomosc challengeMessage"));
        log.info("model = {}",model);
        return "challenge"; //welcome zwraca jsp plik
    }
    @ModelAttribute("challengeMessage")   // to dziala tak samo jak model.addAtribute. Domyslnie mapowanie bedzie na stronie
    public String challengeMessage()
    {
        log.info("challengeMessage() zawolanie");
        return demoService.getWelcomeMessage();
    }

    // http://localhost:8080/Spring-01-todo-list/chalenge2?user=Tim      = to wlasnie robi RequestParam . Parametr przekazywany podczas requestu na stronie
    // dzieki request param mozemy przekazac jakies dane poprzez przegladarke. Mozna uzywac danych roznego typu. Jesli konwersja jest mozliwa dokonywana jest automatycznie

    @GetMapping("challenge2")//tutaj zwraca nazwe mapowania
    public String challenge2(@RequestParam String user, Model model)
    {
        model.addAttribute("NazwaAtrybutu",demoService.getHelloMessage(user));
        log.info("model = {}",model);
        return "challenge"; //welcome zwraca jsp plik
    }
    //http://localhost:8080/Spring-01-todo-list/challenge3?user=Tim&age=30
    @GetMapping("challenge3")//tutaj zwraca nazwe mapowania
    public String challenge3(@RequestParam String user,@RequestParam int age, Model model)
    {
        model.addAttribute("NazwaAtrybutu",demoService.getHelloMessage(user));
        model.addAttribute("age",age);
        log.info("model = {}",model);
        return "challenge"; //welcome zwraca jsp plik
    }
}
