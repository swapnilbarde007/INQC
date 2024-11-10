package com.INQC.Controller;

import com.INQC.Entity.Commands.AIRCommands;
import com.INQC.Entity.Commands.Method;
import com.INQC.Service.AIRCommandsService;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/air")
public class AIRCommandsController {

    @Autowired
    AIRCommandsService airCommandsService;

    @GetMapping("/allAirCommands")
    public AIRCommands allAirCommands(){
        return airCommandsService.getAllCommandsFromJson();
    }

    @PostMapping("/saveMethodTemplate")
    @ResponseStatus(HttpStatus.OK)
    public boolean saveMethodAsTemplate(@RequestBody Method method){
        airCommandsService.saveMethodTemplate(method);
        return true;
    }


    @GetMapping("/getMethodTempByName/{templateName}")
    @ResponseStatus(HttpStatus.OK)
    public Method getAIRMethodTemplateByName(@PathVariable String templateName){
        return airCommandsService.getMethodTemplateByName(templateName);
    }

    @PostMapping("/executeMethodByTemplateName/{templateName}")
    @ResponseStatus(HttpStatus.OK)
    public void executeMethodByTemplateName(@PathVariable String templateName) throws JAXBException {
        airCommandsService.executeByMethodTemplateName(templateName);
    }

}
