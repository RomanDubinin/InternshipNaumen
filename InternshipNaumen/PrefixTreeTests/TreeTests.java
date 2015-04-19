import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Roman on 19/04/2015.
 */

public class TreeTests {
    @Test
    public void testIncert1() throws Exception
    {
        PrefixTree tree = new PrefixTree();
        ClassItem classItem1 = new ClassItem("Class1", 243);
        ClassItem classItem2 = new ClassItem("Class2", 2);

        tree.Incert(classItem1);
        tree.Incert(classItem2);

        Assert.assertTrue(tree.Head.GetSubNodes().get(0).GetKey() == 'C');
        Assert.assertTrue(tree.Head.GetSubNodes().get(0)
                .GetSubNodes().get(0).GetKey() == 'l');
        Assert.assertTrue(tree.Head.GetSubNodes().get(0)
                .GetSubNodes().get(0)
                .GetSubNodes().get(0).GetKey() == 'a');
        Assert.assertTrue(tree.Head.GetSubNodes().get(0)
                .GetSubNodes().get(0)
                .GetSubNodes().get(0)
                .GetSubNodes().get(0).GetKey() == 's');
        Assert.assertTrue(tree.Head.GetSubNodes().get(0)
                .GetSubNodes().get(0)
                .GetSubNodes().get(0)
                .GetSubNodes().get(0)
                .GetSubNodes().get(0).GetKey() == 's');
        Assert.assertTrue(tree.Head.GetSubNodes().get(0)
                .GetSubNodes().get(0)
                .GetSubNodes().get(0)
                .GetSubNodes().get(0)
                .GetSubNodes().get(0)
                .GetSubNodes().get(0).GetKey() == '1');
        Assert.assertTrue(tree.Head.GetSubNodes().get(0)
                .GetSubNodes().get(0)
                .GetSubNodes().get(0)
                .GetSubNodes().get(0)
                .GetSubNodes().get(0)
                .GetSubNodes().get(1).GetKey() == '2');
    }

    @Test
    public void testFind1() throws Exception
    {
        PrefixTree tree = new PrefixTree();
        ClassItem classItem1 = new ClassItem("Class1", 243);
        ClassItem classItem2 = new ClassItem("Class2", 2);
        ClassItem classItem3 = new ClassItem("Cla", 5);
        ClassItem classItem4 = new ClassItem("Abc", 9);

        tree.Incert(classItem1);
        tree.Incert(classItem2);
        tree.Incert(classItem3);
        tree.Incert(classItem4);

        ArrayList<ClassItem> ActualList = tree.FindClassItemsByPrefix("Cla");
        ArrayList<ClassItem> ExpectedList = new ArrayList<ClassItem>(Arrays.asList(classItem3, classItem1, classItem2));

        Assert.assertEquals(ExpectedList, ActualList);
    }

    @Test
    public void testFind2() throws Exception
    {
        PrefixTree tree = new PrefixTree();
        ClassItem classItem1 = new ClassItem("Class1", 243);
        ClassItem classItem2 = new ClassItem("Class2", 2);

        tree.Incert(classItem1);
        tree.Incert(classItem2);

        ArrayList<ClassItem> ActualList = tree.FindClassItemsByPrefix("Class2");
        ArrayList<ClassItem> ExpectedList = new ArrayList<ClassItem>(Arrays.asList(classItem2));

        Assert.assertEquals(ExpectedList, ActualList);
    }
}
