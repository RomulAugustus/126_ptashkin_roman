import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Task_4 implements Task_4_base {
    @Override
    public int[] subtask_1_arrays(int size, int a0, int d) {
        // сгенерировать и вернуть массив размера size, содержащий элементы
        // арифметической прогрессии с первым членом a0 и разностью d
        int[] progression = new int[size];
        progression[0] = a0;
        for (int i = 1; i < size; i++) {
            progression[i] = progression[i - 1] + d;
        }
        return progression;
    }

    @Override
    public int[] subtask_2_arrays(int size) {
        // сгенерировать и вернуть массив размера size, первые два элемента
        // которого равны единице, а каждый следующий - сумме всех предыдущих
        int[] progression = new int[size];
        if (size == 1) {
            progression[0] = 1;
            return progression;
        }
        progression[0] = 1; progression[1] = 1;
        for (int i = 2; i < size; i++) {
            int value = 0;
            for (int j = 0; j < i; j++) {
                value += progression[j];
            }
            progression[i] = value;
        }
        return progression;
    }

    @Override
    public int[] subtask_3_arrays(int size) {
        // сгенерировать и вернуть массив размера size, содержащий первые
        // size чисел последовательности фибоначчи.
        // https://ru.wikipedia.org/wiki/Числа_Фибоначчи
        int[] progression = new int[size];
        if (size == 1) {
            progression[0] = 0;
            return progression;
        }
        progression[0] = 0; progression[1] = 1;
        for (int i = 2; i < size; i++) {
            progression[i] = progression[i - 2] + progression[i - 1];
        }
        return progression;
    }

    @Override
    public int subtask_4_arrays(int[] data) {
        // Для данного массива вычислить максимальный элемент
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > max) max = data[i];
        }
        return max;
    }

    @Override
    public int subtask_5_arrays(int[] data, int k) {
        // Для данного массива вычислить максимальный элемент
        // кратный k. Гарантируется, что как минумум один такой элемент
        // в массиве есть
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < data.length; i++) {
            if ((data[i] % k == 0) && (data[i] > max)) max = data[i];
        }
        return max;
    }

    @Override
    public int[] subtask_6_arrays(int[] arr1, int[] arr2) {
        // Даны два массива arr1, arr2.
        // Произвести слияние данных массивов в один отсортированный
        // по возрастанию массив.
        int[] biggerArray = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            biggerArray[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            biggerArray[i +arr1.length] = arr2[i];
        }
        Arrays.sort(biggerArray);
        return biggerArray;
    }

    @Override
    public int[] subtask_7_arrays(int[] arr1, int[] arr2) {
        // Даны два отсортированных по возрастанию массива arr1, arr2.
        // Произвести слияние данных массивов в один также отсортированный
        // по возрастанию массив.
        // Используйте алгоритм, время работы которого будет пропорционально сумме
        // размеров arr1 и arr2, а не их произведению.
        // O(2n) вместо O(n^2).

        // Variables initialization.
        List<Integer> biggerArray = new ArrayList<>();
        int iter = 0;
        int memory = 0;
        // Swapping, for a shorter array to get the first.
        if (arr1.length > arr2.length) {
            int[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }
        // Catching empty arrays.
        if (arr1.length == 0) return arr2;
        if (arr2.length == 0) return arr1;

        // Main sorting loop.
        while ((iter < arr1.length) && (memory < arr2.length)) {
            if (arr1[iter] >= arr2[memory]) {
                biggerArray.add(arr2[memory]);
                ++memory;
            }
            else {
                biggerArray.add(arr1[iter]);
                ++iter;
            }
        //Adding leftover arrays values.
        }
        if (memory < arr2.length) {
            for (int i = memory; i < arr2.length; i++) {
                biggerArray.add(arr2[i]);
            }
        }
        else if (iter < arr1.length) {
            for (int i = iter; i < arr1.length; i++) {
                biggerArray.add(arr1[i]);
            }
        }

        // Reformatting ArrayList to int[], and returning.
        int[] result = new int[biggerArray.size()];
        for (int i = 0; i < biggerArray.size(); i++) {
            result[i] = biggerArray.get(i);
        }
        return result;
    }

}
