package Lesson30_linkedHashMap.homework.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    static TreeMap<Integer, Movie> movies = new TreeMap<>();
    static TreeMap<Integer, User> users = new TreeMap<>();

    public static void main(String[] args) {
        movies.put(1, new Movie(1, "Shawshank Redemption", "Drama", "Tim Robbins", "Morgan Freeman", "Frank Dorabant"));
        movies.put(2, new Movie(2, "The Dark Knight", "Action", "Christian Bale", "Heath Ledger", "Christopher Nolan"));
        movies.put(3, new Movie(3, "Inception", "Sci-Fi", "Leonardo DiCaprio", "Joseph Gordon-Levitt", "Christopher Nolan"));
        movies.put(4, new Movie(4, "The Godfather", "Drama", "Marlon Brando", "Al Pacino", "Francis Ford Coppola"));

        users.put(1, new User(1, "John Doe", 1, 2));

        List<Movie> ListOfRecommenderMovies = recommendMovies(1, 3);
        for (Movie movie : ListOfRecommenderMovies) {
            System.out.println("id: " + movie.id + ", title: " + movie.title);
        }
    }

    static List<Movie> recommendMovies (int userId, int maxRecommendations) {
        List<Movie> recommendedMovies = new ArrayList<>();
        User user = users.get(userId);
        for (Map.Entry<Integer, Movie> entry : movies.entrySet()) {
            if(recommendedMovies.size() == maxRecommendations) {
                break;
            }
            Movie currentMovie = entry.getValue();

            for (Integer movieId : user.watchedMovies) {
                if (currentMovie.id == movies.get(movieId).id) {
                    continue;
                }

                if (currentMovie.genre.equals(movies.get(movieId).genre) || movies.get(movieId).actors.contains(currentMovie.actors.get(0)) || movies.get(movieId).actors.contains(currentMovie.actors.get(1)) || currentMovie.director.equals(movies.get(movieId).director)) {
                    recommendedMovies.add(currentMovie);
                }
            }
        }

        return recommendedMovies;
    }
}
