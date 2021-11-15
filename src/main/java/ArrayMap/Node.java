package ArrayMap;

import ArrayMap.NodeTypes;
import Utils.AutoIncrement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Node {
    private int x; //Позиция ячейки по X
    private int y; //Позиция ячейки по Y
    private int size; //Размер одной ячейки n*n
    private NodeTypes type; //Тип клетки
    private boolean startPosition = false; //Является ли стартовой ячейкой
    private boolean finishPosition = false; //Является ли финишной ячейкой
    private String word; //Для консольного вывода
    private boolean isVisited; //Посещение клетки (для будущих алгоритмов)
    private boolean passing; //Можно ли пройти по клетке (с залогом на различные препятсвия и проходы)
    private int id; //Не придумал как иначе работать с добавлением граней между нодами

    public Node() {
        this.isVisited = false;
    }
}
