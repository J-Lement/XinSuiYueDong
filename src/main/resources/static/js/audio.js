$(document).ready(function() {

    var audio = $("audio")[0];//要在后面加[0]，否则获取不到
    audio.src = "/music/song/李荣浩 - 老街.mp3";

    var text;
    //ajax同步获取歌词文件中的歌词
    $.ajax({url:"/music/lyrics/老街.txt",success:function(data){
            text = data;
        },async:false});

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

    //开始3行不移动
    var startMoveLine = 3;
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