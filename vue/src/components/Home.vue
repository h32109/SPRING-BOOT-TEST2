<template>
<div id='app'>
	<lay-out>
		<template  #header = 'header'>
			<div><h1>{{header.title}}</h1></div>
			<component :is="!loginCheck ? 'pre-auth' : 'post-auth'"></component>
		</template>
		<template #sidebar='sidebar'>
				<ul v-if="loginCheck" class="menu" >
					<li v-for="sidebar of sidebars" :key="sidebar.menu">
						<router-link :to='sidebar.link'>{{sidebar.menu}}</router-link>
					</li>
				</ul>
		</template>
		<template #content='content'>
			<h1>{{content.title}}</h1>
		</template>
		<template #footer='footer'>
			<h1>{{footer.title}}</h1>
		</template>
	</lay-out>
</div>
</template>
<script>
import LayOut from '@/components/cmm/LayOut.vue'
import PreAuth from '@/components/cmm/PreAuth.vue'
import PostAuth from '@/components/cmm/PostAuth.vue'
import STUDENT from '@/components/cmm/StudentSideBar.vue'
import TEACHER from '@/components/cmm/TeacherSideBar.vue'
import MANAGER from '@/components/cmm/ManagerSideBar.vue'
export default{
	components : {
		LayOut, PreAuth, PostAuth, STUDENT, TEACHER, MANAGER
	},
	computed : {
		loginCheck : function(){
			return this.$store.state.admin.isAuth
		},
		sidebars : function(){
			return this.$store.state.admin.sidebars
		}
	}
}
</script>
<style scoped>
ul.menu {
    position:relative;
    padding: 5px 5px 5px 5px;
    list-style: none;
    font-style: italic;
}
ul.menu a {
    text-decoration:none;
}
</style>