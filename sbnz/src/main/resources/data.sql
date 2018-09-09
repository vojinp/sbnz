INSERT INTO user (id, first_name, last_name, username, password, authority) VALUES (0, 'doctor', 'doctor', 'doctor', 'doctor', 0)
INSERT INTO user (id, first_name, last_name, username, password, authority) VALUES (1, 'admin', 'admin', 'admin', 'admin', 1)
INSERT INTO user (id, first_name, last_name, username, password, authority) VALUES (2, 'doctor2', 'doctor2', 'doctor2', 'doctor2', 0)
INSERT INTO user (id, first_name, last_name, username, password, authority) VALUES (3, 'doctor3', 'doctor3', 'doctor3', 'doctor3', 0)

INSERT INTO disease (id, name, d_group) VALUES (0, 'Prehlada', 0)
INSERT INTO disease (id, name, d_group) VALUES (1, 'Groznica', 0)
INSERT INTO disease (id, name, d_group) VALUES (2, 'Upala krajnika', 0)
INSERT INTO disease (id, name, d_group) VALUES (3, 'Sinusna infekcija', 0)
INSERT INTO disease (id, name, d_group) VALUES (4, 'Hipertenzija', 1)
INSERT INTO disease (id, name, d_group) VALUES (5, 'Dijabetes', 1)
INSERT INTO disease (id, name, d_group) VALUES (6, 'Hronicna bubrezna bolest', 2)
INSERT INTO disease (id, name, d_group) VALUES (7, 'Akutna bubrezna povreda', 2)

INSERT INTO symptom (id, name, specific) VALUES (0, 'Curenje iz nosa', false)
INSERT INTO symptom (id, name, specific) VALUES (1, 'Bol u grlu', false)
INSERT INTO symptom (id, name, specific) VALUES (2, 'Glavobolja', false)
INSERT INTO symptom (id, name, specific) VALUES (3, 'Kijanje', false)
INSERT INTO symptom (id, name, specific) VALUES (4, 'Kasalj', false)
INSERT INTO symptom (id, name, specific) VALUES (5, 'Povisena temperatura', false)
INSERT INTO symptom (id, name, specific) VALUES (6, 'Drhtavica', false)
INSERT INTO symptom (id, name, specific) VALUES (7, 'Bol koji se siri do usiju', false)
-- INSERT INTO symptom (id, name, specific) VALUES (8, 'Temperatura od 40 do 41', false)
INSERT INTO symptom (id, name, specific) VALUES (9, 'Gubitak apetita', false)
INSERT INTO symptom (id, name, specific) VALUES (10, 'Umor', false)
INSERT INTO symptom (id, name, specific) VALUES (11, 'Zuti sekret iz nosa', false)
INSERT INTO symptom (id, name, specific) VALUES (12, 'Oticanje oko ociju', false)
INSERT INTO symptom (id, name, specific) VALUES (13, 'U poslednjih 6 meseci, barem 10 puta imao visok pritisak', false)
INSERT INTO symptom (id, name, specific) VALUES (14, 'Cesto uriniranje', false)
INSERT INTO symptom (id, name, specific) VALUES (15, 'Zamor', false)
INSERT INTO symptom (id, name, specific) VALUES (16, 'Gubitak telesne tezine', false)
INSERT INTO symptom (id, name, specific) VALUES (17, 'Povracanje', false)
INSERT INTO symptom (id, name, specific) VALUES (18, 'Nocturia', false)
INSERT INTO symptom (id, name, specific) VALUES (19, 'Oticanje nogu i zglobova', false)
INSERT INTO symptom (id, name, specific) VALUES (20, 'Gusenje', false)
INSERT INTO symptom (id, name, specific) VALUES (21, 'Bol u grudima', false)
INSERT INTO symptom (id, name, specific) VALUES (22, 'Dijareja', false)

