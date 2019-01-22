package adam.projekty.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TodoData {

    // == fields ==
    private static int idValue = 1;

    private final List<TodoItem> items = new ArrayList<>();

    // == constructors ==
    public TodoData() {

        // add some dummy data, using the addItem method so it sets the id field
        addItem(new TodoItem("Pierwszy", "pierwszy details", LocalDate.now()));
        addItem(new TodoItem("Drugi ", "drugi details", LocalDate.now()));
        addItem(new TodoItem("Trzeci", "trzeci details", LocalDate.now()));
        addItem(new TodoItem("Czwarty", "czwarty details", LocalDate.now()));
    }

    // == public methods ==
    public List<TodoItem> getItems() {
        return Collections.unmodifiableList(items);/// lista niezmienna
    }

    public void addItem(@NonNull TodoItem toAdd) {// not null czyli nie sprawdzac czy toAdd item jest null ifem tylko odrazu adnotacja

        toAdd.setId(idValue);
        items.add(toAdd);
        idValue++;
    }

    public void removeItem(int id) {
        ListIterator<TodoItem> itemIterator = items.listIterator();

        while(itemIterator.hasNext()) {
            TodoItem item = itemIterator.next();

            if(item.getId() == id) {
                itemIterator.remove();
                break;
            }
        }
    }

    public TodoItem getItem(int id) {
        for(TodoItem item : items) {
            if(item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void updateItem(@NonNull TodoItem toUpdate) {
        ListIterator<TodoItem> itemIterator = items.listIterator();

        while(itemIterator.hasNext()) {
            TodoItem item = itemIterator.next();

            if(item.equals(toUpdate)) {
                itemIterator.set(toUpdate);
                break;
            }
        }
    }
}
