lines = load 'WCFile' AS (line:Chararray);
twords = Foreach lines generate TOKENIZE(line) AS word;
words = Foreach lines generate FLATTEN(TOKENIZE(line)) as word;
grouped = group words by word;
count = foreach grouped generate group,COUNT(words);
store count into 'Word_count_result' using PigStorage (',');
