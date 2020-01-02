<template>
<div class="btn-cover" >
	<slot name ="pagination" :result = 'paginatedData'></slot>
	<button :disabled="pageNum === 0" @click="prevPage" class="page-btn">
	이전
	</button>
	
	<span class="page-count">{{ pageNum+1 }}/{{pageCount}}</span>

	<button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn">
	다음
	</button>
</div>
</template>
<script>
export default{
	data(){
		return{
			pageNum : 0,
		}
	},
	props: {
		listArray: {
			type: Array,
			required: true
		},
		blockSize : {
			type: Number,
			required: true,
			default: 5
		}
	},
	methods : {
		prevPage(){
			this.pageNum -= 1
		},
		nextPage(){
			this.pageNum += 1
		}
	},
	computed : {
		pageCount(){
			let listLeng = this.listArray.length,
			listSize = this.blockSize,
			page = Math.floor(listLeng / listSize)
			if(listLeng % listSize > 0) page += 1
			return page
		},
		paginatedData(){
			const start = this.pageNum * this.pageSize,
						end = start + this.pageSize
			return this.listArray.slice(start, end)
		}
	}
}
</script>
<style scoped>
.btn-cover {
  margin-top: 1.5rem;
  text-align: center;
}
.btn-cover .page-btn {
  width: 5rem;
  height: 2rem;
  letter-spacing: 0.5px;
}
.btn-cover .page-count {
  padding: 0 1rem;
  border: 1px solid black;
  margin-right: 10px;
  margin-left: 10px;
}
</style>