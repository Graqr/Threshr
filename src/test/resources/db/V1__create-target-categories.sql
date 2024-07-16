CREATE TABLE public.test_target_categories (
	id text NOT NULL,
	category_name text NOT NULL,
	CONSTRAINT test_target_categories_path_key UNIQUE (category_name),
	CONSTRAINT test_target_categories_pkey PRIMARY KEY (id, category_name)
);