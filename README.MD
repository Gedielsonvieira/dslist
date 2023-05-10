# Projeto java spring
- anotar topicos e pedir para o gpt criar um readme
    - projeto java com banco de dados em memoria h2, postgtre para colocar na nuvem e jpa
    - separado por ambiente de teste, homologação e produção
## Aprendizados

### API

É só o que está exposto para a web, então falar que o back end e api são a mesma coisa conceitualemnte
não é a mesma coisa até porque no back-end tem muito mais coisa do qeu está exposto a API

é a interface para mexer com o bacj end

#### Padrão REST

- Cliente/servidor com HTTP
- Comunicação statless (\*) - não guarda estado,
- Interface uniforme, formato padronizado (\*)
- Cache
- Sistema em camadas
- Código sob demanda (opcional)

### Erro padrão Spring

Whitelabel Error Page
This application has no explicit mapping for /error, so you are seeing this as a fallback.

Tue May 09 20:49:56 BRT 2023
There was an unexpected error (type=Not Found, status=404).

## Relembrando
- camelCase: primeira palavra minúscula e a primeira letra de cada nova palavra maiúscula
Ex: valorFinal

- @Column(columnDefinition = "TEXT"): embora a string do Java aceite até 4GB ao não colocar essa anotação em um atributo que irá receber um texto longo a JPA ao fazer ORM ela vai entender que queremos que ela mapeie o atributo para um campo no BD como varchar, que aceita somente 255 caracteres
