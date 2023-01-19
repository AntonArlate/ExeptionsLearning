package HWork3.Repo;

import HWork3.Presenter.MyPresenter;

import java.io.IOException;

public class DataRepo implements DataRepoInterface {
    private MyPresenter presenter;

    @Override
    public void setPresenter(MyPresenter presenter) {
        this.presenter = presenter;
    }

    private Parsing parseData;
    private Saver saver = new Saver();

    @Override
    public boolean parse(String dataString) {
        // создаём класс в котором будем парсить
        parseData = new Parsing(dataString);
        // проверяем длину
        int error = parseData.validationLength();
        if (error == -1) {
            presenter.sendErrorMessage("Введено меньше чем 6 данных");
        } else if (error == 1) {
            presenter.sendErrorMessage("Введено больше чем 6 данных");
        }
        // если с длиной всё в порядке, выполняем парсинг
        else {
            try {
                parseData.runParse();
                return true;
            } catch (Exception e) {
                presenter.sendErrorMessage(e.getMessage());
            }
        }
        return false;
    }

    public boolean saveInFile (){
        try {
            saver.saveInFile(parseData);
            return true;
        } catch (IOException e) {
            presenter.sendErrorMessage(e.getMessage());
        }
        return false;
    }

    public String getData (){
        return parseData.toString();
    }


}
