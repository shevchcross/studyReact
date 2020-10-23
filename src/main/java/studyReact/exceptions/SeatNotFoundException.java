package studyReact.exceptions;

public class SeatNotFoundException extends Exception{

    public SeatNotFoundException(long id){
        super("seat with `" + id + "` doesn't exist");
    }
}
