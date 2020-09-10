package lesson5;

import java.util.Arrays;

public class MainLesson5 {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args){
        doCalculation1(createArray());
        System.out.println();
        doCalculation2(createArray());
    }

    static float[] createArray(){
        float[] array = new float[size];
        Arrays.fill(array,1.0f);
        return array;
    }

    static void doCalculation1(float[] array){
        System.out.println("Начало работы первого метода...");
        long a = System.currentTimeMillis();
        for(int i = 0; i < array.length; i++){
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время работы первого метода:");
        System.out.println(System.currentTimeMillis() - a);
    }

    static void doCalculation2(float[] array){
        System.out.println("Начало работы второго метода...");
        float[] array1 = new float[h];
        float[] array2 = new float[h];
        System.arraycopy(array, 0, array1, 0, h);
        System.arraycopy(array, h, array2, 0, h);
        long b = System.currentTimeMillis();
        System.out.println(String.format("Время выполнения разделения массива: %s",b));
        Thread calc1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < array1.length; i++) {
                    array1[i] = (float)(array1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        calc1.start();
        Thread calc2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < array2.length; i++) {
                    array1[i] = (float)(array2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        calc2.start();
        try {
            calc1.join();
            calc2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long c = System.currentTimeMillis();
        System.out.println(String.format("Время выполнения просчета массивов: %s",c - b));
        System.arraycopy(array1, 0, array, 0, h);
        System.arraycopy(array2, 0, array, h, h);
        System.out.println("Время Время выполнения склейки массивов:");
        System.out.println(System.currentTimeMillis() - c);
    }
}
