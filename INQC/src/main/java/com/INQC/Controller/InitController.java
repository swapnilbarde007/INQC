package com.INQC.Controller;


import com.INQC.DTO.UCIP_LIB.Requests.UpdateOfferReq;

import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


import java.text.ParseException;


@Controller
@RequestMapping("/hotels")
public class InitController {

    @Autowired
    UpdateOfferReq updateOfferReq;

    @RequestMapping("/info")
    public void printXml() {
//        System.out.println("Start");
//        UpdateOfferReq uo=new UpdateOfferReq();
//        try{
//            uo.initMethodCall();
//        }catch (ParseException j){
//            System.out.println(j.getStackTrace());
//        } catch (JAXBException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println("End");
    }

}
