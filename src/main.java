import java.util.Random;
import java.util.Scanner;

public class main {
    public static final int SIZE = 8;

    public static void main(String[] args) {
        int[][] colors = new int[SIZE][SIZE];
        int[][] rotatedColors = new int[SIZE][SIZE];
        boolean isAngleCorrect = true;

        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }
        System.out.println("Дана следующая матрица:");
        printArray(colors);

        System.out.println();
        System.out.println("Введите угол поворота матрицы (90, 180 или 270 градусов)");
        Scanner scanner = new Scanner(System.in);
        int angle = scanner.nextInt();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (angle == 90) {
                    rotatedColors[i][j] = colors[SIZE - 1 - j][i];
                } else if (angle == 180) {
                    rotatedColors[i][j] = colors[SIZE - 1 - i][SIZE - 1 - j];
                } else if (angle == 270) {
                    rotatedColors[i][j] = colors[j][SIZE - 1 - i];
                } else {
                    isAngleCorrect = false;
                }
            }
        }
        if (isAngleCorrect) {
            System.out.println("Вывод:");
            printArray(rotatedColors);
        } else {
            System.out.println("Вы ввели некорректный угол");
        }
    }

    public static void printArray(int[][] colors) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", colors[i][j]);
            }
            System.out.println();
        }
    }
}