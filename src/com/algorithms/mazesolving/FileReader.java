package com.algorithms.mazesolving;

import java.io.File;
import java.util.Scanner;

public class FileReader {

    private int[][] map;
    private String fileName;
    private int numOfRows;
    private int numOfColumns;
    private int startPositionRow;
    private int startPositionColumn;

    public FileReader(String fileName, int numOfRows, int numOfColumns) {
        this.fileName = fileName;
        this.numOfRows = numOfRows;
        this.numOfColumns = numOfColumns;
        this.map = new int[numOfRows][numOfColumns];
    }

    public void parseFile() {
        try {
            File file = new File(this.fileName);
            Scanner scanner = new Scanner(file);
            for (int i = 0; i < this.numOfRows; i++) {
                String[] line = scanner.nextLine().trim().split(" ");
                for (int j = 0; j < this.numOfColumns; j++) {
                    this.map[i][j] = Integer.parseInt(line[j]);
                    if (map[i][j] == 2) {
                        this.startPositionRow = i;
                        this.startPositionColumn = j;
                    }
                }
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int[][] getMap() {
        return map;
    }


    public int getStartPositionRow() {
        return startPositionRow;
    }


    public int getStartPositionColumn() {
        return startPositionColumn;
    }

}
