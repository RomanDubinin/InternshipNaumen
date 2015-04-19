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
        String prefix = "Cla";
        searcher.Refresh(names,  dates);

        String[] actualNames = searcher.Guess(prefix);
        String[] expectedNames = {"Class2", "Cla", "Class1"};

        Assert.assertEquals(expectedNames, actualNames);
    }

    @Test
    public void testSearcher2() throws Exception
    {
        String[] names = {"Class1", "Class2", "Cla", "Abc", "abc"};
        long[] dates = {11,64, 35, 61, 32};

        Searcher searcher = new Searcher();
        String prefix = "ab";
        searcher.Refresh(names,  dates);

        String[] actualNames = searcher.Guess(prefix);
        String[] expectedNames = {"abc"};

        Assert.assertEquals(expectedNames, actualNames);
    }

    @Test
    public void testSearcher3() throws Exception
    {
        String[] names = new String[100000];
        long[] dates = new long[100000];

        int k = 0;
        for (int i = 0; i < 100000; i++)
        {
            names[i] = String.valueOf(i);
            dates[i] = i;
        }

        Searcher searcher = new Searcher();
        String prefix = "12";

        long start = System.nanoTime();
        searcher.Refresh(names, dates);
        long end = System.nanoTime();
        long traceTime = end-start;
        System.out.println(traceTime / 1e9);

        start = System.nanoTime();
        String[] actualNames = searcher.Guess(prefix);
        end = System.nanoTime();
        traceTime = end-start;
        System.out.println(traceTime / 1e9);

        String[] expectedNames = {"12999", "12998", "12997", "12996", "12995", "12994", "12993", "12992", "12991", "12990", "12989", "12988"};

        Assert.assertEquals(expectedNames, actualNames);
    }
}
