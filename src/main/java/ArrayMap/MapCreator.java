package ArrayMap;

import Utils.AutoIncrement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MapCreator {
    private int n; //Ширина сетки в ячейках
    private int m; //Длина сетки в ячейках
    private Node[][] map; //Массив карты
    private int stoneCounter = 0; //Счетчик камней на карте

    private AutoIncrement autoIncrement = new AutoIncrement();

    public MapCreator(int n, int m) {
        this.n = n;
        this.m = m;
        map = new Node[n][m];
    }

    private void createMap(){
        Node startNode = new Node();
        Node finishNode = new Node();
        startNode.setStartPosition(true);
        finishNode.setFinishPosition(true);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ; j++){
                map[i][j] = randomizerNodeProperties(15);
                if(i == 0 && j == 0){
                    map[i][j].setStartPosition(true);
                    map[i][j].setType(NodeTypes.ROAD);
                }else if(i == n - 1 && j == m - 1){
                    map[i][j].setFinishPosition(true);
                    map[i][j].setType(NodeTypes.ROAD);
                }
            }
        }
    }

    private Node randomizerNodeProperties(int stoneCount){
        Node node = new Node();
        node.setId(autoIncrement.setId());
        Random random = new Random();
        if((random.nextDouble() < 0.3) && stoneCounter < stoneCount){
            node.setType(NodeTypes.STONE);
            node.setPassing(false);
            stoneCounter++;
        }else{
            node.setType(NodeTypes.ROAD);
            node.setPassing(true);
        }
        return node;
    }

    private void setWordsOnNodes(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j].getType() == NodeTypes.STONE){
                    map[i][j].setWord("K  ");
                }else if(map[i][j].getType() == NodeTypes.ROAD){
                    if(map[i][j].isStartPosition()){
                        map[i][j].setWord("S  ");
                    }else if(map[i][j].isFinishPosition()){
                        map[i][j].setWord("F  ");
                    }else{
                        map[i][j].setWord("R  ");
                    }
                }
            }
        }
    }

    public void consoleDrawMap(){
        createMap();
        setWordsOnNodes();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(map[i][j].getWord());
            }
            System.out.println();
        }
    }
}
