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

    }
}
