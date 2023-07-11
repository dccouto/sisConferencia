package br.gov.mds.sisConferencia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import br.gov.cidadania.sso.api.cache.client.config.CacheClientProperties;
import br.gov.cidadania.sso.api.oauth.client.config.OauthClientProperties;
import br.gov.cidadania.sso.api.servico.client.config.ServicoClienteProperties;

/**
 * Class principal da aplicação que habilita
 *  as configurações inciais
 * e realiza as configurações dos beans
 */
@EnableCaching
@EnableFeignClients(basePackages = "br.gov.mds")
@SpringBootApplication
@ComponentScan(basePackages = "br.gov.mds")
@EnableConfigurationProperties({
        OauthClientProperties.class,
        CacheClientProperties.class,
        ServicoClienteProperties.class
})
public class SisConferenciaApiApplication {
    /**
     * function main
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.setProperty("server.servlet.context-path", "/sisconferencia/api/v1");
        SpringApplication.run(SisConferenciaApiApplication.class, args);
    }
}
