import java.util.Scanner;

public class Shein {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long i = sc.nextLong();

        String cz = sc.next();
        if (i<=0) {
            System.out.println(0);
            return;
        }
        long cur = 1;
        long left = 1, right = (i <= 4L ? i : 4L);

        for (int j = 0; j < cz.length(); j++) {
            char c = cz.charAt(j);

            if (c=='U'){
                if (cur==left){
                    if (cur==1){
                        if (i<4){
                            cur=i;
                        }else {
                            left = i-3;
                            right= i;
                            cur=i;
                        }
                    }else {
                        left = --cur;
                        right--;
                    }
                }else {
                    cur--;
                }
            }else { //down
                if (cur==right){
                    if (cur==i){
                        if (i<4){
                            cur=1;
                        }else {
                            left = 1;
                            right=4;
                            cur=1;
                        }
                    }else {
                       left++;
                       cur++;
                       right++;
                    }
                }else {
                    cur++;
                }
            }
        }

        for (long j = left; j <=right ; j++) {
            if (j==right){
                System.out.print(j);
            }else {
                System.out.print(j+" ");
            }
        }

        System.out.println();
        System.out.println(cur);
    }


    public int[][] clearZero(int[][] mat, int n) {
        // write code here
        boolean[] row = new boolean[n];
        boolean[] cols = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j]==0){
                    row[i]=true;
                    cols[j]=true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i]||cols[j]){
                    mat[i][j]=0;
                }
            }
        }

        return mat;
    }
}
