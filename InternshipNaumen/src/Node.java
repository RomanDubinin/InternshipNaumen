import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Roman on 18/04/2015.
 */
public class Node
{
    private char Key;
    public ClassItem ClassItem;
    private ArrayList<Node> SubNodes;

    public Node(char key, ClassItem classItem, ArrayList<Node> subNodes)
    {
        Key = key;
        ClassItem = classItem;
        SubNodes = subNodes;
    }

    public Node(char key, ArrayList<Node> subTrees)
    {
        this(key, null, subTrees);
    }

    public char GetKey()
    {
        return Key;
    }

    public List<Node> GetSubNodes()
    {
        return Collections.unmodifiableList(SubNodes);
    }

    public void AddSubNode(Node node)
    {
        SubNodes.add(node);
    }
}
