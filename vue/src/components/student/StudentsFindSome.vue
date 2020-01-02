<template> 
	<div>
    <div class="login-form">
    <form >
        <h2 class="text-center">조건검색</h2> 
		<div class="form-group">
            <input v-model="searchWord" type="text" class="form-control" placeholder="Keyword" required="required">
        </div>
        <div class="form-group">
            <button @click.prevent="find" type="submit" class="btn btn-primary btn-block">전 송</button>
        </div>    
		<div><a @click.prevent="namesOfStudents">1. 학생의 이름</a></div>
		<div><a @click.prevent="streamToArray">2. 스트림을 배열로 전환</a></div>
		<div><a @click.prevent="streamToMap">3. 스트림을 맵으로 전환. 학생이름이  key</a></div>
		<div><a @click.prevent="theNumberOfStudents">4. 학생의 수</a></div>
		<div><a @click.prevent="totalScore">5. 학생들 총점</a></div>
		<div><a @click.prevent="topStudent">6. 1등 학생</a></div>
		<div><a @click.prevent="getStat">7. 전체 학생 성적 통계</a></div>
		<div><a @click.prevent="nameList">8. 전체 학생 이름</a></div>
		<div><a @click.prevent="partioningByGender">1.단순분할 (성별로 분할)</a></div>
		<div><a @click.prevent="partioningCountPerGender">2.단순분할 (성별 학생수)</a></div>
		<div><a @click.prevent="partioningTopPerGender">3.단순분할 (성별 1등)</a></div>
		<div><a @click.prevent="partioningRejectPerGender">4.다중분할 (성별 불합격자,  50점이하)</a></div>
		<div><a @click.prevent="groupingByBan">1. 단순 그룹화(반별로 그룹화)</a></div>
		<div><a @click.prevent="groupingByGrade">2. 단순그룹화(성적별로 그룹화)</a></div>
		<div><a @click.prevent="groupingByCountByLevel">3. 단순그룹화 + 통계(성적별 학생수))</a></div>
		<div><a @click.prevent="groupingByHakAndBan">4. 다중 그룹화 (학년별, 반별)</a></div>
		<div><a @click.prevent="groupingTopByHakAndBan">5. 다중 그룹화 +통계 (학년별, 반별  1등)</a></div>
		<div><a @click.prevent="groupingByStat">6. 다중그룹화 + 통계(학년별, 반별  성적그룹)</a></div>
		<div><a @click.prevent="groupingByHak">7. 학년별 그룹화</a></div>
<!--         <div class="form-group">
            <input v-model="keyword" type="text" class="form-control" placeholder="Keyword" required="required">
        </div>
        <div class="form-group">
            <div @click.prevent="find" class="btn btn-primary btn-block">Search</div>
        </div> -->
    </form>
	</div>
	<div>검색결과 
	<table class="table"><tr>
	<th>No.</th><th>아이디</th><th>비번</th><th>이름</th><th>생년월일</th>
	<th>성별</th><th>학년</th><th>반</th><th>점수</th><th>역할</th>
	</tr>
	<tr v-for="(j, i) of resultlist" :key="j.id">
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
 import axios from 'axios' 
export default{
data(){
return {
		list: [],
		searchWord : ''
	}
},
	methods : {
		groupByHakBest(){
			alert(`찾기`)
			axios.get(`${this.$store.state.context}students/groupByHakBest`)
			.then((res)=>{
				this.list = res.data
			})
		},
		namesOfStudents(){},
		streamToArray(){},
		streamToMap(){},
		theNumberOfStudents(){},
		totalScore(){},
		topStudent(){},
		getStat(){},
		nameList(){},
		partioningByGender(){
			if(this.searchWord=='')
			alert(`검색어를 입력해 주세요. 남/여`)
			else{
				if(this.searchWord=='남')
				{axios.get(`${this.$store.state.context}students/partioningByMale`)
					.then((res)=>{
						this.list = res.data
					})}else{
						axios.get(`${this.$store.state.context}students/partioningByFemale`)
					.then((res)=>{
						this.list = res.data
					})
					}
			}
			
		},
		groupingByHak(){
			if(this.searchWord=='')
			alert(`검색어를 입력해 주세요. 1학년 2학년 3학년`)
			else{
				if(this.searchWord=='남')
				{axios.get(`${this.$store.state.context}students/partioningByMale`)
					.then((res)=>{
						this.list = res.data
					})}else{
						axios.get(`${this.$store.state.context}students/partioningByFemale`)
					.then((res)=>{
						this.list = res.data
					})
					}
			}
		},
		partioningCountPerGender(){},
		partioningTopPerGender(){},
		partioningRejectPerGender(){},
		findByHak(){},
		groupByGrade(){},
		personCountByLevel(){},
		multiGrouping(){},
		multiGroupingMax(){},
		multiGroupingGrade(){}

	},

	computed : {
		resultlist(){
			return this.list
		}
	}
}
</script>
<style scoped>
.table{border : 1px solid black; margin : 0px auto}
.table tr{border : 1px solid black}
.table tr th{border : 1px solid black; text-align: center;}
.table tr td{border : 1px solid black; text-align: center;}
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
    margin: 0px auto;
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