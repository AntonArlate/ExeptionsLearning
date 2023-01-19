package HWork3.Repo;

import HWork3.Presenter.MyPresenter;

public interface DataRepoInterface {
    void setPresenter(MyPresenter presenter);

    boolean parse(String dataString) throws Exception;
}
