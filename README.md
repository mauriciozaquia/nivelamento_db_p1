# Desafio DBServer - Prova para alinhamento de conhecimentos em automação de testes
## Testes automatizados web

Estes *Script* foi desenvolvido para a prova de testes automatizados da mentoria da **DBserver**, tem por objetivo testar e validar casos de uso para o site [**Seu Barriga**](https://seubarriga.wcaquino.me/)

### PRÉ REQUISITOS

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas ou dependências:

* [Git](https://git-scm.com)
* [Java](https://www.java.com/pt-BR/)
* [JDK](https://www.oracle.com/java/technologies/downloads/)
* [JUnit 5](https://junit.org/junit5/)
* [Maven](https://maven.apache.org/)

Além disto é bom ter uma IDE Java para trabalhar com o código como por exemplo o [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/) ou [Ecplipse](https://www.eclipse.org/downloads/) dentre outras.

### EXECUÇÃO

* Abra o projeto "nivelamento_db_p1"
* Navegar até o pacote src/test/java/TestCases/
* Na classe *registerMovementTest* clicar com o botão direito
* Clicar no menu "Run registerMovementTest

### GERAÇÃO DE RELATÓRIO

* Apos executar os testes, os relatórios serão gerados automaticamente na pasta Relatorio na raiz do projeto.


### CENÁRIOS DE TESTE

#### Cenário 1: Realizar movimentação
* Passo 1: Acessar o site: https://seubarriga.wcaquino.me/login
* Passo 2: Registrar um novo usuário
* Passo 3: Acessar a plataforma
* Passo 4: Criar contas de Receitas e Despesas
* Passo 5: Inserir movimentações
* Passo 6: Validar as movimentações inseridas
* Passo 7: Validar saldo conforme as movimentações criadas