<template>
<div id = "wrapper">
  <header id = 'header'>
   <slot name ="header" ></slot>
  </header>
  <aside id = 'sidebar' >
    <slot name ="sidebar"></slot>
  </aside>
  <section id='content'>
    <router-view></router-view>
    <slot name ="content" >
    </slot>
  </section>
  <footer>
    <slot name ="footer" :title = 'footertitle'></slot>
  </footer>
</div>
</template>
<script>
export default{
  data(){
    return {
      footertitle : 'jong.com'
    }
  }
}
</script>
<style scoped>
#wrapper {
     padding: 5px;
     width: 960px;
     margin: 20px auto;
}
#header {
     height: 100px;
     padding: 0 15px;
     display: grid;
     grid-template-columns: 85% 15%;

}
#content {
     width: 696px;
     float: left;
     padding: 5px 15px;
    min-height: 300px;
}
#sidebar {
     width: 200px;
     padding: 5px 15px;
     float: left;
}
footer {
     clear: both;
     padding: 0 15px;
}
/* 가로폭 980보다 작을 때 사용할 @media query */
@media screen and (max-width: 980px) {     
     #wrapper {
           width: 94%;
     }
     #content {
           clear: both;
           padding: 1% 4%;
           width: auto;
           float: none;
     }
     #sidebar {
           clear: both;
           padding: 1% 4%;
           width: auto;
           float: none;
     }
     header, footer {
           padding: 1% 4%;
     }
}
/* 공통 */
#content {
     background: #f8f8f8;
}
#sidebar {
     background: #f0efef;
}
header, #content, #middle, #sidebar {
     margin-bottom: 5px;
}
#wrapper, header, #content, #middle, #sidebar, footer {
     border: solid 1px #ccc;
}
</style>
