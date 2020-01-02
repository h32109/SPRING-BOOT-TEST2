<template>
<div>
	<ul class="menu">
		<li >
			<a @click.prevent='logout'><h5>로그아웃</h5></a>
		</li>
		<li >
			<a @click.prevent='withdrawal'><h5>회원탈퇴</h5></a>
		</li>
	</ul>
</div>
</template>
<script>
import axios from 'axios'
export default {
			methods : {
		logout(){
			this.$store.state.person = {}
			this.$store.state.authCheck = false
			alert('로그아웃!')
			this.$router.push({path : '/login'})
		},
		withdrawal(){
			alert('회원탈퇴!')
			axios
			.delete(`${this.$store.state.context}withdrawal/${this.$store.state.person.userid}`)
			.then(res => {
				alert(res.data)
				this.$store.state.person = {}
				this.$store.state.authCheck = false
				this.$router.push({path : '/'})
			})
		}
	}	
}
</script>