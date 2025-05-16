# TrieBenchmark

A high-performance Trie data structure implementation in Java, benchmarked with a large real-world English word dataset. This project evaluates the insert and search efficiency of a Trie at multiple dataset sizes, showcasing its suitability for search-heavy applications such as autocomplete and dictionary lookup.

---

## Features

- Efficient insertion of large datasets (up to 370,105 words)
- Fast search operations with near constant-time performance
- Benchmarking across multiple dataset sizes (1K, 10K, 100K, full dataset)
- Detailed performance metrics: insert time, search time, average search time per word
- Simple and extensible Java implementation

---

## Dataset

The benchmarking uses a real-world English word list (`words.txt`) containing **370,105** words sourced from an open dataset.

---

## How to Run

### Prerequisites

- Java JDK 11 or higher installed
- (Optional) Python 3 environment with `matplotlib` and `pandas` for graph plotting

### Compile and Run Benchmark

```bash
javac Trie.java TrieBenchmark.java
java TrieBenchmark
```

## Results Summary

| Dataset Size | Insert Time (ms) | Search Time (ms) | Avg Search Time per Word (ms) |
|--------------|------------------|------------------|-------------------------------|
| 1,000        | 1                | 0.246334         | 0.000246                      |
| 10,000       | 15               | 0.151625         | 0.000152                      |
| 100,000      | 26               | 1.475125         | 0.001475                      |
| 370,105      | 93               | 0.659375         | 0.000659                      |

## Analysis

- **Insert time** increases approximately linearly with the size of the dataset, indicating scalable insertion performance.
- **Search time** remains consistently low across all dataset sizes, demonstrating the efficiency of Trie for lookup operations.
- The average search time per word is in the order of microseconds (~0.0006 ms for the largest dataset), which shows that Trie performs **near constant-time searches**.
- Interestingly, the search time for 10,000 words was slightly better than 1,000 words, likely due to caching effects or system optimizations.
- Overall, the Trie data structure is highly suitable for applications requiring fast and frequent searches, such as autocomplete, spell-checking, and dictionary implementations.

## Plotting Graphs

The benchmark results were visualized using Python's `matplotlib` and `pandas` libraries to better understand the Trie performance trends.

### Graphs Included:
- **Insert Time vs Dataset Size:** Shows how insertion time increases with the number of words.
- **Search Time vs Dataset Size:** Illustrates how search time behaves as dataset size grows.
- **Average Search Time per Word vs Dataset Size:** Demonstrates the near constant-time search performance of the Trie.

### How to Generate Graphs:
1. Make sure Python 3 is installed on your system.
2. Create and activate a virtual environment to avoid permission issues:
   ```bash
   python3 -m venv venv
   source venv/bin/activate
   ```
3. Install required Python libraries:
  ```bash
  pip install matplotlib pandas
  ```
4. Run the graph plotting script:
  ```bash
  python3 plot_graphs.py
  ```
5. The graphs will be saved in the results/ folder as image files (e.g., PNG).

# Note:
If you encounter errors while installing packages system-wide, using a virtual environment is highly recommended to keep dependencies isolated and manageable.

## Author

**Manish Rawat**

- GitHub: [https://github.com/Manishrwt15](https://github.com/Manishrwt15)
- Email: manishrwat15@gmail.com
- LinkedIn: [https://www.linkedin.com/in/manish-rawat-b1b61b269/](https://www.linkedin.com/in/manish-rawat-b1b61b269/)

