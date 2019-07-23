package com.zml;

import com.zml.dao.ToListResposity;
import com.zml.entity.ToListEntity;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
        toListEntity.setId(1);
        toListEntity.setIsChecked(0);
        toListEntity.setTitle("todolist1");
        JSONObject jsonObject = new JSONObject(toListEntity);
        //when
        //when
        String result=this.mockMvc.perform(post("/tolistentitys").content(jsonObject.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();
        //then
        JSONObject jsonObject1=new JSONObject(result);
        Assertions.assertEquals("todolist1",jsonObject.getString("title"));
        //then


    }

    @Test
    public void should_return_all_tolist_when_get_to_all() throws Exception{
        //given
        ToListEntity toListEntity = new ToListEntity();
        toListEntity.setId(1);
        toListEntity.setIsChecked(0);
        toListEntity.setTitle("todolist1");
        toListResposity.save(toListEntity);

        //when
        //when
        String result=this.mockMvc.perform(get("/tolistentitys")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        //then
        JSONArray jsonArray = new JSONArray(result);

        Assertions.assertEquals("todolist1",jsonArray.getJSONObject(0).getString("title"));
        //then


    }
}
