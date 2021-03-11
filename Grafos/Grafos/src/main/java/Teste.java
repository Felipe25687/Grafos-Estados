import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import java.util.ArrayList;
public class Teste {
    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new MultiGraph("Tutorial 1");
        graph.setAttribute("ui.stylesheet",
                "node {" +
                        "fill-color: white;" +
                        "size: 50px;" +
                        "stroke-mode: plain;" +
                        "stroke-color: black;" +
                        "stroke-width: 1px;" +
                        "}"
        );
        int [][] matriz={
                new int []{0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                new int []{0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0},
                new int []{0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                new int []{1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0},
                new int []{0,1,0,0,0,0,0,1,1,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,1,1},
                new int []{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,1,0,0,0,0,0,0,0},
                new int []{0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                new int []{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
                new int []{0,0,0,0,1,0,1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                new int []{0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1},
                new int []{0,0,0,0,0,0,0,0,1,0,0,1,0,1,0,0,0,0,0,0,0,1,0,0,0,0,1},
                new int []{0,0,0,0,0,0,0,0,1,0,1,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0},
                new int []{0,0,0,0,1,0,0,1,1,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0},
                new int []{0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1},
                new int []{0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,1,0,1,0,0,0,0,0,0,0},
                new int []{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0},
                new int []{0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                new int []{0,0,0,0,1,1,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                new int []{0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                new int []{0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                new int []{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
                new int []{1,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                new int []{0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                new int []{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0},
                new int []{0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
                new int []{0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                new int []{0,0,0,0,1,0,0,0,1,1,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0}
        };
        String[] estados = {"AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PS","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"};
        ArrayList<String[]> vetor = new ArrayList<>();
        for (int i =0 ; i < estados.length;i++){
            graph.addNode(estados[i]);
        }
        for(int i = 0; i < matriz.length; i++) {
            for(int j = i + 1; j < matriz.length; j++) {
                if(matriz[i][j] == 1) vetor.add(new String[]{estados[i], estados[j]});
            }
        }
        for(int i = 0; i < vetor.size(); i++) {
            graph.addEdge(String.join("-", vetor.get(i)), vetor.get(i)[0], vetor.get(i)[1]);
        }
        graph.edges().forEach((node) -> {
            Node node0, node1;
            node0 = node.getNode0();
            node1 = node.getNode1();

            node0.setAttribute("ui.label", node0.getId());
            node1.setAttribute("ui.label", node1.getId());
            node0.setAttribute("ui.class", "node");
        });
        graph.display();
    }
}