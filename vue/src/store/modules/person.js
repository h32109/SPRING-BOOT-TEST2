import axios from 'axios'
import Constant from '@/store/modules/mutation_types' 
const state = {
	person : {},
	isAuth : false
}
const getters = {
	getPerson : state => state.person,
	getIsAuth : state => state.isAuth
}
const actions = {
	async login(){
		let url = `${this.$store.state.context}/login`
		let data = {
			userid: this.userid,
			passwd: this.passwd
		}
		let headers = {
			'authorization': 'JWT fefege..',
			'Accept' : 'application/json',
			'Content-Type': 'application/json'
		}
		axios
		.post(url, data, headers)
		.then(res=>{
			if(res.data.result === "SUCCESS"){
				if(res.data.person.role==="STUDENT"){
				alert(`로그인성공 ${res.data.person.userid}`)
				this.$store.person.state.commit(Constant.PERSON, res.data.person)
				this.$store.commit(Constant.IS_AUTH, true)
				this.$store.commit(Constant.Header_Message, '학생화면')
				this.$store.commit(Constant.SIDEBAR, 'studentSidebar')
				this.$store.state.authCheck = true
				this.$router.push({path : '/mypage'})}else{
					alert(`관리자님 안녕하세요! `)
					this.$store.state.commit(Constant.PERSON, res.data.person)
					this.$store.commit(Constant.IS_AUTH, true)
					this.$store.commit(Constant.SIDEBAR, 'managerSidebar')
					this.$store.commit(Constant.Header_Message, '관리자화면')
					this.$router.push({path : '/admin'})
				}
			
			}else{
			alert('아이디와 비밀번호를 확인해 주세요.')
			this.$router.push({path : '/login'})
			}
		})
		.catch(()=>{
			alert('AXIOS 실패')
		})  
	},
		async join(){
			let url = `${this.$store.state.context}/join`
			let data = {
				userid : this.userid,
				passwd : this.passwd,
				name : this.name,
				birthday : this.birthday,
				role : this.role,
				gender : this.gender
			}
			let headers = {
					'authorization': 'JWT fefege..',
					'Accept' : 'application/json',
					'Content-Type': 'application/json'
			}
			axios
			.post(url, data, headers)
			.then(res=>{
				if(res.data.result==="SUCCESS"){
					if(res.data.person.role=="STUDENT"){
					alert(`${res.data.person.name}님 가입을 환영합니다.`)
					this.$store.commit(Constant.PERSON, res.data.person)
					this.$store.commit(Constant.IS_AUTH, true)
					this.$router.push({path : '/mypage'})}else{
						alert(`관리자님 안녕하세요! `)
						this.$store.commit(Constant.PERSON, res.data.person)
						this.$store.commit(Constant.IS_AUTH, true)
						this.$router.push({path : '/admin'})
					}
					}
				else
				{alert(`회원가입 실패!`)
				this.$router.push({path : '/join'})}
			})
			.catch(()=>{
				alert(`axios 실패!`)
			})
		}
}
const mutations = {
	LOGIN (state, person){
		state.person = person
	},
	LOGOUT (state){
		state.person = {}
	}
}

export default{
	name : 'person',
	namespaced : true,
	state,
	getters,
	actions,
	mutations
}