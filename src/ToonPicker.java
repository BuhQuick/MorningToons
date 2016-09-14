import java.util.ArrayList;
import java.util.Random;

/**
 * ToonPicker takes jumbled data from the CSVReader and converts it into
 * a list of Shows. Each show has a title and a weight, based on how many votes
 * it received. Uses some weighted probability to determine what show
 * we should watch, removes it from the master list, makes it a "to watch"
 * @author Nicholas Buquicchio
 *
 */
public class ToonPicker {
	ArrayList<Show> showList;
	
	public ToonPicker(String name) {
		CSVReader reader = new CSVReader(name);
		ArrayList<String> titlesAndScores = reader.extractValues();
		this.organizeData(titlesAndScores);
	}
	
	/**
	 * Takes messy array from CSV reader and turns it into a list of shows
	 * easily used for show selection
	 * @param list - array of shows and scores in alternating order
	 */
	private void organizeData(ArrayList<String> list) {
		this.showList = new ArrayList<Show>();
		for (int n = 0; n < list.size() - 1; n += 2) {
			this.showList.add(new Show(list.get(n), Integer.parseInt(list.get(n+1))));
			//this.showList[index] = new Show(list[n], Integer.parseInt(list[n+1]));
		}
	}
	
	/**
	 * pick one random show, if chosen, remove from list
	 * @return randomly selected show
	 * EFFECT: removes a show from @param showList
	 */
	private String randomShow() {
		String genShow = "";
		double totalWeight = 0;
		for (Show s : this.showList) {
			totalWeight += s.getWeight();
		}
		Random r = new Random();
		double roll = r.nextDouble() * totalWeight;
		for (Show s : this.showList) {
			roll -= s.getWeight();
			if (roll <= 0.0d) {
				genShow = s.getTitle();
				this.showList.remove(s);
				break;
			}
		}
		
		return genShow;
	}
	
	/**
	 * Returns full list of what shows to watch on a weekend morning
	 * @param shows - total blocks of cartoons to watch
	 * @return list of show titles
	 */
	String[] getShows(int shows) {
		String[] toWatch = new String[shows];
		for (int n = 0; n < shows; n += 1) {
			toWatch[n] = this.randomShow();
		}
		return toWatch;
	}
}
