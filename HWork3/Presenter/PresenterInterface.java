package HWork3.Presenter;

public interface PresenterInterface {
    boolean parse(String dataString) throws Exception;

    void sendErrorMessage(String message);
}
