package pl.grzegorz.projects.WEBDiabloPage.model.exceptions;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(String message){
        super(message);
    }
}
