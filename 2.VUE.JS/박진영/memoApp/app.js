var app = new Vue({
    el: "#app",
    data: {
        mode: "list",
        //인풋 형태의 태그에는 보통 v-model 사용, 변수명 통일
        memo: {
            id: null,
            content: null,
            regDate: null
        },
        memos: [{
                id: 1,
                content: "메모",
                regDate: new Date()
            },
            {
                id: 2,
                content: "메모",
                regDate: new Date()
            },
            {
                id: 3,
                content: "메모",
                regDate: new Date()
            },
        ]
    },
    methods: {
        write: function() {
            this.mode = "write";
        },
        cancel: function() {
            this.mode = "list";
        },
        save: function() {
            //새로운 메모 추가할 때마다 배열의 길이 1씩 증가
            var id = this.memos.length + 1;
            this.memos.push({
                id: id,
                content: this.memo.content,
                regDate: new Date()
            })
            this.mode = "list";
        }
    }
});