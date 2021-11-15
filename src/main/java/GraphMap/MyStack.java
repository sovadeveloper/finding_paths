package GraphMap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyStack {
    private int size; //Размер стека
    private int top; //Последний элемент
    private int[] array;

    public MyStack() {
        array = new int[size];
        top = -1;
    }

    //Добавление узла в стек
    public void push(int n){
        array[++top] = n;
    }

    //Удаление и возвращение последнего узла из стека
    public int pop(){
        return array[top--];
    }

    //Возввращение последнего узла из стека
    public int peek(){
        return array[top];
    }

    public boolean isEmpty(){
        return array[top] == -1;
    }
}
