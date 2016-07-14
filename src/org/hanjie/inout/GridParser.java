package org.hanjie.inout;

import java.io.IOException;

/**
 * Created by thomas on 14/07/16.
 */
public class GridParser {

    private GridReader gridReader = null;

    private GridParser(String fileAddress) throws IOException {
        this.gridReader = GridReader.getInstance(fileAddress);
    }

}
