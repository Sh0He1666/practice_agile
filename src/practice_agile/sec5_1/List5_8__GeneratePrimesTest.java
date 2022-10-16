package practice_agile.sec5_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class List5_8__GeneratePrimesTest {

    @Test
    void test() {
        int[] nullArray = List5_7__GeneratePrimes.generatePrimes(0);
        assertEquals(nullArray.length, 0);
        int[] minArray = List5_7__GeneratePrimes.generatePrimes(2);
        assertEquals(minArray.length, 1);
        assertEquals(minArray[0], 2);
        int[] threeArray = List5_7__GeneratePrimes.generatePrimes(3);
        assertEquals(threeArray.length, 2);
        assertEquals(threeArray[0], 2);
        assertEquals(threeArray[1], 3);
        int[] centArray = List5_7__GeneratePrimes.generatePrimes(100);
        assertEquals(centArray.length, 25);
        assertEquals(centArray[24], 97);
    }
    
    @Test
    void testExaustive()
    {
        for (int i = 2; i < 500; i++)
            verifyPrimeList(List5_7__GeneratePrimes.generatePrimes(i));
    }
    
    private void verifyPrimeList(int[] list)
    {
        for (int i = 0; i<list.length; i++)
            verifyPrime(list[i]);
    }
    
    private void verifyPrime(int n)
    {
        for (int factor = 2; factor < n; factor++)
        {
            assertTrue(n%factor != 0);
        }
    }

}
