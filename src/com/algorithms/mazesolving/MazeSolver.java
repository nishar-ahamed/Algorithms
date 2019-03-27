package com.algorithms.mazesolving;

public class MazeSolver {

    private int[][] mazeMap;
    private boolean[][] visited;
    private int startPositionRow;
    private int startPositionColumn;

    public MazeSolver(int[][] map, int startPositionRow, int startPositionColumn) {
        this.mazeMap = map;
        this.startPositionRow = startPositionRow;
        this.startPositionColumn = startPositionColumn;
        this.visited = new boolean[map.length][map.length];
    }

    public void findWayOut() {
        try {
            dfs(this.startPositionRow, this.startPositionColumn);
            System.out.println("No solution found...");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void dfs(int rowIndex, int columnIndex) {
        int endOfMap = this.mazeMap.length - 1;
        if (rowIndex < 0 || rowIndex > endOfMap) {
            return;
        } else if (columnIndex < 0 || columnIndex > endOfMap) {
            return;
        } else if (this.mazeMap[rowIndex][columnIndex] == 1) {
            return;
        } else if (visited[rowIndex][columnIndex]) {
            return;
        } else if (this.mazeMap[rowIndex][columnIndex] == 3) {
            throw new RuntimeException("Route found to exit Row " + rowIndex + " Column " + columnIndex);
        } else {
            System.out.println("Visiting Row " + rowIndex + " Column " + columnIndex);
            this.visited[rowIndex][columnIndex] = true;
            dfs(rowIndex + 1, columnIndex);     //move down
            dfs(rowIndex, columnIndex + 1);  //move right
            dfs(rowIndex, columnIndex - 1);  //move left
            dfs(rowIndex - 1, columnIndex);     //move up
        }
    }

    public static void main(String[] args) {
        FileReader fileReader = new FileReader("/location/to/your/matrix/txt/file", 14, 14);
        fileReader.parseFile();
        MazeSolver mazeSolver = new MazeSolver(fileReader.getMap(), fileReader.getStartPositionRow(), fileReader.getStartPositionColumn());
        mazeSolver.findWayOut();
    }
}
