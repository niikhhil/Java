import java.util.*;
public class Graphs{
    static class Edge{
        int src;
        int dest;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));
        
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
       
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
        
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
        
        graph[6].add(new Edge(6, 5));

    }
    public static void bfs(ArrayList<Edge> graph[], int v){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[v];
        q.add(0);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visited[curr]){
                System.out.print(curr + " ");
                visited[curr] = true;
                for(Edge e: graph[curr]){
                    q.add(e.dest);
                }
            }
        }
    }
    public static void dfs(ArrayList<Edge> graph[], int curr, boolean[] visited){
        System.out.println(curr + " ");
        visited[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest])
            dfs(graph, e.dest, visited);
        }
    }
    public static void printAllPath(ArrayList<Edge> graph[], int curr, boolean[] visited, int tar, String str){
        if(curr == tar){
            System.out.println(str);
            return;
        }
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                visited[curr] = true;
                printAllPath(graph, e.dest, visited, tar, str +"-> " + e.dest);
                visited[curr] = false;
            }
        }
    }
    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        // bfs(graph, v);
        // System.out.println();
        
        boolean[] visited = new boolean[v];
        dfs(graph, 0, visited);

        //print 2's neighbours
        // for(int i = 0; i < graph[2].size(); i++){
        //     Edge e = graph[2].get(i);
        //     System.out.print(e.dest + " ");
        // }
        int src = 0, tar = 5;
        printAllPath(graph, src, new boolean[v], tar, "0");
    }
}