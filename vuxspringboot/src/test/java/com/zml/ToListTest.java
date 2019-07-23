package com.zml;

import com.zml.dao.ToListResposity;
import com.zml.entity.ToListEntity;
import com.zml.entity.vo.ToListEntityVo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ToListTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ToListResposity toListResposity;
    @BeforeEach
    public void beforeEach() {
     toListResposity.deleteAll();
    }

    @Test
    public void should_return_is_ok_when_post_todolistEntity_to_save() throws Exception{
        //given
        ToListEntity toListEntity = new ToListEntity();
        toListEntity.setIsChecked(0);
        toListEntity.setTitle("todolist1");
        JSONObject jsonObject = new JSONObject(toListEntity);
        //when
        //when
        String result=this.mockMvc.perform(post("/to-list-entitys").content(jsonObject.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();
        //then
        JSONObject jsonObject1=new JSONObject(result);
        Assertions.assertEquals("todolist1",jsonObject.getString("title"));

    }

    @Test
    public void should_return_all_tolist_when_get_to_all() throws Exception{
        //given
        ToListEntity toListEntity = new ToListEntity();
        toListEntity.setIsChecked(0);
        toListEntity.setTitle("todolist1");
        toListResposity.save(toListEntity);
        //when
        //when
        String result=this.mockMvc.perform(get("/to-list-entitys")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        //then
        JSONArray jsonArray = new JSONArray(result);

        Assertions.assertEquals("todolist1",jsonArray.getJSONObject(0).getString("title"));

    }

    @Test
    public void should_return_parkinglot_when_put_parkinglot() throws Exception{
        //given
        ToListEntity toListEntity = new ToListEntity();
        toListEntity.setIsChecked(0);
        toListEntity.setTitle("todolist1");
        ToListEntity toListEntity1=toListResposity.save(toListEntity);
        toListEntity1.setIsChecked(1);
        ToListEntityVo toListEntityVo=new ToListEntityVo();
        toListEntityVo.setId(toListEntity1.getId());
        if (toListEntity1.getIsChecked() == 0) {
            toListEntityVo.setState(false);
        }else {
            toListEntityVo.setState(true);
        }
        if (toListEntity1.getIsEven() == 0) {
            toListEntityVo.setEven(false);
        }else {
            toListEntityVo.setEven(true);
        }
        toListEntityVo.setTitle(toListEntity1.getTitle());
        JSONObject jsonObject = new JSONObject(toListEntityVo);
        //when
        //then
        String result=this.mockMvc.perform(put("/to-list-entitys/"+toListEntity1.getId()).content(jsonObject.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();




    }
}
