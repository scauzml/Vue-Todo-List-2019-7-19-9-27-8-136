
import axios from 'axios'

export default{
  
 
    //actions
    addItem({commit},item){
        
        axios.post("http://localhost:8082/to-list-entitys",item).then(
            res=>{
            let e=res.data;
              let item={};
              item.id=e.id;
              item.title=e.title;
  
              if(e.isChecked===0){
                  item.state=false;
              }else{
                  item.state=true;
              }
              if(e.isEven===0){
                  item.isEven=false;
              }else{
                  item.isEven=true;
  
              }
              commit("addTodos1",item);
            }
          ).catch(reason => {
                alert(reason)
              });
    },

    getAllItem({commit}){

    axios.get("http://localhost:8082/to-list-entitys").then(
     res=>{
         if(res.data.length>0){
            res.data.map(e=>{
                
                let item={};
                item.id=e.id;
                item.title=e.title;
    
                if(e.isChecked===0){
                    item.state=false;
                }else{
                    item.state=true;
                }
                if(e.isEven===0){
                    item.isEven=false;
                }else{
                    item.isEven=true;
    
                }
    
                commit("addTodos1",item);
    
    
            }) 
         }
        
     }
   ).catch(reason => {
                alert(reason)
    });
    },
    changeState({commit},item){
         item.state=!item.state;
       axios.put("http://localhost:8082/to-list-entitys/"+item.id,item).then(
           e=>{
              
           }
       ).catch(reason => {
        alert(reason)
      });  
    },
    removeItem({commit},item){
        axios.delete("http://localhost:8082/to-list-entitys/"+item.id).then(
            e=>{
               
                commit("remove",item);
            }
        ).catch(reason => {
         alert(reason)
       });  


    }

     
}
