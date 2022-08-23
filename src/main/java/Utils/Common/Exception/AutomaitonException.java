package Utils.Common.Exception;

public class AutomaitonException extends Exception{
    public AutomaitonException(String message)
    {
        super(message);
    }
    public AutomaitonException(Exception exception)
    {
        super(exception);

    }

}
