CREATE TABLE public.target_stores (
	location_id int8 NOT NULL,
	location_name text NOT NULL,
	address_line_1 text NULL,
	city text NOT NULL,
	region text NOT NULL,
	postal_code text NOT NULL,
	latitude float8 DEFAULT '0'::double precision NOT NULL,
	longitude float8 DEFAULT '0'::double precision NOT NULL,
	is_active bool NOT NULL,
	is_test_location bool NULL,
	phone text NULL,
	obgb_enabled text NULL,
	CONSTRAINT target_stores_location_id_key UNIQUE (location_id),
	CONSTRAINT target_stores_pkey PRIMARY KEY (location_id)
);