using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MessageAssistant.Model
{
    /// <summary>
    /// 消息中重复组合字段，子元素重复次数引用其它字段的值
    /// </summary>
    class CompositFieldRefModel : FieldBaseModel
    {
        public int RepeatValue { get; set; }
        /// <summary>
        /// 引用的字段支持层级嵌套，以.分隔
        /// </summary>
        public String RepeatRef { get; set; }
        public List<FieldBaseModel> Children { get; private set; } = new List<FieldBaseModel>();

        public override int GetBitLength()
        {
            return Children.Sum(r => r.GetBitLength()) * RepeatValue;
        }
    }
}
