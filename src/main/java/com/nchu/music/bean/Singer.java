package com.nchu.music.bean;

/**
 * @ClassName Singer
 * @Description 歌手类
 * @Author Lement
 * @Date 2019/9/12 15:18
 */
public class Singer {
    private Integer singerId;
    private String singerName;
    private String singerInfomation;

    public Integer getSingerId() {
        return singerId;
    }

    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getSingerInfomation() {
        return singerInfomation;
    }

    public void setSingerInfomation(String singerInfomation) {
        this.singerInfomation = singerInfomation;
    }
}
