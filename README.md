# Wikipedia-Crawler-Inverted-Index
The "Wikipedia-Crawler-Inverted-Index" project is a Java-based application designed for information retrieval tasks. It combines web crawling with inverted indexing and cosine similarity computation to enable efficient searching and ranking of Wikipedia articles based on user queries.


Functionality
The project offers the following key functionalities:

1. Web Crawling:
The web crawler starts from a seeded Wikipedia page (https://en.wikipedia.org/wiki/List_of_pharaohs) and traverses through hyperlinks to collect relevant Wikipedia articles.

2.Inverted Indexing:
As the crawler visits each page, it builds an inverted index, mapping terms to the documents (Wikipedia articles) where they appear. This inverted index facilitates fast information retrieval by enabling quick lookup of documents containing specific terms.

3. Cosine Similarity Computation:
After building the inverted index, the project allows users to input a query, which consists of a set of words. It computes the cosine similarity between each document (Wikipedia article) and the query.

4.Ranking:
Finally, the project ranks the top k=10 documents based on their cosine similarity values with the query. This ranking helps users identify the most relevant Wikipedia articles related to their query.
