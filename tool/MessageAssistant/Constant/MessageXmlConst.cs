using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MessageAssistant.Constant
{
    class MessageXmlConst
    {
        // 元素属性常量
        public const String MESSAGE = "message";
        public const String CMD = "cmd";
        public const String FIELD = "field";
        public const String FIELDS = "fields";
        public const String NAME = "name";
        public const String DESCRIPTION = "description";
        public const String ENDIAN = "endian";
        public const String LENGTH = "length";
        public const String TYPE = "type";
        public const String RATE = "rate";
        public const String OFFSET = "offset";
        public const String SKIP = "skip";
        public const String UNIT = "unit";
        public const String REPEAT = "repeat";
        public const String REPEAT_REF = "repeat-ref";
        public const String Default = "default";
        // 值常量
        // 大小端
        public const String ENDIAN_BIG = "big";
        public const String ENDIAN_LITTLE = "little";
        // 字段长度单位
        public const String UNIT_BIT = "bit";
        public const String UNIT_BYTE = "byte";
        // 是否跳过
        public const String SKIP_TRUE = "true";
        // 字段数据类型
        public const String TYPE_BYTE = "byte";
        public const String TYPE_SHORT = "short";
        public const String TYPE_USHORT = "ushort";
        public const String TYPE_INT = "int";
        public const String TYPE_UINT = "uint";
        public const String TYPE_ASTRING = "ascii";
        public const String TYPE_CP56TIME = "cp56";
    }
}
