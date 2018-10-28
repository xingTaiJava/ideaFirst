var vue = new Vue({
    el:"#app",
    data:{
        list:[],
        user:{}
    },
    methods:{
        findAll:function () {
            var thiss =this;
            axios.post("/user/findAll.do").then(function (json) {
                thiss.list=json.data;
            })
        },

        findOne:function (id) {
            var thiss=this;
            axios.get("/user/findOne.do?id="+id).then(function (value) {
                thiss.user=value.data;
            })
            $("#myModal").modal("show");
        },

        update:function () {
            var thiss=this;
            axios.post("/user/update.do",thiss.user).then(function () {
                thiss.findAll();
            })
            $("#myModal").modal("hide");
        }

    },

    created:function () {
        this.findAll();
    }
})