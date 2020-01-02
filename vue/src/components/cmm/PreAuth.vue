<template>
<div>
	<ul class="menu">
		<li v-for="item of headnav" :key="item.menu">
			<router-link :to='item.link'>{{item.menu}}</router-link>
		</li>
	</ul>
</div>
</template>
<script>
export default {
	data(){
		return {
			headnav : [
				{menu : '로그인', link : '/login'},
				{menu : '회원가입', link : '/join'},
				{menu : '마이페이지', link : '/mypage'}
			]
		}
	}	
}
</script>