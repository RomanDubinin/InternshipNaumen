/**
 * Created by Roman on 18/04/2015.
 */
public class ClassItem
{
    private String Name;
    private long ModificationDate;

    public ClassItem(String name, long modificationDate)
    {
        Name = name;
        ModificationDate = modificationDate;
    }

    public String GetName()
    {
        return Name;
    }

    public long GetModificationDate()
    {
        return ModificationDate;
    }
}
