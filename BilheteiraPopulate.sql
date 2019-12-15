insert into estadio (estadioID) values (01);

insert into zona (zonaID, portao, taxa, lugaresTotalZona, estadioID_zona) values (01, 01, 1.8, 2000, 01);
insert into zona (zonaID, portao, taxa, lugaresTotalZona, estadioID_zona) values (02, 02, 1.8, 2000, 01);
insert into zona (zonaID, portao, taxa, lugaresTotalZona, estadioID_zona) values (03, 03, 1.2, 1800, 01);
insert into zona (zonaID, portao, taxa, lugaresTotalZona, estadioID_zona) values (04, 04, 1.2, 1800, 01);
insert into zona (zonaID, portao, taxa, lugaresTotalZona, estadioID_zona) values (05, 05, 1.8, 2000, 01);
insert into zona (zonaID, portao, taxa, lugaresTotalZona, estadioID_zona) values (06, 06, 1.8, 2000, 01);
insert into zona (zonaID, portao, taxa, lugaresTotalZona, estadioID_zona) values (07, 07, 1.2, 1800, 01);
insert into zona (zonaID, portao, taxa, lugaresTotalZona, estadioID_zona) values (08, 08, 1.2, 1800, 01);
insert into zona (zonaID, portao, taxa, lugaresTotalZona, estadioID_zona) values (09, 09, 1.0, 2800, 01);
insert into zona (zonaID, portao, taxa, lugaresTotalZona, estadioID_zona) values (10, 10, 1.5, 2800, 01);
insert into zona (zonaID, portao, taxa, lugaresTotalZona, estadioID_zona) values (11, 11, 1.5, 2800, 01);
insert into zona (zonaID, portao, taxa, lugaresTotalZona, estadioID_zona) values (12, 12, 1.0, 2800, 01);
insert into zona (zonaID, portao, taxa, lugaresTotalZona, estadioID_zona) values (13, 13, 1.0, 2500, 01);
insert into zona (zonaID, portao, taxa, lugaresTotalZona, estadioID_zona) values (14, 14, 1.1, 2500, 01);
insert into zona (zonaID, portao, taxa, lugaresTotalZona, estadioID_zona) values (15, 15, 1.1, 2500, 01);
insert into zona (zonaID, portao, taxa, lugaresTotalZona, estadioID_zona) values (16, 16, 1.0, 2500, 01);
insert into zona (zonaID, portao, taxa, lugaresTotalZona, estadioID_zona) values (17, 17, 1.0, 2800, 01);
insert into zona (zonaID, portao, taxa, lugaresTotalZona, estadioID_zona) values (18, 18, 1.5, 2800, 01);
insert into zona (zonaID, portao, taxa, lugaresTotalZona, estadioID_zona) values (19, 19, 1.5, 2800, 01);
insert into zona (zonaID, portao, taxa, lugaresTotalZona, estadioID_zona) values (20, 20, 1.0, 2800, 01);
insert into zona (zonaID, portao, taxa, lugaresTotalZona, estadioID_zona) values (21, 21, 1.0, 2500, 01);
insert into zona (zonaID, portao, taxa, lugaresTotalZona, estadioID_zona) values (22, 22, 1.1, 2500, 01);
insert into zona (zonaID, portao, taxa, lugaresTotalZona, estadioID_zona) values (23, 23, 1.1, 2500, 01);
insert into zona (zonaID, portao, taxa, lugaresTotalZona, estadioID_zona) values (24, 24, 1.0, 2500, 01);


insert into utilizador (username, email, pass) values ("Ricardo Cruz", "rc@example.com", "1234");
insert into utilizador (username, email, pass) values ("Renato Junior", "rj@example.com", "123456");

insert into evento (nome, dia, precoBase) value ("Jogo de portugal", str_to_date('2019-12-25 12:00:00','%Y-%m-%d %H:%i:%s'), 10);




insert into evento_zona (eventoID_ev_zon, zonaID_ev_zon) values (01, 01);
insert into evento_zona (eventoID_ev_zon, zonaID_ev_zon) values (01, 02);
insert into evento_zona (eventoID_ev_zon, zonaID_ev_zon) values (01, 03);
insert into evento_zona (eventoID_ev_zon, zonaID_ev_zon) values (01, 04);
insert into evento_zona (eventoID_ev_zon, zonaID_ev_zon) values (01, 05);
insert into evento_zona (eventoID_ev_zon, zonaID_ev_zon) values (01, 06);
insert into evento_zona (eventoID_ev_zon, zonaID_ev_zon) values (01, 07);
insert into evento_zona (eventoID_ev_zon, zonaID_ev_zon) values (01, 08);
insert into evento_zona (eventoID_ev_zon, zonaID_ev_zon) values (01, 09);
insert into evento_zona (eventoID_ev_zon, zonaID_ev_zon) values (01, 10);
insert into evento_zona (eventoID_ev_zon, zonaID_ev_zon) values (01, 11);
insert into evento_zona (eventoID_ev_zon, zonaID_ev_zon) values (01, 12);
insert into evento_zona (eventoID_ev_zon, zonaID_ev_zon) values (01, 13);
insert into evento_zona (eventoID_ev_zon, zonaID_ev_zon) values (01, 14);
insert into evento_zona (eventoID_ev_zon, zonaID_ev_zon) values (01, 15);
insert into evento_zona (eventoID_ev_zon, zonaID_ev_zon) values (01, 16);
insert into evento_zona (eventoID_ev_zon, zonaID_ev_zon) values (01, 17);
insert into evento_zona (eventoID_ev_zon, zonaID_ev_zon) values (01, 18);
insert into evento_zona (eventoID_ev_zon, zonaID_ev_zon) values (01, 19);
insert into evento_zona (eventoID_ev_zon, zonaID_ev_zon) values (01, 20);
insert into evento_zona (eventoID_ev_zon, zonaID_ev_zon) values (01, 21);
insert into evento_zona (eventoID_ev_zon, zonaID_ev_zon) values (01, 22);
insert into evento_zona (eventoID_ev_zon, zonaID_ev_zon) values (01, 23);
insert into evento_zona (eventoID_ev_zon, zonaID_ev_zon) values (01, 24);



insert into bilhete (codigoBilhete, entrada, userID_bilhete, eventoZonaID_bilhete) values (010112354, 0, 01, 14);
insert into bilhete (codigoBilhete, entrada, userID_bilhete, eventoZonaID_bilhete) values (010112565, 0, 01, 08);
insert into bilhete (codigoBilhete, entrada, userID_bilhete, eventoZonaID_bilhete) values (010116549, 0, 01, 08);
insert into bilhete (codigoBilhete, entrada, userID_bilhete, eventoZonaID_bilhete) values (010135798, 0, 02, 14);
insert into bilhete (codigoBilhete, entrada, userID_bilhete, eventoZonaID_bilhete) values (010154565, 0, 02, 19);
insert into bilhete (codigoBilhete, entrada, userID_bilhete, eventoZonaID_bilhete) values (010168888, 0, 02, 08);


commit;