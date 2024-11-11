package com.INQC.Service;

import com.INQC.DTO.UCIP_CORE.*;
import com.INQC.DTO.UCIP_LIB.Builder.MemberBuilder;
import com.INQC.DTO.UCIP_LIB.Builder.MethodCallBuilder;
import com.INQC.DTO.UCIP_LIB.Builder.StructBuilder;
import com.INQC.Entity.Commands.Method;
import com.INQC.Entity.Commands.MethodStruct;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.apache.commons.net.telnet.TelnetClient;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class AIRExecutor {

    private MethodCall methodCall;

    public void execute(Method method) throws JAXBException {

        this.methodCall=new MethodCall();
        this.methodCall = buildUCIP(method);
        String xmlString=formatUCIPXML();
        //System.out.println("Generated XML:\n" + xmlString);
        System.out.println("Executing UCIP on AIR");
        test(xmlString);

    }

    public String formatUCIPXML() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(MethodCall.class);
        Marshaller marshaller = context.createMarshaller();
        //marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "iso-8859-1");
        StringWriter writer = new StringWriter();
        marshaller.marshal(methodCall, writer);
        String xmlString = writer.toString();
        int xmlLength=xmlString.length();
        String header="POST /Air HTTP/1.1\n" +
                "Content-Length: "+xmlLength+"\n" +
                "Content-Type: text/xml\n" +
                "User-Agent: UGw Server/5.0/1.0\n" +
                "Host: 10.95.214.166:10011\n" +
                "Authorization: Basic ZWFpOmVhaUAxMjM=";
//        String header="POST /Air HTTP/1.1\n" +
//                "Content-Length: 4411"+"\n" +
//                "Content-Type: text/xml\n" +
//                "User-Agent: UGw Server/5.0/1.0\n" +
//                "Host: 10.95.214.166:10011\n" +
//                "Authorization: Basic ZWFpOmVhaUAxMjM=";
        header+="\n\n";
        xmlString=removeLastNewline(xmlString);
        return header+xmlString;
    }



        public  String removeLastNewline(String str) {
            if (str.endsWith("\n")) {
                return str.substring(0, str.length() - 1);
            } else {
                return str;
            }
        }

    public MethodCall buildUCIP(Method method) {

        MethodCallBuilder methodCallBuilder = new MethodCallBuilder();
        methodCallBuilder.setMethodName(method.getMethodName());
        Params params = new Params();
        Param param = new Param();
        Value value = new Value();

        Function<MethodStruct, Member> memberManager = (methodStruct) -> {
            Member newMember = new Member();
            newMember.setName(methodStruct.getMemberName());

            MemberValue newMemberValue = new MemberValue();

            if (methodStruct.getMemberDataType().equals("int")) {
                newMemberValue.setIntValue(Integer.parseInt(methodStruct.getMemberValue()));
            }

            if (methodStruct.getMemberDataType().equals("string")) {
                newMemberValue.setStringValue(methodStruct.getMemberValue());
            }


            if (methodStruct.getMemberDataType().equals("dateTime.iso8601")) {
                ZonedDateTime zonedDateTime = ZonedDateTime.parse(methodStruct.getMemberValue(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
                Instant instant = zonedDateTime.toInstant();
                Date date = Date.from(instant);
                newMemberValue.setDateTime(date);
            }


            if (methodStruct.getMemberDataType().equals("arrayStruct")) {
                Array array10 = new Array();
                Data data10 = new Data();
                MemberValue mvin10 = new MemberValue();
                Struct strin10 = new Struct();
                List<Member> innerMemberList = new ArrayList<>();

                methodStruct.getMethodStructList().stream()
                        .forEach((methodStruct1) -> {
                            Member memberIn10_1 = new Member();
                            memberIn10_1.setName(methodStruct1.getMemberName());
                            MemberValue memberIn10_1_val = new MemberValue();
                            memberIn10_1_val.setStringValue(methodStruct1.getMemberValue());
                            memberIn10_1.setValue(memberIn10_1_val);
                            innerMemberList.add(memberIn10_1);
                        });
                strin10.setMembers(innerMemberList);
                mvin10.setStruct(strin10);
                data10.setValue(mvin10);
                List<Data> dataList10 = new ArrayList<>();
                dataList10.add(data10);
                array10.setData(dataList10);
                newMemberValue.setArray(array10);
            }

            if (methodStruct.getMemberDataType().equals("array")){
                Array array101 = new Array();
                Data data101 = new Data();
                MemberValue mvin101 = new MemberValue();
                methodStruct.getMethodStructList().stream()
                        .forEach((methodStruct1) ->{
                            if (methodStruct1.getMemberDataType().equals("int")) {
                                mvin101.setIntValue(Integer.parseInt(methodStruct1.getMemberValue()));
                            }

                            if (methodStruct1.getMemberDataType().equals("string")) {
                                mvin101.setStringValue(methodStruct1.getMemberValue());
                            }


                            if (methodStruct1.getMemberDataType().equals("dateTime.iso8601")) {
                                ZonedDateTime zonedDateTime = ZonedDateTime.parse(methodStruct1.getMemberValue(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
                                Instant instant = zonedDateTime.toInstant();
                                Date date = Date.from(instant);
                                mvin101.setDateTime(date);
                            }
                        });
                List<Data> innerListOfData=new ArrayList<>();
                data101.setValue(mvin101);
                innerListOfData.add(data101);
                array101.setData(innerListOfData);
                newMemberValue.setArray(array101);
            }

            newMember.setValue(newMemberValue);
            return newMember;
        };

        StructBuilder structBuilder = new StructBuilder();
        MemberBuilder memberBuilder = new MemberBuilder();

        List<Member> memberList = method.getMethodStructList().stream()
                .map(memberManager)
                .toList();

        Struct struct = new Struct();
        struct.setMembers(memberList);
        value.setStruct(struct);
        param.setValue(value);
        params.setParam(param);
        methodCallBuilder.setParams(params);
        return methodCallBuilder.build();
    }

    public void test(String xmlInput){
        System.out.println("Test Project");
        String sshHost = "10.95.214.166";
        String sshUsername = "cakhpdgo";
        String sshPassword = "Dubai@1234";
        int telnetPort = 10011;         // Remote Telnet port on SSH server
        int localPort = 9999;           // Local port for SSH forwarding

        try {
            // Step 1: Connect to the SSH server
//            JSch jsch = new JSch();
//            Session session = jsch.getSession(sshUsername, sshHost, 22);
//            session.setPassword(sshPassword);
//            session.setConfig("StrictHostKeyChecking", "no");
//            session.connect();
//
//            // Step 2: Forward a local port to the remote Telnet port
//            session.setPortForwardingL(localPort, "localhost", telnetPort);

            // Step 3: Connect to the Telnet server through the forwarded port
            JSCHSession jschSession=JSCHSession.getJschSession();
            TelnetClient telnet = jschSession.getTelnetClient();
            //telnet.connect("localhost", localPort);




            InputStream telnetIn = telnet.getInputStream();
            OutputStream telnetOut = telnet.getOutputStream();



            PrintWriter writer = new PrintWriter(telnetOut, true, StandardCharsets.UTF_8);
            writer.println(xmlInput);
            writer.flush();


            // Step 4: Read response from Telnet server
//            byte[] buffer1 = new byte[1024];
//            int bytesRead1;
//            while ((bytesRead1 = telnetIn.read(buffer1)) != -1) {
//                System.out.println(new String(buffer1, 0, bytesRead1, StandardCharsets.UTF_8));
//            }

            // Step 4: Read response from Telnet server
            byte[] buffer = new byte[1024];
            int bytesRead;
            StringBuilder response = new StringBuilder();
            while ((bytesRead = telnetIn.read(buffer)) != -1) {
                //System.out.println(new String(buffer, 0, bytesRead, StandardCharsets.UTF_8));
                response.append(new String(buffer, 0, bytesRead, StandardCharsets.UTF_8));
            }
            String fullResponse = response.toString();


                //String responseString = new String(buffer, 0, bytesRead, StandardCharsets.UTF_8);
                int xmlStart = fullResponse.indexOf("<?xml");
                String xmlContent="";
                if (xmlStart != -1) {
                    // Extract XML content
                    xmlContent= fullResponse.substring(xmlStart).trim();
                    //System.out.println("Extracted XML:\n" + xmlContent);
                } else {
                    System.out.println("XML content not found.");
                }
                // Assuming you have a configured JAXBContext for MethodResponse
                JAXBContext jaxbContext = JAXBContext.newInstance(MethodResponse.class);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

                // Parse the String into a MethodResponse object
                MethodResponse methodResponse = (MethodResponse) unmarshaller.unmarshal(new StringReader(xmlContent));

                // Access data from the response object
                int responseCode=methodResponse.getParams().getParam().getValue().getStruct().getMembers().get(7).getValue().getI4Value();
                System.out.println("XML Response Code: "+responseCode);


            // Step 5: Close connections
            telnet.disconnect();
            jschSession.getSession().disconnect();
//            System.out.println("XML BELOW");
//            System.out.println(xmlInput);
//            System.out.println("XML ABOVE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
