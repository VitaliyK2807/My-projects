package practice;

import java.util.ArrayList;

public class TodoList {

    private ArrayList<String> todoList = new ArrayList<>();

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        todoList.add(todo);

    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        int foundIndex = -1;
        for (int i = 0; i < todoList.size(); i++) {
          if (index == i) {
            foundIndex = index;
          }
        }
        if (foundIndex == -1) {
            todoList.add(todoList.size(), todo);
        } else todoList.add(index, todo);

    }

    public void edit(int index, String todo) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        for (int i = 0; i < todoList.size(); i++) {
            if (index == i) {
                String memory = todoList.get(index);
                todoList.set(index, todo);
                System.out.println("Дело" + " \"" + memory +
                        "\"" +" заменено на" + " \"" + todo + "\"");
            }
            if (i >= todoList.size()) {
                System.out.println("Введенный индекс не найден!");
            }
        }

    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        String memory = "";
        Boolean checkDelete = false;
        for (int i = 0; i < todoList.size(); i++) {
            if (index == i) {
                memory = "Дело" + " \"" + todoList.get(index) +
                        "\"" +" удалено";
                todoList.remove(index);
                checkDelete = true;
                break;
            }
        }
        System.out.println(checkDelete ? memory : "Дело с таким номером не существует");
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return todoList;
    }

}