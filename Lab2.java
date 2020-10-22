import java.util.Random;
import java.util.Scanner;

public class Lab2{
    private static final int length = 5000;
    private static final double[] array = new double[length];
    private static double mathExpection = 0;
    private static double dispersion = 0;
    private static double sDev = 0;
    private static double p;
    private static final Random random = new Random();

    public static void main(String[] args){
        double enteredMathEx;
        double enteredVidh;

        while (true){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введіть математичне очікування:");
                enteredMathEx = scanner.nextDouble();
                System.out.println("Введіть середнє квадратичне відхилення:");
                enteredVidh = scanner.nextDouble();
                break;
            }
            catch (Exception ignored) {
                System.out.println("Введіть коректні значення!");
            }
        }
        // цикл для 5000
        for (int i = 0; i < length; i++) {
            // встановлюємо значення -6 за формулою
            double r = -6;
            for (int j = 0; j < 12; j++){
                // формула -- сума до кожного згенерованого числа додається -6
                r += random.nextDouble();
            }


            r = r * enteredVidh + enteredMathEx;
            mathExpection += r;
            dispersion += (r - enteredMathEx) * (r - enteredMathEx);
            array[i] = r;
        }
        int c = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]>0){
                c +=1;
            }

        }



        mathExpection /= (double) length;
        dispersion /= (double) length;
        sDev = Math.sqrt(dispersion);
        p = (double)c/length;



        System.out.println("Математичне очікування: " +mathExpection);
        System.out.println("Середнє квадратичне відхилення: " +sDev);
        System.out.println("Ймовірність" +p);

    }
}