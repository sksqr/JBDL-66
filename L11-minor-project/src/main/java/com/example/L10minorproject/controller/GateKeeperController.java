package com.example.L10minorproject.controller;


import com.example.L10minorproject.dto.UserDto;
import com.example.L10minorproject.dto.VisitDto;
import com.example.L10minorproject.dto.VisitorDTO;
import com.example.L10minorproject.service.GateKeeperService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gatekeeper")
public class GateKeeperController {

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
}
