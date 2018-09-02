INSERT INTO user (id, first_name, last_name, username, password, authority) VALUES (0, 'doctor', 'doctor', 'doctor', 'doctor', 0)
INSERT INTO user (id, first_name, last_name, username, password, authority) VALUES (1, 'admin', 'admin', 'admin', 'admin', 1)

INSERT INTO disease (id, name, d_group) VALUES (0, 'Prehlada', 0)
INSERT INTO disease (id, name, d_group) VALUES (1, 'Groznica', 0)
INSERT INTO disease (id, name, d_group) VALUES (2, 'Upala krajnika', 0)
INSERT INTO disease (id, name, d_group) VALUES (3, 'Sinusna infekcija', 0)
INSERT INTO disease (id, name, d_group) VALUES (4, 'Hipertenzija', 1)
INSERT INTO disease (id, name, d_group) VALUES (5, 'Dijabetes', 1)
INSERT INTO disease (id, name, d_group) VALUES (6, 'Hronicna bubrezna bolest', 2)
INSERT INTO disease (id, name, d_group) VALUES (7, 'Akutna bubrezna povreda', 2)

INSERT INTO symptom (id, name) VALUES (0, 'Curenje iz nosa')
INSERT INTO symptom (id, name) VALUES (1, 'Bol u grlu')
INSERT INTO symptom (id, name) VALUES (2, 'Glavobolja')
INSERT INTO symptom (id, name) VALUES (3, 'Kijanje')
INSERT INTO symptom (id, name) VALUES (4, 'Kasalj')
INSERT INTO symptom (id, name) VALUES (5, 'Temperatura veca od 38')
INSERT INTO symptom (id, name) VALUES (6, 'Drhtavica')
INSERT INTO symptom (id, name) VALUES (7, 'Bol koji se siri do usiju')
INSERT INTO symptom (id, name) VALUES (8, 'Temperatura od 40 do 41')
INSERT INTO symptom (id, name) VALUES (9, 'Gubitak apetita')
INSERT INTO symptom (id, name) VALUES (10, 'Umor')
INSERT INTO symptom (id, name) VALUES (11, 'Zuti sekret iz nosa')
INSERT INTO symptom (id, name) VALUES (12, 'Oticanje oko ociju')
INSERT INTO symptom (id, name) VALUES (13, 'U poslednjih 6 meseci, barem 10 puta imao visok pritisak')
INSERT INTO symptom (id, name) VALUES (14, 'Cesto uriniranje')
INSERT INTO symptom (id, name) VALUES (15, 'Zamor')
INSERT INTO symptom (id, name) VALUES (16, 'Gubitak telesne tezine')
INSERT INTO symptom (id, name) VALUES (17, 'Povracanje')
INSERT INTO symptom (id, name) VALUES (18, 'Nocturia')
INSERT INTO symptom (id, name) VALUES (19, 'Oticanje nogu i zglobova')
INSERT INTO symptom (id, name) VALUES (20, 'Gusenje')
INSERT INTO symptom (id, name) VALUES (21, 'Bol u grudima')
INSERT INTO symptom (id, name) VALUES (22, 'Dijareja')

INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (0, 0)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (0, 1)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (0, 2)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (0, 3)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (0, 4)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (1, 3)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (1, 1)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (1, 4)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (1, 5)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (1, 0)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (1, 2)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (1, 6)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (2, 1)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (2, 7)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (2, 8)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (2, 2)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (2, 6)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (2, 9)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (2, 10)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (2, 11)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (3, 12)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (3, 2)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (3, 11)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (3, 1)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (3, 5)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (3, 4)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (4, 13)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (5, 14)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (5, 15)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (5, 16)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (5, 17)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (6, 15)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (6, 18)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (6, 19)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (6, 20)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (6, 21)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (0, 15)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (0, 20)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (0, 21)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (0, 22)










