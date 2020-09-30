import java.util.*;

public class BucketSort {
    public static void main(String args[]) {

        Random rand = new Random();
        int size=6000;

        float[] a = new float[size];

        double start,duration;

        for (int i = 0; i < size; i++) {

            a[i] = rand.nextFloat();
        }

        start = System.nanoTime();
        bucketsort(a, size);
        duration = (System.nanoTime() - start)/1000.0;

        System.out.println("Time is "+ duration);
    }

    static void bucketsort(float a[], int size) {

        @SuppressWarnings("unchecked")
        ArrayList<Float>[] b = new ArrayList[size];

        for (int i = 0; i < size; i++) {
            b[i] = new ArrayList<Float>();
        }

        for (int i = 0; i < size; i++) {
            int index = (int) (a[i]*size);
            b[index].add(a[i]);
        }

        for (int i = 0; i < size; i++) {
            Collections.sort(b[i]);
        }
        int index1 = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < b[i].size(); j++) {
                a[index1++] = b[i].get(j);
            }
        }
    }

}