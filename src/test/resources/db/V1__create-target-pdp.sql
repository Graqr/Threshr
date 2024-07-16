CREATE TABLE public.target_pdp (
	tcin int8 NOT NULL,
	image_url text NOT NULL,
	pdp_url text NOT NULL,
	CONSTRAINT target_pdp_pkey PRIMARY KEY (tcin)
);