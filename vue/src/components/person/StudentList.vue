<template>
<div>
	<template #pagination='pagination'>
	<div><h2>검색결과</h2>
	<table class="table">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>생년월일</th>
			<th>성별</th>
			<th>반</th>
			<th>학번</th>
			<th>점수</th>
			<th>직급</th>
		</tr>
		<tr v-for="j of pagination.result" :key="j.id">
			<td>{{j.userid}}</td>
			<td>{{j.passwd}}</td>
			<td>{{j.name}}</td>
			<td>{{j.birthday}}</td>
			<td>{{j.gender}}</td>
			<td>{{j.ban}}</td>
			<td>{{j.hak}}</td>
			<td>{{j.score}}</td>
			<td>{{j.role}}</td>
		</tr>
	</table>
	</div>
		</template>
	<pagination :list-array="pageArray"/>
</div>
</template>
<script>
import axios from 'axios'
import Pagination from '@/components/cmm/Pagination.vue'
export default{
	components : {
		Pagination
	},
	data(){
		return{
			pageArray : []
		}
	},
	created(){
		axios
		.get(`${this.$store.state.common.context}/students`)
		.then((res)=>{
			this.pageArray = res.data
/* 			for(let i=1; i< this.list.length/5;i++){
				this.listArray.push(i)
			} */
		})
	}
}
</script>
<style scoped>
.table{border : 1px solid black;}
.table tr th{border : 1px solid black;}
.table tr td{border : 1px solid black;}
</style>