/**
 * Created by Roman on 19/04/2015.
 */
public interface ISearcher
{
    void Refresh(String[] classNames, long[] modificationDates);
    String[] Guess(String start);
}
