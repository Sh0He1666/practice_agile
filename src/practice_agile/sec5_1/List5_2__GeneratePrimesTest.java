package practice_agile.sec5_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class List5_2__GeneratePrimesTest {

    @Test
    void test() {
        int[] nullArray = List5_1__GeneratePrimes.generatePrimes(0);
        assertEquals(nullArray.length, 0);
        int[] minArray = List5_1__GeneratePrimes.generatePrimes(2);
        assertEquals(minArray.length, 1);
        assertEquals(minArray[0], 2);
        int[] threeArray = List5_1__GeneratePrimes.generatePrimes(3);
        assertEquals(threeArray.length, 2);
        assertEquals(threeArray[0], 2);
        assertEquals(threeArray[1], 3);
        int[] centArray = List5_1__GeneratePrimes.generatePrimes(100);
        assertEquals(centArray.length, 25);
        assertEquals(centArray[24], 97);
    }

}
