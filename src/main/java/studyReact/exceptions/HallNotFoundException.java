package studyReact.exceptions;

public class HallNotFoundException extends Exception{

    public HallNotFoundException(long id){
        super("Hall with `" + id + "` doesn't exist");
    }

    public HallNotFoundException(String name) {super("Hall with `" + name + "` doesn't exist"); }
}
