import matplotlib.pyplot as plt
import pandas as pd

# Load the CSV file
df = pd.read_csv("results/trie_benchmark_results.csv")

# Dataset sizes
sizes = df["Dataset Size"]

# Plot 1: Insert Time vs Dataset Size
plt.figure(figsize=(8, 5))
plt.plot(sizes, df["Insert Time (ms)"], marker='o', color='blue')
plt.title("Insert Time vs Dataset Size")
plt.xlabel("Dataset Size")
plt.ylabel("Insert Time (ms)")
plt.grid(True)
plt.savefig("results/insert_time_vs_dataset_size.png")
plt.close()

# Plot 2: Total Search Time vs Dataset Size
plt.figure(figsize=(8, 5))
plt.plot(sizes, df["Search Time (ms)"], marker='o', color='green')
plt.title("Search Time vs Dataset Size")
plt.xlabel("Dataset Size")
plt.ylabel("Search Time (ms)")
plt.grid(True)
plt.savefig("results/search_time_vs_dataset_size.png")
plt.close()

# Plot 3: Avg Search Time per Word vs Dataset Size
plt.figure(figsize=(8, 5))
plt.plot(sizes, df["Avg Search Time per Word (ms)"], marker='o', color='red')
plt.title("Avg Search Time per Word vs Dataset Size")
plt.xlabel("Dataset Size")
plt.ylabel("Avg Time per Word (ms)")
plt.grid(True)
plt.savefig("results/avg_time_per_word_vs_dataset_size.png")
plt.close()

print("✅ Graphs saved in results/ folder")
