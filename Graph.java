import java.util.*;

public class Graph {
    // method to construct graph
    public static void createGraph(int vertices, int[][] edges, int[][] grph) {
        for(int r=0; r<vertices; r++) {
            addEdge(grph, edges[r][0], edges[r][1]);
        }
    }
    // method to add edges to a graph
    public static void addEdge(int[][] grph, int row, int col) {
        grph[row][col] = 1;
        grph[col][row] = 1;
    }
    // method to display the constructed graph
    public static void displayGraph(int[][] grph, int vertices) {
        for(int r=0; r<vertices; r++) {
            for(int c=0; c<vertices; c++) {
                System.out.print(grph[r][c]+" ");
            }
            System.out.println();
        }
    }
    // main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int vertices = sc.nextInt(); // number of vetrices of the graph
        int[][] edges = new int[vertices][2]; // edges of the graph
        for(int i=0; i<vertices; i++) {
            System.out.print("Enter "+(i+1)+" edge: ");
            for(int j=0; j<2; j++) {
                edges[i][j] = sc.nextInt(); // geting the each edge of the graph from the user. ex (1,2) (1,3) (2,3) (3,4)
            }
        }
        int[][] grph = new int[vertices][vertices];
        createGraph(vertices, edges, grph);
        displayGraph(grph, vertices);
        sc.close();
    }
}
