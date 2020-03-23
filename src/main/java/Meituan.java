import java.util.ArrayList;
import java.util.Scanner;

public class Meituan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String num = sc.next();
        char[] chars = num.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        while (m-->0) {
            String skey = sc.next();
            if (skey.equals("q")) {
                list.add(LIS(chars));
            } else if (skey.equals("c")){
                int i = sc.nextInt();
                int j= sc.nextInt();
                changeChar(chars,i,j);
            }
        }
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
    private static void changeChar(char[] c, int i, int j) {

        for (int k = i-1; k < j; k++) {
            if (c[k] == '0') {
                c[k] = '1';
            } else {
                c[k] = '0';
            }
        }
    }
    private static int LIS(char[] c) {
        int n = c.length;
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int a = c[i - 1] - '0';
            dp[i] = 1;
            int sc = 0;
            for (int j = 0; j < i - 1; j++) {
                if (c[j] - '0' <= a) {
                    sc = Math.max(sc, dp[j + 1]);
                }
            }
            dp[i] += sc;
            max = Math.max(dp[i], max);
        }
        return max;
    }

   /* public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        //完成所有任务的得分
        int sAll =p*k+q;
        int[] arr = new int[k];
        int aM = 0;
        //每个子任务的收益比
        double[] rs = new double[k];
        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
            aM+=arr[i];
            rs[i] = p/arr[i];
        }
        //完成整个任务的收益比
        double rate = sAll/aM;
        Arrays.sort(arr);
        Arrays.sort(rs);

        int res=0;
        for (int i = k-1; i >= 0; i--) {
            if (rs[i]>rate || aM>m){
                int a = m / arr[k-i-1];
                res+=a*p;
                m=m-a*arr[k-i-1];
            }else if (m>=aM){
                int a = m/aM;
                res+=sAll*a;
                m -=aM*a;
            }
        }

        System.out.println(res);
    }*/

   /* public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //dp[i][0]不删的最长，dp[i][1] 表示前面一个删掉的最长
        int[][] dp = new int[n + 1][2];
        dp[1][0] = 1;
        dp[1][1] = 0;
        int max=1;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            if (arr[i - 1] > arr[i - 2]) {
                dp[i][0] = Math.max(dp[i - 1][0] + 1, dp[i][0]);
            }
            if (i - 3 >= 0 && arr[i - 1] > arr[i - 3]) {
                dp[i][1] = Math.max(dp[i-2][0]+1,dp[i][1]);
            }
            max = Math.max(max,Math.max(dp[i][0],dp[i][1]));
        }

        System.out.println(max);

    }*/


}
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a1 = new int[n];
        for (int i = 0; i < n; i++) {
            a1[i] = sc.nextInt();
        }
        Arrays.sort(a1);
        int[] a2 = new int[n];
        for (int i = 0; i < n; i++) {
            a2[i] = sc.nextInt();
        }
        Arrays.sort(a2);
        int m = Math.max(n - 3, 0);
        long r1 = 0;
        for (int i = n-1; i >=m ; i--) {
            r1+=a1[i];

        }
        long r2 = 0;
        for (int i = n-1; i >=m ; i--) {
            r2+=a2[i];

        }
        System.out.println(Math.max(r1,r2));
    }*/