package com.zml.controller;

import com.zml.entity.ToListEntity;
import com.zml.entity.vo.ToListEntityVo;
import com.zml.service.ToListServe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("to-list-entitys")
@RestController
public class TolistController {


    @Autowired
    ToListServe toListServe;
    @PostMapping()
    public ResponseEntity addParkingLot(@RequestBody ToListEntityVo toListEntityVot) {

        ToListEntity toListEntity1=toListServe.save(toListEntityVot);
        return toListEntity1!=null? ResponseEntity.status(HttpStatus.CREATED).body(toListEntity1):ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping
    public ResponseEntity getAll() {
        List<ToListEntity> toListEntities = toListServe.findAll();
        return ResponseEntity.ok().body(toListEntities);
    }

    @PutMapping("/{id}")
    public ResponseEntity changeState(@PathVariable("id")String id,@RequestBody ToListEntityVo toListEntityVot) {
       toListServe.changeState(id,toListEntityVot);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteParkingLot(@PathVariable("id")String id) {
        toListServe.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