INSERT INTO symptom (id, name, specific) VALUES (23, 'Pacijent boluje od hipertenzije vise od 6 meseci', true)
INSERT INTO symptom (id, name, specific) VALUES (24, 'Pacijent boluje od dijabetesa', true)
INSERT INTO symptom (id, name, specific) VALUES (25, 'Oporavlja se od operacije', true)
INSERT INTO symptom (id, name, specific) VALUES (26, 'U poslednjih 14 dana dijagnostikovana bolest koja kao simptom ima povissenu telesnu temperaturu', true)
INSERT INTO symptom (id, name, specific) VALUES (27, 'U poslednjih 21 dana dijagnostikovana bolest za koju je primao antibiotike', true)


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
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (2, 5)
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
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (7, 15)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (7, 20)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (7, 19)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (7, 22)

INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (6, 23)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (6, 24)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (7, 25)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (7, 26)
INSERT INTO disease_symptom (disease_id, symptom_id) VALUES (7, 27)

INSERT INTO patient (id, firstname, lastname, recovery) VALUES (0, 'patient', 'patient', false)
INSERT INTO patient (id, firstname, lastname, recovery) VALUES (1, 'patient1', 'patient1', false)

INSERT INTO medication(id, name, type) VALUES (0, 'analgesic', 1)
INSERT INTO medication(id, name, type) VALUES (1, 'antibiotic', 0)

INSERT INTO ingredient (id, name) VALUES (0, 'ingredient')

INSERT INTO medication_ingredient (medication_id, ingredient_id) VALUES (0, 0)

INSERT INTO patient_ingredient (patient_id, ingredient_id) VALUES (0, 0)

INSERT INTO diagnosis (id, date, disease_id, user_id, patient_id) VALUES (0, '2018-05-14 02:00:00.0', 3, 0, 0)
INSERT INTO diagnosis (id, date, disease_id, user_id, patient_id) VALUES (1, '2018-05-15 02:00:00.0', 4, 2, 0)
INSERT INTO diagnosis (id, date, disease_id, user_id, patient_id) VALUES (2, '2018-05-16 02:00:00.0', 3, 3, 0)
INSERT INTO diagnosis (id, date, disease_id, user_id, patient_id) VALUES (3, '2018-05-17 02:00:00.0', 3, 0, 0)
INSERT INTO diagnosis (id, date, disease_id, user_id, patient_id) VALUES (4, '2018-05-18 02:00:00.0', 3, 0, 0)
INSERT INTO diagnosis (id, date, disease_id, user_id, patient_id) VALUES (5, '2018-05-19 02:00:00.0', 3, 0, 0)
INSERT INTO diagnosis (id, date, disease_id, user_id, patient_id) VALUES (6, '2018-05-19 02:00:00.0', 3, 0, 0)
INSERT INTO diagnosis (id, date, disease_id, user_id, patient_id) VALUES (7, '2018-05-19 02:00:00.0', 3, 0, 0)
INSERT INTO diagnosis (id, date, disease_id, user_id, patient_id) VALUES (8, '2018-05-19 02:00:00.0', 3, 0, 0)
INSERT INTO diagnosis (id, date, disease_id, user_id, patient_id) VALUES (9, '2018-05-19 02:00:00.0', 3, 0, 0)
INSERT INTO diagnosis (id, date, disease_id, user_id, patient_id) VALUES (10, '2018-05-19 02:00:00.0', 3, 0, 0)

INSERT INTO diagnosis_medication(diagnosis_id, medication_id) VALUES (0, 1)
INSERT INTO diagnosis_medication(diagnosis_id, medication_id) VALUES (1, 1)
INSERT INTO diagnosis_medication(diagnosis_id, medication_id) VALUES (2, 1)
INSERT INTO diagnosis_medication(diagnosis_id, medication_id) VALUES (3, 1)
INSERT INTO diagnosis_medication(diagnosis_id, medication_id) VALUES (4, 1)
INSERT INTO diagnosis_medication(diagnosis_id, medication_id) VALUES (5, 1)
INSERT INTO diagnosis_medication(diagnosis_id, medication_id) VALUES (6, 1)
INSERT INTO diagnosis_medication(diagnosis_id, medication_id) VALUES (7, 1)
INSERT INTO diagnosis_medication(diagnosis_id, medication_id) VALUES (8, 1)
INSERT INTO diagnosis_medication(diagnosis_id, medication_id) VALUES (9, 1)
INSERT INTO diagnosis_medication(diagnosis_id, medication_id) VALUES (10, 1)


