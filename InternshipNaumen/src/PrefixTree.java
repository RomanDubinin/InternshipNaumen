import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * Created by Roman on 18/04/2015.
 */
public class PrefixTree
{
    public Node Head;

    public PrefixTree()
    {
        Head = new Node('0', new ArrayList<Node>());//head node must has empty line as key, but i cant create empty char
    }

    public void Incert(ClassItem classItem)
    {
        Node currentNode = Head;
        for(int i = 0; i < classItem.GetName().length(); i++)
        {
            Node nextNode = FindNodeByKey(currentNode.GetSubNodes(), classItem.GetName().charAt(i));
            if (nextNode != null)
                currentNode = nextNode;
            else
            {
                Node newNode = new Node(classItem.GetName().charAt(i), new ArrayList<Node>());
                currentNode.AddSubNode(newNode);
                currentNode = newNode;
            }
        }
        currentNode.ClassItem = classItem;
    }

    public ArrayList<ClassItem> FindClassItemsByPrefix(String prefix)
    {
        Node currentNode = Head;
        for(int i = 0; i < prefix.length(); i++)
        {
            Node nextNode = FindNodeByKey(currentNode.GetSubNodes(), prefix.charAt(i));
            if (nextNode == null)
                return new ArrayList<ClassItem>();

            else
                currentNode = nextNode;
        }

        ArrayList<ClassItem> finededClasses = new ArrayList<ClassItem>();
        Queue<Node> bfsQueue = new LinkedBlockingQueue<Node>();
        bfsQueue.add(currentNode);
        while (!bfsQueue.isEmpty())
        {
            currentNode = bfsQueue.poll();
            if (currentNode.ClassItem != null)
                finededClasses.add(currentNode.ClassItem);
            for (Node nextNode : currentNode.GetSubNodes())
                bfsQueue.add(nextNode);
        }

        return finededClasses;
    }

    private Node FindNodeByKey(List<Node> nodes, char key)
    {
        Optional<Node> otionalFineded = nodes.stream().filter(node -> node.GetKey() == key).findFirst();
        return otionalFineded.isPresent() ? otionalFineded.get() : null;
    }
}
