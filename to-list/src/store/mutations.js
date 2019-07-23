
export default{

        addTodos1 (state,data) {  
         state.todos1.push(data);
         state.todos=state.todos1.map((e,index)=>{
            e.isEven=(index+1)%2===0;
            return e;
        });

        },
        showState(state,showState){
            if(showState==='all'){
                state.todos=state.todos1.map((e,index)=>{
                    e.isEven=(index+1)%2===0;
                    return e;
                });
            }else if(showState === 'active'){
                state.todos=state.todos1.filter(e=>e.state === false)
                state.todos=state.todos.map((e,index)=>{
                  
                    e.isEven=(index+1)%2===0;
                    return e;
                });
            }else if(showState==='complete'){
                state.todos=state.todos1.filter(e=>e.state === true)
                state.todos=state.todos.map((e,index,arr)=>{
                
                   e.isEven=(index+1)%2===0;
                   return e;
               });
            }
        },
        remove(state,todo){
            let index=state.todos1.indexOf(todo);
            state.todos1.splice(index, 1);
            let index1=state.todos.indexOf(todo);
            state.todos.splice(index1, 1);
        },


  
}
