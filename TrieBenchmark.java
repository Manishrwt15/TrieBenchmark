import java.io.*;
import java.util.*;

public class TrieBenchmark {

    public static List<String> loadWords(String filePath) throws IOException {
        List<String> words = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            words.add(line.trim().toLowerCase());
        }
        reader.close();
        return words;
    }

    public static void benchmark(Trie trie, List<String> words, int size) {
        List<String> subList = words.subList(0, size);

        System.out.println("\n====== Testing with " + size + " words ======");

        // Insert
        long startInsert = System.currentTimeMillis();
        for (String word : subList) {
            trie.insert(word);
        }
        long endInsert = System.currentTimeMillis();

        // Search
        Collections.shuffle(subList);
        List<String> searchWords = subList.subList(0, Math.min(1000, subList.size()));

        long startSearch = System.nanoTime();
        int found = 0;
        for (String word : searchWords) {
            if (trie.search(word)) found++;
        }
        long endSearch = System.nanoTime();

        double totalSearchTime = (endSearch - startSearch) / 1_000_000.0;

        System.out.println("Insert Time: " + (endInsert - startInsert) + " ms");
        System.out.println("Search Time: " + totalSearchTime + " ms");
        System.out.println("Avg Time per word: " + (totalSearchTime / searchWords.size()) + " ms");
        System.out.println("Found: " + found + "/" + searchWords.size());
    }

    public static void main(String[] args) throws IOException {
        List<String> words = loadWords("dataset/words.txt");
        int[] sizes = {1000, 10000, 100000, words.size()};

        for (int size : sizes) {
            Trie trie = new Trie();  // fresh trie for each test
            benchmark(trie, words, size);
        }
    }
}
