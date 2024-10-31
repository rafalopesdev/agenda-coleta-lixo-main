#language: pt

Funcionalidade: Gerenciar agenda de coleta de lixo

  Cenário: Criar um novo registro de coleta
    Dado que eu tenho os dados de um novo registro de coleta
      | tipo     | dia         | horario | endereco             |
      | Orgânico | 2024-10-15  | 07:00   | Rua Principal, 123   |
    Quando eu envio uma requisição POST para criar o registro
    Então o registro deve ser criado com sucesso e o status code deve ser 201
    E o campo "tipo" do registro criado deve ser "Orgânico"

  Cenário: Listar todos os registros de coleta
    Dado que existem registros de coleta cadastrados
    Quando eu envio uma requisição GET para listar todos os registros
    Então a resposta deve conter uma lista de registros de coleta
    E o status code deve ser 200

  Cenário: Deletar um registro de coleta
    Dado que existe um registro de coleta com o ID "123"
    Quando eu envio uma requisição DELETE para deletar o registro com o ID "123"
    Então o status code deve ser 204
    E o registro com o ID "123" não deve mais existir

  Cenário: Atualizar um registro de coleta
    Dado que existe um registro de coleta cadastrado para atualização
    Quando eu envio uma requisição PUT para atualizar o registro
    Então o status code deve ser 200
    E o campo "tipo" do registro atualizado deve ser "Reciclável"
