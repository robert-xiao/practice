using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MessageAssistant.Model
{
    class CompositFieldFileModel : FieldBaseModel
    {
        public String FileName { get; set; }

        public List<FieldBaseModel> Children { get; private set; } = new List<FieldBaseModel>();

        public override int GetBitLength()
        {
            return Children.Sum(r => r.GetBitLength());
        }
    }
}
