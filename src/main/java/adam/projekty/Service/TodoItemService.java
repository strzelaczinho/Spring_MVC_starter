package adam.projekty.Service;

import adam.projekty.model.TodoData;
import adam.projekty.model.TodoItem;

public interface TodoItemService {
    public void addItem(TodoItem todoItem);
    public void removeItem(int id);
    public TodoItem getItem(int id);
    public void updateItem(TodoItem item);
    public TodoData getData();
}
