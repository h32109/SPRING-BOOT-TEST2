import Vue from "vue"
import Router from "vue-router"
/* import Home from "@/components/Home.vue" */
import BoardAdd from "@/components/board/BoardAdd.vue"
import BoardEdit from "@/components/board/BoardEdit.vue"
import BoardFindOne from "@/components/board/BoardFindOne.vue"
import BoardFindSome from "@/components/board/BoardFindSome.vue"
import BoardRemoval from "@/components/board/BoardRemoval.vue"
import StudentAdd from "@/components/student/StudentAdd.vue"
import StudentEdit from "@/components/student/StudentEdit.vue"
import StudentFindOne from "@/components/student/StudentFindOne.vue"
import StudentFindSome from "@/components/student/StudentsFindSome.vue"
import StudentRemoval from "@/components/student/StudentRemoval.vue"
import Login from "@/components/person/Login.vue"
import Join from "@/components/person/Join.vue"
import MyPage from "@/components/person/MyPage.vue"
import ReRegist from "@/components/person/ReRegist.vue"
import Admin from "@/components/person/Admin.vue"
import StudentList from "@/components/person/StudentList.vue"

Vue.use(Router)

export default new Router({
	mode : "history",
	routes : [
/* 		{path : "/", name : "home", component : Home}, */
		{path : "/boardadd", name : "boardadd", component : BoardAdd},
		{path : "/boardedit", name : "boardedit", component : BoardEdit},
		{path : "/boardfindone", name : "boardfindone", component : BoardFindOne},
		{path : "/boardfindsome", name : "boardfindsome", component : BoardFindSome},
		{path : "/boardremoval", name : "boardremoval", component : BoardRemoval},
		{path : "/studentadd", name : "studentadd", component : StudentAdd},
		{path : "/studentedit", name : "studentedit", component : StudentEdit},
		{path : "/studentfindone", name : "studentfindone", component : StudentFindOne},
		{path : "/studentfindsome", name : "studentfindsome", component : StudentFindSome},
		{path : "/studentremoval", name : "studentremoval", component : StudentRemoval},
		{path : "/login", name : "login", component : Login},
		{path : "/join", name : "join", component : Join},
		{path : "/mypage", name : "mypage", component : MyPage},
		{path : "/reregist", name : "reregist", component : ReRegist},
		{path : "/admin", name : "admin", component : Admin},
		{path : "/studentlist", name : "studentlist", component : StudentList}
		

	]
})