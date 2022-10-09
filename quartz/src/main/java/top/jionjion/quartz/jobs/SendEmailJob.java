package top.jionjion.quartz.jobs;


import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 模拟定时发送邮件任务.
 * Job类, 定义具体的业务
 *
 * @author Jion
 */
@SuppressWarnings("unused")
public class SendEmailJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) {
        // 从上下文中获得执行参数
        JobDataMap jobDataMap = context.getMergedJobDataMap();

        if (jobDataMap != null && !jobDataMap.isEmpty()) {
            System.out.println("******************************");
            System.out.println("job name = " + jobDataMap.get("TASK_NAME"));
            System.out.println("开始发送邮件了");
        }
    }
}