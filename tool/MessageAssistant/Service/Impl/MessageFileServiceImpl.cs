using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MessageAssistant.Model;
using System.Xml;
using MessageAssistant.Constant;
using MessageAssistant.Util;

namespace MessageAssistant.Service.Impl
{
    class MessageFileServiceImpl : IMessageFileService
    {
        public MessageModel Read(string file)
        {
            throw new NotImplementedException();
        }

        public void Write(MessageModel model, string file)
        {
            throw new NotImplementedException();
        }

        private MessageModel Read(XmlElement e)
        {
            MessageModel model = new MessageModel();
            String strEle = e.OuterXml;
            String str = e.GetAttribute(MessageXmlConst.FIELD);
            Assert.NotNullOrEmpty(str, strEle + " 名称不可以为空");
            model.Name = str;

            model.Description = e.GetAttribute(MessageXmlConst.DESCRIPTION, "");
            str = e.GetAttribute(MessageXmlConst.ENDIAN);
            if (String.Compare(str, MessageXmlConst.ENDIAN_BIG) == 0
                || String.Compare(str, MessageXmlConst.ENDIAN_LITTLE) == 0)
            {
                model.Endian = str;
            }

            str = e.GetAttribute(MessageXmlConst.CMD);
            Assert.NotNullOrEmpty(str, strEle + " 名称不可以为空");
            int cmd = 0;
            if(!int.TryParse(str, out cmd))
            {
                throw new ArgumentException("命令码必须是整数");
            }
            model.Cmd = cmd;
            var children = e.ChildNodes;
            for(int i = 0; i < children.Count; ++i)
            {
                var child = children[i] as XmlElement;
                if(child != null)
                {
                    model.Fields.Add(ReadFieldBase(child));
                }
            }
            return model;
        }

        private FieldBaseModel ReadFieldBase(XmlElement e)
        {
            switch (e.Name)
            {
                case MessageXmlConst.FIELD:
                    return ReadField(e);
                case MessageXmlConst.COMPOSITE_FIELD:
                    return ReadCompositeField(e);
            }
            return null;
        }

        private FieldBaseModel ReadField(XmlElement e)
        {
            FieldModel model = new FieldModel();
            ReadFieldBase(e, model);

            return model;
        }

        private FieldBaseModel ReadCompositeField(XmlElement e)
        {
            CompositeFieldModel model = new CompositeFieldModel();
            ReadFieldBase(e, model);

            return model;
        }

        private void ReadFieldBase(XmlElement e, FieldBaseModel model)
        {
            String strEle = e.OuterXml;
            String str = e.GetAttribute(MessageXmlConst.FIELD);
            Assert.NotNullOrEmpty(str, strEle + " 名称不可以为空");
            model.Name = str;

            model.Description = e.GetAttribute(MessageXmlConst.DESCRIPTION, "");
            str = e.GetAttribute(MessageXmlConst.ENDIAN);
            if (String.Compare(str, MessageXmlConst.ENDIAN_BIG) == 0
                || String.Compare(str, MessageXmlConst.ENDIAN_LITTLE) == 0)
            {
                model.Endian = str;
            }
            return;
        }
    }
}
