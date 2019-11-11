package dev.jfuture.task.exception;

public class WebsiteParsingException extends Exception {

    public WebsiteParsingException() {}

    public WebsiteParsingException(String message){
        super(message);
    }

    public WebsiteParsingException(Exception exception){
        super(exception);
    }

    public WebsiteParsingException(String message, Exception exception){
        super(message, exception);
    }

}
