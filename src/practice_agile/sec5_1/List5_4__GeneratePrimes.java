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
public class List5_4__GeneratePrimes {
    
    private static boolean[] f;
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
            initializeArrayOfIntegers(maxValue);
            crossOutMultiples();
            putUnclossedIntegersIntoResult();
            return result; // 素数をリターン
        }
    }
    
    private static void initializeArrayOfIntegers(int maxValue)
    {
        f = new boolean[maxValue + 1];
        f[0] = f[1] = false; // 素数でも倍数でもない
        for (int i = 2; i < f.length; i++)
            f[i] = true;
    }
    
    private static void crossOutMultiples()
    {
        int i;
        int j;
        for (i = 2; i < Math.sqrt(f.length) + 1; i++)
        {
            if (f[i]) // iが除かれていなければ、その倍数を除く
            {
                for (j = 2 * i; j < f.length; j += i)
                    f[j] = false; // 倍数は素数ではない
            }
        }
    }
    
    private static void putUnclossedIntegersIntoResult()
    {
        int i;
        int j;
        
        // 見つけた素数の個数をカウント
        int count = 0;
        for (i = 0; i < f.length; i++)
        {
            if (f[i])
                count++; // カウントアップ
        }
        
        result = new int[count];
        
        // 素数の抜き出し
        for (i = 0, j = 0; i < f.length; i++)
        {
            if (f[i]) // 素数であれば
                result[j++] = i;
        }
    }
    
}
