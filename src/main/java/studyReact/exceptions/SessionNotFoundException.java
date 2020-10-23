package studyReact.exceptions;

public class SessionNotFoundException extends Exception {
    public SessionNotFoundException(long id) {
        super("Session with `" + id + "` doesn't exist");
    }
}
