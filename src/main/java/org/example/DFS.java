package org.example;

import java.util.List;

public class DFS {
    public static boolean dfs(int[][] grid, int x, int y, List<Integer> arr){
        if(grid[y][x]==9){
            arr.add(x);
            arr.add(y);
            return true;
        }
        if(grid[y][x]==0){
            grid[y][x]=2;
            if(dfs(grid,x-1,y,arr)){
                arr.add(x);
                arr.add(y);
                return true;
            }
            if(dfs(grid,x+1,y,arr)){
                arr.add(x);
                arr.add(y);
                return true;
            }
            if(dfs(grid,x,y-1,arr)){
                arr.add(x);
                arr.add(y);
                return true;
            }
            if(dfs(grid,x,y+1,arr)){
                arr.add(x);
                arr.add(y);
                return true;
            }
        }
        return false;
    }
}
