# Bilheteira de eventos de um estádio


## Participantes
Renato Júnior, 50039475

Ricardo Cruz, 50039470

## Enquadramento do projeto
Este projeto enquadra-se na área de venda de bilhetes para eventos de um estádio.

A venda de bilhetes é uma das principais fontes de rendimento de um clube ou de um artista / artistas responsáveis pelo evento. É importante ter um sistema fluido, eficaz e fácil de navegar, principalmente onde há milhares de clientes a aceder simultaneamente. Assim é fundamental ter uma base de dados rápida, organizada e eficaz.

Este projeto pode ser comparado com a TicketLine pois ambos têm os mesmos objetivos.

Ticketline foi fundada em 1999 e é a maior e mais conceituada empresa nacional especializada em vendas de bilhetes para qualquer tipo de eventos.

Facilita o acesso à compra dos bilhetes, aumenta a venda dos mesmos, reduz os custos operacionais e encurta a distância entre o espectador e o evento ao diminuir o tempo e esforço gastos pelo cliente.

Disponibiliza no site (www.ticketline.pt), de forma simples e segura, os bilhetes para qualquer tipo de evento. O cliente pode pesquisar por categoria do evento, data, localidade e nome.

A sua base de dados e o próprio site têm que ser rápidos, seguros, eficazes e principalmente bem estruturados pois este é visitado por meio milhão a 1 milhão de pessoas mensalmente.

Neste projeto trazemos uma alteração vantajosa quando comparado com a ticketline, fazemos venda dos bilhetes por zona e não marcados por cada lugar, o que diminui em grande parte os recursos necessários para o bom funcionamento da base de dados e tambem facilita a criação de eventos em que o administrador pode escolher quais zonas onde deseja vender os bilhetes e quais estarão fechadas para esse evento em particular.

## Cenário principal:
Lista de Eventos: Antes de serem comprados os bilhetes é necessário que o utilizador escolha o evento para o qual quer comprar o/os bilhete/bilhetes. Na lista é apresentado o ID, o nome, a data e as horas, o preço base (preço mais baixo para o qual é aumentado por uma taxa dependendo da zona em questão) e o número de lugares disponiveis de cada evento. Para escolher a zona, basta clicar na linha da tabela com os dados do evento preferido pelo utilizador.

Compra de bilhetes: É escolhida a zona para a qual é desejado reservar um bilhete (a partir deste momento um lugar, dentro da zona escolhida fica indisponível, diminuindo o numero de lugares disponíveis).

NOTA:
Os bilhetes são vendidos por zona logo não há lugares marcados no estádio.

## Cenários secundários:
Preços variados consoante as várias zonas.

Troca de zona: Após a compra do seu bilhete, o utilizador ao escolher a opção de trocar de zona é lhe pedido o código gerado no ato da compra. Após submeter o código É criada uma janela com o valor a ser devolvido (preço do bilhete).

Criação de eventos no estádio: um administrador escolhe a opção "criar evento" e é levado para uma janela onde é-lhe pedido uma password (previamente criada), se nao for introduzida a password correta é mostrada uma mensagem de erro, se acertar o administrador é levado para a janela onde é pedido o nome do evento, data e hora, preço base (o preço da zona mais barata, pelo qual são calculados os preços das restantes zonas) e por fim escolhe as zonas onde o administrador deseja desativar (para onde não vão ser vendidos bilhetes, pois pode estar atras de um palco), quando estiver tudo escolhido o administrador clica em "SUBMETER".

## Manual de Instruções
Comprar Bilhete: 
Menu Principal > Comprar Bilhete > Inserir a password do utilizador e clicar “Enter” > Escolher e clicar no evento >
Escolher zona e clicar “Confirmar zona” > Escolher o numero de bilhetes pretendido e clicar “Comprar” >
Uma janela irá aparecer com o bilhete (os códigos dos bilhetes estarão presentes na caixa dentro do bilhete) e outra 
com o preço total de todos os bilhetes comprados.

Criar Evento:
Menu Principal > Criação de Eventos > Inserir a password reservada a administradores (a password é a mesma para todos os funcionários) >
Inserir os dados do evento e clicar “Continuar” > escolher as zonas indisponíveis do evento e clicar “Submit” >
Uma janela irá aparecer com a confirmação de que o evento foi criado com sucesso.

Devolver Bilhete:
Menu Principal > Devolução de Bilhetes > Inserir o código do bilhete e clicar “Confirmar”>
Uma janela irá aparecer com o valor a devolver, para fazer a devolução de outro bilhete basta repetir o processo.

## Referências:
QUEM SOMOS. Acedido em: 2, 10, 2019, em: https://ticketline.sapo.pt/pagina/quemsomos.
