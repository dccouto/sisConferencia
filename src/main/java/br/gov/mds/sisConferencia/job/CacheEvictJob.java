package br.gov.mds.sisConferencia.job;

import java.time.LocalDateTime;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@EnableScheduling
@Log4j2
class CacheEvictJob {
    
    private static final String TIME_ZONE = "America/Sao_Paulo";

    
    @Scheduled(cron = "${cron.expression.push.notification.expire.cecad}", zone = TIME_ZONE)
    @CacheEvict(value = {"BeneficiarioCecad","FamiliaCecad"}, allEntries = true)
    public void removeCache() {
        log.info("Cache removido " + LocalDateTime.now());
        
    }

}
