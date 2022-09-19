package br.com.devrodrigues.schoolservice.input.api.middleware;

import br.com.devrodrigues.schoolservice.core.exceptions.YouCantRunException;
import br.com.devrodrigues.schoolservice.ports.UserPort;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class YouCanRunAspect {

    private final Logger logger = LoggerFactory.getLogger(YouCanRunAspect.class);
    private final UserPort userPort;

    public YouCanRunAspect(UserPort userPort) {
        this.userPort = userPort;
    }

    @Around("execution(* br.com.devrodrigues.schoolservice.input.api.StudentApiImpl.listAll(..))" +
            "|| execution(* br.com.devrodrigues.schoolservice.input.api.AttendanceApiImpl.storeAttendance(..))" +
            "|| execution(* br.com.devrodrigues.schoolservice.input.api.AttendanceApiImpl.attendanceJustifyAttendanceIdPost(..)) " +
            "|| execution(* br.com.devrodrigues.schoolservice.input.api.ReportApiImpl.reportAttendanceGet(..))"
    )

    public Object execute(ProceedingJoinPoint pjp) throws Throwable {
        var token = (String) pjp.getArgs()[0];
        var function = (String) pjp.getArgs()[1];

        try {
            var youCanRun = userPort.youCanRun(token, function);

            if (youCanRun) {
                return pjp.proceed();
            }

            throw new YouCantRunException("You can't run this function");
        } catch (Exception e) {
            logger.error("Error in youCanRunAspect", e);
            throw new RuntimeException(e);
        }
    }
}
