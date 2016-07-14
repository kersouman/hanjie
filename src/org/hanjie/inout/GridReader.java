package org.hanjie.inout;

import org.hanjie.logic.Grid;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by thomas on 14/07/16.
 */
public class GridReader {

    private static GridReader GRID_READER_INSTANCE = null;
    private static FileInputStream GRID_READER_STREAM = null;
    private static String GRID_READER_ADDRESS = "";

    private GridReader(String fileAddress) throws IOException {
        GRID_READER_STREAM = new FileInputStream(fileAddress);
        GRID_READER_ADDRESS = fileAddress;
    }

    private static void closeStream() throws IOException {
        GRID_READER_STREAM.close();
    }

    private static void releaseAddress() {
        GRID_READER_ADDRESS = "";
    }

    private static void changeStream(String fileAddress) throws IOException {
        closeStream();
        GRID_READER_STREAM = new FileInputStream(fileAddress);
        GRID_READER_ADDRESS = fileAddress;
    }

    public static void releaseInstance() throws IOException {
        closeStream();
        releaseAddress();
        GRID_READER_INSTANCE = null;
    }

    public static GridReader getInstance(String fileAddress) throws IOException {
        if (GRID_READER_INSTANCE == null) {
            GRID_READER_INSTANCE = new GridReader(fileAddress);
        } else if (!(fileAddress.equals(GRID_READER_ADDRESS))) {
            changeStream(fileAddress);
        }
        return GRID_READER_INSTANCE;
    }

    protected static FileInputStream getGridReaderStream() {
        return GRID_READER_STREAM;
    }
}
