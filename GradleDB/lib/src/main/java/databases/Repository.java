package databases;


public interface Repository {

	public void storeCard(Card card);
	
	public Card loadCard(int id);
	
	public void deleteCard(int id);
}
