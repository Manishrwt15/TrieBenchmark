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

    public static long getUsedMemoryInKB() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        return (runtime.totalMemory() - runtime.freeMemory()) / 1024;
    }

    public static void writeToCSV(String fileName, String data) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(data + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void benchmark(Trie trie, List<String> words, int size, String csvFile) {
        List<String> subList = words.subList(0, size);
        System.out.println("\n====== Testing with " + size + " words ======");

        // === INSERT ===
        long insertMemBefore = getUsedMemoryInKB();
        long startInsert = System.currentTimeMillis();
        for (String word : subList) {
            trie.insert(word);
        }
        long endInsert = System.currentTimeMillis();
        long insertMemAfter = getUsedMemoryInKB();
        long insertMemoryUsed = insertMemAfter - insertMemBefore;

        // === SEARCH ===
        Collections.shuffle(subList);
        List<String> searchWords = subList.subList(0, Math.min(1000, subList.size()));

        long searchMemBefore = getUsedMemoryInKB();
        long startSearch = System.nanoTime();
        int found = 0;
        for (String word : searchWords) {
            if (trie.search(word)) found++;
        }
        long endSearch = System.nanoTime();
        long searchMemAfter = getUsedMemoryInKB();
        long searchMemoryUsed = searchMemAfter - searchMemBefore;

        double totalSearchTime = (endSearch - startSearch) / 1_000_000.0;

        // === OUTPUT ===
        System.out.println("Insert Time: " + (endInsert - startInsert) + " ms");
        System.out.println("Insert Memory Used: " + insertMemoryUsed + " KB");
        System.out.println("Search Time: " + totalSearchTime + " ms");
        System.out.println("Search Memory Used: " + searchMemoryUsed + " KB");
        System.out.println("Avg Time per word: " + (totalSearchTime / searchWords.size()) + " ms");
        System.out.println("Found: " + found + "/" + searchWords.size());

        // === WRITE TO CSV ===
        String row = size + "," + (endInsert - startInsert) + "," + insertMemoryUsed + "," +
                totalSearchTime + "," + searchMemoryUsed + "," + (totalSearchTime / searchWords.size());
        writeToCSV(csvFile, row);
    }

    public static void main(String[] args) throws IOException {
        List<String> words = loadWords("dataset/words.txt");
        int[] sizes = {1000, 10000, 100000, words.size()};

        // CSV header
        String csvFile = "benchmark_results.csv";
        writeToCSV(csvFile, "DatasetSize,InsertTime(ms),InsertMemory(KB),SearchTime(ms),SearchMemory(KB),AvgSearchTimePerWord(ms)");

        for (int size : sizes) {
            Trie trie = new Trie();
            benchmark(trie, words, size, csvFile);
        }
    }
}
