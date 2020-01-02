<template>
	<ul class="menu" >
		<li v-for="sidebar of sidebars" :key="sidebar.menu">
			<router-link :to='sidebar.link'>{{sidebar.menu}}</router-link>
		</li>
	</ul>
</template>
<script>
export default{
	name : 'teacher',
	data(){
		return {
			sidebars : [
			{menu : '학생목록', link : '/studentlist'},
			{menu : '학생수정', link : '/studentedit'},
			{menu : '학생한명검색', link : '/studentfindone'},
			{menu : '학생여러명검색', link : '/studentfindsome'},
			{menu : '학생삭제', link : '/studentremoval'} 
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