package com.hitss.assistant.orchestrator;


import com.hitss.assistant.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class Orchestrator {

    @Autowired
    private OrchestratorService service;

    @GetMapping("/orchestrator")
    public String teste(){
        return "Hello World";
    }

    @PostMapping("/orchestrator")
    public ResponseEntity messageTelegram(@RequestBody Message msg) throws Exception {
        return new ResponseEntity(service.message(msg), HttpStatus.OK);
    }
}
