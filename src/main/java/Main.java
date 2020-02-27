import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE+Integer.MIN_VALUE+1);
    }

    public void T23() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[3 * n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int res = 0;
        for (int i = arr.length - 2; i >= n; i -= 2) {
            res += arr[i];
        }
        System.out.println(res);

    }

    public void T2() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Node node = new Node();
            node.zd = sc.nextInt(); //战斗
            node.ql = sc.nextInt(); //潜力
            node.datil = node.ql - node.zd; //潜力-战斗值
            list.add(node);
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.zd == o2.zd) {
                    return o2.datil - o1.datil;
                }
                return o2.zd - o1.zd;
            }
        });
        int res = 0;
        int pre = 0;
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);

            if (pre == node.zd) {
                if (res < node.zd + node.ql) {
                    res = node.zd + node.ql;
                }
            } else {
                if (node.datil > 0) {
                    res = node.datil;
                    pre += node.datil;
                }

            }
        }
        System.out.println(res);

    }

    int res = 0;

    public void T1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        if (arr.length <= 2) {
            System.out.println(1);
            return;
        }
        DG(arr, 0);
        System.out.println(res);
    }


    public void DG(int[] arr, int i) {
        if (i >= arr.length) return;
        int pre = 0;
        int j = i + 1;
        for (; j < arr.length; j++) {
            if (pre == 0) {
                if (arr[j] == arr[j - 1]) {
                    continue;
                } else {
                    if (arr[j] > arr[j - 1]) {
                        pre = 1;
                    } else {
                        pre = 2;
                    }
                }
            } else if (arr[j] < arr[j - 1]) {
                if (pre == 1) {
                    break;
                }
            } else if (arr[j] > arr[j - 1]) {
                if (pre == 2) {
                    break;
                }
            }

        }
        res++;
        DG(arr, j + 1);

    }

    public void Q2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q1 = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q1.offer(i);
        }

        int k = 0;
        while (q1.size() > 1) {
            Integer poll = q1.poll();
            k++;
            if (k == 3) {
                k = 0;
            } else {
                q1.offer(poll);
            }
        }

        System.out.println(q1.poll());
    }

    public static void Q4() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 4];

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int r1 = dp[n];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        int r2 = dp[n];

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 1;
        for (int i = 5; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }

        System.out.println(r1 + " " + r2 + " " + dp[n]);
    }

    /**
     * 头条的2017校招开始了！为了这次校招，我们组织了一个规模宏大的出题团队，每个出题人都出了一些有趣的题目，
     * 而我们现在想把这些题目组合成若干场考试出来，在选题之前，我们对题目进行了盲审，并定出了每道题的难度系统。
     * 一场考试包含3道开放性题目，假设他们的难度从小到大分别为a,b,c，我们希望这3道题能满足下列条件：
     * a<=b<=c
     * b-a<=10
     * c-b<=10
     * 所有出题人一共出了n道开放性题目。现在我们想把这n道题分布到若干场考试中（1场或多场，每道题都必须使用且只能用一次），
     * 然而由于上述条件的限制，可能有一些考试没法凑够3道题，因此出题人就需要多出一些适当难度的题目来让每场考试都达到要求，
     * 然而我们出题已经出得很累了，你能计算出我们最少还需要再出几道题吗？
     */
    public void Test() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int res = 0;

        int k=1;
        Stack<Integer> stack = new Stack<>();
        stack.add(arr[0]);
        while (k<arr.length){
            if (arr[k]-stack.peek()<=10){

            }

        }



    }
}

class Node {
    int ql;
    int zd;
    int datil;

}
