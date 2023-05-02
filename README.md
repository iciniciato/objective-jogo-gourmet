[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=iciniciato_objective-jogo-gourmet&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=iciniciato_objective-jogo-gourmet)

# objective-jogo-gourmet-simples

Exemplo do Jogo Gourmet: <https://www.dropbox.com/s/bbek2kmd2dvvumh/JogoGourmet.zip?dl=0>

Você deverá implementar em JAVA com exatamente o mesmo comportamento e características, o mais OO e o mais simples possível. Precisamos que nos envie o código fonte e o executável para auxiliar na avaliação da sua aplicação.

Você tem até 48 horas para entregar a solução do exercício. Caso você não possa cumprir este prazo, por favor, nos avise.

Dicas:
- Teste bem o jogo e só entregue se estiver funcionando.
- Queremos avaliar a qualidade e o estilo da implementação e não APENAS ver se funciona.
- O jogo para estar funcionando, deve estar com o mesmo comportamento que o jogo modelo. Estimule ambos os jogos (o modelo e o que você enviará) com as mesmas respostas, e o resultado deve ser o mesmo.
- Não precisa fazer telas, JOptionPane e afins já resolvem.


# Considerações sobre o desafio
- Nunca havia feito nenhum jogo, foi bem complicado entender como funciona um game loop, pesquisei bastante antes de entender que é uma solução muito usual para jogos e que se enquadrava muito bem no desafio.
- No jogo de exemplo no campo disponível para escrita do prato, ele aceita o campo vazio e segue o fluxo com o campo vindo como "null". No meu desenvolvimento fiz um tratamento para retornar para a tela de ínicio caso esse campo retorno nulo ou vazio.
- Tentei aproximar a aparencia do meu projeto o maximo possivel do projeto exemplo, tive algumas dificuldades sendo a mais evidente a do tamanho do textField, sei que o problema está relacionado a criação do textPanel onde defino o BoxLayout igual a BoxLayout.Y_AXIS, mas não encontrei, a tempo, nenhuma solução que deixasse o campo mais próximo do original.
