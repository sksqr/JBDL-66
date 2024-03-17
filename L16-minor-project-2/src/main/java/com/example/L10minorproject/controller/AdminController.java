package com.example.L10minorproject.controller;

import com.example.L10minorproject.dto.AddressDto;
import com.example.L10minorproject.dto.UserDto;
import com.example.L10minorproject.entity.User;
import com.example.L10minorproject.enums.UserStatus;
import com.example.L10minorproject.service.AdminService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private static Logger LOGGER = LoggerFactory.getLogger(AdminController.class);


    @Autowired
    private AdminService adminService;

    @PostMapping("/createUser")
    ResponseEntity<Long> createUser(@RequestBody UserDto userDto)  {
        return ResponseEntity.ok(adminService.createUser(userDto));
    }

    @PostMapping("/user-csv-upload")
    public ResponseEntity<List<String>> createUsersWithCSV(@RequestParam("file") MultipartFile file){
        LOGGER.info("File uploaded: {} ",file.getOriginalFilename());
        List<String> response = new ArrayList<>();
        try {
            BufferedReader fileReader= new BufferedReader(new InputStreamReader(file.getInputStream()));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for(CSVRecord csvRecord : csvRecords){
                UserDto userDTO = new UserDto();
                userDTO.setName(csvRecord.get("name"));
                userDTO.setEmail(csvRecord.get("email"));
                userDTO.setPhone(csvRecord.get("phone"));
                userDTO.setFlatNo(csvRecord.get("flatNo"));
                userDTO.setRole(csvRecord.get("role"));
                userDTO.setIdNumber(csvRecord.get("idNumber"));
                userDTO.setStatus(UserStatus.ACTIVE);
                AddressDto addressDTO = new AddressDto();
                addressDTO.setLine1(csvRecord.get("line1"));
                addressDTO.setLine2(csvRecord.get("line2"));
                addressDTO.setCity(csvRecord.get("city"));
                addressDTO.setPincode(csvRecord.get("pincode"));
                addressDTO.setCountry(csvRecord.get("country"));
                userDTO.setAddress(addressDTO);
                try{
                    Long id = adminService.createUser(userDTO);
                    response.add("Created User "+userDTO.getName()+"with id:"+id);
                }
                catch (Exception e){
                    response.add("Unable to created User "+userDTO.getName()+" msg:"+e.getMessage());
                }
            }
        }catch (IOException e){

        }
        return ResponseEntity.ok(response);
    }

}
