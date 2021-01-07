﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MessageAssistant.Model
{
    /// <summary>
    /// 消息中重复组合字段，子元素重复次数是固定值
    /// </summary>
    class CompositeFieldModel :FieldBaseModel
    {
        public int Repeat { get; set; }
        public List<FieldBaseModel> Children { get; private set; } = new List<FieldBaseModel>();

        public override int GetBitLength()
        {
            return Children.Sum(r => r.GetBitLength()) * Repeat;
        }
    }
}
