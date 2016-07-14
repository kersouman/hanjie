package org.hanjie.inout;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by thomas on 14/07/16.
 */
public class GridParser {

    private BufferedReader gridParserReader = null;

    public GridParser(String fileAddress) throws IOException {
        FileInputStream gridReaderStream = GridReader.getInstance(fileAddress).getGridReaderStream();
        this.gridParserReader = new BufferedReader(new InputStreamReader(gridReaderStream));
    }

    public void closeParserReader() throws IOException {
        this.gridParserReader.close();
    }

    public String getTitle() throws IOException {
        while (!(this.gridParserReader.readLine().equals("Title:"))) {}
        return this.gridParserReader.readLine();
    }

    public int getHeight() throws IOException {
        while (!(this.gridParserReader.readLine().equals("Height:"))) {}
        return Integer.parseInt(this.gridParserReader.readLine());
    }

    public int getWidth() throws IOException {
        while (!(this.gridParserReader.readLine().equals("Width"))) {}
        return Integer.parseInt(this.gridParserReader.readLine());
    }

    public ArrayList<ArrayList<Integer>> getRows(int height) throws IOException {
        while (!(this.gridParserReader.readLine().equals("Rows:"))) {}
        ArrayList<ArrayList<Integer>> rows = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ArrayList<Integer> rowList = new ArrayList<>();
            String rowTable[] = this.gridParserReader.readLine().split(",");
            for (int j = 0; j < rowTable.length; j++) {
                rowList.add(Integer.parseInt(rowTable[j]));
            }
            rows.add(rowList);
        }
        return rows;
    }

    public ArrayList<ArrayList<Integer>> getColumns(int width) throws IOException {
        while (!(this.gridParserReader.readLine().equals("Columns:"))) {};
        ArrayList<ArrayList<Integer>> columns = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            ArrayList<Integer> columnList = new ArrayList<>();
            String columnTable[] = this.gridParserReader.readLine().split("");
            for (int j = 0; j < columnTable.length; j++) {
                columnList.add(Integer.parseInt(columnTable[j]));
            }
            columns.add(columnList);
        }
        return columns;
    }

}
