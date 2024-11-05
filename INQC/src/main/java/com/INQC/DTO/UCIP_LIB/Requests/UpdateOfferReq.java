package com.INQC.DTO.UCIP_LIB.Requests;


import com.INQC.DTO.UCIP_CORE.*;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.stereotype.Service;



import java.io.StringWriter;
import java.text.ParseException;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class UpdateOfferReq implements UCIP{


    private MethodCall methodCall;

    HashMap<String,String> defaultValuesMap=new HashMap<>();



    public void initMethodCall() throws ParseException, JAXBException {
        methodCall=new MethodCall();

        methodCall.setMethodName("UpdateOffer");

        Params params=new Params();

        Param param =new Param();

        Value value=new Value();

        Struct struct=new Struct();

        Member member1=new Member();
        member1.setName("originNodeType");
        MemberValue mv1=new MemberValue();
        mv1.setStringValue("EXT");
        member1.setValue(mv1);

        Member member2=new Member();
        member2.setName("originHostName");
        MemberValue mv2=new MemberValue();
        mv2.setStringValue("meydvvmnmt02menalabcorplocal");
        member2.setValue(mv2);


        Member member3=new Member();
        member3.setName("originTransactionID");
        MemberValue mv3=new MemberValue();
        mv3.setStringValue("2020092316562490");
        member3.setValue(mv3);

        Member member4=new Member();
        member4.setName("originTimeStamp");
        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        Instant instant = zonedDateTime.toInstant();
        Date date = Date.from(instant);

        MemberValue mv4=new MemberValue();
        mv4.setDateTime(date);
        member4.setValue(mv4);

        Member member5=new Member();
        member5.setName("subscriberNumberNAI");
        MemberValue mv5=new MemberValue();
        mv5.setIntValue(1);
        member5.setValue(mv5);

        Member member6=new Member();
        member6.setName("negotiatedCapabilities");
        MemberValue mv6=new MemberValue();
        Array mbr6mr=new Array();
        Data data=new Data();
        MemberValue mv1Int=new MemberValue();
        mv1Int.setIntValue(268763332);
        data.setValue(mv1Int);
        List<Data> datalist=new ArrayList<>();
        datalist.add(data);
        mbr6mr.setData(datalist);
        mv6.setArray(mbr6mr);
        member6.setValue(mv6);

        Member member7=new Member();
        member7.setName("subscriberNumber");
        MemberValue mv7=new MemberValue();
        mv7.setStringValue("971553205721");
        member7.setValue(mv7);

        Member member8=new Member();
        member8.setName("offerID");
        MemberValue mv8=new MemberValue();
        mv8.setIntValue(100);
        member8.setValue(mv8);

        Member member9=new Member();
        member9.setName("offerType");
        MemberValue mv9=new MemberValue();
        mv9.setIntValue(2);
        member9.setValue(mv9);

        Member member10=new Member();
        member10.setName("attributeUpdateInformationList");
        MemberValue mv10=new MemberValue();
        Array array10=new Array();
        Data data10=new Data();
        MemberValue mvin10=new MemberValue();
        Struct strin10=new Struct();

        Member memberIn10_1=new Member();
        memberIn10_1.setName("attributeName");
        MemberValue memberIn10_1_val=new MemberValue();
        memberIn10_1_val.setStringValue("CommitmentBundle");
        memberIn10_1.setValue(memberIn10_1_val);

        Member memberIn10_2=new Member();
        memberIn10_2.setName("attributeUpdateAction");
        MemberValue memberIn10_2_val=new MemberValue();
        memberIn10_2_val.setStringValue("SET");
        memberIn10_2.setValue(memberIn10_2_val);

        Member memberIn10_3=new Member();
        memberIn10_3.setName("attributeValueString");
        MemberValue memberIn10_3_val=new MemberValue();
        memberIn10_3_val.setStringValue("AllStarV1D1Annual");
        memberIn10_3.setValue(memberIn10_3_val);

        List<Member> innerMemberList=new ArrayList<>();
        innerMemberList.add(memberIn10_1);
        innerMemberList.add(memberIn10_2);
        innerMemberList.add(memberIn10_3);

        strin10.setMembers(innerMemberList);
        mvin10.setStruct(strin10);
        data10.setValue(mvin10);

        List<Data> dataList10=new ArrayList<>();
        dataList10.add(data10);
        array10.setData(dataList10);
        mv10.setArray(array10);

        member10.setValue(mv10);

        List<Member> memberList=new ArrayList<>();
        memberList.add(member1);
        memberList.add(member2);
        memberList.add(member3);
        memberList.add(member4);
        memberList.add(member5);
        memberList.add(member6);
        memberList.add(member7);
        memberList.add(member8);
        memberList.add(member9);
        memberList.add(member10);
        struct.setMembers(memberList);

        value.setStruct(struct);

        param.setValue(value);

        params.setParam(param);

        methodCall.setParams(params);

        JAXBContext context = JAXBContext.newInstance(MethodCall.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "iso-8859-1");
        StringWriter writer = new StringWriter();
        marshaller.marshal(methodCall, writer);
        String xmlString = writer.toString();

        System.out.println("Generated XML:\n" + xmlString);
    }


    @Override
    public UCIP formXml(HashMap<String, String> inputMap) {
        inputMap.get("originNodeType");
        return null;
    }
}
