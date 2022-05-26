
package SupplementServices;

import java.io.Serializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

/**
 *
 * @author callu
 */
public class MyVBox extends VBox implements Serializable{

    public MyVBox() {
    }

    public MyVBox(double spacing) {
        super(spacing);
    }

    public MyVBox(Node... children) {
        super(children);
    }

    public MyVBox(double spacing, Node... children) {
        super(spacing, children);
    }

}