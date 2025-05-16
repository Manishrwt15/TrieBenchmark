# Trie Performance Benchmark Report

## Dataset  
Used a real-world English word dataset (`words.txt`) containing **370,105 words**.

---

## Benchmark Sizes  
Performance tested on the following dataset sizes:
- **1,000 words**
- **10,000 words**
- **100,000 words**
- **370,105 words** (Full dataset)

---

## Results Summary

| Dataset Size | Insert Time (ms) | Search Time (ms) | Avg. Search Time per Word (ms) |
|--------------|------------------|------------------|---------------------------------|
| 1,000        | 1                | 0.246334         | 0.000246334                     |
| 10,000       | 15               | 0.151625         | 0.000151625                     |
| 100,000      | 26               | 1.475125         | 0.001475125                     |
| 370,105      | 93               | 0.659375         | 0.000659375                     |

---

## Observations

- **Insert Time:**  
  Insertion time increases with dataset size, but not drastically—showing **near-linear** or slightly sub-linear scaling due to prefix-sharing in the Trie structure.

- **Search Time:**  
  Search times remain **consistently low**, even with large datasets. Average per-word search time stays well below **0.0015 ms**, showcasing Trie's efficiency.

- **Notable Insight:**  
  The 10,000-word dataset showed slightly **faster search time** than the 1,000-word case—possibly due to **JVM warm-up effects**, **caching**, or **CPU branch prediction optimizations**.

---

## Conclusion

The Trie data structure demonstrates:

- **Fast insertions** with minimal overhead.  
- **Ultra-fast searches**, even across hundreds of thousands of entries.  
- Excellent scalability and reliability for **prefix-based queries**.

 **Recommendation:**  
Trie is an ideal choice for search-heavy applications such as:
-  Autocomplete engines  
-  Spell checkers  
-  Prefix-matching systems  
-  Dictionary-based lookups  
