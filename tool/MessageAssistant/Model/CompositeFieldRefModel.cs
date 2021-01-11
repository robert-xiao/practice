using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MessageAssistant.Model
{
    class CompositeFieldRefModel : FieldBaseModel
    {
        public String RepeatRef { get; set; }
        public int Repeat { get; set; }
        public List<FieldBaseModel> Children { get; private set; } = new List<FieldBaseModel>();

        public override int GetBitLength()
        {
            return Children.Sum(r => r.GetBitLength());
        }
    }
}
