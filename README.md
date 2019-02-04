# ProjetoPokemon
Esse aplicativo utiliza a API PokéAPI (https://pokeapi.co/), para mostrar todos os tipos de pokemon, separar os pokemons por tipo,
detalhar cada pokemon individualmente mostrando seus dados, e também permite que compartilhe essas informações do pokemon via aplicativos
do Android, como Outlook, Facebook e Whatsapp.
As bibliotecas que foram utilizadas nesse projeto foram as seguintes:
com.facebook.shimmer:shimmer:0.1.0@aar - Para fazer efeitos de carregamento nas telas, enquanto aguarda a resposta da PokéAPI.
com.google.code.gson:gson:2.8.5 - Para fazer a desserialização dos JSON da PokéAPI.
com.loopj.android:android-async-http:1.4.9 - Para consumir a PokéAPI, utilizando chamadas GET assíncronas e possibilitando de deixar o callback
na mesma thread em que foi criado.
com.squareup.picasso:picasso:2.71828 - Para facilitar a utilização de imagens via sua URL, deixando em apenas uma linha a sua funcionalidade.

A SDK mínima para executar este aplicativo, é a 24, e a target é a 28. Sendo assim, não é garantido o funcionamento correto em SDK's inferiores
a essa.

Para mais informações sobre este projeto, entre em contato pelo e-mail ge.stamm@hotmail.com.
