Feature: Gerenciamento de Zonas de Irrigação

  Scenario: Criar uma nova zona com dados válidos
    Given que o sistema está em execução
    When eu envio uma requisição POST para "/zones" com o corpo:
    """
    {
      "name": "Zona Norte",
      "type": "Gramado"
    }
    """
    Then o status da resposta deve ser 201
    And o corpo da resposta deve conter "Zona Norte"

  Scenario: Criar zona com dados inválidos
    Given que o sistema está em execução
    When eu envio uma requisição POST inválida para "/zones" com o corpo:
    """
    {
      "nome": ""
    }
    """
    Then o status da resposta deve ser 400

  Scenario: Listar todas as zonas
    Given que o sistema está em execução
    When eu envio uma requisição GET para "/zones"
    Then o status da resposta deve ser 200
    And a resposta deve conter uma lista de zonas

  Scenario: Criar uma nova zona válida e validar o contrato
    Given que o sistema está em execução
    When eu envio uma requisição POST para "/zones" com o corpo:
    """
    {
      "name": "Zona Leste",
      "type": "Jardim"
    }
    """
    Then o status da resposta deve ser 201
    And o corpo deve seguir o schema da zona
