This custom github fetcher will do the following
1. Grab the all the commit sequence history. 
2. Use the sha to access the file name of the file changes at each commit.
3. Look into changes of each file and see if a class is created.
4. Output the order of class creation to XML

This index.html must be run on the localhost in order to use Github api.