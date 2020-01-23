create database bilheteira;
use bilheteira;

CREATE TABLE zona (
    zonaID INT NOT NULL,
    portao INT NOT NULL,
    taxa DOUBLE NOT NULL,
    lugaresTotalZona INT NOT NULL,
    estadioID_zona int not null,
    PRIMARY KEY (ZonaID)
);
                    
create table evento(eventoID int not null auto_increment,
					nome varchar(30),
                    dia varchar(30),						
                    precoBase double,
                    primary key (eventoID));

create table estadio(estadioID int not null,
                     imagemEstadio BLOB,
                     primary key (estadioID));

create table utilizador(userID int not null auto_increment,
						username varchar(30) not null,
                        email varchar(30) not null,
						pass varchar(30)  not null,
                        tempoConta timestamp default CURRENT_TIMESTAMP,
                        primary key (userID));
                        
create table bilhete (  codigoBilhete int not null auto_increment,
						codigoQr blob,
                        entrada tinyint,
                        tempoBilhete timestamp default CURRENT_TIMESTAMP,
						userID_bilhete int not null,
                        eventoZonaID_bilhete int not null,
						isDevolvido TINYINT NOT NULL DEFAULT '0',
                        primary key (codigoBilhete));
					
create table evento_zona(eventoZonaID int not null auto_increment,
						eventoID_ev_zon int not null,
						zonaID_ev_zon int not null,
                        isIndisponivel TINYINT NOT NULL DEFAULT '0',
						primary key (eventoZonaID));

	alter table zona add constraint zona_estadio
	foreign key (estadioID_zona) references estadio(estadioID)
    ON DELETE NO ACTION ON UPDATE NO ACTION;
    
	alter table bilhete add constraint bilhete_utilizador
	foreign key (userID_bilhete) references utilizador(userID)
    ON DELETE NO ACTION ON UPDATE NO ACTION;
    
	alter table bilhete add constraint bilhete_evento
	foreign key (eventoZonaID_bilhete) references evento_zona(eventoZonaID)
    ON DELETE NO ACTION ON UPDATE NO ACTION;
    
	alter table evento_zona add constraint evento_bilhete_zon
	foreign key (zonaID_ev_zon) references zona(zonaID)
    ON DELETE NO ACTION ON UPDATE NO ACTION;
