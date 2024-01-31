
using System;
using System.IO;
namespace project33
{
    class Program
    {
        static string[] hamleler = new string[9999];
        static void Notation(string durum, string başagelen)
        {


            if (durum == "normal")
            {

                if (notation % 2 == 0)
                {
                    if (notation == 1)
                        notation++;
                    Console.SetCursorPosition(48, 4 + notation / 2);
                    Console.Write((notation) / 2 + 1 + ".");
                    Console.ForegroundColor = ConsoleColor.DarkCyan;
                    Console.SetCursorPosition(50, 4 + notation / 2);
                    Console.Write(başagelen + "" + gösterici[cx] + "" + sgösterici[cy]);

                }
                if (notation % 2 == 1)
                {
                    Console.ForegroundColor = ConsoleColor.DarkRed;
                    Console.SetCursorPosition(60, 4 + notation / 2);
                    Console.Write(başagelen + "" + gösterici[cx] + "" + sgösterici[cy]);

                }
                if (başagelen == "")
                    hamleler[gamecounter] = (gösterici[cx] + "" + sgösterici[cy] + " ");
                else
                    hamleler[gamecounter] = (başagelen + gösterici[at_ilkx] + "" + gösterici[cx] + "" + sgösterici[cy] + " ");
            }
            else if (durum == "promo")
            {


                if (notation % 2 == 0)
                {
                    if (notation == 1)
                        notation++;
                    Console.SetCursorPosition(48, 4 + notation / 2);
                    Console.Write((notation) / 2 + 1 + ".");
                    Console.ForegroundColor = ConsoleColor.DarkCyan;
                    Console.SetCursorPosition(50, 4 + notation / 2);
                    Console.Write(gösterici[cx] + "" + sgösterici[cy] + "" + başagelen);

                }
                if (notation % 2 == 1)
                {
                    Console.ForegroundColor = ConsoleColor.DarkRed;
                    Console.SetCursorPosition(60, 4 + notation / 2);
                    Console.Write(gösterici[cx] + "" + sgösterici[cy] + "" + başagelen);

                }
                hamleler[gamecounter] = (gösterici[cx] + "" + sgösterici[cy] + başagelen + " ");
            }

            else if (durum == "yeme")
            {
                if (notation % 2 == 0)
                {
                    ;
                    Console.SetCursorPosition(48, 4 + notation / 2);
                    Console.Write((notation) / 2 + 1 + ".");
                    Console.ForegroundColor = ConsoleColor.DarkCyan;
                    Console.SetCursorPosition(50, 4 + notation / 2);
                    Console.Write(başagelen + "" + gösterici[at_ilkx] + "x" + gösterici[cx] + "" + sgösterici[cy]);
                }
                if (notation % 2 == 1)
                {
                    Console.ForegroundColor = ConsoleColor.DarkRed;
                    Console.SetCursorPosition(60, 4 + notation / 2);
                    Console.Write(başagelen + "" + gösterici[at_ilkx] + "x" + gösterici[cx] + "" + sgösterici[cy]);
                }
                hamleler[gamecounter] = (başagelen + gösterici[at_ilkx] + "x" + "" + gösterici[cx] + "" + sgösterici[cy] + " ");
            }
            else if (durum == "en")
            {


                if (notation % 2 == 0)
                {

                    Console.SetCursorPosition(48, 4 + notation / 2);
                    Console.Write((notation) / 2 + 1 + ".");
                    Console.ForegroundColor = ConsoleColor.DarkCyan;
                    Console.SetCursorPosition(50, 4 + notation / 2);
                    Console.Write(gösterici[at_ilkx] + "x" + gösterici[cx] + "" + (sgösterici[tempcypawn] + "e.p."));


                }
                if (notation % 2 == 1)
                {

                    Console.ForegroundColor = ConsoleColor.DarkRed;
                    Console.SetCursorPosition(60, 4 + notation / 2);
                    Console.Write(gösterici[at_ilkx] + "x" + gösterici[cx] + "" + sgösterici[tempcypawn] + "e.p.");

                }

            }
            else if (durum == "kısarok")
            {
                int sayı = 0;
                if (notation % 2 == 0)
                {
                    Console.SetCursorPosition(48, 4 + notation / 2);
                    Console.Write((notation) / 2 + 1 + ".");
                    Console.ForegroundColor = ConsoleColor.DarkCyan;
                    sayı = 50;
                }
                if (notation % 2 == 1)
                {
                    Console.ForegroundColor = ConsoleColor.DarkRed;
                    sayı = 60;
                }
                Console.SetCursorPosition(sayı, 4 + notation / 2);
                Console.Write("0-0");
                hamleler[gamecounter] = ("0-0 ");
            }
            else if (durum == "uzunrok")
            {
                int sayı = 0;
                if (notation % 2 == 0)
                {
                    Console.SetCursorPosition(48, 4 + notation / 2);
                    Console.Write((notation) / 2 + 1 + ".");
                    Console.ForegroundColor = ConsoleColor.DarkCyan;
                    sayı = 50;
                }
                if (notation % 2 == 1)
                {
                    Console.ForegroundColor = ConsoleColor.DarkRed;
                    sayı = 60;
                }
                Console.SetCursorPosition(sayı, 4 + notation / 2);
                Console.Write("0-0-0");
                hamleler[gamecounter] = ("0-0-0 ");
            }
            else if (durum == "normal2")
            {
                if (notation % 2 == 0)
                {
                    if (notation == 1)
                        notation++;
                    Console.SetCursorPosition(48, 4 + notation / 2);
                    Console.Write((notation) / 2 + 1 + ".");
                    Console.ForegroundColor = ConsoleColor.DarkCyan;
                    Console.SetCursorPosition(50, 4 + notation / 2);
                    Console.Write(başagelen + "" + column + "" + yyy);

                }
                if (notation % 2 == 1)
                {
                    Console.ForegroundColor = ConsoleColor.DarkRed;
                    Console.SetCursorPosition(60, 4 + notation / 2);
                    Console.Write(başagelen + "" + column + "" + yyy);

                }
                if (başagelen == "")
                    hamleler[gamecounter] = (gösterici[cx] + "" + sgösterici[cy] + " ");
                else
                    hamleler[gamecounter] = (başagelen + gösterici[at_ilkx] + "" + gösterici[cx] + "" + sgösterici[cy] + " ");

            }
            Console.ResetColor();
        }
        static string[] sgösterici = new string[16];
        static string[] gösterici = new string[33];
        static int cx, cy, temp_b, at_ilkx, at_ilky, tempcxpawn, tempcypawn, notation, gamecounter, yyy;
        static bool atoan, çıkıcı, queenbool, queenceviri, yukarıaşağı, sağsol, sağcapraz, solcapraz, yanlıstas, enpassantm, enpassantk, Promotionbool;
        static string tempdeneme = "E", tempdeneme2 = "E", gamename = "", column;
        static int tempdenemei = 0, tempdenemea = 0, countera = 0;
        static int[,] board2 = new int[8, 8] { {-1,-1,-1,-1,-1,-1,-1,-1 },
                                              {-1,-1,-1,-1,-1,-1,-1,-1 },
                                              {0,0,0,0,0,0,0,0 },
                                              {0,0,0,0,0,0,0,0 },
                                              {0,0,0,0,0,0,0,0 },
                                              {0,0,0,0,0,0,0,0 },
                                              {1,1,1,1,1,1,1,1 },
                                              {1,1,1,1,1,1,1,1 }, };
        static void GelismisYön(int üst, int sağ, int alt, int sol)
        {
            if (üst == 8 && cy > 1)
            {
                tempdenemei = board2[((cy - 1) / 2) - 1, ((cx - 1) / 4)];
                tempdeneme = board[((cy - 1) / 2) - 1, ((cx - 1) / 4)];
                Yön(cx, cy, "up");
                cy -= 2;
                board[((cy - 1) / 2) + 1, ((cx - 1) / 4)] = tempdeneme2;
                board2[((cy - 1) / 2) + 1, ((cx - 1) / 4)] = tempdenemea;
            }
            if (sağ == 6 && cx < 32)
            {
                tempdenemei = board2[((cy - 1) / 2), ((cx - 1) / 4) + 1];
                tempdeneme = board[((cy - 1) / 2), ((cx - 1) / 4) + 1];
                Yön(cx, cy, "right");
                cx += 4;
                board[((cy - 1) / 2), ((cx - 1) / 4) - 1] = tempdeneme2;
                board2[((cy - 1) / 2), ((cx - 1) / 4) - 1] = tempdenemea;
            }
            if (alt == 2 && cy < 15)
            {
                tempdenemei = board2[((cy - 1) / 2) + 1, ((cx - 1) / 4)];
                tempdeneme = board[((cy - 1) / 2) + 1, ((cx - 1) / 4)];
                Yön(cx, cy, "down");
                cy += 2;
                board[((cy - 1) / 2) - 1, ((cx - 1) / 4)] = tempdeneme2;
                board2[((cy - 1) / 2) - 1, ((cx - 1) / 4)] = tempdenemea;
            }
            if (sol == 4 && cx > 4)
            {
                tempdenemei = board2[((cy - 1) / 2), ((cx - 1) / 4) - 1];
                tempdeneme = board[((cy - 1) / 2), ((cx - 1) / 4) - 1];
                Yön(cx, cy, "left");
                cx -= 4;
                board[((cy - 1) / 2), ((cx - 1) / 4) + 1] = tempdeneme2;
                board2[((cy - 1) / 2), ((cx - 1) / 4) + 1] = tempdenemea;
            }
        }
        static string[,] board = new string[8, 8] { { "RK","NK","BK","QK","KK","BK","NK","RK" },
                                                 {"PK","PK","PK", "PK","PK","PK","PK", "PK"},
                                                 {"E","E","E","E","E","E","E","E"  },
                                                 {"E","E","E","E","E","E","E","E"  },
                                                 {"E","E","E","E","E","E","E","E"  } ,
                                                 {"E","E","E","E","E","E","E","E"  } ,
                                                 {"PM","PM","PM","PM","PM","PM","PM","PM" },
                                                 {"RM","NM","BM","QM","KM","BM","NM","RM" } };  //2D array for board 
        static void Promotion(string takımharf)
        {
            Console.SetCursorPosition(70, 1);
            Console.Write("!Promotion!");
            Console.SetCursorPosition(70, 3);
            Console.Write("Press the letter of the piece you want to convert");
            Console.SetCursorPosition(70, 5);
            Console.Write("R(ROOK)    Q(QUEEN)    B(BISHOP)    N(KNIGHT)");
            ConsoleKeyInfo keyInfo2 = Console.ReadKey(true);
            if (keyInfo2.Key == ConsoleKey.N)
            {
                board[((cy - 1) / 2), ((cx - 1) / 4)] = "N" + takımharf;
                Promotionbool = true;
                Notation("promo", "N");
            }
            else if (keyInfo2.Key == ConsoleKey.R)
            {
                board[((cy - 1) / 2), ((cx - 1) / 4)] = "R" + takımharf;
                Promotionbool = true;
                Notation("promo", "R");
            }
            else if (keyInfo2.Key == ConsoleKey.Q)
            {
                board[((cy - 1) / 2), ((cx - 1) / 4)] = "Q" + takımharf;
                Promotionbool = true;
                Notation("promo", "Q");
            }
            else if (keyInfo2.Key == ConsoleKey.B)
            {
                board[((cy - 1) / 2), ((cx - 1) / 4)] = "B" + takımharf;
                Promotionbool = true;
                Notation("promo", "B");
            }
            else
            {
                Console.SetCursorPosition(70, 7);
                Console.WriteLine("WRONG KEY TRY AGAIN");
                Promotionbool = false;

            }

            Console.SetCursorPosition(70, 1);
            Console.Write("                                                                   ");
            Console.SetCursorPosition(70, 3);
            Console.Write("                                                                       ");
            Console.SetCursorPosition(70, 5);
            Console.Write("                                                                    ");
            Console.SetCursorPosition(70, 7);
            Console.Write("                                                     ");
            Rewrite();
        }
        static void Wrong_move(int takım)
        {
            if (takım == 1)
                Console.ForegroundColor = ConsoleColor.DarkCyan;
            else if (takım == -1)
                Console.ForegroundColor = ConsoleColor.DarkRed;
            Console.SetCursorPosition(12, 20);
            Console.WriteLine("Wrong Place Try Again.");
            Console.ResetColor();
            if (takım == 0)
            {
                Console.SetCursorPosition(12, 20);
                Console.WriteLine("                                  ");
            }
        }
        static void Rewrite()
        {
            for (int y = 0; y < 8; y++)
            {
                for (int x = 0; x < 8; x++)
                {
                    Console.SetCursorPosition(4 * x + 4, 2 * y + 1);
                    if (board[y, x] == "E") Console.Write(".");
                    else if (board[y, x] == "PK")
                    {
                        Console.ForegroundColor = ConsoleColor.Red;
                        Console.Write("P");
                        Console.ResetColor();
                    }
                    else if (board[y, x] == "PM")
                    {
                        Console.ForegroundColor = ConsoleColor.Blue;
                        Console.Write("P");
                        Console.ResetColor();
                    }
                    else if (board[y, x] == "RK")
                    {
                        Console.ForegroundColor = ConsoleColor.Red;
                        Console.Write("R");
                        Console.ResetColor();
                    }
                    else if (board[y, x] == "RM")
                    {
                        Console.ForegroundColor = ConsoleColor.Blue;
                        Console.Write("R");
                        Console.ResetColor();
                    }
                    else if (board[y, x] == "NK")
                    {
                        Console.ForegroundColor = ConsoleColor.Red;
                        Console.Write("N");
                        Console.ResetColor();
                    }
                    else if (board[y, x] == "NM")
                    {
                        Console.ForegroundColor = ConsoleColor.Blue;
                        Console.Write("N");
                        Console.ResetColor();
                    }
                    else if (board[y, x] == "BK")
                    {
                        Console.ForegroundColor = ConsoleColor.Red;
                        Console.Write("B");
                        Console.ResetColor();
                    }
                    else if (board[y, x] == "BM")
                    {
                        Console.ForegroundColor = ConsoleColor.Blue;
                        Console.Write("B");
                        Console.ResetColor();
                    }
                    else if (board[y, x] == "QK")
                    {
                        Console.ForegroundColor = ConsoleColor.Red;
                        Console.Write("Q");
                        Console.ResetColor();
                    }
                    else if (board[y, x] == "QM")
                    {
                        Console.ForegroundColor = ConsoleColor.Blue;
                        Console.Write("Q");
                        Console.ResetColor();
                    }
                    else if (board[y, x] == "KK")
                    {
                        Console.ForegroundColor = ConsoleColor.Red;
                        Console.Write("K");
                        Console.ResetColor();
                    }
                    else if (board[y, x] == "KM")
                    {
                        Console.ForegroundColor = ConsoleColor.Blue;
                        Console.Write("K");
                        Console.ResetColor();
                    }
                    else Console.Write(board[y, x]);
                }
            }
        }
        static void Piyon(int ikigids, int cysayısı)
        {
            ConsoleKeyInfo keyInfo2 = Console.ReadKey(true);
            Wrong_move(0);
            if (keyInfo2.Key == ConsoleKey.N && at_ilkx - cx == 0 && at_ilky - cy == 0)
                yanlıstas = true;
            if (keyInfo2.Key == ConsoleKey.UpArrow)
                GelismisYön(8, 0, 0, 0);
            if (keyInfo2.Key == ConsoleKey.RightArrow)
                GelismisYön(0, 6, 0, 0);
            if (keyInfo2.Key == ConsoleKey.DownArrow)
                GelismisYön(0, 0, 2, 0);
            if (keyInfo2.Key == ConsoleKey.LeftArrow)
                GelismisYön(0, 0, 0, 4);
            if (keyInfo2.Key == ConsoleKey.Enter)
            {
                if (at_ilky == ikigids && Math.Abs(cx - at_ilkx) == 0 && Math.Abs(cy - at_ilky) == 4 && tempdenemei == 0)
                {
                    tempcxpawn = cx;
                    tempcypawn = cy;
                    if (cysayısı / 2 == 1)
                        enpassantk = true;
                    if (cysayısı / 2 == -1)
                        enpassantm = true;
                    çıkıcı = true;
                    Notation("normal", "");
                }

                else if (Math.Abs(cx - at_ilkx) == 0 && Math.Abs(cy - at_ilky) == 2 && tempdenemei == 0)
                {
                    çıkıcı = true;
                    Notation("normal", "");
                }

                else if (Math.Abs(cx - at_ilkx) == 4 && Math.Abs(cy - at_ilky) == 2 && tempdenemei == (cysayısı) && tempdeneme == "E")
                {
                    Notation("en", "");
                    board[((cy - 1) / 2) - (cysayısı / 2), ((cx - 1) / 4)] = "E";
                    board2[((cy - 1) / 2) - (cysayısı / 2), ((cx - 1) / 4)] = 0;
                    çıkıcı = true;
                }
                else if (Math.Abs(cx - at_ilkx) == 4 && Math.Abs(cy - at_ilky) == 2 && tempdenemei == (cysayısı / 2))
                {
                    if (cy != 1 && cy != 15)
                        Notation("yeme", "");
                    çıkıcı = true;

                }


                else
                    Wrong_move(-(cysayısı / 2));
            }
            Rewrite();
            tempdeneme2 = tempdeneme;
            tempdenemea = tempdenemei;
        }
        static void King(int takım, string takımkalesi)
        {
            ConsoleKeyInfo keyInfo2 = Console.ReadKey(true);
            Wrong_move(0);


            if (keyInfo2.Key == ConsoleKey.K && board2[((at_ilky - 1) / 2), ((at_ilkx - 1) / 4) + 1] == 0 && board2[((at_ilky - 1) / 2), ((at_ilkx - 1) / 4) + 2] == 0 && board[((at_ilky - 1) / 2), ((at_ilkx - 1) / 4) + 3] == "R" + takımkalesi)
            {
                GelismisYön(0, 6, 0, 0);
                GelismisYön(0, 6, 0, 0);
                board[((at_ilky - 1) / 2), ((at_ilkx - 1) / 4) + 1] = "R" + takımkalesi;
                board2[((at_ilky - 1) / 2), ((at_ilkx - 1) / 4) + 1] = takım;
                board[((at_ilky - 1) / 2), ((at_ilkx - 1) / 4) + 3] = "E";
                board2[((at_ilky - 1) / 2), ((at_ilkx - 1) / 4) + 3] = 0;
                Notation("kısarok", "");
                çıkıcı = true;
            }
            if (keyInfo2.Key == ConsoleKey.U && board2[((at_ilky - 1) / 2), ((at_ilkx - 1) / 4) - 1] == 0 && board2[((at_ilky - 1) / 2), ((at_ilkx - 1) / 4) - 2] == 0 && board2[((at_ilky - 1) / 2), ((at_ilkx - 1) / 4) - 3] == 0 && board[((at_ilky - 1) / 2), ((at_ilkx - 1) / 4) - 4] == "R" + takımkalesi)
            {
                GelismisYön(0, 0, 0, 4);
                GelismisYön(0, 0, 0, 4);
                board[((at_ilky - 1) / 2), ((at_ilkx - 1) / 4) - 1] = "R" + takımkalesi;
                board2[((at_ilky - 1) / 2), ((at_ilkx - 1) / 4) - 1] = takım;
                board[((at_ilky - 1) / 2), ((at_ilkx - 1) / 4) - 4] = "E";
                board2[((at_ilky - 1) / 2), ((at_ilkx - 1) / 4) - 4] = 0;
                Notation("uzunrok", "");
                çıkıcı = true;
            }

            if (keyInfo2.Key == ConsoleKey.N && at_ilkx - cx == 0 && at_ilky - cy == 0)
                yanlıstas = true;
            if (keyInfo2.Key == ConsoleKey.UpArrow)
                GelismisYön(8, 0, 0, 0);
            if (keyInfo2.Key == ConsoleKey.RightArrow)
                GelismisYön(0, 6, 0, 0);
            if (keyInfo2.Key == ConsoleKey.DownArrow)
                GelismisYön(0, 0, 2, 0);
            if (keyInfo2.Key == ConsoleKey.LeftArrow)
                GelismisYön(0, 0, 0, 4);
            if (keyInfo2.Key == ConsoleKey.Enter)
            {
                if (Math.Abs(cx - at_ilkx) == 0 && Math.Abs(cy - at_ilky) == 2 && tempdenemei != takım)
                {
                    if (tempdenemei == -takım)
                        Notation("yeme", "N");
                    else
                        Notation("normal", "N");
                    çıkıcı = true;
                }

                else if (Math.Abs(cx - at_ilkx) == 4 && Math.Abs(cy - at_ilky) == 0 && tempdenemei != takım)
                {
                    if (tempdenemei == -takım)
                        Notation("yeme", "N");
                    else
                        Notation("normal", "N");
                    çıkıcı = true;
                }
                if (Math.Abs(cx - at_ilkx) == 4 && Math.Abs(cy - at_ilky) == 2 && tempdenemei != takım)
                {
                    if (tempdenemei == -takım)
                        Notation("yeme", "N");
                    else
                        Notation("normal", "N");
                    çıkıcı = true;
                }

                else
                    Wrong_move(takım);
            }
            Rewrite();
            tempdeneme2 = tempdeneme;
            tempdenemea = tempdenemei;
        }
        static void At(int takım)
        {
            ConsoleKeyInfo keyInfo2 = Console.ReadKey(true);
            Wrong_move(0);
            if (keyInfo2.Key == ConsoleKey.N && at_ilkx - cx == 0 && at_ilky - cy == 0)
                yanlıstas = true;
            if (keyInfo2.Key == ConsoleKey.UpArrow)
                GelismisYön(8, 0, 0, 0);
            if (keyInfo2.Key == ConsoleKey.RightArrow)
                GelismisYön(0, 6, 0, 0);
            if (keyInfo2.Key == ConsoleKey.DownArrow)
                GelismisYön(0, 0, 2, 0);
            if (keyInfo2.Key == ConsoleKey.LeftArrow)
                GelismisYön(0, 0, 0, 4);
            if (keyInfo2.Key == ConsoleKey.Enter)
            {
                if (Math.Abs(cx - at_ilkx) == 8 && Math.Abs(cy - at_ilky) == 2 && tempdenemei != takım)// __| yada |__        
                {
                    if (tempdenemei == -takım)
                        Notation("yeme", "N");
                    else
                        Notation("normal", "N");
                    çıkıcı = true;
                }
                else if (Math.Abs(cx - at_ilkx) == 4 && Math.Abs(cy - at_ilky) == 4 && tempdenemei != takım)// L yada _|       
                {
                    if (tempdenemei == -takım)
                        Notation("yeme", "N");
                    else
                        Notation("normal", "N");
                    çıkıcı = true;
                }
                else
                    Wrong_move(takım);
            }
            Rewrite();
            tempdeneme2 = tempdeneme;
            tempdenemea = tempdenemei;
        }
        static void Kale(int karşı_takım)
        {
            ConsoleKeyInfo keyInfo2 = Console.ReadKey(true);
            Wrong_move(0);
            if (keyInfo2.Key == ConsoleKey.N && at_ilkx - cx == 0 && at_ilky - cy == 0)
                yanlıstas = true;
            if (temp_b == karşı_takım && countera > 1)
                queenbool = false;
            else if (sağsol == false && cy > 1 && keyInfo2.Key == ConsoleKey.UpArrow && board2[((cy - 1) / 2) - 1, (cx - 1) / 4] != -karşı_takım)
            {
                temp_b = board2[((cy - 1) / 2) - 1, (cx - 1) / 4];
                yukarıaşağı = true;
                Yön(cx, cy, "up");
                cy -= 2;
                Console.SetCursorPosition(cx, cy);
            }
            else if (sağsol == false && cy < 15 && keyInfo2.Key == ConsoleKey.DownArrow && board2[((cy - 1) / 2) + 1, (cx - 1) / 4] != -karşı_takım)
            {
                temp_b = board2[((cy - 1) / 2) + 1, (cx - 1) / 4];
                yukarıaşağı = true;
                Yön(cx, cy, "down");
                cy += 2;
                Console.SetCursorPosition(cx, cy);
            }
            else if (yukarıaşağı == false && keyInfo2.Key == ConsoleKey.RightArrow && cx < 30 && board2[((cy - 1) / 2), ((cx - 1) / 4) + 1] != -karşı_takım)
            {
                temp_b = board2[((cy - 1) / 2), ((cx - 1) / 4) + 1];
                sağsol = true;
                Yön(cx, cy, "right");
                cx += 4;
                Console.SetCursorPosition(cx, cy);
            }
            else if (yukarıaşağı == false && cx > 4 && keyInfo2.Key == ConsoleKey.LeftArrow && board2[((cy - 1) / 2), ((cx - 1) / 4) - 1] != -karşı_takım)
            {
                temp_b = board2[((cy - 1) / 2), ((cx - 1) / 4) - 1];
                sağsol = true;
                Yön(cx, cy, "left");
                cx -= 4;
                Console.SetCursorPosition(cx, cy);
            }
            if (at_ilkx - cx == 0 && at_ilky - cy == 0)
            {
                queenceviri = true;
                yukarıaşağı = false;
                sağsol = false;
            }
            if (keyInfo2.Key == ConsoleKey.Enter)
            {
                if (at_ilkx - cx == 0 && at_ilky - cy == 0)
                    Wrong_move(-karşı_takım);
                else

                    queenbool = false;
            }
            Rewrite();
            tempdeneme2 = tempdeneme;
            tempdenemea = tempdenemei;
        }
        static void Fil(int karşı_takım)
        {

            ConsoleKeyInfo keyInfo2 = Console.ReadKey(true);
            Wrong_move(0);
            if (keyInfo2.Key == ConsoleKey.N && at_ilkx - cx == 0 && at_ilky - cy == 0)
                yanlıstas = true;
            if (temp_b == karşı_takım && countera > 1)
                queenbool = false;

            else if (solcapraz == false && cy > 1 && cx < 30 && keyInfo2.Key == ConsoleKey.E && board2[((cy - 1) / 2) - 1, ((cx - 1) / 4) + 1] != -karşı_takım)//sagcapraz yukarı
            {
                temp_b = board2[((cy - 1) / 2) - 1, ((cx - 1) / 4) + 1];
                Console.SetCursorPosition(46, 5);
                sağcapraz = true;
                Yön(cx, cy, "ur");
                cy -= 2;
                cx += 4;
                Console.SetCursorPosition(cx, cy);
            }
            else if (solcapraz == false && cy < 15 && cx > 4 && keyInfo2.Key == ConsoleKey.Z && board2[((cy - 1) / 2) + 1, ((cx - 1) / 4) - 1] != -karşı_takım)//sagcaprz asagi
            {
                temp_b = board2[((cy - 1) / 2) + 1, ((cx - 1) / 4) - 1];
                Console.SetCursorPosition(46, 5);
                sağcapraz = true;
                Yön(cx, cy, "dl");
                cy += 2;
                cx -= 4;
                Console.SetCursorPosition(cx, cy);
            }
            else if (sağcapraz == false && cx > 4 && keyInfo2.Key == ConsoleKey.Q && board2[((cy - 1) / 2) - 1, ((cx - 1) / 4) - 1] != -karşı_takım)//solcapraz yukarı
            {
                temp_b = board2[((cy - 1) / 2) - 1, ((cx - 1) / 4) - 1];
                Console.SetCursorPosition(46, 5);
                solcapraz = true;
                Yön(cx, cy, "ul");
                cy -= 2;
                cx -= 4;
                Console.SetCursorPosition(cx, cy);
            }
            else if (sağcapraz == false && cy < 15 && cx < 30 && keyInfo2.Key == ConsoleKey.C && board2[((cy - 1) / 2) + 1, ((cx - 1) / 4) + 1] != -karşı_takım)//solcaprz asagi
            {
                temp_b = board2[((cy - 1) / 2) + 1, ((cx - 1) / 4) + 1];
                Console.SetCursorPosition(46, 5);
                solcapraz = true;
                Yön(cx, cy, "dr");
                cy += 2;
                cx += 4;
                Console.SetCursorPosition(cx, cy);
            }
            if (at_ilkx - cx == 0 && at_ilky - cy == 0)
            {
                queenceviri = false;
                sağcapraz = false;
                solcapraz = false;
            }
            if (keyInfo2.Key == ConsoleKey.Enter)
            {
                if (at_ilkx - cx == 0 && at_ilky - cy == 0)
                    Wrong_move(-karşı_takım);
                else
                    queenbool = false;
            }
        }
        static void Queen(bool sağsol, bool yukarıaşağı, int karşı_takım, bool sağcapraz, bool solcapraz)
        {
            while (queenbool == true)
            {
                if (yanlıstas == true)
                    break;
                if (queenceviri == true)
                    Fil(karşı_takım);
                if (queenceviri == false)
                    Kale(karşı_takım);
            }
            if (yanlıstas != true)
            {
                if (temp_b == karşı_takım)
                    Notation("yeme", "Q");
                else
                    Notation("normal", "Q");
            }

        }
        static void Yön(int x, int y, string belirleyici)
        {
            int yönbelirleyici = 0;
            int yönbelirleyici2 = 0;
            if (belirleyici == "up")
                yönbelirleyici = -1;
            if (belirleyici == "down")
                yönbelirleyici = 1;
            if (belirleyici == "right")
                yönbelirleyici2 = +1;
            if (belirleyici == "left")
                yönbelirleyici2 = -1;
            if (belirleyici == "ur")
            {
                yönbelirleyici = -1;//y 
                yönbelirleyici2 = 1;//x
            }
            if (belirleyici == "dl")
            {
                yönbelirleyici = 1;
                yönbelirleyici2 = -1;
            }
            if (belirleyici == "ul")
            {
                yönbelirleyici = -1;
                yönbelirleyici2 = -1;
            }
            if (belirleyici == "dr")
            {
                yönbelirleyici = 1;
                yönbelirleyici2 = 1;
            }
            board[((y - 1) / 2) + yönbelirleyici, ((x - 1) / 4) + yönbelirleyici2] = board[(y - 1) / 2, ((x - 1) / 4)];
            board[(y - 1) / 2, (x - 1) / 4] = "E";
            board2[((y - 1) / 2) + yönbelirleyici, ((x - 1) / 4) + yönbelirleyici2] = board2[(y - 1) / 2, ((x - 1) / 4)];
            board2[(y - 1) / 2, (x - 1) / 4] = 0;
            Rewrite();

        }

