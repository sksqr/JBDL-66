package com.example.L13UnitTestIntegrationTestdemo.controller;


import com.example.L13UnitTestIntegrationTestdemo.entity.Branch;
import com.example.L13UnitTestIntegrationTestdemo.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;
    @GetMapping("/{id}")
    public ResponseEntity<Branch> getBranchById(@PathVariable Long id){
        Branch branch = branchService.getById(id);
        return ResponseEntity.ok(branch);
    }


    @PostMapping
    public ResponseEntity<Long> createBranch(@RequestBody Branch branch){
        Long id = branchService.createBranch(branch);
        return ResponseEntity.ok(id);
    }

}
