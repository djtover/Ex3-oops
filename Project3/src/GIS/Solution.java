package GIS;

public class Solution {
	
	private Game game;

	public Solution( Game g) {
		game = g;
	}
	public Solution(Solution other) {
		game = other.game;
	}
	public String toString() {
		return game.toString();
	}
	public Game getGame() {
		return game;
	}
}
