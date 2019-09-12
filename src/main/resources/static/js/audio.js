$(document).ready(function() {

    var audio = $("audio")[0];//要在后面加[0]，否则获取不到
    audio.src = "/music/song/李荣浩 - 老街.mp3";

    var text = "[00:00.00] 作曲 : 李荣浩\n" +
        "[00:01.00] 作词 : 李荣浩\n" +
        "[00:16.990]一张褪色的照片\n" +
        "[00:20.110]好像带给我一点点怀念\n" +
        "[00:23.920]巷尾老爷爷卖的热汤面\n" +
        "[00:27.900]味道弥漫过旧旧的后院\n" +
        "[00:31.890]流浪猫睡熟在摇晃秋千\n" +
        "[00:35.820]夕阳照了一遍他咪着眼\n" +
        "[00:40.320]那张同桌寄的明信片\n" +
        "[00:44.000]安静的躺在课桌的里面\n" +
        "[00:49.050]快要过完的春天\n" +
        "[00:51.860]还有雕刻着图案的门帘\n" +
        "[00:55.930]窄窄的长长的过道两边\n" +
        "[00:59.790]老房子依然升起了炊烟\n" +
        "[01:03.780]刚刚下完了小雨的季节\n" +
        "[01:07.840]爸妈又一起走过的老街\n" +
        "[01:12.270]记不得哪年的哪一天\n" +
        "[01:15.960]很漫长又很短暂的岁月\n" +
        "[01:20.330]现在已经回不去\n" +
        "[01:24.270]早已流逝的光阴\n" +
        "[01:28.210]手里的那一张渐渐模糊不清的车票\n" +
        "[01:33.010]成了回忆的信号\n" +
        "[01:37.880]忘不掉的是什么我也不知道\n" +
        "[01:42.440]想不起当年模样\n" +
        "[01:46.290]看也看不到 去也去不了的地方\n" +
        "[01:54.010]也许那老街的腔调是属于我的忧伤\n" +
        "[02:02.300]嘴角那点微笑越来越勉强\n" +
        "[02:08.650]\n" +
        "[02:09.990]忘不掉的是什么我也不知道\n" +
        "[02:14.220]放不下熟悉片段\n" +
        "[02:18.310]回头望一眼 已经很多年的时间\n" +
        "[02:25.880]透过手指间看着天\n" +
        "[02:30.250]我又回到那老街\n" +
        "[02:34.300]靠在你们身边渐行渐远\n" +
        "[02:42.310]\n" +
        "[03:10.960]快要过完的春天\n" +
        "[03:13.960]还有雕刻着图案的门帘\n" +
        "[03:17.890]窄窄的长长的过道两边\n" +
        "[03:21.880]老房子依然升起了炊烟\n" +
        "[03:25.900]刚刚下完了小雨的季节\n" +
        "[03:29.910]爸妈又一起走过的老街\n" +
        "[03:34.260]记不得哪年的哪一天\n" +
        "[03:37.880]很漫长又很短暂的岁月\n" +
        "[03:42.310]现在已经回不去\n" +
        "[03:46.310]早已流逝的光阴\n" +
        "[03:50.050]手里的那一张渐渐模糊不清的车票\n" +
        "[03:55.010]成了回忆的信号\n" +
        "[03:59.760]忘不掉的是什么我也不知道\n" +
        "[04:04.190]想不起当年模样\n" +
        "[04:08.260]看也看不到 去也去不了的地方\n" +
        "[04:15.870]也许那老街的腔调是属于我的忧伤\n" +
        "[04:24.260]嘴角那点微笑越来越勉强\n" +
        "[04:31.880]忘不掉的是什么我也不知道\n" +
        "[04:36.240]放不下熟悉片段\n" +
        "[04:40.220]回头望一眼 已经很多年的时间\n" +
        "[04:47.840]透过手指间看着天\n" +
        "[04:52.330]我又回到那老街\n" +
        "[04:56.260]靠在你们身边渐行渐远\n";

    function analysisLyrics(text){
        textArray = text.split("\n");
        //result要定义成数组，否则会出错
        var result=[];

        for(var i = 0; i < textArray.length; i ++){
            //获取歌词出现的时间，time[0]为分，time[1]为秒
            var time = textArray[i].substring(1, textArray[i].indexOf("]")).split(":");
            // console.log("i:" + i + " time: " + time[0] + " : " + time[1]);
            //获取歌词内容
            var content = textArray[i].substring(textArray[i].indexOf("]") + 1, textArray.length);
            result.push({
                //将时间转换成以秒为单位，保留两位小数,要加括号，否则会被当成字符串
                lineTime: (parseInt(time[0] * 60) + parseFloat(time[1])).toFixed(4),
                content : content
            });
            // console.log(result[i].lineTime);
        }
        return result;
    }

    var result = analysisLyrics(text);

    //插入包含歌词的html组件
    var $ul = $("<ul></ul>");
    for(var i = 0; i < result.length; i ++){
        var $li = $("<li></li>").text(result[i].content);
        $ul.append($li);
    }
    //包含歌词的div
    var lyricsDiv = $(".lyricsDiv");
    lyricsDiv.append($ul);

    //开始六行不移动
    var startMoveLine = 4;
    //每次移动60个单位
    var lineMove = -60;
    //歌词总行数
    var allLine = result.length;

    //当前行高亮
    function highLight(){
        var nowLine = getNowLine();
        $("li").eq(nowLine).addClass("active").siblings().removeClass("active");
        if(nowLine >= startMoveLine)
            $ul.stop(true, true).animate({top : (nowLine - startMoveLine) * lineMove});
    }

    //获取当前行的行号
    function getNowLine(){
        for(var i = 0; i < allLine; i ++){
            // console.log(audio.currentTime);
            if(audio.currentTime < result[i].lineTime){
                // console.log(" : " + result[i].lineTime);
                return --i;
            }
        }
        return 0;
    }

    //监听事件，播放位置改变时触发
    audio.addEventListener("timeupdate",function () {
        highLight();
    });


});