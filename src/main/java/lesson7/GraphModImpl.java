package lesson7;

import java.util.*;

public class GraphModImpl implements GraphMod {

    private final List<Vertex> vertexList;
    private final int[][] adjMatrix;

    public GraphModImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, Integer distance) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = distance;
        return true;
    }


    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        for (int i = 0; i < getSize(); i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] != 0) {
                    System.out.printf(" - %d -> %s", adjMatrix[i][j], vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitedVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitedVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
        System.out.println();
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] != 0 && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visitedVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        stack.add(vertex);
        vertex.setVisited(true);
    }

    private void visitedVertex(Queue<Vertex> queue, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        queue.add(vertex);
        vertex.setVisited(true);
    }

    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitedVertex(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitedVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }
        System.out.println();
    }

    @Override
    public void shortestWayBetween(String startLabel, String secondLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }

        int secondIndex = indexOf(secondLabel);
        if (secondIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + secondLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);
        Vertex startVertex = vertex;

        String resultTrek = "";
        int min = 0;
        int current = 0;


        StringBuilder currentTrek = new StringBuilder();
        if (vertex != null) {
            currentTrek.append(vertex.getLabel());
            stack.add(vertex);
            vertex.setVisited(true);
        }

        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                int value = adjMatrix[indexOf(stack.peek().getLabel())][indexOf(vertex.getLabel())];
                current += value;
                currentTrek.append(" > ").append(value).append(" > ").append(vertex.getLabel());
                if (vertex.getLabel().equals(secondLabel)) {
                    if (min == 0 || current < min) {
                        min = current;
                        resultTrek = currentTrek.toString();
                    }
                    currentTrek = new StringBuilder(startVertex.getLabel());
                    current = 0;
                    stack.clear();
                    stack.add(startVertex);
                    continue;
                }

                stack.add(vertex);
                vertex.setVisited(true);
            } else {
                stack.pop();
            }
        }
        if (min != 0) {
            System.out.printf("Shortest way between %s and %s - %d%n", startLabel, secondLabel, min);
            System.out.printf("trek: %s", resultTrek);
        } else {
            System.out.printf("No way to get from %s to %s%n", startLabel, secondLabel);
        }
    }
}
