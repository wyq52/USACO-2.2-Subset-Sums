import java.io.*;
import java.util.*;

public class subset {
    public static int[] value;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("subset.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
        StringTokenizer line = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(line.nextToken());
        double temp = 0.5 * (1 + num) * num;
        if (temp % 2 != 0) {
            out.println(0);
        } else {
            int aimSum = (int) temp / 2;
            value = new int[num + 1];
            for (int i = 0; i < num + 1; i++) {
                value[i] = i;
            }
            long r = result(num, aimSum);
            out.println(r);


        }
        out.close();
    }

    public static long result(int num, int aimSum) {
        long [][] dp = new long[num + 1][aimSum + 1];
        dp[0][0] = 1;
        for (int i = 1; i < num + 1; i++) {
            for (int j = 0; j < aimSum + 1; j++) {
                if (j - value[i] >= 0) {
                    dp[i][j] = dp[i - 1][j - value[i]] + dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        long ways = dp[num][aimSum];
        return ways/2;
    }

}
