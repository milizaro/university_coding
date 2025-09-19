using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace ConsoleApp1
{
    public class Program
    {
        public class BigInt
        {
            string numStr1, numStr2;
            bool isFirstNumNegative = false;
            bool isSecondNumNegative = false;

            bool isFirstNumBigger = false;
            public BigInt(string inStr = "0 0")
            {
                inStr = inStr.Trim();
                string[] mas_str = inStr.Split(" ");

                numStr1 = mas_str[0];
                numStr2 = mas_str[mas_str.Length - 1];


                if (numStr1[0] == '-')
                {
                    isFirstNumNegative = true;
                    numStr1 = numStr1.Remove(0, 1);

                }

                if (numStr2[0] == '-')
                {
                    isSecondNumNegative = true;
                    numStr2 = numStr2.Remove(0, 1);
                }

                if (numStr1.Length > numStr2.Length)
                {
                    numStr2 = numStr2.PadLeft(numStr1.Length, '0');
                    isFirstNumBigger = true;
                }
                else if (numStr1.Length < numStr2.Length)
                {
                    numStr1 = numStr1.PadLeft(numStr2.Length, '0');
                }
                else if (string.Compare(numStr1, numStr2) > 0)
                {
                    isFirstNumBigger = true;
                }

            }

            private int getNumber(bool isNegative, char c)
            {
                int num = int.Parse(c.ToString());
                return isNegative ? -num  : num;
            }

            public string Sum()
            {
                string sum = "";
                int sumNum = 0;

                int i = numStr1.Length - 1;
                int j = numStr2.Length - 1;
                

                while (i >= 0)
                {
                    sumNum += getNumber(isFirstNumNegative, numStr1[i]) +
                              getNumber(isSecondNumNegative, numStr2[j]);
                    if (sumNum > 9)
                    {
                        sum += (sumNum % 10).ToString();
                        sumNum /= 10;
                    }
                    else
                    {
                        sum += sumNum.ToString();
                        sumNum = 0;
                    }
                    i--;
                    j--;
                }
                sum += sumNum == 0 ? "" : sumNum.ToString();
                return new string(sum.Reverse().ToArray());
            }

            public string Diff()
            {
                int diffNum = 0;

                int i = numStr1.Length - 1;
                int j = numStr2.Length - 1;
                string diff = "";

                if (isFirstNumBigger)
                {
                    while (i >= 0)
                    {
                        diffNum += getNumber(isFirstNumNegative, numStr1[i]) -
                              getNumber(isSecondNumNegative, numStr2[j]);
                        if (diffNum < 0)
                        {
                            diff += (diffNum + 10).ToString();
                            diffNum = -1;
                        }
                        else
                        {
                            diff += diffNum.ToString();
                            diffNum = 0;
                        }
                        i--;
                        j--;
                    }
                }
                else
                {
                    while (i >= 0)
                    {
                        diffNum += getNumber(isSecondNumNegative, numStr2[j]) -
                              getNumber(isFirstNumNegative, numStr1[i]);
                        if (diffNum < 0)
                        {
                            diff += (diffNum + 10).ToString();
                            diffNum = -1;
                        }
                        else
                        {
                            diff += diffNum.ToString();
                            diffNum = 0;
                        }
                        i--;
                        j--;
                    }
                }

                diff += diffNum == 0 ? "" : diffNum.ToString();



                diff += isFirstNumBigger ? "" : "-";
                return new string(diff.Reverse().ToArray());
            }
        }

        public static void Main(string[] args)
        {
            while (true)
            {
                string inString = Console.ReadLine();

                BigInt test = new BigInt(inString.Trim());

                Console.WriteLine("Sum: " + test.Sum());
                Console.WriteLine("Diff: " + test.Diff());
            }


        }

    }
}
