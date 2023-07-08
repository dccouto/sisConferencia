
## INSTRUÇÕES PARA USO DO FLYWAY

### CONFIG

É necessário a configuração de uma variável de ambiente do gitlab do tipo arquivo com as seguintes linhas:

```
flyway.url=jdbc:oracle:thin:@suorts01.mds.net:1521/MDSDES
flyway.schemas=DB_SKELETON
flyway.user=DB_SKELETON
flyway.password=******
flyway.locations=sql/flyway/
```

No fork, o desenvolvedor deve criar a variável com o nome FLYWAY_CONF_DESENV, com o conteudo acima alterando as linhas informando o schema, usuário e senha corretas para a aplicação.

### SQLS

Os arquivos com scripts para execução devem ser salvos no diretório informado no parametro flyway.locations (por padrão manteremos em sql/flyway/).

A nomenclatura deve obedecer o seguinte padrão: 

```
V#__esquema.tabela.sql
```

Onde # seria um numero de ordem da execução. Para todo novo script o desenvolvedor deve verificar o numero do último salvo e adicionar o próximo em sequência.

O conteudo dos scripts sql devem seguir as orientações da equipe de Administração de Dados.
https://wiki.cidadania.gov.br/en/CGSIS/Padroes_CGS/Adminstrador_Dados/AD
