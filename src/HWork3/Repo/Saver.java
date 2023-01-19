// <Фамилия><Имя><Отчество><датарождения><номертелефона><пол>

package HWork3.Repo;

import java.io.*;
import java.util.Scanner;

public class Saver {

    public boolean saveInFile(Parsing preparedData) throws IOException{
        boolean checkSave = false;
        String filPath =preparedData.getFullName()[0] + ".txt";
        File file = new File(filPath);
        //если файла нет создадим его
        if (!(file.exists() && !file.isDirectory())){
//            try {
                file.createNewFile();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
        }

        // генерируем строку на запись
        String str = String.format("<%s><%s><%s><%s><%s><%s>",
                preparedData.getFullName()[0],
                preparedData.getFullName()[1],
                preparedData.getFullName()[2],
                preparedData.getBrithDateToStrong(),
                preparedData.getTelephone(),
                preparedData.getGender() );

        // сканируем отсутствие дубликата
//        boolean duplicate;
//        try {
//            duplicate = checkduplicate(filPath, str);
            // открываем файл на запись если нет дупликатов
            if (!checkduplicate(filPath, str)){
                FileWriter fileW = new FileWriter(filPath, true);
                fileW.write(str + "\n"); // производим запись
                checkSave = true;
                fileW.close();
            }
            else {
                throw new IOException("В файле обнаружен дубликат, добавление отменено");
            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        /*
        // вариант отдельного try-catch для записи
        if (!duplicate){
            try (FileWriter fileW = new FileWriter(filPath, true)){
                fileW.write(str); // производим запись
                checkSave = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        */

        return checkSave;
    }

    private boolean checkduplicate (String filPath, String str) throws IOException {
        FileReader fileR = new FileReader(filPath);
        Scanner scan = new Scanner(fileR);

        while (scan.hasNextLine()) {
            String eq = scan.nextLine();
            if (str.equals(eq)){
                fileR.close();
                return true;
            }
        }

        fileR.close();
        return false;
    }
}
