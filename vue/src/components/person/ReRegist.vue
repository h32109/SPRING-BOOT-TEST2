<template>
 <div class="back">
     <div align = "center"><h1>{{person.name}}님의 Mypage</h1></div>
      <div class="sub">
        <div class="pull-left rt size" >
           <fieldset style="margin-top: 1%; height: 25.5%;border: 2px solid black;">
              <legend><h3>아이디</h3></legend>
              <h2>{{person.userid}}</h2>
           </fieldset>
           <fieldset style="margin-top: 1%; height: 25.5%;border: 2px solid black;">
              <legend><h3>비밀번호</h3></legend>
              <h4>현재 비밀번호 : {{person.passwd}}</h4>
                <input v-model="changepass" type="text" name="pwd" size="20" placeholder="변경할 비밀번호 입력" style="float: none;width: 70%;">
           </fieldset>
           <fieldset style="margin-top: 1%; height: 25.5%;border: 2px solid black;">
              <legend><h3>생일</h3></legend>
              <h2>{{person.birthday}}</h2>
           </fieldset>
            <fieldset style="margin-top: 1%; height: 25.5%;border: 2px solid black;">
              <legend><h3>성별</h3></legend>
              <h2>{{person.gender}}</h2>
           </fieldset>
        </div>
        <div class="pull-right size" >
           <fieldset style="margin-top: 1%; height: 25.5%;border: 2px solid black;">
              <legend><h3>학번</h3></legend>
              <h2>{{person.hak}}</h2>
           </fieldset>
           <fieldset style="margin-top: 1%; height: 25.5%;border: 2px solid black;">
              <legend><h3>반번호</h3></legend>
              <h2>{{person.ban}}</h2>
           </fieldset>
            <fieldset style="margin-top: 1%; height: 25.5%;border: 2px solid black;">
              <legend><h3>점수</h3></legend>
                 <h4>현재 점수 : {{person.score}}</h4>
                <input v-model="changesco" type="text" name="pwd" size="20" placeholder="변경할 점수 입력" style="float: none;width: 70%;">
           </fieldset>
           <fieldset style="margin-top: 1%; height: 25.5%;border: 2px solid black;">
              <legend><h3>확인</h3></legend>
                 <a @click.prevent="reregist"><h3>변경완료</h3></a>
           </fieldset>
        </div>
      </div>
    </div>
</template>
<script>
 import axios from 'axios' 
export default{
     data(){
          return {
          person : this.$store.state.person,
          changepass : '',
          changesco : 0}
     },
     methods : {
      reregist(){
         let url = `${this.$store.state.context}reregist`
        let data = {
          userid : this.$store.state.person.userid,
          score : (this.changesco==0)?this.$store.state.person.score:this.changesco,
          passwd : this.changepass
        } 
         axios
        .patch(url, data)
        .then((res)=>{
          this.person = res.data.person
          this.$store.state.person = res.data.person
          this.$router.push({path : '/mypage'})
        })
        .catch(()=>{
          ('axios 실패')
         }) 
      }

     }
}
</script>
<style scoped>
  .back {width: 100%; margin: 0 auto;}
    .sub {width: 70%; height: 600px; margin: 0 auto; text-align: center;}
    .pull-left {float: left;}
    .pull-right {float: right;}
    .top {margin-top: 1%;}
    .rt {margin-right: 1%;}
    .size {width: 49.5%; height: 100%;}
</style>