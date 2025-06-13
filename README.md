PROJETO POKEMON (em Java Puro usando Orientação a Objetos).

A ideia do projeto era simular batalhas entre dois Treinadores com seus Pokémons, e então permitir o acesso ao histórico das batalhas. 
O vencedor é determinado pelo tipo do Pokémon, com a possibilidade de empate caso sejam do mesmo tipo.

PRINCIPAIS CLASSES:

Model

Representam o modelo de cada entidade ou ação envolvida neste programa:
    Pokémon (e subclasses: PokemonFogo, PokemonAgua, PokemonGrama): Representa os Pokémons com seus atributos (nome, tipo, nivel). Utiliza herança.
    Treinador: Representa o treinador, contendo uma lista de Pokémons. Possui relação de composição com Pokémons.
    Batalha: Representa uma batalha entre dois treinadores.
    RegrasBatalha: Define as lógicas para determinar vencedores com base nos tipos.
    HistoricoBatalhas: Armazena os registros das batalhas.

Controller

Controlam as interações com o usuário:
    TreinadorController
    PokemonController
    BatalhaController

Service

Executam a lógica de negócios:
    SistemaService: Gerencia o carregamento e salvamento de dados.
    BatalhaService, PokemonService, TreinadorService: Contêm regras específicas de cada domínio.

View

Lidam com entrada e saída no terminal:
    ConsoleView, MenuPrincipal, InputHelper, etc.

Persistência

Responsáveis pela leitura e escrita dos dados:
    ArquivoTreinador, ArquivoPokemon, ArquivoBatalha.

COMO RODAR O PROJETO

Pré-requisitos:
    Baixar JDK 11 ou superior para execução.
    Possuir uma IDE (IntelliJ, Eclipse, Visual Studio Code, etc.).

MÉTODO 1: Via Download ZIP (Recomendado para iniciantes)

Este método é recomendável para quem tem um programa que consegue descompactar arquivos (ex: 7-Zip);
    O arquivo .zip do projeto pode ser baixado clicando em "<>Code" e, em seguida, em "Download ZIP".
    Após descompactar, você pode abrir e executar o projeto usando uma IDE como Visual Studio Code ou IntelliJ.

MÉTODO 2: Via Linha de Comando (Cmd)

Clone o repositório:
    git clone https://github.com/Luc-Bruno/Projeto-Pokemon.git

Acesse o diretório do projeto e compile:
    cd Projeto-Pokemon-master
    javac -d bin src/**/*.java

Execute o projeto:
    java -cp bin Main

USO DO CHATGPT
  O ChatGPT foi utilizado na idealização do projeto (usando o prompt disponibilizado pelo Professor), na estruturação do projeto, no auxílio ao salvamento em arquivos e na junção das classes.

REFERÊNCIAS
  ChatGPT;
  Material disponibilizado pelo Professor (slides e códigos disponíveis no GitLab).
