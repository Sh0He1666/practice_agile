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
public class List5_1__GeneratePrimes {
    
    /**
     * @param maxValue 生成する素数の上限
     * @return
     */
    public static int[] generatePrimes(int maxValue)
    {
        // 宣言
        if (maxValue >= 2) {
            int s = maxValue + 1; // 配列のサイズ
            boolean[] f = new boolean[s];
            int i;
            
            // 配列を真(true)に初期化
            for (i = 0; i < s; i++)
                f[i] = true;
            
            // 周知の非素数を取り除く
            f[0] = f[1] = false;
            
            // ふるい落とす
            int j;
            for (i = 2; i < Math.sqrt(s) + 1; i++)
            {
                if (f[i])
                {
                    for (j = 2 * i; j < s; j += i)
                        f[j] = false; // 倍数は素数ではない
                }
            }
            
            // 見つけた素数の個数をカウント
            int count = 0;
            for (i = 0; i < s; i++)
            {
                if (f[i]) 
                    count++; // カウントアップ
            }
            
            int[] primes = new int[count];
            
            // 素数の抜きだし
            for (i = 0, j = 0; i < s; i++)
            {
                if (f[i]) // 素数であれば
                    primes[j++] = i;
            }
            return primes; // 素数を返す
        }
        else // maxValue < 2
            return new int[0]; // 入力が不適切な場合null配列を戻す
    }
    
    
    public static void main(String[] args) {
        System.out.println((int)Math.sqrt(10));
    }
}
