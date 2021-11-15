import ArrayMap.MapCreator;
import GraphMap.Graph;

public class Main {
    public static void main(String[] args) {
        MapCreator mapCreator = new MapCreator(5, 10);
        Graph graph = new Graph(mapCreator.getMap(), mapCreator);
        mapCreator.consoleDrawMap();
        graph.createGraphFromArrayMap();
        graph.getAllEdgesInConsole();
    }
}
