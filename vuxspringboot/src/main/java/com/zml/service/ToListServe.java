package com.zml.service;

import com.zml.dao.ToListResposity;
import com.zml.entity.ToListEntity;
import com.zml.entity.vo.ToListEntityVo;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToListServe {

    @Autowired
    ToListResposity tolistResposity;

    public ToListEntity save(ToListEntityVo toListEntityVo) {
        Optional<ToListEntityVo> optional = Optional.of(toListEntityVo);
        ToListEntity toListEntity = null;
        ToListEntity toListEntity1=null;
        if (optional.isPresent()) {

            toListEntity = new ToListEntity();
            toListEntity.setId(toListEntityVo.getId());
            toListEntity.setTitle(
                    toListEntityVo.getTitle()
            );
            if (toListEntityVo.isState() == true) {
                toListEntity.setIsChecked(1);
            }else {
                toListEntity.setIsChecked(0);
            }
            toListEntity1 =tolistResposity.save(toListEntity);

        }
        return toListEntity1;

    }

    public List<ToListEntity> findAll() {
        return tolistResposity.findAll();
    }

    public void changeState(String id, ToListEntityVo toListEntityVot) {
        Optional<ToListEntity> byId = tolistResposity.findById(Integer.valueOf(id));
        if (byId.isPresent()) {
            ToListEntity toListEntity = byId.get();
            if (toListEntityVot.isState()) {
                toListEntity.setIsChecked(1);
            }else {
                toListEntity.setIsChecked(0);
            }
            tolistResposity.save(toListEntity);

        }
    }

//    public List<ParkingLot> getParkingLotByPage(String page, String pageSize) {
//        Page<ParkingLot> parkingLots=parkingLotResposity.findAll
//                (PageRequest.of(Integer.valueOf(page)-1,Integer.valueOf(pageSize)));
//        return parkingLots.getContent();
//
//    }
//
//
//    public boolean save(ParkingLot parkingLot) {
//        ParkingLot parkingLot1=parkingLotResposity.save(parkingLot);
//        return parkingLot1.getId()!=null?true:false;
//    }
//
//    public void deleteById(String id) {
//        parkingLotResposity.deleteById(id);
//
//    }
//
//    public ParkingLot findParkingLotByID(String id) {
//        return parkingLotResposity.findById(id).get();
//
//    }
//
//    public ParkingLot changeParkingLot(ParkingLot parkingLot,String id) {
//        ParkingLot parkingLot1=parkingLotResposity.findById(id).get();
//        Optional<ParkingLot> optionalParkingLot = Optional.of(parkingLot1);
//        if (optionalParkingLot.isPresent()) {
//            parkingLot1.setName(parkingLot.getPosition());
//            parkingLot1.setCapicity(parkingLot.getCapicity());
//            parkingLot1.setPosition(parkingLot.getPosition());
//        }
//        return   parkingLotResposity.saveAndFlush(parkingLot1);
//    }
}
