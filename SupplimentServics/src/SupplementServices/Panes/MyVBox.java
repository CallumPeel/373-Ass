
package SupplementServices.Panes;

import java.io.Serializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

/**
 *
 * @author callu
 */
public class MyVBox extends VBox implements Serializable{

    /**
     *
     */
    public MyVBox() {
    }

    /**
     *
     * @param spacing
     */
    public MyVBox(double spacing) {
        super(spacing);
    }

    /**
     *
     * @param children
     */
    public MyVBox(Node... children) {
        super(children);
    }

    /**
     *
     * @param spacing
     * @param children
     */
    public MyVBox(double spacing, Node... children) {
        super(spacing, children);
    }

}
