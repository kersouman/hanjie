package org.hanjie.logic;

/**
 * Created by thomas on 14/07/16.
 */
public class Grid {

    private int height = 0;
    private int rows[][] = new int[height][height/2 + 1];
    private int width = 0;
    private int columns[][] = new int[width][width/2 + 1];


    public Grid(int height, int width) {
        this.height = height;
        this.width = width;
    }

}
