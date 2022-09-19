package br.com.devrodrigues.schoolservice.input.api.middleware;

import br.com.devrodrigues.schoolservice.core.enums.Permissions;
import br.com.devrodrigues.schoolservice.ports.UserPort;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static br.com.devrodrigues.schoolservice.core.enums.Permissions.ROLLS;

@Aspect
@Component
public class YouCanRunAspect {

    private final Logger logger = LoggerFactory.getLogger(YouCanRunAspect.class);
    private final UserPort userPort;

    public YouCanRunAspect(UserPort userPort) {
        this.userPort = userPort;
    }

    @Around("execution(* br.com.devrodrigues.schoolservice.input.api.StudentApiImpl.listAll(..))" +
            "|| execution(* br.com.devrodrigues.schoolservice.input.api.AttendanceApiImpl.storeAttendance(..))"
    )

    public Object execute(ProceedingJoinPoint pjp) throws Throwable {
        var token = (String) pjp.getArgs()[0];

        try {
            var youCanRun = userPort.youCanRun(token, ROLLS.getValue());

            if (youCanRun) {
                return pjp.proceed();
            }

            throw new RuntimeException("You can't run this function");
        } catch (Exception e) {
            logger.error("Error in youCanRunAspect", e);
            throw new RuntimeException(e);
        }
    }
}
