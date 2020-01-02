<template>
	<ul  class="menu" >
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
				{menu : '학생목록', link : '/studentlist'},
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