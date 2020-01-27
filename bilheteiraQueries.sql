select eventoID from evento where nome = "Jogo de portugal"; # Obter o ID de um evento criado, pois este é auto_increment (uma querry automatica do java)
select eventoZonaID from evento_zona where eventoID_ev_zon = 1 and zonaID_ev_zon = 13; # Obter o ID da tabela de ligação entre o evento e a zona (evento_zona), informação necessária para a criação de bilhetes, pois este é auto_increment (uma querry automatica do java)
select (taxa * precoBase) from zona inner join evento_zona ON zonaID = zonaID_ev_zon inner join evento ON eventoID = eventoID_ev_zon inner join bilhete on eventoZonaID_bilhete = eventoZonaID where codigoBilhete = 10135798; # Calcular o preço de uma zona para um determinado evento, usando o codigo unico do bilhete (foi usado o eventoZonaID = 13 como exemplo, no projeto será usado uma variavel; ainda nao está implementado)
SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY','')); # necessario para ser possivel utilizar o group by
select * from evento group by eventoID; # Obter a lista com toda a informacao dos eventos
select sum(lugaresTotalZona) from zona inner join evento_zona	# Obter o numero total de lugares de um determinado evento
									on zonaID = zonaID_ev_zon where isIndisponivel = 0 and eventoID_ev_zon = 1;
Insert into bilhete (entrada, userID_bilhete, eventoZonaID_bilhete) values (?,?,?); #inserir um novo bilhete na base de dados
SELECT zonaID_ev_zon from evento_zona WHERE isIndisponivel = 0 and eventoID_ev_zon = ?; #obter as zonas disponiveis de um evento
select userID from utilizador where pass = ?; #Obter o ID do utilizador quando é inserido a sua password
Insert into evento (nome, precoBase, dia) values (?,?,?); # Inserir um novo evento na base de dados
insert into evento_zona (eventoID_ev_zon, zonaID_ev_zon) values (?,?); # Inserir um novo evento na tabela evento_zona na base de dados
select portao from zona where zonaID = ?; #Obter id do portao para uma determinada zona
SELECT zonaID, (lugaresTotalZona - count(codigoBilhete)) as 'lugares' from zona # Obter uma lista com os ID's das zonas e os seus 
				left join evento_zona ON zonaID_ev_zon = zonaID					# respectivos lugares disponiveis, de um determinado evento
				left join bilhete ON eventoZonaID = eventoZonaID_bilhete
				where eventoID_ev_zon = ? and isIndisponivel = 0 group by zonaID_ev_zon;
select count(*) as 'nZonas' from zona; #Obter o numero de zonas 
select zonaID as 'Zonas' from zona; #Obter uma lista com os id das zonas
SELECT MAX(eventoID) from evento; #Obter o ID do ultimo evento inserido
UPDATE evento_zona 		# Zonas selecionadas ficam marcadas como indisponiveis
	SET isIndisponivel = 1 
	WHERE eventoID_ev_zon = ? and zonaID_ev_zon = ?; 
DELIMITER $$	# Stored Procedure para contar os bilhetes vendidos de um determinado evento, recebe o id do evento e devolve o numero de bilhetes vendidos para o mesmo (nao esta implementado pois nao é suportado pela base de dados online, outras queries tambem seriam guardadas como stored procedure se fosse possivel)
CREATE PROCEDURE nBilhetes (in evID integer)
BEGIN
    select  count(codigoBilhete) as 'lugares' from bilhete
						inner join evento_zona ON eventoZonaID_bilhete = eventoZonaID
						left join evento on eventoID_ev_zon = eventoID
						where eventoID = evID and isDevolvido = 0;
END $$
DELIMITER ;
call nBilhetes (1); # call para o nBilhetes criado (foi utilizado o id 1 como exemplo)
