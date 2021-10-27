package lesson7;

public interface GraphMod {

    void addVertex(String label);

    boolean addEdge(String startLabel, String secondLabel, Integer weight);

    int getSize();

    void display();

    /**
     * англ. Depth-first search, DFS
     */
    void dfs(String startLabel);

    /**
     * англ. breadth-first search, BFS
     */
    void bfs(String startLabel);

    void shortestWayBetween(String startLabel, String secondLabel);

}
