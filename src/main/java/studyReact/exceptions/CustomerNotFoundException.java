package studyReact.exceptions;

public class CustomerNotFoundException  extends Exception{
    public CustomerNotFoundException(long id){
        super("Customer with `" + id + "` doesn't exist");
    }
}
