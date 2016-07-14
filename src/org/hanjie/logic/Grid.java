package org.hanjie.logic;

import java.io.IOException;

/**
 * Created by thomas on 15/07/16.
 */
public class Grid {

    private int height = 0;
    private int width = 0;
    private Picture picture = null;
    private Box[][] grid = new Box[height][width];

    public Grid(String fileAddress) throws IOException {
        this.picture = new Picture(fileAddress);
        this.height = this.picture.getHeight();
        this.width = this.picture.getWidth();
        this.initializeBoxes();
    }

    private void initializeBoxes() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                this.grid[i][j] = new Box();
            }
        }
    }

}
