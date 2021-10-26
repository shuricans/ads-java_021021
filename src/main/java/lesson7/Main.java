package lesson7;

public class Main {
    public static void main(String[] args) {
//        testGraph();
//        testDfs();
//        testBfs();
        findPath();
    }

    private static void findPath() {
        GraphMod graph = new GraphModImpl(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdge("Москва", "Тула", 180);
        graph.addEdge("Москва", "Рязань", 210);
        graph.addEdge("Москва", "Калуга", 200);

        graph.addEdge("Тула", "Липецк", 300);
        graph.addEdge("Рязань", "Тамбов", 290);
        graph.addEdge("Калуга", "Орел", 210);

        graph.addEdge("Липецк", "Воронеж", 130);

        graph.addEdge("Тамбов", "Саратов", 470);
        graph.addEdge("Орел", "Курск", 160);

        graph.addEdge("Саратов", "Воронеж", 510);
        graph.addEdge("Курск", "Воронеж", 230);

        graph.shortestWayBetween("Москва", "Воронеж");
    }

    private static void testGraph() {
        Graph graph = new GraphImpl(4);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B", "C");
        graph.addEdge("B", "C", "D");
        graph.addEdge("C", "A", "B", "D");
        graph.addEdge("D", "B", "C");

        System.out.println("Size of graph is " + graph.getSize());
        graph.display();
    }

    private static void testDfs() {
        Graph graph = new GraphImpl(7);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge("A", "B", "C", "D");
        graph.addEdge("B", "E");
        graph.addEdge("D", "F");
        graph.addEdge("F", "G");

        graph.dfs("A");
    }

    private static void testBfs() {
        Graph graph = new GraphImpl(8);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");

        graph.addEdge("A", "B", "C", "D");
        graph.addEdge("B", "E");
        graph.addEdge("E", "H");
        graph.addEdge("C", "F");
        graph.addEdge("D", "G");

        graph.bfs("A");
    }
}
