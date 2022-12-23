/*
Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
вместо этого, необходимо повторно запросить у пользователя ввод данных.

2. Если необходимо, исправьте данный код (задание 2
try {
   int d = 0;
   double catchedRes1 = intArray[8] / d;
   System.out.println("catchedRes1 = " + catchedRes1);
} catch (ArithmeticException e) {
   System.out.println("Catching exception: " + e);
}


Дан следующий код, исправьте его там, где требуется (задание 3
public static void main(String[] args) throws Exception {
   try {
       int a = 90;
       int b = 3;
       System.out.println(a / b);
       printSum(23, 234);
       int[] abc = { 1, 2 };
       abc[3] = 9;
   } catch (Throwable ex) {
       System.out.println("Что-то пошло не так...");
   } catch (NullPointerException ex) {
       System.out.println("Указатель не может указывать на null!");
   } catch (IndexOutOfBoundsException ex) {
       System.out.println("Массив выходит за пределы своего размера!");
   }
}
public static void printSum(Integer a, Integer b) throws FileNotFoundException {
   System.out.println(a + b);
}


Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 */

package HWork2;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HWork2Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!\n");



        // задание 1
        IOmethod();

        //    задание 2
        example2();
        // задание 3
        example3();

        // задание 4 (Exception empty in)
        try {
            hasEmptyIn();
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());;
        }
//        NewClass newClass = new NewClass();
//        newClass.hasEmptyIn();

    }

    public static void IOmethod() {
        float number = 0;
        boolean check = false;
        Scanner in;
        in = new Scanner(System.in);

        System.out.printf("Введите число: ");

        while (!check) {
            try {
                number = in.nextFloat();
                System.out.println(number);
                check = true;
            } catch (InputMismatchException e) {
                in.nextLine();
                System.out.printf("Не является числом. Попробуйте ещё раз: ");
            }
        }
//        in.close(); // почему эта строка вызывает ошибку при следующем использовании сканера в другом методе
    }


    //    задание 2
    public static void example2 (){
        try {
            int d = 0;
            double catchedRes1 = 10 / d; // нет массива, возьмём любое число
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (
                ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }

    // задание 3
    public static void example3() throws Exception {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;

            // меняем местами порядок перехвата
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }

    //    задание 4
    public static void hasEmptyIn () throws InputMismatchException{
        Scanner inner;
        inner = new Scanner(System.in);

        System.out.printf("Введите строку: ");
        String str = inner.nextLine();

        if (str != ""){
            System.out.println(str);
        }
        else {
            throw new InputMismatchException("Пустая строка не допустима.");
        }
    }

}

// test class
class NewClass {
    public void hasEmptyIn (){
        Scanner inner;
        inner = new Scanner(System.in);

        System.out.printf("Введите строку: ");

        String str;
        str = inner.next();
        System.out.println(str);

//        if (str != ""){
//            System.out.println(str);
//        }
//        else {
//            sc.close();
////            throw new InputMismatchException("Пустая строка не допустима.");
//        }

        inner.close();
    }
}
