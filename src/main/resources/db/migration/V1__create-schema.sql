CREATE TABLE generic_data (
  generic_id TEXT,
  id TEXT,
  PRIMARY KEY (id),
  FOREIGN KEY (generic_id) REFERENCES generic(id)
);

CREATE TABLE generic_data_product_summaries (
  generic_data_id TEXT,
  id TEXT,
  __typename TEXT,
  tcin TEXT,
  PRIMARY KEY (id),
  FOREIGN KEY (generic_data_id) REFERENCES generic_data(id)
);

CREATE TABLE generic_data_product_summaries_item (
  generic_data_product_summaries_id TEXT,
  id TEXT,
  is_limited_time_offer BOOLEAN,
  relationship_type_code TEXT,
  PRIMARY KEY (id),
  FOREIGN KEY (generic_data_product_summaries_id) REFERENCES generic_data_product_summaries(id)
);

CREATE TABLE generic_data_product_summaries_item_product_description (
  generic_data_product_summaries_item_id TEXT,
  id TEXT,
  title TEXT,
  PRIMARY KEY (id),
  FOREIGN KEY (generic_data_product_summaries_item_id) REFERENCES generic_data_product_summaries_item(id)
);

CREATE TABLE generic_data_product_summaries_item_enrichment (
  generic_data_product_summaries_item_id TEXT,
  id TEXT,
  buy_url TEXT,
  PRIMARY KEY (id),
  FOREIGN KEY (generic_data_product_summaries_item_id) REFERENCES generic_data_product_summaries_item(id)
);

CREATE TABLE generic_data_product_summaries_item_fulfillment (
  generic_data_product_summaries_item_id TEXT,
  id TEXT,
  PRIMARY KEY (id),
  FOREIGN KEY (generic_data_product_summaries_item_id) REFERENCES generic_data_product_summaries_item(id)
);

CREATE TABLE generic_data_product_summaries_item_merchandise_classification (
  generic_data_product_summaries_item_id TEXT,
  class_id INT,
  department_id INT,
  PRIMARY KEY (department_id),
  FOREIGN KEY (generic_data_product_summaries_item_id) REFERENCES generic_data_product_summaries_item(id)
);

CREATE TABLE generic_data_product_summaries_item_product_vendors (
  generic_data_product_summaries_item_id TEXT,
  id TEXT,
  PRIMARY KEY (id),
  FOREIGN KEY (generic_data_product_summaries_item_id) REFERENCES generic_data_product_summaries_item(id)
);

CREATE TABLE generic_data_product_summaries_item_eligibility_rules (
  generic_data_product_summaries_item_id TEXT,
  id TEXT,
  PRIMARY KEY (id),
  FOREIGN KEY (generic_data_product_summaries_item_id) REFERENCES generic_data_product_summaries_item(id)
);

CREATE TABLE generic_data_product_summaries_fulfillment (
  generic_data_product_summaries_id TEXT,
  product_id TEXT,
  is_out_of_stock_in_all_store_locations BOOLEAN,
  sold_out BOOLEAN,
  PRIMARY KEY (product_id),
  FOREIGN KEY (generic_data_product_summaries_id) REFERENCES generic_data_product_summaries(id)
);

CREATE TABLE generic_data_product_summaries_fulfillment_shipping_options (
  generic_data_product_summaries_fulfillment_product_id TEXT,
  id TEXT,
  availability_status TEXT,
  loyalty_availability_status TEXT,
  PRIMARY KEY (id),
  FOREIGN KEY (generic_data_product_summaries_fulfillment_id) REFERENCES generic_data_product_summaries_fulfillment(product_id)
);

CREATE TABLE generic_data_product_summaries_fulfillment_shipping_options_services (
  generic_data_product_summaries_fulfillment_shipping_options_id TEXT,
  shipping_method_id TEXT,
  min_delivery_date TEXT,
  max_delivery_date TEXT,
  is_two_day_shipping BOOLEAN,
  is_base_shipping_method BOOLEAN,
  PRIMARY KEY (shipping_method_id),
  FOREIGN KEY (generic_data_product_summaries_fulfillment_shipping_options_id) REFERENCES generic_data_product_summaries_fulfillment_shipping_options(id)
);

CREATE TABLE generic_data_product_summaries_fulfillment_store_options (
  generic_data_product_summaries_fulfillment_product_id TEXT,
  search_response_store_type TEXT,
  location_available_to_promise_quantity INT,
  location_id TEXT,
  PRIMARY KEY (location_id),
  FOREIGN KEY (generic_data_product_summaries_fulfillment_id) REFERENCES generic_data_product_summaries_fulfillment(product_id)
);

CREATE TABLE generic_data_product_summaries_fulfillment_store_options_store (
  generic_data_product_summaries_fulfillment_store_options_location_id TEXT,
  id TEXT,
  location_name TEXT,
  PRIMARY KEY (id),
  FOREIGN KEY (generic_data_product_summaries_fulfillment_store_options_id) REFERENCES generic_data_product_summaries_fulfillment_store_options(location_id)
);

CREATE TABLE generic_data_product_summaries_fulfillment_store_options_order_pickup (
  generic_data_product_summaries_fulfillment_store_options_location_id TEXT,
  id TEXT,
  availability_status TEXT,
  pickup_date TEXT,
  guest_pick_sla INT,
  location_locale TEXT,
  PRIMARY KEY (id),
  FOREIGN KEY (generic_data_product_summaries_fulfillment_store_options_id) REFERENCES generic_data_product_summaries_fulfillment_store_options(location_id)
);

CREATE TABLE generic_data_product_summaries_fulfillment_store_options_in_store_only (
  generic_data_product_summaries_fulfillment_store_options_location_id TEXT,
  id TEXT,
  availability_status TEXT,
  PRIMARY KEY (id),
  FOREIGN KEY (generic_data_product_summaries_fulfillment_store_options_id) REFERENCES generic_data_product_summaries_fulfillment_store_options(location_id)
);

CREATE TABLE generic_data_product_summaries_fulfillment_scheduled_delivery (
  generic_data_product_summaries_fulfillment_product_id TEXT,
  id TEXT,
  availability_status TEXT,
  location_available_to_promise_quantity INT,
  PRIMARY KEY (id),
  FOREIGN KEY (generic_data_product_summaries_fulfillment_id) REFERENCES generic_data_product_summaries_fulfillment(product_id)
);