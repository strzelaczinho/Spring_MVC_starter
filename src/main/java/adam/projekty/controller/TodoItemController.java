package adam.projekty.controller;


import adam.projekty.Service.TodoItemService;
import adam.projekty.model.TodoData;
import adam.projekty.model.TodoItem;
import adam.projekty.util.AttributeNames;
import adam.projekty.util.Mappings;
import adam.projekty.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Slf4j
@Controller
public class TodoItemController {

    private final TodoItemService service;

    @Autowired
    public TodoItemController(TodoItemService service)
    {
        this.service = service;
    }
    // == model attributes ==
    @ModelAttribute
    public TodoData todoData() { //zwracam obiekt klasy poprzez model o nazwie todoData
   //     return new TodoData();
        return service.getData();
    }
    // == handler methods ==
  //  http://localhost:8080/Spring-01-todo-list/items
    @GetMapping(Mappings.ITEMS)
    public String items() {         // mapuje na adres w stringu "items" ktory zwraca jsp o nazwie items_list.jsp
        return ViewNames.ITEMS_LIST;
    }
    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false,defaultValue = "-1") int id, Model model) { // request param dla edycji listy . Serwis znajdzie nam item z id . Required false to jest parametr tzw opcjonalny , defaultValue -1 i tak zostanie zamienione na inta
        log.info("edycja id + {}",id);
        TodoItem todoItem = service.getItem(id);

        if (todoItem == null)
        {
             todoItem = new TodoItem("", "", LocalDate.now());

        }
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }
    @PostMapping(Mappings.ADD_ITEM)//to jest metoda Post wiec po submicie mozemy wrocic do listy natychmiastowo
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem) {//dodaje do modelu obiekt klasy , nazwa atrybutu bedzie nazwa klasy pisana mala litera. Nastepnym krokiem jest powiedzenie formie ze model jest ten sam rowniez w controlerze

        log.info("todoItem from from =============== {}", todoItem);
        // sprawdzam czy item ma id 0 , jesli tak to wtedy wiem ze to jest nowy item , w inynm przypadku to bedzie edycja itemu
        if (todoItem.getId() == 0)
        {
            service.addItem(todoItem); // dodaje do mojej listy czy serwisu obiekt klasy
        }
        else
        {
            service.updateItem(todoItem);
        }

        return "redirect:/" + Mappings.ITEMS;
    }
    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id)
    {
        service.removeItem(id);
        return "redirect:/"+ Mappings.ITEMS;
    }
    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id,Model model)
    {
         TodoItem todoItem = service.getItem(id);
         model.addAttribute(AttributeNames.TODO_ITEM,todoItem);
        return ViewNames.VIEW_ITEM;
    }

}

