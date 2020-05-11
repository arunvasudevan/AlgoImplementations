package com.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a 2D grid, each cell is either a zombie 1 or a human 0. Zombies can turn adjacent (up/down/left/right) human beings into zombies every hour. Find out how many hours does it take to infect all humans?
 *
 * Example:
 *
 * Input:
 * [[0, 1, 1, 0, 1],
 *  [0, 1, 0, 1, 0],
 *  [0, 0, 0, 0, 1],
 *  [0, 1, 0, 0, 0]]
 *
 * Output: 2
 *
 * Explanation:
 * At the end of the 1st hour, the status of the grid:
 * [[1, 1, 1, 1, 1],
 *  [1, 1, 1, 1, 1],
 *  [0, 1, 0, 1, 1],
 *  [1, 1, 1, 0, 1]]
 *
 * At the end of the 2nd hour, the status of the grid:
 * [[1, 1, 1, 1, 1],
 *  [1, 1, 1, 1, 1],
 *  [1, 1, 1, 1, 1],
 *  [1, 1, 1, 1, 1]]
 *
 */

public class ZombieInMatrix {
    // Add all zombies into a queue and add -1, -1 and process each one of them and count when -1 occurs

    int minHours(int rows, int columns, List<List<Integer>> grid) {
        int minHours = 0;
        Queue<Node> q= new LinkedList<>();
        int humansCount = 0;

        for(int r=0; r< rows; r++){
            for(int c=0; c< columns; c++){
                int element = grid.get(r).get(c);
                if(element == 1){
                    q.add(new Node(r, c));
                } else {
                    ++humansCount;
                }
            }
        }
        q.add(new Node(-1, -1));

        if(humansCount >0 && q.size()>0){
            minHours = bfs(q, grid);
        }

        return minHours;
    }

    private int bfs(Queue<Node> q, List<List<Integer>> grid) {
        int maxCount = 0;
        while(!q.isEmpty()){
            Node n = q.poll();
            int r = n.row;
            int c= n.col;

            if(r == -1 && c == -1 && q.size() > 1){
                ++maxCount;
                q.add(new Node(-1, -1));
            }

            int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

            for(int[] d: directions){
                int newR = r + d[0];
                int newC = c + d[1];
                if(newR < 0 || newR >= grid.size() || newC < 0 || newC>=grid.get(newR).size()){
                    continue;
                }

                if(grid.get(newR).get(newC) == 0){
                    List<Integer> integerList = grid.get(newR);
                    integerList.set(newC, 1);
                    q.add(new Node(newR, newC));
                }
            }

        }
        return maxCount;
    }
}

class Node {
    int row;
    int col;
    Node(int row, int col){
        this.row = row;
        this.col = col;
    }
}
