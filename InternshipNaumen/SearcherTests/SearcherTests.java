import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Roman on 19/04/2015.
 */
public class SearcherTests
{

    @Test
    public void testSearcher1() throws Exception
    {
        String[] names = {"Class1", "Class2", "Cla", "Abc", "abc"};
        long[] dates = {Long.valueOf(11), Long.valueOf(64), Long.valueOf(35), Long.valueOf(61), Long.valueOf(32)};

        Searcher searcher = new Searcher();
        String start = "Cla";
        searcher.Refresh(names,  dates);

        String[] actualNames = searcher.Guess(start);
        String[] expectedNames = {"Class1", "Cla", "Class2"};

        Assert.assertEquals(expectedNames, actualNames);
    }

    @Test
    public void testSearcher2() throws Exception
    {
        String[] names = {"Class1", "Class2", "Cla", "Abc", "abc"};
        long[] dates = {Long.valueOf(11), Long.valueOf(64), Long.valueOf(35), Long.valueOf(61), Long.valueOf(32)};

        Searcher searcher = new Searcher();
        String start = "ab";
        searcher.Refresh(names,  dates);

        String[] actualNames = searcher.Guess(start);
        String[] expectedNames = {"abc"};

        Assert.assertEquals(expectedNames, actualNames);
    }
}
