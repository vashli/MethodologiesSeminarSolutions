import java.util.Iterator;

public interface Final2022Session1Footballer {
	public void addFootballPlayer(String club, String player);
	public Iterator<String> getClubs(String player);
	public Iterator<String> getPlayers(String club, int n);
}
