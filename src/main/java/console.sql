create database product_management;
use product_management;

create table Category(
    category_id int auto_increment primary key,
    category_name varchar(100) not null unique ,
    description text,
    status bit default (1)
);

create table Product(
    product_id int auto_increment primary key,
    product_name varchar(100) not null unique,
    description text,
    price double not null check ( price>0 ),
    image_url varchar(255),
    status bit default (1),
    created_at datetime default now(),
    category_id int not null,
    foreign key (category_id) references Category(category_id)
);

DELIMITER //
create procedure add_category(
    in p_category_name varchar(100),
    in p_description text,
    in p_status boolean
)
begin
    insert into Category (category_name, description, status)
    values (p_category_name, p_description, p_status);
end //
DELIMITER ;

# drop procedure add_category;

DELIMITER //
create procedure find_all_category()
begin
    select * from Category;
end //
DELIMITER ;

DELIMITER //
create procedure update_category(
    in p_category_id int,
    in p_category_name varchar(100),
    in p_description text,
    in p_status boolean
)
begin
    update Category
    set category_name = p_category_name,
        description = p_description,
        status = p_status
    where category_id = p_category_id;
end //
DELIMITER ;

DELIMITER //
create procedure delete_category(
    in p_category_id int
)
begin
    delete from Category where category_id = p_category_id;
end //
DELIMITER ;


DELIMITER //
create procedure find_category_by_id(
    in p_category_id int
)
begin
    select * from Category where category_id = p_category_id;
end //
DELIMITER ;

DELIMITER //
create procedure find_all_products()
begin
    select * from Product;
end //
DELIMITER ;


DELIMITER //
create procedure add_product(
    in p_product_name varchar(100),
    in p_description text,
    in p_price double,
    in p_image_url varchar(255),
    in p_status bit ,
    in p_category_id int
)
begin
    insert into Product (product_name, description, price, image_url, status, category_id)
    values (p_product_name, p_description, p_price, p_image_url,p_status, p_category_id);
end //
DELIMITER ;


# drop procedure add_product;

DELIMITER //
create procedure delete_product(
    product_id_in int
)
begin
    delete from Product where product_id = product_id_in;

end //
DELIMITER ;

# drop procedure delete_product;

DELIMITER //
create procedure update_product(
    id_in int,
    name_in varchar(255),
    des_in text,
    price_in double,
    url_in varchar(255),
    status_in bit
)
begin
    update Product
    set product_name = name_in,
        description = des_in,
        price = price_in,
        image_url = url_in,

        status = status_in

    where product_id = id_in;
end //
DELIMITER ;

DELIMITER //
create procedure find_product_by_id(
    id_in int
)
begin

        select * from Product where product_id = id_in;

end //
DELIMITER ;