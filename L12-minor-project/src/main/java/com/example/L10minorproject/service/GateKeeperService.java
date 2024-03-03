package com.example.L10minorproject.service;

import com.example.L10minorproject.dto.AddressDto;
import com.example.L10minorproject.dto.VisitDto;
import com.example.L10minorproject.dto.VisitorDTO;
import com.example.L10minorproject.entity.*;
import com.example.L10minorproject.enums.Role;
import com.example.L10minorproject.enums.UserStatus;
import com.example.L10minorproject.enums.VisitStatus;
import com.example.L10minorproject.exception.BadRequestException;
import com.example.L10minorproject.exception.NotFoundException;
import com.example.L10minorproject.repo.FlatRepo;
import com.example.L10minorproject.repo.VisitRepo;
import com.example.L10minorproject.repo.VisitorRepo;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GateKeeperService {

//    @Autowired
//    private EntityManager entityManager;
//
    @Autowired
    private VisitorRepo visitorRepo;

    @Autowired
    private FlatRepo flatRepo;

    @Autowired
    private VisitRepo visitRepo;

    public Long createVisitor(VisitorDTO visitorDTO){
        Visitor visitor = Visitor.builder()
                .email(visitorDTO.getEmail())
                .name(visitorDTO.getName())
                .phone(visitorDTO.getPhone())
                .idNumber(visitorDTO.getIdNumber())
                .build();
        if(visitorDTO.getAddress() != null){
            AddressDto addressDto = visitorDTO.getAddress();
            Address address = Address.builder()
                    .line1(addressDto.getLine1())
                    .line2(addressDto.getLine1())
                    .pincode(addressDto.getPincode())
                    .city(addressDto.getCity())
                    .country(addressDto.getCountry())
                    .build();
            visitor.setAddress(address);
        }
//        entityManager.persist(visitor);
        visitor = visitorRepo.save(visitor);
        return visitor.getId();
    }

    public VisitorDTO getByIdNumber(String idNumber){
        Visitor visitor = visitorRepo.findByIdNumber(idNumber);
        VisitorDTO visitorDTO = null;
        if(visitor != null){
            visitorDTO = VisitorDTO.builder()
                    .email(visitor.getEmail())
                    .name(visitor.getName())
                    .phone(visitor.getPhone())
                    .idNumber(visitor.getIdNumber())
                    .build();
        }
        else {
            throw new NotFoundException();
        }
        return visitorDTO;
    }


    public Long createVisit(VisitDto visitDto){
        Visitor visitor = visitorRepo.findByIdNumber(visitDto.getIdNumber());
        if(visitor == null){
            throw new BadRequestException("Visitor does not exist");
        }
        Flat flat = flatRepo.findByNumber(visitDto.getFlatNumber());
        if(flat == null){
            throw new BadRequestException("Flat does not exist");
        }
        Visit visit = Visit.builder()
                .imageUrl(visitDto.getUrlOfImage())
                .noOfPeople(visitDto.getNoOfPeople())
                .purpose(visitDto.getPurpose())
                .visitor(visitor)
                .flat(flat)
                .status(VisitStatus.WAITING)
                .build();
        visit = visitRepo.save(visit);
        return visit.getId();
    }

    public String markEntry(Long id){
        Visit visit = visitRepo.findById(id).get();
        if(visit == null){
            throw new BadRequestException("Visit does not exist");
        }
        if(visit.getStatus().equals(VisitStatus.APPROVED)){
            visit.setInTime(new Date());
            visitRepo.save(visit);
            return "Done";
        }
        else {
            throw new BadRequestException("Can not mark this");
        }
    }

    public String markExit(Long id){
        Visit visit = visitRepo.findById(id).get();
        if(visit == null){
            throw new BadRequestException("Visit does not exist");
        }
        if(visit.getStatus().equals(VisitStatus.APPROVED) && visit.getInTime() != null){
            visit.setOutTime(new Date());
            visit.setStatus(VisitStatus.COMPLETED);
            visitRepo.save(visit);
            return "Done";
        }
        else {
            throw new BadRequestException("Can not mark this");
        }
    }
}
