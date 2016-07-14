package org.hanjie.logic;

import org.hanjie.inout.GridParser;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by thomas on 14/07/16.
 */
public class Picture {

    private String name = "";
    private int height = 0;
    private int rows[][] = new int[height][height/2 + 1];
    private int width = 0;
    private int columns[][] = new int[width][width/2 + 1];

    public Picture(String fileAddress) throws IOException {
        GridParser gridParser = new GridParser(fileAddress);
        this.name = gridParser.getTitle();
        this.height = gridParser.getHeight();
        this.width = gridParser.getWidth();
        this.setRowsArray(fileAddress);
        this.setColumnsArray(fileAddress);
    }

    private void setRowsArray(String fileAddress) throws IOException {
        GridParser gridParser = new GridParser(fileAddress);
        ArrayList<ArrayList<Integer>> rowList = gridParser.getRows(this.height);
        for (int i = 0; i < rowList.size(); i++) {
            for (int j = 0; j < rowList.get(i).size(); j++) {
                this.rows[i][j] = rowList.get(i).get(j);
            }
        }
    }

    private void setColumnsArray(String fileAddress) throws IOException {
        GridParser gridParser = new GridParser(fileAddress);
        ArrayList<ArrayList<Integer>> columnList = gridParser.getColumns(this.width);
        for (int i = 0; i < columnList.size(); i++) {
            for (int j = 0; j < columnList.get(i).size(); j++) {
                this.columns[i][j] = columnList.get(i).get(j);
            }
        }
    }

    public int[][] getRows() {
        return this.rows;
    }

    public int[][] getColumns() {
        return this.columns;
    }
}
