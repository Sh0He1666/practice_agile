package practice_agile.sec6_1;

public class Game 
{
    private int itsScore = 0;
    private int[] itsThrows = new int[21];
    private int itsCurrentThrow = 0;
    
    public int score()
    {
        return itsScore;
    }
    
    public void add(int pins)
    {
        itsThrows[itsCurrentThrow++] = pins;
        itsScore += pins;
    }
    
    public int scoreForFrame(int theFrame)
    {
        int ball = 0;
        int score = 0;
        for (int currentFrame = 0;
                currentFrame < theFrame;
                currentFrame++)
        {
            int firstThrow = itsThrows[ball++];
            int secondThrow = itsThrows[ball++];
            int frameScore = firstThrow + secondThrow;
            // スペアの得点計算には次のフレームの第一投が必要
            if (frameScore == 10)
                score += frameScore + itsThrows[ball];
            else 
                score += frameScore;
        }
        return score;
    }
    
    public int getCurrentFrame()
    {
        return 1;
    }
}
