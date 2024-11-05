package com.INQC.Controller;

import com.INQC.Entity.Commands.AIRCommands;
import com.INQC.Entity.Commands.Method;
import com.INQC.Service.AIRCommandsService;
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
    public boolean saveMethodAsTemplate(Method method){
        return true;
    }
}
