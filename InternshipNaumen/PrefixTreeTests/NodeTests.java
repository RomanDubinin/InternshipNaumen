import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Roman on 18/04/2015.
 */
public class NodeTests
{

    @Test
    public void testCreatingNodeWithoutClassItem() throws Exception
    {
        Node node = new Node('a', new ArrayList<Node>());
        Assert.assertTrue(node.ClassItem == null);
    }
}
