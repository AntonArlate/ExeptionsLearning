package HWork3.Presenter;

import HWork3.Repo.DataRepo;
import HWork3.Viewer.MyUI;

public class MyPresenter implements PresenterInterface{
    private MyUI uiInterface;
    private DataRepo dataRepoInterface;

    public MyPresenter(MyUI uiInterface, DataRepo dataRepoInterface) {
        this.uiInterface = uiInterface;
        uiInterface.setPresenter(this);
        this.dataRepoInterface = dataRepoInterface;
        dataRepoInterface.setPresenter(this);
    }

    @Override
    public boolean parse(String dataString) {
        return dataRepoInterface.parse(dataString);
    }

    @Override
    public void sendErrorMessage(String message){
        uiInterface.sendErrorMessage(message);
    }

    public boolean saveInFile(){
        return dataRepoInterface.saveInFile();
    }

    public String getData(){
        return dataRepoInterface.getData();
    }



}
