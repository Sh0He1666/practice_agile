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
public class List5_3__GeneratePrimes {
    
    private static int s;
    private static boolean[] f;
    private static int[] primes;
    
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
            initializeSieve(maxValue);
            sieve();
            loadPrimes();
            return primes; // 素数をリターン
        }
    }
    
    private static void loadPrimes()
    {
        int i;
        int j;
        
        // 見つけた素数の個数をカウント
        int count = 0;
        for (i = 0; i < s; i++)
        {
            if (f[i])
                count++; // カウントアップ
        }
        
        primes = new int[count];
        
        // 素数の抜き出し
        for (i = 0, j = 0; i < s; i++)
        {
            if (f[i]) // 素数であれば
                primes[j++] = i;
        }
    }
    
    private static void sieve()
    {
        int i;
        int j;
        for (i = 2; i < Math.sqrt(s) + 1; i++)
        {
            if (f[i]) // iが除かれていなければ、その倍数を除く
            {
                for (j = 2 * i; j < s; j += i)
                    f[j] = false; // 倍数は素数ではない
            }
        }
    }
    
    private static void initializeSieve(int maxValue)
    {
        // 宣言
        s = maxValue + 1; // 配列のサイズ
        f = new boolean[s];
        int i;
        
        // 配列を真(true)に初期化
        for (i = 0; i < s; i++)
            f[i] = true;
        
        // 周知の非素数を取り除く
        f[0] = f[1] = false;
    }
    
}
