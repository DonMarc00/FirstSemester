package sorty;

public interface DataListener {

    public void beforeSwapping(int replacePosition, int withPosition);

    public void afterSwapping(int replacePosition, int withPosition);

    public void readAccess(int position);
}
