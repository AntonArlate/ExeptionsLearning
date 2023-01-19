package HWork3.Viewer;

import HWork3.Presenter.MyPresenter;

import java.util.Scanner;

public class MyUI implements UIInterface{
    private MyPresenter presenter;
    private Scanner in;

    public void setPresenter(MyPresenter presenter) {
        this.presenter = presenter;
    }

    public void start() {
        in = new Scanner(System.in);
        Boolean begin = true;
        String com;
        String dataString;
//        System.out.print("\033[H\033[J");

        while (begin) {

            System.out.println("------");
            System.out.println("Введите число для соответствующей задачи или иное для выхода:");
            System.out.println("1. Ввести данные.");
            System.out.println("2. Использовать тестовые данные.");
            System.out.println("3. Отобразить данные.");
            System.out.println("4. Сохранить в файл.");

            com = in.nextLine();

            switch (com) {
                case "1": // Ввести данные в ручную
                    System.out.println("Введите следующие данные через пробел: \n " +
                            "Фамилия <строка> Имя <строка> Отчество <строка> \n " +
                            "Дата_рождения <dd.mm.yyyy> \n " +
                            "Номер_телефона <11 цифр без знаков и форматирования> \n " +
                            "пол <символ 'f' или 'm'>");
                    dataString = in.nextLine();
                    // передаём данные в парсер
                        if (presenter.parse(dataString)){
                            System.out.println("Парсинг прошёл успешно. Данные временно сохранены. Вызовите распечатку данных для проверки и затем сохраните в файл");
                        }


                case "2":
                    TestData testData = new TestData();

                    for (String testDataString: testData.testString) {
                        if (presenter.parse(testDataString)){
                            System.out.println("Парсинг прошёл успешно.");
                            presenter.saveInFile();
                        }
                    }

                    break;

                case "3":
                    System.out.println(presenter.getData());
                    break;

                case "4":
                    if (presenter.saveInFile()){
                        System.out.println("Данные записаны в файл");
                    } else System.out.println("Вероятно ошибка сохранения");
                    break;

                default:
                    begin = false;
                    break;
            }
        }

    }

    @Override
    public void sendErrorMessage(String message){
        System.out.println(message);
    }
}

class TestData{
    String[] testString = {
            "Смирнов Томас Васильевич 16.11.1847 89786481564 m",
            "26.05.1770 m 84569723578 Попов Пётр Анатольевич",
            "m 04.09.1951 81568723156 Смирнов Валентин Андреевич"};
}