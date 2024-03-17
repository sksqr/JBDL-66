package com.example.L10minorproject.controller;


import com.example.L10minorproject.dto.UserDto;
import com.example.L10minorproject.dto.VisitDto;
import com.example.L10minorproject.dto.VisitorDTO;
import com.example.L10minorproject.service.GateKeeperService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/gatekeeper")
public class GateKeeperController {

    private static Logger LOGGER = LoggerFactory.getLogger(GateKeeperController.class);

    @Autowired
    private GateKeeperService gateKeeperService;

    @PostMapping("/createVisitor")
    ResponseEntity<Long> createUser(@RequestBody @Valid VisitorDTO visitorDTO){
        return ResponseEntity.ok(gateKeeperService.createVisitor(visitorDTO));
    }

    @GetMapping("/getVisitor")
    ResponseEntity<VisitorDTO> getVisitor(@RequestParam String idNumber){

        VisitorDTO visitorDTO = gateKeeperService.getByIdNumber(idNumber);
        if(visitorDTO == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(visitorDTO);
    }

    @PostMapping("/createVisit")
    ResponseEntity<Long> createVisit(@RequestBody @Valid VisitDto visitDto){
        return ResponseEntity.ok(gateKeeperService.createVisit(visitDto));
    }

    @PostMapping("/markEntry/{id}")
    ResponseEntity<String> markEntry(@PathVariable Long id){
        return ResponseEntity.ok(gateKeeperService.markEntry(id));
    }

    @PostMapping("/markExit/{id}")
    ResponseEntity<String> markExit(@PathVariable Long id){
        return ResponseEntity.ok(gateKeeperService.markExit(id));
    }

    @PostMapping("/image-upload")
    public ResponseEntity<String> uploadVisitorImage(@RequestParam("file") MultipartFile file){
        String fileName = UUID.randomUUID()+"_"+file.getOriginalFilename();
        String publicUrl = "/content/"+fileName;
        String uploadPath = "/tmp/images/"+fileName;
        try {
            file.transferTo(new File(uploadPath));
        } catch (IOException e) {
            LOGGER.error("Exception while uploading image: {}", e);
            return ResponseEntity.ok("Exception while uploading Image");
        }
        return ResponseEntity.ok(publicUrl);
    }
}
