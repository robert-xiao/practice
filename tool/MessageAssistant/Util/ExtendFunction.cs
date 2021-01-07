using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;

namespace MessageAssistant.Util
{
    public static class ExtendFunction
    {
        public static String GetAttribute(this XmlElement e, String name, String val)
        {
            String str = e.GetAttribute(name);
            if (String.IsNullOrEmpty(str))
            {
                return val;
            }
            return str.Trim();
        }
    }
}
