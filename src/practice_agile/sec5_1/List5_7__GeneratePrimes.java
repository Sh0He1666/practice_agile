package practice_agile.sec5_1;

/**
 * このクラスは素数を生成する。生成される素数の上限はユーザーが指定する。
 * ここで使用されているアルゴリズムは、「エラトステネスのふるい」法である。
 * <p>
 * このアルゴリズムは極めて単純である。2から始まる整数配列を与え、2の
 * 倍数を全て消す。まだ消えていない次の整数を見つけ、その倍数を
 * 全て削除する。1番大きい数の平方根を超えるまで、この作業を繰り返す。
 * @author tkmr0
 *
 */
public class List5_7__GeneratePrimes {
    
    private static boolean[] crossedOut; // 素数以外 == true, 素数 == false
    private static int[] result;
    
    /**
     * @param maxValue 生成する素数の上限
     * @return
     */
    public static int[] generatePrimes(int maxValue)
    {
        if (maxValue < 2)
            return new int[0];
        else 
        {
            uncrossIntegersUpTo(maxValue);
            crossOutMultiples();
            putUnclossedIntegersIntoResult();
            return result; // 素数をリターン
        }
    }
    
    private static void uncrossIntegersUpTo(int maxValue)
    {
        crossedOut = new boolean[maxValue + 1];
        for (int i = 2; i < crossedOut.length; i++)
            crossedOut[i] = false;
    }
    
    private static void crossOutMultiples()
    {
        int maxPrimeFactor = determineIterationLimit();
        for (int i = 2; i <= maxPrimeFactor; i++)
        {
            if (notCrossed(i))
                crossOutMultiplesOf(i);
        }
    }
    
    private static int determineIterationLimit()
    {
        // 配列に格納されているいかなる倍数も、その配列サイズの平方根に
        // 等しいか、それよりも小さい素数因子を持っている。したがって、
        // その平方根よりも大きな数の倍数をチェックする必要はない。
        double iterationLimit = Math.sqrt(crossedOut.length);
        return (int) iterationLimit;
    }
    
    private static void crossOutMultiplesOf(int i)
    {
        for (int multiple = 2*i;
                multiple < crossedOut.length;
                multiple += i)
            crossedOut[multiple] = true;
    }

    private static boolean notCrossed(int i) 
    {
        return crossedOut[i] == false;
    }
    
    private static void putUnclossedIntegersIntoResult()
    {
        result = new int[numberOfUncrossedIntegers()];
        for (int j = 0, i = 2; i < crossedOut.length; i++)
            if (notCrossed(i))
                result[j++] = i;
    }
    
    private static int numberOfUncrossedIntegers()
    {
        int count = 0;
        for (int i = 2; i < crossedOut.length; i++)
            if (notCrossed(i))
                count++;
        return count;
    }
    
    public static void main(String[] args) {
        generatePrimes(100);
    }

}
