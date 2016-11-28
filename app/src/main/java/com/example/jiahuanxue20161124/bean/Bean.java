package com.example.jiahuanxue20161124.bean;

import java.util.List;

/**
 * Created by 贾焕雪 on 2016-11-24.
 */
public class Bean {


    /**
     * error_code : 0
     * reason : Success
     * result : {"data":[{"content":"英国两个小伙子花了一下午的时间在西瓜身上勒上橡皮筋，当被勒到第500条时，西瓜终于爆了\u2026\u2026　　最后被他们用慢镜拍了下来。　　在场目睹了整个事件的刘先生称：\u201c我活了48年，他们是我见过最无聊的两个人。\u201d","hashId":"1c8896a19b51e083a883e9505d8b7690","unixtime":1479944030,"updatetime":"2016-11-24 07:33:50"},{"content":"一个人来到婚姻问题咨询所。　　他说：\u201c您帮帮我吧，我的太太简直令人无法忍受，她总是把她喜爱的小猪放在卧室里，气味让人难以忍受。\u201d　　律师说：\u201c那你为什么不打开窗户换换气。\u201d　　这个人惊讶的说：\u201c那我养的鸽子岂不要全部飞掉？\u201d","hashId":"9cfb7480619581e66bfe4e67b3a17610","unixtime":1479941633,"updatetime":"2016-11-24 06:53:53"},{"content":"丈夫晚上喝高了，睡觉把自个儿腿挠破了，早上起来非说是妻子挠的。　　妻子当然不乐意了，说是他自个儿挠的，丈夫偏偏不承认。　　最后给妻子急了，上去在他另一条腿上挠了个五线谱，咆哮：\u201c就是我挠的你能怎么地吧！\u201d　　丈夫瞬间绵了：\u201c不怎么地，就是觉得挠得挺好看的。\u201d","hashId":"953027ae203ea1c30b90bb75b3f26f92","unixtime":1479941633,"updatetime":"2016-11-24 06:53:53"},{"content":"话说昨天我们这有雨，特别大，我站在路边想打个TAXI。　　正当我瞭望的时候，一小孩子大概是淋坏了，掀起我到脚踝的长裙就钻进去避雨。　　你以为这是GC？那孩子的爸爸一看孩子钻我裙子底下一边说对不起，一边又掀开我裙子把他孩子给拉出来了！　　整个过程动作流畅自然，尼玛啊！！！！","hashId":"425fbd9aee4d867d5fc9ec5a02366672","unixtime":1479941633,"updatetime":"2016-11-24 06:53:53"},{"content":"办公室有两美女，互相谁也不服气，常为小事争吵，经理很是头疼。　　这天早上，经理刚进办公室，就看到两人在争吵。经理十分生气：\u201c大早起就吵架，太不像话了！你们两个不把原因给我讲清楚了，我把你们两个人一块罚。\u201d　　两美女一听，又争起来了。　　\u201c我先讲\u2026\u2026\u201d　　\u201c我先讲\u2026\u2026\u201d　　见此情形，经理怒道：\u201c胖的先讲。\u201d　　顿时，两个人都不吱声了。","hashId":"0c324bf4af3e983bddc6f5d5b91fc227","unixtime":1479941633,"updatetime":"2016-11-24 06:53:53"},{"content":"回家路过步行街，一个小姑娘，牵着一只和她差不多高的大金毛，确切是狗狗牵着她，走着走着狗坐在地上不走了，小姑娘拉了半天拉不动。　　然后她蹲在狗旁边开始给狗讲道理\u2026\u2026讲道理\u2026\u2026道理\u2026\u2026","hashId":"2fe898583b9dafb3b074d6b975871e41","unixtime":1479941633,"updatetime":"2016-11-24 06:53:53"},{"content":"我们写作业是辛苦地写2个月。　　而老师却只需要在我们的成果上简简单单的写一个\u201c阅\u201d！","hashId":"af76c978647f234f5bbe48cb07bedd12","unixtime":1479941633,"updatetime":"2016-11-24 06:53:53"},{"content":"阿姨让我看着2岁的小表弟，然后我带他去逛街。　　上厕所的时候，担心小家伙被牵走，就拉着他一块上女厕。　　哪晓得，小家伙死活不进来，还说：\u201c妈妈说，我是男孩纸。\u201d　　我实在憋不住了，一急，就对他说：\u201c你长大以后就没机会进了！\u201d","hashId":"464c5019e59866b4b317f7c22f4759d9","unixtime":1479941633,"updatetime":"2016-11-24 06:53:53"},{"content":"一个说话有浓重口音的老师问一学生：\u201c50+9=？\u201d　　学生想了半天才答道：\u201c武术+酒=醉拳。\u201d","hashId":"ad7c78496af7a012a28b37a819fa2ea4","unixtime":1479941031,"updatetime":"2016-11-24 06:43:51"},{"content":"今天男朋友给我发信息，说奶奶想抱孙子了。　　我想了想回复：\u201c你不就是孙子么？\u201d","hashId":"55a69fcaad32af9cce8c08baee8b340e","unixtime":1479941031,"updatetime":"2016-11-24 06:43:51"}]}
     */

    private int error_code;
    private String reason;
    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * content : 英国两个小伙子花了一下午的时间在西瓜身上勒上橡皮筋，当被勒到第500条时，西瓜终于爆了……　　最后被他们用慢镜拍了下来。　　在场目睹了整个事件的刘先生称：“我活了48年，他们是我见过最无聊的两个人。”
             * hashId : 1c8896a19b51e083a883e9505d8b7690
             * unixtime : 1479944030
             * updatetime : 2016-11-24 07:33:50
             */

            private String content;
            private String hashId;
            private int unixtime;
            private String updatetime;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getHashId() {
                return hashId;
            }

            public void setHashId(String hashId) {
                this.hashId = hashId;
            }

            public int getUnixtime() {
                return unixtime;
            }

            public void setUnixtime(int unixtime) {
                this.unixtime = unixtime;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }
        }
    }
}
