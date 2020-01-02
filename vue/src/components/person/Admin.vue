<template>
 <div class="back">
     <div align = "center"><h1>관리자{{admin.name}}님의 Mypage</h1></div>
      <div class="sub">
        <div class="pull-left rt size" >
           <fieldset style="margin-top: 1%; height: 25.5%;border: 2px solid black;">
              <legend><h3>아이디</h3></legend>
              <h2>{{admin.userid}}</h2>
           </fieldset>
           <fieldset style="margin-top: 1%; height: 25.5%;border: 2px solid black;">
              <legend><h3>비밀번호</h3></legend>
              <h2>{{admin.passwd}}</h2>
           </fieldset>
           <fieldset style="margin-top: 1%; height: 25.5%;border: 2px solid black;">
              <legend><h3>생일</h3></legend>
              <h2>{{admin.birthday}}</h2>
           </fieldset>
            <fieldset style="margin-top: 1%; height: 25.5%;border: 2px solid black;">
              <legend><h3>성별</h3></legend>
              <h2>{{admin.gender}}</h2>
           </fieldset>
        </div>
        <div class="pull-right size" >
           <fieldset style="margin-top: 1%; height: 25.5%;border: 2px solid black;">
              <legend><h3>학번</h3></legend>
              <h2>{{admin.hak}}</h2>
           </fieldset>
           <fieldset style="margin-top: 1%; height: 25.5%;border: 2px solid black;">
              <legend><h3>반번호</h3></legend>
              <h2>{{admin.ban}}</h2>
           </fieldset>
            <fieldset style="margin-top: 1%; height: 25.5%;border: 2px solid black;">
              <legend><h3>점수</h3></legend>
                 <h2>{{admin.score}}</h2>
           </fieldset>
           <fieldset style="margin-top: 1%; height: 25.5%;border: 2px solid black;">
              <legend><h3>정보변경</h3></legend>
                 <router-link to='/reregist'><h3>변경하기</h3></router-link>
           </fieldset>
        </div>
      </div>
    </div>
</template>
<script>
export default{
     data(){
          return {
             admin : this.$store.state.admin.admin
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