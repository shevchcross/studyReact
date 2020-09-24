package studyReact.exceptions;

public class FilmNotFoundException extends Exception {
    public FilmNotFoundException(long productId){
        super("Film with `" + productId + "` doesn't exist");
    }

    public FilmNotFoundException(String name) {super("Film with `" + name + "` doesn't exist"); }
}
