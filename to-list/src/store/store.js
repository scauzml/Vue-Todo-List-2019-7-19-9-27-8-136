import Vue from 'vue'
import Vuex from 'vuex'
// import vuexAlong from 'vuex-along'
Vue.use(Vuex)

export const  store =new Vuex.Store({
  state:{
    //设置属性状态
    todos1:[],
    todos:[],
    showState:'all',
  },
  getters:{
    //获取属性状态
    getTodos1:state => state.todos1,
    getTodos:state => state.todos,

  },
  
    mutations: {
        addTodos1 (state,data) {  
         state.todos1.push(data);
         state.todos=state.todos1.map(e=>e);
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
        }

 
  },
//   actions:{
//     //应用mutations
//     //patch
//     setUser({commit}, user) {
//       commit("userStatus",user)
//     },
//     setImage({commit}, image) {
//       commit("updateImage",image)
//     },
//     setTypeUser({commit},typeUser){
//       commit("typeStatus",typeUser)
//     }
//   },
//   plugins: [vuexAlong]
})
