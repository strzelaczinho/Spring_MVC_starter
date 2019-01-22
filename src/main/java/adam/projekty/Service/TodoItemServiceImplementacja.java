package adam.projekty.Service;

import adam.projekty.model.TodoData;
import adam.projekty.model.TodoItem;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImplementacja implements TodoItemService {

    @Getter
    private final TodoData data = new TodoData(); // metoda getData z interfejsu

    @Override
    public void addItem(TodoItem todoItem) {
        data.addItem(todoItem);
    }

    @Override
    public void removeItem(int id) {
        data.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return data.getItem(id);
    }

    @Override
    public void updateItem(TodoItem item) {
        data.updateItem(item);
    }
    /*
    @Override
    public TodoData getData() {
        return data;
    }
*/

}
