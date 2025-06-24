CREATE TABLE ACTOR(
    ActorId varchar(5),
    ActorName varchar(30),
    ActorPhone varchar(10),
    ActorAge int(3),
    constraint pk_actor PRIMARY KEY(ActorId)
);

CREATE TABLE MOVIE(
    MovieId varchar(5),
    MovieName varchar(30),
    Rating float(3, 2),
    Budget varchar(10),
    constraint pk_movie PRIMARY KEY(MovieId)
);

CREATE TABLE WORKS_ON(
    ActorId varchar(5),
    MovieId varchar(5),
    Hours float(10, 5),
    Pay varchar(10),
    constraint pk_works_on PRIMARY KEY(ActorId, MovieId)
);

CREATE TABLE AWARD(
    AwardId varchar(5),
    AwardName varchar(30),
    constraint pk_awards PRIMARY KEY(AwardId)
);

CREATE TABLE AWARDS_WON(
    ActorId varchar(5),
    AwardId varchar(5),
    TimesWon int(3),
    constraint pk_awards_won PRIMARY KEY(ActorId, AwardId)
);

CREATE TABLE RELATIONSHIP(
    ActorId varchar(5),
    RelationId varchar(5),
    RelationName varchar(30),
    RelationType varchar(10),
    constraint pk_spouse PRIMARY KEY(RelationId)
);