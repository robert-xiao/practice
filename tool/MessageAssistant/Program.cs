using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MessageAssistant
{
    static class Program
    {
        /// <summary>
        /// 应用程序的主入口点。
        /// </summary>
        [STAThread]
        static void Main()
        {
            TestBit();
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new MainFrm());
        }

        static void TestBit()
        {
            byte[] bts = new byte[] { 0x34, 0x51, 0x34 };
            byte[] bts2 = new byte[2];
            ClearBits(bts2);
            GetBits(bts, bts2, 4, 8);
            ClearBits(bts2);
            GetBits(bts, bts2, 6, 8);
            Console.WriteLine("good");
        }

        static void GetBits(byte[] src, byte[] dst, int srcStart, int len)
        {
            int dstStart = dst.Length * 8 - len;
            TransferBits(src, dst, srcStart, dstStart, len);
        }

        static void SetBits(byte[] src, byte[] dst, int dstStart, int len)
        {
            int srcStart = src.Length * 8 - len;
            TransferBits(src, dst, srcStart, dstStart, len);
        }

        static void ClearBits(byte[] dst)
        {
            for(int i = 0; i < dst.Length; ++i)
            {
                dst[i] = 0;
            }
        }

        static void TransferBits(byte[] src, byte[] dst, int srcStart, int dstStart, int len)
        {
            int rLoc = srcStart + len - 1;
            int wLoc = dstStart + len - 1;
            for (; rLoc >= srcStart;)
            {
                int rIndex = rLoc / 8;
                int rInnerLoc = rLoc % 8;
                int wIndex = wLoc / 8;
                int wInnerLoc = wLoc % 8;

                byte val = src[rIndex];
                val >>= (7 - rInnerLoc);
                val &= 0x1;
                val <<= (7 - wInnerLoc);
                dst[wIndex] |= val;

                --rLoc;
                --wLoc;
            }
        }
    }
}
