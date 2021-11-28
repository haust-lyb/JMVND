<template>
  <div class="hello">

    <h1>当前网站的留言数：<strong>{{ visitTimes }}</strong>条</h1>
    <h4>springboot + Vue + docker-compose</h4>
    <textarea style="width: 80vw; height: 200px" v-model="message"/>
    <br>
    <button @click="submit">提交</button>

    <br>

    <h2>留言历史：</h2>
    <div style="display: flex;justify-content: center;">
      <table style="width: 80vh;">
        <tr>
          <td>id</td>
          <td>时间</td>
          <td>留言</td>
        </tr>
        <tr v-for="item in visitLogs" :key="item.id">
          <td>{{ item.id }}</td>
          <td>{{ item.datetime }}</td>
          <td>{{ item.msg }}</td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>

import axios from 'axios';

export default {
  name: 'VisitLog',
  mounted() {
    this.getVisitTimes();
    this.getVisitLogs();
  },
  data() {
    return {
      message: "hi 来都来了 说点什么吧？",
      visitTimes: 0,
      visitLogs: []
    }
  },
  methods: {
    getVisitTimes() {
      console.log("调用api请求后台获取访问次数");
      axios.get('/JMVND/getVisitTimes')
          .then(res => {
            console.log(res);
            this.visitTimes = res.data.data;
          });

    },
    getVisitLogs() {
      axios.get('/JMVND/getVisitLogs')
          .then(res => {
            console.log(res);
            this.visitLogs = res.data.data;
          });
    },
    submit() {
      // axios.post("/JMVND/addVisit", {
      //   message: this.message
      // }).then(res => {
      //   console.log(res);
      //   this.message="hi 来都来了 说点什么吧？";
      //   this.getVisitTimes();
      //   this.getVisitLogs();
      // });

      axios({
        method: 'post',
        url: '/JMVND/addVisit',
        data: {
          message: this.message
        },
        transformRequest: [
          function (data) {
            let ret = ''
            for (let it in data) {
              ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
            }
            ret = ret.substring(0, ret.lastIndexOf('&'));
            return ret
          }
        ],
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
        }
      }).then(res => {
        console.log(res);
        this.message="hi 来都来了 说点什么吧？";
        this.getVisitTimes();
        this.getVisitLogs();
      });

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
