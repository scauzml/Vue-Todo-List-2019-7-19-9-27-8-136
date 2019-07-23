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

    public void deleteById(String id) {
        tolistResposity.deleteById(Integer.valueOf(id));
    }

}
