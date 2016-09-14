
/**
 * Representation of a show.
 * @author Nicholas Buquicchio
 *
 */
public class Show {
	private String title;
	private int weight;
	
	/**
	 * Show object.
	 * @param title    : title of show
	 * @param weight   : how many votes it received amongst roommates
	 */
	public Show(String title, int weight) {
		this.title = title;
		this.weight = weight;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Show)) { return false; }
		else {
			Show s = (Show)o;
			return s.getTitle() == this.title &&
					s.getWeight() == this.weight;
		}
	}
}
