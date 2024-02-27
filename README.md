# toCare
API do Projeto toCare - Agendamento de consultas médicas

## Requisitos

- [ ] CRUD de Agendamentos
- [ ] CRUD de Usuários
- [ ] CRUD de Profissional
- [ ] Autenticação
- [ ] Dashboard

## Documentação da API

Endpoint

- [Listar Agendamento](#listar-agendamento)
- [Cadastrar Agendamento](#cadastrar-agendamento)
- [Detalhar motivo de Agendamento](#detalhar-agendamento)
- [Apagar Agendamento](#apagar-agendamento)
- [Atualizar Agendamento](#atualizar-agendamento)

### Listar Agendamentos

`GET` /agendamento

Retorna um array com todos os agendamentos do usuário autenticado.

#### Exemplo de Resposta

```js
[
    {
        "id": 1,
        "agenda": "agendamento"
        "icone": "agenda"
    }
]
```

#### Códigos de Status

|código| descrição
|------| ---------
|200| Lista de agendamentos retornada com sucesso
|401| Não autenticado.

---

### Cadastrar Agendamento

`POST` /agendamento

Cadastra um agendamento com dados enviados no corpo da requisição.

#### Corpo da Requisição

|campo|tipo|obrigatório|descrição
|-----|----|-----------|---------
|nome|string|SIM|Um nome curto para o agendamento
|consultorio|string|SIM|Selecionar consultorio desejado
|data|date-time|SIM|Selecionar uma data para agendamento

#### Exemplo de Requisição

```js
//POST/agendamento
{
    "nome": "Avaliação"
}
```

#### Exemplo de Resposta
```js
{
    "id": 1,
    "nome": "Avaliação"
    "icone": "agenda"
}
```
#### Códigos de Status

|código| descrição
|------| ---------
|201| Agendamento foi criado com sucesso.
|400| Validação falhou. Verifique o corpo da requisição
|401| Não autenticado. Se autentique em /login

---

### Detalhar Agendamento

`GET`/agendamento/`{id}`

Retorna os detalhes da categoria com o `id` informado no path.

#### Exemplo de Resposta
```js
{
    "id": 1,
    "nome": "Avaliação"
    "icone": "agenda"
}
```

#### Códigos de Status

|código| descrição
|------| ---------
|200| Agendamento foi criado com sucesso.
|401| Não autenticado. Se autentique em /login
|403| Não autorizado. Esse agendamento não pertence ao usuário autenticado.
|404| Não existe categoria com o `id` informado
---

### Apagar Agendamento

`DELETE` /agendamento/`{id}`

Apaga o agendamento com o `id` informado no path

### Códigos de Status

|código| descrição
|------| ---------
|204| Agendamento foi apagado com sucesso.
|401| Não autenticado. Se autentique em /login.
|403| Não autorizado. Esse agendamento não pertence ao usuário autenticado.
|404| Não existe categoria com o `id` informado
---

### Atualizar agendamento

`PUT` /categoria/`{id}`

Atualiza os dados do agendamento com o `id` informado no path. utilizando as informações do corpo da requisição

#### Corpo da Requisição

|campo|tipo|obrigatório|descrição
|-----|----|-----------|---------
|nome|string|SIM|Um nome curto para o agendamento
|consultorio|string|SIM|Selecionar consultorio desejado
|data|date-time|SIM|Selecionar uma data para agendamento

#### Exemplo de Requisição

```js
// PUT /agendamento/1
{
    "nome": "Avaliação",
    "icone": "agenda"
}
```

#### Exemplo de Resposta
```js
{
    "id": 1,
    "nome": "Avaliação",
    "icone": "agenda"
}
```
### Códigos de Status

|código| descrição
|------| ---------
|200| Agendamento foi atualizada com sucesso.
|400| Validação falhou. Verifique o corpo da requisição.
|401| Não autenticado. Se autentique em /login
|403| Não autorizado. Esse agendamento não pertence ao usuário autenticado.
|404| Não existe categoria com o `id` informado
---



