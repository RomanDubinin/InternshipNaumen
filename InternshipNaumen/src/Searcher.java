import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Roman on 19/04/2015.
 */
public class Searcher implements ISearcher
{
    private PrefixTree PrefixTree;
    private final int MaxNum = 12;

    public Searcher()
    {
        PrefixTree = new PrefixTree();
    }

    @Override
    public void Refresh(String[] classNames, long[] modificationDates)
    {
        if (classNames.length != modificationDates.length)
            throw new IllegalArgumentException("arrays must have same lenghts!");

        int n = classNames.length;
        for (int i = 0; i < n; i++)
        {
            ClassItem classItem = new ClassItem(classNames[i], modificationDates[i]);
            PrefixTree.Incert(classItem);
        }
    }

    @Override
    public String[] Guess(String start)
    {
        ArrayList<ClassItem> foundItems = PrefixTree.FindClassItemsByPrefix(start);
        int realNum = Math.min(foundItems.size(), MaxNum);


        Collections.sort(
                foundItems,
                (item1, item2) -> (int) (item2.GetModificationDate() - item1.GetModificationDate()));

        List<ClassItem> selected = foundItems.subList(0, realNum);

        String[] result = new String[realNum];
        for (int i = 0; i < realNum; i ++)
            result[i] = selected.get(i).GetName();

        return result;
    }
}
