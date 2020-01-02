<template> 
    <div class="login-form">
    <form >
        <h2 class="text-center">학번검색</h2>       
        <div class="form-group">
            <input v-model="keyword" type="text" class="form-control" placeholder="Hak" required="required">
        </div>
        <div class="form-group">
            <div @click.prevent="find" class="btn btn-primary btn-block">Search</div>
        </div>
    </form>
    <p class="text-center"><a href="#">Create an Account</a></p>
	<div>검색결과 
	<table class="table"><tr>
	<th>No.</th><th>아이디</th><th>비번</th><th>이름</th><th>생년월일</th>
	<th>성별</th><th>학년</th><th>반</th><th>점수</th><th>역할</th>
	</tr>
	<tr v-for="(j, i) of list" :key="j.id">
	<td>{{i+1}}</td>
	<td>{{j.userid}}</td>
	<td>{{j.passwd}}</td>
	<td>{{j.name}}</td>
	<td>{{j.birthday}}</td>
	<td>{{j.gender}}</td>
	<td>{{j.hak}}</td>
	<td>{{j.ban}}</td>
	<td>{{j.score}}</td>
	<td>{{j.role}}</td>
	</tr>
	</table>
	</div>
</div>
</template>
<script>
/* import axios from 'axios' */
export default{
	data(){
		return {
/* 			context: 'http://localhost:8080/',
			list: [] */
		}
	},
	methods : {
		find(){

		}
	}
}
</script>
<style scoped>
.table{border : 1px solid black}
.table tr{border : 1px solid black}
.table tr th{border : 1px solid black}
.table tr td{border : 1px solid black}
.login-form {
    width: 340px;
    margin: 50px auto;
}
.login-form form {
    margin-bottom: 15px;
    background: #f7f7f7;
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    padding: 30px;
}
.login-form h2 {
    margin: 0 0 15px;
}
.form-control, .btn {
    min-height: 38px;
    border-radius: 2px;
}
.btn {        
    font-size: 15px;
    font-weight: bold;
}
</style>