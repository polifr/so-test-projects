CREATE TABLE DTTKC_DAILY (
    sum_date timestamp,
    tree_id number,
    active_year varchar(10),
    is_corporate varchar(10),
    network_id varchar(10),
    district_number number,
    total_credit number
);

create table dm_tree_list (
    tree_id number,
    sum_date timestamp,
    linh_vuc varchar(10),
    cap2_sum varchar(10)
);

create table dm_area (
    district_number number,
    center varchar(10),
    province_code varchar(10),
    district_code varchar(10)
);

create table area_list (
    district_code varchar(10),
    branch_name varchar(10)
);
