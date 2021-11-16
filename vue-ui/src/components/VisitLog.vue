<template>
  <div class="hello">
    <h1>当前网站的访问次数：<strong>{{ visitTimes }}</strong>次</h1>
  </div>
</template>

<script>

import axios from 'axios';

export default {
  name: 'VisitLog',
  mounted() {
    this.getVisitTimes();
  },
  data() {
    return {
      visitTimes:0
    }
  },
  methods:{
    getVisitTimes(){
      console.log("调用api请求后台获取访问次数");
      axios.get('https://localhost:18080/JMVND/getVisitTimes')
          .then(response => console.log(response));
      this.visitTimes=1;
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
