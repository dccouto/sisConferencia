# Ministério da Cidadania
## Equipe de Qualidade
### SisConferencia API

Esse é SisConferencia API
O projeto foi baseado no padrão para aplicações que utilizarão backend em JAVA. Ele já vem configurado com alguns recursos do springboot, dentre eles:

1. spring-boot-starter-actuator
2. spring-boot-starter-web
3. spring-boot-starter
4. spring-boot-starter-data-jpa
5. spring-boot-devtools
6. spring-boot-starter-test
7. spring-boot-maven-plugin

Configuramos outros pacotes para auxílio no desenvolvimento:

1. com.h2database
2. org.projectlombok
3. junit
4. springfox-swagger2
5. springfox-swagger-ui

Disponibilizamos a documentação através do SWAGGER em url/swagger-ui.html.

Para iniciar, configure o local da sua base de dados h2. 
Edite o arquivo src\main\resources\application.properties e modifique a propriedade spring.datasource.url

Configuramos os arquivos Docker para levantar o projeto. 
Para isso utilize os comandos abaixo, na raiz do projeto:
```
// exlcuir a imagem java caso já possua para compilar novamente
$ docker-compose down && docker rmi -f java11:latest

// compilar a imagem com parametros atuais
$ docker build --rm --network host --target runner -t java11 .

// levantar aplicação
$ docker-compose down && docker-compose up -d

// visualizar logs
# docker logs -f sisConferencia-api-java11
```
