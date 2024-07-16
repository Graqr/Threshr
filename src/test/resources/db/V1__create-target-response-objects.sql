CREATE TABLE public.test_target_response_objects (
	id int8 NOT NULL,
	response_body json NOT NULL,
	endpoint text NOT NULL,
	CONSTRAINT test_target_response_objects_pkey PRIMARY KEY (id)
);