        static void Yön2(int x, int y, int X, int Y)
        {

            board[Y, X] = board[y, x];
            board[y, x] = "E";
            board2[Y, X] = board2[y, x];
            board2[y, x] = 0;
            Rewrite();

        }
        static void Yön3(int x, int y, int X, int Y)
        {
            string ffirst = board[y, x];
            board[y, x] = board[Y, X];
            board[Y, X] = ffirst;
            Rewrite();
        }

        static void Main(string[] args)
        {
            string dosya = "";
            Console.SetCursorPosition(44, 2);
            Console.ForegroundColor = ConsoleColor.DarkYellow;
            Console.Write("M   O   V   E");
            Console.SetCursorPosition(44, 4);
            Console.Write("O");
            Console.SetCursorPosition(44, 6);
            Console.Write("V");
            Console.SetCursorPosition(44, 8);
            Console.Write("E");
            Console.ResetColor();
            Console.SetCursorPosition(0, 0);
            int count = 1;

            string[] gösterici2 = new string[] { "a", "b", "c", "d", "e", "f", "g", "h" };
            for (int i = 0; i < gösterici.Length; i++)
            {
                if (i % 4 == 0 && i > 3)
                    gösterici[i] = gösterici2[i / 4 - 1];
                else
                    gösterici[i] = null;
            }

            string[] sgösterici2 = new string[] { "8", "7", "6", "5", "4", "3", "2", "1" };
            for (int i = 1; i < sgösterici.Length; i += 2)
            {
                sgösterici[i] = sgösterici2[i - count];
                count++;
            }
            cx = 4;
            cy = 1;
            int temp2cypawn = 200, temp2cxpawn = 200;
            int k = 9;
            for (int i = 0; i <= 16; i++)
            {
                System.Threading.Thread.Sleep(50);
                if (i == 0 || i == 16) Console.WriteLine("  +--------------------------------+");
                if (i % 2 == 1)
                {
                    k--;
                    Console.WriteLine(k + " |                                |");
                }
                else
                {
                    if (i < 16 && i > 0 && i % 2 == 0) Console.WriteLine("  |                                |");

                }
            }
            int game_counter = 0;
            Rewrite();
            Console.SetCursorPosition(3, 17);
            Console.Write(" a   b   c   d   e   f   g   h ");
            int ccount = 0;
            string c = "";
            bool kırıcı = true;
            Console.SetCursorPosition(0, 20);
            Console.WriteLine("Which game style do you want to play?  1-Play Mode   2-String Mode   3-Demo Mode");
            string check = Console.ReadLine();
            if (check == "1" || check == "2")
            {
                Console.WriteLine("If you want a play demo mode press enter or Enter Game .txt name");
                gamename = Console.ReadLine();
                StreamWriter f1 = File.CreateText(gamename + ".txt");
                f1.Close();
            }
            if (check == "3")
            {
                Console.WriteLine("Enter txt file name");
                dosya = Console.ReadLine();

            }
            if (check == "2" || check == "3")
            {
                Console.SetCursorPosition(0, 20);
                Console.WriteLine("                                                                                                                      ");
                Console.SetCursorPosition(0, 21);
                Console.WriteLine("         ");
                while (true)
                {
                    //-----
                    string a = "";
                    Console.SetCursorPosition(40, 15);
                    Console.WriteLine("                        ");
                    Console.SetCursorPosition(65, 20);
                    Console.WriteLine("                        ");
                    if (game_counter % 2 == 0)
                    {
                        Console.SetCursorPosition(40, 15);
                        Console.ForegroundColor = ConsoleColor.Blue;
                        Console.WriteLine("play turn is in blue");
                        Console.ResetColor();
                    }
                    if (game_counter % 2 == 1)
                    {
                        Console.SetCursorPosition(40, 15);
                        Console.ForegroundColor = ConsoleColor.Red;
                        Console.WriteLine("play turn is in red");
                        Console.ResetColor();
                    }
                    Console.SetCursorPosition(0, 23);
                    Console.WriteLine("                                 ");
                    if (check == "2")//string mode
                    {
                        Console.SetCursorPosition(0, 22);
                        Console.WriteLine("enter a string");
                        a = Console.ReadLine();
                        c = a;

                    }
                    else if (check == "3")//Demo mod
                    {


                        StreamReader f = File.OpenText(dosya + ".txt");
                        string sstr = f.ReadLine();
                        f.Close();
                        string[] words = sstr.Split(' ');
                        ConsoleKeyInfo keyInfo = Console.ReadKey(true);
                        if (keyInfo.Key == ConsoleKey.Spacebar)
                        {
                            a = words[ccount];
                            c = a;
                            ccount++;
                        }
                        if (keyInfo.Key == ConsoleKey.Enter)
                        {
                            check = "1";
                            break;
                        }
                    }


                    int yy = 0, xx = 0, xxx = 0, yyy = 0;
                    int locx = 0, line = 0;
                    bool flag = false, flag2 = true;
                    string from = "", color = "";
                    string where = "", column = "", columnf = "", fil_kontrol = "";
                    for (int i = 0; i < a.Length; i++)
                    {
                        if (a[i] == 'x')
                        {
                            flag = true;
                            locx = i;
                            break;
                        }
                    }
                    if (flag == true)//capture
                    {
                        Console.SetCursorPosition(0, 50);
                        Console.WriteLine("capture");
                        Console.SetCursorPosition(0, 51);
                        Console.WriteLine(locx);
                        if (a.Length == 5)//
                        {
                            where = a.Substring(a.Length - 2, 2);
                            from = a.Substring(0, 2);
                            column = where.Substring(0, 1);
                            line = Convert.ToInt32(where.Substring(1, 1));
                            columnf = from.Substring(1, 1);

                        }
                        if (a.Length == 4 && locx == 1)//pawn
                        {
                            where = a.Substring(a.Length - 2, 2);
                            from = a.Substring(0, 1);
                            column = where.Substring(0, 1);
                            line = Convert.ToInt32(where.Substring(1, 1));
                            columnf = from.Substring(0, 1);

                        }
                        if (locx == 1)
                            from = a.Substring(0, 1);
                        else if (locx == 2)
                            from = a.Substring(0, 2);

                        where = a.Substring(a.Length - 2, 2);

                    }
                    else if (flag == false)//no capture
                    {
                        Console.SetCursorPosition(0, 52);
                        Console.WriteLine("no capture");
                        if (a.Length == 2)//pawn
                        {
                            where = a.Substring(0, 2);
                            column = where.Substring(0, 1);
                            line = Convert.ToInt32(where.Substring(1, 1));

                        }
                        else if (a.Length == 3)
                        {
                            where = a.Substring(a.Length - 2, 2);
                            from = a.Substring(0, 1);
                            column = where.Substring(0, 1);
                            line = Convert.ToInt32(where.Substring(1, 1));
                        }
                        else if (a.Length == 4)
                        {
                            where = a.Substring(a.Length - 2, 2);
                            from = a.Substring(0, 2);
                            column = where.Substring(0, 1);
                            columnf = from.Substring(1, 1);
                            line = Convert.ToInt32(where.Substring(1, 1));
                        }
                    }


                    Console.SetCursorPosition(0, 53);
                    Console.WriteLine("from:" + from + "      where:" + where);
                    Console.SetCursorPosition(0, 54);
                    Console.WriteLine(column + "      " + line);

                    if (columnf == "a")//first point
                    {
                        xx = 0;
                    }
                    if (columnf == "b")
                    {
                        xx = 1;
                    }
                    if (columnf == "c")
                    {
                        xx = 2;
                    }
                    if (columnf == "d")
                    {
                        xx = 3;
                    }
                    if (columnf == "e")
                    {
                        xx = 4;
                    }
                    if (columnf == "f")
                    {
                        xx = 5;
                    }
                    if (columnf == "g")
                    {
                        xx = 6;
                    }
                    if (columnf == "h")
                    {
                        xx = 7;
                    }

                    if (column == "a")//last point
                    {
                        xxx = 0;
                    }
                    if (column == "b")
                    {
                        xxx = 1;
                    }
                    if (column == "c")
                    {
                        xxx = 2;
                    }
                    if (column == "d")
                    {
                        xxx = 3;
                    }
                    if (column == "e")
                    {
                        xxx = 4;
                    }
                    if (column == "f")
                    {
                        xxx = 5;
                    }
                    if (column == "g")
                    {
                        xxx = 6;
                    }
                    if (column == "h")
                    {
                        xxx = 7;
                    }
                    yyy = 8 - line;
                    Console.SetCursorPosition(0, 55);
                    Console.WriteLine(xxx + "   last    " + yyy);//--
                    if (game_counter % 2 == 0)//COLOR--
                    {
                        if (a == "0-0" || a == "0-0-0")
                        {
                            color = color + a + "M";
                        }
                        else if (from == "")
                        {
                            color = color + "PM";
                        }
                        else if (from == from.Substring(0, 1).ToLower())
                        {
                            color = color + "PM";
                        }
                        else
                        {
                            color = color + from.Substring(0, 1) + "M";

                        }
                    }
                    if (game_counter % 2 == 1)
                    {
                        if (a == "0-0" || a == "0-0-0")
                        {
                            color = color + a + "M";
                        }
                        else if (from == "")
                        {
                            color = color + "PK";
                        }
                        else if (from == from.Substring(0, 1).ToLower())
                        {
                            color = color + "PK";
                        }
                        else
                        {
                            color = color + from.Substring(0, 1) + "K";

                        }
                    }
                    Console.SetCursorPosition(0, 56);
                    Console.WriteLine(color);
                    for (int i = 0; i < 8; i++)//first point calculator (y)
                    {
                        if (a.Length == 2)
                        {
                            if (board[i, xxx] == color)
                            {
                                yy = i;

                                if (flag == false && a.Length == 2)
                                {
                                    xx = xxx;
                                }


                                Console.SetCursorPosition(0, 57);
                                Console.WriteLine(xx + "   first    " + yy);
                            }
                        }
                        else
                        {
                            if (board[i, xx] == color)
                            {
                                yy = i;

                                if (flag == false && a.Length == 2)
                                {
                                    xx = xxx;
                                }


                                Console.SetCursorPosition(0, 57);
                                Console.WriteLine(xx + "   first    " + yy);
                            }
                        }

                    }
                    if (color == "PM" && flag == false && board2[yyy, xxx] == 0)//pawn  MAVİ no capture
                    {
                        if (yy == 6 && (yy - yyy == 2))
                        {
                            Yön2(xx, yy, xxx, yyy);
                            game_counter++;

                        }
                        if (yy - yyy == 1)
                        {
                            Yön2(xx, yy, xxx, yyy);
                            game_counter++;
                        }
                        if (yyy == 0)
                        {
                            Console.SetCursorPosition(65, 20);
                            Console.Write("Enter a game item you want   :");
                            string b = Console.ReadLine();
                            board[yyy, xxx] = b + "M";
                            Rewrite();
                        }


                    }
                    if (color == "PM" && flag == true)//pawn MAVİ capture
                    {
                        if (yy - yyy == 1 && (((xxx - xx == 1 && board2[yyy, xxx] == -1)) || ((xxx - xx == -1 && board2[yyy, xxx] == -1))))
                        {
                            Yön2(xx, yy, xxx, yyy);
                            game_counter++;

                        }
                        Console.ForegroundColor = ConsoleColor.DarkCyan;
                        Console.SetCursorPosition(48, 4 + game_counter / 2);
                        Console.WriteLine(game_counter + 1 / 2 + ". " + c);
                        Console.ResetColor();
                    }
                    if (color == "PK" && flag == false && board2[yyy, xxx] == 0)//pawn  KIRMIZI no capture
                    {
                        if (yy == 1 && (yy - yyy == -2))
                        {
                            Yön2(xx, yy, xxx, yyy);
                            game_counter++;

                        }
                        if (yy - yyy == -1)
                        {
                            Yön2(xx, yy, xxx, yyy);
                            game_counter++;
                        }
                        if (yyy == 7)
                        {
                            Console.SetCursorPosition(65, 20);
                            Console.Write("Enter a game item you want   :");
                            string b = Console.ReadLine();
                            board[yyy, xxx] = b + "K";
                            Rewrite();
                        }
                    }
                    if (color == "PK" && flag == true && board2[yyy, xxx] == 1)//pawn KIRMIZI capture
                    {
                        if (yy - yyy == -1 && xxx - xx == 1)
                        {
                            Yön2(xx, yy, xxx, yyy);
                            game_counter++;
                        }
                        if (yy - yyy == -1 && xxx - xx == -1)
                        {
                            Yön2(xx, yy, xxx, yyy);
                            game_counter++;
                        }

                    }
                    if (color == "NM" && flag == false && ((Math.Abs(yyy - yy) == 2 && Math.Abs(xxx - xx) == 1) || (Math.Abs(yyy - yy) == 1 && Math.Abs(xxx - xx) == 2)) && board2[yyy, xxx] == 0)// mavi at no capture
                    {
                        Yön2(xx, yy, xxx, yyy);
                        game_counter++;
                    }
                    if (color == "NM" && flag == true && ((Math.Abs(yyy - yy) == 2 && Math.Abs(xxx - xx) == 1) || (Math.Abs(yyy - yy) == 1 && Math.Abs(xxx - xx) == 2)) && board2[yyy, xxx] == -1)// mavi at  capture
                    {
                        Yön2(xx, yy, xxx, yyy);
                        game_counter++;
                    }
                    if (color == "NK" && flag == false && ((Math.Abs(yyy - yy) == 2 && Math.Abs(xxx - xx) == 1) || (Math.Abs(yyy - yy) == 1 && Math.Abs(xxx - xx) == 2)) && board2[yyy, xxx] == 0)// kırmızı at no capture
                    {
                        Yön2(xx, yy, xxx, yyy);
                        game_counter++;
                    }
                    if (color == "NK" && flag == true && ((Math.Abs(yyy - yy) == 2 && Math.Abs(xxx - xx) == 1) || (Math.Abs(yyy - yy) == 1 && Math.Abs(xxx - xx) == 2)) && board2[yyy, xxx] == 1)// kırmızı at  capture
                    {
                        Yön2(xx, yy, xxx, yyy);
                        game_counter++;
                    }
                    if ((color == "RM" || color == "RK") && ((flag == false && board2[yyy, xxx] == 0) || (flag == true && board2[yyy, xxx] == -1 && board2[yy, xx] == 1) || (flag == true && board2[yyy, xxx] == 1 && board2[yy, xx] == -1)))// kale 
                    {
                        int bigger, lower;
                        if (yy == yyy && xx != xxx)
                        {
                            if (xx > xxx)
                            {
                                bigger = xx;
                                lower = xxx;
                            }
                            else
                            {
                                bigger = xxx;
                                lower = xx;
                            }
                            for (int i = lower + 1; i < bigger; i++)
                            {
                                if (board2[yy, i] != 0)
                                {
                                    flag2 = false;
                                }
                            }
                            if (flag2 == true)
                            {
                                Yön2(xx, yy, xxx, yyy);
                                game_counter++;
                            }
                        }
                        if (yy != yyy && xx == xxx)
                        {
                            if (yy > yyy)
                            {
                                bigger = yy;
                                lower = yyy;
                            }
                            else
                            {
                                bigger = yyy;
                                lower = yy;
                            }
                            for (int i = lower + 1; i < bigger; i++)
                            {
                                if (board2[i, xx] != 0)
                                {
                                    flag2 = false;
                                }
                            }
                            if (flag2 == true)
                            {
                                Yön2(xx, yy, xxx, yyy);
                                game_counter++;
                            }
                        }
                    }
                    if ((color == "BM" || color == "BK") && ((flag == false && board2[yyy, xxx] == 0) || (flag == true && board2[yyy, xxx] == -1 && board2[yy, xx] == 1) || (flag == true && board2[yyy, xxx] == 1 && board2[yy, xx] == -1)))// fil
                    {
                        int biggerx, lowerx, biggery, lowery;
                        if (Math.Abs(xxx - xx) == Math.Abs(yyy - yy))
                        {
                            if (xx > xxx)
                            {
                                biggerx = xx;
                                lowerx = xxx;
                                fil_kontrol = "sol";
                            }
                            else
                            {
                                biggerx = xxx;
                                lowerx = xx;
                                fil_kontrol = "sag";
                            }
                            if (yy > yyy)
                            {
                                biggery = yy;
                                lowery = yyy;
                            }
                            else
                            {
                                biggery = yyy;
                                lowery = yy;
                            }
                            if (fil_kontrol == "sag")
                            {
                                int j = biggery - 1;
                                for (int i = lowerx + 1; i < biggerx; i++)
                                {
                                    if (board2[j, i] != 0)
                                    {
                                        flag2 = false;
                                    }
                                    j--;
                                    if (j == lowery)
                                    {
                                        break;
                                    }
                                }
                            }
                            if (fil_kontrol == "sol")
                            {
                                int j = lowery + 1;
                                for (int i = lowerx + 1; i < biggerx; i++)
                                {
                                    if (board2[j, i] != 0)
                                    {
                                        flag2 = false;
                                    }
                                    j++;
                                    if (j == biggery)
                                    {
                                        break;
                                    }
                                }
                            }
                            if (flag2 == true)
                            {
                                Yön2(xx, yy, xxx, yyy);
                                game_counter++;
                            }
                        }
                    }
                    if ((color == "QM" || color == "QK") && ((flag == false && board2[yyy, xxx] == 0) || (flag == true && board2[yyy, xxx] == -1 && board2[yy, xx] == 1) || (flag == true && board2[yyy, xxx] == 1 && board2[yy, xx] == -1)))// queen
                    {
                        int biggerx, lowerx, biggery, lowery;
                        if (Math.Abs(xxx - xx) == Math.Abs(yyy - yy))
                        {
                            if (xx > xxx)
                            {
                                biggerx = xx;
                                lowerx = xxx;
                                fil_kontrol = "sol";
                            }
                            else
                            {
                                biggerx = xxx;
                                lowerx = xx;
                                fil_kontrol = "sag";
                            }
                            if (yy > yyy)
                            {
                                biggery = yy;
                                lowery = yyy;
                            }
                            else
                            {
                                biggery = yyy;
                                lowery = yy;
                            }
                            if (fil_kontrol == "sag")
                            {
                                int j = biggery - 1;
                                for (int i = lowerx + 1; i < biggerx; i++)
                                {

                                    if (board2[j, i] != 0)
                                    {
                                        flag2 = false;
                                    }
                                    j--;
                                    if (j == lowery)
                                    {
                                        break;
                                    }

                                }

                            }
                            if (fil_kontrol == "sol")
                            {
                                int j = lowery + 1;
                                for (int i = lowerx + 1; i < biggerx; i++)
                                {

                                    if (board2[j, i] != 0)
                                    {
                                        flag2 = false;
                                    }
                                    j++;
                                    if (j == biggery)
                                    {
                                        break;
                                    }

                                }

                            }
                            if (flag2 == true)
                            {
                                Yön2(xx, yy, xxx, yyy);
                                game_counter++;
                            }
                        }
                        else
                        {
                            int bigger, lower;
                            if (yy == yyy && xx != xxx)
                            {
                                if (xx > xxx)
                                {
                                    bigger = xx;
                                    lower = xxx;
                                }
                                else
                                {
                                    bigger = xxx;
                                    lower = xx;
                                }
                                for (int i = lower + 1; i < bigger; i++)
                                {
                                    if (board2[yy, i] != 0)
                                    {
                                        flag2 = false;
                                    }
                                }
                                if (flag2 == true)
                                {
                                    Yön2(xx, yy, xxx, yyy);
                                    game_counter++;
                                }
                            }
                            if (yy != yyy && xx == xxx)
                            {
                                if (yy > yyy)
                                {
                                    bigger = yy;
                                    lower = yyy;
                                }
                                else
                                {
                                    bigger = yyy;
                                    lower = yy;
                                }
                                for (int i = lower + 1; i < bigger; i++)
                                {
                                    if (board2[i, xx] != 0)
                                    {
                                        flag2 = false;
                                    }
                                }
                                if (flag2 == true)
                                {
                                    Yön2(xx, yy, xxx, yyy);
                                    game_counter++;
                                }
                            }
                        }

                    }
                    if ((color == "KM" || color == "KK") && ((flag == false && board2[yyy, xxx] == 0) || (flag == true && board2[yyy, xxx] == -1 && board2[yy, xx] == 1) || (flag == true && board2[yyy, xxx] == 1 && board2[yy, xx] == -1)))// king
                    {
                        if ((yy == yyy && xx != xxx && Math.Abs(xx - xxx) == 1) || (yy != yyy && xx == xxx && Math.Abs(yy - yyy) == 1))
                        {
                            Yön2(xx, yy, xxx, yyy);
                            game_counter++;
                        }
                        if (yy != yyy && xx != xxx && Math.Abs(yy - yyy) == 1 && Math.Abs(xx - xxx) == 1)
                        {
                            Yön2(xx, yy, xxx, yyy);
                            game_counter++;
                        }


                    }
                    if ((color == "0-0M") && board2[7, 5] == 0 && board2[7, 6] == 0 && board2[7, 7] == 1 && board[7, 7] == "RM")//rok mavi kısa
                    {
                        Yön3(4, 7, 7, 7);
                        game_counter++;
                    }
                    if ((color == "0-0K") && board2[0, 5] == 0 && board2[0, 6] == 0 && board2[0, 7] == -1 && board[0, 7] == "RK")//rok kırmızı kısa
                    {
                        Yön3(4, 0, 7, 0);
                        game_counter++;
                    }
                    if ((color == "0-0-0M") && board2[7, 1] == 0 && board2[7, 2] == 0 && board2[7, 3] == 0 && board2[7, 0] == 1 && board[7, 0] == "RM")//rok mavi uzun
                    {
                        Yön3(4, 7, 0, 7);
                        game_counter++;
                    }
                    if ((color == "0-0-0K") && board2[0, 1] == 0 && board2[0, 2] == 0 && board2[0, 3] == 0 && board2[0, 0] == -1 && board[0, 0] == "RK")//rok kırmızı uzun
                    {
                        Yön3(4, 0, 0, 0);
                        game_counter++;
                    }



                    if (game_counter % 2 == 1)
                    {
                        Console.SetCursorPosition(48, 4 + game_counter / 2);
                        Console.WriteLine((game_counter + 1) / 2 + ". ");
                        Console.ForegroundColor = ConsoleColor.DarkCyan;
                        Console.SetCursorPosition(50, 4 + game_counter / 2);
                        Console.WriteLine(c);
                        StreamWriter f3 = File.AppendText(gamename + ".txt");
                        f3.Write(c + " ");
                        f3.Close();
                    }
                    else if (game_counter % 2 == 0)
                    {
                        Console.ForegroundColor = ConsoleColor.DarkRed;
                        Console.SetCursorPosition(60, 4 + (game_counter / 2) - 1);
                        Console.WriteLine(c);
                        StreamWriter f3 = File.AppendText(gamename + ".txt");
                        f3.Write(c + " ");
                        f3.Close();
                    }


                    Console.ResetColor();
                }
            }
            if (check == "1")
            {
                while (true)
                {
                    Console.SetCursorPosition(0, 20);
                    Console.WriteLine("                                                                                                                      ");
                    Console.SetCursorPosition(0, 21);
                    Console.WriteLine("         ");

                    if (game_counter % 2 == 0)
                    {

                        Console.SetCursorPosition(12, 19);
                        Console.ForegroundColor = ConsoleColor.DarkCyan;
                        Console.WriteLine("Blue's Turn");

                        if (enpassantm == true)
                            if (board2[(((temp2cypawn - 1) / 2) + 1), ((temp2cxpawn - 1) / 4)] == 2)
                                board2[(((temp2cypawn - 1) / 2) + 1), ((temp2cxpawn - 1) / 4)] = 0;
                        enpassantm = false;
                        if (enpassantk == true)
                        {
                            board2[(((tempcypawn - 1) / 2) - 1), ((tempcxpawn - 1) / 4)] = -2;
                            temp2cypawn = tempcypawn;
                            temp2cxpawn = tempcxpawn;
                        }
                    }
                    else
                    {
                        Console.SetCursorPosition(12, 19);
                        Console.ForegroundColor = ConsoleColor.DarkRed;
                        Console.WriteLine(" Red's Turn");

                        if (enpassantk == true)
                            if (board2[(((temp2cypawn - 1) / 2) - 1), ((temp2cxpawn - 1) / 4)] == -2)
                                board2[(((temp2cypawn - 1) / 2) - 1), ((temp2cxpawn - 1) / 4)] = 0;
                        enpassantk = false;
                        if (enpassantm == true)
                        {
                            board2[(((tempcypawn - 1) / 2) + 1), ((tempcxpawn - 1) / 4)] = 2;
                            temp2cypawn = tempcypawn;
                            temp2cxpawn = tempcxpawn;
                        }



                    }
                    Console.ResetColor();

                    for (int y = 0; y < 8; y++)
                    {

                        for (int x = 0; x < 8; x++)
                        {
                            Console.SetCursorPosition(4 * x + 4, 2 * y + 1);
                            if (board[y, x] == "E") Console.Write(".");
                            else if (board[y, x] == "PK")
                            {
                                Console.ForegroundColor = ConsoleColor.Red;
                                Console.Write("P");
                                Console.ResetColor();
                            }
                            else if (board[y, x] == "PM")
                            {
                                Console.ForegroundColor = ConsoleColor.Blue;
                                Console.Write("P");
                                Console.ResetColor();
                            }
                            else if (board[y, x] == "RK")
                            {
                                Console.ForegroundColor = ConsoleColor.Red;
                                Console.Write("R");
                                Console.ResetColor();
                            }
                            else if (board[y, x] == "RM")
                            {
                                Console.ForegroundColor = ConsoleColor.Blue;
                                Console.Write("R");
                                Console.ResetColor();
                            }
                            else if (board[y, x] == "NK")
                            {
                                Console.ForegroundColor = ConsoleColor.Red;
                                Console.Write("N");
                                Console.ResetColor();
                            }
                            else if (board[y, x] == "NM")
                            {
                                Console.ForegroundColor = ConsoleColor.Blue;
                                Console.Write("N");
                                Console.ResetColor();
                            }
                            else if (board[y, x] == "BK")
                            {
                                Console.ForegroundColor = ConsoleColor.Red;
                                Console.Write("B");
                                Console.ResetColor();
                            }
                            else if (board[y, x] == "BM")
                            {
                                Console.ForegroundColor = ConsoleColor.Blue;
                                Console.Write("B");
                                Console.ResetColor();
                            }
                            else if (board[y, x] == "QK")
                            {
                                Console.ForegroundColor = ConsoleColor.Red;
                                Console.Write("Q");
                                Console.ResetColor();
                            }
                            else if (board[y, x] == "QM")
                            {
                                Console.ForegroundColor = ConsoleColor.Blue;
                                Console.Write("Q");
                                Console.ResetColor();
                            }
                            else if (board[y, x] == "KK")
                            {
                                Console.ForegroundColor = ConsoleColor.Red;
                                Console.Write("K");
                                Console.ResetColor();
                            }
                            else if (board[y, x] == "KM")
                            {
                                Console.ForegroundColor = ConsoleColor.Blue;
                                Console.Write("K");
                                Console.ResetColor();
                            }
                            else Console.Write(board[y, x]);
                        }
                    }

                    Console.SetCursorPosition(cx, cy);
                    Console.CursorVisible = true;
                    ConsoleKeyInfo keyInfo = Console.ReadKey(true);
                    if (keyInfo.Key == ConsoleKey.RightArrow && cx < 29)
                        cx += 4;
                    if (keyInfo.Key == ConsoleKey.LeftArrow && cx > 4)
                        cx -= 4;
                    if (keyInfo.Key == ConsoleKey.UpArrow && cy > 2)
                        cy -= 2;
                    if (keyInfo.Key == ConsoleKey.DownArrow && cy < 15)
                        cy += 2;
                    Console.SetCursorPosition(cx, cy);

                    if (keyInfo.Key == ConsoleKey.Enter)
                    {
                        notation = game_counter;
                        atoan = false;
                        if (atoan == false)
                        {
                            at_ilkx = cx;
                            at_ilky = cy;
                        }
                        atoan = true;
                        StreamWriter f2 = File.AppendText(gamename + ".txt");
                        queenbool = true;
                        queenceviri = true;
                        tempdeneme = "E";
                        tempdeneme2 = "E";
                        tempdenemei = 0;
                        tempdenemea = 0;
                        countera = 0;
                        bool yukarıaşağı = false;
                        bool sağsol = false;
                        bool solcapraz = false;
                        bool sağcapraz = false;
                        Promotionbool = false;

                        çıkıcı = false;
                        Console.CursorVisible = false;
                        while (true)
                        {
                            yanlıstas = false;
                            if ((board[(cy - 1) / 2, (cx - 1) / 4] == "E"))
                            {
                                Console.SetCursorPosition(12, 21);
                                Console.ForegroundColor = ConsoleColor.DarkYellow;
                                Console.Write("You do not choose any piece");
                                Console.ResetColor();
                                break;
                            }
                            else
                            {
                                Console.SetCursorPosition(12, 21);
                                Console.WriteLine("                                  ");
                            }
                            if (game_counter % 2 == 0 && board[(cy - 1) / 2, (cx - 1) / 4] == "PM")
                            {
                                while (çıkıcı == false)
                                {
                                    Piyon(13, -2);
                                    if (yanlıstas == true)
                                        break;

                                }
                                if (yanlıstas == true)
                                    break;

                                if (cy == 1)
                                {
                                    while (Promotionbool == false)
                                        Promotion("M");
                                }

                                game_counter++;
                                break;

                            }
                            if (game_counter % 2 != 0 && board[(cy - 1) / 2, (cx - 1) / 4] == "PM")
                                break;
                            if (game_counter % 2 == 1 && board[(cy - 1) / 2, (cx - 1) / 4] == "PK")
                            {
                                while (çıkıcı == false)
                                {
                                    Piyon(3, 2);
                                    if (yanlıstas == true)
                                        break;
                                }
                                if (yanlıstas == true)
                                    break;

                                if (cy == 15)
                                {
                                    while (Promotionbool == false)
                                        Promotion("K");
                                }
                                game_counter++;
                                break;

                            }//
                            if (game_counter % 2 != 1 && board[(cy - 1) / 2, (cx - 1) / 4] == "PK")
                                break;
                            if (game_counter % 2 == 0 && board[(cy - 1) / 2, (cx - 1) / 4] == "RM")
                            {
                                while (queenbool == true)
                                {
                                    countera++;
                                    if (yanlıstas == true)
                                        break;
                                    Kale(-1);
                                }
                                if (yanlıstas == true)
                                    break;
                                if (temp_b == -1)
                                    Notation("yeme", "R");
                                else
                                    Notation("normal", "R");
                                game_counter++;
                                break;
                            }
                            if (game_counter % 2 != 0 && board[(cy - 1) / 2, (cx - 1) / 4] == "RM")
                                break;
                            if (game_counter % 2 == 1 && board[(cy - 1) / 2, (cx - 1) / 4] == "RK")
                            {
                                while (queenbool == true)
                                {
                                    countera++;
                                    if (yanlıstas == true)
                                        break;
                                    Kale(1);
                                }
                                if (yanlıstas == true)
                                    break;
                                if (temp_b == 1)
                                    Notation("yeme", "R");
                                else
                                    Notation("normal", "R");
                                game_counter++;
                                break;
                            }
                            if (game_counter % 2 != 1 && board[(cy - 1) / 2, (cx - 1) / 4] == "RK")
                                break;
                            if (game_counter % 2 == 0 && board[(cy - 1) / 2, (cx - 1) / 4] == "BM")//fil
                            {
                                while (queenbool == true)
                                {
                                    countera++;
                                    if (yanlıstas == true)
                                        break;
                                    Fil(-1);
                                }
                                if (yanlıstas == true)
                                    break;
                                if (temp_b == -1)
                                    Notation("yeme", "B");
                                else
                                    Notation("normal", "B");
                                game_counter++;
                                break;
                            }
                            if (game_counter % 2 != 0 && board[(cy - 1) / 2, (cx - 1) / 4] == "BM")
                                break;
                            if (game_counter % 2 == 1 && board[(cy - 1) / 2, (cx - 1) / 4] == "BK")//fil
                            {
                                while (queenbool == true)
                                {
                                    countera++;
                                    if (yanlıstas == true)
                                        break;
                                    Fil(1);
                                }
                                if (yanlıstas == true)
                                    break;
                                if (temp_b == 1)
                                    Notation("yeme", "B");
                                else
                                    Notation("normal", "B");
                                game_counter++;
                                break;
                            }
                            if (game_counter % 2 != 1 && board[(cy - 1) / 2, (cx - 1) / 4] == "BK")
                                break;
                            if (game_counter % 2 == 0 && board[(cy - 1) / 2, (cx - 1) / 4] == "QM")//queen
                            {
                                Queen(sağsol, yukarıaşağı, -1, sağcapraz, solcapraz);
                                if (yanlıstas == true)
                                    break;
                                game_counter++;
                                break;
                            }
                            if (game_counter % 2 != 0 && board[(cy - 1) / 2, (cx - 1) / 4] == "QM")
                                break;
                            if (game_counter % 2 == 1 && board[(cy - 1) / 2, (cx - 1) / 4] == "QK")//queen
                            {
                                Queen(sağsol, yukarıaşağı, 1, sağcapraz, solcapraz);
                                if (yanlıstas == true)
                                    break;
                                game_counter++;
                                break;
                            }
                            if (game_counter % 2 != 1 && board[(cy - 1) / 2, (cx - 1) / 4] == "QK")
                                break;
                            if (game_counter % 2 == 0 && (board[(cy - 1) / 2, (cx - 1) / 4] == "NM"))
                            {
                                while (çıkıcı == false)
                                {
                                    if (yanlıstas == true)
                                        break;
                                    At(1);
                                }
                                if (yanlıstas == true)
                                    break;
                                game_counter++;
                                break;
                            }
                            if (game_counter % 2 != 0 && (board[(cy - 1) / 2, (cx - 1) / 4] == "NM"))
                                break;
                            if (game_counter % 2 == 1 && (board[(cy - 1) / 2, (cx - 1) / 4] == "NK"))
                            {
                                while (çıkıcı == false)
                                {
                                    if (yanlıstas == true)
                                        break;
                                    At(-1);
                                }
                                if (yanlıstas == true)
                                    break;
                                game_counter++;
                                break;
                            }
                            if (game_counter % 2 != 1 && (board[(cy - 1) / 2, (cx - 1) / 4] == "NK"))
                                break;
                            if (game_counter % 2 == 0 && (board[(cy - 1) / 2, (cx - 1) / 4] == "KM"))
                            {
                                while (çıkıcı == false)
                                {
                                    if (yanlıstas == true)
                                        break;
                                    King(1, "M");
                                }
                                if (yanlıstas == true)
                                    break;
                                game_counter++;
                                break;
                            }
                            if (game_counter % 2 != 0 && (board[(cy - 1) / 2, (cx - 1) / 4] == "KM"))
                                break;
                            if (game_counter % 2 == 1 && (board[(cy - 1) / 2, (cx - 1) / 4] == "KK"))
                            {
                                while (çıkıcı == false)
                                {
                                    if (yanlıstas == true)
                                        break;
                                    King(-1, "K");
                                }
                                if (yanlıstas == true)
                                    break;
                                game_counter++;
                                break;
                            }
                            if (game_counter % 2 == 1 && (board[(cy - 1) / 2, (cx - 1) / 4] == "KM"))
                                break;
                        }
                        if (gamecounter > 1)
                        {
                            if (hamleler[gamecounter] == hamleler[gamecounter - 1])
                            {
                                f2.Write(hamleler[gamecounter]);
                            }
                        }
                        else
                            f2.Write(hamleler[gamecounter]);

                        f2.Close();
                    }
                }
            }





        }

    }
}
