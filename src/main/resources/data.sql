-- data.sql

-- Seed data for status table
INSERT INTO public.status (status_id, status_code, status_name) VALUES
                                                                    (1, 'status04', 'Approved'),
                                                                    (2, 'status03', 'Ingestion In-Progress'),
                                                                    (3, 'status02', 'Triage Pending Approval'),
                                                                    (4, 'status01', 'Draft'),
                                                                    (5, 'status05', 'Ingestion Completed'),
                                                                    (6, 'status06', 'Ingestion Failure'),
                                                                    (7, 'status07', 'Rejected');

-- Seed data for application_reference_table
INSERT INTO public.application_reference_table
(reference_id, created_by, created_date, modified_by, modified_date, reference_data, reference_data_type, reference_group_type, reference_order) VALUES
                                                                                                                                                     (1, 'test@gmail.com', '2024-05-16 17:35:19.914', 'test@gmail.com', '2024-05-16 17:35:19.914', 'referenceData1', 'type', 'grpType1', 3),
                                                                                                                                                     (2, 'test@gmail.com', '2024-05-18 13:43:32.382', 'test@gmail.com', '2024-05-18 13:43:32.382', 'referenceData2', 'type', 'grpType2', 2),
                                                                                                                                                     (3, 'test@gmail.com', '2024-05-18 13:43:37.269', 'test@gmail.com', '2024-05-18 13:43:37.269', 'referenceData3', 'type', 'grpType3', 1);