package com.schedule.demo.utils;


import com.schedule.demo.entity.ScheduleTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTask;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

/**
 * 定时任务工具类
 */
public class ScheduleUtil {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleUtil.class);

    private static ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
    private static Map<String, ScheduledFuture<?>> scheduledFutureMap = new HashMap<>();

    static {
        threadPoolTaskScheduler.initialize();
        logger.info("定时任务线程池启动");
    }

    // 启动某定时任务
    public static void start(ScheduleTask scheduleTask, Date startTime) {
        ScheduledFuture<?> scheduledFuture = threadPoolTaskScheduler.schedule(scheduleTask, startTime);    // 启动定时任务
        scheduledFutureMap.put(scheduleTask.getId(), scheduledFuture);   // 取消定时任务时用
        logger.info("启动定时任务" + scheduleTask.getId() + ", 执行时间" + DateUtil.dateToStrLong(startTime));
    }

    // 取消某定时任务
    public static void cancel(ScheduleTask scheduleTask) {
        ScheduledFuture<?> scheduledFuture = scheduledFutureMap.get(scheduleTask.getId());

        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            scheduledFuture.cancel(false);
        }
        scheduledFutureMap.remove(scheduleTask.getId());
        logger.info("取消定时任务： " + scheduleTask.getId());
    }

    //修改某定时任务时间
    public static void reset(ScheduleTask scheduleTask, Date startTime) {
        // 先取消某定时任务
        ScheduledFuture<?> scheduledFuture = scheduledFutureMap.get(scheduleTask.getId());

        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            scheduledFuture.cancel(false);
        }
        scheduledFutureMap.remove(scheduleTask.getId());
        // 启动新的定时任务
        scheduledFuture = threadPoolTaskScheduler.schedule(scheduleTask, startTime);
        scheduledFutureMap.put(scheduleTask.getId(), scheduledFuture);
        logger.info("修改定时任务" + scheduleTask.getId() + "的执行时间为" + DateUtil.dateToStrLong(startTime));

    }

}
