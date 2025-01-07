<h1 align="center">
    Fórum-hub
</h1>

<h2>
Descrição
</h2>

<p>
 Challenge Alura e Oracle Next Education<br><br>
    A aplicação consiste em uma API de um fórum ao qual estudantes conseguem criar tópicos para sanar dúvidas de determinado assunto de um curso. Outros usuários conseguem inserir respostas para às dúvidas. É possível listar cada tópico
  individualmente e listar todos os tópicos com paginação. Você pode registrar um tópico, atualizar e deletar. A deleção será possível apenas se o tópico não tiver respostas. Também foi adicionado a opção de listar os cursos. 
</p>

<h2>Tecnologias utilizadas</h2>

<ul>
    <li>Java</li>
    <li>Spring Boot</li>
    <li>Maven</li>
    <li>PostgreSql</li></li><br>
  
</ul>

<h2>Instalação</h2>
<ul>
    <li>1. Clone o repositório</li>
    <li>2. Certifique-se de ter o Java JDK 17</li>
    <li>3. Importe o projeto para uma IDE</li>
    <li>4. Configure o arquivo application.properties para o banco de dados PostgreSql</li>
    <li>5. Execute a classe ApiApplication</li>
</ul>

<h2>Como usar</h2>
<p>Após iniciar a API será possível acessar endpoints para gerenciar os usuários, o login, os tópicos e as respostas.<p>

<p>Será necessário popular sua base de dados. Você tem que cadastrar diretamente no banco de dados na tabela tb_usuario um primeiro usuário, preencha os campos das tabelas "email" e "senha".
<br>Lembre-se de usar o método de criptografia BCRYPT ao inserir a senha na tabela no banco de dados. Utilize um site para criptografar uma senha no formato BCRYPT e utilize o Hash da senha no campo da coluna "senha"<p>

<p>Logo após será possível fazer o login em um software de teste de requisição de sua preferência - como o Insomnia ou Postman por exemplo. Após fazer o login utilize o token JWT gerado na aba de Bearer token, toda vez que for testar as requisições.
<p>

  <h2>Link - Diagrama do projeto</h2>
![diagrama_banco_de_dados_forumhub](https://github.com/user-attachments/assets/0220b921-b63c-4d0b-a4cc-86f7d912a449)

  
