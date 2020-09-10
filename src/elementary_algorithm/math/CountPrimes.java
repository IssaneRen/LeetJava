package elementary_algorithm.math;

/**
 * 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnzlu6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class CountPrimes {
    public static void main(String[] args) {
        int number = 3;
        CountPrimes entity = new CountPrimes();
        System.out.println("{number : " + number + "}, {countPrimes:" + entity.countPrimes(number) + "}");;

    }

    public int countPrimes(int n) {
        if (n <= 2) return 0;
        int sum = 0;
        //1000万以内的所有素数
        //用数组将1000万以内的数分为两大派系，素数用0代替数值，合数用1代替数值；
        //一开始默认全部为素数，所以值全部为0，等到开始筛选的时候再把为合数的赋值为1
        int num[] = new int[n - 1];
        num[0] = 1;          //由于1规定不是素数，所以要提前用1标值
        //根据埃氏筛法的结论，要得到自然数  N 以内的全部素数，必须把不大于" 二次根号  N "的所有素数的倍数剔除，剩下的就是素数
        double prescription = Math.sqrt(n);
        for (int i = 2; i <= prescription + 1; i++) {
            //开始把所有素数的倍数剔除，剩下的就是素数
            if (num[i - 1] == 1) {
                continue;
            }
            for (int j = i*i; j <= n - 1; j+=i) {
                //从i*i开始去除，因为比i*i小的倍数，已经在前面去除过了
                //例如：i=5
                //5的2倍（10），3倍（15），在i=2的时候，已经去除过了

                num[j-1] = 1;   //把素数的倍数剔除，也就是赋值为1，不是素数就是合数
            }
        }
        //遍历数组，把值为0的数全部统计出来，得到素数之和
        for (int i = 0; i < num.length; i++) {
            if(num[i]==0)
                sum++;
        }

        return sum;
    }
}
