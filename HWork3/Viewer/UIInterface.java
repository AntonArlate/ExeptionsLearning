package HWork3.Viewer;

import HWork3.Presenter.MyPresenter;
import HWork3.Presenter.PresenterInterface;

public interface UIInterface {
    void setPresenter(MyPresenter presenter);
    void start();

    void sendErrorMessage(String message);
}
