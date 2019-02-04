create table inventory(
id varchar(64) not null primary key,
id_device varchar(64) not null,
id_device_category varchar(64) not null,
id_device_condition varchar(64) not null,
id_capacity_unit varchar(64) not null,
id_brand_category varchar(64) not null,
id_color varchar(64) not null,
id_loan varchar(64) not null
)engine=InnoDb;

alter table inventory
  add constraint fk_inventory_device foreign key (id_device)
    references device (id) on update cascade on delete restrict;

alter table inventory
  add constraint fk_inventory_device_category foreign key (id_device_category)
    references device_category (id) on update cascade on delete restrict;

alter table inventory
  add constraint fk_inventory_device_condition foreign key (id_device_condition)
    references device_condition (id) on update cascade on delete restrict;

    alter table inventory
  add constraint fk_inventory_capacity_unit foreign key (id_capacity_unit)
    references capacity_unit (id) on update cascade on delete restrict;

    alter table inventory
  add constraint fk_inventory_brand_category foreign key (id_brand_category)
    references brand_category (id) on update cascade on delete restrict;

    alter table inventory
  add constraint fk_inventory_color_category foreign key (id_color)
    references color_category (id) on update cascade on delete restrict;

    alter table inventory
  add constraint fk_inventory_loan_status foreign key (id_loan)
    references loan_status (id) on update cascade on delete restrict;
