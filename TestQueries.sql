INSERT INTO nurse(nurse_id, n_firstname, n_lastname, contact_no)
VALUES (1001, 'Emil', 'Castagnier', '+63 9638215147');

INSERT INTO nurse_shift(nurseShift_id, nurse_id, shift_day, start_time, end_time)
VALUES(2, 1001, 'Monday', '08:00', '20:00');	 

INSERT INTO patient(patient_id, p_lastname, p_firstname, contact_no)
VALUES (100, 'Mikasa', 'Ackerman', '+63 9163257790');

INSERT INTO patient(p_firstname, p_lastname, contact_no)
VALUES('Levi', 'Ackerman', '+63 9105633254'); 

INSERT INTO physician(physician_id, ph_firstname, ph_lastname, contact_no, specialization)
VALUES(2001, 'Maria', 'Santos', '+63 9171234567', 'Cardiology');

INSERT INTO physician_schedule(physicianSchedule_id, physician_id, schedule_day, start_time, end_time)
VALUES(3, 2001, 'Monday', '08:00', '20:00');

INSERT INTO illness(illness_id, illness_name, category, illness_description)
VALUES (3001, 'Coronary Artery Disease', 'Heart Disease', 'A condition caused by buildup of plaque in the arteries supplying blood to the heart');

INSERT INTO medicine(medicine_id, medicine_name, stock_qty)
VALUES(4001, 'Aspirin', 50);

INSERT INTO ward(ward_id, floor)
VALUES(501, '3rd Floor');

INSERT INTO diagnosis(diagnosis_id, patient_id, physicianSchedule_id, illness_id, diagnosis_date, notes)
VALUES(6001, 100, 3, 3001, '2025-09-11', 'Monitor patient closely');

INSERT INTO nurse_assignment(nurseAssignment_id, nurseShift_id, patient_id, date_assigned, assigned_until)
VALUES (7001, 2, 100, '2025-11-09', null);

INSERT INTO admission(admission_id, patient_id, ward_id, admission_date)
VALUES (8001, 100, 501, '2025-11-09');

INSERT INTO treatment(treatment_id, nurseAssignment_id, diagnosis_id, medicine_id, treatment_date, treatment_procedure, remarks)
VALUES (9001, 7001, 6001, 4001, '2025-11-09', 'Administered medicine', 'See if patient condition alleviates');

INSERT INTO discharge(discharge_id, admission_id, discharge_date)
VALUES (1, 8001, '2025-11-10');


# -------------
SELECT * FROM patient;
SELECT * FROM nurse;
SELECT * FROM physician;
SELECT * FROM ward;
SELECT * FROM illness;
SELECT * FROM medicine;
SELECT * FROM nurse_shift;
SELECT * FROM physician_schedule;
SELECT * FROM diagnosis;
SELECT * FROM nurse_assignment;
SELECT * FROM admission;
SELECT * FROM treatment;
SELECT * FROM discharge; 

DELETE FROM treatment WHERE treatment_id = 9001;
DELETE FROM discharge WHERE discharge_id = 3;
DELETE FROM admission WHERE admission_id = 8004;

INSERT INTO discharge(discharge_id, admission_id, discharge_date)
VALUES (3, 8002, '2025-11-11');

-- Test Queries --
DELETE FROM nurse WHERE nurse_id = 1001; #should fail (restrict) if nurse assignment exist == SUCCESS

DELETE FROM medicine WHERE medicine_id = 4001; #Should set medicine_id in treatment to NULL (set null) == SUCCESS

DELETE FROM admission WHERE admission_id = 8001; #Should also delete from discharge == SUCCESS

DELETE FROM physician WHERE physician_id = 2001; #Delete a physician still linked to a diagnosis (should RESTRICT) -- this should fail == SUCCESS

INSERT INTO nurse_assignment(nurseAssignment_id, nurseShift_id, patient_id, date_assigned, assigned_until)
VALUES (7002, 2, 100, '2025-11-09', null); #Should fail: same nurseShift_id + patient_id + date_assigned (unique constraint)

DELETE FROM diagnosis WHERE diagnosis_id = 6001; #Delete a diagnosis that is linked to treatment: Should fail because treatment references it (ON DELETE RESTRICT) == SUCCESS

DELETE FROM ward WHERE ward_id = 501; #Delete a ward that has admissions: Should fail (ON DELETE RESTRICT on admission) == SUCCESS

DELETE FROM nurse_shift WHERE nurseShift_id = 2; #Delete a nurse_shift linked to nurse_assignment: Should fail (ON DELETE RESTRICT on nurse_assignment). == SUCCESS

INSERT INTO treatment(nurseAssignment_id, diagnosis_id, treatment_date)
VALUES (9999, 6001, '2025-11-11');#Try inserting treatment with a nonexistent nurseAssignment_id: should fail == SUCCESS

INSERT INTO admission(patient_id, ward_id, admission_date)
VALUES (101, 501, '2025-11-10'); #inserting another patient on the same ward: should fail == SUCCESS

INSERT INTO nurse_assignment(nurseShift_id, patient_id, date_assigned, assigned_until)
VALUES (2, 101, '2025-11-10', null); #Assign the same nurse to different patients on the same shift (should succeed). == SUCCESS

SELECT a.admission_id, a.patient_id, a.ward_id, a.admission_date
FROM admission a
LEFT JOIN discharge d ON a.admission_id = d.admission_id
WHERE d.discharge_id IS NULL; #wala pang discharge == occupied ung ward


SELECT a.admission_id, a.patient_id, a.ward_id, a.admission_date
FROM admission a
LEFT JOIN discharge d ON a.admission_id = d.admission_id
WHERE a.ward_id != 501 AND d.discharge_id IS NULL; #we have to make sure ward_id !-= id when updating an admission record 

INSERT INTO discharge(admission_id, discharge_date)
VALUES (8001, "2025-11-10");

ALTER TABLE treatment
ADD assignedPhysician_id INT,
ADD CONSTRAINT fk_assignedPhysician
FOREIGN KEY (assignedPhysician_id) REFERENCES physician(physician_id) ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE treatment
ADD performed_by ENUM('Nurse', 'Diagnosing Physician', 'Assigned Physician');

ALTER TABLE treatment
DROP performed_by;	







