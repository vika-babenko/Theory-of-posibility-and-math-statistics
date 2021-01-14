import java.util.Arrays;

public class Lab4 {

    public static final double[] X = {12, 11, 9, 16, 10, 6, 7, 14, 5};

    public static double[] getSequence(double[] X){
        return X;
    }

    public static double getSigma(double[] X){
        Arrays.sort(X);
        return (X[X.length - 1] - X[0])/2.95;
    }

    public static double getMeanValue(double[] X){
        double sum = 0;
        for (int i = 0; i < X.length; i++){
            sum += X[i];
        }
        return sum/X.length;
    }

    public static double[] firstLimit(double[] X){
        double[] returnDouble = new double[2];
        Arrays.sort(X);
        if (X[2] != X[3]){
            double limit1 = (X[2] + X[3]) / 2;
            returnDouble[0]=limit1;
            returnDouble[1]=0;
            return returnDouble;
        }
        else {
            for (int i = 2; i < X.length;i++)
                if (X[i] != X[i+1]){
                    int k = i + 1;
                    double limit1 = (X[i+1]+X[i])/2;
                    returnDouble[0]=limit1;
                    returnDouble[1]=k;
                    return returnDouble;
                }
        }
        return returnDouble;
    }

    public static double secondLimit(double[] X){
        Arrays.sort(X);
        if (X[2]!=X[3]){
            if (X[6]!=X[7]){
                double limit2=(X[6]+X[7])/2;
                return limit2;
            }
            else{
                for (int i = 6; i < X.length; i++)
                    if (X[i]!=X[i+1]){
                        double limit2=(X[i+1]+X[i])/2;
                        return limit2;
                    }
            }
        }

        double[] box = new double[2];
        box = firstLimit(X);
        int k = (int) box[1];

        if (X[2]==X[3])
            for (int i=k+1;i < X.length; i++)
                if (X[i]!=X[i+1]){
                    double limit2 = (X[i+1]+X[i])/2;
                    return limit2;
                }
        return 0;
    }

    public static double[] calcProbibility(int tests){
        double sigma = getSigma(X);
        double meanValue = getMeanValue(X);

        double P1 = 0;
        double[] box = new double[2];
        box = firstLimit(X);
        double limit1 = box[0];

        double P2 = 0;
        double limit2 = secondLimit(X);

        double P3 = 0;

        double[] prob = new double[3];

        for (int j = 0; j < tests; j++){
            double rand=0;
            for (int i = 0; i < 12; i++)
                rand+=Math.random();
            double x = sigma * (rand - 6) + meanValue;


            if (x < limit1) P1++;
            if (limit1 <x && x < limit2) P2++;
            if (limit2 < x) P3++;

            prob[0] = P1/tests;
            prob[1] = P2/tests;
            prob[2] = P3/tests;
        }
        return prob;
    }

    public static double[] boxes(){
        double[] boxes = new double[3];

        double box1 = 0;
        double twoThirds = 0;

        double[] box = new double[2];
        box = firstLimit(X);
        double limit1 = box[0];
        double limit2 = secondLimit(X);

        for (int i=0;i<X.length;i++){
            if(X[i]<limit1)
                box1++;
            if(X[i]<limit2)
                twoThirds++;
        }
        boxes[0] = box1;
        boxes[1] = twoThirds - boxes[0];
        boxes[2] = X.length - boxes[0] - boxes[1];
        return boxes;
    }

    public static final double[][] Y = {{0.01, 0.02, 0.05, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 0.95},
            {0.02, 0.04, 0.103, 0.211, 0.446, 0.713, 1.0217, 1.386, 1.8326, 2.41, 3.22, 4.6, 5.99}};

    public static double probibilityOfSequence(){
        double P;
        int n = X.length;
        double[] m = new double[3];
        m = boxes();

        double[] p = new double[3];
        p = calcProbibility(30000);
        double hi=(Math.pow((m[0]-n*p[0]),2)/(n*p[0]))+(Math.pow((m[1]-n*p[1]),2)/(n*p[1]))+(Math.pow((m[2]-n*p[2]),2)/(n*p[2]));
        if (hi<Y[1][0]){
            P = 0.99;
            return P;
        }

        if (hi>Y[1][12]){
            P = 0.04;
            return P;
        }
        for (int i = 0; i < 12; i++)
            if (hi > Y[1][i])
                if (hi < Y[1][i + 1]){
                    double t = -Y[1][i] + hi;
                    double f = Y[1][i + 1] - hi;
                    if (t < f){
                        P = 1-Y[0][i];
                        return P;
                    }
                    else {
                        P = 1-Y[0][i+1];
                        return P;
                    }
                }
        return 0;
    }

    public static void main(String[] args) {

        Arrays.sort(X);
        for (int i = 0; i < X.length; i++){
            System.out.print(X[i] + " ");
        }
        System.out.println();

        System.out.println("Sigma " + getSigma(X));

        System.out.println("Mean Value " + getMeanValue(X));

        double[] box1 = new double[2];
        box1 = firstLimit(X);
        System.out.println("First limit " + box1[0]);
        System.out.println("Second limit " + secondLimit(X));

        double[] box2 = new double[3];
        box2 = calcProbibility(1000);
        System.out.println("Probabilities of intervals: ");
        System.out.println(box2[0]);
        System.out.println(box2[1]);
        System.out.println(box2[2]);

        double[] box3 = new double[3];
        box3 = boxes();
        System.out.println("Count of numbers in first interval: " + (int)box3[0] + " units");
        System.out.println("Count of numbers in second interval: " + (int)box3[1] + " units");
        System.out.println("Count of numbers in third interval: " + (int)box3[2] + " units");

        System.out.println("Probibility of hit: " + probibilityOfSequence());
    }
}
