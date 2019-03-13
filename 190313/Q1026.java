package baecjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Q1026 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] b = new int[n];


        String[] sa = br.readLine().split(" ");
        String[] sb = br.readLine().split(" ");
        for (int j = 0; j < n; j++) {
            a[j] = Integer.parseInt(sa[j]);
            b[j] = Integer.parseInt(sb[j]);
        }

        a = IntStream.of(a)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(i -> i)
                .toArray();

        Arrays.sort(b);

        int s=0;

        for(int i = 0;i<n;i++){
            s+=(a[i] * b[i]);
        }

        System.out.println(s);

    }
}
