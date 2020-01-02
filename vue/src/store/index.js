import Vue from 'vue'
import Vuex from 'vuex'
import common from '@/store/modules/common.js'
import person from '@/store/modules/person.js'
import board from '@/store/modules/board.js'
import student from '@/store/modules/student.js'
import admin from '@/store/modules/admin.js'

Vue.use(Vuex)

export const store = new Vuex.Store({
	modules: {
		common,
		person,
		board,
		student,
		admin
	},
	strict: true
  
})