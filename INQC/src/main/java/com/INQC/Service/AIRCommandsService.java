package com.INQC.Service;

import com.INQC.Entity.Commands.AIRCommands;
import com.INQC.Entity.Commands.Method;
import com.INQC.Entity.Commands.MethodStruct;
import com.INQC.Repository.AIRCommandRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AIRCommandsService {

    private final ObjectMapper objectMapper;

    @Autowired
    AIRCommandRepo airCommandRepo;

    @Autowired
    AIRExecutor airExecutor;

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

        //Check AirCommandTemplateListExists

        boolean exists=airCommandRepo.existsBy();
        if(!exists){
            AIRCommands objAirCommands=new AIRCommands();
            List<Method> methodList=new ArrayList<>();
            methodList.add(method);
            objAirCommands.setMethodList(methodList);
            airCommandRepo.save(objAirCommands);
        }else{
            List<AIRCommands> objAirCommands=airCommandRepo.findAll();
            objAirCommands.get(0).getMethodList().add(method);
            airCommandRepo.save(objAirCommands.get(0));
        }
        return true;
    }

    public Method getMethodTemplateByName(String templateName){
        List<AIRCommands> foundAirCommands=airCommandRepo.findAll();
        if(!(foundAirCommands.isEmpty())){
            List<Method> methodList=foundAirCommands.get(0).getMethodList();
            if(!(methodList.isEmpty())){
                List<Method> foundMethod=methodList
                        .stream()
                        .filter(
                                (method)-> method.getTemplateName().contains(templateName))
                        .toList();
                return foundMethod.get(0);
            }
        }
        return null;
    }


    public void executeByMethodTemplateName(String templateName) throws JAXBException {
        Method method=getMethodTemplateByName(templateName);
        airExecutor.execute(method);
    }
}
