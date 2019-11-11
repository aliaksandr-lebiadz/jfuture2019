# JFuture 2019

## Task
Imagine that you're a developer working on Cinema Analytics System, who needs to collect data and make calculations on the following items:

1. Display the dynamics of film releases in China and the United States over the past 3 years. Please take into account 5 different film genres.

2. Make the list of top 5 Directors of the highest-rated films.

## Running instruction
In order to run the program, you need to use Maven.

1. Set current directory to project directory;

2. Build .war archive of the project using

    ```
    mvn compile war::war
    ```

3. Deploy the built .war file to the any servlet container

## Algorithm description
* Task 1:
    In the first task movies are being collected from the Wikipedia tables.
    Then it finds out the most popular genres of movies and counts amount of movies 
    of the each genre. Then the results are presented in the web page.
    
    **Information gathering** class: [MoviesParser](src/main/java/dev/jfuture/task/parser/movie/MoviesParser.java)
    
    **Calculations** classes: [MoviesCalculator](src/main/java/dev/jfuture/task/calculator/MoviesCalculator.java) and
    [MoviesCalculatorHelper](src/main/java/dev/jfuture/task/service/MoviesCalculatorHelper.java)
    
    ---
    
* Task 2:
    In the second task movies are being collected from the IMDb rating.
    The list of the movies should be distinct by director, because we
    need to have the list of directors.
    
    For **information gathering** and **calculations** see [DirectorsParser](src/main/java/dev/jfuture/task/parser/director/DirectorsParser.java)