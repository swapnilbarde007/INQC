package com.INQC.Service;

import com.INQC.Entity.Commands.AIRCommands;
import com.INQC.Entity.Commands.Method;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class AIRCommandsService {

    private final ObjectMapper objectMapper;


    public AIRCommandsService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public AIRCommands getAllCommandsFromJson() {
        InputStream inputStream=getClass().getResourceAsStream("/jsons/AIRCommands.json");
        AIRCommands airCommands=new AIRCommands();
        try{
            airCommands=objectMapper.readValue(inputStream, AIRCommands.class);

        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return airCommands;
    }

    public boolean saveMethodTemplate(Method method){
        return true;
    }

}
