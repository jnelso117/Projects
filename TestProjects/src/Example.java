import java.util.*;

import com.treehouse.treet.*;
public class Example {

	public static void main(String[] args) {
		

//		Treet treet = new Treet("nagato6192","Mad Max tonight! #MadMax #Carmike #Furiosaisbae", new Date(1431626304L));
//		// TODO Auto-generated method stub
//		//Treehouse example
//		Treet secondTreet = new Treet("journeytocode","@treehouse makes java so fun", new Date());
//		System.out.printf("This is a new Treet: %s %n", treet);
//		System.out.println("The words are:");
//		for (String word : treet.getWords()) {
//			System.out.println(word);
//		}
//		Treet[] treets = {treet, secondTreet};
//		Arrays.sort(treets);
//		for(Treet exampleTreet : treets) {
//			System.out.println(exampleTreet);
//		}
//		Treets.save(treets);
//		Treet [] reloadedTreets = Treets.load();
//		for (Treet reloaded: reloadedTreets) {
//			System.out.println(reloaded);
//		}
		Treet[] treets = Treets.load();
		System.out.printf("There are %d treets, %n", treets.length);
		//Tree sets are HashSets sorted to alphabetical order
		Set<String> allHashTags = new TreeSet<String>();
		Set<String> allMentions = new TreeSet<String>();
		for(Treet t: treets) {
			allHashTags.addAll(t.getHashTags());
			allMentions.addAll(t.getMentions());
		}
		System.out.printf("All the hashtags: %S %n", allHashTags);
		System.out.printf("All the mentions: %s %n", allMentions);
		
		Map<String, Integer> hashTagCount = new HashMap<String, Integer>();
		for (Treet t: treets) {
			for (String hashTag : t.getHashTags()) {
				Integer count = hashTagCount.get(hashTag);
				if (count == null) {count = 0;}
				count = count + 1;
				hashTagCount.put(hashTag, count);
			}
			
		}
		System.out.printf("hash tag counts: %s %n", hashTagCount);
	}
}
