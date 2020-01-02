<template>
	<ul class="menu" >
		<li v-for="sidebar of sidebars" :key="sidebar.menu">
			<router-link :to='sidebar.link'>{{sidebar.menu}}</router-link>
		</li>
	</ul>
</template>
<script>
export default{
	data(){
		return {
			sidebars : [
				{menu : '글쓰기', link : '/boardadd'},
				{menu : '글수정', link : '/boardedit'},
				{menu : '글하나찾기', link : '/boardfindone'},
				{menu : '글여러개찾기', link : '/boardfindsome'},
				{menu : '글삭제', link : '/boardremoval'}
			]
		}
	},
	computed : {
		loginCheck : function(){
			return this.$store.state.authCheck
		}
	}	
}
</script>