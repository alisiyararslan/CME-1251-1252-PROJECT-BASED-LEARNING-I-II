using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace proje
{
    class Program
    {
        static void Main(string[] args)
        {
            bool boo;
            bool boo2;
            int score = 0, piececounter = 0, y_piece_length = 0, x_piece_length = 0, cy = 0, cx = 0, mul, sum, z;
            int[,] table = new int[9, 9];
            int[,] game_element = new int[3, 3];
            int[] fileld = new int[9];
            for (int i = 0; i < 9; i++)
            {
                for (int j = 0; j < 9; j++)
                {
                    table[i, j] = -1;
                }
            }
            /*
            for (int k = 1; k <= 19; k++)
            {
                for (int l = 1; l <= 19; l++)
                {
                    if (k == 1 | k == 7 | k == 13 | k == 19)
                    {
                        if (l == 1 | l == 7 | l == 13 | l == 19)
                        {
                            Console.Write("+");
                        }
                        else
                        {
                            Console.Write("-");
                        }
                    }
                    else
                    {
                        if (l == 1 | l == 7 | l == 13 | l == 19)
                        {
                            Console.Write("|");
                        }
                        else
                        {
                            Console.Write(" ");
                        }
                    }
                }
                Console.WriteLine();
            }
            */
            
            Console.WriteLine("+-----+-----+-----+");
            Console.WriteLine("|. . .|. . .|. . .|1");
            Console.WriteLine("|     |     |     |");
            Console.WriteLine("|. . .|. . .|. . .|2");
            Console.WriteLine("|     |     |     |");
            Console.WriteLine("|. . .|. . .|. . .|3");
            Console.WriteLine("+-----+-----+-----+");
            Console.WriteLine("|. . .|. . .|. . .|4");
            Console.WriteLine("|     |     |     |");
            Console.WriteLine("|. . .|. . .|. . .|5");
            Console.WriteLine("|     |     |     |");
            Console.WriteLine("|. . .|. . .|. . .|6");
            Console.WriteLine("+-----+-----+-----+");
            Console.WriteLine("|. . .|. . .|. . .|7");
            Console.WriteLine("|     |     |     |");
            Console.WriteLine("|. . .|. . .|. . .|8");
            Console.WriteLine("|     |     |     |");
            Console.WriteLine("|. . .|. . .|. . .|9");
            Console.WriteLine("+-----+-----+-----+");
            Console.WriteLine(" 1 2 3 4 5 6 7 8 9");
            Console.SetCursorPosition(24, 0);
            Console.WriteLine("New Piece");
            int count = 0;
            int hand = 0;
            int handr = 0;
            int total_element = 0;
            while (true)
            {

                for (int a = 1; a <= 17; a += 2)
                {
                    for (int b = 1; b <= 17; b += 2)
                    {
                        Console.SetCursorPosition(a, b);
                        if (table[(a - 1) / 2, (b - 1) / 2] == -1)
                        {
                            Console.Write(".");
                        }
                        else
                        {
                            Console.Write(table[(a - 1) / 2, (b - 1) / 2]);
                        }
                    }
                    Console.WriteLine();
                }
                cx = 1;
                cy = 1;
                ConsoleKeyInfo cki;
                Random rnd = new Random();
                int random_element = 0;
                if (hand == handr)
                {
                    random_element = rnd.Next(1, 11);
                

                switch (random_element)
                {
                    //x
                    case 1:
                        total_element = 1;
                        x_piece_length = 0;
                        y_piece_length = 0;
                        for (int i = 0; i < 3; i++)
                        {
                            for (int j = 0; j < 3; j++)
                            {
                                if (i == 0 && j == 0)
                                {
                                    game_element[i, j] = rnd.Next(0, 2);
                                }
                                else
                                {
                                    game_element[i, j] = -1;
                                }
                            }
                        }
                            handr++;
                            break;
                    //xx
                    case 2:
                        total_element = 2;
                        x_piece_length = 1;
                        y_piece_length = 0;
                        for (int i = 0; i < 3; i++)
                        {
                            for (int j = 0; j < 3; j++)
                            {
                                if (i == 0 && j < 2)
                                {
                                    game_element[i, j] = rnd.Next(0, 2);
                                }
                                else
                                {
                                    game_element[i, j] = -1;
                                }
                            }
                        }
                            handr++;
                            break;
                    //x[0,0]
                    //x[1,0]
                    case 3:

                        x_piece_length = 0;
                        y_piece_length = 1;
                        total_element = 2;
                        for (int i = 0; i < 3; i++)
                        {
                            for (int j = 0; j < 3; j++)
                            {
                                if (i < 2 && j == 0)
                                {
                                    game_element[i, j] = rnd.Next(0, 2);
                                }
                                else
                                {
                                    game_element[i, j] = -1;
                                }
                            }
                        }
                            handr++;
                            break;
                    //xxx[0,0][0,1][0,2]
                    case 4:
                        x_piece_length = 2;
                        y_piece_length = 0;
                        total_element = 3;
                        for (int i = 0; i < 3; i++)
                        {
                            for (int j = 0; j < 3; j++)
                            {
                                if (i == 0 && j <= 2)
                                {
                                    game_element[i, j] = rnd.Next(0, 2);
                                }
                                else
                                {
                                    game_element[i, j] = -1;
                                }
                            }
                        }
                            handr++;
                            break;
                    //x[0,0]
                    //x[1,0]
                    //x[2,0]
                    case 5:
                        x_piece_length = 0;
                        total_element = 3;
                        y_piece_length = 2;
                        for (int i = 0; i < 3; i++)
                        {
                            for (int j = 0; j < 3; j++)
                            {
                                if (i <= 2 && j == 0)
                                {
                                    game_element[i, j] = rnd.Next(0, 2);
                                }
                                else
                                {
                                    game_element[i, j] = -1;
                                }
                            }
                        }
                            handr++;
                            break;
                    //xx[0,0][0,1]
                    //x[1,0]
                    case 6:
                        x_piece_length = 1;
                        total_element = 3;
                        y_piece_length = 1;
                        for (int i = 0; i < 3; i++)
                        {
                            for (int j = 0; j < 3; j++)
                            {
                                if (i == 0 && j < 2)
                                {
                                    game_element[i, j] = rnd.Next(0, 2);
                                }
                                else if (i == 1 && j == 0)
                                {
                                    game_element[i, j] = rnd.Next(0, 2);
                                }
                                else
                                {
                                    game_element[i, j] = -1;
                                }
                            }
                        }
                            handr++;
                            break;
                    //xx[0,0][0,1]
                    // x     [1,1]
                    case 7:
                        x_piece_length = 1;
                        total_element = 3;
                        y_piece_length = 1;
                        for (int i = 0; i < 3; i++)
                        {
                            for (int j = 0; j < 3; j++)
                            {
                                if (i == 0 && j < 2)
                                {
                                    game_element[i, j] = rnd.Next(0, 2);
                                }
                                else if (i == 1 && j == 1)
                                {
                                    game_element[i, j] = rnd.Next(0, 2);
                                }
                                else
                                {
                                    game_element[i, j] = -1;
                                }
                            }
                        }
                            handr++;
                            break;
                    //x     [0,0]
                    //xx    [1,0][1,1]
                    case 8:
                        x_piece_length = 1;
                        total_element = 3;
                        y_piece_length = 1;
                        for (int i = 0; i < 3; i++)
                        {
                            for (int j = 0; j < 3; j++)
                            {
                                if (i == 0 && j == 0)
                                {
                                    game_element[i, j] = rnd.Next(0, 2);
                                }
                                else if (i == 1 && j < 2)
                                {
                                    game_element[i, j] = rnd.Next(0, 2);
                                }
                                else
                                {
                                    game_element[i, j] = -1;
                                }
                            }
                        }
                            handr++;
                            break;
                    // x     [0,1]
                    //xx[1,0][1,1]
                    case 9:
                        x_piece_length = 1;
                        total_element = 3;
                        y_piece_length = 1;
                        for (int i = 0; i < 3; i++)
                        {
                            for (int j = 0; j < 3; j++)
                            {
                                if (i == 0 && j == 1)
                                {
                                    game_element[i, j] = rnd.Next(0, 2);
                                }
                                else if (i == 1 && j < 2)
                                {
                                    game_element[i, j] = rnd.Next(0, 2);
                                }
                                else
                                {
                                    game_element[i, j] = -1;
                                }
                            }
                        }
                            handr++;
                            break;
                    //xx[0,0][0,1]
                    //xx[1,0][1,1]
                    case 10:
                        x_piece_length = 1;
                        total_element = 4;
                        y_piece_length = 1;
                        for (int i = 0; i < 3; i++)
                        {
                            for (int j = 0; j < 3; j++)
                            {
                                if (i == 0 && j < 2)
                                {
                                    game_element[i, j] = rnd.Next(0, 2);
                                }
                                else if (i == 1 && j < 2)
                                {
                                    game_element[i, j] = rnd.Next(0, 2);
                                }
                                else
                                {
                                    game_element[i, j] = -1;
                                }
                            }
                        }
                        handr++;
                        break;
                }
            }
                boo2 = false;
                int counter = 0;
                for (int k = 0; k < 9-y_piece_length; k++)
                {
                    for (int l = 0; l < 9-x_piece_length; l++)
                    {
                        counter = 0;
                        for (int i = 0; i < 3; i++)
                        {
                            for (int j = 0; j < 3; j++)
                            {
                                if (game_element[i, j] != -1 && table[k + i, l  + j] == -1)
                                {
                                    counter++;
                                }
                            }
                            
                        }
                        if (counter == total_element)
                        {
                            boo2 = true;
                            break;
                        }


                    }
                    if (boo2 == true)
                    {
                        break;
                    }
                }
                if (boo2 == false)
                {
                    Console.SetCursorPosition(50, 5);
                    Console.WriteLine("game over");
                }
                Console.SetCursorPosition(24, 1); //
                for (int l = 0; l < 3; l++)
                {
                    for (int k = 0; k < 3; k++)
                    {
                        Console.SetCursorPosition(24 + (k), 2 + (l));
                        Console.Write(" ");
                    }
                }
                for (int i = 0; i < 3; i++)
                {
                    for (int j = 0; j < 3; j++)
                    {

                        if (game_element[i, j] != -1)
                        {
                            Console.SetCursorPosition(24 + (j), 2 + (i));
                            Console.Write(game_element[i, j]);
                        }
                    }
                }
                Console.SetCursorPosition(42, 0);
                Console.Write("Score: " + score);
                Console.SetCursorPosition(42, 1);
                Console.Write("Piece: " + piececounter);
                piececounter += 1;
                Console.SetCursorPosition(cx, cy);
                while (true)
                {
                    cki = Console.ReadKey(true);
                    if (cx > 1 && cki.Key == ConsoleKey.LeftArrow)
                    {
                        cx -= 2;
                    }
                    if (cx < (17 - x_piece_length * 2) && cki.Key == ConsoleKey.RightArrow)
                    {
                        cx += 2;
                    }
                    if (cy > 1 && cki.Key == ConsoleKey.UpArrow)
                    {
                        cy -= 2;
                    }
                    if (cy < (17 - y_piece_length * 2) && cki.Key == ConsoleKey.DownArrow)
                    {
                        cy += 2;
                    }
                    //Console.SetCursorPosition(cx, cy);

                    for (int a = 1; a <= 17; a += 2)
                    {
                        for (int b = 1; b <= 17; b += 2)
                        {
                            Console.SetCursorPosition(a, b);
                            if (table[(a) / 2, (b) / 2] == -1)
                            {
                                Console.Write(".");
                            }
                            else
                            {
                                Console.Write(table[(a) / 2, (b) / 2]);
                            }
                        }
                    }
                    Console.SetCursorPosition(cx, cy);
                    
                    for (int i = 0; i < 3; i++)
                    {
                        for (int j = 0; j < 3; j++)
                        {
                            Console.SetCursorPosition(cx + j * 2, cy + i * 2);
                            if (game_element[i, j] != -1)
                            {
                                Console.ForegroundColor = ConsoleColor.Red;
                                Console.Write(game_element[i, j]);
                                
                            }
                            
                        }
                    }

                    Console.SetCursorPosition(cx, cy);
                    Console.ForegroundColor = ConsoleColor.White;//-
                    
                            
                                      
                            if (cki.Key == ConsoleKey.Enter)
                    {

                        
                        boo = true;
                        for (int i = 0; i < 3; i++)
                        {
                            for (int j = 0; j < 3; j++)
                            {
                                if (game_element[i, j] != -1 && table[(cx - 1) / 2 + j, (cy - 1) / 2 + i] != -1)
                                {
                                    boo = false;
                                    break;
                                }
                            }
                            if (boo == false)
                            {
                                break;
                            }
                        }

                        if (boo)
                        {
                            hand++;
                            for (int i = 0; i < 3; i++)
                            {
                                for (int j = 0; j < 3; j++)
                                {
                                    if (game_element[i, j] != -1)
                                    {
                                        table[(cx - 1) / 2 + j, (cy - 1) / 2 + i] = game_element[i, j];

                                        bool fullv = true;
                                        for (int k = 0; k < 9; k++) // control
                                        {
                                            if (table[(cx - 1) / 2 + j, k] == -1)
                                            {
                                                fullv = false;
                                            }
                                        }
                                        
                                        
                                        if (fullv)
                                        {
                                            Console.SetCursorPosition(24, 6);
                                            Console.WriteLine("Calculations:    ");
                                            Console.SetCursorPosition(24, 7+count);
                                            Console.Write("(");
                                            for (int l = 0; l < 9; l++)
                                            {
                                                fileld[l] = table[(cx - 1) / 2 + j, l]; // dolan kısmı arraye ekleme
                                                Console.SetCursorPosition(25 + l, 7+count);
                                                Console.Write(fileld[l]);
                                            }
                                            Console.Write(")2 = ");
                                            sum = 0;
                                            mul = 1;
                                            z = 0;
                                            for (int m = fileld.GetLength(0) - 1; m >= 0; m--) // puan hesabı
                                            {
                                                if (fileld[m] == 1)
                                                {
                                                    mul = 1;
                                                    for (int n = 0; n < z; n++)
                                                    {
                                                        mul = mul * 2;
                                                    }
                                                    sum = sum + mul;
                                                }

                                                z++;
                                            }
                                            score += sum;
                                            Console.SetCursorPosition(40, 7+count);
                                            Console.WriteLine("("+sum+")10");

                                            for (int b = 0; b < 9; b++) // dolan yerleri sıfırlamak için
                                            {
                                                table[(cx - 1) / 2 + j, b] = -1;
                                            }
                                            count++;
                                        }
                                    }
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
}
