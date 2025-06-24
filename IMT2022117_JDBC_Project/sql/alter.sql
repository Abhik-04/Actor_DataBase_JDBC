ALTER TABLE WORKS_ON
add constraint fk_ActorId FOREIGN KEY(ActorId)
REFERENCES ACTOR(ActorId);

ALTER TABLE WORKS_ON
add constraint fk_MovieId FOREIGN KEY(MovieId)
REFERENCES MOVIE(MovieId);

ALTER TABLE AWARDS_WON
add constraint fk_ActorId_awards_won FOREIGN KEY(ActorId)
REFERENCES ACTOR(ActorId);

ALTER TABLE AWARDS_WON
add constraint fk_AwardId FOREIGN KEY(AwardId)
REFERENCES AWARD(AwardId);

ALTER TABLE RELATIONSHIP
add constraint fk_relationship FOREIGN KEY(ActorId)
REFERENCES ACTOR(ActorId);