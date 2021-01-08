﻿using System;
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
    class MessageModelServiceImpl : IMessageModelService
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
            String str = e.GetAttributeEx(MessageXmlConst.FIELD);
            Assert.NotNullOrEmpty(str, strEle + " 名称不可以为空");
            model.Name = str;

            model.Description = e.GetAttributeEx(MessageXmlConst.DESCRIPTION, "");
            str = e.GetAttributeEx(MessageXmlConst.ENDIAN);
            if (String.Compare(str, MessageXmlConst.ENDIAN_BIG) == 0
                || String.Compare(str, MessageXmlConst.ENDIAN_LITTLE) == 0)
            {
                model.Endian = str;
            }
                    
            model.Cmd = e.GetAttributeInt(MessageXmlConst.CMD);
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
            model.Length = e.GetAttributeInt(MessageXmlConst.LENGTH);
            model.Type = e.GetAttributeEx(MessageXmlConst.TYPE);
            model.Rate = e.GetAttributeDouble(MessageXmlConst.RATE, 1);
            model.Offset = e.GetAttributeDouble(MessageXmlConst.OFFSET, 0);
            model.Skip = e.GetAttributeEx(MessageXmlConst.SKIP, MessageXmlConst.SKIP_FALSE);
            model.Unit = e.GetAttributeEx(MessageXmlConst.UNIT, MessageXmlConst.UNIT_BYTE);
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
            String str = e.GetAttributeEx(MessageXmlConst.FIELD);
            Assert.NotNullOrEmpty(str, strEle + " 名称不可以为空");
            model.Name = str;

            model.Description = e.GetAttributeEx(MessageXmlConst.DESCRIPTION, "");
            str = e.GetAttributeEx(MessageXmlConst.ENDIAN);
            if (string.Compare(str, MessageXmlConst.ENDIAN_BIG) == 0
                || String.Compare(str, MessageXmlConst.ENDIAN_LITTLE) == 0)
            {
                model.Endian = str;
            }
            return;
        }
    }
}