import java.util.HashMap;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.Map;

public class Library {
    private final static String[] BOOKS = {
			"Priests Of Dawn",
            "Chicken Abroad",
            "Lord With Sins",
            "Chicken Abroad",
            "Fish And Horses",
            "Mistress Of Devotion",
            "Bandit Of The Void",
            "Lord With Sins",
            "Guardians And Gangsters",
            "Lions Of Dread",
            "Chicken Abroad",
            "Future Of Fire",
            "Priests Of Dawn",
            "Fish And Horses",
            "Chicken Abroad",
            "Fish And Horses",
            "Guardians And Gangsters",
            "Inception Of Heaven",
            "Lord With Sins",
            "Future Of Fire",
            "Driving Into The Depths",
            "Starting The Demons",
            "Maid With Blue Eyes",
            "Mistress Of Devotion",
            "Lovers In The Forest",
            "Fish And Horses",
            "Maid With Blue Eyes",
            "Destruction Of The Faceless Ones",
            "Guardians And Gangsters",
            "Chicken Abroad"};
	
    public static final HashMap<String, Integer> createBooksHashMap() {
		
		HashMap<String, Integer> booksHashMap = new HashMap<>();
		
		for (int i = 0; i < BOOKS.length; i++) {
			if (booksHashMap.containsKey(BOOKS[i])) {
				booksHashMap.put(BOOKS[i], booksHashMap.get(BOOKS[i]) + 1);
			} else {
				booksHashMap.put(BOOKS[i], 1);
			}
		}
		
        return booksHashMap;
	}

    public static final ArrayList<String> findWhiteRavens(HashMap<String, Integer> booksCounter) {
						
        return booksCounter.entrySet().stream()
				.filter(n -> n.getValue() == 1)
				.map(n -> n.getKey())
				.collect(Collectors.toCollection(ArrayList::new));
    }
	
	public static final int countBooks(HashMap<String, Integer> booksCounter) {
		
		return booksCounter.entrySet().stream()
				.map(n -> n.getValue())
				.reduce(0, Integer::sum);
    }
	
	public static void listAvailablePositions(HashMap<String, Integer> booksHashMap) {
		
		booksHashMap.entrySet().stream()
			.sorted(Comparator.comparing(n -> n.getKey()))
			.map(n -> " - " + n.getValue() + "x " + n.getKey())
			.forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		
		System.out.println("\nWelcome to Library!");
		
		HashMap<String, Integer> booksHashMap = createBooksHashMap();
		
		System.out.println("\nTotal number of books in librabry: " + countBooks(booksHashMap));
		
		System.out.println("Available positions:");
		listAvailablePositions(booksHashMap);
		
		System.out.println("\nList of 'white ravens' (boooks that occour only once in library):");
		findWhiteRavens(booksHashMap).stream().sorted().map(n -> " - " + n).forEach(System.out::println);
	}
}