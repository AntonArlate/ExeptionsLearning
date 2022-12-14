/*
    Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
    Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
    Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
Если длины массивов не равны, необходимо как-то оповестить пользователя.
    * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
и возвращающий новый массив, каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
Если длины массивов не равны, необходимо как-то оповестить пользователя.
Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.
 */

package HWork1;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class HWork1Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!\n");

        //region Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
        try {
//            zeroDivide();
//            convertError();
            arrayError();
        } catch (Exception e) {
            System.out.println("произошла ошибка: " + e);
        }
        //endregion
        System.out.println("----------");
        //region Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
        AnalysisСode cod = new AnalysisСode(); // предложенный код
        //endregion
        System.out.println("----------");
        //region Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
//      каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
//      Если длины массивов не равны, необходимо как-то оповестить пользователя.
        int[] arr1 = {5, 3, 10};
        int[] arr2 = {3, 4};
        try {
            System.out.println(Arrays.toString(difElementOfArray(arr1, arr2)));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        //endregion
        System.out.println("----------");
        //region * Реализуйте метод
        arr2 = new int[]{3, 4, 0};
        try {
            System.out.println(Arrays.toString(divElementOfArray(arr1, arr2)));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        //endregion

    }

    public static void zeroDivide() {
        System.out.println(1 / 0);
    }

    public static void convertError() {
        Object s = "aaa";
        Character c = ((Character) s);
    }

    public static void arrayError() {
        int[] arr = new int[2];
        System.out.println(arr[2]);
    }

    public static int[] difElementOfArray(int[] arr1, int[] arr2) throws Exception {
        if (arr1.length != arr2.length) {
            throw new Exception("Массивы не равны");
        }
        int[] result = new int[arr1.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = arr1[i] - arr2[i];
        }

        return result;
    }

    public static double[] divElementOfArray(int[] arr1, int[] arr2) throws Exception {
        if (arr1.length != arr2.length) {
            throw new Exception("Массивы не равны");
        }
        double[] result = new double[arr1.length];

        try {
            for (int i = 0; i < result.length; i++) {
                result[i] = (double) arr1[i] / (double) arr2[i];
            }
        }catch (Throwable e){
            throw new Exception("Что-то пошло не так");
        }
        return result;
    }

}

class AnalysisСode { // предложеный код
    public AnalysisСode() throws Exception { // не будет срабатывать так как перехватывается обработчиком как (Throwable ex)
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2};
            abc[3] = 9; // место возникновения исключения
        } catch (
                Throwable ex) { // это родительский класс всех остальных исключений, находясь первым он будет срабатывать на любое перехваченное исключение.
            System.out.println("Что-то пошло не так...");
        }
//            catch (NullPointerException ex) {
//                System.out.println("Указатель не может указывать на null!");
//            }
//            catch (IndexOutOfBoundsException ex) {
//                System.out.println("Массив выходит за пределы своего размера!");
//            }
    }

    public static void printSum(Integer a, Integer b) throws FileNotFoundException { // exeption при открытии файла. В методе функция не реализована
        System.out.println(a + b);
    }
}



