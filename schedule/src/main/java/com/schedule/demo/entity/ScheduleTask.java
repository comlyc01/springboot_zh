package com.schedule.demo.entity;

import com.schedule.demo.utils.DateUtil;
import com.schedule.demo.utils.ScheduleUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class ScheduleTask implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(ScheduleTask.class);

    protected String id; // 任务唯一标识码

    public ScheduleTask(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void run() {
        LOG.info(id + "开始执行。时间： " + DateUtil.dateToStrLong(new Date()));
    }

    public static void main(String[] args) {
        LOG.info("当前时间：" + DateUtil.dateToStrLong(new Date()));

        // 启动任务1
        ScheduleUtil.start(new ScheduleTask("Task1"), DateUtil.addDateMinut(new Date(), 1));
        // 启动任务2
        ScheduleUtil.start(new ScheduleTask("Task2"), DateUtil.addDateMinut(new Date(), 2));
        // 启动任务3
        ScheduleUtil.start(new ScheduleTask("Task3"), DateUtil.addDateMinut(new Date(), 3));

        // 取消任务1
        ScheduleUtil.cancel(new ScheduleTask("Task1"));

        // 修改任务1的时间
        ScheduleUtil.reset(new ScheduleTask("Task1"), DateUtil.addDateMinut(new Date(), 10));
    }
}
