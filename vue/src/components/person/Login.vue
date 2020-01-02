<template>
    <div class="login-form">
    <form method="post" @submit.prevent="onSubmit(userid, passwd)">
        <h2 class="text-center">Log in</h2>       
        <div class="form-group">
            <input v-model="userid" type="text" class="form-control" placeholder="Username" required="required">
        </div>
        <div class="form-group">
            <input v-model="passwd" type="password" class="form-control" placeholder="Password" required="required">
        </div>
        <div class="form-group">
            <!-- <div @click.prevent="login" class="btn btn-primary btn-block">Log in</div> -->
            <button type="submit" class="btn btn-primary btn-block">Log in</button>
        </div>
        <div class="clearfix">
            <label class="pull-left checkbox-inline"><input type="checkbox"> Remember me</label>
            <a href="#" class="pull-right">Forgot Password?</a>
        </div>        
    </form>
    <p class="text-center"><a href="#">Create an Account</a></p>
</div>
</template>
<script>
/* import { mapMutations } from 'vuex' */
/* import Constant from '@/store/mustation_types.js' */
export default {
    data () {
       return {
           userid : '',
           passwd : '',
            ctx: this.$store.state.common.context,
            msg: ''
       }
    },
    methods : {
/*         ...mapMutations([
        'increment' // this.increment()를 this.$store.commit('increment')에 매핑합니다.
        ]),
        ...mapMutations({
        add: 'increment' // this.add()를 this.$store.commit('increment')에 매핑합니다.
        }) */
        onSubmit(userid, passwd){
            this.$store.dispatch('admin/login', {userid:userid, passwd:passwd, context: this.ctx})
            .then(()=>this.redirect())
            .catch(({message})=>this.msg = message)
            
        },
        /* ...mapActions('admin/login') */
        redirect(){
            this.$router.push(`/admin`)
        }

    },
    computed : {
    changeSidebars(){
        return this.$store.state.sidebars
    }  
  }
}
</script>
<style scoped>
.login-form {
    width: 340px;
    margin: 50px auto;
}
.login-form form {
    margin-bottom: 15px;
    background: #f7f7f7;
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    padding: 30px;
}
.login-form h2 {
    margin: 0 0 15px;
}
.form-control, .btn {
    min-height: 38px;
    border-radius: 2px;
}
.btn {        
    font-size: 15px;
    font-weight: bold;
}
</style>