# language: pt

Funcionalidade: Pesquisar conteúdos aleatórios no youtube

Cenario: Deve pesquisar (class name: YoutubeRamdomSearch)
  Dado que busca uma palavra aleatoria na API
  E insere as informacoes na pesquisa do youtube
  Quando executa a pesquisa
  Entao a pesquisa deve finalizar com sucesso