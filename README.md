# ComparaPrecoAPI

## Rodando a aplicação

### Requisitos
1. *Java*
2. *Spring tool suite*
3. *Redis(Opcional)*

### Rodando a aplicação

2. *Clonar o projeto `git clone https://github.com/NeeT-T/ComparaPrecoAPI.git`*
3. *Abrir o projeto no Spring tool suite*
4. *Se optar por utilizar o Redis adicione as configurações do redis ao arquivo `(root)/src/main/resources/application.properties`*
```
spring.cache.type=redis
spring.redis.host=[host-ip]
spring.redis.port=[port]
```
**OBS: O redis deverá está rodando antes de inicializar a API.**

5. *Rode o projeto como uma aplicação Spring boot*


