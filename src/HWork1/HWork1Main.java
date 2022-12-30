/*
    Реализуйте 3 метода, чтобы в каждом из них получить разные исключения

    Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
Если длины массивов не равны, необходимо как-то оповестить пользователя.
    * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
и возвращающий новый массив, каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
Если длины массивов не равны, необходимо как-то оповестить пользователя.
Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.
 */

package HWork1;


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
        //region Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
//      каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
//      Если длины массивов не равны, необходимо как-то оповестить пользователя.
        int[] arr1 = {5, 3, 10};
        int[] arr2 = {3, 4, -1};
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
//            System.out.println(Arrays.stream(arr2)
//                    .filter(num -> num == 0)
//                    .findFirst()
//                    .isEmpty());
            // это первая попытка использования стрима. В ином случае я пониаю что рациональней делать проверку
            // условием во время перебора Так как в большинстве случаев у нас нуля не ожидается и перебирать каждый раз
            // весь массив возможно менее эффективно

            if (!Arrays.stream(arr2)
                    .filter(num -> num == 0)
                    .findFirst()
                    .isEmpty()) {throw new ArithmeticException("деление на ноль");}

            for (int i = 0; i < result.length; i++) {
                result[i] = (double) arr1[i] / (double) arr2[i];
            }
        }catch (ArithmeticException e){
            throw new ArithmeticException(e.getMessage());
        }catch (Throwable e){
            throw new Exception("Что-то пошло не так");
        }
        return result;
    }

}

/*
Убрано задание которое было предназначено для второго урока.
Для последней задачи в методе divElementOfArray() была реализована попытка перехвата деления на ноль.
 */


