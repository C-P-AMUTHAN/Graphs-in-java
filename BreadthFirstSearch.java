import java.util.*;

public class BreadthFirstSearch {
    public static void addEdge(int[][] graph, int row, int col) {
        // if row = 0 and col = 1, in the graph matrix we put 1 for 0,1 and 1,0 such that edge is existing between node 0 and 1
        graph[row][col] = 1;
        graph[col][row] = 1;
    }
    public static void bredthFirstSearch(int vertices, int[][] graph) {
        boolean[] visited = new boolean[vertices]; // boolean array initially false
        Queue<Integer> queue = new LinkedList<>(); 
        queue.add(0);
        visited[0] = true;
        System.out.print("The graph representation using breadth first search: ");
        while(!queue.isEmpty()) {
            int r = queue.poll(); // removing the first element of the queue
            System.out.print(r+" "); // printing it
            for(int c=0; c<vertices; c++) { // traverse the r row in the graph matrix
                if(graph[r][c] == 1 && visited[c] == false) { // if the value of it is 1, then there is a connection in it, and check by vistied array whether we already visited it or not.
                    queue.add(c); // adding it to the queue
                    visited[c]=true; // make the visited array as true for the particular node
                }
            }
        }
    }
    public static void main(String[] args) {
        // edges of the graph
        int[][] edges = {{0,1}, {0,2}, {1,3}, {1,4}, {2,4}, {3,5}, {4,5}};
        int vertices = 6; // 6 nodes in the graph
        int[][] graph = new int[vertices][vertices]; // a graph array is declared with 6*6 matrix
        for(int row=0; row<vertices; row++) {
            addEdge(graph, edges[row][0], edges[row][1]); // adding the edges in graph matrix
        }
        bredthFirstSearch(vertices,graph);
    }
}


// Algorithm:

// a boolean array with the size of number of vertices, initially it will be false.
// a queue data structure to insert the vertices and to remove it.

// initially insert 0 in the queue, that is starting vertices
// in the boolean array index 0 changes from false to true, beacause 0 vertice is visited
// find the adjacent vertices of 0 and add to the queue, when you completely found the adjacent vertices of, the remove and print the 0
// like wise, find the adjacent matrix of another number which is added in queue.

// Adjacency matrix
//      0 1 2 3 4 5
//      | | | | | |
// 0 => 0 1 1 0 0 0
// 1 => 1 0 0 1 1 0
// 2 => 1 0 0 0 1 0
// 3 => 0 1 0 0 1 1
// 4 => 0 1 1 1 0 0
// 5 => 0 0 0 1 1 0

// visited = [f, f, f, f, f, f]
// queue = []

// queue = [0]
// visited = [t, f, f, f, f, f]

// finding 0s adjacent vertices and adding it. before adding it, check the visited array, that is 0 is already visited or not.

// queue = [0, 1, 2]
// visited = [t, t, t, f, f, f]

// removing 0 and printing it.

// finding 1s adjacent vertices and adding it. before adding it, check the visited array, to check it is already visited or not.

// queue = [1, 2, 3, 4]
// visited = [t, t, t, t, t, f]

// removing 1 and printing it.

// finding 2s adjacent vertices and adding it. before adding it, check the visited array, to check it is already visited or not.

// queue = [2, 3, 4]
// visited = [t, t, t, t, t, f]

// removing 2 and printing it.

// finding 3s adjacent vertices and adding it. before adding it, check the visited array, to check it is already visited or not.

// queue = [3, 4, 5]
// visited = [t, t, t, t, t, t]

// removing 3 and printing it.

// finding 3s adjacent vertices and adding it. before adding it, check the visited array, to check it is already visited or not.

// queue = [4, 5]
// visited = [t, t, t, t, t, t]

// removing 4 and printing it.

// finding 3s adjacent vertices and adding it. before adding it, check the visited array, to check it is already visited or not.

// queue = [5]
// visited = [t, t, t, t, t, t]

// removing 5 and printing it.

// output: 0 1 2 3 4 5 (BFS)