package GraphMap;

import ArrayMap.MapCreator;
import ArrayMap.Node;
import ArrayMap.NodeTypes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Graph {
    private int maxNodes; //Кол-во вершин в графе
    private int[][] adjMatrix; //Матрица смежности
    Node[] vertexList; //Список всех узлов
    private int currentVertex; //Кол-во текущих узлов (счетчик)
    // Большой вопрос как тут поступить правильно... Передавать из MapCreator: map, n, m
    // (так как все нужно для заполнения графа) или же просто передать сюда экземпляр MapCreator целиком
    // Пока передам целиком, так как работать с полями проще, хотя что-то мне подсказывает, что это не особо правильно
    private Node[][] map;
    private MapCreator mapCreator;

    public Graph(Node[][] map, MapCreator mapCreator) {
        this.maxNodes = mapCreator.getN() * mapCreator.getM() * 4;
        vertexList = new Node[maxNodes];
        adjMatrix = new int[maxNodes][maxNodes];
        currentVertex = 0;
        //this.map = map;
        this.mapCreator = mapCreator;
    }

    public void addVertex(Node node){
        vertexList[currentVertex++] = node;
    }

    public void addEdge(int start, int end, int value){
        adjMatrix[start][end] = value; // 1 или 0, в зависимости от того можно ли пройти на клетку из A в B
        adjMatrix[end][start] = value; // 1 или 0, в зависимости от того можно ли пройти на клетку из B в A
    }

    public int check(int vertex){
        for(int i = 0; i < currentVertex; i++){
            if(adjMatrix[vertex][i] == 1 && !vertexList[i].isVisited()){
                return i;
            }
        }
        return -1;
    }

    public void setNeighbours(int i, int j){
        if(i - 1 >= 0){
            if(mapCreator.getMap()[i - 1][j] != null) {
                if (mapCreator.getMap()[i][j].isPassing() && mapCreator.getMap()[i - 1][j].isPassing()) {
                    addEdge(mapCreator.getMap()[i][j].getId(), mapCreator.getMap()[i - 1][j].getId(), 1);
                }
            }
        }
        if(i + 1 < mapCreator.getN()){
            if(mapCreator.getMap()[i + 1][j] != null){
                if(mapCreator.getMap()[i][j].isPassing() && mapCreator.getMap()[i + 1][j].isPassing()) {
                    addEdge(mapCreator.getMap()[i][j].getId(), mapCreator.getMap()[i + 1][j].getId(), 1);
                }
            }
        }
        if(j - 1 >= 0){
            if(mapCreator.getMap()[i][j - 1] != null){
                if(mapCreator.getMap()[i][j].isPassing() && mapCreator.getMap()[i][j - 1].isPassing()) {
                    addEdge(mapCreator.getMap()[i][j].getId(), mapCreator.getMap()[i][j - 1].getId(), 1);
                }
            }
        }
        if(j + 1 < mapCreator.getM()){
            if(mapCreator.getMap()[i][j + 1] != null){
                if(mapCreator.getMap()[i][j].isPassing() && mapCreator.getMap()[i][j + 1].isPassing()) {
                    addEdge(mapCreator.getMap()[i][j].getId(), mapCreator.getMap()[i][j + 1].getId(), 1);
                }
            }
        }
    }

    public void createGraphFromArrayMap(){
        for(int i = 0; i < mapCreator.getN(); i++){
            for(int j = 0; j < mapCreator.getM(); j++){
                addVertex(mapCreator.getMap()[i][j]);
                setNeighbours(i, j);
            }
        }
    }

    public void getAllEdgesInConsole(){
        System.out.println("===========Вывод инфы о графе===========");
        System.out.println("Макс. кол-во вершин в графе: " + maxNodes + "; Кол-во текущих врешин: " + currentVertex);
        System.out.println("Матрица смежности:");
        for(int i = 0; i < maxNodes; i++){
            for(int j = 0; j < maxNodes; j++){
                if(adjMatrix[i][j] != 0){

                    System.out.println("[" + i + ", " + j + "]: " + adjMatrix[i][j]);
                }
            }
        }
    }
}
