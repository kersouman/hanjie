package org.hanjie.logic;

/**
 * Created by thomas on 13/07/16.
 */
public class Box {

    protected enum BoxState {EMPTY, TICKED, CHECKED;}
    private BoxState state = BoxState.EMPTY;

    protected BoxState boxState() {
        return this.state;
    }

    protected void emptyBox() {
        if (this.state != BoxState.EMPTY) this.state = BoxState.EMPTY;
    }

    protected void tickBox() {
        if (this.state != BoxState.TICKED) this.state = BoxState.TICKED;
    }

    protected void checkBox() {
        if (this.state != BoxState.CHECKED) this.state = BoxState.CHECKED;
    }
}
