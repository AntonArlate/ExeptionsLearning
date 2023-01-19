package HWork3.Repo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Parsing {
    private String[] fullName = new String[3];
    private Date brithDate;
    private long telephone;
    private char gender;
    private boolean validCheck = false;


    private List<Exception> errors = new ArrayList<>();
    private String[] dataWords;

    public Parsing(String dataString) {
        this.dataWords = dataString.split(" ");
    }

    public String[] getDataWords() {
        return dataWords;
    }

    public int validationLength() {
        return Integer.compare(this.dataWords.length, 6);
    }

    public void runParse() throws Exception {
        int fioCount = 0;
        int fillCount = 0;
        for (String word : this.dataWords) {
            // отправляем слово на анализ
            int wordType = wordAnalyze(word);

            switch (wordType) {
                case 1:
                    fillCount ++;
                    if (fioCount <= 2) {
                        this.fullName[fioCount] = word;
                        fioCount++;
                    } else {
                        throw new Exception("Слово (" + word + ") определено как часть ФИО, однако оно уже заполнено как " + this.fullName);
                    }
                    break;

                case 2:
                    fillCount ++;
                    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                    try {
                        this.brithDate = formatter.parse(word);
                    } catch (ParseException e) {
                        throw new Exception("Слово (" + word + ") определено как дата, однако на стадии парсинга произошла ошибка");
                    }
                    break;

                case 3:
                    fillCount ++;
                    this.telephone = Long.parseLong(word);
                    break;

                case 4:
                    fillCount ++;
                    this.gender = word.charAt(0);
                    break;

                default:
                    throw new Exception("Слово (" + word + ") не распознано");

            }
        }

        if (fillCount < 6){ // примечание я заметил, что проверка бессмысленна в таком виде, но проверку дубликатов для блокировки счётчка пока не реализовал.
            throw new Exception("Строка распарсена без ошибок. Но данных оказалось не достаточно. Проверьте ввод на дубликаты.");
        }
        this.validCheck = true;
    }

    /**
     * @param word
     * @return 0 = нет совпадений; 1 = FIO; 2 = Date; 3 = Telephone; 4 = Gender
     */
    private int wordAnalyze(String word) {
        int count = 0;
        boolean itsFIO = true;
        boolean itsDate = (word.length() == 10);
        boolean itsTelephone = (word.length() == 11);
        boolean itsGender = (word.length() == 1);

        for (char symbol : word.toCharArray()) {
            count++;

            // определяем дату
            // 3 и 6 символы должны быть точками
            if (itsDate) {
                if (count == 3 || count == 6) {
                    if (symbol != '.') {
                        itsDate = false;
                    } // если на требуемом месте оказалась не точка, это не дата
                } else if (!(Character.isDigit(symbol))) {
                    itsDate = false; // остальные значения должны быть числами
                }
            }

            // проверяем телефон
            if (itsTelephone) {
                if (!(Character.isDigit(symbol))) {
                    itsTelephone = false;
                }
            } // тут всё просто, все 11 символов (которые посчитали в начале) должны быть цифрами

            // проверяем гендер
            if (itsGender) {
                word = word.toLowerCase();
                if (!(word.equals("f") || word.equals("m"))) {
                    itsGender = false;
                }
            }
        }

        // узнаём результаты проверки
        if (itsDate) {
            return 2;
        } else if (itsTelephone) {
            return 3;
        } else if (itsGender) {
            return 4;
        }

        // проверяем ФИО
        if (itsFIO) {
            if ((word.replaceAll("[||\\da-zA-Zа-яёА-ЯЁ]", "")).length() == 0) { // это единственный найденный мной способ сравнения со множеством.
                // В данной функции я убираю из строки все валидные значения и если после в стороке что-то осталось, то это не может быть именем.
                return 1;
            }
        }

        return 0;
    }

    public String[] getFullName() {
        return fullName;
    }

    public Date getBrithDate() {
        return brithDate;
    }

    public String getBrithDateToStrong() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        return formatter.format(brithDate);
    }

    public long getTelephone() {
        return telephone;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return String.format("Фамилия: %s\n" +
                        "Имя: %s\n" +
                        "Отчество: %s\n" +
                        "Дата рождения: %s\n" +
                        "Телефон: %s\n" +
                        "Пол: %s\n",
                this.getFullName()[0],
                this.getFullName()[1],
                this.getFullName()[2],
                this.getBrithDateToStrong(),
                this.getTelephone(),
                this.getGender() );
    }
}

