public class InvalidCatalogException extends Exception{

    /**
     * custom exception
     * @param e
     */
    public InvalidCatalogException(Exception e){
        super("Invalid catalog file!", e);
    }
}
