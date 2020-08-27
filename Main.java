package lesson2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        int x,y;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите длину двумерного строкового массива");
        x = sc.nextInt();
        y = sc.nextInt();
        String[][] array = new String[x][y];

        try{
            createArray(array, sc, x, y);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static void createArray(String[][] array, Scanner sc, int x, int y){
        if(x != 4 || y != 4){
            throw new MyArraySizeException("Введена неверная длина массива " + x +" " + y);
        } else {
            System.out.println("Заполните массив");
            for(int i = 0; i < array.length; i++){
                for(int j = 0; j < array.length; j++){
                    array[i][j] = sc.next();
                }
            }
        }
        calculateArr(array, x, y);
    }

    private static void calculateArr(String[][] array, int x, int y) {
        int sum = 0;
        int[][] intArray = new int[x][y];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    intArray[i][j] = Integer.parseInt(array[i][j]);
                    sum += intArray[i][j];
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверное преобразование символьной строки в числовой формат");
                }
            }
        }
        System.out.println(String.format("Сумма равна %s", sum));
    }

}
