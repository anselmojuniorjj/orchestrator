package com.hitss.assistant.orchestrator;


import com.hitss.assistant.models.Message;
import com.ibm.watson.developer_cloud.assistant.v1.Assistant;
import com.ibm.watson.developer_cloud.assistant.v1.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.core.env.Environment;



@Service
public class OrchestratorService {

    Logger logger = LoggerFactory.getLogger(OrchestratorService.class);

    @Autowired
    private Environment env;

    public MessageResponse message(Message inputMessage) {

        logger.info("Menssagem :" + inputMessage.getText());
        logger.info("Conectando com Assistant");

        Assistant assistant1 = new Assistant(env.getProperty("VERSIONDATE"));
        assistant1.setUsernameAndPassword(env.getProperty("USERNAME"), env.getProperty("PASSWORD"));
        assistant1.setEndPoint(env.getProperty("ENDPOINT"));

        InputData input = new InputData.Builder().text(inputMessage.getText()).build();
        String workspaceId = env.getProperty("WORKSPACEID");
        MessageOptions.Builder optionsBuilder = new MessageOptions.Builder(workspaceId).input(input);

        if(inputMessage.getContext() != null){
            optionsBuilder.context(inputMessage.getContext());
        }

        MessageOptions messageOptions = optionsBuilder.build();
        MessageResponse messageResponse = assistant1.message(messageOptions).execute();

        logger.info("MessageResponse:");
        logger.info(messageResponse.toString());

        return messageResponse;
    }
}
