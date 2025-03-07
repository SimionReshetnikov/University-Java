public class Main
{
    public static void main(String[] args)
    {
        int[][] magicSquare = new int[3][3];
        int row = 0;
        int col = 1;

        for (int i = 1; i <= 9; i++)
        {
            magicSquare[row][col] = i;
            int newRow = (row - 1 + 3) % 3;
            int newCol = (col + 1) % 3;

            if (magicSquare[newRow][newCol] != 0)
            {
                row = (row + 1) % 3;
            }
            else
            {
                row = newRow;
                col = newCol;
            }
        }

        PrintMagicSquare(magicSquare);
    }

    public static void PrintMagicSquare(int[][] array)
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}